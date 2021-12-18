package com.crud.ffin.service.review.impl;

import com.crud.ffin.common.Search;
import com.crud.ffin.service.domain.Review;
import com.crud.ffin.service.review.ReviewDao;
import com.crud.ffin.service.review.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("reviewServiceImpl")
public class ReviewServiceImpl implements ReviewService {

    //FFF
    @Autowired
    @Qualifier("reviewDaoImpl")
    private ReviewDao reviewDao;
    public void setReviewDao(ReviewDao reviewDao){
        this.reviewDao = reviewDao;
    }

    //CCC
    public ReviewServiceImpl(){
        System.out.println(this.getClass());
    }

    //MMM
    @Override
    public void addReview(Review review) throws Exception {
        reviewDao.addReview(review);
    }

    @Override
    public Map<String, Object> getReviewList(Search search) throws Exception {
        List<Review> list = reviewDao.getReviewList(search);
        int totalCount = reviewDao.getTotalCount(search);

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("list", list);
        map.put("totalCount", new Integer(totalCount));
        return map;
    }

    @Override
    public void updateReview(Review review) throws Exception {
        reviewDao.updateReview(review);
    }

    @Override
    public void updateRVAddTruckComment(Review review) throws Exception {
        reviewDao.updateRVAddTruckComment(review);
    }

    @Override
    public void updateRVUpdateTruckComment(Review review) throws Exception {
        reviewDao.updateRVUpdateTruckComment(review);
    }
}
