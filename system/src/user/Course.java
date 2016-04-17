package user;

public class Course {
    private String crID;
    private String crName;
    private String crAttribute;
    private String crCredit;
	public Course()
	{
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString()
	{
		return "Course [crID=" + crID + ", crName=" + crName + ", crAttribute="
				+ crAttribute + ", crCredit=" + crCredit +"]";
	}
	public String getCrID()
	{
		return crID;
	}
	public void setCrID(String crID)
	{
		this.crID = crID;
	}
	public String getCrName()
	{
		return crName;
	}
	public void setCrName(String crName)
	{
		this.crName = crName;
	}
	public String getCrAttribute()
	{
		return crAttribute;
	}
	public void setCrAttribute(String crAttribute)
	{
		this.crAttribute = crAttribute;
	}
	public String getCrCredit()
	{
		return crCredit;
	}
	public void setCrCredit(String crCredit)
	{
		this.crCredit = crCredit;
	}
}
