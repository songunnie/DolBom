package member;

public class MemberVo {
	private String user_id;
	private String pwd;
	private String name;
	private String tel;
	private String address;
	private int status;
	
	public MemberVo() {}
	
	public MemberVo(String user_id, String pwd, String name, String tel, String address, int status) {
		this.user_id = user_id;
		this.pwd = pwd;
		this.name = name;
		this.tel = tel;
		this.address = address;
		this.status = status;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "MemberVo [user_id=" + user_id + ", pwd=" + pwd + ", name=" + name + ", tel=" + tel + ", address="
				+ address + ", status=" + status + "]";
	}
}