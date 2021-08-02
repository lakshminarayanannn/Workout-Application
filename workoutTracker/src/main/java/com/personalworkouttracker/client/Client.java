package com.personalworkouttracker.client;

import java.util.List;
import java.util.Scanner;
import com.personalworkouttracker.entity.Role;
import com.personalworkouttracker.entity.User;
import com.personalworkouttracker.exception.ValidationException;
import com.personalworkouttracker.repository.UserRepository;
import com.personalworkouttracker.service.UserService;

public class Client {

	public static void main(String[] args) throws ValidationException {

		UserRepository objRepository = new UserRepository();
		UserService userServiceOjb = new UserService();
		Scanner inp = new Scanner(System.in);
		while (true) {
			System.out.println(
					"1).Add User \n2).Login User \n3).Edit User \n4).Delete User \n5).Find User \n 6).ViewAllUser \n 7).Exit");
			int value = inp.nextInt();

			switch (value) {
			case 1:
				System.out.println("Enter your Email:");
				String email = inp.next();
				System.out.println("Enter your password:");
				String password = inp.next();
				System.out.println("Enter your height:");
				int height = inp.nextInt();
				System.out.println("Enter your weight:");
				int weight = inp.nextInt();
				System.out.println("Enter your Role:(Admin/Trainer/User):");
				String role = inp.next();

				Role roleobj = new Role(role);
				User userobj = new User(email, password, height, weight, roleobj);
				userServiceOjb.add(userobj);
				break;

			case 2:
				
				System.out.println("Enter your Email:");
				String email1 = inp.next();

				System.out.println("Enter your Password");
				String password1 = inp.next();

				objRepository.loginTest(email1, password1);
				break;
				
			case 3:
				
				System.out.println("Enter your id");
				int id = inp.nextInt();
				
				System.out.println("Enter your new Email");
				String newEmail = inp.next();	
				
				userServiceOjb.editUser(id,newEmail);
				break;
				
			case 4:
				System.out.println("Enter the user to be deleted");
				String email2 = inp.next();
				
				System.out.println("enter the user id");
				int iddd = inp.nextInt();
				
				objRepository.deleteUser(iddd, email2);
				break;
			case 5:
				System.out.println("Enter the user to be Found");
				String email3 = inp.next();

				System.out.println(objRepository.findUser(email3));
				break;
			case 6:
				List<User> userList = objRepository.findAllUser();
				for (User u : userList) {
					System.out.println(u);
				}

			case 7:
				System.exit(0);
			default:
				break;
			}
		}
	}
}
