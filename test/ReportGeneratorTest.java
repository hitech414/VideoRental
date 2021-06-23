import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ReportGeneratorTest {

    @Test
    void getReport() {
        Customer customer = new Customer("AA");

        VideoSystem videoSystem = new VideoSystem();
        Video v1 = videoSystem.createVideo("v1", 0, 0);
        Video v2 = videoSystem.createVideo("v2", 1, 1);
        Video v3 = videoSystem.createVideo("v3", 2, 1);
        Rental r1 = new Rental(v1);
        Rental r2 = new Rental(v2);
        Rental r3 = new Rental(v3);
        r3.returnVideo();
        customer.addRental(r1);
        customer.addRental(r2);
        customer.addRental(r3);

        String correctAnswer = "Customer Report for AA\n\tv1\tDays rented: 1\tCharge: 2.0\tPoint: 0\n\tv2\tDays rented: 1\tCharge: 3.0\tPoint: 0\n\tv3\tDays rented: 1\tCharge: 3.0\tPoint: 0\nTotal charge: 8.0\tTotal Point:0\n";
        ReportGenerator RGenerator = new ReportGenerator(customer);

        System.out.println(correctAnswer);
        System.out.println(RGenerator.getReport());
        assertEquals(correctAnswer, RGenerator.getReport());
    }
}