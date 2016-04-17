package user;

public class Teacher {
     private String tcID;
     private String tcPassword;
     private String tcName;
     private String tcCollege;
     private String tcEmail;
	public Teacher()
	{
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString()
	{
		return "Teacher [tcID=" + tcID + ", tcPassword=" + tcPassword
				+ ", tcName=" + tcName + ", tcCollege=" + tcCollege
				+ ", tcEmail=" + tcEmail + "]";
	}
	public String getTcID()
	{
		return tcID;
	}
	public void setTcID(String tcID)
	{
		this.tcID = tcID;
	}
	public String getTcPassword()
	{
		return tcPassword;
	}
	public void setTcPassword(String tcPassword)
	{
		this.tcPassword = tcPassword;
	}
	public String getTcName()
	{
		return tcName;
	}
	public void setTcName(String tcName)
	{
		this.tcName = tcName;
	}
	public String getTcCollege()
	{
		return tcCollege;
	}
	public void setTcCollege(String tcCollege)
	{
		this.tcCollege = tcCollege;
	}
	public String getTcEmail()
	{
		return tcEmail;
	}
	public void setTcEmail(String tcEmail)
	{
		this.tcEmail = tcEmail;
	}
     
}
