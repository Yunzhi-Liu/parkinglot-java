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

    @Test
    void given_a_parking_lot_with_lots_of_spaces_when_parking_two_cars_then_return_two_tickets() {
        final Car car1 = new Car();
        final Car car2 = new Car();
        final ParkingLot parkingLot = new ParkingLot(2);

        final Ticket ticket1 = parkingLot.park(car1);
        final Ticket ticket2 = parkingLot.park(car2);

        assertThat(ticket1).isNotEqualTo(ticket2);
    }
}
