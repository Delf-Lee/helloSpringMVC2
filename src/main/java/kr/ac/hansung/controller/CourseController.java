package kr.ac.hansung.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.ac.hansung.model.Course;
import kr.ac.hansung.service.CourseService;

/* client request processing (at home) */
@Controller
public class CourseController {

	private ArrayList<Course> courseInfoList_2017_1 = new ArrayList<Course>();
	private HashMap<String, Course> courseInfo_2017_1 = new HashMap<String, Course>();
	private ArrayList<String> registeredCode_2017_1 = new ArrayList<String>();
	private CourseService courseService;
	
	private boolean debugFlag = true;

	@Autowired
	public void setCourseService(CourseService courseService) {
		this.courseService = courseService;
	}

	@RequestMapping("/course")
	public String showAllCourse(Model model) {
		List<Course> course = courseService.getCurrent();

		model.addAttribute("course", course);
		return "course";
	}

	@RequestMapping("/creditBySemester")
	public String showCoursePerSemester(Model model) {
		List<Course> creditBySemester = courseService.getCoursePerSemester();

		model.addAttribute("creditBySemester", creditBySemester);
		return "creditBySemester";
	}

	@RequestMapping("/courseListBySemester")
	public String showTitleListPerSemester(Model model, int year, int semester) {

		System.out.println("courseListPerSemester");
		System.out.println("year: " + year);
		System.out.println("semester: " + semester);

		List<Course> courseListBySemester = courseService.getTitleListPerSemester(year, semester);
		System.out.println("리스트 크기 = " + courseListBySemester.size());

		model.addAttribute("courseListBySemester", courseListBySemester);
		return "courseListBySemester";
	}

	@RequestMapping("/creditByDivision")
	public String showCreditDetails(Model model) {
		int totalCredits = courseService.getSumCredit();
		List<Course> creditByDivision = courseService.getCreditsDetails();

		model.addAttribute("totalCredits", totalCredits);
		model.addAttribute("creditByDivision", creditByDivision);
		return "creditByDivision";
	}

	@RequestMapping("/courseRegister")
	public String courseRegister(Model model) {
		// return Empty instance to save user input text
		// model.addAttribute(new Course());
		intoList();
		intoHashMap();
		model.addAttribute("courseInfoList", courseInfoList_2017_1);
		model.addAttribute(new Course());
		return "courseRegister";
	}

	@RequestMapping("/doRegister")
	public String doRegister(Model model, @Valid Course course, BindingResult result) {
		if (result.hasErrors()) {
			System.out.println("Form data does not validate");
			List<ObjectError> errors = result.getAllErrors();
			for (ObjectError error : errors) {
				System.out.println(error.getDefaultMessage());
			}
			return "courseRegister";
		}
		System.out.println("에러 없음");

		String reqCode = course.getCode();

		if (courseInfo_2017_1.containsKey(reqCode)) {
			if (registeredCode_2017_1.contains(reqCode)) {
				model.addAttribute("message", "이미 신청한 강좌입니다.");
				System.out.println("신청 실패");
				return "registerFail";
			} else {
				Course reqRegisterCourse = courseInfo_2017_1.get(reqCode);
				reqRegisterCourse.setCode(reqCode);

				courseService.insert(reqRegisterCourse);
				registeredCode_2017_1.add(reqCode);
				model.addAttribute("message", "성공!");
				System.out.println("신청성공");
				return "registerSuccess";
			}
		} else {
			model.addAttribute("message", "이번학기에 개설되지 않은 강좌입니다.");
			return "registerFail";
		}
	}

	@RequestMapping("/registrationDetails")
	public String showRegistration(Model model) {
		List<Course> registrationDetails = courseService.getRegistrationDetails();

		model.addAttribute("registrationDetails", registrationDetails);
		return "registrationDetails";
	}

	public void intoList() {
		if (debugFlag) {
			courseInfoList_2017_1.add(new Course(2017, 1, "CSE0052", "	SW설계및테스트", "전선", 3));
			courseInfoList_2017_1.add(new Course(2017, 1, "CSE0006", "	객체지향언어1", "전선", 3));
			courseInfoList_2017_1.add(new Course(2017, 1, "CSE0012", "	객체지향언어2", "전선", 3));
			courseInfoList_2017_1.add(new Course(2017, 1, "CSE0055", "	고급DB설계", "전선", 3));
			courseInfoList_2017_1.add(new Course(2017, 1, "CSE0054", "	고급SW설계", "전선", 3));
			courseInfoList_2017_1.add(new Course(2017, 1, "CSE0019", "	데이터베이스", "전지", 3));
			courseInfoList_2017_1.add(new Course(2017, 1, "CSE0015", "	데이터통신", "전선", 3));
			courseInfoList_2017_1.add(new Course(2017, 1, "CSE0044", "	디지털콘텐츠기획및제작", "전선", 3));
			courseInfoList_2017_1.add(new Course(2017, 1, "CSE0022", "	모바일시스템", "전선", 3));
			courseInfoList_2017_1.add(new Course(2017, 1, "CSE0043", "	빅데이터프로그래밍", "전선", 3));
			courseInfoList_2017_1.add(new Course(2017, 1, "CSE0053", "	사용자어플리케이션구현", "전선", 3));
			courseInfoList_2017_1.add(new Course(2017, 1, "CSE0020", "	소프트웨어공학", "전선", 3));
			courseInfoList_2017_1.add(new Course(2017, 1, "CSE0031", "	안드로이드프로그래밍1", "전선", 3));
			courseInfoList_2017_1.add(new Course(2017, 1, "CSE0024", "	영상처리", "전선", 3));
			courseInfoList_2017_1.add(new Course(2017, 1, "CSE0037", "	오픈소스소프트웨어", "전선", 3));
			courseInfoList_2017_1.add(new Course(2017, 1, "CSE0017", "	운영체제", "전지", 3));
			courseInfoList_2017_1.add(new Course(2017, 1, "CSE0023", "	웹서버프로그래밍", "전선", 3));
			courseInfoList_2017_1.add(new Course(2017, 1, "CSE0032", "	웹프레임워크1", "전선", 3));
			courseInfoList_2017_1.add(new Course(2017, 1, "CSE0001", "	이산수학", "전기", 3));
			courseInfoList_2017_1.add(new Course(2017, 1, "CSE0007", "	자료구조", "전지", 3));
			courseInfoList_2017_1.add(new Course(2017, 1, "CSE0038", "	정보보안", "전선", 3));
			courseInfoList_2017_1.add(new Course(2017, 1, "CSE0057", "	정보컴퓨터교과교육론", "전선", 3));
			courseInfoList_2017_1.add(new Course(2017, 1, "CSE0025", "	캡스톤디자인1", "전지", 3));
			courseInfoList_2017_1.add(new Course(2017, 1, "CSE0036", "	캡스톤디자인2", "전지", 3));
			courseInfoList_2017_1.add(new Course(2017, 1, "CSE0056", "	캡스톤디자인3", "전지", 3));
			courseInfoList_2017_1.add(new Course(2017, 1, "CSE0009", "	컴퓨터구조", "전선", 3));
			courseInfoList_2017_1.add(new Course(2017, 1, "CSE0021", "	컴퓨터그래픽스", "전선", 3));
			courseInfoList_2017_1.add(new Course(2017, 1, "CSE0002", "	컴퓨터프로그래밍1", "전기", 3));
			courseInfoList_2017_1.add(new Course(2017, 1, "CSE0010", "	프로그래밍랩", "전선", 3));
			courseInfoList_2017_1.add(new Course(2017, 1, "CSE0005", "	확률및통계", "전선", 3));
			debugFlag = false;
		}
	}

	public void intoHashMap() {
		for (int i = 0; i < courseInfoList_2017_1.size(); i++) {
			courseInfo_2017_1.put(courseInfoList_2017_1.get(i).getCode(), courseInfoList_2017_1.get(i));
		}
	}
}
