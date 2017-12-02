package com.project.exam.services;

import java.util.List;

import com.project.exam.model.StudentsExam;

public interface StudentsExamService {
	public List<StudentsExam> getstudentsExam();
	public StudentsExam addstudentsExam(StudentsExam studentsExam);
	public StudentsExam getstudentsExam(int s_Id);
	public StudentsExam updatestudentsExam(StudentsExam studentsExam);
	public int deletestudentsExam(int s_Id);
}
