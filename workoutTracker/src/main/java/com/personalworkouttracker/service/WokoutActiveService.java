package com.personalworkouttracker.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.personalworkouttracker.entity.WorkoutTracker;
import com.personalworkouttracker.repository.WorkoutActiveRepository;

public class WokoutActiveService {
	private EntityManager em;
	WorkoutActiveRepository obj = new WorkoutActiveRepository();

	public WokoutActiveService() {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("test");

		em = emf.createEntityManager();
	}

	public void calculate_calories(int id) throws ParseException {
		WorkoutTracker esc = em.find(WorkoutTracker.class, id);

		SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
		Date date1 = format.parse(esc.getStart_datetime());
		Date date2 = format.parse(esc.getEnd_datetime());
		long difference = date2.getTime() - date1.getTime();
		long miliseconds = difference / 1000;

		obj.Total_Calories(calculateCalories(miliseconds / 60), id);

	}

	public int calculateCalories(long value) {
		int count = 0;

		if (value > 2) {

			if (value > 60) {
				count = 25;
			} else if (value > 40) {
				count = 17;
			} else if (value > 20) {
				count = 12;
			} else if (value > 10) {
				count = 6;
			}
		} else {
			count = 1;

		}
		return count;

	}

}