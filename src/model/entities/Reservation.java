package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {
	private Integer roomNumber;
	private Date checkin;
	private Date checkout;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reservation() {		
	}

	public Reservation(Integer roomNumber, Date checkin, Date checkout) {
		this.roomNumber = roomNumber;
		this.checkin = checkin;
		this.checkout = checkout;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Date getCheckin() {
		return checkin;
	}
	
	/*
	public void setCheckin(Date checkin) {
		this.checkin = checkin;
	}
	*/
	
	public Date getCheckout() {
		return checkout;
	}
	
	/*
	public void setCheckout(Date checkout) {
		this.checkout = checkout;
	}
	*/
	
	public long duration() {
		// getTime() resolves time in milliseconds
		long diff = checkout.getTime() - checkin.getTime();
		// converting milliseconds to days
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}
	
	public void updateDates(Date checkin, Date checkout) {
		this.checkin = checkin;
		this.checkout = checkout;
	}
	
	@Override
	public String toString() {
		return "Reservation: "
				+ roomNumber
				+ ", Check-in date (dd/MM/yyyy): "
				+ sdf.format(checkin)
				+ ", Check-out date (dd/MM/yyyy): "
				+ sdf.format(checkout)
				+ ", "
				+ duration()
				+ " nights.";
	}
}