package club.oobootcamp.parkingboy;

import club.oobootcamp.parkinglot.Car;
import club.oobootcamp.parkinglot.ParkingLot;
import club.oobootcamp.parkinglot.Ticket;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class SmartParkingBoy {

    private final List<ParkingLot> parkingLots;

    public SmartParkingBoy(final List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    public Ticket park(final Car car) {
        Optional<ParkingLot> maxParkingLot = parkingLots.stream()
            .max(Comparator.comparing(ParkingLot::getEmptySpaceCount));
        Ticket ticket = null;
        if (maxParkingLot.isPresent()) {
            ticket = maxParkingLot.get().park(car);
        }
        return ticket;
    }
}
