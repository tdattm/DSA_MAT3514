package Hw5_22000081_NguyenTienDat.Ex3;

// FlightEvent class to represent a flight event with timestamp, flightID, and eventType
public class FlightEvent implements Comparable<FlightEvent> {
    private int timestamp;
    private String flightID;
    private String eventType;  // "takeoff" or "landing"

    public FlightEvent(int timestamp, String flightID, String eventType) {
        this.timestamp = timestamp;
        this.flightID = flightID;
        this.eventType = eventType;
    }

    public int getTimestamp() {
        return timestamp;
    }

    public String getFlightID() {
        return flightID;
    }

    public String getEventType() {
        return eventType;
    }

    @Override
    public int compareTo(FlightEvent other) {
        // Order by timestamp (ascending)
        return Integer.compare(this.timestamp, other.timestamp);
    }

    @Override
    public String toString() {
        return "Flight " + flightID + " " + eventType + " at " + timestamp;
    }
}




