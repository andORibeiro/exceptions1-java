package Application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args){

		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
		
		try {
			System.out.print("Room number: ");
			int number = sc.nextInt();
			System.out.print("Check-in date (dd/mm/yyyy): ");
			Date checkIn = sdf.parse(sc.next()); //converte o string capturado pelo scannerno formato de data
			System.out.print("Check-out date (dd/mm/yyyy): ");
			Date checkOut = sdf.parse(sc.next());
			
		
	
			Reservation reservation = new Reservation(number, checkIn, checkOut);
			System.out.println("Reservation: " + reservation);
			
			System.out.println();
			System.out.println("Enter data to update the reservarion:");
			System.out.print("Check-in date (dd/mm/yyyy): ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Check-out date (dd/mm/yyyy): ");
			checkOut = sdf.parse(sc.next());
			
			
			reservation.updateDate(checkIn, checkOut); //Valida atraves da string retornada pelo metodo se deu erro ou nao
			System.out.println("Reservation: " + reservation);

		}catch(ParseException e) {
			System.out.println("Invalid date format");
		}catch(DomainException e) {
			System.out.println("Error in reservation " + e.getMessage()); //Recebe a mensagem vinda da exceção do método na classe reservation
		}catch(RuntimeException e) { //Captura qualquer erro que não seja oque espero
			System.out.println("Unexpected error" + e);
		}
	}

}


