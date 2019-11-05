package club.oobootcamp.parkinglot;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ParkingLotTest {

    @Test
    void given_one_parking_lot_with_one_space_when_parking_one_car_then_return_one_ticket() {
        final Car car = new Car();
        final ParkingLot parkingLot = new ParkingLot(1);

        final Ticket ticket = parkingLot.park(car);

        assertThat(ticket).isNotNull();
    }
}
