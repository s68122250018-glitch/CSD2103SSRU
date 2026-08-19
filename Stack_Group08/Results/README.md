# Results

โฟลเดอร์นี้ใช้สำหรับจัดเก็บผลการทดลองและกราฟเปรียบเทียบประสิทธิภาพของ Algorithm A และ Algorithm B ในโครงงาน City Skyline: Next Greater Element

## ไฟล์ภายในโฟลเดอร์

### ผลการทดลอง
ประกอบด้วยข้อมูลผลการทดลองจาก Experiment.java โดยทดลองข้อมูลจำนวน 5 ขนาด ได้แก่

- n = 10
- n = 100
- n = 1,000
- n = 5,000
- n = 10,000

แต่ละขนาดข้อมูลทดลอง 5 รอบ และนำเวลาในการทำงานมาคำนวณค่าเฉลี่ย

ข้อมูลที่บันทึกประกอบด้วย

- Algorithm A Average Time
- Algorithm A Operations
- Algorithm B Average Time
- Algorithm B Operations
- Result Comparison (PASS/FAIL)

### กราฟเปรียบเทียบ
ใช้แสดงการเปรียบเทียบระหว่าง Algorithm A และ Algorithm B ในด้าน

1. Average Running Time
2. Number of Operations

## หมายเหตุ

ค่าเวลาในการทำงานที่วัดด้วย System.nanoTime() สามารถเปลี่ยนแปลงได้ตามสภาพแวดล้อมของ JVM และเครื่องคอมพิวเตอร์ที่ใช้ทดลอง ดังนั้นควรพิจารณาผลร่วมกับ Time Complexity และจำนวน Operation
