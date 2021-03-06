import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class VRUIManager {

    private List<Customer> customers = new ArrayList<Customer>() ;
    private List<Video> videos = new ArrayList<Video>() ;
    private VideoSystem videoSystem = new VideoSystem();

    public void clearRentals(String customerName) {

        // Duplication
        Customer foundCustomer = getCustomer(customerName);

        if ( foundCustomer == null ) {
            System.out.println("No customer found") ;
        } else {
	    foundCustomer.customerSummary();

            foundCustomer.clearRental();
        }
    }

    private Customer getCustomer(String customerName) {
        Customer foundCustomer = null;
        for (Customer customer : customers) {
            if (customer.getName().equals(customerName)) {
                foundCustomer = customer;
                break;
            }
        }
        return foundCustomer;
    }

    public void returnVideo(String customerName, String videoTitle) {


        Customer foundCustomer = getCustomer(customerName);
        if ( foundCustomer == null ) return ;


        List<Rental> customerRentals = foundCustomer.getRentals() ;
        for ( Rental rental: customerRentals ) {
            if ( rental.getVideo().getTitle().equals(videoTitle) && rental.getVideo().isRented() ) {
                rental.returnVideo();
                rental.getVideo().setRented(false);
                break ;
            }
        }
    }

    public void init() {
        Customer james = new Customer("James") ;
        Customer brown = new Customer("Brown") ;
        customers.add(james) ;
        customers.add(brown) ;

        Video v1 = registerVideo("v1", VideoType.VHS.ordinal(), PriceCode.REGULAR.ordinal()) ;
        Video v2 = registerVideo("v2", VideoType.DVD.ordinal(), PriceCode.NEW_RELEASE.ordinal() ) ;

        Rental r1 = new Rental(v1) ;
        Rental r2 = new Rental(v2) ;

   //     james.addRental(r1) ;
   //     james.addRental(r2) ;
    }

    public void listVideos() {

        for ( Video video: videos ) {
            System.out.println("Price code: " + video.getPriceCode() +"\tTitle: " + video.getTitle()) ;
        }
        System.out.println("End of list");
    }

    public void listCustomers() {
        for ( Customer customer: customers ) {
		customer.customerSummary();
        }
        System.out.println("End of list");
    }

    public void getCustomerReport(String customerName) {

        Customer foundCustomer = getCustomer(customerName);

        if ( foundCustomer == null ) {
            System.out.println("No customer found") ;
        } else {
            ReportGenerator genReport = new ReportGenerator(foundCustomer);
            String result = genReport.getReport() ;
            System.out.println(result);
        }
    }

    public void rentVideo(String customerName, String videoTitle ) {


        Customer foundCustomer = getCustomer(customerName);

        if ( foundCustomer == null ) return ;

        Video foundVideo = null ;
        for ( Video video: videos ) {
            if ( video.getTitle().equals(videoTitle) && video.isRented() == false ) {
                foundVideo = video ;
                break ;
            }
        }

        if ( foundVideo == null ) return ;

        Rental rental = new Rental(foundVideo) ;
        foundVideo.setRented(true);

        foundCustomer.addRental(rental);
    }

    // SRP violation

    public void registerCustomer(String customerName ) {
        Customer customer = new Customer(customerName) ;
        customers.add(customer) ;
    }

    public Video registerVideo(String title, int videoType, int priceCode) {
        Video video = videoSystem.createVideo(title, videoType, priceCode);
        videos.add(video) ;
        return video;
    }
}
