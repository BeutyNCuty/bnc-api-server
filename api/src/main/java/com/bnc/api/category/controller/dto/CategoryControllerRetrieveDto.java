package com.bnc.api.category.controller.dto;

import com.bnc.api.member.controller.dto.MemberDetailDto;
import com.bnc.common.category.domain.Category;
import lombok.*;

import java.time.OffsetDateTime;

@Getter
@AllArgsConstructor
public class CategoryControllerRetrieveDto {

    @Getter
    @AllArgsConstructor
    public static class CategoryResponse {
        private MemberDetailDto.MemberDetailData member;
    }

    @Getter
    @RequiredArgsConstructor
    @ToString
    public static class CategoryRetrieveData {

        @NonNull
        private long id;
        @NonNull
        private String name;

        public static CategoryControllerRetrieveDto.CategoryRetrieveData retrieveCategory(Category category){
            return new CategoryControllerRetrieveDto.CategoryRetrieveData(category.getId(), category.getName());
        }
    }
}
