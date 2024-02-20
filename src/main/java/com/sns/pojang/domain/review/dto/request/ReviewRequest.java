package com.sns.pojang.domain.review.dto.request;

import com.sns.pojang.domain.member.entity.Member;
import com.sns.pojang.domain.order.entity.Order;
import com.sns.pojang.domain.review.entity.Review;
import com.sns.pojang.domain.store.entity.Store;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.nio.file.Path;

@Data
public class ReviewRequest {

    // 별점
    @NotNull(message = "별점을 입력해주세요.")
    private int rating;

    // 내용
    @NotEmpty(message = "리뷰를 작성해주세요.")
    private String contents;

    // 이미지
    private MultipartFile Image;

    public Review toEntity(Order order, Store store, Member member, int rating, String contents, Path path){
        String imageUrl = path != null ? path.toString() : null;
        return Review.builder()
                .order(order)
                .store(store)
                .member(member)
                .imageUrl(imageUrl)
                .rating(rating)
                .contents(contents)
                .build();
    }

}