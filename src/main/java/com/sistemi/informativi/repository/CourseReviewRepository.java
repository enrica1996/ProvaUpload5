package com.sistemi.informativi.repository;

import java.util.List;

import com.sistemi.informativi.entity.Course;
import com.sistemi.informativi.entity.Review;

public interface CourseReviewRepository {

	public void addCourse(Course course);

	public void addReview(Review review);
	
	public Course findCourseById(int id);

	public List<Review> findAllReviewsByCourse(Course course);

}
