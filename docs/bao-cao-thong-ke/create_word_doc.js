// Đây là một script đơn giản để tạo file HTML từ Markdown
// Sau đó, người dùng có thể mở file HTML trong trình duyệt và lưu dưới dạng Word

const fs = require('fs');

// Đọc nội dung file Markdown
const markdownContent = fs.readFileSync('Review_Code_Phan_He_Bao_Cao.md', 'utf8');

// Chuyển đổi Markdown thành HTML đơn giản
let htmlContent = `
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Review Code Phân hệ Báo cáo và Thống kê</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            line-height: 1.6;
            margin: 20px;
        }
        h1 {
            color: #333;
            border-bottom: 2px solid #333;
            padding-bottom: 10px;
        }
        h2 {
            color: #444;
            margin-top: 30px;
            border-bottom: 1px solid #ddd;
            padding-bottom: 5px;
        }
        h3 {
            color: #555;
            margin-top: 25px;
        }
        pre {
            background-color: #f5f5f5;
            padding: 15px;
            border-radius: 5px;
            overflow-x: auto;
            font-family: 'Courier New', monospace;
        }
        code {
            font-family: 'Courier New', monospace;
        }
        ul {
            margin-left: 20px;
        }
        li {
            margin-bottom: 5px;
        }
        .strong {
            font-weight: bold;
        }
    </style>
</head>
<body>
`;

// Xử lý các tiêu đề
let lines = markdownContent.split('\n');
let inCodeBlock = false;

for (let i = 0; i < lines.length; i++) {
    let line = lines[i];

    // Xử lý code blocks
    if (line.startsWith('```')) {
        if (!inCodeBlock) {
            inCodeBlock = true;
            htmlContent += '<pre><code>';
            continue;
        } else {
            inCodeBlock = false;
            htmlContent += '</code></pre>';
            continue;
        }
    }

    if (inCodeBlock) {
        // Escape HTML characters in code blocks
        line = line.replace(/&/g, '&amp;')
                   .replace(/</g, '&lt;')
                   .replace(/>/g, '&gt;');
        htmlContent += line + '\n';
        continue;
    }

    // Xử lý tiêu đề
    if (line.startsWith('# ')) {
        htmlContent += '<h1>' + line.substring(2) + '</h1>\n';
    } else if (line.startsWith('## ')) {
        htmlContent += '<h2>' + line.substring(3) + '</h2>\n';
    } else if (line.startsWith('### ')) {
        htmlContent += '<h3>' + line.substring(4) + '</h3>\n';
    } else if (line.startsWith('- ')) {
        // Xử lý danh sách không thứ tự
        if (i === 0 || !lines[i-1].startsWith('- ')) {
            htmlContent += '<ul>\n';
        }

        htmlContent += '<li>' + line.substring(2) + '</li>\n';

        if (i === lines.length - 1 || !lines[i+1].startsWith('- ')) {
            htmlContent += '</ul>\n';
        }
    } else if (line.startsWith('  - ')) {
        // Xử lý danh sách con
        if (i === 0 || !lines[i-1].startsWith('  - ')) {
            htmlContent += '<ul style="margin-left: 30px;">\n';
        }

        htmlContent += '<li>' + line.substring(4) + '</li>\n';

        if (i === lines.length - 1 || !lines[i+1].startsWith('  - ')) {
            htmlContent += '</ul>\n';
        }
    } else if (line.trim() === '') {
        // Xử lý dòng trống
        htmlContent += '<p></p>\n';
    } else {
        // Xử lý văn bản thông thường
        // Xử lý in đậm
        line = line.replace(/\*\*(.*?)\*\*/g, '<span class="strong">$1</span>');
        htmlContent += '<p>' + line + '</p>\n';
    }
}

htmlContent += `
<script>
    // Thêm hướng dẫn để lưu dưới dạng Word
    window.onload = function() {
        alert('Để lưu dưới dạng Word, vui lòng nhấn Ctrl+S hoặc chọn File > Save As, sau đó chọn định dạng Word Document (*.docx)');
    }
</script>
</body>
</html>
`;

// Ghi nội dung HTML vào file
fs.writeFileSync('Review_Code_Phan_He_Bao_Cao.html', htmlContent);
console.log('HTML file created successfully. Open it in a browser and save as Word document.');
