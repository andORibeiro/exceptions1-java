package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.exceptions.DomainException;

public class Reservation {

	private Integer roomNumber;
	private Date checkIn;
	private Date checkOut;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
	
	public Reservation(Integer roomNumber, Date checkIn, Date checkOut) throws DomainException {
		
		if(!checkOut.after(checkIn)) {
			throw new DomainException("Check-out date must be after check-in date.");
		}
		if(checkIn.before(new Date()) || checkOut.before(new Date())) { //Se o checkin ou checkout for antes de agora
			throw new DomainException("Reservation dates for updates must be future dates"); //Tipo de exceção comumente usado quando os argumentos recebidos pelo métodos são invalidos
		}
		
		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	public Date getCheckOut() {
		return checkOut;
	}
	
	public long duration() {
		long  diff = checkOut.getTime() - checkIn.getTime();
		return TimeUnit.DAYS.convert(diff,TimeUnit.MILLISECONDS); //Converte o diff passado em milliseconds em days
	}
	
	public void updateDate(Date checkIn, Date checkOut) throws DomainException{
		
		Date now = new Date(); //Instancia uma variavel com a data atual
		if(checkIn.before(now) || checkOut.before(now)) { //Se o checkin ou checkout for antes de agora
			throw new DomainException("Reservation dates for updates must be future dates"); //Tipo de exceção comumente usado quando os argumentos recebidos pelo métodos são invalidos
		}
		if(!checkOut.after(checkIn)) {
			throw new DomainException("Check-out date must be after check-in date.");
		}
		
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}
	
	@Override
	public String toString() {
		return "Room: "
			+ roomNumber
			+ ", check-in: "
			+ sdf.format(checkIn)
			+", check-out: "
			+ sdf.format(checkOut)
			+", "
			+ duration()
			+" nights";
	}


	
	
}
