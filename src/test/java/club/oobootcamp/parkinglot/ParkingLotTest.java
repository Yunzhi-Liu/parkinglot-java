package club.oobootcamp.parkinglot;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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

    @Test
    void given_a_parking_lot_without_space_when_parking_a_cara_then_failure() {
        final Car car = new Car();
        final ParkingLot parkingLot = new ParkingLot(0);

        assertThatThrownBy(() -> parkingLot.park(car))
            .isInstanceOf(ParkingFailureException.class);
    }

    @Test
    void given_a_parking_lot_that_only_parked_my_car_when_picking_up_a_car_using_my_ticket_then_return_my_car() {
        final Car myCar = new Car();
        final ParkingLot parkingLot = new ParkingLot(1);
        Ticket myTicket = parkingLot.park(myCar);

        final Car actualCar = parkingLot.pickUp(myTicket);

        assertThat(actualCar).isEqualTo(myCar);
    }

    @Test
    void given_a_parking_lot_parked_with_lots_of_cars_and_including_my_car_when_picking_up_a_car_using_my_ticket_then_return_my_car() {
        final Car car = new Car();
        final Car myCar = new Car();
        final ParkingLot parkingLot = new ParkingLot(2);
        parkingLot.park(car);
        Ticket myTicket = parkingLot.park(myCar);

        final Car actualCar = parkingLot.pickUp(myTicket);

        assertThat(actualCar).isEqualTo(myCar);
    }

    @Test
    void given_a_parking_lot_that_parked_my_car_when_picking_up_a_car_using_an_illegal_ticket_then_failure() {
        final Car myCar = new Car();
        final ParkingLot parkingLot = new ParkingLot(1);
        parkingLot.park(myCar);

        assertThatThrownBy(() -> parkingLot.pickUp(new Ticket()))
            .isInstanceOf(PickUpFailureException.class);
    }
}
