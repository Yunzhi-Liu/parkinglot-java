package club.oobootcamp.parkingboy;

import club.oobootcamp.parkinglot.Car;
import club.oobootcamp.parkinglot.ParkingLot;
import club.oobootcamp.parkinglot.Ticket;

import java.util.List;

public class GraduateParkingBoy {
    private final List<ParkingLot> parkingLots;

    public GraduateParkingBoy(final List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    public Ticket park(final Car car) {
        return parkingLots.get(0).park(car);
    }
}
