import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {

    @Test
    void getName() {
        Customer customer = new Customer("AA");
        customer.getName();
        assertEquals("AA", customer.getName());
    }

    @Test
    void setName() {
        Customer customer = new Customer("AA");
        customer.setName("BB");
        customer.getName();
        assertEquals("BB", customer.getName());
    }

    @Test
    void getRentals() {
        Customer customer = new Customer("AA");
        customer.setName("BB");
        customer.getName();
        assertEquals("BB", customer.getName());
    }

    @Test
    void setgetRentals() {
        Customer customer = new Customer("AA");
        List<Rental> testRentals = new ArrayList<Rental>() ;

        Video v1 = new Video("v1", Video.CD, Video.REGULAR, new Date()) ;
        Video v2 = new Video("v2", Video.DVD, Video.NEW_RELEASE, new Date()) ;
        Rental r1 = new Rental(v1) ;
        Rental r2 = new Rental(v2) ;
        testRentals.add (r1);
        testRentals.add (r2);
        customer.setRentals(testRentals);

        assertEquals(testRentals, customer.getRentals());
    }

    @Test
    void addgetRental() {
        Customer customer = new Customer("AA");

        Video v1 = new Video("v1", Video.CD, Video.REGULAR, new Date()) ;
        Video v2 = new Video("v2", Video.DVD, Video.NEW_RELEASE, new Date()) ;
        Rental r1 = new Rental(v1) ;
        Rental r2 = new Rental(v2) ;
        customer.addRental(r1);
        customer.addRental(r2);

        assertEquals(r1, customer.getRentals().get(0));
        assertEquals(r2, customer.getRentals().get(1));
    }

}