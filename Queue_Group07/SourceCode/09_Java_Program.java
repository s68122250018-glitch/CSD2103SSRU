import java.util.*;

/**
 * กลุ่มที่ 7: Ride-Hailing Driver Assignment
 * ออกแบบด้วย Queue<T> และ PriorityQueue<T> ตามหลักการ Queue Algorithm Design
 *
 * Algorithm A: FIFO Matching        -> Queue<Passenger> + Queue<Driver>
 * Algorithm B: Nearest Driver Match -> Queue<Passenger> + PriorityQueue<Driver> (ต่อผู้โดยสาร 1 คน)
 */
public class RideHailingQueueAlgorithm {

    static class Passenger {
        String id;
        int index; // แถวใน distanceMatrix
        Passenger(String id, int index) { this.id = id; this.index = index; }
        public String toString() { return id; }
    }

    static class Driver {
        String id;
        int index; // คอลัมน์ใน distanceMatrix
        Driver(String id, int index) { this.id = id; this.index = index; }
        public String toString() { return id; }
    }

    static class MatchResult {
        String passengerId;
        String driverId; // null = ยังไม่ได้จับคู่ (รอคิว)
        int distance;     // -1 = ไม่มีค่า
        MatchResult(String p, String d, int dist) {
            passengerId = p; driverId = d; distance = dist;
        }
    }

    public static void main(String[] args) {
        String[] passengerIds = {"R1", "R2", "R3", "R4"};
        String[] driverIds    = {"D1", "D2", "D3"};

        int[][] distanceMatrix = {
            {5, 2, 8}, // R1
            {1, 6, 4}, // R2
            {7, 3, 2}, // R3
            {3, 5, 6}, // R4
        };

        List<Passenger> passengers = new ArrayList<>();
        for (int i = 0; i < passengerIds.length; i++) passengers.add(new Passenger(passengerIds[i], i));

        List<Driver> drivers = new ArrayList<>();
        for (int i = 0; i < driverIds.length; i++) drivers.add(new Driver(driverIds[i], i));

        System.out.println("=== Algorithm A: FIFO Matching ===");
        List<MatchResult> fifo = fifoMatching(passengers, drivers, distanceMatrix);
        printResults(fifo);

        System.out.println("\n=== Algorithm B: Nearest Driver Matching ===");
        List<MatchResult> nearest = nearestMatching(passengers, drivers, distanceMatrix);
        printResults(nearest);
    }

    /**
     * Algorithm A: FIFO Matching
     * ใช้ Queue<Passenger> และ Queue<Driver> (ArrayDeque) ล้วน ๆ
     * dequeue คู่กันไปเรื่อย ๆ จนกว่า Queue ใด Queue หนึ่งจะว่าง
     */
    static List<MatchResult> fifoMatching(List<Passenger> passengers, List<Driver> drivers, int[][] dist) {
        Queue<Passenger> requestQueue = new ArrayDeque<>(passengers);
        Queue<Driver> driverQueue = new ArrayDeque<>(drivers);

        List<MatchResult> results = new ArrayList<>();

        while (!requestQueue.isEmpty() && !driverQueue.isEmpty()) {
            Passenger p = requestQueue.poll(); // dequeue
            Driver d = driverQueue.poll();     // dequeue
            int distance = dist[p.index][d.index];
            results.add(new MatchResult(p.id, d.id, distance));
        }

        // ผู้โดยสารที่เหลือ (ไม่มีคนขับพอ) ถือว่ารอคิว
        while (!requestQueue.isEmpty()) {
            Passenger p = requestQueue.poll();
            results.add(new MatchResult(p.id, null, -1));
        }

        return results;
    }

    /**
     * Algorithm B: Nearest Driver Matching
     * requestQueue เป็น Queue ปกติ (รักษาลำดับ First-Come)
     * แต่ต่อผู้โดยสาร 1 คน จะสร้าง PriorityQueue<Driver> ใหม่จากคนขับที่ยังว่าง
     * โดยจัดลำดับความสำคัญ (priority) ตามระยะทางไปยังผู้โดยสารคนนั้น (น้อย -> มาก)
     */
    static List<MatchResult> nearestMatching(List<Passenger> passengers, List<Driver> drivers, int[][] dist) {
        Queue<Passenger> requestQueue = new ArrayDeque<>(passengers);
        List<Driver> availableDrivers = new ArrayList<>(drivers); // pool คนขับที่ยังว่าง

        List<MatchResult> results = new ArrayList<>();

        while (!requestQueue.isEmpty()) {
            Passenger p = requestQueue.poll(); // dequeue ตามลำดับ First-Come

            final Passenger current = p;
            PriorityQueue<Driver> pq = new PriorityQueue<>(
                Comparator.comparingInt(d -> dist[current.index][d.index])
            );
            pq.addAll(availableDrivers); // offer คนขับที่ว่างทั้งหมดเข้า PriorityQueue

            if (!pq.isEmpty()) {
                Driver nearest = pq.poll(); // ดึงคนขับที่ระยะทางน้อยที่สุด
                availableDrivers.remove(nearest);
                int distance = dist[p.index][nearest.index];
                results.add(new MatchResult(p.id, nearest.id, distance));
            } else {
                results.add(new MatchResult(p.id, null, -1));
            }
        }

        return results;
    }

    /**
     * Cancel Case: ยกเลิกคำขอที่อยู่กลาง requestQueue (Test Case #6)
     * ArrayDeque.remove(Object) จะค้นหาและลบสมาชิกตัวแรกที่ตรงกัน O(n)
     * คืนค่า false ถ้าไม่พบ (เช่น ยกเลิกคำขอที่ไม่มีอยู่จริง) โดยไม่เกิด Exception
     */
    static boolean cancelRequest(Queue<Passenger> requestQueue, String passengerId) {
        Passenger target = null;
        for (Passenger p : requestQueue) {
            if (p.id.equals(passengerId)) { target = p; break; }
        }
        if (target == null) return false; // ไม่พบ -> ไม่มีผลใด ๆ
        return requestQueue.remove(target);
    }

    static void printResults(List<MatchResult> results) {
        System.out.printf("%-10s%-10s%-10s%n", "Passenger", "Driver", "Distance");
        for (MatchResult r : results) {
            System.out.printf("%-10s%-10s%-10s%n",
                    r.passengerId,
                    r.driverId == null ? "-" : r.driverId,
                    r.distance < 0 ? "รอคิว" : String.valueOf(r.distance));
        }
    }
}
