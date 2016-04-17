package user;

public class Grade {
	private String courseID;
	private String teacherID;
	private String studentID;
	private String courseName;
    private String absent;
    private String ordinary;
    private String exam;
    private String total;
    private String courseClass;
    private String term;
	public Grade()
	{
		super();
		// TODO Auto-generated constructor stub
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
	public String getAbsent() {
		return absent;
	}
	public void setAbsent(String absent) {
		this.absent = absent;
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
	public String getTotal() {
		return total;
	}
	public void setTotal(String total) {
		this.total = total;
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
	@Override
	public String toString() {
		return "Grade [courseID=" + courseID + ", teacherID=" + teacherID
				+ ", studentID=" + studentID + ", courseName=" + courseName
				+ ", absent=" + absent + ", ordinary=" + ordinary + ", exam="
				+ exam + ", total=" + total + ", courseClass=" + courseClass
				+ ", term=" + term + "]";
	}


}
