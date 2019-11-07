package club.oobootcamp.parkingboy;

import club.oobootcamp.parkinglot.Car;
import club.oobootcamp.parkinglot.ParkingFailureException;
import club.oobootcamp.parkinglot.ParkingLot;
import club.oobootcamp.parkinglot.Ticket;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class GraduateParkingBoyTest {

    @Test
    void given_one_parking_lot_with_one_space_when_parking_one_car_then_return_one_ticket() {
        final ParkingLot parkingLot = new ParkingLot(1);
        final List<ParkingLot> parkingLots = Collections.singletonList(parkingLot);
        final GraduateParkingBoy graduateParkingBoy = new GraduateParkingBoy(parkingLots);

        final Ticket ticket = graduateParkingBoy.park(new Car());

        assertThat(ticket).isNotNull();
    }

    @Test
    void given_two_parking_lots_with_enough_spaces_when_parking_two_cars_then_both_cars_parked_in_the_first_parking_lot() {
        final Car car1 = new Car();
        final Car car2 = new Car();
        final ParkingLot parkingLot1 = new ParkingLot(10);
        final ParkingLot parkingLot2 = new ParkingLot(10);
        final List<ParkingLot> parkingLots = Arrays.asList(parkingLot1, parkingLot2);
        GraduateParkingBoy graduateParkingBoy = new GraduateParkingBoy(parkingLots);

        final Ticket ticket1 = graduateParkingBoy.park(car1);
        final Ticket ticket2 = graduateParkingBoy.park(car2);

        assertThat(parkingLot1.pickUp(ticket1)).isEqualTo(car1);
        assertThat(parkingLot1.pickUp(ticket2)).isEqualTo(car2);
    }

    @Test
    void given_two_parking_lots_with_few_spaces_when_parking_two_cars_then_the_first_car_parked_in_the_first_parking_lot_and_the_second_car_parked_in_the_second_parking_lot() {
        final Car car1 = new Car();
        final Car car2 = new Car();
        final ParkingLot parkingLot1 = new ParkingLot(1);
        final ParkingLot parkingLot2 = new ParkingLot(1);
        List<ParkingLot> parkingLots = Arrays.asList(parkingLot1, parkingLot2);
        final GraduateParkingBoy graduateParkingBoy = new GraduateParkingBoy(parkingLots);

        final Ticket ticket1 = graduateParkingBoy.park(car1);
        final Ticket ticket2 = graduateParkingBoy.park(car2);

        assertThat(parkingLot1.pickUp(ticket1)).isEqualTo(car1);
        assertThat(parkingLot2.pickUp(ticket2)).isEqualTo(car2);
    }

    @Test
    void given_two_parking_lots_that_the_first_is_filled_and_the_second_is_empty_when_parking_two_cars_then_both_cars_parked_in_the_second_parking_lot() {
        final Car car1 = new Car();
        final Car car2 = new Car();
        final ParkingLot parkingLot1 = new ParkingLot(0);
        final ParkingLot parkingLot2 = new ParkingLot(10);
        List<ParkingLot> parkingLots = Arrays.asList(parkingLot1, parkingLot2);
        final GraduateParkingBoy graduateParkingBoy = new GraduateParkingBoy(parkingLots);

        final Ticket ticket1 = graduateParkingBoy.park(car1);
        final Ticket ticket2 = graduateParkingBoy.park(car2);

        assertThat(parkingLot2.pickUp(ticket1)).isEqualTo(car1);
        assertThat(parkingLot2.pickUp(ticket2)).isEqualTo(car2);
    }

    @Test
    void given_two_parking_lots_that_are_filled_when_parking_a_car_then_failure() {
        final ParkingLot parkingLot1 = new ParkingLot(0);
        final ParkingLot parkingLot2 = new ParkingLot(0);
        List<ParkingLot> parkingLots = Arrays.asList(parkingLot1, parkingLot2);
        final GraduateParkingBoy graduateParkingBoy = new GraduateParkingBoy(parkingLots);

        assertThatThrownBy(() -> graduateParkingBoy.park(new Car()))
            .isInstanceOf(ParkingFailureException.class);
    }

    @Test
    void given_a_parking_lot_that_only_parked_my_car_when_picking_up_a_car_using_my_ticket_then_return_my_car() {
        final Car myCar = new Car();
        final ParkingLot parkingLot = new ParkingLot(1);
        final Ticket myTicket = parkingLot.park(myCar);
        final List<ParkingLot> parkingLots = Collections.singletonList(parkingLot);
        final GraduateParkingBoy graduateParkingBoy = new GraduateParkingBoy(parkingLots);

        final Car actualCar = graduateParkingBoy.pickUp(myTicket);

        assertThat(actualCar).isEqualTo(myCar);
    }

    @Test
    void given_a_parking_lot_parked_with_lots_of_cars_and_including_my_car_when_picking_up_a_car_using_my_ticket_then_return_my_car() {
        final Car myCar = new Car();
        final ParkingLot parkingLot = new ParkingLot(2);
        parkingLot.park(new Car());
        final Ticket myTicket = parkingLot.park(myCar);
        final List<ParkingLot> parkingLots = Collections.singletonList(parkingLot);
        final GraduateParkingBoy graduateParkingBoy = new GraduateParkingBoy(parkingLots);

        Car actualCar = graduateParkingBoy.pickUp(myTicket);

        assertThat(actualCar).isEqualTo(myCar);
    }
}
