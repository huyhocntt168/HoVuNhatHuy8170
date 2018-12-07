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
		this.departStation = getRandomDepartStation();
		this.arriveStation = getRandomArriveStation();
		this.seatType = "Soft bed with air conditioner";
		this.ticketAmount = "1";
	}

	public String getRandomDepartStation() {
		Random random = new Random();
		String[] deparStation = { "Sài Gòn", "Phan Thiết", "Nha Trang", "Đà Nẵng", "Huế", "Quảng Ngãi" };
		return deparStation[random.nextInt(5)];
	}

	public String getRandomArriveStation() {
		Random random = new Random();
		if (this.departStation.equals("Sài Gòn")) {
			String[] arriveStation = { "Phan Thiết", "Nha Trang", "Đà Nẵng", "Huế", "Quảng Ngãi" };
			return arriveStation[random.nextInt(4)];
		} else if (this.departStation.equals("Phan Thiết")) {
			String[] arriveStation = { "Sài Gòn", "Nha Trang", "Đà Nẵng" };
			return arriveStation[random.nextInt(2)];
		} else if (this.departStation.equals("Nha Trang")) {
			String[] arriveStation = { "Sài Gòn", "Phan Thiết", "Đà Nẵng", "Huế" };
			return arriveStation[random.nextInt(3)];
		} else if (this.departStation.equals("Đà Nẵng")) {
			String[] arriveStation = { "Sài Gòn", "Nha Trang", "Huế", "Quảng Ngãi" };
			return arriveStation[random.nextInt(3)];
		} else if (this.departStation.equals("Huế")) {
			String[] arriveStation = { "Sài Gòn", "Nha Trang", "Đà Nẵng", "Quảng Ngãi" };
			return arriveStation[random.nextInt(3)];
		} else {
			String[] arriveStation = { "Sài Gòn", "Nha Trang", "Đà Nẵng", "Huế" };
			return arriveStation[random.nextInt(3)];
		}
	}
	public TicketInfo(String departDate, String departStation, String arriveStation, String seatType,
			String ticketAmount) {
		this.departDate = departDate;
		this.departStation = departStation;
		this.arriveStation = arriveStation;
		this.seatType = seatType;
		this.ticketAmount = ticketAmount;
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
