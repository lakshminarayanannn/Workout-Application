package com.personalworkouttracker.client;
import java.util.Scanner;

import com.personalworkouttracker.entity.*;

import com.personalworkouttracker.repository.*;;

public class WorkoutClient {

	public static void main(String[] args) throws Exception {

		WorkoutRepository objRepository = new WorkoutRepository();

		Scanner inp = new Scanner(System.in);
		System.out.println("1).Add Workout \n2).Update WorkoutTitle \n3).Delete WorkoutTitle \n4).Find WorkoutByid \n5).Find WorkoutByTitle \n6).Exit");
		int value = inp.nextInt();
		switch (value) {
		case 1:
			System.out.println("Enter Workout Title:");
			String title = inp.next();
			
			System.out.println("Enter cbpm:");
			int cbpm = inp.nextInt(); 
			
			System.out.println("Enter note:");
			String note = inp.next();
			
		
			
			System.out.println("Enter your Category:(strength/flexibility/endurance/balance):");
			String category = inp.next();
		
			
			Category categoryobj = new Category(category);
			Workout workoutobj = new Workout(title, note,cbpm,categoryobj);
			objRepository.addWorkout(workoutobj);
			break;

		
		case 2:
			System.out.println("Enter id");
			
		//	String st = inp.nextLine();
		int id1 = inp.nextInt();
	 objRepository.updateWorkout(id1);
			break;
		
		case 3:
			System.out.println("Enter the id to be deleted");
			int id2 = inp.nextInt();
			//inp.next();
			objRepository.deleteWorkout(id2);
			break;
		case 4:
			System.out.println("Enter the id to be Found");
			int id3 = inp.nextInt();
		//	inp.next();
			objRepository.findByid(id3);
			break;
		
		case 5:
			System.out.println("Enter the title to be Found");
			String title1 = inp.next();
		//	inp.next();
			objRepository.findByTitle(title1);
			break;
		case 6:
			System.exit(0);

		default:
			break;
		}
	}
}