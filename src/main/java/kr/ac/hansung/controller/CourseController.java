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
		System.out.println("����Ʈ ũ�� = " + courseListBySemester.size());

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
		System.out.println("���� ����");

		String reqCode = course.getCode();

		if (courseInfo_2017_1.containsKey(reqCode)) {
			if (registeredCode_2017_1.contains(reqCode)) {
				model.addAttribute("message", "�̹� ��û�� �����Դϴ�.");
				System.out.println("��û ����");
				return "registerFail";
			} else {
				Course reqRegisterCourse = courseInfo_2017_1.get(reqCode);
				reqRegisterCourse.setCode(reqCode);

				courseService.insert(reqRegisterCourse);
				registeredCode_2017_1.add(reqCode);
				model.addAttribute("message", "����!");
				System.out.println("��û����");
				return "registerSuccess";
			}
		} else {
			model.addAttribute("message", "�̹��б⿡ �������� ���� �����Դϴ�.");
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
			courseInfoList_2017_1.add(new Course(2017, 1, "CSE0052", "	SW������׽�Ʈ", "����", 3));
			courseInfoList_2017_1.add(new Course(2017, 1, "CSE0006", "	��ü������1", "����", 3));
			courseInfoList_2017_1.add(new Course(2017, 1, "CSE0012", "	��ü������2", "����", 3));
			courseInfoList_2017_1.add(new Course(2017, 1, "CSE0055", "	���DB����", "����", 3));
			courseInfoList_2017_1.add(new Course(2017, 1, "CSE0054", "	���SW����", "����", 3));
			courseInfoList_2017_1.add(new Course(2017, 1, "CSE0019", "	�����ͺ��̽�", "����", 3));
			courseInfoList_2017_1.add(new Course(2017, 1, "CSE0015", "	���������", "����", 3));
			courseInfoList_2017_1.add(new Course(2017, 1, "CSE0044", "	��������������ȹ������", "����", 3));
			courseInfoList_2017_1.add(new Course(2017, 1, "CSE0022", "	����Ͻý���", "����", 3));
			courseInfoList_2017_1.add(new Course(2017, 1, "CSE0043", "	���������α׷���", "����", 3));
			courseInfoList_2017_1.add(new Course(2017, 1, "CSE0053", "	����ھ��ø����̼Ǳ���", "����", 3));
			courseInfoList_2017_1.add(new Course(2017, 1, "CSE0020", "	����Ʈ�������", "����", 3));
			courseInfoList_2017_1.add(new Course(2017, 1, "CSE0031", "	�ȵ���̵����α׷���1", "����", 3));
			courseInfoList_2017_1.add(new Course(2017, 1, "CSE0024", "	����ó��", "����", 3));
			courseInfoList_2017_1.add(new Course(2017, 1, "CSE0037", "	���¼ҽ�����Ʈ����", "����", 3));
			courseInfoList_2017_1.add(new Course(2017, 1, "CSE0017", "	�ü��", "����", 3));
			courseInfoList_2017_1.add(new Course(2017, 1, "CSE0023", "	���������α׷���", "����", 3));
			courseInfoList_2017_1.add(new Course(2017, 1, "CSE0032", "	�������ӿ�ũ1", "����", 3));
			courseInfoList_2017_1.add(new Course(2017, 1, "CSE0001", "	�̻����", "����", 3));
			courseInfoList_2017_1.add(new Course(2017, 1, "CSE0007", "	�ڷᱸ��", "����", 3));
			courseInfoList_2017_1.add(new Course(2017, 1, "CSE0038", "	��������", "����", 3));
			courseInfoList_2017_1.add(new Course(2017, 1, "CSE0057", "	������ǻ�ͱ���������", "����", 3));
			courseInfoList_2017_1.add(new Course(2017, 1, "CSE0025", "	ĸ���������1", "����", 3));
			courseInfoList_2017_1.add(new Course(2017, 1, "CSE0036", "	ĸ���������2", "����", 3));
			courseInfoList_2017_1.add(new Course(2017, 1, "CSE0056", "	ĸ���������3", "����", 3));
			courseInfoList_2017_1.add(new Course(2017, 1, "CSE0009", "	��ǻ�ͱ���", "����", 3));
			courseInfoList_2017_1.add(new Course(2017, 1, "CSE0021", "	��ǻ�ͱ׷��Ƚ�", "����", 3));
			courseInfoList_2017_1.add(new Course(2017, 1, "CSE0002", "	��ǻ�����α׷���1", "����", 3));
			courseInfoList_2017_1.add(new Course(2017, 1, "CSE0010", "	���α׷��ַ�", "����", 3));
			courseInfoList_2017_1.add(new Course(2017, 1, "CSE0005", "	Ȯ�������", "����", 3));
			debugFlag = false;
		}
	}

	public void intoHashMap() {
		for (int i = 0; i < courseInfoList_2017_1.size(); i++) {
			courseInfo_2017_1.put(courseInfoList_2017_1.get(i).getCode(), courseInfoList_2017_1.get(i));
		}
	}
}
