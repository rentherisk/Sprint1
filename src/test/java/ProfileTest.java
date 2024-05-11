

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.Start;


public class ProfileTest {

	Organizer o = new Organizer();
	
	@Test
	void tests() {
		
		Profile x = o.createProfile("johndoe");
		Profile y = o.createProfile("janesmith");
		Profile z = o.createProfile("janesmith");
		assertEquals(o.profileList.size(), 2, "Profiles with duplicate usernames should not be saved to list"); // test if duplicate username is disallowed;
		
		// test if username saves and matches
		assertEquals(x.permissions.get(0).name, "johndoe", "username should match expected value");
		
		// test if profiles are in database
		System.out.println(x);
		System.out.println(o.profileList.get(0).name);
		assertEquals(o.profileList.get(0).name, "johndoe", "username should match expected value");
		assertEquals(o.profileList.get(1).name, "janesmith", "username should match expected value");
		assertEquals(o.pageList.get(0), x, "Profile should match expected value");
		
		// test following
		x.followProfile(y);
		assertEquals(x.followedProfiles.get(0).name, "janesmith", "username should match expected value");
	
		
		// test jobs
		
		Jobs j1 = o.createJob("Programmer");
		
		// test if in database
		assertEquals(o.jobPostings.get(0).name, "Programmer", "Title should match expected value");
		assertEquals(o.pageList.get(2).name, "Programmer", "Title should match expected value");
		
		// job applicant
		j1.newApplicant(x);
		assertEquals(j1.appliedProfiles.get(0), x, "Profile should match expected value");
		
		
		// test news
		
		News n1 = o.createNews("Breaking News");
		assertEquals(o.pageList.get(3).name, "Breaking News", "Title should match expected value");
		assertEquals(o.newsPostings.get(0).name, "Breaking News", "Title should match expected value");
		
		// test post interactions (follows, likes, comments)
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
		
		
		// test if linking two pages of the same type works
		News n2 = o.createNews("Research");
		n1.linkPage(n2);
		assertEquals(n1.linkedPages.contains(n2), true, "Page should be linked");
		
		// link to another kind of page
		n1.linkPage(j1);
		assertEquals(n1.linkedPages.contains(j1), true, "Page should be linked");
		
		// test permissions with n1
		
		n1.updatePermissions(y); // give permissions
		assertEquals(n1.permissions.contains(y), true, "Profile should have permissions");
		n1.updatePermissions(y); // remove permissions
		assertEquals(n1.permissions.contains(y), false, "Profile should NOT have permissions");
		
		
	}
		
}