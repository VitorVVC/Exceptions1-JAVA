package Application;

import Model.Entities.Reservation;
import Model.Exceptions.DomainException;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        DateTimeFormatter dtFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        // Testando o método toString
        /*
        LocalDate checkInTeste = LocalDate.of(2019,9,23);
        LocalDate checkOutTeste = LocalDate.of(2019,9,26);
        Reservation teste = new Reservation(3,checkInTeste,checkOutTeste);
        System.out.println(teste);
         */
        try {
            System.out.print("Room number: ");
            int number = sc.nextInt();
            System.out.print("Check-in date (dd/MM/yyyy): ");
            LocalDate checkIn = LocalDate.from(dtFormatter.parse(sc.next()));
            System.out.print("Check-out date (dd/MM/yyyy): ");
            LocalDate checkOut = LocalDate.from(dtFormatter.parse(sc.next()));

            Reservation reservation = new Reservation(number, checkIn, checkOut);
            System.out.println("Reservation: " + reservation);

            System.out.println("Enter data to update the reservation: ");
            System.out.print("Check-in date (dd/MM/yyyy): ");
            checkIn = LocalDate.from(dtFormatter.parse(sc.next()));
            System.out.print("Check-out date (dd/MM/yyyy): ");
            checkOut = LocalDate.from(dtFormatter.parse(sc.next()));

            reservation.updateDates(checkIn, checkOut);
            System.out.println("Reservation: " + reservation);
        } catch (DomainException e) {
            System.out.println("Error in reservation: " + e.getMessage());
        } catch (RuntimeException e) { // Usamos upcasting pois herancas possuem alem disso herancas e toda excecao que "quebraria nosso progama" apenas retorna um sysout
            System.out.println("Unexcpected error");
        }

        sc.close();

    }
}