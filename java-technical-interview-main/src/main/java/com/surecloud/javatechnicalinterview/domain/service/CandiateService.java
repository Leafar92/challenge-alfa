package com.surecloud.javatechnicalinterview.domain.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.surecloud.javatechnicalinterview.api.exception.ResourceNotFoundException;
import com.surecloud.javatechnicalinterview.domain.model.Candidate;
import com.surecloud.javatechnicalinterview.domain.repository.CandidateRepository;

@Service
public class CandiateService {

	@Autowired
	private CandidateRepository candidateRepository;
	
	public List<Candidate> getAll(){
		return candidateRepository.findAll();
	}
	
	public Candidate findByID(UUID id) {
		return candidateRepository.searchById(id).orElseThrow(() -> 
		new ResourceNotFoundException(String.format("The Candidate of id %d was not found", id)));
	}
	
	@Transactional
	public Candidate save(Candidate candidate) {
		candidate.createID();
		return candidateRepository.save(candidate);
	}
}
