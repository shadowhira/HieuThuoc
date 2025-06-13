#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Script phân tích kết quả kiểm thử hiệu năng từ file CSV
"""

import pandas as pd
import matplotlib.pyplot as plt
import seaborn as sns
from datetime import datetime
import os

def analyze_performance_results(detail_file, summary_file=None):
    """Phân tích kết quả kiểm thử hiệu năng"""
    
    print("="*60)
    print("PHÂN TÍCH KẾT QUẢ KIỂM THỬ HIỆU NĂNG")
    print("="*60)
    
    # Đọc file chi tiết
    if not os.path.exists(detail_file):
        print(f"❌ Không tìm thấy file: {detail_file}")
        return
    
    df = pd.read_csv(detail_file)
    print(f"✅ Đã đọc {len(df)} records từ file: {detail_file}")
    
    # Phân tích tổng quan
    print("\n📊 PHÂN TÍCH TỔNG QUAN:")
    print("-" * 40)
    
    total_requests = len(df)
    successful_requests = len(df[df['success'] == True])
    failed_requests = total_requests - successful_requests
    success_rate = (successful_requests / total_requests) * 100
    
    print(f"Tổng số request: {total_requests}")
    print(f"Request thành công: {successful_requests}")
    print(f"Request thất bại: {failed_requests}")
    print(f"Tỷ lệ thành công: {success_rate:.2f}%")
    
    if successful_requests > 0:
        avg_response_time = df[df['success'] == True]['response_time_ms'].mean()
        min_response_time = df[df['success'] == True]['response_time_ms'].min()
        max_response_time = df[df['success'] == True]['response_time_ms'].max()
        
        print(f"\nThời gian phản hồi (ms):")
        print(f"  - Trung bình: {avg_response_time:.2f}")
        print(f"  - Tối thiểu: {min_response_time:.2f}")
        print(f"  - Tối đa: {max_response_time:.2f}")
    
    # Phân tích theo từng test case
    print("\n📈 PHÂN TÍCH THEO TEST CASE:")
    print("-" * 40)
    
    test_groups = df.groupby('test_name')
    
    for test_name, group in test_groups:
        print(f"\n{test_name}:")
        
        group_successful = group[group['success'] == True]
        group_failed = group[group['success'] == False]
        
        print(f"  Tổng số request: {len(group)}")
        print(f"  Thành công: {len(group_successful)}")
        print(f"  Thất bại: {len(group_failed)}")
        print(f"  Tỷ lệ thành công: {(len(group_successful)/len(group)*100):.2f}%")
        
        if len(group_successful) > 0:
            response_times = group_successful['response_time_ms']
            print(f"  Thời gian phản hồi (ms):")
            print(f"    - Trung bình: {response_times.mean():.2f}")
            print(f"    - Tối thiểu: {response_times.min():.2f}")
            print(f"    - Tối đa: {response_times.max():.2f}")
            print(f"    - Trung vị: {response_times.median():.2f}")
            print(f"    - Độ lệch chuẩn: {response_times.std():.2f}")
            
            # Tính percentile
            p95 = response_times.quantile(0.95)
            p99 = response_times.quantile(0.99)
            print(f"    - P95: {p95:.2f}")
            print(f"    - P99: {p99:.2f}")
            
            # Đánh giá hiệu năng
            avg_time = response_times.mean()
            success_rate = (len(group_successful)/len(group)*100)
            
            if success_rate >= 95 and avg_time < 2000:
                print(f"    - Đánh giá: ✅ TỐT")
            elif success_rate >= 90 and avg_time < 5000:
                print(f"    - Đánh giá: ⚠️  TRUNG BÌNH")
            else:
                print(f"    - Đánh giá: ❌ CẦN CẢI THIỆN")
    
    # Tạo biểu đồ
    create_performance_charts(df, test_name)
    
    # Lưu báo cáo phân tích
    save_analysis_report(df, test_groups)
    
    print(f"\n✅ Hoàn thành phân tích!")
    print(f"📁 Các file biểu đồ đã được tạo trong thư mục hiện tại")

def create_performance_charts(df, test_name):
    """Tạo các biểu đồ hiệu năng"""
    
    # Cấu hình style
    plt.style.use('seaborn-v0_8')
    sns.set_palette("husl")
    
    # Biểu đồ 1: Response Time Distribution
    plt.figure(figsize=(12, 8))
    
    plt.subplot(2, 2, 1)
    successful_df = df[df['success'] == True]
    for test_name in successful_df['test_name'].unique():
        test_data = successful_df[successful_df['test_name'] == test_name]['response_time_ms']
        plt.hist(test_data, alpha=0.7, label=test_name, bins=10)
    
    plt.xlabel('Response Time (ms)')
    plt.ylabel('Frequency')
    plt.title('Distribution of Response Times')
    plt.legend()
    plt.grid(True, alpha=0.3)
    
    # Biểu đồ 2: Average Response Time by Test
    plt.subplot(2, 2, 2)
    avg_times = successful_df.groupby('test_name')['response_time_ms'].mean()
    avg_times.plot(kind='bar', color='skyblue')
    plt.xlabel('Test Case')
    plt.ylabel('Average Response Time (ms)')
    plt.title('Average Response Time by Test Case')
    plt.xticks(rotation=45)
    plt.grid(True, alpha=0.3)
    
    # Biểu đồ 3: Success Rate by Test
    plt.subplot(2, 2, 3)
    success_rates = df.groupby('test_name')['success'].agg(lambda x: (x == True).mean() * 100)
    success_rates.plot(kind='bar', color='lightgreen')
    plt.xlabel('Test Case')
    plt.ylabel('Success Rate (%)')
    plt.title('Success Rate by Test Case')
    plt.xticks(rotation=45)
    plt.grid(True, alpha=0.3)
    
    # Biểu đồ 4: Response Time Box Plot
    plt.subplot(2, 2, 4)
    successful_df.boxplot(column='response_time_ms', by='test_name', ax=plt.gca())
    plt.xlabel('Test Case')
    plt.ylabel('Response Time (ms)')
    plt.title('Response Time Distribution (Box Plot)')
    plt.suptitle('')  # Xóa title mặc định
    plt.grid(True, alpha=0.3)
    
    plt.tight_layout()
    timestamp = datetime.now().strftime("%Y%m%d_%H%M%S")
    plt.savefig(f'performance_analysis_{timestamp}.png', dpi=300, bbox_inches='tight')
    plt.show()
    
    # Biểu đồ 5: Response Time Over Time
    plt.figure(figsize=(12, 6))
    
    for test_name in df['test_name'].unique():
        test_data = df[df['test_name'] == test_name]
        test_data = test_data.sort_values('timestamp')
        plt.plot(range(len(test_data)), test_data['response_time_ms'], 
                marker='o', label=test_name, alpha=0.7)
    
    plt.xlabel('Request Sequence')
    plt.ylabel('Response Time (ms)')
    plt.title('Response Time Over Time')
    plt.legend()
    plt.grid(True, alpha=0.3)
    
    timestamp = datetime.now().strftime("%Y%m%d_%H%M%S")
    plt.savefig(f'response_time_trend_{timestamp}.png', dpi=300, bbox_inches='tight')
    plt.show()

def save_analysis_report(df, test_groups):
    """Lưu báo cáo phân tích"""
    
    timestamp = datetime.now().strftime("%Y%m%d_%H%M%S")
    report_file = f'performance_analysis_report_{timestamp}.txt'
    
    with open(report_file, 'w', encoding='utf-8') as f:
        f.write("BÁO CÁO PHÂN TÍCH KIỂM THỬ HIỆU NĂNG\n")
        f.write("="*50 + "\n")
        f.write(f"Ngày tạo: {datetime.now().strftime('%Y-%m-%d %H:%M:%S')}\n\n")
        
        # Tổng quan
        total_requests = len(df)
        successful_requests = len(df[df['success'] == True])
        failed_requests = total_requests - successful_requests
        success_rate = (successful_requests / total_requests) * 100
        
        f.write("1. TỔNG QUAN\n")
        f.write("-" * 20 + "\n")
        f.write(f"Tổng số request: {total_requests}\n")
        f.write(f"Request thành công: {successful_requests}\n")
        f.write(f"Request thất bại: {failed_requests}\n")
        f.write(f"Tỷ lệ thành công: {success_rate:.2f}%\n\n")
        
        if successful_requests > 0:
            avg_response_time = df[df['success'] == True]['response_time_ms'].mean()
            f.write(f"Thời gian phản hồi trung bình: {avg_response_time:.2f}ms\n\n")
        
        # Chi tiết từng test case
        f.write("2. CHI TIẾT THEO TEST CASE\n")
        f.write("-" * 30 + "\n")
        
        for test_name, group in test_groups:
            f.write(f"\n{test_name}:\n")
            
            group_successful = group[group['success'] == True]
            group_failed = group[group['success'] == False]
            
            f.write(f"  Tổng số request: {len(group)}\n")
            f.write(f"  Thành công: {len(group_successful)}\n")
            f.write(f"  Thất bại: {len(group_failed)}\n")
            f.write(f"  Tỷ lệ thành công: {(len(group_successful)/len(group)*100):.2f}%\n")
            
            if len(group_successful) > 0:
                response_times = group_successful['response_time_ms']
                f.write(f"  Thời gian phản hồi (ms):\n")
                f.write(f"    - Trung bình: {response_times.mean():.2f}\n")
                f.write(f"    - Tối thiểu: {response_times.min():.2f}\n")
                f.write(f"    - Tối đa: {response_times.max():.2f}\n")
                f.write(f"    - Trung vị: {response_times.median():.2f}\n")
                f.write(f"    - Độ lệch chuẩn: {response_times.std():.2f}\n")
                f.write(f"    - P95: {response_times.quantile(0.95):.2f}\n")
                f.write(f"    - P99: {response_times.quantile(0.99):.2f}\n")
        
        # Kết luận và khuyến nghị
        f.write("\n3. KẾT LUẬN VÀ KHUYẾN NGHỊ\n")
        f.write("-" * 35 + "\n")
        
        if success_rate >= 95:
            f.write("✅ Tỷ lệ thành công tổng thể: TỐT\n")
        elif success_rate >= 90:
            f.write("⚠️  Tỷ lệ thành công tổng thể: TRUNG BÌNH\n")
        else:
            f.write("❌ Tỷ lệ thành công tổng thể: CẦN CẢI THIỆN\n")
        
        if successful_requests > 0:
            avg_time = df[df['success'] == True]['response_time_ms'].mean()
            if avg_time < 2000:
                f.write("✅ Thời gian phản hồi: TỐT\n")
            elif avg_time < 5000:
                f.write("⚠️  Thời gian phản hồi: TRUNG BÌNH\n")
            else:
                f.write("❌ Thời gian phản hồi: CHẬM\n")
        
        f.write("\nKhuyến nghị:\n")
        if success_rate < 95:
            f.write("- Kiểm tra logs server để xác định nguyên nhân lỗi\n")
            f.write("- Tối ưu hóa database queries\n")
            f.write("- Kiểm tra cấu hình server\n")
        
        if successful_requests > 0 and df[df['success'] == True]['response_time_ms'].mean() > 2000:
            f.write("- Tối ưu hóa hiệu năng database\n")
            f.write("- Cân nhắc sử dụng caching\n")
            f.write("- Kiểm tra tài nguyên hệ thống\n")
    
    print(f"📄 Báo cáo phân tích đã được lưu vào: {report_file}")

def main():
    """Hàm main"""
    import sys
    
    if len(sys.argv) > 1:
        detail_file = sys.argv[1]
    else:
        # Sử dụng file mẫu nếu không có tham số
        detail_file = "sample_performance_results.csv"
    
    analyze_performance_results(detail_file)

if __name__ == "__main__":
    main() 