package club.oobootcamp.parkingboy;

import club.oobootcamp.parkinglot.Car;
import club.oobootcamp.parkinglot.ParkingLot;
import club.oobootcamp.parkinglot.Ticket;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
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
}
