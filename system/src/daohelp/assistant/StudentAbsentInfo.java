package daohelp.assistant;

public class StudentAbsentInfo
{
	private String student_id;
	private String student_name;
	private String course_name;
	private String absent;
	private String term;
	private String absent_total;
	public StudentAbsentInfo()
	{
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString()
	{
		return "StudentAbsentInfo [student_id=" + student_id
				+ ", student_name=" + student_name + ", course_name="
				+ course_name + ", absent=" + absent + ", term=" + term
				+ ", absent_total=" + absent_total + "]";
	}
	public String getStudent_id()
	{
		return student_id;
	}
	public void setStudent_id(String student_id)
	{
		this.student_id = student_id;
	}
	public String getStudent_name()
	{
		return student_name;
	}
	public void setStudent_name(String student_name)
	{
		this.student_name = student_name;
	}
	public String getCourse_name()
	{
		return course_name;
	}
	public void setCourse_name(String course_name)
	{
		this.course_name = course_name;
	}
	public String getAbsent()
	{
		return absent;
	}
	public void setAbsent(String absent)
	{
		this.absent = absent;
	}
	public String getTerm()
	{
		return term;
	}
	public void setTerm(String term)
	{
		this.term = term;
	}
	public String getAbsent_total()
	{
		return absent_total;
	}
	public void setAbsent_total(String absent_total)
	{
		this.absent_total = absent_total;
	}
	
	
}
