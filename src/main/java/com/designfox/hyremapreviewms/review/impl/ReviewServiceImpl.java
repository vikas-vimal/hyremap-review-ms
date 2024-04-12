package com.designfox.hyremapreviewms.review.impl;

import com.designfox.hyremapreviewms.review.Review;
import com.designfox.hyremapreviewms.review.ReviewRepository;
import com.designfox.hyremapreviewms.review.ReviewService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewServiceImpl implements ReviewService {

    private ReviewRepository reviewRepository;

    public ReviewServiceImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public List<Review> getAllReviewsList() {
        return this.reviewRepository.findAll();
    }

    @Override
    public List<Review> getAllReviewsByCompanyId(Long cid) {
        return this.reviewRepository.findByCompanyId(cid);
    }

    @Override
    public Review getReviewById(Long id) {
        return this.reviewRepository.findById(id).orElse(null);
    }

    @Override
    public Review addReview(Long cid, Review body) {
//        Company companyExists = this.companyService.findCompanyById(cid);
//        if(companyExists == null) return null;
        body.setId(null);
//        body.setCompany(companyExists);
        return this.reviewRepository.save(body);
    }

    @Override
    public Review updateReviewById(Long companyId, Long id, Review body) {
        Optional<Review> foundReview = this.reviewRepository.findById(id);
        if(foundReview.isPresent()){
            Review review = foundReview.get();
            review.setId(id);
            review.setTitle(body.getTitle());
            review.setDescription(body.getDescription());
            review.setName(body.getName());
            review.setRating(body.getRating());
            this.reviewRepository.save(review);
            return review;
        }
        return null;
    }

    @Override
    public boolean deleteReviewById(Long companyId, Long id) {
        try {
            this.reviewRepository.deleteById(id);
            return true;
        } catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }
}
