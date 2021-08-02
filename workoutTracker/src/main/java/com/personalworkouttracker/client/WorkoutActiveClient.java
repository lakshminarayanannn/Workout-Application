package com.personalworkouttracker.client;

import java.util.Scanner;
import java.text.ParseException;
import com.personalworkouttracker.entity.Role;
import com.personalworkouttracker.entity.User;
import com.personalworkouttracker.entity.WorkoutTracker;
import com.personalworkouttracker.repository.UserRepository;
import com.personalworkouttracker.repository.WorkoutActiveRepository;
import com.personalworkouttracker.service.WokoutActiveService;

public class WorkoutActiveClient {

	public static void main(String[] args) throws ParseException {
		UserRepository rep = new UserRepository();

		WokoutActiveService serv = new WokoutActiveService();

		WorkoutActiveRepository objRepository = new WorkoutActiveRepository();

		Scanner inp = new Scanner(System.in);
		System.out.println(
				"1).Assign Workout to user \n2).Start Workout for User \n3).End Workout for User \n4).Caculate Calories for User \n5).display \n6).Exit");
		int value = inp.nextInt();
		switch (value) {
		case 1:
			System.out.println("Enter user id");
			int id = inp.nextInt();
			User user = rep.getUserById(id);
			WorkoutTracker work = new WorkoutTracker(101, "Jogging", id, user.getEmail());
			objRepository.assignWorkoutToUser(work);
			break;

		case 2:
			System.out.println("Enter user id for startwork");
			int sid = inp.nextInt();
			objRepository.StartWorkout(sid);
			break;

		case 3:
			System.out.println("Enter user id for endwork");
			int eid = inp.nextInt();
			objRepository.EndWorkout(eid);
			break;

		case 4:
			System.out.println("Enter the user id to calculate");
			int cid = inp.nextInt();
			serv.calculate_calories(cid);
			break;

		case 5:
			System.out.println("Display");
			String email = inp.next();
			objRepository.displayByEmail(email);
			break;
		case 6:
			System.exit(0);

		default:
			break;
		}
	}
}