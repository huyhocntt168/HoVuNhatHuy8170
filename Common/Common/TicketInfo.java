package Common;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;

public class TicketInfo {
	private String departDate;
	private String departStation;
	private String arriveStation;
	private String seatType;
	private String ticketAmount;

	public TicketInfo() {
		this.departDate = getRandomDepartDate();
		this.departStation = "Sài Gòn";
		this.arriveStation = "Nha Trang";
		this.seatType = "Soft bed with air conditioner";
		this.ticketAmount = "1";
	}

	public String getDepartDate() {
		return departDate;
	}

	public void setDepartDate(String departDate) {
		this.departDate = departDate;
	}

	public String getDepartStation() {
		return departStation;
	}

	public void setDepartStation(String departStation) {
		this.departStation = departStation;
	}

	public String getArriveStation() {
		return arriveStation;
	}

	public void setArriveStation(String arriveStation) {
		this.arriveStation = arriveStation;
	}

	public String getSeatType() {
		return seatType;
	}

	public void setSeatType(String seatType) {
		this.seatType = seatType;
	}

	public String getTicketAmount() {
		return ticketAmount;
	}

	public void setTicketAmount(String ticketAmount) {
		this.ticketAmount = ticketAmount;
	}

	public String getRandomDepartDate() {
		SimpleDateFormat format = new SimpleDateFormat("M/d/yyyy");
		Random random = new Random();
		int i = random.nextInt(27) + 3;
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_MONTH, i);
		return format.format(calendar.getTime());
	}
}
