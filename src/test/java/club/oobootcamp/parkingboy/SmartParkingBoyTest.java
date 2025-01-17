package club.oobootcamp.parkingboy;

import club.oobootcamp.parkinglot.Car;
import club.oobootcamp.parkinglot.ParkingFailureException;
import club.oobootcamp.parkinglot.ParkingLot;
import club.oobootcamp.parkinglot.PickUpFailureException;
import club.oobootcamp.parkinglot.Ticket;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class SmartParkingBoyTest {
    @Test
    void given_one_parking_lot_with_one_space_when_parking_one_car_then_return_one_ticket() {
        final ParkingLot parkingLot = new ParkingLot(1);
        final List<ParkingLot> parkingLots = Collections.singletonList(parkingLot);
        final SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLots);

        final Ticket ticket = smartParkingBoy.park(new Car());

        assertThat(ticket).isNotNull();
    }

    @Test
    void given_two_parking_lots_that_the_first_empty_space_is_more_than_the_second_when_parking_one_car_then_the_car_parked_in_the_first_parking_lot() {
        final Car car = new Car();
        final ParkingLot parkingLot1 = new ParkingLot(2);
        final ParkingLot parkingLot2 = new ParkingLot(1);
        final List<ParkingLot> parkingLots = Arrays.asList(parkingLot1, parkingLot2);
        final SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLots);

        final Ticket ticket = smartParkingBoy.park(car);

        assertThat(parkingLot1.contains(ticket)).isTrue();
    }

    @Test
    void given_two_parking_lots_that_the_second_empty_space_is_more_than_the_first_when_parking_one_car_then_the_car_parked_in_the_second_parking_lot() {
        final Car car = new Car();
        final ParkingLot parkingLot1 = new ParkingLot(1);
        final ParkingLot parkingLot2 = new ParkingLot(2);
        final List<ParkingLot> parkingLots = Arrays.asList(parkingLot1, parkingLot2);
        final SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLots);

        final Ticket ticket = smartParkingBoy.park(car);

        assertThat(parkingLot2.contains(ticket)).isTrue();
    }

    @Test
    void given_two_same_parking_lots_with_two_space_when_parking_four_cars_then_the_cars_alternately_parked_in_two_parking_lot() {
        final Car car1 = new Car();
        final Car car2 = new Car();
        final Car car3 = new Car();
        final Car car4 = new Car();
        final ParkingLot parkingLot1 = new ParkingLot(2);
        final ParkingLot parkingLot2 = new ParkingLot(2);
        final List<ParkingLot> parkingLots = Arrays.asList(parkingLot1, parkingLot2);
        final SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLots);

        final Ticket ticket1 = smartParkingBoy.park(car1);
        final Ticket ticket2 = smartParkingBoy.park(car2);
        final Ticket ticket3 = smartParkingBoy.park(car3);
        final Ticket ticket4 = smartParkingBoy.park(car4);

        assertThat(parkingLot1.contains(ticket1)).isTrue();
        assertThat(parkingLot2.contains(ticket2)).isTrue();
        assertThat(parkingLot1.contains(ticket3)).isTrue();
        assertThat(parkingLot2.contains(ticket4)).isTrue();
    }

    @Test
    void given_two_parking_lots_that_are_filled_when_parking_a_car_then_failure() {
        final ParkingLot parkingLot1 = new ParkingLot(0);
        final ParkingLot parkingLot2 = new ParkingLot(0);
        List<ParkingLot> parkingLots = Arrays.asList(parkingLot1, parkingLot2);
        final SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLots);

        assertThatThrownBy(() -> smartParkingBoy.park(new Car()))
            .isInstanceOf(ParkingFailureException.class);
    }

    @Test
    void given_a_parking_lot_that_only_parked_my_car_when_picking_up_a_car_using_my_ticket_then_return_my_car() {
        final Car myCar = new Car();
        final ParkingLot parkingLot = new ParkingLot(1);
        final Ticket myTicket = parkingLot.park(myCar);
        final List<ParkingLot> parkingLots = Collections.singletonList(parkingLot);
        final SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLots);

        final Car actualCar = smartParkingBoy.pickUp(myTicket);

        assertThat(actualCar).isEqualTo(myCar);
    }

    @Test
    void given_two_parking_lots_parked_with_lots_of_cars_while_the_second_parking_lot_includes_my_car_when_picking_up_a_car_using_my_ticket_then_return_my_car() {
        final ParkingLot parkingLot1 = new ParkingLot(1);
        parkingLot1.park(new Car());
        final Car myCar = new Car();
        final ParkingLot parkingLot2 = new ParkingLot(1);
        final Ticket myTicket = parkingLot2.park(myCar);
        final List<ParkingLot> parkingLots = Arrays.asList(parkingLot1, parkingLot2);
        final SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLots);

        Car actualCar = smartParkingBoy.pickUp(myTicket);

        assertThat(actualCar).isEqualTo(myCar);
    }

    @Test
    void given_a_parking_lot_that_parked_my_car_when_picking_up_a_car_using_an_illegal_ticket_then_failure() {
        final Car myCar = new Car();
        final ParkingLot parkingLot = new ParkingLot(2);
        parkingLot.park(myCar);
        final List<ParkingLot> parkingLots = Collections.singletonList(parkingLot);
        final SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLots);

        assertThatThrownBy(() -> smartParkingBoy.pickUp(new Ticket()))
            .isInstanceOf(PickUpFailureException.class);
    }

    @Test
    void given_a_parking_lot_that_parked_my_car_when_picking_up_a_car_twice_using_one_ticket_then_the_second_failure() {
        final Car myCar = new Car();
        final ParkingLot parkingLot = new ParkingLot(1);
        final Ticket myTicket = parkingLot.park(myCar);
        parkingLot.pickUp(myTicket);
        final List<ParkingLot> parkingLots = Collections.singletonList(parkingLot);
        final SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLots);

        assertThatThrownBy(() -> smartParkingBoy.pickUp(myTicket))
            .isInstanceOf(PickUpFailureException.class);
    }
}
