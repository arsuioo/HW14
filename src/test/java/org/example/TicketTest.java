package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

class TicketTest {
    @Test
    public void testSort() {
        AviaSouls ticket = new AviaSouls();
        Ticket ticket1 = new Ticket("RUS", "UAR", 1000, 10, 21);
        Ticket ticket2 = new Ticket("RUS", "USA", 10000, 1, 14);
        Ticket ticket3 = new Ticket("RUS", "USA", 5000, 4, 23);
        Ticket ticket4 = new Ticket("RUS", "USA", 9000, 6, 15);
        Ticket ticket5 = new Ticket("USA", "RUS", 5100, 5, 24);
        Ticket ticket6 = new Ticket("RUS", "UAR", 700, 12, 23);
        Ticket ticket7 = new Ticket("RUS", "UAR", 7000, 2, 10);
        ticket.add(ticket1);
        ticket.add(ticket2);
        ticket.add(ticket3);
        ticket.add(ticket4);
        ticket.add(ticket5);
        ticket.add(ticket6);
        ticket.add(ticket7);

        Ticket[] actual = ticket.search("RUS", "UAR");
        Ticket[] expected = {ticket6, ticket1, ticket7};
        Assertions.assertArrayEquals(actual, expected);
    }

    @Test
    public void testSortZero() {
        AviaSouls ticket = new AviaSouls();
        Ticket ticket1 = new Ticket("RUS", "UAR", 1000, 10, 21);
        Ticket ticket2 = new Ticket("RUS", "USA", 10000, 1, 14);
        Ticket ticket3 = new Ticket("RUS", "USA", 5000, 4, 23);
        Ticket ticket4 = new Ticket("RUS", "USA", 9000, 6, 15);
        Ticket ticket5 = new Ticket("USA", "RUS", 5100, 5, 24);
        Ticket ticket6 = new Ticket("RUS", "UAR", 700, 12, 23);
        Ticket ticket7 = new Ticket("RUS", "UAR", 7000, 2, 10);
        ticket.add(ticket1);
        ticket.add(ticket2);
        ticket.add(ticket3);
        ticket.add(ticket4);
        ticket.add(ticket5);
        ticket.add(ticket6);
        ticket.add(ticket7);

        Ticket[] actual = ticket.search("RUS", "RUS");
        Ticket[] expected = {};
        Assertions.assertArrayEquals(actual, expected);
    }

    @Test
    public void testSortOne() {
        AviaSouls ticket = new AviaSouls();
        Ticket ticket1 = new Ticket("RUS", "UAR", 1000, 10, 21);
        Ticket ticket2 = new Ticket("RUS", "USA", 10000, 1, 14);
        Ticket ticket3 = new Ticket("RUS", "USA", 5000, 4, 23);
        Ticket ticket4 = new Ticket("RUS", "USA", 9000, 6, 15);
        Ticket ticket5 = new Ticket("USA", "RUS", 5100, 5, 24);
        Ticket ticket6 = new Ticket("RUS", "UAR", 700, 12, 23);
        Ticket ticket7 = new Ticket("RUS", "RUS", 7000, 2, 10);
        ticket.add(ticket1);
        ticket.add(ticket2);
        ticket.add(ticket3);
        ticket.add(ticket4);
        ticket.add(ticket5);
        ticket.add(ticket6);
        ticket.add(ticket7);

        Ticket[] actual = ticket.search("RUS", "RUS");
        Ticket[] expected = {ticket7};
        Assertions.assertArrayEquals(actual, expected);
    }

    @Test
    public void testSortComp() {
        AviaSouls ticket = new AviaSouls();
        Ticket ticket1 = new Ticket("RUS", "UAR", 1000, 10, 21);//11
        Ticket ticket2 = new Ticket("RUS", "USA", 10000, 1, 14);//13
        Ticket ticket3 = new Ticket("RUS", "USA", 5000, 4, 23);//19
        Ticket ticket4 = new Ticket("RUS", "USA", 9000, 6, 15);//9
        Ticket ticket5 = new Ticket("USA", "RUS", 5100, 5, 24);//19
        Ticket ticket6 = new Ticket("RUS", "UAR", 700, 12, 23);//11
        Ticket ticket7 = new Ticket("RUS", "UAR", 7000, 2, 10);//8
        ticket.add(ticket1);
        ticket.add(ticket2);
        ticket.add(ticket3);
        ticket.add(ticket4);
        ticket.add(ticket5);
        ticket.add(ticket6);
        ticket.add(ticket7);
        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] actual = ticket.search("RUS", "UAR", comparator);
        Ticket[] expected = {ticket7, ticket1, ticket6};
        Assertions.assertArrayEquals(actual, expected);
    }

    @Test
    public void testSortZeroComp() {
        AviaSouls ticket = new AviaSouls();
        Ticket ticket1 = new Ticket("RUS", "UAR", 1000, 10, 21);
        Ticket ticket2 = new Ticket("RUS", "USA", 10000, 1, 14);
        Ticket ticket3 = new Ticket("RUS", "USA", 5000, 4, 23);
        Ticket ticket4 = new Ticket("RUS", "USA", 9000, 6, 15);
        Ticket ticket5 = new Ticket("USA", "RUS", 5100, 5, 24);
        Ticket ticket6 = new Ticket("RUS", "UAR", 700, 12, 23);
        Ticket ticket7 = new Ticket("RUS", "UAR", 7000, 2, 10);
        ticket.add(ticket1);
        ticket.add(ticket2);
        ticket.add(ticket3);
        ticket.add(ticket4);
        ticket.add(ticket5);
        ticket.add(ticket6);
        ticket.add(ticket7);
        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] actual = ticket.search("RUS", "RUS", comparator);
        Ticket[] expected = {};
        Assertions.assertArrayEquals(actual, expected);
    }

    @Test
    public void testSortOneComp() {
        AviaSouls ticket = new AviaSouls();
        Ticket ticket1 = new Ticket("RUS", "UAR", 1000, 10, 21);
        Ticket ticket2 = new Ticket("RUS", "USA", 10000, 1, 14);
        Ticket ticket3 = new Ticket("RUS", "USA", 5000, 4, 23);
        Ticket ticket4 = new Ticket("RUS", "USA", 9000, 6, 15);
        Ticket ticket5 = new Ticket("USA", "RUS", 5100, 5, 24);
        Ticket ticket6 = new Ticket("RUS", "UAR", 700, 12, 23);
        Ticket ticket7 = new Ticket("RUS", "RUS", 7000, 2, 10);
        ticket.add(ticket1);
        ticket.add(ticket2);
        ticket.add(ticket3);
        ticket.add(ticket4);
        ticket.add(ticket5);
        ticket.add(ticket6);
        ticket.add(ticket7);
        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] actual = ticket.search("RUS", "RUS", comparator);
        Ticket[] expected = {ticket7};
        Assertions.assertArrayEquals(actual, expected);
    }
}