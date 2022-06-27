package com.surecloud.javatechnicalinterview.domain.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.surecloud.javatechnicalinterview.domain.model.Candidate;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate, Long> {

	@Query("from Candidate c where c.id = :id")
	Optional<Candidate> searchById(@Param("id") UUID id);
}
