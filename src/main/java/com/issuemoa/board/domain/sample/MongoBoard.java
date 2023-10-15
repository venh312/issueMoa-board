package com.issuemoa.board.domain.sample;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Document(collection = "board")
public class MongoBoard {
    @Id
    private String id;
    private String type;
    private String startDate;
    private String allTimeYn;
    private String title;
    private String contents;
    private String url;
    private Long readCount;
    private String register;
    private LocalDateTime registerDateTime;

    @Builder
    public MongoBoard(String id, String type, String startDate, String allTimeYn, String title, String contents, String url, Long readCount) {
        this.id = id;
        this.type = type;
        this.startDate = startDate;
        this.allTimeYn = allTimeYn;
        this.title = title;
        this.contents = contents;
        this.url = url;
        this.readCount = 0L;
        this.register = "batch";
        this.registerDateTime = LocalDateTime.now();
    }
}