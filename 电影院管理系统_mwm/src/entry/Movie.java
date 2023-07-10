package entry;

public class Movie {
	private int mId;
	private String mName;
	private String director;
	private String majorActor;
	private String type;
	private int duration;
	private String introduction;
	private String route;

	public int getmId() {
		return mId;
	}

	public void setmId(int mId) {
		this.mId = mId;
	}

	public String getmName() {
		return mName;
	}

	public void setmName(String mName) {
		this.mName = mName;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getMajorActor() {
		return majorActor;
	}

	public void setMajorActor(String majorActor) {
		this.majorActor = majorActor;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public String getRoute() {
		return route;
	}

	public void setRoute(String route) {
		this.route = route;
	}

	public Movie() {
		super();
	}
	
	public Movie(String mName, String director, String majorActor, String type, int duration, String introduction,
			String route) {
		super();
		this.mName = mName;
		this.director = director;
		this.majorActor = majorActor;
		this.type = type;
		this.duration = duration;
		this.introduction = introduction;
		this.route = route;
	}

	public Movie(int mId, String mName, String director, String majorActor, String type, int duration,
			String introduction, String route) {
		super();
		this.mId = mId;
		this.mName = mName;
		this.director = director;
		this.majorActor = majorActor;
		this.type = type;
		this.duration = duration;
		this.introduction = introduction;
		this.route = route;
	}

	@Override
	public String toString() {
		if (mId==-1) {
			return mName;
		}
		return mName + "(ID:" +  mId + ")";
	}
	

}
