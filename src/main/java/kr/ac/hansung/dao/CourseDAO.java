package kr.ac.hansung.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import kr.ac.hansung.model.Course;

@Repository
public class CourseDAO {
	private JdbcTemplate jdbcTemplateObject;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	public boolean insert(Course course) {
		int year = course.getYear();
		int semester = course.getSemester();
		String code = course.getCode();
		String title = course.getTitle();
		String division = course.getDivision();
		int credit = course.getCredit();

		// year, semester, code, title, division, credit
		String sqlStatement = "insert into course (year, semester, code, title, division, credit) values (?,?,?,?,?,?)";
		return (jdbcTemplateObject.update(sqlStatement,
				new Object[] { year, semester, code, title, division, credit }) == 1);
	}

	public boolean update(Course course) {
		int year = course.getYear();
		int semester = course.getSemester();
		String code = course.getCode();
		String title = course.getTitle();
		String division = course.getDivision();
		int credit = course.getCredit();
 
		// year, semester, code, title, division, credit
		String sqlStatement = "update course set year=?, semester=?, title=?, division=?, credit=? where code=?";
		return (jdbcTemplateObject.update(sqlStatement,
				new Object[] { year, semester, title, division, credit, code }) == 1);
	}

	public boolean delete(String code) {
		String sqlStatement = "delete from course where code=?";
		return (jdbcTemplateObject.update(sqlStatement, new Object[] { code }) == 1);
	}
	
	public int getRowCount() {
		String sqlStatement = "select count(*) from course";
		return jdbcTemplateObject.queryForObject(sqlStatement, Integer.class);
	}

	public Course getCourse(String code) {
		String sqlStatement = "select * from course where code=?";
		return jdbcTemplateObject.queryForObject(sqlStatement, new Object[] { code }, new CourseMapper());
	}
	
	public int getSumCredit() {
		String sqlStatement = "select sum(credit) from course";
		return jdbcTemplateObject.queryForObject(sqlStatement, Integer.class);
	}

	public Course getCourseByYear(String year) {
		String sqlStatement = "select * from course where year=?";
		return jdbcTemplateObject.queryForObject(sqlStatement, new Object[] { year }, new CourseMapper());
	}

	public List<Course> getAllCourses() {
		String sqlStatement = "select * from course where year<2017";
		return jdbcTemplateObject.query(sqlStatement, new CourseMapper());
	}

	public List<Course> getCoursePerSemester() {
		String sqlStatement = "select year, semester, sum(credit) from course group by year, semester";
		return jdbcTemplateObject.query(sqlStatement, new RowMapper<Course>() {
			public Course mapRow(ResultSet resultSet, int rowNum) throws SQLException {
				Course course = new Course();
				course.setYear(resultSet.getInt("year"));
				course.setSemester(resultSet.getInt("semester"));
				course.setCredit(resultSet.getInt("sum(credit)"));
				return course;
			}
		});
	}

	public List<Course> getTitleListPerSemester(int year, int semester) {
		String sqlStatement = "select * from course where year=? and semester=?";
		return jdbcTemplateObject.query(sqlStatement, new Object[] { year, semester }, new CourseMapper());
	}
	
	public List<Course> getRegistrationDetails() {
		String sqlStatement = "select * from course where year=2017 and semester=1";
		return jdbcTemplateObject.query(sqlStatement, new CourseMapper());
	}

	public List<Course> getCreditsDetails() {
		String sqlStatement = "select division, sum(credit) from course group by division";
		return jdbcTemplateObject.query(sqlStatement, new RowMapper<Course>() {
			public Course mapRow(ResultSet resultSet, int rowNum) throws SQLException {
				Course course = new Course();
				course.setDivision(resultSet.getString("division"));
				course.setCredit(resultSet.getInt("sum(credit)"));
				return course;
			}
		});
	}
}
