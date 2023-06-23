package com.sistemi.informativi.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sistemi.informativi.entity.Course;
import com.sistemi.informativi.entity.Review;

@Repository
@Transactional
public class CourseReviewRepositoryImpl implements CourseReviewRepository {

	//connessione con Hibernate
	@PersistenceContext
	private EntityManager em;

	@Override
	public void addCourse(Course course) {
		em.persist(course);
	}

	@Override
	public void addReview(Review review) {
		em.persist(review);
	}

	@Override
	public Course findCourseById(int id) {
		return em.find(Course.class, id);
	}

	@Override
	public List<Review> findAllReviewsByCourse(Course course) {
		/*
		 * possiamo farlo in quanto nella classe course abbiamo un array di 
		 * reviews in quanto abbiamo tra le classe un collegamento OneToMany.
		 * per cui possiamo recuperarci le reviews tramite il get che abbiamo
		 * implementato nella classe course
		 */
		return course.getReviews();
	}
}
