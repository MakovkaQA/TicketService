package ru.netology.Repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RepositoryTest {
    Ticket ticket1 = new Ticket(23, 9_000, "SVO", "OVB", 240);
    Ticket ticket2 = new Ticket(12, 6_500, "DME", "KZN", 90);
    Ticket ticket3 = new Ticket(67, 8_000, "DME", "SVX", 140);

    Repository repo = new Repository();

    @Test
    public void findAllWhenRepositoryIsEmpty() {
        Ticket[] expected = {};
        Ticket[] actual = repo.getTickets();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void findAllWhenRepositoryHas1Ticket() {
        repo.save(ticket1);

        Ticket[] expected = {ticket1};
        Ticket[] actual = repo.getTickets();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void findAllWhenRepositoryHas3Tickets() {
        repo.save(ticket1);
        repo.save(ticket2);
        repo.save(ticket3);

        Ticket[] expected = {ticket1, ticket2, ticket3};
        Ticket[] actual = repo.getTickets();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void saveNewTicket() {
        repo.save(ticket1);

        Ticket[] expected = {ticket1};
        Ticket[] actual = repo.getTickets();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void remoteTicketById() {
        repo.save(ticket1);
        repo.save(ticket2);
        repo.save(ticket3);

        repo.remoteById(12);

        Ticket[] expected = {ticket1, ticket3};
        Ticket[] actual = repo.getTickets();

        Assertions.assertArrayEquals(expected, actual);
    }

}