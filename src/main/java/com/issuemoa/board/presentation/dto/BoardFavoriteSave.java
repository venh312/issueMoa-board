package com.issuemoa.board.presentation.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.Assert;

@Slf4j
public record BoardFavoriteSave(
        @Schema(description = "Board ID", required = true) String boardId) {
    public BoardFavoriteSave {
        Assert.hasText(boardId, "Board ID는 필수입니다.");
    }
}
