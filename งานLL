public class Node1<T> {
    public T nodeValue;
    public Node1<T> next;

    public Node1() {
        this.nodeValue = null;
        this.next = null;
    }

    public Node1(T nodeValue) {
        this.nodeValue = nodeValue;
        this.next = null;
    }

    // ==========================================
    // เฉลย ข้อ 1: คำสั่งในการค้นหา node ที่มีค่า blue
    // ==========================================
    public static Node1<String> searchNode(Node1<String> head, String target) {
        Node1<String> current = head;
        while (current != null) {
            if (current.nodeValue != null && current.nodeValue.equalsIgnoreCase(target)) {
                return current; // คืนค่า Node ที่พบ
            }
            current = current.next;
        }
        return null; // คืนค่า null หากไม่พบ Node
    }

    // ==========================================
    // เฉลย ข้อ 2: Method ในการนับจำนวน node ใน list
    // ==========================================
    public static int countNodes(Node1<String> head) {
        int count = 0;
        Node1<String> current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count; // คืนค่าจำนวน node ทั้งหมด
    }

    public static void main(String[] args) {
        // 1. สร้าง Node ตามโครงสร้างในคลาส
        Node1<String> p = new Node1<String>("red");
        Node1<String> q = new Node1<String>("green");
        Node1<String> n = new Node1<String>("blue");
        Node1<String> m = new Node1<String>("yellow");

        // 2. เชื่อมต่อ Node เข้าด้วยกัน
        p.next = q;
        q.next = n;
        n.next = m;

        Node1<String> head = p;
        Node1<String> tail = m;

        // 3. แสดงผลรันโปรแกรม
        System.out.println("p = " + p);
        System.out.println("p.nodeValue = " + p.nodeValue);
        System.out.println("head. = " + head);
        System.out.println("teil. = " + tail);

        // เรียกใช้งาน ข้อ 1
        Node1<String> searchResult = searchNode(head, "blue");
        System.out.println("search 'blue' = " + searchResult);

        // เรียกใช้งาน ข้อ 2
        int totalNodes = countNodes(head);
        System.out.println("count nodes = " + totalNodes);
    }
}
