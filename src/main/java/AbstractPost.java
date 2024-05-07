import java.util.ArrayList; 
import java.util.List; 

public abstract class AbstractPost extends AbstractPage
{

	protected int likes;
	protected List<String> comments;
	protected List<Profile> commenters;
	protected List<Profile> posters;
	
	public AbstractPost(int id, String name) {
		super(id, name);
		this.likes = 0;
		this.comments = new ArrayList<String>();
		this.commenters = new ArrayList<Profile>();
		this.posters = new ArrayList<Profile>();
		
	}
	
	void updatePosters(Profile p) {
		posters.add(p);
	}
	
	void newComment(String s, Profile p) {
		comments.add(s);
		commenters.add(p);
	}
	
	void newLike() {
		likes += 1;
	}
	
}
