package com.surecloud.javatechnicalinterview;

import java.time.LocalDate;
import java.util.UUID;

import com.surecloud.javatechnicalinterview.domain.model.Candidate;

public class CandidateFactoryTest {

	public static Candidate createValidCandidate() {
		return new Candidate(UUID.randomUUID(), "Rafael", 50, LocalDate.now());
	}
}
