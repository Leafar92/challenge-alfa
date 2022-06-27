package com.surecloud.javatechnicalinterview.api.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.surecloud.javatechnicalinterview.api.dto.CandidateDTO;
import com.surecloud.javatechnicalinterview.domain.model.Candidate;

@Component
public class CandidateAssembler {

	@Autowired
	private ModelMapper mapper;

	public CandidateDTO toDTO(Candidate candidate) {
		return mapper.map(candidate, CandidateDTO.class);
	}

	public List<CandidateDTO> toDTOList(List<Candidate> candidates) {
		return candidates.stream().map(c -> toDTO(c)).collect(Collectors.toList());
	}
}
