package daohelp.student;

public class course_info
{
	private String course_name;
	private String course_class;
	private String term;
	private String week;
	private String time;
	public course_info()
	{
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString()
	{
		return "course_info [course_name=" + course_name + ", course_class="
				+ course_class + ", term=" + term + ", week=" + week
				+ ", time=" + time + "]";
	}
	public String getCourse_name()
	{
		return course_name;
	}
	public void setCourse_name(String course_name)
	{
		this.course_name = course_name;
	}
	public String getCourse_class()
	{
		return course_class;
	}
	public void setCourse_class(String course_class)
	{
		this.course_class = course_class;
	}
	public String getTerm()
	{
		return term;
	}
	public void setTerm(String term)
	{
		this.term = term;
	}
	public String getWeek()
	{
		return week;
	}
	public void setWeek(String week)
	{
		this.week = week;
	}
	public String getTime()
	{
		return time;
	}
	public void setTime(String time)
	{
		this.time = time;
	}

	
	
}
