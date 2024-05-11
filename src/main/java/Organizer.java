
import java.util.ArrayList; 
import java.util.List; 

public class Organizer
{
	int nextId;
	List<AbstractPage> pageList;
	List<Profile> profileList;
	List<String> usernameList;
	List<Skill> skillList;
	List<Project> projectList;
	List<Jobs> jobPostings;
	List<News> newsPostings;
	
	public Organizer() {
		
		this.nextId = 0;
		this.pageList = new ArrayList<AbstractPage>();
		this.profileList = new ArrayList<Profile>();
		this.usernameList = new ArrayList<String>();
		this.skillList = new ArrayList<Skill>();
		this.projectList = new ArrayList<Project>();
		this.jobPostings = new ArrayList<Jobs>();
		this.newsPostings = new ArrayList<News>();
		
		
	}
	
	Profile createProfile(String username) {
		if(usernameList.contains(username)) {
			System.out.println("Username already exists.");
			Profile newProfile = new Profile(nextId++, username);
			return newProfile;
		} else {
			Profile newProfile = new Profile(nextId++, username);
			profileList.add(newProfile);
			pageList.add(newProfile);
			usernameList.add(username);
			newProfile.permissions.add(newProfile);
			return newProfile;
		}
	}
	
	Jobs createJob(String name) {
		Jobs newJob = new Jobs(nextId++, name);
		jobPostings.add(newJob);
		pageList.add(newJob);
		return newJob;
	}
	
	Project createProject(String name) {
		Project newProject = new Project(nextId++, name);
		projectList.add(newProject);
		pageList.add(newProject);
		return newProject;
	}
	
	News createNews(String name) {
		News newNews = new News(nextId++, name);
		newsPostings.add(newNews);
		pageList.add(newNews);
		return newNews;
	}
	
	Skill createSkills() {
		Skill newSkills = new Skill(nextId++, "New Skills");
		skillList.add(newSkills);
		pageList.add(newSkills);
		return newSkills;
	}

	/*AbstractPage linkOutside(int id) {
			for (AbstractPage p: pageList) {
		        if (p.pageId == id) {
		        	return p;
		        }
		}
	}*/
	
	AbstractPage openPage(int id) {
		for (AbstractPage p: pageList) {
	        if (p.pageId == id) {
	        	return p;
	        }
		}
		return pageList.get(0);
	}
	
	AbstractPage linkPage(int id) {
		for (AbstractPage p: pageList) {
	        if (p.pageId == id) {
	        	return p;
	        }
		}
		return pageList.get(0);
	}
	
	
}
