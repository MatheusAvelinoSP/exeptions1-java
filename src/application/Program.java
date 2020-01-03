package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Resevation;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Room number");
		int number = sc.nextInt();
		System.out.print("Check-in date (dd/MM/yyyy) : ");
		Date checkIn = sdf.parse(sc.next());
		System.out.print("Check-Out date (dd/MM/yyyy) : ");
		Date checkOut = sdf.parse(sc.next());
		
		
		if(!checkOut.after(checkIn)) {
			System.out.println("Error in reservation : Check-out must be after checkin date");
		}
		else {
			Resevation reservation = new Resevation(number, checkIn, checkOut);
			System.out.println("Servervation" + reservation);
			System.out.println();
			System.out.println("Enter data to update the reservation:");
			System.out.print("Check-in date (dd/MM/yyyy) : ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Check-Out date (dd/MM/yyyy) : ");
			checkOut = sdf.parse(sc.next());
	
			Date now = new Date();
			if(checkIn.before(now) || checkOut.before(now)) {
				System.out.println("Error in reservation : Check-out must be after checkin date");
			}
			else if(!checkOut.after(checkIn)) {
				System.out.println("Error in reservation : Check-out must be after checkin date");
			}
			else {
			reservation.updateDate(checkIn, checkOut);
			System.out.println("Reservation: " + reservation);
			}
		}
		
		
		
		
		
		
		
		
		
		
		
		sc.close();
		
	}

}
