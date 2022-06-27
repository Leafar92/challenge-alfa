package com.surecloud.javatechnicalinterview.api.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.surecloud.javatechnicalinterview.api.dto.input.CandidateSaveDTO;
import com.surecloud.javatechnicalinterview.domain.model.Candidate;

@Component
public class CandidateDisassembler {

	@Autowired
	private ModelMapper mapper;

	public Candidate toModel(CandidateSaveDTO candidate) {
		return mapper.map(candidate, Candidate.class);
	}

}
