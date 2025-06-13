#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Script kiểm thử hiệu năng cho các API báo cáo doanh thu
Frontend chạy trên cổng 4200
"""

import requests
import time
import threading
import csv
import json
from datetime import datetime
from concurrent.futures import ThreadPoolExecutor, as_completed
import statistics

class PerformanceTester:
    def __init__(self, base_url="http://localhost:4200"):
        self.base_url = base_url
        self.results = []
        
    def test_api_endpoint(self, endpoint, params=None, timeout=30):
        """Test một API endpoint và trả về kết quả"""
        url = f"{self.base_url}{endpoint}"
        start_time = time.time()
        
        try:
            response = requests.get(url, params=params, timeout=timeout)
            end_time = time.time()
            response_time = (end_time - start_time) * 1000  # Convert to milliseconds
            
            return {
                'url': url,
                'status_code': response.status_code,
                'response_time': response_time,
                'success': response.status_code == 200,
                'data_size': len(response.content),
                'error': None
            }
        except requests.exceptions.Timeout:
            end_time = time.time()
            response_time = (end_time - start_time) * 1000
            return {
                'url': url,
                'status_code': 408,
                'response_time': response_time,
                'success': False,
                'data_size': 0,
                'error': 'Timeout'
            }
        except requests.exceptions.ConnectionError:
            end_time = time.time()
            response_time = (end_time - start_time) * 1000
            return {
                'url': url,
                'status_code': 0,
                'response_time': response_time,
                'success': False,
                'data_size': 0,
                'error': 'Connection Error'
            }
        except Exception as e:
            end_time = time.time()
            response_time = (end_time - start_time) * 1000
            return {
                'url': url,
                'status_code': 500,
                'response_time': response_time,
                'success': False,
                'data_size': 0,
                'error': str(e)
            }
    
    def run_load_test(self, endpoint, params=None, num_requests=10, num_threads=5, timeout=30):
        """Chạy load test với số lượng request và thread cụ thể"""
        print(f"Chạy load test cho {endpoint} với {num_requests} requests, {num_threads} threads")
        
        results = []
        with ThreadPoolExecutor(max_workers=num_threads) as executor:
            futures = []
            for _ in range(num_requests):
                future = executor.submit(self.test_api_endpoint, endpoint, params, timeout)
                futures.append(future)
            
            for future in as_completed(futures):
                result = future.result()
                results.append(result)
        
        return results
    
    def analyze_results(self, results):
        """Phân tích kết quả test"""
        if not results:
            return None
            
        response_times = [r['response_time'] for r in results]
        success_count = sum(1 for r in results if r['success'])
        total_count = len(results)
        success_rate = (success_count / total_count) * 100 if total_count > 0 else 0
        
        return {
            'total_requests': total_count,
            'successful_requests': success_count,
            'success_rate': success_rate,
            'avg_response_time': statistics.mean(response_times),
            'min_response_time': min(response_times),
            'max_response_time': max(response_times),
            'median_response_time': statistics.median(response_times),
            'avg_data_size': statistics.mean([r['data_size'] for r in results]),
            'errors': [r['error'] for r in results if r['error']]
        }
    
    def run_all_tests(self):
        """Chạy tất cả các test case"""
        test_cases = [
            # Test cases với tải nhẹ
            {
                'id': 'PERF-TK-001',
                'description': 'Kiểm tra hiệu năng API báo cáo doanh thu theo ngày với tải nhẹ',
                'endpoint': '/baocao/doanhthutheongay',
                'params': {'ngay': '2024-12-19'},
                'num_requests': 10,
                'num_threads': 5,
                'expected_time': 2000
            },
            {
                'id': 'PERF-TK-002',
                'description': 'Kiểm tra hiệu năng API báo cáo doanh thu theo tháng với tải nhẹ',
                'endpoint': '/baocao/doanhthutheothang',
                'params': {'nam': '2024', 'thang': '12'},
                'num_requests': 10,
                'num_threads': 5,
                'expected_time': 2000
            },
            {
                'id': 'PERF-TK-003',
                'description': 'Kiểm tra hiệu năng API báo cáo doanh thu theo năm với tải nhẹ',
                'endpoint': '/baocao/doanhthutheonam',
                'params': {'nam': '2024'},
                'num_requests': 10,
                'num_threads': 5,
                'expected_time': 2000
            },
            # Test cases với tải trung bình
            {
                'id': 'PERF-TK-004',
                'description': 'Kiểm tra hiệu năng API báo cáo doanh thu theo ngày với tải trung bình',
                'endpoint': '/baocao/doanhthutheongay',
                'params': {'ngay': '2024-12-19'},
                'num_requests': 50,
                'num_threads': 20,
                'expected_time': 3000
            },
            {
                'id': 'PERF-TK-005',
                'description': 'Kiểm tra hiệu năng API báo cáo doanh thu theo tháng với tải trung bình',
                'endpoint': '/baocao/doanhthutheothang',
                'params': {'nam': '2024', 'thang': '12'},
                'num_requests': 50,
                'num_threads': 20,
                'expected_time': 3000
            },
            {
                'id': 'PERF-TK-006',
                'description': 'Kiểm tra hiệu năng API báo cáo doanh thu theo năm với tải trung bình',
                'endpoint': '/baocao/doanhthutheonam',
                'params': {'nam': '2024'},
                'num_requests': 50,
                'num_threads': 20,
                'expected_time': 3000
            },
            # Test cases với dữ liệu rỗng
            {
                'id': 'PERF-TK-013',
                'description': 'Kiểm tra hiệu năng API báo cáo doanh thu theo ngày với dữ liệu rỗng',
                'endpoint': '/baocao/doanhthutheongay',
                'params': {'ngay': '2020-01-01'},
                'num_requests': 10,
                'num_threads': 5,
                'expected_time': 1000
            },
            {
                'id': 'PERF-TK-014',
                'description': 'Kiểm tra hiệu năng API báo cáo doanh thu theo tháng với dữ liệu rỗng',
                'endpoint': '/baocao/doanhthutheothang',
                'params': {'nam': '2020', 'thang': '1'},
                'num_requests': 10,
                'num_threads': 5,
                'expected_time': 1000
            },
            {
                'id': 'PERF-TK-015',
                'description': 'Kiểm tra hiệu năng API báo cáo doanh thu theo năm với dữ liệu rỗng',
                'endpoint': '/baocao/doanhthutheonam',
                'params': {'nam': '2020'},
                'num_requests': 10,
                'num_threads': 5,
                'expected_time': 1000
            }
        ]
        
        all_results = []
        
        for test_case in test_cases:
            print(f"\n{'='*60}")
            print(f"Chạy test case: {test_case['id']}")
            print(f"Mô tả: {test_case['description']}")
            print(f"Endpoint: {test_case['endpoint']}")
            print(f"Tham số: {test_case['params']}")
            print(f"Số request: {test_case['num_requests']}")
            print(f"Số thread: {test_case['num_threads']}")
            print(f"{'='*60}")
            
            # Chạy test
            start_time = time.time()
            results = self.run_load_test(
                test_case['endpoint'],
                test_case['params'],
                test_case['num_requests'],
                test_case['num_threads']
            )
            end_time = time.time()
            
            # Phân tích kết quả
            analysis = self.analyze_results(results)
            
            if analysis:
                # Xác định trạng thái
                status = 'Passed'
                if analysis['success_rate'] < 95:
                    status = 'Failed'
                elif analysis['avg_response_time'] > test_case['expected_time']:
                    status = 'Failed'
                
                # Tạo kết quả chi tiết
                result_detail = f"Tổng request: {analysis['total_requests']}, Thành công: {analysis['successful_requests']}, Tỷ lệ thành công: {analysis['success_rate']:.2f}%. Thời gian phản hồi trung bình: {analysis['avg_response_time']:.2f}ms. Kích thước dữ liệu trung bình: {analysis['avg_data_size']:.0f} bytes."
                
                if analysis['errors']:
                    result_detail += f" Lỗi: {', '.join(set(analysis['errors']))}"
                
                test_result = {
                    'id': test_case['id'],
                    'description': test_case['description'],
                    'endpoint': test_case['endpoint'],
                    'params': test_case['params'],
                    'num_requests': test_case['num_requests'],
                    'num_threads': test_case['num_threads'],
                    'execution_time': (end_time - start_time) * 1000,
                    'avg_response_time': analysis['avg_response_time'],
                    'data_size': analysis['avg_data_size'],
                    'success_rate': analysis['success_rate'],
                    'status': status,
                    'result_detail': result_detail,
                    'errors': analysis['errors']
                }
                
                all_results.append(test_result)
                
                print(f"Kết quả: {status}")
                print(f"Thời gian thực hiện: {test_result['execution_time']:.2f}ms")
                print(f"Thời gian phản hồi trung bình: {analysis['avg_response_time']:.2f}ms")
                print(f"Tỷ lệ thành công: {analysis['success_rate']:.2f}%")
                print(f"Kích thước dữ liệu trung bình: {analysis['avg_data_size']:.0f} bytes")
                if analysis['errors']:
                    print(f"Lỗi: {', '.join(set(analysis['errors']))}")
            else:
                print("Không có kết quả để phân tích")
        
        return all_results
    
    def update_csv_file(self, results, csv_file='ket-qua-kiem-thu-hieu-nang-bao-cao-doanh-thu.csv'):
        """Cập nhật file CSV với kết quả test"""
        # Đọc file CSV hiện tại
        rows = []
        with open(csv_file, 'r', encoding='utf-8') as file:
            reader = csv.reader(file)
            rows = list(reader)
        
        # Cập nhật kết quả
        for result in results:
            for i, row in enumerate(rows):
                if len(row) > 0 and row[0] == result['id']:
                    # Cập nhật các cột tương ứng
                    if len(row) >= 8:
                        row[5] = result['result_detail']  # Kết quả thực tế
                        row[7] = result['status']  # Trạng thái
                    if len(row) >= 9:
                        row[8] = f"{result['execution_time']:.2f}"  # Thời gian thực hiện
                    if len(row) >= 10:
                        row[9] = f"{result['avg_response_time']:.2f}"  # Thời gian phản hồi
                    if len(row) >= 11:
                        row[10] = f"{result['data_size']:.0f}"  # Kích thước dữ liệu
                    if len(row) >= 12:
                        row[11] = f"{result['success_rate']:.2f}"  # Tỷ lệ thành công
                    if len(row) >= 13:
                        row[12] = f"Test chạy lúc {datetime.now().strftime('%Y-%m-%d %H:%M:%S')}"  # Ghi chú
                    break
        
        # Cập nhật thống kê
        passed_count = sum(1 for r in results if r['status'] == 'Passed')
        failed_count = sum(1 for r in results if r['status'] == 'Failed')
        total_count = len(results)
        
        for i, row in enumerate(rows):
            if len(row) > 1 and row[1] == 'Pass':
                row[2] = str(passed_count)
            elif len(row) > 1 and row[1] == 'Fail':
                row[2] = str(failed_count)
            elif len(row) > 1 and row[1] == 'Tổng số test case':
                row[2] = str(total_count)
        
        # Ghi lại file CSV
        with open(csv_file, 'w', newline='', encoding='utf-8') as file:
            writer = csv.writer(file)
            writer.writerows(rows)
        
        print(f"\nĐã cập nhật file CSV: {csv_file}")
        print(f"Tổng số test case: {total_count}")
        print(f"Passed: {passed_count}")
        print(f"Failed: {failed_count}")

def main():
    print("Bắt đầu kiểm thử hiệu năng cho các API báo cáo doanh thu")
    print(f"Frontend URL: http://localhost:4200")
    print(f"Thời gian bắt đầu: {datetime.now().strftime('%Y-%m-%d %H:%M:%S')}")
    
    # Kiểm tra kết nối
    try:
        response = requests.get("http://localhost:4200", timeout=5)
        print(f"Kết nối thành công đến frontend (Status: {response.status_code})")
    except Exception as e:
        print(f"Không thể kết nối đến frontend: {e}")
        print("Vẫn tiếp tục chạy test để kiểm tra...")
    
    # Tạo tester và chạy test
    tester = PerformanceTester("http://localhost:4200")
    results = tester.run_all_tests()
    
    # Cập nhật file CSV
    if results:
        tester.update_csv_file(results)
        
        # In báo cáo tóm tắt
        print(f"\n{'='*60}")
        print("BÁO CÁO TÓM TẮT KIỂM THỬ HIỆU NĂNG")
        print(f"{'='*60}")
        print(f"Tổng số test case: {len(results)}")
        print(f"Passed: {sum(1 for r in results if r['status'] == 'Passed')}")
        print(f"Failed: {sum(1 for r in results if r['status'] == 'Failed')}")
        
        print(f"\nChi tiết từng test case:")
        for result in results:
            print(f"{result['id']}: {result['status']} - {result['avg_response_time']:.2f}ms - {result['success_rate']:.2f}%")
    
    print(f"\nThời gian kết thúc: {datetime.now().strftime('%Y-%m-%d %H:%M:%S')}")

if __name__ == "__main__":
    main() 