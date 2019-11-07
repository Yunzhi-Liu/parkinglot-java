package club.oobootcamp.parkingboy;

import club.oobootcamp.parkinglot.Car;
import club.oobootcamp.parkinglot.ParkingFailureException;
import club.oobootcamp.parkinglot.ParkingLot;
import club.oobootcamp.parkinglot.Ticket;

import java.util.List;

public class GraduateParkingBoy extends AbstractParkingBoy {

    public GraduateParkingBoy(final List<ParkingLot> parkingLots) {
        super(parkingLots);
    }

    @Override
    public Ticket park(final Car car) {
        return parkingLots.stream()
            .filter(ParkingLot::existEmptyParking)
            .findFirst()
            .orElseThrow(ParkingFailureException::new)
            .park(car);
    }

}
