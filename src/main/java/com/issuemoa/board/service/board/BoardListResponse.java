package com.issuemoa.board.service.board;

import com.issuemoa.board.domain.BaseTime;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.data.annotation.Id;
import java.time.LocalDateTime;
import java.util.List;

public record BoardListResponse(
        @Schema(description = "IDX")
        @Id
        String id,

        @Schema(description = "news / youtube")
        String type,

        @Schema(description = "제목")
        String title,

        @Schema(description = "내용")
        String contents,

        @Schema(description = "URL")
        String url,

        @Schema(description = "썸네일")
        String thumbnail,

        @Schema(description = "관심 등록 사용자 ID 목록")
        List<String> favoriteUserIds,

        @Schema(description = "등록시간")
        String registerDateTime
) {
    public String getRegisterDateTime(LocalDateTime registerDateTime) {
        return BaseTime.toStringDateTime(registerDateTime);
    }
}
