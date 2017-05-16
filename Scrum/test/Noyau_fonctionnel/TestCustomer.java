package Noyau_fonctionnel;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import scrum.noyau.Customer2;
import scrum.noyau.Order;

public class TestCustomer {

    private Customer2 customer;

    @Before
    public void setUp() {
        customer = new Customer2("nom", "ville");
    }

    /**
     * S'execute apres les test (pas utile ici)
     */
    @After
    public void tearDown() {
    }

    /**
     * Permet de tester l'ajout d'un order
     */
    @Test
    public void testAddOrder() {
        Order newOrder = new Order(customer);
        customer.addOrder(newOrder);
        assertEquals(true, customer.getOrders().contains(newOrder));
    }

    /**
     * Permet de tester un ajout duliqué d'un order pour un customer
     */
    @Test
    public void testAddOrderBad() {
        Order newOrder = new Order(customer);
        customer.addOrder(newOrder);
        assertEquals(true, customer.getOrders().contains(newOrder));
        customer.addOrder(newOrder);
    }
}
