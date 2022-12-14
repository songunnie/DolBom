package reservation;

import java.sql.Date;

public class ReservationVo {
	private int num;
	private String user_id;
	private String sitter_id;
	private Date start_date;
	private Date end_date;
	private Date register_date;
	private String content;
	
	public ReservationVo() {}
	
	public ReservationVo(int num, String user_id, String sitter_id, Date start_date, Date end_date, Date register_date,
			String content) {
		this.num = num;
		this.user_id = user_id;
		this.sitter_id = sitter_id;
		this.start_date = start_date;
		this.end_date = end_date;
		this.register_date = register_date;
		this.content = content;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getSitter_id() {
		return sitter_id;
	}

	public void setSitter_id(String sitter_id) {
		this.sitter_id = sitter_id;
	}

	public Date getStart_date() {
		return start_date;
	}

	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}

	public Date getEnd_date() {
		return end_date;
	}

	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}

	public Date getRegister_date() {
		return register_date;
	}

	public void setRegister_date(Date register_date) {
		this.register_date = register_date;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "ReservationVo [num=" + num + ", user_id=" + user_id + ", sitter_id=" + sitter_id + ", start_date="
				+ start_date + ", end_date=" + end_date + ", register_date=" + register_date + ", content=" + content
				+ "]";
	}
	
	
}
