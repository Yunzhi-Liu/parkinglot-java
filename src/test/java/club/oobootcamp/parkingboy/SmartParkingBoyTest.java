package club.oobootcamp.parkingboy;

import club.oobootcamp.parkinglot.Car;
import club.oobootcamp.parkinglot.ParkingLot;
import club.oobootcamp.parkinglot.Ticket;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class SmartParkingBoyTest {
    @Test
    void given_one_parking_lot_with_one_space_when_parking_one_car_then_return_one_ticket() {
        final ParkingLot parkingLot = new ParkingLot(1);
        final List<ParkingLot> parkingLots = Collections.singletonList(parkingLot);
        final SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLots);

        final Ticket ticket = smartParkingBoy.park(new Car());

        assertThat(ticket).isNotNull();
    }
}
