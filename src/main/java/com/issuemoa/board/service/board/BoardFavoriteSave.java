package com.issuemoa.board.service.board;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.Assert;

@Slf4j
public record BoardFavoriteSave(
        @Schema(description = "사용자 ID", required = true) String userId,
        @Schema(description = "Board ID", required = true) String boardId) {
    public BoardFavoriteSave {
        Assert.hasText(userId, "사용자 ID는 필수입니다.");
        Assert.hasText(boardId, "Board ID는 필수입니다.");
    }
}
