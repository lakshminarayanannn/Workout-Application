package com.personalworkouttracker.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.personalworkouttracker.entity.Category;
import com.personalworkouttracker.entity.Workout;

import javax.persistence.TypedQuery;

public class WorkoutRepository {
	
	private EntityManager em;
	
	
	public WorkoutRepository()
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("test");
	    em = emf.createEntityManager();
	
	}
	public void addWorkout(Workout workout)
	{
		em.getTransaction().begin();
		Category category = workout.getCategory();
		TypedQuery<Category> query = em.createQuery("select c from Category c where c.cname=:cname", Category.class);
		
		query.setParameter("cname",workout.getCategory().getCname());
		System.out.println(workout.getCategory().getCname());
		Category existingCategory = query.getSingleResult();
		
		if(existingCategory.getCname().equals(category.getCname())) {
			workout.setCategory(existingCategory);
		}
		

		em.persist(workout);
		em.getTransaction().commit();
		
		
		 
	}
	public void updateWorkout(int id)
	{   
		
		em.getTransaction().begin();
		Workout foundworkout = em.find(Workout.class,id);
	    foundworkout.setTitle("dancing");
		em.merge(foundworkout);  
		em.getTransaction().commit();
	
	}
	public void deleteWorkout(int id)
	{
		em.getTransaction().begin();
		Workout foundworkout = em.find(Workout.class,id);
		em.remove(foundworkout);
		em.getTransaction().commit();
	
	}
	
	public void findByid(int id)
	{
		TypedQuery<Workout> query = em.createQuery("SELECT u FROM Workout u where u.id=:entityId ", Workout.class);
		query.setParameter("entityId", id);
       Workout w = query.getSingleResult();
		System.out.println(w);
		
		
	}
	
	public void findByTitle(String title)
	{
		TypedQuery<Workout> query = em.createQuery("SELECT u FROM Workout u where title=:nameparam ", Workout.class);
		query.setParameter("nameparam", title);
       Workout w = query.getSingleResult();
		System.out.println(w);
		
		
	}
}