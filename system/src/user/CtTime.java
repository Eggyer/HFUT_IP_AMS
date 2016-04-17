package user;

public class CtTime {
	private String courseID;
	private String teacherID;
	private String courseClass;
	private String term;
	private String week;
	private String time;
	public String getCourseID() {
		return courseID;
	}
	public void setCourseID(String courseID) {
		this.courseID = courseID;
	}
	public String getTeacherID() {
		return teacherID;
	}
	public void setTeacherID(String teacherID) {
		this.teacherID = teacherID;
	}
	public String getCourseClass() {
		return courseClass;
	}
	public void setCourseClass(String courseClass) {
		this.courseClass = courseClass;
	}
	public String getTerm() {
		return term;
	}
	public void setTerm(String term) {
		this.term = term;
	}
	public String getWeek() {
		return week;
	}
	public void setWeek(String week) {
		this.week = week;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	@Override
	public String toString() {
		return "CtTime [courseID=" + courseID + ", teacherID=" + teacherID
				+ ", courseClass=" + courseClass + ", term=" + term + ", week="
				+ week + ", time=" + time + "]";
	}
	
}
