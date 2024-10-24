package Hw5_22000081_NguyenTienDat.Ex3;

import Hw5_22000081_NguyenTienDat.Ex1.PriorityQueueInterface;
import Hw5_22000081_NguyenTienDat.Ex1.Entry;


class AirTrafficControl {
    private PriorityQueueInterface<Integer, FlightEvent> queue;

    public AirTrafficControl(PriorityQueueInterface<Integer, FlightEvent> queue) {
        this.queue = queue;
    }

    // Thêm sự kiện với timestamp (K) và thông tin FlightEvent (E)
    public void addEvent(int timestamp, String flightID, String eventType) {
        FlightEvent event = new FlightEvent(timestamp, flightID, eventType);
        queue.insert(timestamp, event);
    }

    // Lấy ra sự kiện có timestamp nhỏ nhất
    public void nextEvent() {
        if (!queue.isEmpty()) {
            Entry<Integer, FlightEvent> next = queue.removeMin();
            System.out.println("Handling event: " + next.getValue() + " at timestamp: " + next.getKey());
        } else {
            System.out.println("No events available.");
        }
    }

    public boolean hasEvents() {
        return !queue.isEmpty();
    }
}
