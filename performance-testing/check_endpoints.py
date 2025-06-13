#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Script kiểm tra các API endpoints
"""

import requests
import json

def check_endpoint(url, description):
    """Kiểm tra một endpoint"""
    print(f"\nKiểm tra: {description}")
    print(f"URL: {url}")
    
    try:
        response = requests.get(url, timeout=10)
        print(f"Status Code: {response.status_code}")
        print(f"Response Size: {len(response.content)} bytes")
        
        if response.status_code == 200:
            try:
                data = response.json()
                print(f"Response Type: JSON")
                print(f"Response Preview: {str(data)[:200]}...")
            except:
                print(f"Response Type: Text/HTML")
                print(f"Response Preview: {response.text[:200]}...")
        else:
            print(f"Response: {response.text[:200]}...")
            
    except requests.exceptions.ConnectionError:
        print("Lỗi: Không thể kết nối")
    except requests.exceptions.Timeout:
        print("Lỗi: Timeout")
    except Exception as e:
        print(f"Lỗi: {e}")

def main():
    base_url = "http://localhost:4200"
    
    print("Kiểm tra các API endpoints báo cáo doanh thu")
    print(f"Base URL: {base_url}")
    
    # Kiểm tra các endpoints có thể có
    endpoints = [
        ("/baocao/doanhthutheongay?ngay=2024-12-19", "API báo cáo doanh thu theo ngày"),
        ("/baocao/doanhthutheothang?nam=2024&thang=12", "API báo cáo doanh thu theo tháng"),
        ("/baocao/doanhthutheonam?nam=2024", "API báo cáo doanh thu theo năm"),
        ("/api/baocao/doanhthutheongay?ngay=2024-12-19", "API báo cáo doanh thu theo ngày (với /api)"),
        ("/api/baocao/doanhthutheothang?nam=2024&thang=12", "API báo cáo doanh thu theo tháng (với /api)"),
        ("/api/baocao/doanhthutheonam?nam=2024", "API báo cáo doanh thu theo năm (với /api)"),
        ("/thongke/doanhthutheongay?ngay=2024-12-19", "API thống kê doanh thu theo ngày"),
        ("/thongke/doanhthutheothang?nam=2024&thang=12", "API thống kê doanh thu theo tháng"),
        ("/thongke/doanhthutheonam?nam=2024", "API thống kê doanh thu theo năm"),
        ("/api/thongke/doanhthutheongay?ngay=2024-12-19", "API thống kê doanh thu theo ngày (với /api)"),
        ("/api/thongke/doanhthutheothang?nam=2024&thang=12", "API thống kê doanh thu theo tháng (với /api)"),
        ("/api/thongke/doanhthutheonam?nam=2024", "API thống kê doanh thu theo năm (với /api)"),
    ]
    
    for endpoint, description in endpoints:
        check_endpoint(base_url + endpoint, description)

if __name__ == "__main__":
    main() 