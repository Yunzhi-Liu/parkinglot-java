package club.oobootcamp.parkingboy;

import club.oobootcamp.parkinglot.Car;
import club.oobootcamp.parkinglot.ParkingLot;
import club.oobootcamp.parkinglot.Ticket;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

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
}
