#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Script demo để kiểm thử hiệu năng với dữ liệu mẫu
Chạy nhanh để kiểm tra cấu hình
"""

import requests
import time
import csv
from datetime import datetime

def demo_performance_test():
    """Chạy kiểm thử hiệu năng demo với ít request"""
    
    print("="*60)
    print("DEMO KIỂM THỬ HIỆU NĂNG - BÁO CÁO DOANH THU")
    print("="*60)
    
    base_url = "http://localhost:8080"
    results = []
    
    # Định nghĩa test cases
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
    
    print("Kiểm tra kết nối server...")
    try:
        response = requests.get(f"{base_url}/baocao/doanhthutheongay?ngay=2024-12-19", timeout=5)
        if response.status_code == 200:
            print("✅ Server đang hoạt động")
        else:
            print(f"⚠️  Server trả về status code: {response.status_code}")
    except Exception as e:
        print(f"❌ Không thể kết nối đến server: {e}")
        print("Hãy đảm bảo server đang chạy tại http://localhost:8080")
        return
    
    print("\nBắt đầu kiểm thử hiệu năng...")
    
    # Chạy mỗi test case 3 lần
    for test_case in test_cases:
        print(f"\nĐang test: {test_case['name']}")
        
        for i in range(3):
            start_time = time.time()
            try:
                response = requests.get(
                    f"{base_url}{test_case['endpoint']}", 
                    params=test_case['params'], 
                    timeout=10
                )
                end_time = time.time()
                
                response_time = (end_time - start_time) * 1000
                
                result = {
                    'test_name': test_case['name'],
                    'iteration': i + 1,
                    'status_code': response.status_code,
                    'response_time_ms': response_time,
                    'response_size_bytes': len(response.content),
                    'success': response.status_code == 200,
                    'timestamp': datetime.now().strftime('%Y-%m-%d %H:%M:%S')
                }
                
                results.append(result)
                
                status_icon = "✅" if response.status_code == 200 else "❌"
                print(f"  {status_icon} Lần {i+1}: {response_time:.2f}ms (Status: {response.status_code})")
                
            except requests.exceptions.Timeout:
                end_time = time.time()
                response_time = (end_time - start_time) * 1000
                result = {
                    'test_name': test_case['name'],
                    'iteration': i + 1,
                    'status_code': None,
                    'response_time_ms': response_time,
                    'response_size_bytes': 0,
                    'success': False,
                    'timestamp': datetime.now().strftime('%Y-%m-%d %H:%M:%S')
                }
                results.append(result)
                print(f"  ❌ Lần {i+1}: Timeout sau {response_time:.2f}ms")
                
            except Exception as e:
                end_time = time.time()
                response_time = (end_time - start_time) * 1000
                result = {
                    'test_name': test_case['name'],
                    'iteration': i + 1,
                    'status_code': None,
                    'response_time_ms': response_time,
                    'response_size_bytes': 0,
                    'success': False,
                    'timestamp': datetime.now().strftime('%Y-%m-%d %H:%M:%S')
                }
                results.append(result)
                print(f"  ❌ Lần {i+1}: Lỗi - {e}")
    
    # Tạo báo cáo tổng hợp
    print("\n" + "="*60)
    print("BÁO CÁO TỔNG HỢP")
    print("="*60)
    
    # Nhóm kết quả theo test name
    test_groups = {}
    for result in results:
        test_name = result['test_name']
        if test_name not in test_groups:
            test_groups[test_name] = []
        test_groups[test_name].append(result)
    
    for test_name, test_results in test_groups.items():
        print(f"\n{test_name}:")
        
        successful_tests = [r for r in test_results if r['success']]
        failed_tests = [r for r in test_results if not r['success']]
        
        print(f"  Tổng số test: {len(test_results)}")
        print(f"  Thành công: {len(successful_tests)}")
        print(f"  Thất bại: {len(failed_tests)}")
        print(f"  Tỷ lệ thành công: {(len(successful_tests)/len(test_results)*100):.1f}%")
        
        if successful_tests:
            response_times = [r['response_time_ms'] for r in successful_tests]
            avg_time = sum(response_times) / len(response_times)
            min_time = min(response_times)
            max_time = max(response_times)
            
            print(f"  Thời gian phản hồi (ms):")
            print(f"    - Trung bình: {avg_time:.2f}")
            print(f"    - Tối thiểu: {min_time:.2f}")
            print(f"    - Tối đa: {max_time:.2f}")
            
            # Đánh giá hiệu năng
            if avg_time < 2000:
                print(f"    - Đánh giá: ✅ Tốt")
            elif avg_time < 5000:
                print(f"    - Đánh giá: ⚠️  Trung bình")
            else:
                print(f"    - Đánh giá: ❌ Chậm")
        
        if failed_tests:
            print(f"  Lỗi gặp phải:")
            for test in failed_tests:
                if test['status_code']:
                    print(f"    - HTTP {test['status_code']}")
                else:
                    print(f"    - Timeout/Connection Error")
    
    # Lưu kết quả vào file CSV
    timestamp = datetime.now().strftime("%Y%m%d_%H%M%S")
    filename = f"demo_performance_test_{timestamp}.csv"
    
    with open(filename, 'w', newline='', encoding='utf-8') as csvfile:
        fieldnames = ['test_name', 'iteration', 'status_code', 'response_time_ms', 
                     'response_size_bytes', 'success', 'timestamp']
        writer = csv.DictWriter(csvfile, fieldnames=fieldnames)
        writer.writeheader()
        writer.writerows(results)
    
    print(f"\nKết quả đã được lưu vào file: {filename}")
    
    # Đánh giá tổng thể
    print("\n" + "="*60)
    print("ĐÁNH GIÁ TỔNG THỂ")
    print("="*60)
    
    total_tests = len(results)
    successful_tests = len([r for r in results if r['success']])
    overall_success_rate = (successful_tests / total_tests) * 100
    
    if successful_tests > 0:
        all_response_times = [r['response_time_ms'] for r in results if r['success']]
        overall_avg_time = sum(all_response_times) / len(all_response_times)
        
        print(f"Tổng số test: {total_tests}")
        print(f"Tỷ lệ thành công tổng thể: {overall_success_rate:.1f}%")
        print(f"Thời gian phản hồi trung bình: {overall_avg_time:.2f}ms")
        
        if overall_success_rate >= 95 and overall_avg_time < 2000:
            print("🎉 Hiệu năng tổng thể: TỐT")
        elif overall_success_rate >= 90 and overall_avg_time < 5000:
            print("⚠️  Hiệu năng tổng thể: TRUNG BÌNH")
        else:
            print("❌ Hiệu năng tổng thể: CẦN CẢI THIỆN")
    else:
        print("❌ Không có test nào thành công!")

if __name__ == "__main__":
    demo_performance_test() 