package Application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {

		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
		
		System.out.print("Room number: ");
		int number = sc.nextInt();
		System.out.print("Check-in date (dd/mm/yyyy): ");
		Date checkIn = sdf.parse(sc.next()); //converte o string capturado pelo scannerno formato de data
		System.out.print("Check-out date (dd/mm/yyyy): ");
		Date checkOut = sdf.parse(sc.next());
		
		
		if(!checkOut.after(checkIn)) { //Se a data de checkou não for depois da de checkin
			System.out.println("Error in reservation: Check-out date must be after check-in date.");
		}else {
			Reservation reservation = new Reservation(number, checkIn, checkOut);
			System.out.println("Reservation: " + reservation);
			
			System.out.println();
			System.out.println("Enter data to update the reservarion:");
			System.out.print("Check-in date (dd/mm/yyyy): ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Check-out date (dd/mm/yyyy): ");
			checkOut = sdf.parse(sc.next());
			
			
			String error = reservation.updateDate(checkIn, checkOut); //Valida atraves da string retornada pelo metodo se deu erro ou nao
			if(error != null) {
				System.out.println("Erro in reservation: " + error);
			}
			else {
				System.out.println("Reservation: " + reservation);
			}
			
			
			
		}
	}

}
