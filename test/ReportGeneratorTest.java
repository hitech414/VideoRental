import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class ReportGeneratorTest {

    @Test
    void getReport() {
        Customer customer = new Customer("AA");

        Video v1 = new Video("v1", VideoType.CD, PriceCode.REGULAR, new Date()) ;
        Video v2 = new Video("v2", VideoType.DVD, PriceCode.NEW_RELEASE, new Date()) ;
        Video v3 = new Video("v3", VideoType.VHS, PriceCode.NEW_RELEASE, new Date()) ;
        Rental r1 = new Rental(v1) ;
        Rental r2 = new Rental(v2) ;
        Rental r3 = new Rental(v3) ;
        r3.returnVideo();
        customer.addRental(r1);
        customer.addRental(r2);
        customer.addRental(r3);

        String correctAnswer = "Customer Report for AA\n\tv1\tDays rented: 1\tCharge: 2.0\tPoint: 0\n\tv2\tDays rented: 1\tCharge: 3.0\tPoint: 0\n\tv3\tDays rented: 1\tCharge: 3.0\tPoint: 1\nTotal charge: 8.0\tTotal Point:1\n";
        ReportGenerator RGenerator = new ReportGenerator (customer);

        //System.out.println(correctAnswer);
        //System.out.println(RGenerator.getReport());
        assertEquals(correctAnswer, RGenerator.getReport());
    }
}