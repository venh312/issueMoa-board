package com.issuemoa.board.dto.boardfavorite;

import com.issuemoa.board.domain.board.favorite.BoardFavorite;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(name = "BoardFavoriteSave")
public class BoardFavoriteSave {
    @Schema(description = "이슈 ID")
    private String boardId;

    @Schema(description = "사용자 ID")
    private String userId;

    public BoardFavorite toEntity() {
        return BoardFavorite.builder()
            .boardId(boardId)
            .userId(userId)
            .build();
    }
}
