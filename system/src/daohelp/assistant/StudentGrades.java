package daohelp.assistant;

import java.util.ArrayList;
import java.util.List;

public class StudentGrades
{
	private String student_id;
	private String student_name;
	private List<Agrade> grade_list = new ArrayList<Agrade>();
	public String getStudent_id() {
		return student_id;
	}
	public void setStudent_id(String student_id) {
		this.student_id = student_id;
	}
	public String getStudent_name() {
		return student_name;
	}
	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}
	public List<Agrade> getGrade_list() {
		return grade_list;
	}
	public void setGrade_list(List<Agrade> grade_list) {
		this.grade_list = grade_list;
	}
	
}
