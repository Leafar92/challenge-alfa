package com.surecloud.javatechnicalinterview.api.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.surecloud.javatechnicalinterview.api.assembler.CandidateAssembler;
import com.surecloud.javatechnicalinterview.api.assembler.CandidateDisassembler;
import com.surecloud.javatechnicalinterview.api.dto.CandidateDTO;
import com.surecloud.javatechnicalinterview.api.dto.input.CandidateSaveDTO;
import com.surecloud.javatechnicalinterview.domain.model.Candidate;
import com.surecloud.javatechnicalinterview.domain.service.CandiateService;

@RestController
@RequestMapping("/candidates")
public class CandidateController {

	@Autowired
	private CandiateService candiateService;

	@Autowired
	private CandidateAssembler candidateAssembler;
	
	@Autowired
	private CandidateDisassembler candidateDisassembler;

	@GetMapping
	public List<CandidateDTO> getAll() {
		List<Candidate> candidates = candiateService.getAll();
		return candidateAssembler.toDTOList(candidates);
	}

	@GetMapping("/{id}")
	public CandidateDTO getByID(@PathVariable UUID id) {
		Candidate candidate = candiateService.findByID(id);
		return candidateAssembler.toDTO(candidate);
	}
	
	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	public CandidateDTO save(@RequestBody CandidateSaveDTO candidateDTO) {
		Candidate candidateToBeSaved = candidateDisassembler.toModel(candidateDTO);
		 candidateToBeSaved = candiateService.save(candidateToBeSaved);
		 
		 return candidateAssembler.toDTO(candidateToBeSaved);
	}

}
