import java.util.ArrayList; 
import java.util.List; 

public abstract class AbstractPage
{

	protected int pageId;
	protected String name;
	protected List<String> information;
	protected List<AbstractPage> linkedPages;
	protected List<Profile> permissions;
	
	public AbstractPage(int pageId, String name) {
		this.name = name;
		this.pageId = pageId;
		this.information = new ArrayList<String>();
		this.linkedPages = new ArrayList<AbstractPage>();
		this.permissions = new ArrayList<Profile>();
	}
	
	void createPage() {
		
	}

	void openPage(AbstractPage p) {
		
	}
	
	void linkPage(AbstractPage p) {
		
	}
	
	void updateName(String name) {
		this.name = name;
	}
	
	void updateInfo(String newInfo) {
		
	}
	
	void updatePermissions(Profile p) {
		
	}
	
	
	
	
}