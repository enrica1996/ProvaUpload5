package com.sistemi.informativi.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.TransactionRequiredException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistemi.informativi.entity.Course;
import com.sistemi.informativi.entity.Review;
import com.sistemi.informativi.repository.CourseReviewRepository;

@Service
public class CourseReviewServiceImpl implements CourseReviewService {

	/*
	 * il Logger serve per fare la stampa di informazioni sulla console l'API Logger
	 * fornisce 3 livelli di profondità: 1.info(meno profondo tipo syso)
	 * 2.debud(mediamente profondo) 3.error(più profondo)
	 */
	Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private CourseReviewRepository courseReviewRepository;

	@Override
	public void checkAddCourse(Course course) {

		String message = null;
		try {
			courseReviewRepository.addCourse(course);
			message = "Inserimento corso avvenuto con successo";
		} catch (IllegalArgumentException | EntityExistsException | TransactionRequiredException e) {
			e.printStackTrace();
			message = "Inserimento corso fallito";
		}

		log.info(message);

	}

	@Override
	public void checkAddReview(Review review) {

		String message = null;
		try {
			courseReviewRepository.addReview(review);
			message = "Inserimento review avvenuto con successo";
		} catch (IllegalArgumentException | EntityExistsException | TransactionRequiredException e) {
			e.printStackTrace();
			message = "Inserimento review fallito";
		}

		log.info(message);

	}

	@Override
	public void checkFindAllReviewsByCourse(int courseId) {

		List<Review> reviews = new ArrayList<>();
		Course course = courseReviewRepository.findCourseById(courseId);
		String message = null;

		if (course != null) {
			reviews = courseReviewRepository.findAllReviewsByCourse(course);
			if (!reviews.isEmpty()) {
				message = "Review relativa al corso " + course.getTitle() + " recuperate correttamente";
				reviews.forEach(review -> log.info(review.toString()));
			} else {
				message = "Non ci sono versioni relative al corso " + course.getTitle();
			}
		} else {
			message = "Non è stato possibile cercare le versioni del corso";
		}
		log.info(message);
	}
}
