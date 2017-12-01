package com.project.exam.services;

import java.util.List;

import org.springframework.stereotype.Component;

import com.project.exam.model.Program;

@Component
public interface ProgramService {
	public List<Program> getProgramList();
	public Program addProgram(Program program);
	public Program getProgram(int s_Id);
	public Program updateProgram(Program program);
	public int deleteProgram(int s_Id);
}
