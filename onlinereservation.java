import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Train {
    private String trainNumber;
    private String trainName;
    private int totalSeats;
    private int seatsBooked;

    public Train(String trainNumber, String trainName, int totalSeats) {
        this.trainNumber = trainNumber;
        this.trainName = trainName;
        this.totalSeats = totalSeats;
        this.seatsBooked = 0;
    }

    public String getTrainNumber() {
        return trainNumber;
    }

    public String getTrainName() {
        return trainName;
    }

    public int getTotalSeats() {
        return totalSeats;
    }

    public int getSeatsBooked() {
        return seatsBooked;
    }

    public void bookSeats(int numSeats) {
        if (seatsBooked + numSeats <= totalSeats) {
            seatsBooked += numSeats;
            System.out.println(numSeats + " seats booked successfully for train " + trainNumber);
        } else {
            System.out.println("Sorry, requested number of seats not available for train " + trainNumber);
        }
    }
}

class ReservationSystem {
    private List<Train> trains;

    public ReservationSystem() {
        trains = new ArrayList<>();
    }

    public void addTrain(Train train) {
        trains.add(train);
    }

    public Train getTrainByNumber(String trainNumber) {
        for (Train train : trains) {
            if (train.getTrainNumber().equals(trainNumber)) {
                return train;
            }
        }
        return null;
    }
}




public class onlinereservation {
    public static void main(String[] args) {
        ReservationSystem reservationSystem = new ReservationSystem();

        // Creating sample trains
        Train train1 = new Train("12345", "Express Train", 100);
        Train train2 = new Train("54321", "Superfast Train", 150);

        reservationSystem.addTrain(train1);
        reservationSystem.addTrain(train2);

        // User interaction
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("==== Online Train Reservation System ====");
            System.out.println("1. Book Seats");
            System.out.println("2. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter train number: ");
                    String trainNumber = scanner.next();
                    Train train = reservationSystem.getTrainByNumber(trainNumber);
                    if (train != null) {
                        System.out.print("Enter number of seats to book: ");
                        int numSeats = scanner.nextInt();
                        train.bookSeats(numSeats);
                    } else {
                        System.out.println("Train not found!");
                    }
                    break;
                case 2:
                    running = false;
                    System.out.println("Thank you for using the Online Train Reservation System!");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
            System.out.println();
        }
        scanner.close();
    }
}
