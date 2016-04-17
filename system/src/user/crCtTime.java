package user;

public class crCtTime {
    private String courseID;
    private String courseClass;
    private String crName;
    private String crAttribute;
    private String crCredit;
    private String term;
	public String getCourseID() {
		return courseID;
	}
	public void setCourseID(String courseID) {
		this.courseID = courseID;
	}
	public String getCourseClass() {
		return courseClass;
	}
	public void setCourseClass(String courseClass) {
		this.courseClass = courseClass;
	}
	public String getCrName() {
		return crName;
	}
	public void setCrName(String crName) {
		this.crName = crName;
	}
	public String getCrAttribute() {
		return crAttribute;
	}
	public void setCrAttribute(String crAttribute) {
		this.crAttribute = crAttribute;
	}
	public String getCrCredit() {
		return crCredit;
	}
	public void setCrCredit(String crCredit) {
		this.crCredit = crCredit;
	}
	public String getTerm() {
		return term;
	}
	public void setTerm(String term) {
		this.term = term;
	}
	@Override
	public String toString() {
		return "crCtTime [courseID=" + courseID + ", courseClass="
				+ courseClass + ", crName=" + crName + ", crAttribute="
				+ crAttribute + ", crCredit=" + crCredit + ", term=" + term
				+ "]";
	}
}
