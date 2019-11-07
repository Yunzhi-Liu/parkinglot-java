package club.oobootcamp.parkingboy;

import club.oobootcamp.parkinglot.Car;
import club.oobootcamp.parkinglot.ParkingFailureException;
import club.oobootcamp.parkinglot.ParkingLot;
import club.oobootcamp.parkinglot.Ticket;

import java.util.Comparator;
import java.util.List;

public class SmartParkingBoy {

    private final List<ParkingLot> parkingLots;

    public SmartParkingBoy(final List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    public Ticket park(final Car car) {
        return parkingLots.stream()
            .max(Comparator.comparing(ParkingLot::getEmptySpaceCount))
            .orElseThrow(ParkingFailureException::new)
            .park(car);
    }

    public Car pickUp(final Ticket ticket) {
        return parkingLots.get(0).pickUp(ticket);
    }
}
