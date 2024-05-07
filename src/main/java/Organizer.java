
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
		Profile newProfile = new Profile(nextId++, username);
		profileList.add(newProfile);
		pageList.add(newProfile);
		return newProfile;
	}
	
	Jobs createJob() {
		Jobs newJob = new Jobs(nextId++, "New Post");
		jobPostings.add(newJob);
		pageList.add(newJob);
		return newJob;
	}
	
	Project createProject() {
		Project newProject = new Project(nextId++, "New Project");
		projectList.add(newProject);
		pageList.add(newProject);
		return newProject;
	}
	
	News createNews() {
		News newNews = new News(nextId++, "New News");
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
