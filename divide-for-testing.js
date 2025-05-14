const fs = require('fs');

// Đọc file SQL đã tạo
function readSqlFile() {
  try {
    const sqlContent = fs.readFileSync('seat.sql', 'utf8');
    return sqlContent;
  } catch (error) {
    console.error('Lỗi khi đọc file SQL:', error);
    process.exit(1);
  }
}

// Chia dữ liệu thành 5 phần cho nhóm kiểm thử
function divideForTestingTeam(sqlContent) {
  // Phân chia các phần dữ liệu theo chức năng
  const sections = [
    {
      name: 'Phần 1: Quản lý thuốc',
      pattern: /-- Additional Medicine Data[\s\S]*?-- Additional Medicine Components[\s\S]*?-- Additional Medicine Target Groups[\s\S]*?-- Additional Inventory Data[\s\S]*?(?=\n-- Additional)/
    },
    {
      name: 'Phần 2: Quản lý nhập kho',
      pattern: /-- Additional Import Receipt Data[\s\S]*?-- Additional Import Receipt Details[\s\S]*?(?=\n-- Additional)/
    },
    {
      name: 'Phần 3: Quản lý khuyến mãi',
      pattern: /-- Additional Promotion Data[\s\S]*?-- Additional Promotion Details[\s\S]*?(?=\n-- Additional)/
    },
    {
      name: 'Phần 4: Quản lý đơn hàng',
      pattern: /-- Additional Order Data[\s\S]*?-- Additional Order Details[\s\S]*?(?=\n-- Additional)/
    },
    {
      name: 'Phần 5: Quản lý đánh giá và tương tác thuốc',
      pattern: /-- Additional Review Data[\s\S]*?-- Additional Drug Interaction Data[\s\S]*?(?=\n-- Additional)/
    }
  ];

  // Tạo thư mục nếu chưa tồn tại
  if (!fs.existsSync('testing-parts')) {
    fs.mkdirSync('testing-parts');
  }

  // Trích xuất và lưu từng phần
  sections.forEach((section, index) => {
    const match = sqlContent.match(section.pattern);
    if (match) {
      const content = match[0];
      const fileName = `testing-parts/part${index + 1}.sql`;
      fs.writeFileSync(fileName, `-- ${section.name}\n\n${content}`);
      console.log(`Đã tạo ${fileName}`);
    } else {
      console.error(`Không tìm thấy dữ liệu cho ${section.name}`);
    }
  });

  // Tạo file README hướng dẫn
  const readmeContent = `# Hướng dẫn kiểm thử

Dữ liệu mẫu đã được chia thành 5 phần cho nhóm kiểm thử:

1. **Phần 1: Quản lý thuốc** (part1.sql)
   - Dữ liệu thuốc
   - Thành phần thuốc
   - Đối tượng sử dụng thuốc
   - Dữ liệu tồn kho

2. **Phần 2: Quản lý nhập kho** (part2.sql)
   - Phiếu nhập
   - Chi tiết phiếu nhập

3. **Phần 3: Quản lý khuyến mãi** (part3.sql)
   - Chương trình khuyến mãi
   - Chi tiết khuyến mãi

4. **Phần 4: Quản lý đơn hàng** (part4.sql)
   - Đơn hàng
   - Chi tiết đơn hàng

5. **Phần 5: Quản lý đánh giá và tương tác thuốc** (part5.sql)
   - Đánh giá thuốc
   - Tương tác thuốc

## Cách sử dụng

1. Mỗi thành viên trong nhóm chọn một phần để kiểm thử
2. Thực thi file SQL tương ứng vào cơ sở dữ liệu PostgreSQL:
   \`\`\`
   psql -U username -d database_name -f part1.sql
   \`\`\`
3. Tiến hành kiểm thử các chức năng liên quan
`;

  fs.writeFileSync('testing-parts/README.md', readmeContent);
  console.log('Đã tạo file README.md');
}

// Thực thi chương trình
const sqlContent = readSqlFile();
divideForTestingTeam(sqlContent);
console.log('Hoàn thành phân chia dữ liệu cho nhóm kiểm thử!');
