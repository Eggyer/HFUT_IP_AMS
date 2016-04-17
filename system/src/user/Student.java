package user;

public class Student {
      private String stID;
      private String stPassword;
      private String stName;
      private String stClass;
      private String stEmail;
      private String stCollege;
      private String stCourseAbsentTotal;
      private String stExerciseAbsentTotal;
	public Student()
	{
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString()
	{
		return "Student [stID=" + stID + ", stPassword=" + stPassword
				+ ", stName=" + stName + ", stClass=" + stClass + ", stEmail="
				+ stEmail + ", stCollege=" + stCollege
				+ ", stCourseAbsentTotal=" + stCourseAbsentTotal
				+ ", stExerciseAbsentTotal=" + stExerciseAbsentTotal + "]";
	}
	public String getStID()
	{
		return stID;
	}
	public void setStID(String stID)
	{
		this.stID = stID;
	}
	public String getStPassword()
	{
		return stPassword;
	}
	public void setStPassword(String stPassword)
	{
		this.stPassword = stPassword;
	}
	public String getStName()
	{
		return stName;
	}
	public void setStName(String stName)
	{
		this.stName = stName;
	}
	public String getStClass()
	{
		return stClass;
	}
	public void setStClass(String stClass)
	{
		this.stClass = stClass;
	}
	public String getStEmail()
	{
		return stEmail;
	}
	public void setStEmail(String stEmail)
	{
		this.stEmail = stEmail;
	}
	public String getStCollege()
	{
		return stCollege;
	}
	public void setStCollege(String stCollege)
	{
		this.stCollege = stCollege;
	}
	public String getStCourseAbsentTotal()
	{
		return stCourseAbsentTotal;
	}
	public void setStCourseAbsentTotal(String stCourseAbsentTotal)
	{
		this.stCourseAbsentTotal = stCourseAbsentTotal;
	}
	public String getStExerciseAbsentTotal()
	{
		return stExerciseAbsentTotal;
	}
	public void setStExerciseAbsentTotal(String stExerciseAbsentTotal)
	{
		this.stExerciseAbsentTotal = stExerciseAbsentTotal;
	}
      
}
