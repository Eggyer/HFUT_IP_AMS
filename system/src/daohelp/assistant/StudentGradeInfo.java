package daohelp.assistant;

public class StudentGradeInfo
{
	private String student_id;
	private String student_name;
	private String course_name;
	private String absent_total;
	private String total;
	private String term;
	private String credit;
	private String attribute;
	private String gpa;
	public StudentGradeInfo()
	{
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString()
	{
		return "StudentGradeInfo [student_name=" + student_name
				+ ", student_id=" + student_id + ", course_name=" + course_name
				+ ", absent_total=" + absent_total + ", total=" + total
				+ ", term=" + term + ", credit=" + credit + ", attribute="
				+ attribute + ", gpa=" + gpa + "]";
	}
	public String getStudent_name()
	{
		return student_name;
	}
	public void setStudent_name(String student_name)
	{
		this.student_name = student_name;
	}
	public String getStudent_id()
	{
		return student_id;
	}
	public void setStudent_id(String student_id)
	{
		this.student_id = student_id;
	}
	public String getCourse_name()
	{
		return course_name;
	}
	public void setCourse_name(String course_name)
	{
		this.course_name = course_name;
	}
	public String getAbsent_total()
	{
		return absent_total;
	}
	public void setAbsent_total(String absent_total)
	{
		this.absent_total = absent_total;
	}
	public String getTotal()
	{
		return total;
	}
	public void setTotal(String total)
	{
		this.total = total;
	}
	public String getTerm()
	{
		return term;
	}
	public void setTerm(String term)
	{
		this.term = term;
	}
	public String getCredit()
	{
		return credit;
	}
	public void setCredit(String credit)
	{
		this.credit = credit;
	}
	public String getAttribute()
	{
		return attribute;
	}
	public void setAttribute(String attribute)
	{
		this.attribute = attribute;
	}
	public String getGpa()
	{
		return gpa;
	}
	public void setGpa(String gpa)
	{
		this.gpa = gpa;
	}
	
	
}
