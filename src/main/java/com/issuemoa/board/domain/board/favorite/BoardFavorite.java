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
    private String userId;
    private String type;
    private String title;
    private String contents;
    private String url;
    private String thumbnail;
    private LocalDateTime registerDateTime;

    @Builder
    public BoardFavorite(String id, String userId, String type, String title, String contents, String url, String thumbnail, LocalDateTime registerDateTime) {
        this.id = id;
        this.userId = userId;
        this.type = type;
        this.title = title;
        this.contents = contents;
        this.url = url;
        this.thumbnail = thumbnail;
        this.registerDateTime = registerDateTime;
    }
}
