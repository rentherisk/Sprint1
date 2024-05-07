import java.util.ArrayList;
import java.util.List;

public class News extends AbstractPage
{
	protected List<String> sources;

	public News(int id, String name)
	{
		super(id, name);
		this.sources = new ArrayList<>();
	}
	
	void addSource(String source) {
		sources.add(source);
		
	}
	
	void removeSource(String source) {
		sources.remove(source);
	}

}
