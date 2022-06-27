package com.surecloud.javatechnicalinterview.domain.model;

import java.time.LocalDate;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "Result")
public class Candidate {

	public Candidate(UUID id, String name, int score, LocalDate dateTaken) {
		this.id = id;
		this.name = name;
		this.score = score;
		this.dateTaken = dateTaken;
	}

	@Id
	private UUID id;

	private String name;
	private int score;
	private LocalDate dateTaken;

	public UUID getId() {
		return id;
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

	public void createID() {
		this.id = UUID.randomUUID();
	}

}
