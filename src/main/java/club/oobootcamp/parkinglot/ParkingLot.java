package club.oobootcamp.parkinglot;

public class ParkingLot {
    private final int capacity;

    public ParkingLot(final int capacity) {
        this.capacity = capacity;
    }

    public Ticket park(final Car car) {
        if (capacity <= 0) {
            throw new ParkingFailureException();
        }
        return new Ticket();
    }
}
