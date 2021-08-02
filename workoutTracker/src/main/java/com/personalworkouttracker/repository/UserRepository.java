package com.personalworkouttracker.repository;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import com.personalworkouttracker.entity.Role;
import com.personalworkouttracker.entity.User;
import com.personalworkouttracker.exception.ValidationException;

public class UserRepository {

	private EntityManager em;

	public UserRepository() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("test");
		em = emf.createEntityManager();

	}

	public void addUser(User user) throws ValidationException {

		em.getTransaction().begin();
		
		TypedQuery<Role> query = em.createQuery("select r from Role r where r.role_name=:rolename", Role.class);
		query.setParameter("rolename", user.getRole().getRole_name());

		Role role =user.getRole();
		Role existingRole = query.getSingleResult();

		if (existingRole.getRole_name().equals(role.getRole_name())) {
		user.setRole(existingRole);
		}
		
		em.persist(user);
		em.getTransaction().commit();


	}

	public User getUserById(int id) {
		User use = em.find(User.class, id);
		return use;
	}

	public boolean loginTest(String email, String password) {

		TypedQuery<User> query = em.createQuery("select u from User u where u.email=:emailname ", User.class);

		query.setParameter("emailname", email);
		User existinguser = query.getSingleResult();

		if (existinguser.getEmail().equals(email) && existinguser.getPassword().equals(password)) {
			System.out.println("sucessful login");
			return true;
		}

		else {
			System.out.println("Use correct email and password");
			return false;
		}

	}

	public void editUser(User user) {
		
		
		em.getTransaction().begin();
		em.merge(user);
		em.getTransaction().commit();
	}

	public User deleteUser(int id,String email) {
		TypedQuery<User> query = em.createQuery("SELECT u FROM User u where u.email=:nameparam ", User.class);
		query.setParameter("nameparam", email);
		User user = query.getSingleResult();
		em.getTransaction().begin();
		User foundUser = em.find(User.class, id);
		
		em.remove(foundUser); 
		em.getTransaction().commit();
		user=null;
		return user;

	}

	public User findUser(String email) {
		TypedQuery<User> query = em.createQuery("SELECT u FROM User u where u.email=:name ", User.class);
		query.setParameter("name", email);
		User user = query.getSingleResult();
		
		return user;

	}
	public List<User> findAllUser()
	{
		TypedQuery<User> query = em.createQuery("SELECT u FROM User u", User.class);
		List<User> userList = query.getResultList();
		return userList;

		
	}

}
