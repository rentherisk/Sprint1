import java.util.ArrayList;
import java.util.List;

public class Jobs extends AbstractPage
{
	protected List<Profile> appliedProfiles;

	public Jobs(int id, String name)
	{
		super(id, name);
		this.appliedProfiles = new ArrayList<>();
	}
	
	void newApplicant(Profile p) {
		appliedProfiles.add(p);
	}

}
