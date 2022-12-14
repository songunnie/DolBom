package review;

import java.sql.Date;

public class ReviewVo {
	private int num;
	private String sitter_id;
	private String user_id;
	private Date review_date;
	private String content;
	
	public ReviewVo() {
		
	}
	
	public ReviewVo(int num, String sitter_id, String user_id, Date review_date, String content) {
		this.num = num;
		this.sitter_id = sitter_id;
		this.user_id = user_id;
		this.review_date = review_date;
		this.content = content;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getSitter_id() {
		return sitter_id;
	}

	public void setSitter_id(String sitter_id) {
		this.sitter_id = sitter_id;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public Date getReview_date() {
		return review_date;
	}

	public void setReview_date(Date review_date) {
		this.review_date = review_date;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "ReviewVo [num=" + num + ", sitter_id=" + sitter_id + ", user_id=" + user_id + ", review_date="
				+ review_date + ", content=" + content + "]";
	}
	
}
