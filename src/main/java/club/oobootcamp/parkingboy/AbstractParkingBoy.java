package club.oobootcamp.parkingboy;

import club.oobootcamp.parkinglot.Car;
import club.oobootcamp.parkinglot.ParkingLot;
import club.oobootcamp.parkinglot.PickUpFailureException;
import club.oobootcamp.parkinglot.Ticket;

import java.util.List;

public abstract class AbstractParkingBoy {
    final List<ParkingLot> parkingLots;

    AbstractParkingBoy(final List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    public abstract Ticket park(Car car);

    public Car pickUp(final Ticket ticket) {
        return parkingLots.stream()
            .filter(parkingLot -> parkingLot.contains(ticket))
            .findAny()
            .orElseThrow(PickUpFailureException::new)
            .pickUp(ticket);
    }
}
