package petsitter;

import java.util.ArrayList;

import review.ReviewVo;

public class PetsitterVo {
	private String sitter_id;
	private String region;
	private String type;
	private ArrayList<ReviewVo> revs;
	
	public PetsitterVo() {}
	
	public PetsitterVo(String sitter_id, String region, String type) {
		this.sitter_id = sitter_id;
		this.region = region;
		this.type = type;
	}

	public String getSitter_id() {
		return sitter_id;
	}

	public void setSitter_id(String sitter_id) {
		this.sitter_id = sitter_id;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	
	//리뷰때문에 추가한거!
	public ArrayList<ReviewVo> getRevs() {
		return revs;
	}

	public void setRevs(ArrayList<ReviewVo> revs) {
		this.revs = revs;
	}
	
	@Override
	public String toString() {
		return "PetsitterVo [sitter_id=" + sitter_id + ", region=" + region + ", type=" + type + "]";
	}	
}
