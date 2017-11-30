package com.project.exam.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.exam.dao.ProgramDAO;
import com.project.exam.model.Programs;

@Service
public class ProgramServiceImpl implements ProgramService {

	@Autowired
	private ProgramDAO programDao;
	
	public List<Programs> getProgramList() {
		return programDao.getProgramList();
	}

	@Override
	public Programs addProgram(Programs program) {
		return programDao.addProgram(program);
	}

	@Override
	public Programs getProgram(int s_Id) {
		return programDao.getProgram(s_Id);
	}

	@Override
	public Programs updateProgram(Programs program) {
		return programDao.updateProgram(program);
	}

	@Override
	public int deleteProgram(int s_Id) {
		return programDao.deleteProgram(s_Id);
	}

}
