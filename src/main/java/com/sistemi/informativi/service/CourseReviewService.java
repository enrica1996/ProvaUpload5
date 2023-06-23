package com.sistemi.informativi.service;

import com.sistemi.informativi.entity.Course;
import com.sistemi.informativi.entity.Review;

public interface CourseReviewService {
	
	public void checkAddCourse(Course course);
	public void checkAddReview(Review review);
	public void checkFindAllReviewsByCourse(int courseId);
	
}
