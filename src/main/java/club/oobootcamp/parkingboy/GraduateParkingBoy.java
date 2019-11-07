package club.oobootcamp.parkingboy;

import club.oobootcamp.parkinglot.Car;
import club.oobootcamp.parkinglot.ParkingFailureException;
import club.oobootcamp.parkinglot.ParkingLot;
import club.oobootcamp.parkinglot.PickUpFailureException;
import club.oobootcamp.parkinglot.Ticket;

import java.util.List;

public class GraduateParkingBoy {
    private final List<ParkingLot> parkingLots;

    public GraduateParkingBoy(final List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    public Ticket park(final Car car) {
        return parkingLots.stream()
            .filter(ParkingLot::existEmptyParking)
            .findFirst()
            .orElseThrow(ParkingFailureException::new)
            .park(car);
    }

    public Car pickUp(final Ticket ticket) {
        return parkingLots.stream()
            .filter(parkingLot -> parkingLot.contains(ticket))
            .findAny()
            .orElseThrow(PickUpFailureException::new)
            .pickUp(ticket);
    }
}
