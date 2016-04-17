package daohelp.assistant;

public class UpdateAbsentInfo
{
	private String courseID;
	private String studentID;
	private String add_reduce;
	public UpdateAbsentInfo()
	{
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString()
	{
		return "UpdateAbsentInfo [courseID=" + courseID + ", studentID="
				+ studentID + ", add_reduce=" + add_reduce + "]";
	}
	public String getCourseID()
	{
		return courseID;
	}
	public void setCourseID(String courseID)
	{
		this.courseID = courseID;
	}
	public String getStudentID()
	{
		return studentID;
	}
	public void setStudentID(String studentID)
	{
		this.studentID = studentID;
	}
	public String getAdd_reduce()
	{
		return add_reduce;
	}
	public void setAdd_reduce(String add_reduce)
	{
		this.add_reduce = add_reduce;
	}
	
}
