package com.project.exam.services;

import java.util.List;

import com.project.exam.model.StudentsProgram;

public interface StudentsProgramService {
	public List<StudentsProgram> getStudentsProgramList();
	public StudentsProgram addStudentsProgram(StudentsProgram studentsProgram);
	public StudentsProgram getStudentsProgram(int s_Id);
	public StudentsProgram updateStudentsProgram(StudentsProgram studentsProgram);
	public int deleteStudentsProgram(int s_Id);
}
