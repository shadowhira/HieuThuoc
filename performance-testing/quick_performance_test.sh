#!/bin/bash

# Script kiểm thử hiệu năng nhanh cho chức năng báo cáo doanh thu
# Sử dụng curl để test các API endpoints

echo "========================================"
echo "KIỂM THỬ HIỆU NĂNG NHANH - BÁO CÁO DOANH THU"
echo "========================================"

BASE_URL="http://localhost:8080"
RESULTS_FILE="quick_performance_results_$(date +%Y%m%d_%H%M%S).csv"

# Tạo header cho file CSV
echo "test_name,endpoint,status_code,response_time_ms,response_size_bytes,success,timestamp" > "$RESULTS_FILE"

# Hàm test một endpoint
test_endpoint() {
    local test_name="$1"
    local endpoint="$2"
    local params="$3"
    
    echo "Đang test: $test_name"
    
    # Đo thời gian phản hồi
    start_time=$(date +%s%3N)
    
    if [ -n "$params" ]; then
        response=$(curl -s -w "\n%{http_code}\n%{size_download}\n%{time_total}" \
            "$BASE_URL$endpoint?$params")
    else
        response=$(curl -s -w "\n%{http_code}\n%{size_download}\n%{time_total}" \
            "$BASE_URL$endpoint")
    fi
    
    end_time=$(date +%s%3N)
    
    # Parse response
    response_body=$(echo "$response" | head -n -3)
    status_code=$(echo "$response" | tail -n 3 | head -n 1)
    response_size=$(echo "$response" | tail -n 2 | head -n 1)
    curl_time=$(echo "$response" | tail -n 1)
    
    # Tính thời gian phản hồi
    response_time=$((end_time - start_time))
    
    # Kiểm tra thành công
    if [ "$status_code" = "200" ]; then
        success="true"
    else
        success="false"
    fi
    
    timestamp=$(date '+%Y-%m-%d %H:%M:%S')
    
    # Ghi vào file CSV
    echo "$test_name,$endpoint,$status_code,$response_time,$response_size,$success,$timestamp" >> "$RESULTS_FILE"
    
    echo "  Status: $status_code, Time: ${response_time}ms, Size: ${response_size}bytes"
}

# Test các endpoints
echo "Bắt đầu kiểm thử..."

# Test 1: Doanh thu theo ngày
for i in {1..5}; do
    test_endpoint "Doanh Thu Theo Ngay" "/baocao/doanhthutheongay" "ngay=2024-12-19"
done

# Test 2: Doanh thu theo tháng
for i in {1..5}; do
    test_endpoint "Doanh Thu Theo Thang" "/baocao/doanhthutheothang" "nam=2024&thang=12"
done

# Test 3: Doanh thu theo năm
for i in {1..5}; do
    test_endpoint "Doanh Thu Theo Nam" "/baocao/doanhthutheonam" "nam=2024"
done

echo ""
echo "Hoàn thành kiểm thử!"
echo "Kết quả đã được lưu vào file: $RESULTS_FILE"

# Hiển thị thống kê
echo ""
echo "THỐNG KÊ KẾT QUẢ:"
echo "================="

# Đếm số lượng test thành công/thất bại cho mỗi loại
echo "Doanh Thu Theo Ngay:"
success_count=$(grep "Doanh Thu Theo Ngay" "$RESULTS_FILE" | grep "true" | wc -l)
total_count=$(grep "Doanh Thu Theo Ngay" "$RESULTS_FILE" | wc -l)
echo "  Thành công: $success_count/$total_count"

echo "Doanh Thu Theo Thang:"
success_count=$(grep "Doanh Thu Theo Thang" "$RESULTS_FILE" | grep "true" | wc -l)
total_count=$(grep "Doanh Thu Theo Thang" "$RESULTS_FILE" | wc -l)
echo "  Thành công: $success_count/$total_count"

echo "Doanh Thu Theo Nam:"
success_count=$(grep "Doanh Thu Theo Nam" "$RESULTS_FILE" | grep "true" | wc -l)
total_count=$(grep "Doanh Thu Theo Nam" "$RESULTS_FILE" | wc -l)
echo "  Thành công: $success_count/$total_count"

echo ""
echo "File CSV đã được tạo: $RESULTS_FILE" 