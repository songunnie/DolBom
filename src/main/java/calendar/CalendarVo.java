package calendar;

import java.sql.Date;

public class CalendarVo {
	private int num;
	private int reserv_num;
	private String sitter_id;
	private Date reserved_date;
	private Date abled_date;
	
	public CalendarVo() {}

	public CalendarVo(int num, int reserv_num, String sitter_id, Date reserved_date, Date abled_date) {
		this.num = num;
		this.reserv_num = reserv_num;
		this.sitter_id = sitter_id;
		this.reserved_date = reserved_date;
		this.abled_date = abled_date;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}
	
	public int getReserv_num() {
		return num;
	}

	public void setReserv_num(int reserv_num) {
		this.reserv_num = reserv_num;
	}

	public String getSitter_id() {
		return sitter_id;
	}

	public void setSitter_id(String sitter_id) {
		this.sitter_id = sitter_id;
	}

	public Date getReserved_date() {
		return reserved_date;
	}

	public void setReserved_date(Date reserved_date) {
		this.reserved_date = reserved_date;
	}

	public Date getAbled_date() {
		return abled_date;
	}

	public void setAbled_date(Date abled_date) {
		this.abled_date = abled_date;
	}

	@Override
	public String toString() {
		return "CalendarVo [num=" + num + ", sitter_id=" + sitter_id + ", reserved_date=" + reserved_date
				+ ", abled_date=" + abled_date + "]";
	}
	
	
}
