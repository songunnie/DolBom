package dolbom;

import java.sql.Date;

public class DolbomVo {
	private int num;
	private String sitter_id ;
	private int reservation_num;
	private String user_id;
	private String title;
	private String img;
	private String content;
	private Date post_date;
	
	public DolbomVo() {

	}

	public DolbomVo(int num, String sitter_id, int reservation_num, String user_id, String title, String img,
			String content, Date post_date) {
		this.num = num;
		this.sitter_id = sitter_id;
		this.reservation_num = reservation_num;
		this.user_id = user_id;
		this.title = title;
		this.img = img;
		this.content = content;
		this.post_date = post_date;
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

	public int getReservation_num() {
		return reservation_num;
	}

	public void setReservation_num(int reservation_num) {
		this.reservation_num = reservation_num;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getPost_date() {
		return post_date;
	}

	public void setPost_date(Date post_date) {
		this.post_date = post_date;
	}

	@Override
	public String toString() {
		return "DolbomVo [num=" + num + ", sitter_id=" + sitter_id + ", reservation_num=" + reservation_num
				+ ", user_id=" + user_id + ", title=" + title + ", img=" + img + ", content=" + content + ", post_date="
				+ post_date + "]";
	}

}
