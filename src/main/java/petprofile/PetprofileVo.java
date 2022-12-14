package petprofile;

public class PetprofileVo {
	private int pet_id;
	private String user_id;
	private String name;
	private int age;
	private String kind;
	private String type;
	private String sex;
	private String img;
	private String content;
	
	public PetprofileVo() {}

	public PetprofileVo(int pet_id, String user_id, String name, int age, String kind, String type, String sex, String img,
			String content) {
		this.pet_id = pet_id;
		this.user_id = user_id;
		this.name = name;
		this.age = age;
		this.kind = kind;
		this.type = type;
		this.sex = sex;
		this.img = img;
		this.content = content;
	}

	public int getPet_id() {
		return pet_id;
	}

	public void setPet_id(int pet_id) {
		this.pet_id = pet_id;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
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

	@Override
	public String toString() {
		return "PetprofileVo [pet_id=" + pet_id + ", user_id=" + user_id + ", name=" + name + ", age=" + age + ", kind="
				+ kind + ", type=" + type + ", sex=" + sex + ", img=" + img + ", content=" + content + "]";
	}
}
