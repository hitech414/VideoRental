import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

//SRP violation - Domain Logic + Presentation
public class VRUI {
	private static Scanner scanner = new Scanner(System.in) ;

	private static VRUIManager uiManager = new VRUIManager();

	public static void main(String[] args) {
		VRUI ui = new VRUI() ;

		boolean quit = false ;
		while ( ! quit ) {
			int command = ui.showCommand() ;
			switch ( command ) {
				case 0: quit = true ; break ;
				case 1: ui.listCustomers() ; break ;
				case 2: ui.listVideos() ; break ;
				case 3: ui.registerCustomer() ; ; break ;
				case 4: ui.registerVideo() ; break ;
				case 5: ui.rentVideo() ; break ;
				case 6: ui.returnVideo() ; break ;
				case 7: ui.getCustomerReport() ; break;
				case 8: ui.clearRentals() ; break ;
				case -1: ui.init() ; break ;
				default: break ;
			}
		}
		System.out.println("Bye");
	}

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

		this.uiManager.returnVideo(customerName, videoTitle);
	}

	private void init() {
		this.uiManager.init();
	}

	public void listVideos() {
		System.out.println("List of videos");

		this.uiManager.listVideos();
	}

	public void listCustomers() {
		System.out.println("List of customers");

		this.uiManager.listCustomers();
	}

	public void getCustomerReport() {
		System.out.println("Enter customer name: ") ;
		String customerName = scanner.next() ;

		Customer foundCustomer = null ;
		for ( Customer customer: customers ) {
			if ( customer.getName().equals(customerName)) {
				foundCustomer = customer ;
				break ;
			}
		}

	}

	public void rentVideo() {
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
		this.uiManager.rentVideo(customerName, videoTitle);
	}

  // SRP violation
	public void registerCustomer() {
		System.out.println("Enter customer name: ") ;
		String name = scanner.next();

		this.uiManager.registerCustomer(name);
	}
	public void registerVideo() {
		System.out.println("Enter video title to register: ") ;
		String title = scanner.next() ;

		System.out.println("Enter video type( 1 for VHD, 2 for CD, 3 for DVD ):") ;
		int videoType = scanner.nextInt();

		System.out.println("Enter price code( 1 for Regular, 2 for New Release ):") ;
		int priceCode = scanner.nextInt();

		this.uiManager.registerVideo(title, videoType, priceCode);
	}
	public int showCommand() {
		System.out.println("\nSelect a command !");
		System.out.println("\t 0. Quit");
		System.out.println("\t 1. List customers");
		System.out.println("\t 2. List videos");
		System.out.println("\t 3. Register customer");
		System.out.println("\t 4. Register video");
		System.out.println("\t 5. Rent video");
		System.out.println("\t 6. Return video");
		System.out.println("\t 7. Show customer report");
		System.out.println("\t 8. Show customer and clear rentals");

		int command = scanner.nextInt() ;

		return command ;

	}
}
