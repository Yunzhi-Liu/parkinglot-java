package club.oobootcamp.parkingboy;

import club.oobootcamp.parkinglot.Car;
import club.oobootcamp.parkinglot.ParkingFailureException;
import club.oobootcamp.parkinglot.ParkingLot;
import club.oobootcamp.parkinglot.Ticket;

import java.util.Comparator;
import java.util.List;

public class SuperParkingBoy extends AbstractParkingBoy {
    public SuperParkingBoy(final List<ParkingLot> parkingLots) {
        super(parkingLots);
    }

    @Override
    public Ticket park(final Car car) {
        return parkingLots.stream()
            .max(Comparator.comparing(ParkingLot::getVacancyRate))
            .orElseThrow(ParkingFailureException::new)
            .park(car);
    }
}
