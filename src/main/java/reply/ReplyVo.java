package reply;

import java.util.Date;

public class ReplyVo {
	private int num;
	private String user_id;
	private String content;
	private Date reply_date;
	private int parent;
	
	public ReplyVo () {}

	public ReplyVo(int num, String user_id, String content, Date reply_date, int parent) {
		this.num = num;
		this.user_id = user_id;
		this.content = content;
		this.reply_date = reply_date;
		this.parent = parent;
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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getReply_date() {
		return reply_date;
	}

	public void setReply_date(Date reply_date) {
		this.reply_date = reply_date;
	}

	public int getParent() {
		return parent;
	}

	public void setParent(int parent) {
		this.parent = parent;
	}

	@Override
	public String toString() {
		return "replyVo [num=" + num + ", user_id=" + user_id + ", content=" + content + ", reply_date=" + reply_date
				+ ", parent=" + parent + "]";
	}
}
