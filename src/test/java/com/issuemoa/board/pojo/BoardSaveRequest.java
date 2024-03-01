package com.issuemoa.board.pojo;

import java.time.LocalDateTime;
import java.util.List;

public record BoardSaveRequest(
         String type,
         String title,
         String contents,
         String url,
         String thumbnail,
         LocalDateTime registerDateTime) {

    public Board toEntity() {
        return new Board.Builder()
                    .type(type)
                    .title(title)
                    .contents(contents)
                    .url(url)
                    .thumbnail(thumbnail)
                    .registerDateTime(registerDateTime)
                    .build();
    }
}
