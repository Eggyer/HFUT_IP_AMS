package daohelp.student;

public class grade_info
{
	private String course_name;
	private String absent;
	private String ordinary;
	private String exam;
	private String total;
	private String term;
	private String credit;
	private String attribute;
	private String gpa;
	public grade_info()
	{
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString()
	{
		return "grade_info [course_name=" + course_name + ", absent=" + absent
				+ ", ordinary=" + ordinary + ", exam=" + exam + ", total="
				+ total + ", term=" + term + ", credit=" + credit
				+ ", attribute=" + attribute + ", gpa=" + gpa + "]";
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
	public String getOrdinary()
	{
		return ordinary;
	}
	public void setOrdinary(String ordinary)
	{
		this.ordinary = ordinary;
	}
	public String getExam()
	{
		return exam;
	}
	public void setExam(String exam)
	{
		this.exam = exam;
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
