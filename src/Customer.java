import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String name;

    private List<Rental> rentals = new ArrayList<Rental>();

    public Customer(String name) {
        this.setName(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Rental> getRentals() {
        return rentals;
    }

    public void setRentals(List<Rental> rentals) {
        this.rentals = rentals;
    }

    public void addRental(Rental rental) {
        rentals.add(rental);
    }
	public void clearRental() {
		List<Rental> rentals = new ArrayList<Rental>() ;
		setRentals(rentals);
	}

	public void customerSummary() {
            System.out.println("Name: " + getName() +
                    "\tRentals: " + getRentals().size()) ;
            for ( Rental rental: getRentals() ) {
                System.out.print("\tTitle: " + rental.getVideo().getTitle() + " ") ;
                System.out.print("\tPrice Code: " + rental.getVideo().getPriceCode()) ;
            }
	}
}
