package com.surecloud.javatechnicalinterview;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.surecloud.javatechnicalinterview.api.exception.ResourceNotFoundException;
import com.surecloud.javatechnicalinterview.domain.model.Candidate;
import com.surecloud.javatechnicalinterview.domain.repository.CandidateRepository;
import com.surecloud.javatechnicalinterview.domain.service.CandiateService;

@ExtendWith(SpringExtension.class)
public class CandidateServiceTest {

	@InjectMocks
	private CandiateService candidateService;

	@Mock
	private CandidateRepository candidateRepositoryMock;

	@BeforeEach
	void setUp() {
		BDDMockito.when(candidateRepositoryMock.searchById(ArgumentMatchers.any(UUID.class)))
				.thenReturn(Optional.of(CandidateFactoryTest.createValidCandidate()));

		BDDMockito.when(candidateRepositoryMock.save(ArgumentMatchers.any(Candidate.class)))
				.thenReturn(CandidateFactoryTest.createValidCandidate());

		BDDMockito.when(candidateService.getAll()).thenReturn(Arrays.asList(CandidateFactoryTest.createValidCandidate(),
				CandidateFactoryTest.createValidCandidate()));

	}

	@Test
	void itShoulReturnAValidCandidate() {
		Candidate found = candidateService.findByID(UUID.randomUUID());
		Candidate expected = CandidateFactoryTest.createValidCandidate();
		assertThat(found).isNotNull();
		assertThat(found.getName()).isEqualTo(expected.getName());

	}

	@Test
	void itShoulSaveAValidCandidate() {
		Candidate saved = candidateService.save(CandidateFactoryTest.createValidCandidate());
		Candidate expected = CandidateFactoryTest.createValidCandidate();

		assertThat(saved).isNotNull();
		assertThat(saved.getName()).isEqualTo(expected.getName());

	}

	@Test
	void itShoulReturnAList() {
		int size = 2;
		List<Candidate> result = candidateService.getAll();
		assertThat(result).isNotEmpty().hasSize(size);

	}
	
}
