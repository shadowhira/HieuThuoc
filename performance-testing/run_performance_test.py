#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Script kiểm thử hiệu năng cho chức năng thống kê báo cáo doanh thu
Tạo file CSV ghi lại kết quả kiểm thử
"""

import requests
import time
import csv
import json
import statistics
from datetime import datetime
from concurrent.futures import ThreadPoolExecutor, as_completed
import threading

class RevenueReportPerformanceTest:
    def __init__(self, base_url="http://localhost:8080"):
        self.base_url = base_url
        self.results = []
        self.lock = threading.Lock()
        
    def test_api_endpoint(self, endpoint, params=None, test_name=""):
        """Kiểm thử một API endpoint và đo thời gian phản hồi"""
        url = f"{self.base_url}{endpoint}"
        
        start_time = time.time()
        try:
            response = requests.get(url, params=params, timeout=30)
            end_time = time.time()
            
            response_time = (end_time - start_time) * 1000  # Chuyển sang milliseconds
            
            result = {
                'test_name': test_name,
                'endpoint': endpoint,
                'url': url,
                'params': params,
                'status_code': response.status_code,
                'response_time_ms': response_time,
                'response_size_bytes': len(response.content),
                'success': response.status_code == 200,
                'timestamp': datetime.now().isoformat(),
                'error': None
            }
            
            if response.status_code != 200:
                result['error'] = f"HTTP {response.status_code}: {response.text}"
                
        except requests.exceptions.Timeout:
            end_time = time.time()
            response_time = (end_time - start_time) * 1000
            result = {
                'test_name': test_name,
                'endpoint': endpoint,
                'url': url,
                'params': params,
                'status_code': None,
                'response_time_ms': response_time,
                'response_size_bytes': 0,
                'success': False,
                'timestamp': datetime.now().isoformat(),
                'error': 'Timeout'
            }
        except Exception as e:
            end_time = time.time()
            response_time = (end_time - start_time) * 1000
            result = {
                'test_name': test_name,
                'endpoint': endpoint,
                'url': url,
                'params': params,
                'status_code': None,
                'response_time_ms': response_time,
                'response_size_bytes': 0,
                'success': False,
                'timestamp': datetime.now().isoformat(),
                'error': str(e)
            }
        
        with self.lock:
            self.results.append(result)
        
        return result
    
    def run_single_test(self, test_config):
        """Chạy một test đơn lẻ"""
        return self.test_api_endpoint(
            endpoint=test_config['endpoint'],
            params=test_config.get('params'),
            test_name=test_config['name']
        )
    
    def run_performance_test(self, num_threads=10, iterations_per_thread=5):
        """Chạy kiểm thử hiệu năng với nhiều thread"""
        print(f"Bắt đầu kiểm thử hiệu năng với {num_threads} threads, {iterations_per_thread} lần lặp mỗi thread")
        
        # Định nghĩa các test cases
        test_cases = [
            {
                'name': 'Doanh Thu Theo Ngay',
                'endpoint': '/baocao/doanhthutheongay',
                'params': {'ngay': '2024-12-19'}
            },
            {
                'name': 'Doanh Thu Theo Thang',
                'endpoint': '/baocao/doanhthutheothang',
                'params': {'nam': 2024, 'thang': 12}
            },
            {
                'name': 'Doanh Thu Theo Nam',
                'endpoint': '/baocao/doanhthutheonam',
                'params': {'nam': 2024}
            }
        ]
        
        # Tạo danh sách tất cả các test cần chạy
        all_tests = []
        for _ in range(iterations_per_thread):
            for test_case in test_cases:
                all_tests.append(test_case)
        
        # Chạy tests với ThreadPoolExecutor
        with ThreadPoolExecutor(max_workers=num_threads) as executor:
            futures = [executor.submit(self.run_single_test, test) for test in all_tests]
            
            completed = 0
            total = len(futures)
            
            for future in as_completed(futures):
                completed += 1
                if completed % 10 == 0:
                    print(f"Đã hoàn thành {completed}/{total} tests")
        
        print("Hoàn thành kiểm thử hiệu năng!")
    
    def generate_summary_report(self):
        """Tạo báo cáo tổng hợp"""
        if not self.results:
            return None
        
        # Nhóm kết quả theo test name
        test_groups = {}
        for result in self.results:
            test_name = result['test_name']
            if test_name not in test_groups:
                test_groups[test_name] = []
            test_groups[test_name].append(result)
        
        summary = {}
        for test_name, results in test_groups.items():
            response_times = [r['response_time_ms'] for r in results if r['success']]
            success_count = sum(1 for r in results if r['success'])
            total_count = len(results)
            
            if response_times:
                summary[test_name] = {
                    'total_requests': total_count,
                    'successful_requests': success_count,
                    'failed_requests': total_count - success_count,
                    'success_rate': (success_count / total_count) * 100,
                    'min_response_time': min(response_times),
                    'max_response_time': max(response_times),
                    'avg_response_time': statistics.mean(response_times),
                    'median_response_time': statistics.median(response_times),
                    'std_deviation': statistics.stdev(response_times) if len(response_times) > 1 else 0,
                    'p95_response_time': sorted(response_times)[int(len(response_times) * 0.95)],
                    'p99_response_time': sorted(response_times)[int(len(response_times) * 0.99)]
                }
            else:
                summary[test_name] = {
                    'total_requests': total_count,
                    'successful_requests': 0,
                    'failed_requests': total_count,
                    'success_rate': 0,
                    'min_response_time': 0,
                    'max_response_time': 0,
                    'avg_response_time': 0,
                    'median_response_time': 0,
                    'std_deviation': 0,
                    'p95_response_time': 0,
                    'p99_response_time': 0
                }
        
        return summary
    
    def save_results_to_csv(self, filename=None):
        """Lưu kết quả chi tiết vào file CSV"""
        if filename is None:
            timestamp = datetime.now().strftime("%Y%m%d_%H%M%S")
            filename = f"revenue_report_performance_test_{timestamp}.csv"
        
        with open(filename, 'w', newline='', encoding='utf-8') as csvfile:
            fieldnames = [
                'test_name', 'endpoint', 'url', 'params', 'status_code',
                'response_time_ms', 'response_size_bytes', 'success',
                'timestamp', 'error'
            ]
            writer = csv.DictWriter(csvfile, fieldnames=fieldnames)
            writer.writeheader()
            writer.writerows(self.results)
        
        print(f"Đã lưu kết quả chi tiết vào file: {filename}")
        return filename
    
    def save_summary_to_csv(self, filename=None):
        """Lưu báo cáo tổng hợp vào file CSV"""
        summary = self.generate_summary_report()
        if not summary:
            print("Không có dữ liệu để tạo báo cáo tổng hợp")
            return None
        
        if filename is None:
            timestamp = datetime.now().strftime("%Y%m%d_%H%M%S")
            filename = f"revenue_report_summary_{timestamp}.csv"
        
        with open(filename, 'w', newline='', encoding='utf-8') as csvfile:
            fieldnames = [
                'test_name', 'total_requests', 'successful_requests', 'failed_requests',
                'success_rate', 'min_response_time', 'max_response_time', 'avg_response_time',
                'median_response_time', 'std_deviation', 'p95_response_time', 'p99_response_time'
            ]
            writer = csv.DictWriter(csvfile, fieldnames=fieldnames)
            writer.writeheader()
            
            for test_name, data in summary.items():
                row = {'test_name': test_name, **data}
                writer.writerow(row)
        
        print(f"Đã lưu báo cáo tổng hợp vào file: {filename}")
        return filename
    
    def print_summary(self):
        """In báo cáo tổng hợp ra console"""
        summary = self.generate_summary_report()
        if not summary:
            print("Không có dữ liệu để hiển thị")
            return
        
        print("\n" + "="*80)
        print("BÁO CÁO KIỂM THỬ HIỆU NĂNG CHỨC NĂNG BÁO CÁO DOANH THU")
        print("="*80)
        
        for test_name, data in summary.items():
            print(f"\n{test_name}:")
            print(f"  Tổng số request: {data['total_requests']}")
            print(f"  Request thành công: {data['successful_requests']}")
            print(f"  Request thất bại: {data['failed_requests']}")
            print(f"  Tỷ lệ thành công: {data['success_rate']:.2f}%")
            print(f"  Thời gian phản hồi (ms):")
            print(f"    - Tối thiểu: {data['min_response_time']:.2f}")
            print(f"    - Tối đa: {data['max_response_time']:.2f}")
            print(f"    - Trung bình: {data['avg_response_time']:.2f}")
            print(f"    - Trung vị: {data['median_response_time']:.2f}")
            print(f"    - Độ lệch chuẩn: {data['std_deviation']:.2f}")
            print(f"    - P95: {data['p95_response_time']:.2f}")
            print(f"    - P99: {data['p99_response_time']:.2f}")

def main():
    """Hàm main để chạy kiểm thử"""
    print("Bắt đầu kiểm thử hiệu năng chức năng thống kê báo cáo doanh thu")
    print("="*60)
    
    # Khởi tạo tester
    tester = RevenueReportPerformanceTest()
    
    # Chạy kiểm thử hiệu năng
    tester.run_performance_test(num_threads=20, iterations_per_thread=10)
    
    # In báo cáo tổng hợp
    tester.print_summary()
    
    # Lưu kết quả vào file CSV
    detail_file = tester.save_results_to_csv()
    summary_file = tester.save_summary_to_csv()
    
    print(f"\nKết quả kiểm thử đã được lưu vào:")
    print(f"- File chi tiết: {detail_file}")
    print(f"- File tổng hợp: {summary_file}")
    
    # Kiểm tra hiệu năng
    summary = tester.generate_summary_report()
    if summary:
        print("\nĐÁNH GIÁ HIỆU NĂNG:")
        print("-" * 40)
        
        for test_name, data in summary.items():
            avg_time = data['avg_response_time']
            success_rate = data['success_rate']
            
            print(f"{test_name}:")
            if success_rate < 95:
                print(f"  ⚠️  Tỷ lệ thành công thấp: {success_rate:.2f}%")
            else:
                print(f"  ✅ Tỷ lệ thành công tốt: {success_rate:.2f}%")
            
            if avg_time > 5000:
                print(f"  ⚠️  Thời gian phản hồi chậm: {avg_time:.2f}ms")
            elif avg_time > 2000:
                print(f"  ⚠️  Thời gian phản hồi trung bình: {avg_time:.2f}ms")
            else:
                print(f"  ✅ Thời gian phản hồi tốt: {avg_time:.2f}ms")

if __name__ == "__main__":
    main() 