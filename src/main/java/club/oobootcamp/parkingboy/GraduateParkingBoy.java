package club.oobootcamp.parkingboy;

import club.oobootcamp.parkinglot.Car;
import club.oobootcamp.parkinglot.ParkingLot;
import club.oobootcamp.parkinglot.Ticket;

import java.util.List;
import java.util.Optional;

public class GraduateParkingBoy {
    private final List<ParkingLot> parkingLots;

    public GraduateParkingBoy(final List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    public Ticket park(final Car car) {
        Optional<ParkingLot> availableParkingLot = parkingLots.stream()
            .filter(ParkingLot::existEmptyParking)
            .findFirst();
        Ticket ticket = null;
        if (availableParkingLot.isPresent()) {
            ticket = availableParkingLot.get().park(car);
        }
        return ticket;
    }
}
