package com.project.exam.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "semesters_has_semesters_infos")
public class SemSemestersInfos {

	@Id
	private int sem_semesters_info_id;
	
	private SemestersInfos semestersInfos;
	private Semesters semesters;
	
	
}
