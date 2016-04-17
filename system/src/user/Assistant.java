package user;

public class Assistant {
     private String asID;
     private String asPassword;
     private String asName;
     private String asCollege;
     private String asEmail;
	@Override
	public String toString() {
		return "Assistant [asID=" + asID + ", asPassword=" + asPassword
				+ ", asName=" + asName + ", asCollege=" + asCollege
				+ ", asEmail=" + asEmail + "]";
	}
	public String getAsID() {
		return asID;
	}
	public void setAsID(String asID) {
		this.asID = asID;
	}
	public String getAsPassword() {
		return asPassword;
	}
	public void setAsPassword(String asPassword) {
		this.asPassword = asPassword;
	}
	public String getAsName() {
		return asName;
	}
	public void setAsName(String asName) {
		this.asName = asName;
	}
	public String getAsCollege() {
		return asCollege;
	}
	public void setAsCollege(String asCollege) {
		this.asCollege = asCollege;
	}
	public String getAsEmail() {
		return asEmail;
	}
	public void setAsEmail(String asEmail) {
		this.asEmail = asEmail;
	}
	public Assistant() {
		super();
		// TODO Auto-generated constructor stub
	}
     
}
