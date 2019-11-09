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

class SuperParkingBoyTest {

    @Test
    void given_one_parking_lot_with_one_space_when_parking_one_car_then_return_one_ticket() {
        final Car car = new Car();
        final List<ParkingLot> parkingLots = Collections.singletonList(new ParkingLot(1));
        final SuperParkingBoy superParkingBoy = new SuperParkingBoy(parkingLots);

        final Ticket ticket = superParkingBoy.park(car);

        assertThat(ticket).isNotNull();
    }

    @Test
    void given_two_parking_lots_that_the_first_vacancy_rate_is_higher_than_the_second_one_when_parking_one_car_then_parked_in_the_first_one() {
        final ParkingLot parkingLot1 = new ParkingLot(10);
        parkingLot1.park(new Car());
        final ParkingLot parkingLot2 = new ParkingLot(5);
        parkingLot2.park(new Car());
        final SuperParkingBoy superParkingBoy = new SuperParkingBoy(Arrays.asList(parkingLot1, parkingLot2));

        final Ticket ticket = superParkingBoy.park(new Car());

        assertThat(parkingLot1.contains(ticket)).isTrue();
    }

    @Test
    void given_two_parking_lots_that_the_second_vacancy_rate_is_higher_than_the_first_one_when_parking_one_car_then_parked_in_the_second_one() {
        final ParkingLot parkingLot1 = new ParkingLot(5);
        parkingLot1.park(new Car());
        final ParkingLot parkingLot2 = new ParkingLot(10);
        parkingLot2.park(new Car());
        final SuperParkingBoy superParkingBoy = new SuperParkingBoy(Arrays.asList(parkingLot1, parkingLot2));

        final Ticket ticket = superParkingBoy.park(new Car());

        assertThat(parkingLot2.contains(ticket)).isTrue();
    }

    @Test
    void given_two_parking_lots_with_the_same_vacancy_rate_when_parking_one_car_then_parked_in_the_first_one() {
        final ParkingLot parkingLot1 = new ParkingLot(5);
        parkingLot1.park(new Car());
        final ParkingLot parkingLot2 = new ParkingLot(5);
        parkingLot2.park(new Car());
        final SuperParkingBoy superParkingBoy = new SuperParkingBoy(Arrays.asList(parkingLot1, parkingLot2));

        final Ticket ticket = superParkingBoy.park(new Car());

        assertThat(parkingLot1.contains(ticket)).isTrue();
    }

    @Test
    void given_three_parking_lots_that_the_third_is_the_highest_vacancy_rate_when_parking_one_car_then_parked_in_the_third_one() {
        final ParkingLot parkingLot1 = new ParkingLot(5);
        parkingLot1.park(new Car());
        final ParkingLot parkingLot2 = new ParkingLot(10);
        parkingLot2.park(new Car());
        final ParkingLot parkingLot3 = new ParkingLot(20);
        parkingLot3.park(new Car());
        List<ParkingLot> parkingLots = Arrays.asList(parkingLot1, parkingLot2, parkingLot3);
        final SuperParkingBoy superParkingBoy = new SuperParkingBoy(parkingLots);

        final Ticket ticket = superParkingBoy.park(new Car());

        assertThat(parkingLot3.contains(ticket)).isTrue();
    }

    @Test
    void given_zero_parking_lot_when_parking_a_car_then_parked_failure() {
        final SuperParkingBoy superParkingBoy = new SuperParkingBoy(Collections.emptyList());

        assertThatThrownBy(() -> superParkingBoy.park(new Car()))
            .isInstanceOf(ParkingFailureException.class);
    }

    @Test
    void given_two_parking_lots_that_are_filled_when_parking_a_car_then_failure() {
        final ParkingLot parkingLot1 = new ParkingLot(0);
        final ParkingLot parkingLot2 = new ParkingLot(0);
        List<ParkingLot> parkingLots = Arrays.asList(parkingLot1, parkingLot2);
        final SuperParkingBoy superParkingBoy = new SuperParkingBoy(parkingLots);

        assertThatThrownBy(() -> superParkingBoy.park(new Car()))
            .isInstanceOf(ParkingFailureException.class);
    }
}
