package com.issuemoa.board.pojo;

import java.time.LocalDateTime;
import java.util.List;

public class Board {
    private Long id;
    private String type;
    private String title;
    private String contents;
    private String url;
    private String thumbnail;
    private List<String> favoriteUserIds;
    private LocalDateTime registerDateTime;

    // private 생성자: 외부에서 직접 생성하지 못하도록 함
    private Board() {}

    public Long getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public String getTitle() {
        return title;
    }

    public String getContents() {
        return contents;
    }

    public String getUrl() {
        return url;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public List<String> getFavoriteUserIds() {
        return favoriteUserIds;
    }

    public LocalDateTime getRegisterDateTime() {
        return registerDateTime;
    }

    @Override
    public String toString() {
        return "Board{" +
                "id='" + id + '\'' +
                ", type='" + type + '\'' +
                ", title='" + title + '\'' +
                ", contents='" + contents + '\'' +
                ", url='" + url + '\'' +
                ", thumbnail='" + thumbnail + '\'' +
                ", favoriteUserIds=" + favoriteUserIds +
                ", registerDateTime=" + registerDateTime +
                '}';
    }

    public static class Builder {
        private Long id;
        private String type;
        private String title;
        private String contents;
        private String url;
        private String thumbnail;
        private List<String> favoriteUserIds;
        private LocalDateTime registerDateTime;
        public Builder(){}
        public Builder(Board board) {
            this.type = board.type;
            this.title = board.title;
            this.contents = board.contents;
            this.url = board.url;
            this.thumbnail = board.thumbnail;
            this.favoriteUserIds = board.favoriteUserIds;
            this.registerDateTime = board.registerDateTime;
        }

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder type(String type) {
            this.type = type;
            return this;
        }

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder contents(String contents) {
            this.contents = contents;
            return this;
        }

        public Builder url(String url) {
            this.url = url;
            return this;
        }

        public Builder thumbnail(String thumbnail) {
            this.thumbnail = thumbnail;
            return this;
        }

        public Builder favoriteUserIds(List<String> favoriteUserIds) {
            this.favoriteUserIds = favoriteUserIds;
            return this;
        }

        public Builder registerDateTime(LocalDateTime registerDateTime) {
            this.registerDateTime = registerDateTime;
            return this;
        }

        public Board build() {
            Board board = new Board();
            board.id = this.id;
            board.type = this.type;
            board.title  = this.title;
            board.contents = this.contents;
            board.url = this.url;
            board.thumbnail = this.thumbnail;
            board.favoriteUserIds = this.favoriteUserIds;
            board.registerDateTime = this.registerDateTime;
            return board;
        }
    }
}