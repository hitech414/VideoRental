import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class VRUIManager {

    private List<Customer> customers = new ArrayList<Customer>() ;

    private List<Video> videos = new ArrayList<Video>() ;
    private static Scanner scanner = new Scanner(System.in) ;

    public VRUIManager() { }

    public void clearRentals() {
        System.out.println("Enter customer name: ") ;
        String customerName = scanner.next() ;

        // Duplication
        Customer foundCustomer = null ;
        for ( Customer customer: customers ) {
            if ( customer.getName().equals(customerName)) {
                foundCustomer = customer ;
                break ;
            }
        }

        if ( foundCustomer == null ) {
            System.out.println("No customer found") ;
        } else {
            // SRP : Query + Modifier
            System.out.println("Name: " + foundCustomer.getName() +
                    "\tRentals: " + foundCustomer.getRentals().size()) ;
            for ( Rental rental: foundCustomer.getRentals() ) {
                System.out.print("\tTitle: " + rental.getVideo().getTitle() + " ") ;
                System.out.print("\tPrice Code: " + rental.getVideo().getPriceCode()) ;
            }

            List<Rental> rentals = new ArrayList<Rental>() ;
            foundCustomer.setRentals(rentals);
        }
    }

    public void returnVideo() {
        System.out.println("Enter customer name: ") ;
        String customerName = scanner.next() ;

        Customer foundCustomer = null ;
        for ( Customer customer: customers ) {
            if ( customer.getName().equals(customerName)) {
                foundCustomer = customer ;
                break ;
            }
        }
        if ( foundCustomer == null ) return ;

        System.out.println("Enter video title to return: ") ;
        String videoTitle = scanner.next() ;

        List<Rental> customerRentals = foundCustomer.getRentals() ;
        for ( Rental rental: customerRentals ) {
            if ( rental.getVideo().getTitle().equals(videoTitle) && rental.getVideo().isRented() ) {
                rental.returnVideo();
                rental.getVideo().setRented(false);
                break ;
            }
        }
    }

    void init() {
        Customer james = new Customer("James") ;
        Customer brown = new Customer("Brown") ;
        customers.add(james) ;
        customers.add(brown) ;

        Video v1 = new Video("v1", Video.CD, Video.REGULAR, new Date()) ;
        Video v2 = new Video("v2", Video.DVD, Video.NEW_RELEASE, new Date()) ;
        videos.add(v1) ;
        videos.add(v2) ;

        Rental r1 = new Rental(v1) ;
        Rental r2 = new Rental(v2) ;

        james.addRental(r1) ;
        james.addRental(r2) ;
    }

    public void rentVideo(VRUI vrui) {
        System.out.println("Enter customer name: ") ;
        String customerName = scanner.next() ;

        Customer foundCustomer = null ;
        for ( Customer customer: customers ) {
            if ( customer.getName().equals(customerName)) {
                foundCustomer = customer ;
                break ;
            }
        }

        if ( foundCustomer == null ) return ;

        System.out.println("Enter video title to rent: ") ;
        String videoTitle = scanner.next() ;

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

        // Encapsulate Collection
        List<Rental> customerRentals = foundCustomer.getRentals() ;
        customerRentals.add(rental);
        foundCustomer.setRentals(customerRentals);
    }

    //TODO:
    //registerVideo();
    //registerCutomer();
}
