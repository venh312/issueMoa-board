package com.issuemoa.board.record.boardfavorite;

import com.issuemoa.board.domain.board.favorite.BoardFavorite;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.Assert;

@Slf4j
public record BoardFavoriteSave(
        @Schema(description = "사용자 ID", required = true) String userId,
        @Schema(description = "news / youtube", required = true) String type,
        @Schema(description = "제목", required = true) String title,
        @Schema(description = "내용") String contents,
        @Schema(description = "URL", required = true) String url,
        @Schema(description = "썸네일", required = true) String thumbnail) {
    public BoardFavoriteSave {
        Assert.hasText(userId, "사용자 ID는 필수입니다.");
        Assert.hasText(type, "타입은 필수입니다.");
        Assert.hasText(title, "제목은 필수입니다.");
        Assert.hasText(url, "URL은 필수입니다.");
        Assert.hasText(thumbnail, "thumbnail은 필수입니다.");
    }

    public BoardFavorite toEntity() {
        return BoardFavorite.builder()
            .userId(userId)
            .type(type)
            .title(title)
            .contents(contents)
            .url(url)
            .thumbnail(thumbnail)
            .build();
    }
}
