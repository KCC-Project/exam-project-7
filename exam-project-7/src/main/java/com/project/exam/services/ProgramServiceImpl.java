package com.project.exam.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.exam.dao.ProgramDAO;
import com.project.exam.model.Programs;

@Service
public class ProgramServiceImpl implements ProgramService {

	@Autowired
	private ProgramDAO programDAO;
	
	public List<Programs> getProgramList() {
		return programDAO.getProgramList();
	}

	@Override
	public Programs addProgram(Programs program) {
		return programDAO.addProgram(program);
	}

	@Override
	public Programs getProgram(int s_Id) {
		return programDAO.getProgram(s_Id);
	}

	@Override
	public Programs updateProgram(Programs program) {
		return programDAO.updateProgram(program);
	}

	@Override
	public int deleteProgram(int s_Id) {
		return programDAO.deleteProgram(s_Id);
	}

}
