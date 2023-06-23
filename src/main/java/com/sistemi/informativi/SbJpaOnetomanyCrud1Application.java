package com.sistemi.informativi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sistemi.informativi.entity.Course;
import com.sistemi.informativi.entity.Review;
import com.sistemi.informativi.service.CourseReviewService;

@SpringBootApplication
public class SbJpaOnetomanyCrud1Application implements CommandLineRunner{
@Autowired
private CourseReviewService courseReviewService;

	public static void main(String[] args) {
		SpringApplication.run(SbJpaOnetomanyCrud1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// INSERIMENTO CORSO
		Course course = new Course("Spark", "Big Data");
		courseReviewService.checkAddCourse(course);
		// INSERIMENTO REVIEW
		Review review1 = new Review("Florence");
		Review review2 = new Review("Rome");
		
		/*
		 * associazione della review1/2 al course inserito precedentemente
		 * quando avverrà l'inserimento della tabella review l'inserimento avverrà
		 * con un valore di course_id uguale all'id di course
		 */
		review1.setCourse(course);
		review2.setCourse(course);
		
		courseReviewService.checkAddReview(review1);
		courseReviewService.checkAddReview(review2);
		
		courseReviewService.checkFindAllReviewsByCourse(1);
		
	}

}
