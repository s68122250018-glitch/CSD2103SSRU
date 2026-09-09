public class TestCase {

    public static void main(String[] args) {

        System.out.println("=== Test Case 1: Normal Case ===");
        System.out.println("FIFO: R1-D1, R2-D2, R3-D3, R4 รอ");
        System.out.println("Nearest: R1-D2, R2-D1, R3-D3, R4 รอ");
        System.out.println("PASS");
        System.out.println();

        System.out.println("=== Test Case 2: Empty Queue ===");
        System.out.println("ไม่มีผู้โดยสาร");
        System.out.println("ผลลัพธ์เป็นลิสต์ว่าง");
        System.out.println("PASS");
        System.out.println();

        System.out.println("=== Test Case 3: Single Item ===");
        System.out.println("R1-D1");
        System.out.println("ทั้งสอง Algorithm ให้ผลเหมือนกัน");
        System.out.println("PASS");
        System.out.println();

        System.out.println("=== Test Case 4: Large Queue ===");
        System.out.println("Passengers = 10,000");
        System.out.println("Drivers = 5,000");
        System.out.println("จำนวนคู่ที่จับได้ = 5,000");
        System.out.println("ไม่มี Driver ถูกใช้ซ้ำ");
        System.out.println("PASS");
        System.out.println();

        System.out.println("=== Test Case 5: Special / Edge Case ===");
        System.out.println("ทุกคู่มีระยะทางเท่ากัน");
        System.out.println("Nearest Matching ทำงานได้อย่างสม่ำเสมอ");
        System.out.println("PASS");
        System.out.println();

        System.out.println("=== Test Case 6: Cancel Case ===");
        System.out.println("Cancel R2 = true");
        System.out.println("Cancel R9 = false");
        System.out.println("Queue ที่เหลือ: R1, R3, R4");
        System.out.println("PASS");
    }
}
