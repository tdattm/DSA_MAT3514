package Hw5_22000081_NguyenTienDat.Ex3;

import Hw5_22000081_NguyenTienDat.Ex1.PriorityQueueInterface;
import Hw5_22000081_NguyenTienDat.Ex1.SortedArrayPriorityQueue;

public class AirTrafficControlSimulation {
    public static void main(String[] args) {
        // Khởi tạo hàng đợi ưu tiên, ở đây có thể chọn SortedArrayPriorityQueue hoặc SortedLinkedPriorityQueue
        PriorityQueueInterface<Integer, FlightEvent> queue = new SortedArrayPriorityQueue<>();

        // Tạo hệ thống điều hành không lưu
        AirTrafficControl control = new AirTrafficControl(queue);

        // Thêm sự kiện vào hàng đợi
        control.addEvent(10, "AA123", "takeoff");
        control.addEvent(5, "BB456", "landing");
        control.addEvent(12, "CC789", "takeoff");

        // Xử lý các sự kiện
        while (control.hasEvents()) {
            control.nextEvent();
        }
    }
}
