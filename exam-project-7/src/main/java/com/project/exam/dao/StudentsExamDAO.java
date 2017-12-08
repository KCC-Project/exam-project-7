package com.project.exam.dao;

import java.util.List;

import com.project.exam.model.StudentsExam;

public interface StudentsExamDAO {
	public List<StudentsExam> getstudentsExamList();
	public StudentsExam addstudentsExam(StudentsExam studentsExam);
	public StudentsExam getstudentsExam(int s_Id);
	public StudentsExam updatestudentsExam(StudentsExam studentsExam);
	public int deletestudentsExam(int s_Id);
	public void getRequiredInfoTOSave(int a_program_id, int examTypeId, int semester_no);
	
}
