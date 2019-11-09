package club.oobootcamp.parkingboy;

import club.oobootcamp.parkinglot.Car;
import club.oobootcamp.parkinglot.ParkingLot;
import club.oobootcamp.parkinglot.Ticket;

import java.util.List;

public class SuperParkingBoy extends AbstractParkingBoy {
    public SuperParkingBoy(final List<ParkingLot> parkingLots) {
        super(parkingLots);
    }

    @Override
    public Ticket park(final Car car) {
        Ticket ticket = new Ticket();
        if (parkingLots.size() >= 2) {
            ParkingLot firstParkingLot = parkingLots.get(0);
            ParkingLot secondParkingLot = parkingLots.get(1);
            if (firstParkingLot.getVacancyRate() > secondParkingLot.getVacancyRate()) {
                ticket = firstParkingLot.park(car);
            }
        }
        return ticket;
    }
}
