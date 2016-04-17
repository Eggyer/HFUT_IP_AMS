package daohelp.student;

public class absent_info
{
	private String cname;
	private String absent;
	private String term;
	public absent_info()
	{
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString()
	{
		return "absent_info [cname=" + cname + ", absent=" + absent + ", term="
				+ term + "]";
	}
	public String getCname()
	{
		return cname;
	}
	public void setCname(String cname)
	{
		this.cname = cname;
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
	
	
}
