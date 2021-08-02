package com.personalworkouttracker.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.personalworkouttracker.entity.User;
import com.personalworkouttracker.exception.ValidationException;
import com.personalworkouttracker.repository.UserRepository;

public class UserService {

	UserRepository userRepository = new UserRepository();
	private EntityManager em;

	public UserService() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("test");
		em = emf.createEntityManager();

	}

	public void add(User user) throws ValidationException {
		String passwordPattern = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";
		String password = user.getPassword();
		String email = user.getEmail();
		String emailPattern = "^(.+)@(.+)$";

		if (email.matches(emailPattern)) 
		{
			if (password.matches(passwordPattern)) 
			{

				userRepository.addUser(user);
			} 
			else 
			{
				throw new ValidationException("use correct password");
			}
		} else 
		{
			throw new ValidationException("use correct Email");
		}

	}

	public User editUser(int id, String email) {

		User foundUser = em.find(User.class, id);
		foundUser.setEmail(email);
		userRepository.editUser(foundUser);
		return foundUser;
		//userRepository.editUser(user);

	}

}
