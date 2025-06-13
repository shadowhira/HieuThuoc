#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Script chạy kiểm thử hiệu năng thực tế cho các API báo cáo doanh thu
Sử dụng khi có API endpoints đúng
"""

import requests
import time
import csv
from datetime import datetime
from concurrent.futures import ThreadPoolExecutor, as_completed
import statistics

class RealPerformanceTester:
    def __init__(self, frontend_url="http://localhost:4200", backend_url="http://localhost:8080"):
        self.frontend_url = frontend_url
        self.backend_url = backend_url
        self.results = []
        
    def test_api_endpoint(self, url, params=None, timeout=30):
        """Test một API endpoint và trả về kết quả"""
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
    
    def run_load_test(self, url, params=None, num_requests=10, num_threads=5, timeout=30):
        """Chạy load test với số lượng request và thread cụ thể"""
        print(f"Chạy load test cho {url} với {num_requests} requests, {num_threads} threads")
        
        results = []
        with ThreadPoolExecutor(max_workers=num_threads) as executor:
            futures = []
            for _ in range(num_requests):
                future = executor.submit(self.test_api_endpoint, url, params, timeout)
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
    
    def discover_api_endpoints(self):
        """Tìm kiếm các API endpoints có sẵn"""
        print("Tìm kiếm các API endpoints có sẵn...")
        
        # Danh sách các endpoints có thể có
        possible_endpoints = [
            # Frontend endpoints
            f"{self.frontend_url}/baocao/doanhthutheongay",
            f"{self.frontend_url}/baocao/doanhthutheothang", 
            f"{self.frontend_url}/baocao/doanhthutheonam",
            f"{self.frontend_url}/api/baocao/doanhthutheongay",
            f"{self.frontend_url}/api/baocao/doanhthutheothang",
            f"{self.frontend_url}/api/baocao/doanhthutheonam",
            f"{self.frontend_url}/thongke/doanhthutheongay",
            f"{self.frontend_url}/thongke/doanhthutheothang",
            f"{self.frontend_url}/thongke/doanhthutheonam",
            f"{self.frontend_url}/api/thongke/doanhthutheongay",
            f"{self.frontend_url}/api/thongke/doanhthutheothang",
            f"{self.frontend_url}/api/thongke/doanhthutheonam",
            
            # Backend endpoints
            f"{self.backend_url}/baocao/doanhthutheongay",
            f"{self.backend_url}/baocao/doanhthutheothang",
            f"{self.backend_url}/baocao/doanhthutheonam",
            f"{self.backend_url}/api/baocao/doanhthutheongay",
            f"{self.backend_url}/api/baocao/doanhthutheothang",
            f"{self.backend_url}/api/baocao/doanhthutheonam",
            f"{self.backend_url}/thongke/doanhthutheongay",
            f"{self.backend_url}/thongke/doanhthutheothang",
            f"{self.backend_url}/thongke/doanhthutheonam",
            f"{self.backend_url}/api/thongke/doanhthutheongay",
            f"{self.backend_url}/api/thongke/doanhthutheothang",
            f"{self.backend_url}/api/thongke/doanhthutheonam",
        ]
        
        working_endpoints = []
        
        for endpoint in possible_endpoints:
            try:
                response = requests.get(endpoint, timeout=5)
                if response.status_code == 200:
                    working_endpoints.append(endpoint)
                    print(f"✓ Tìm thấy endpoint: {endpoint}")
                elif response.status_code != 404:
                    print(f"? Endpoint có phản hồi khác 404: {endpoint} (Status: {response.status_code})")
            except:
                pass
        
        return working_endpoints
    
    def run_performance_tests(self, endpoints):
        """Chạy kiểm thử hiệu năng cho các endpoints có sẵn"""
        test_cases = []
        
        for endpoint in endpoints:
            if 'doanhthutheongay' in endpoint:
                test_cases.extend([
                    {
                        'id': f'PERF-TK-REAL-{len(test_cases)+1:03d}',
                        'description': f'Kiểm tra hiệu năng API báo cáo doanh thu theo ngày (tải nhẹ)',
                        'endpoint': endpoint,
                        'params': {'ngay': '2024-12-19'},
                        'num_requests': 10,
                        'num_threads': 5,
                        'expected_time': 2000
                    },
                    {
                        'id': f'PERF-TK-REAL-{len(test_cases)+1:03d}',
                        'description': f'Kiểm tra hiệu năng API báo cáo doanh thu theo ngày (tải trung bình)',
                        'endpoint': endpoint,
                        'params': {'ngay': '2024-12-19'},
                        'num_requests': 50,
                        'num_threads': 20,
                        'expected_time': 3000
                    }
                ])
            elif 'doanhthutheothang' in endpoint:
                test_cases.extend([
                    {
                        'id': f'PERF-TK-REAL-{len(test_cases)+1:03d}',
                        'description': f'Kiểm tra hiệu năng API báo cáo doanh thu theo tháng (tải nhẹ)',
                        'endpoint': endpoint,
                        'params': {'nam': '2024', 'thang': '12'},
                        'num_requests': 10,
                        'num_threads': 5,
                        'expected_time': 2000
                    },
                    {
                        'id': f'PERF-TK-REAL-{len(test_cases)+1:03d}',
                        'description': f'Kiểm tra hiệu năng API báo cáo doanh thu theo tháng (tải trung bình)',
                        'endpoint': endpoint,
                        'params': {'nam': '2024', 'thang': '12'},
                        'num_requests': 50,
                        'num_threads': 20,
                        'expected_time': 3000
                    }
                ])
            elif 'doanhthutheonam' in endpoint:
                test_cases.extend([
                    {
                        'id': f'PERF-TK-REAL-{len(test_cases)+1:03d}',
                        'description': f'Kiểm tra hiệu năng API báo cáo doanh thu theo năm (tải nhẹ)',
                        'endpoint': endpoint,
                        'params': {'nam': '2024'},
                        'num_requests': 10,
                        'num_threads': 5,
                        'expected_time': 2000
                    },
                    {
                        'id': f'PERF-TK-REAL-{len(test_cases)+1:03d}',
                        'description': f'Kiểm tra hiệu năng API báo cáo doanh thu theo năm (tải trung bình)',
                        'endpoint': endpoint,
                        'params': {'nam': '2024'},
                        'num_requests': 50,
                        'num_threads': 20,
                        'expected_time': 3000
                    }
                ])
        
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
    
    def save_results_to_csv(self, results, filename='ket-qua-kiem-thu-hieu-nang-thuc-te.csv'):
        """Lưu kết quả vào file CSV mới"""
        with open(filename, 'w', newline='', encoding='utf-8') as file:
            writer = csv.writer(file)
            
            # Header
            writer.writerow([
                'ID', 'Mô tả', 'Endpoint', 'Tham số', 'Số request', 'Số thread',
                'Thời gian thực hiện (ms)', 'Thời gian phản hồi (ms)', 
                'Kích thước dữ liệu (bytes)', 'Tỷ lệ thành công (%)', 
                'Trạng thái', 'Kết quả chi tiết', 'Lỗi', 'Thời gian test'
            ])
            
            # Data
            for result in results:
                writer.writerow([
                    result['id'],
                    result['description'],
                    result['endpoint'],
                    str(result['params']),
                    result['num_requests'],
                    result['num_threads'],
                    f"{result['execution_time']:.2f}",
                    f"{result['avg_response_time']:.2f}",
                    f"{result['data_size']:.0f}",
                    f"{result['success_rate']:.2f}",
                    result['status'],
                    result['result_detail'],
                    ', '.join(set(result['errors'])) if result['errors'] else '',
                    datetime.now().strftime('%Y-%m-%d %H:%M:%S')
                ])
        
        print(f"\nĐã lưu kết quả vào file: {filename}")

def main():
    print("Bắt đầu kiểm thử hiệu năng thực tế cho các API báo cáo doanh thu")
    print(f"Thời gian bắt đầu: {datetime.now().strftime('%Y-%m-%d %H:%M:%S')}")
    
    # Tạo tester
    tester = RealPerformanceTester()
    
    # Tìm kiếm các endpoints có sẵn
    working_endpoints = tester.discover_api_endpoints()
    
    if not working_endpoints:
        print("Không tìm thấy API endpoints nào hoạt động!")
        print("Hãy đảm bảo:")
        print("1. Backend server đang chạy")
        print("2. Frontend server đang chạy")
        print("3. Các API endpoints được định nghĩa đúng")
        return
    
    print(f"\nTìm thấy {len(working_endpoints)} endpoints hoạt động:")
    for endpoint in working_endpoints:
        print(f"  - {endpoint}")
    
    # Chạy kiểm thử hiệu năng
    results = tester.run_performance_tests(working_endpoints)
    
    if results:
        # Lưu kết quả
        tester.save_results_to_csv(results)
        
        # In báo cáo tóm tắt
        print(f"\n{'='*60}")
        print("BÁO CÁO TÓM TẮT KIỂM THỬ HIỆU NĂNG THỰC TẾ")
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