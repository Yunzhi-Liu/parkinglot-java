package club.oobootcamp.parkingboy;

import club.oobootcamp.parkinglot.Car;
import club.oobootcamp.parkinglot.ParkingLot;
import club.oobootcamp.parkinglot.Ticket;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class SuperParkingBoy extends AbstractParkingBoy {
    public SuperParkingBoy(final List<ParkingLot> parkingLots) {
        super(parkingLots);
    }

    @Override
    public Ticket park(final Car car) {
        Optional<ParkingLot> maxVacancyRate = parkingLots.stream()
            .max(Comparator.comparing(ParkingLot::getVacancyRate));
        Ticket ticket = null;
        if (maxVacancyRate.isPresent()) {
            ticket = maxVacancyRate.get().park(car);
        }
        return ticket;
    }
}
