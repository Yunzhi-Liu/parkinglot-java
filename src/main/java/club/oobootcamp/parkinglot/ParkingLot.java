package club.oobootcamp.parkinglot;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private final int capacity;
    private final Map<Ticket, Car> cars;

    public ParkingLot(final int capacity) {
        this.capacity = capacity;
        cars = new HashMap<>();
    }

    public Ticket park(final Car car) {
        if (capacity <= 0) {
            throw new ParkingFailureException();
        }
        Ticket ticket = new Ticket();
        cars.put(ticket, car);
        return ticket;
    }

    public Car pickUp(final Ticket ticket) {
        if (!cars.containsKey(ticket)) {
            throw new PickUpFailureException();
        }
        return cars.remove(ticket);
    }

    public boolean existEmptyParking() {
        return capacity - cars.size() > 0;
    }

    public boolean contains(final Ticket ticket) {
        return cars.containsKey(ticket);
    }
}
