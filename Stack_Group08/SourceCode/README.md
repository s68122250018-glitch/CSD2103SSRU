README รายงานปฏิบัติการกลุ่ม การออกแบบและวิเคราะห์อัลกอริทึมด้วย Stack โดยใช้ภาษา Java 

กรณีศึกษา Group 8: City Skyline การหาตึกที่สูงกว่าถัดไปด้วย Monotonic Stack  และการประยุกต์ใช้กับ Largest Rectangle in Histogram 

คำอธิบายโปรแกรม

โครงงานนี้เป็นโปรแกรมภาษา Java สำหรับการออกแบบและวิเคราะห์อัลกอริทึมโดยใช้ Stack เพื่อแก้ปัญหา Next Greater Element (NGE) ซึ่งเป็นการหาค่าของอาคารที่อยู่ทางด้านขวาและมีความสูงมากกว่าอาคารปัจจุบัน โดยหากไม่พบอาคารที่สูงกว่าจะกำหนดผลลัพธ์เป็น -1

โปรแกรมพัฒนาและเปรียบเทียบวิธีการแก้ปัญหา 2 วิธี ได้แก่

Algorithm A: Brute Force ใช้การค้นหาแบบ Nested Loop โดยตรวจสอบอาคารทางด้านขวาทีละตำแหน่ง

Algorithm B: Monotonic Stack ใช้ Stack เพื่อเก็บตำแหน่งของอาคารที่ยังไม่พบ Next Greater Element และประมวลผลตามหลัก Monotonic Stack

นอกจากการหา Next Greater Element แล้ว โปรแกรมยังสามารถคำนวณ Largest Rectangle in Histogram จากข้อมูลความสูงของอาคารได้

โปรแกรมมีการตรวจสอบ Input เพื่อรองรับกรณีป้อนข้อมูลไม่ถูกต้อง เช่น ป้อนข้อความแทนจำนวนเต็ม จำนวนอาคารน้อยกว่าหรือเท่ากับ 0 และความสูงของอาคารติดลบ โดยโปรแกรมจะแจ้งเตือนและให้ป้อนข้อมูลใหม่

โปรแกรมยังวัดเวลาในการทำงานด้วย System.nanoTime() และนับจำนวน Operation ของ Algorithm A และ Algorithm B เพื่อใช้ในการวิเคราะห์และเปรียบเทียบประสิทธิภาพของอัลกอริทึม

1.โครงสร้างโปรแกรมและ GitHub

1.1 โครงสร้าง Repository

Repository ของกลุ่ม 08 จัดเก็บ Source Code เอกสารประกอบการทดลอง ผลการทดลอง และเอกสารที่เกี่ยวข้องกับโครงงาน โดยใช้โครงสร้างหลักดังนี้
```text
stack-algorithm-group08/
│
├── src/
│   ├── Main.java
│   ├── NGEAlgorithm.java
│   └──  Experiment.java
│   
│
├── test/
├── data/
├── results/
├── diagrams/
│   ├── Pseudocode/
│   ├── Flowchart/
│   └── ClassDiagram/
│
├── presentation/
├── report/
├── README.md
└── group-members.md

โครงสร้าง Source Code ที่ใช้จริง

โปรแกรม Java ของกลุ่มประกอบด้วย 3 ไฟล์หลัก

SourceCode/
│
├── Main.java
├── NGEAlgorithm.java
└── Experiment.java

โดยไม่ได้แยก AlgorithmA.java และ AlgorithmB.java เป็นคนละไฟล์ เนื่องจาก Algorithm A และ Algorithm B ถูกออกแบบและพัฒนาไว้ภายในคลาส NGEAlgorithm ตามโครงสร้าง Source Code ของโครงงาน

1.2 รายละเอียดไฟล์ Source Code

Main.java

เป็นคลาสหลักสำหรับการทำงานของโปรแกรม โดยมีหน้าที่

รับจำนวนอาคารจากผู้ใช้

ตรวจสอบความถูกต้องของจำนวนอาคาร

รับความสูงของอาคารแต่ละหลัง

ตรวจสอบ Input ที่ไม่ถูกต้อง

เรียกใช้ Algorithm A: Brute Force

เรียกใช้ Algorithm B: Monotonic Stack

วัดเวลาในการทำงานของแต่ละอัลกอริทึม

แสดงจำนวน Operation

คำนวณ Largest Rectangle in Histogram

เปรียบเทียบผลลัพธ์ของ Algorithm A และ Algorithm B

แสดงผลเป็น PASS เมื่อผลลัพธ์ทั้งสองวิธีตรงกัน

NGEAlgorithm.java

เป็นคลาสที่เก็บการประมวลผลหลักของอัลกอริทึม ประกอบด้วย

bruteForceNGE() สำหรับ Algorithm A

monotonicStackNGE() สำหรับ Algorithm B

largestRectangle() สำหรับหา Largest Rectangle in Histogram

getOperationA() สำหรับอ่านจำนวน Operation ของ Algorithm A

getOperationB() สำหรับอ่านจำนวน Operation ของ Algorithm B

Experiment.java

ใช้สำหรับการทดลองประสิทธิภาพของ Algorithm A และ Algorithm B โดยทดสอบข้อมูลหลายขนาดและทดลองแต่ละขนาดข้อมูล 5 รอบ จากนั้นนำเวลาที่วัดได้มาหาค่าเฉลี่ย และบันทึกจำนวน Operation ของแต่ละอัลกอริทึม

1.3 รายละเอียดโฟลเดอร์

โฟลเดอร์

รายละเอียด

src/

เก็บ Source Code ภาษา Java

test/

เก็บข้อมูลและเอกสารเกี่ยวกับ Test Case

data/

เก็บข้อมูล Input ที่ใช้ในการทดลอง

results/

เก็บผลการทดลอง ไฟล์ CSV และข้อมูลสำหรับสร้างกราฟ

diagrams/

เก็บ Pseudocode, Flowchart และ Class Diagram

presentation/

เก็บไฟล์สไลด์นำเสนอ

report/

เก็บรายงานฉบับ PDF หรือเอกสารรายงาน

README.md

อธิบายโครงงาน โครงสร้างโปรแกรม และวิธีใช้งาน

group-members.md

รายชื่อสมาชิกและรายละเอียดการแบ่งงาน

1.4 ชื่อ Repository

ชื่อ Repository ที่กำหนดสำหรับกลุ่ม 08 คือ

stack-algorithm-group08


1.5 ตัวอย่าง Commit Message

ตัวอย่าง Commit Message ที่เหมาะสมกับโครงงานนี้ ได้แก่

Add NGE brute force algorithm
Implement monotonic stack algorithm
Add input validation
Add operation counting
Add largest rectangle calculation
Add performance experiment
Add test cases
Update experiment results
Add flowchart and class diagram
Update complexity analysis
Update project documentation

ควรใช้ Commit Message ที่สื่อความหมายชัดเจนว่ามีการแก้ไขหรือเพิ่มส่วนใดของโครงงาน

1.6 การ Compile และ Run

Compile โปรแกรมหลัก

เปิด Terminal ในโฟลเดอร์ที่เก็บไฟล์ Source Code แล้วใช้คำสั่ง

javac Main.java NGEAlgorithm.java

หาก Compile สำเร็จ ให้เรียกใช้โปรแกรมด้วย

java Main

Compile โปรแกรมทดลอง

javac Experiment.java NGEAlgorithm.java

จากนั้นเรียกใช้

java Experiment

การ Compile และ Run ต้องดำเนินการภายในโฟลเดอร์ที่มีไฟล์ .java หรือกำหนด Path ให้ถูกต้องตามตำแหน่งไฟล์ใน Repository

1.7 ขนาดข้อมูลที่ใช้ในการทดลอง

การทดลองประสิทธิภาพกำหนดขนาดข้อมูลจำนวนอาคารทั้งหมด 5 ระดับ และทดลองแต่ละขนาดข้อมูลจำนวน 5 รอบ ดังนี้

    ชุดทดลอง        ชุดที่ 1       ชุดที่ 2     ชุดที่ 3    ชุดที่ 4     ชุดที่ 5

   จำนวนอาคาร (n)          10           100       1,000     5,000     10,000

ผลการทดลองที่ได้จากการรันโปรแกรมจริงมีดังนี้

n        Algorithm A Average Time (ns)     Algorithm A Operations   Algorithm B Average Time (ns)   Algorithm B Operations      Result

10                   560                            16                          7,700                        28                  PASS

100                 9,940                           416                         8,1320                       386                 PASS

1,000              128,600                          7,033                       347,280                     3,978                PASS
 
5,000              208,420                         49,890                       882,360                     19,958               PASS

10,000             222,860                        134,980                      1,566,580                    39,954               PASS


หมายเหตุ: เวลาในการทำงานที่วัดด้วย System.nanoTime() สามารถเปลี่ยนแปลงได้ตามสภาพแวดล้อมและการทำงานของเครื่องคอมพิวเตอร์ 
ดังนั้นค่าดังกล่าวใช้เพื่อประกอบการทดลองและควรพิจารณาร่วมกับจำนวน Operation และแนวโน้มของผลการทดลอง

1.8 ตัวอย่างผลลัพธ์

ตัวอย่างการทำงานของโปรแกรมจากข้อมูล

[4, 5, 2, 10, 8]

ผลลัพธ์ที่ได้คือ

Input: [4, 5, 2, 10, 8]

Algorithm A: Brute Force
Result: [5, 10, 10, -1, -1]

Algorithm B: Monotonic Stack
Result: [5, 10, 10, -1, -1]

Largest Rectangle: 16

Result comparison: PASS

ผลลัพธ์ของ Algorithm A และ Algorithm B ตรงกัน จึงแสดงสถานะ

Result comparison: PASS

1.9 การวิเคราะห์ความซับซ้อน

Algorithm A: Brute Force

Algorithm A ใช้ Nested Loop ในการตรวจสอบอาคารทางด้านขวา ทำให้ในกรณีที่ต้องตรวจสอบข้อมูลจำนวนมาก จำนวนการเปรียบเทียบเพิ่มขึ้นตามจำนวนข้อมูล

Time Complexity: O(n²)

Algorithm B: Monotonic Stack

Algorithm B ใช้ Stack ในการจัดเก็บ Index ของอาคารที่ยังไม่พบ Next Greater Element โดยแต่ละ Index ถูก Push และ Pop ตามกระบวนการของ Stack ทำให้มีประสิทธิภาพมากกว่าเมื่อขนาดข้อมูลเพิ่มขึ้น

Time Complexity: O(n)

1.10 สมาชิกกลุ่ม 08

1.กิตติมาภรณ์ รถทอง  รหัสนักศึกษา 68122250018 

2.ธนารักษ์ จุลแดง     รหัสนักศึกษา  68122250025 

3.ภูวเดช ตรังคธนสิน  รหัสนักศึกษา  68122250002 

4.อาลียะห์ อาลี      รหัสนักศึกษา  68122250024 

1.11รายงานการแบ่งงานของสมาชิก

1.กิตติมาภรณ์ รถทอง รับผิดชอบหลักในการจัดทำรายงานและรวบรวมเนื้อหาทั้งหมด , จัดทำ Test Cases และดำเนินการทดลองวัดประสิทธิภาพ

2.ธนารักษ์ จุลแดง   มีส่วนร่วมในการตรวจสอบความถูกต้องของเนื้อหาและผลการทดลอง , ตรวจสอบรายละเอียดของโปรแกรมและเอกสารประกอบ 

3.ภูวเดช ตรังคธนสิน  มีส่วนร่วมในการตรวจสอบ Test Cases และผลลัพธ์ของโปรแกรม

4.อาลียะห์ อาลี     มีส่วนร่วมในการตรวจสอบและจัดเตรียมเอกสารประกอบรายงาน , ทำสไลด์นำเสนอ ,เขียนและทดสอบโปรแกรมภาษา Java

1.12 สรุป

โครงงานของกลุ่ม 08 เป็นโปรแกรมภาษา Java ที่ใช้ Stack เพื่อแก้ปัญหา Next Greater Element และเปรียบเทียบประสิทธิภาพระหว่าง Brute Force และ Monotonic Stack

โปรแกรมสามารถรับข้อมูลจากผู้ใช้ ตรวจสอบ Input ที่ไม่ถูกต้อง ประมวลผล NGE ด้วย Algorithm A และ Algorithm B วัดเวลาในการทำงาน นับจำนวน Operation เปรียบเทียบผลลัพธ์ และคำนวณ Largest Rectangle in Histogram

สำหรับการทดลองประสิทธิภาพ ได้กำหนดข้อมูลจำนวน 10, 100, 1,000, 5,000 และ 10,000 อาคาร โดยทดลองแต่ละขนาด 5 รอบ ผลการทดลองทุกชุดให้ผลลัพธ์ของ Algorithm A และ Algorithm B ตรงกัน หรือ PASS

Repository ของกลุ่มใช้สำหรับจัดเก็บ Source Code เอกสารประกอบการออกแบบ ผลการทดลอง Test Case กราฟ Presentation และ Report เพื่อให้สามารถตรวจสอบและติดตามการพัฒนาโครงงานได้อย่างเป็นระบบ
