package com.crud.ffin.service.review;

import com.crud.ffin.common.Search;
import com.crud.ffin.service.domain.Review;

import java.util.Map;

public interface ReviewService {

    //리뷰 등록
    public void addReview(Review review) throws Exception;

    //리뷰 목록 조회
    public Map<String, Object> getReviewList(Search search) throws Exception;

    //리뷰 수정
    public void updateReview(Review review) throws Exception;

    //사장님 댓글 등록을 위한 리뷰 수정
    public void updateRVAddTruckComment(Review review) throws Exception;

    //사장님 댓글 수정을 위한 리뷰 수정
    public void updateRVUpdateTruckComment(Review review) throws Exception;

}
