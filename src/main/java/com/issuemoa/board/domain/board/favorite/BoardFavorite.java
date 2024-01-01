package com.issuemoa.board.domain.board.favorite;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;
import java.time.LocalDateTime;

@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Document(collection = "boardFavorite")
public class BoardFavorite {
    @MongoId
    private String id;
    private String boardId;
    private String userId;
    private LocalDateTime registerDateTime;

    @Builder
    public BoardFavorite(String id, String boardId, String userId, LocalDateTime registerDateTime) {
        this.id = id;
        this.boardId = boardId;
        this.userId = userId;
        this.registerDateTime = registerDateTime;
    }
}
