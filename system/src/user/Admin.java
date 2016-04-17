package user;

public class Admin {
    private String adID;
    private String adPassword;
	public Admin()
	{
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString()
	{
		return "Admin [adID=" + adID + ", adPassword=" + adPassword + "]";
	}
	public String getAdID()
	{
		return adID;
	}
	public void setAdID(String adID)
	{
		this.adID = adID;
	}
	public String getAdPassword()
	{
		return adPassword;
	}
	public void setAdPassword(String adPassword)
	{
		this.adPassword = adPassword;
	}
    
}
