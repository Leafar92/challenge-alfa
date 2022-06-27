package com.surecloud.javatechnicalinterview.api.dto.input;

import java.time.LocalDate;

public class CandidateSaveDTO {

	private String name;
	private int score;
	private LocalDate dateTaken;

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
