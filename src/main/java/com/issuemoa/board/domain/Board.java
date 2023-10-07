package com.issuemoa.board.domain;

import lombok.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity(name = "board")
public class Board extends BaseTime {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private String type;
    private String startDate;
    private String endDate;
    private String allTimeYn;
    private String title;
    private String contents;
    private String url;
    private Long readCount;
    private Long registerId;
    private Long modifyId;

    @Builder
    public Board(Long id, String type, String startDate, String endDate, String allTimeYn, String title, String contents, String url, Long readCount, Long registerId, Long modifyId) {
        this.id = id;
        this.type = type;
        this.startDate = startDate;
        this.endDate = endDate;
        this.allTimeYn = allTimeYn;
        this.title = title;
        this.contents = contents;
        this.url = url;
        this.readCount = readCount;
        this.registerId = registerId;
        this.modifyId = modifyId;
    }

    @Getter
    @Setter
    public static class Request {
        private Long id;
        private String type;
        private String startDate;
        private String endDate;
        private String allTimeYn;
        private String title;
        private String contents;
        private String url;
        private Long readCount;
        private Long registerId;
        private Long modifyId;
        private String search;
    }

    @Getter
    public static class Response {
        private Long id;
        private String type;
        private String startDate;
        private String endDate;
        private String allTimeYn;
        private String title;
        private String contents;
        private String url;
        private Long readCount;
        private Long registerId;
        private Long modifyId;
        private String registerTime;
        private String modifyTime;
        private String registerName;
        private String modifyName;

        public String getRegisterTime(LocalDateTime registerName) {
            return toStringDateTime(registerName);
        }

        public String getModifyName(LocalDateTime modifyName) {
            return toStringDateTime(modifyName);
        }

        public Response(Long id, String type, String title, String contents, String url, Long readCount, LocalDateTime registerTime) {
            this.id = id;
            this.type = type;
            this.title = title;
            this.contents = contents;
            this.url = url;
            this.readCount = readCount;
            this.registerTime = toStringDateTime(registerTime);
        }

        public Response(Object o) {
            Board board = (Board) o;
            this.id = board.getId();
            this.type = board.getType();
            this.startDate = board.getStartDate();
            this.endDate = board.getEndDate();
            this.allTimeYn = board.getAllTimeYn();
            this.title = board.getTitle();
            this.contents = board.getContents();
            this.url = board.getUrl();
            this.readCount = board.getReadCount();
            this.registerTime = toStringDateTime(board.getRegisterTime());
            this.modifyTime = toStringDateTime(board.getModifyTime());
            this.registerId = board.getRegisterId();
            this.modifyId = board.getModifyId();
        }

        public Response(Long id, String type, String startDate, String endDate, String allTimeYn, String title, String contents, String url, Long readCount, LocalDateTime registerTime) {
            this.id = id;
            this.type = type;
            this.startDate = startDate;
            this.endDate = endDate;
            this.allTimeYn = allTimeYn;
            this.title = title;
            this.contents = contents;
            this.url = url;
            this.readCount = readCount;
            this.registerTime = toStringDateTime(registerTime);
        }
    }
}
