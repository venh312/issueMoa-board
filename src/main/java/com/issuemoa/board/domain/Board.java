package com.issuemoa.board.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;
import java.time.LocalDateTime;

@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Document(collection = "board")
public class Board {
    @MongoId
    private String id;
    private String type;
    private String title;
    private String contents;
    private String url;
    private String thumbnail;
    private LocalDateTime registerDateTime;
}