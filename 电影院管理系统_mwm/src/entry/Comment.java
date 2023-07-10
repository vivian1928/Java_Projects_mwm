package entry;

import java.util.Date;

public class Comment {
	private int coId;
	private int uId;
	private int mId;
	private String info;
	private String coTime;
	private int score;

	public int getCoId() {
		return coId;
	}

	public void setCoId(int coId) {
		this.coId = coId;
	}

	public int getuId() {
		return uId;
	}

	public void setuId(int uId) {
		this.uId = uId;
	}

	public int getmId() {
		return mId;
	}

	public void setmId(int mId) {
		this.mId = mId;
	}


	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getCoTime() {
		return coTime;
	}

	public void setCoTime(String coTime) {
		this.coTime = coTime;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	

	public Comment(int uId, int mId, String info, String coTime, int score) {
		super();
		this.uId = uId;
		this.mId = mId;
		this.info = info;
		this.coTime = coTime;
		this.score = score;
	}

	public Comment() {
		super();
	}

	@Override
	public String toString() {
		return "Comment [coId=" + coId + ", uId=" + uId + ", mId=" + mId + ", info=" + info + ", coTime=" + coTime
				+ ", score=" + score + "]";
	}


}
