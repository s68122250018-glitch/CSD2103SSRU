# Lab Report: Singly Linked List (Node1)

ใบงานการทดลองเขียนและจัดการข้อมูลประเภท Singly Linked List ด้วยภาษา Java โดยสร้างคลาส `Node1<T>` แบบ Generics

## การทำงานของโปรแกรม

1. **การสร้างและเชื่อมต่อ Node**
   - สร้าง Node ได้แก่ `red`, `green`, `yellow` และ `pink`
   - เชื่อมต่อ Node เข้าด้วยกันตามลำดับ (`red -> yellow -> green -> pink`)
   - กำหนดให้ `head` ชี้ไปยัง Node ตัวแรก (`red`) และ `tail` ชี้ไปยัง Node ตัวสุดท้าย (`pink`)

2. **การค้นหา Node (searchNode)**
   - วนลูปค้นหา Node ที่มีค่าตามที่กำหนด (ค้นหาคำว่า `"blue"`)
   - คืนค่า Node ที่พบ หากไม่พบจะคืนค่า `null`

3. **การนับจำนวน Node (countNodes)**
   - วนลูปนับจำนวน Node ทั้งหมดใน List ตั้งแต่ `head` จนถึง `tail`

---

## ซอร์สโค้ดโปรแกรม (Node1.java)

```java
public class Node1<T> {
    public T nodeValue; 
    public Node1<T> next;

    public Node1() {
        this.nodeValue = null;
        this.next = null;
    }

    public Node1(T item) {
        this.nodeValue = item;
        this.next = null;
    }

    // 1. Method ค้นหา node ที่มีค่าตามกำหนด
    public static <T> Node1<T> searchNode(Node1<T> head, T target) {
        Node1<T> current = head;
        while (current != null) {
            if (current.nodeValue != null && current.nodeValue.equals(target)) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    // 2. Method นับจำนวน node ทั้งหมดใน list
    public static <T> int countNodes(Node1<T> head) {
        int count = 0;
        Node1<T> current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    public static void main(String[] args) {
        Node1<String> p = new Node1<String>("red");
        System.out.println("p = " + p);
        System.out.println("p.nodeValue = " + p.nodeValue);
        System.out.println("p.next before = " + p.next);

        Node1<String> q = new Node1<String>("green");
        Node1<String> m = new Node1<String>("pink");
        Node1<String> n = new Node1<String>("yellow");

        System.out.println("q = " + q);
        System.out.println("q.nodeValue = " + q.nodeValue);
        System.out.println("q.next = " + q.next);

        // เชื่อมต่อ Node: p -> n -> q
        p.next = n;
        n.next = q;
        System.out.println("p.next After = " + p.next);
        System.out.println("n.next After = " + n.next);

        Node1<String> head = p;
        System.out.println("head. = " + head);

        // เชื่อมต่อ Node: q -> m
        q.next = m;
        System.out.println("q.next After = " + q.next);

        Node1<String> teil = m; 
        System.out.println("teil. = " + teil);

        // เรียกใช้คำสั่งค้นหา node ที่มีค่า "blue"
        Node1<String> targetNode = searchNode(head, "blue");
        System.out.println("search 'blue' = " + targetNode);

        // เรียกใช้ method นับจำนวน node ใน list
        int totalNodes = countNodes(head);
        System.out.println("count nodes = " + totalNodes);
    }
}
