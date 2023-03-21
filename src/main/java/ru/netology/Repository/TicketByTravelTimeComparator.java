package ru.netology.Repository;

import ru.netology.Repository.Ticket;

import java.util.Comparator;

public class TicketByTravelTimeComparator implements Comparator<Ticket> {
    @Override
    public int compare(Ticket o1, Ticket o2) {
        return (o1.getTravelTime() - o2.getTravelTime());
    }

}
