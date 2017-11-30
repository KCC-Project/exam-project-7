package com.project.exam.services;

import java.util.List;

import com.project.exam.model.Programs;

public interface ProgramService {
	public List<Programs> getProgramList();
	public Programs addProgram(Programs program);
	public Programs getProgram(int s_Id);
	public Programs updateProgram(Programs program);
	public int deleteProgram(int s_Id);
}
