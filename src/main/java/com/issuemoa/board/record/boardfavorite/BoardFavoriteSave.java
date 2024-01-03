package com.issuemoa.board.record.boardfavorite;

import com.issuemoa.board.domain.board.favorite.BoardFavorite;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.util.Assert;

public record BoardFavoriteSave(
        @Schema(description = "이슈 ID") String boardId,
        @Schema(description = "사용자 ID") String userId) {
    public BoardFavoriteSave {
        Assert.hasText(boardId, "이슈 ID는 필수입니다.");
        Assert.hasText(userId, "사용자 ID는 필수입니다.");
    }

    public BoardFavorite toEntity() {
        return BoardFavorite.builder()
            .boardId(boardId)
            .userId(userId)
            .build();
    }
}
