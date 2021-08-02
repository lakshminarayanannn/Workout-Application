package com.personalworkouttracker.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@Table(name = "WORKOUT")
public class Workout {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(unique = true)
	String title;
	String note;
	int cbpm;

	@ManyToOne(cascade = CascadeType.ALL)
	private Category category;

	public Workout() {
	}

	public Workout(String title, String note, int cbpm, Category category) {
		super();
		this.title = title;
		this.note = note;
		this.cbpm = cbpm;
		this.category = category;
	}

	public int getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public int getCbpm() {
		return cbpm;
	}

	public void setCbpm(int cbpm) {
		this.cbpm = cbpm;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Workout [title=" + title + ", note=" + note + ", cbpm=" + cbpm + "]";
	}

}