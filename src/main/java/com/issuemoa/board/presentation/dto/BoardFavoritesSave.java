package com.issuemoa.board.presentation.dto;

import com.issuemoa.board.domain.board.favorite.BoardFavorites;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.extern.slf4j.Slf4j;
import java.time.LocalDateTime;

@Slf4j
public record BoardFavoritesSave(
        @Schema(description = "Board ID")
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
        String thumbnail) {

        public BoardFavorites toEntity(Long userId) {
               return BoardFavorites.builder()
                       .boardId(this.id)
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
