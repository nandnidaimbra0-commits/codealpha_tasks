import java.util.Scanner;

class HotelRoom {
    int roomNumber;
    String category;
    boolean isAvailable;
    double price;

    public HotelRoom(int roomNumber, String category, double price) {
        this.roomNumber = roomNumber;
        this.category = category;
        this.price = price;
        this.isAvailable = true;
    }
}

public class HotelReservationSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Simple setup matching your worksheet categorization rule
        HotelRoom[] rooms = {
                new HotelRoom(101, "Standard", 50.0),
                new HotelRoom(201, "Deluxe", 100.0),
                new HotelRoom(301, "Suite", 250.0)
        };

        while (true) {
            System.out.println("\n===== Hotel Reservation System =====");
            System.out.println("1. Search Available Rooms & Categories");
            System.out.println("2. Make a Reservation & Pay");
            System.out.println("3. Cancel Reservation");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice = sc.nextInt();
            if (choice == 4) break;

            if (choice == 1) {
                System.out.println("\n--- Room Categories & Status ---");
                for (int i = 0; i < rooms.length; i++) {
                    String status = rooms[i].isAvailable ? "Available" : "Booked";
                    System.out.println("Room " + rooms[i].roomNumber + " [" + rooms[i].category + "] - $" + rooms[i].price + "/night - " + status);
                }
            }
            else if (choice == 2) {
                System.out.print("Enter room index to book (0 for Standard, 1 for Deluxe, 2 for Suite): ");
                int index = sc.nextInt();
                if (index < 0 || index >= rooms.length) {
                    System.out.println("Invalid Room Selection.");
                    continue;
                }

                if (!rooms[index].isAvailable) {
                    System.out.println("This room is already reserved.");
                } else {
                    System.out.println("Total Cost is: $" + rooms[index].price);
                    System.out.println("Simulating Secure Payment Processing... [SUCCESS]");
                    rooms[index].isAvailable = false;
                    System.out.println("Booking finalized for Room " + rooms[index].roomNumber);
                }
            }
            else if (choice == 3) {
                System.out.print("Enter room index to cancel (0, 1, or 2): ");
                int index = sc.nextInt();
                if (index >= 0 && index < rooms.length && !rooms[index].isAvailable) {
                    rooms[index].isAvailable = true;
                    System.out.println("Reservation for Room " + rooms[index].roomNumber + " has been canceled successfully.");
                } else {
                    System.out.println("Invalid operation. Room is either not booked or doesn't exist.");
                }
            }
        }
        System.out.println("=========================");
        System.out.println("Status: Completed");
        sc.close();
    }
}
