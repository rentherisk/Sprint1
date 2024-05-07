import java.util.ArrayList;
import java.util.List;

public abstract class SubPage extends AbstractPage
{
	
	private List<Profile> posters;
	
	public SubPage(int id, String name) {
		super(id, name);
		this.posters = new ArrayList<>();
	}

}
