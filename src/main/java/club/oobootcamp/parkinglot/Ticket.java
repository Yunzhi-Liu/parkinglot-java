package club.oobootcamp.parkinglot;

import java.util.UUID;

public class Ticket {

    private final UUID id;

    public Ticket() {
        this.id = UUID.randomUUID();
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Ticket)) {
            return false;
        }
        final Ticket ticket = (Ticket) o;

        return id.equals(ticket.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
