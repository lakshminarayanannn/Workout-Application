package com.personalworkouttracker.test;

import java.text.ParseException;
import com.personalworkouttracker.entity.User;
import com.personalworkouttracker.entity.WorkoutTracker;
import com.personalworkouttracker.exception.ValidationException;
import com.personalworkouttracker.repository.UserRepository;
import com.personalworkouttracker.repository.WorkoutActiveRepository;
import com.personalworkouttracker.service.WokoutActiveService;

import org.junit.Test;

public class WorkoutActiveTest {

	UserRepository rep = new UserRepository();
	WokoutActiveService serv = new WokoutActiveService();
	WorkoutActiveRepository obj = new WorkoutActiveRepository();
	int id = 1;

	// @Test
	public void testAssignWorkoutToUser() {

		User user = rep.getUserById(id);
		System.out.println(user);
		WorkoutTracker work = new WorkoutTracker(101, "Jogging", id, user.getEmail());
		obj.assignWorkoutToUser(work);

	}

	

	// @Test
	public void testStartWorkout() {

		obj.StartWorkout(id);
	}

	@Test
	public void testStartWorkoutFail() {
		obj.StartWorkout(17);
	}

	//@Test
	public void testEndWorkout() {
		obj.EndWorkout(id);
	}

	//@Test
	public void testEndWorkoutFail() throws ValidationException {
		obj.EndWorkout(88);
	}

	// @Test
	public void testCalculateCalories() throws ParseException {
		serv.calculate_calories(id);
	}

	// @Test
	public void testDisplayrecord() {
		obj.displayrecord();
	}

	// @Test
	public void displayParticular() {
		obj.displayByEmail("murali@123.com");
	}

}