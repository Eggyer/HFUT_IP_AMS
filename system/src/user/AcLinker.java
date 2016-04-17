package user;

public class AcLinker {
      private String stClass;
      private String assistantID;
	public String getStClass() {
		return stClass;
	}
	public void setStClass(String stClass) {
		this.stClass = stClass;
	}
	public String getAssistantID() {
		return assistantID;
	}
	public void setAssistantID(String assistantID) {
		this.assistantID = assistantID;
	}
	@Override
	public String toString() {
		return "AcLinker [stClass=" + stClass + ", assistantID=" + assistantID
				+ "]";
	}
      
}
