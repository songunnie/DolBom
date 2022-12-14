package board;

import java.sql.Date;

public class BoardVo {
	private int num;
	private String user_id;
	private String title;
	private String img;
	private String content;
	private Date post_date;
	private int hit;
	
	public BoardVo() {
		
	}
	
	public BoardVo(int num, String user_id, String title, String img, String content, Date post_date, int hit) {
		this.num = num;
		this.user_id = user_id;
		this.title = title;
		this.img = img;
		this.content = content;
		this.post_date = post_date;
		this.hit = hit;
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

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}

	@Override
	public String toString() {
		return "BoardVo [num=" + num + ", user_id=" + user_id + ", title=" + title + ", img=" + img + ", content="
				+ content + ", post_date=" + post_date + ", hit=" + hit + "]";
	}
	
}
