package user;

public class StGrade {
	private String teacherID;
	private String courseClass;
	private String courseID;
	private String stID;
	private String stName;
	private String stClass;
	private String stCollege;
	private String stCourseAbsentTotal;
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
	public String getCourseID() {
		return courseID;
	}
	public void setCourseID(String courseID) {
		this.courseID = courseID;
	}
	public String getStID() {
		return stID;
	}
	public void setStID(String stID) {
		this.stID = stID;
	}
	public String getStName() {
		return stName;
	}
	public void setStName(String stName) {
		this.stName = stName;
	}
	public String getStClass() {
		return stClass;
	}
	public void setStClass(String stClass) {
		this.stClass = stClass;
	}
	public String getStCollege() {
		return stCollege;
	}
	public void setStCollege(String stCollege) {
		this.stCollege = stCollege;
	}
	@Override
	public String toString() {
		return "StGrade [teacherID=" + teacherID + ", courseClass="
				+ courseClass + ", courseID=" + courseID + ", stID=" + stID
				+ ", stName=" + stName + ", stClass=" + stClass
				+ ", stCollege=" + stCollege + "]";
	}

	public String getStCourseAbsentTotal() {
		return stCourseAbsentTotal;
	}

	public void setStCourseAbsentTotal(String stCourseAbsentTotal) {
		this.stCourseAbsentTotal = stCourseAbsentTotal;
	}
}
