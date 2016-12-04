package kr.ac.hansung.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.hansung.dao.CourseDAO;
import kr.ac.hansung.model.Course;

@Service
public class CourseService {
	private CourseDAO courseDAO;

	@Autowired
	public void setCourseDAO(CourseDAO courseDAO) {
		this.courseDAO = courseDAO;
	}

	public List<Course> getCurrent() {
		return courseDAO.getAllCourses();
	}

	public int getSumCredit() {
		return courseDAO.getSumCredit();
	}

	public List<Course> getCoursePerSemester() {
		return courseDAO.getCoursePerSemester();
	}

	public List<Course> getTitleListPerSemester(int year, int semester) {
		return courseDAO.getTitleListPerSemester(year, semester);
	}

	public List<Course> getCreditsDetails() {
		return courseDAO.getCreditsDetails();
	}
	
	public List<Course> getRegistrationDetails(){
		return courseDAO.getRegistrationDetails();
	}

	public void insert(Course course) {
		courseDAO.insert(course);
	}
}
