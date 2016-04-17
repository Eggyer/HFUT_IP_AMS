package user;

public class GradeInfo {
	private String absent;
	private String courseID;
	private String teacherID;
	private String term;
	private String courseClass;
	private String ordinary;
	private String exam;
	private String studentID;
	private String courseName;
	private String total;
	private String studentName;
	public String getAbsent() {
		return absent;
	}
	public void setAbsent(String absent) {
		this.absent = absent;
	}
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
	public String getTerm() {
		return term;
	}
	public void setTerm(String term) {
		this.term = term;
	}
	public String getCourseClass() {
		return courseClass;
	}
	public void setCourseClass(String courseClass) {
		this.courseClass = courseClass;
	}
	public String getOrdinary() {
		return ordinary;
	}
	public void setOrdinary(String ordinary) {
		this.ordinary = ordinary;
	}
	public String getExam() {
		return exam;
	}
	public void setExam(String exam) {
		this.exam = exam;
	}
	public String getStudentID() {
		return studentID;
	}
	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getTotal() {
		return total;
	}
	public void setTotal(String total) {
		this.total = total;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	@Override
	public String toString() {
		return "GradeInfo [absent=" + absent + ", courseID=" + courseID
				+ ", teacherID=" + teacherID + ", term=" + term
				+ ", courseClass=" + courseClass + ", ordinary=" + ordinary
				+ ", exam=" + exam + ", studentID=" + studentID
				+ ", courseName=" + courseName + ", total=" + total
				+ ", studentName=" + studentName + "]";
	}
	
}
