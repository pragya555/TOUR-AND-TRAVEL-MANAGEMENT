# TOUR-AND-TRAVEL-MANAGEMENT
import java.sql.*;
import java.util.Scanner;

class TourPackage {
    int id;
    String name;
    String description;
    int duration;
    double cost;

    public TourPackage(int id, String name, String description, int duration, double cost) 
    {
        this.id = id;
        this.name = name;
        this.description = description;
        this.duration = duration;
        this.cost = cost;
    }
}

class Destination 
{
    int id;
    String name;
    String description;
    String attractions;
    public Destination(int id, String name, String description, String attractions) 
    {
        this.id = id;
        this.name = name;
        this.description = description;
        this.attractions = attractions;
    }
}

class Booking
	{
    int id;
    int tourPackageId;
    String customerName;
    String bookingDate;
    String paymentStatus;

    public Booking(int id, int tourPackageId, String customerName, String bookingDate, String paymentStatus) 
    {
        this.id = id;
        this.tourPackageId = tourPackageId;
        this.customerName = customerName;
        this.bookingDate = bookingDate;
        this.paymentStatus = paymentStatus;
    }
}

class Customer 
{
	String contactNumber;  
    String email;
    int id;
    String name;

    public Customer(int id, String name, String contactNumber, String email) 
    {
        this.id = id;
        this.name = name;
        this.contactNumber = contactNumber;
        this.email = email;
    }
}

public class TourAndTravelManagement 
{
    static Connection connection;

    public static void main(String[] args) 
    {
        try 
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql: ");                                                         
            Scanner scanner = new Scanner(System.in);

            while (true) 
            {
                System.out.println("1. Tour Package Management");
                System.out.println("2. Destination Management");
                System.out.println("3. Booking Management");
                System.out.println("4. Customer Management");
                System.out.println("5. Exit");
                System.out.print("Choose an option: ");
                int option = scanner.nextInt();
                scanner.nextLine();                             

                switch (option) {
                	case 1:
                		tourPackageManagement1(scanner);
                        break;
                    case 2:
                    	destinationManagement(scanner);
                        break;
                    case 3:
                         bookingManagement(scanner);
                         break;
                    case 4:
                         customerManagement(scanner);
                         break;
                    case 5:
                         System.exit(0);
                         break;
                    default:
                         System.out.println("// Consume newline left-over");
                         
                         
                    switch (option) {
                    	case 1:
                             tourPackageManagement1(scanner);
                             break;
                         case 2:
                             destinationManagement(scanner);
                             break;
                         case 3:
                             bookingManagement(scanner);
                             break;
                         case 4:
                             customerManagement(scanner);
                             break;
                         case 5:
                             System.exit(0);
                             break;
                         default:
                             System.out.println("Invalid option. Please choose a valid option.");
                     }
                 }
             } 
        }
        
        catch (ClassNotFoundException | SQLException e) {
                 System.out.println("Error: " + e.getMessage());
             }
         }

            private static void customerManagement(Scanner scanner) {
		// TODO Auto-generated method stub
		
	}

			private static void bookingManagement(Scanner scanner) {
		// TODO Auto-generated method stub
		
	}

			private static void destinationManagement(Scanner scanner) {
		// TODO Auto-generated method stub
		
	}

			static void tourPackageManagement1(Scanner scanner) throws SQLException {
                System.out.println("// Tour Package Management");
                }
            static void tourPackageManagement(Scanner scanner) throws SQLException {
                System.out.println("1. Add Tour Package");
                System.out.println("2. Update Tour Package");
                System.out.println("3. Delete Tour Package");
                System.out.println("4. View Tour Packages");
                System.out.print("Choose an option: ");
                int option = scanner.nextInt();
                scanner.nextLine();                             

                switch (option) {
                    case 1:
                        addTourPackage(scanner);
                        break;
                    case 2:
                        updateTourPackage(scanner);
                        break;
                    case 3:
                        deleteTourPackage(scanner);
                        break;
                    case 4:
                        viewTourPackages();
                        break;
                    default:
                        System.out.println("// Consume newline left-over");

                        switch (option) {
                        case 1:
                            addTourPackage(scanner);
                            break;
                        case 2:
                            updateTourPackage(scanner);
                            break;
                        case 3:
                            deleteTourPackage(scanner);
                            break;
                        case 4:
                            viewTourPackages();
                            break;
                        default:
                            System.out.println("Invalid option. Please choose a valid option.");
                    }
                }
                }

                                   
                private static void viewTourPackages() 
                {
				// TODO Auto-generated method stub
				
			}

				private static void deleteTourPackage(Scanner scanner) 
				{
				// TODO Auto-generated method stub
				
			}

				private static void updateTourPackage(Scanner scanner) 
				{
				// TODO Auto-generated method stub
				
			}

				static void addTourPackage(Scanner scanner) throws SQLException 
                {
                    System.out.println("// Add tour package");
                }
                
                static void addTourPackage1(Scanner scanner) throws SQLException 
                {
                    System.out.println("Enter tour package name: ");
                    String name = scanner.nextLine();
                    System.out.println("Enter tour package description: ");

                    String description = scanner.nextLine();
                    System.out.println("Enter tour package duration: ");
                    int duration = scanner.nextInt();
                    scanner.nextLine();                             
                    System.out.print("// Consume newline left-over");
                    System.out.print("Enter tour package cost: ");
                    double cost = scanner.nextDouble();
                    scanner.nextLine();                             

                    PreparedStatement statement = connection.prepareStatement("// Consume newline left-over");

                    PreparedStatement statement1 = connection.prepareStatement("INSERT INTO tour_packages (name, description, duration, cost) VALUES (?, ?, ?, ?)");
                    statement1.setString(1, name);
                    statement1.setString(2, description);
                    statement1.setInt(3, duration);
                    statement1.setDouble(4, cost);
                    statement1.executeUpdate();
                    System.out.println("Tour package added successfully.");
            }
      }
