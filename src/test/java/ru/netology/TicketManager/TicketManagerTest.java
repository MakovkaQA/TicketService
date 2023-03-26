package ru.netology.TicketManager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.Repository.Repository;
import ru.netology.Repository.Ticket;
import ru.netology.Repository.TicketByTravelTimeComparator;

import java.util.Comparator;

public class TicketManagerTest {

    Ticket ticket1 = new Ticket(47, 12_000, "SVO", "IKT", 590);
    Ticket ticket2 = new Ticket(89, 10_500, "SVO", "IKT", 685);
    Ticket ticket3 = new Ticket(67, 8_000, "DME", "SVX", 140);
    Ticket ticket4 = new Ticket(95, 15_000, "SVO", "IKT", 340);
    Ticket ticket5 = new Ticket(36, 9_000, "VKO", "KGD", 150);
    Ticket ticket6 = new Ticket(73, 9_000, "SVO", "IKT", 455);
    Ticket ticket7 = new Ticket(12, 6_500, "DME", "KZN", 90);
    Ticket ticket8 = new Ticket(14, 12_000, "SVO", "IKT", 685);
    Ticket ticket9 = new Ticket(23, 9_000, "SVO", "OVB", 240);

    Repository repo = new Repository();
    TicketManager manager = new TicketManager(repo);
    TicketByTravelTimeComparator comparator = new TicketByTravelTimeComparator();

    @BeforeEach
    public void testPreparation() {
        repo.save(ticket1);
        repo.save(ticket2);
        repo.save(ticket3);
        repo.save(ticket4);
        repo.save(ticket5);
        repo.save(ticket6);
        repo.save(ticket7);
        repo.save(ticket8);
        repo.save(ticket9);
    }

    @Test
    public void found1TicketSortedByPrice() {

        Ticket[] expected = {ticket7};
        Ticket[] actual = manager.findAll("DME", "KZN");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void foundSomeTicketsSortedByPrice() {

        Ticket[] expected = {ticket6, ticket2, ticket1, ticket8, ticket4};
        Ticket[] actual = manager.findAll("SVO", "IKT");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void notFoundTicketsSortedByPrice() {

        Ticket[] expected = {};
        Ticket[] actual = manager.findAll("OVB", "SVX");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void found1TicketSortedByTravelTime() {

        Ticket[] expected = {ticket5};
        Ticket[] actual = manager.findAll("VKO", "KGD", comparator);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void foundSomeTicketsSortedByTravelTime() {

        Ticket[] expected = {ticket4, ticket6, ticket1, ticket2, ticket8};
        Ticket[] actual = manager.findAll("SVO", "IKT", comparator);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void notFoundTicketsSortedByTravelTime() {

        Ticket[] expected = {};
        Ticket[] actual = manager.findAll("KGD", "DME", comparator);

        Assertions.assertArrayEquals(expected, actual);
    }

}