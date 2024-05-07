import java.util.ArrayList; 
import java.util.List; 

public abstract class AbstractProfile extends AbstractPage
{
	protected List<Profile> followedProfiles;
	protected List<Post> followedPosts;
	protected List<Profile> followersList;
	protected List<Profile> friendsList;
	protected List<String> mentorStatus;
	protected Boolean privacy;
	
	public AbstractProfile(int id, String name) {
		super(id, name);
		this.followedProfiles = new ArrayList<Profile>();
		this.followedPosts = new ArrayList<Post>();
		this.followersList = new ArrayList<Profile>();
		this.friendsList = new ArrayList<Profile>();
		this.mentorStatus = new ArrayList<String>();
		this.privacy = true;
	}

	void followProfile(Profile p) {
		followedProfiles.add(p);
	}
	
	void acceptFollower(Profile p) {
		followersList.add(p);
	}
	
	void followPost(Post p) {
		followedPosts.add(p);
	}
	
	void updatePrivacy() {
		if(privacy == true) {
			privacy = false;
		} else {
			privacy = true;
		}
	}
	
}
