package com.issuemoa.board.presentation.dto;

import com.issuemoa.board.domain.board.favorite.BoardFavorites;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.extern.slf4j.Slf4j;
import java.time.LocalDateTime;

@Slf4j
public record BoardFavoritesSave(
        @Schema(description = "Board ID")
        String boardId,
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
        @Schema(description = "등록시간")
        LocalDateTime registerDateTime) {

        public BoardFavorites toEntity(String userId) {
               return BoardFavorites.builder()
                       .boardId(this.boardId)
                       .userId(userId)
                       .type(this.type)
                       .title(this.title)
                       .contents(this.contents)
                       .url(this.url)
                       .thumbnail(this.thumbnail)
                       .registerDateTime(LocalDateTime.now())
                       .build();
        }
}
