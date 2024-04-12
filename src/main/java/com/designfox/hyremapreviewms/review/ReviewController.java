package com.designfox.hyremapreviewms.review;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/reviews/v1")
public class ReviewController {
    ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping
    public ResponseEntity<List<Review>> getAllReviews(@RequestParam Optional<Long> companyId){
        return ResponseEntity.ok(this.reviewService.getAllReviewsByCompanyId(companyId.orElse(null)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Review> getReviewById(@PathVariable Long id){
        Review foundReview = this.reviewService.getReviewById(id);
        if(foundReview != null){
            return ResponseEntity.ok(foundReview);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<Review> addReview(@RequestBody Review body){
        Review created = this.reviewService.addReview(body);
        if (created==null) return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(created,HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Review> updateReviewById(@PathVariable Long id, @RequestBody Review body){
        Review updated = this.reviewService.updateReviewById(id, body);
        if(updated!=null){
            return ResponseEntity.ok(updated);
        }
        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteReviewById(@PathVariable Long id){
        boolean deleted = this.reviewService.deleteReviewById(id);
        if(deleted) return ResponseEntity.ok("Review deleted successfully!");
        return new ResponseEntity<>("Unable to delete review!", HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
