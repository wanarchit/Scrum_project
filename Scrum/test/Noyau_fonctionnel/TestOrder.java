package Noyau_fonctionnel;

import static org.junit.Assert.assertEquals;

import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import scrum.noyau.Order;
import scrum.noyau.OrderStatus;
import scrum.noyau.Customer2;
import scrum.noyau.Sample;

public class TestOrder {

    private Order order;
    private Customer2 cust;

    @Before
    public void setUp() {
        cust = new Customer2("nom", "ville");
        order = new Order(cust);
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
    public void testInitialisationStatus() {
        assertEquals(OrderStatus.inProgress, order.getStatus());
    }

    /**
     * Permet de tester la modification des samples et la modification du status
     */
    @Test
    public void testSetSamples() {
        List<Sample> samps = null;
        order.setSamples(samps);
        assertEquals(OrderStatus.toAnalyze, order.getStatus());
    }
}
