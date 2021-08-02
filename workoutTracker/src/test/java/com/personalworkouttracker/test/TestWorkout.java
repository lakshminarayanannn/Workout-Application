package com.personalworkouttracker.test;

import static org.junit.Assert.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.personalworkouttracker.entity.Category;
import com.personalworkouttracker.entity.Workout;
import com.personalworkouttracker.repository.WorkoutRepository;

public class TestWorkout {
	private EntityManager em;
	WorkoutRepository obj = new WorkoutRepository();
	Category category = new Category("strength");
	Category c1 = new Category("flexibility");
	Category c2 = new Category("endurance");

	// @Test
	public void testAddWorkout() {
		Workout workout = new Workout("Swimming", "this comes under endurance category", 50, c2);

		Workout wc2 = new Workout("Lifting weights", "this comes under strength category", 56, category);
		Workout wc3 = new Workout("calf stretch", "this comes under flexibility category", 60, c1);
		Workout wc4 = new Workout("Using resistance band", "this comes under strength category", 150, category);
		obj.addWorkout(workout);
		obj.addWorkout(wc2);
		obj.addWorkout(wc3);
		obj.addWorkout(wc4);

	}

	// @Test
	public void testAddWorkoutFail() throws Exception {
		Workout wc4 = new Workout("Using resistance band", "this comes under strength category", 150, category);
		obj.addWorkout(wc4);
	}

	// @Test
	public void testEditWorkout(int id) {
		
		obj.updateWorkout(id);
	}

	// @Test
	public void testEditWorkoutFail(int id) throws Exception {
		Workout workout = new Workout("Swimming", "this comes under endurance category", 50, c1);
		obj.updateWorkout(id);
	}

	// @Test
	public void testDeleteWorkout() {
		obj.deleteWorkout(5);

	}

	// @Test
	public void testDeleteWorkoutFail() throws Exception {
		obj.deleteWorkout(17);
	}

	// @Test
	public void testFindWorkoutByTitle() {
		obj.findByTitle("swimming");
	}

	// @Test
	public void testFindWorkoutByTitleFail() throws Exception {
		obj.findByTitle("running");

	}
}