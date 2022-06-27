package com.surecloud.javatechnicalinterview.api.dto;

import java.time.LocalDate;
import java.util.UUID;

public class CandidateDTO {

	private UUID id;

	private String name;
	private int score;
	private LocalDate dateTaken;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public LocalDate getDateTaken() {
		return dateTaken;
	}

	public void setDateTaken(LocalDate dateTaken) {
		this.dateTaken = dateTaken;
	}

}
