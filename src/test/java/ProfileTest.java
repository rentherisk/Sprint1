

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.Start;


public class ProfileTest {

	Organizer o = new Organizer();

	void setUp() throws Exception {
		Profile x = o.createProfile("johndoe");
		Profile y = o.createProfile("janesmith");
			
	}
	
	@Test
	void testProfile() {
		
		Profile x = o.createProfile("johndoe");
		Profile y = o.createProfile("janesmith");
		Profile z = o.createProfile("janesmith");
		assertEquals(o.profileList.size(), 2, "Profiles with duplicate usernames should not be saved to list"); // test if duplicate username is disallowed;
		
		assertEquals(x.permissions.get(0).name, "johndoe", "username should match expected value");
		
		System.out.println(x);
		System.out.println(o.profileList.get(0).name);
		assertEquals(o.profileList.get(0).name, "johndoe", "username should match expected value");
		assertEquals(o.profileList.get(1).name, "janesmith", "username should match expected value");
		assertEquals(o.pageList.get(0), x, "Profile should match expected value");
		
		x.followProfile(y);
		assertEquals(x.followedProfiles.get(0).name, "janesmith", "username should match expected value");
	
		Jobs j1 = o.createJob("Programmer");
		assertEquals(o.jobPostings.get(0).name, "Programmer", "Title should match expected value");
		assertEquals(o.pageList.get(2).name, "Programmer", "Title should match expected value");
		
		j1.newApplicant(x);
		assertEquals(j1.appliedProfiles.get(0), x, "Profile should match expected value");
		
		
		News n1 = o.createNews("Breaking News");
		assertEquals(o.pageList.get(3).name, "Breaking News", "Title should match expected value");
		assertEquals(o.newsPostings.get(0).name, "Breaking News", "Title should match expected value");
		
		x.followPost(n1);
		assertEquals(x.followedPosts.get(0).name, "Breaking News", "Title should match expected value");
		n1.newLike(x);
		assertEquals(n1.liked.get(0).name, "johndoe", "Username should match expected value");
		assertEquals(n1.likes, 1, "Number of likes should match");
		n1.newLike(y);
		assertEquals(n1.likes, 2, "Number of likes should match");
		
		n1.newComment("Wow, so cool!", x);
		assertEquals(n1.comments.get(0), "Wow, so cool!", "Comment should match expected value");
		assertEquals(n1.commenters.get(0), x, "Profile should match expected value");
		
		
		
	}
		
}