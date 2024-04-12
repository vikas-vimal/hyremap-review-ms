package com.designfox.hyremapreviewms.review;

import java.util.List;

public interface ReviewService {
    List<Review> getAllReviewsList();
    List<Review> getAllReviewsByCompanyId(Long cid);
    Review getReviewById(Long id);
    Review addReview(Review body);
    Review updateReviewById(Long id, Review body);
    boolean deleteReviewById(Long id);
}
