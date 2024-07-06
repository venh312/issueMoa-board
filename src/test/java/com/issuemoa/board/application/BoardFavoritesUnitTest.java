package com.issuemoa.board.application;

import com.issuemoa.board.domain.board.favorite.BoardFavorites;
import com.issuemoa.board.domain.board.favorite.BoardFavoritesRepository;
import com.issuemoa.board.presentation.dto.BoardFavoritesResponse;
import com.issuemoa.board.presentation.dto.BoardFavoritesSave;
import com.issuemoa.board.presentation.jwt.TokenProvider;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Sort;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BoardFavoritesUnitTest {
    @Mock
    private BoardFavoritesRepository boardFavoritesRepository;

    @Mock
    private TokenProvider tokenProvider;

    @InjectMocks
    private BoardFavoritesService boardFavoritesService;

    @Test
    @DisplayName("관심 게시글 등록")
    void save() {
        // given
        String token = "eyJhbGciOiJIUzUxMiIsInR5cCI6IkpXVCJ9.eyJpZCI6IjEiLCJuYW1lIjoi7ISx7KeE7JqwIn0.o7Lht3b_uwMEzvSubr367QTyNe20FxPRQeT2h15eQ_Fl_qgC30aZztWtUabF9kb7JdwpjtEpj5rL9euGLb5tmQ";
        BoardFavorites savedBoardFavorites =  BoardFavorites.builder()
                .id("IDX")
                .boardId("d35a46b99f6")
                .userId(1L)
                .type("news")
                .title("제목")
                .contents("내용")
                .url("URL")
                .thumbnail("thumbnail")
                .registerDateTime(LocalDateTime.now())
                .build();

        when(boardFavoritesRepository.save(any())).thenReturn(savedBoardFavorites);

        // when
        BoardFavoritesResponse response = boardFavoritesService.save(token, new BoardFavoritesSave(
                "d35a46b99f6",
                "news",
                "제목",
                "내용",
                "URL",
                "thumbnail"
        ));

        // then
        assertEquals(1L, response.userId());
        assertEquals("d35a46b99f6", response.boardId());
        assertEquals("news", response.type());
        assertEquals("제목", response.title());
        assertEquals("내용", response.contents());
        assertEquals("URL", response.url());
        assertEquals("thumbnail", response.thumbnail());
    }

    @Test
    @DisplayName("특정 사용자 게시글 조회")
    void findByUserId() {
        // given
        String token = "eyJhbGciOiJIUzUxMiIsInR5cCI6IkpXVCJ9.eyJpZCI6IjEiLCJuYW1lIjoi7ISx7KeE7JqwIn0.o7Lht3b_uwMEzvSubr367QTyNe20FxPRQeT2h15eQ_Fl_qgC30aZztWtUabF9kb7JdwpjtEpj5rL9euGLb5tmQ";
        Long userId = 0L;

        List<BoardFavoritesResponse> list = getBoardFavoritesResponseList();
        when(boardFavoritesRepository.findByUserId(userId, Sort.by(Sort.Direction.DESC, "registerDateTime"))).thenReturn(list);

        // when
        List<BoardFavoritesResponse> response = boardFavoritesService.findByUserId(token);

        // then
        assertEquals("abcded1", response.get(0).id());
        assertEquals("board1", response.get(0).boardId());
        assertEquals(userId, response.get(0).userId());
        assertEquals("news", response.get(0).type());
        assertEquals("제목", response.get(0).title());
        assertEquals("내용", response.get(0).contents());
        assertEquals("URL", response.get(0).url());
        assertEquals("thumbnail", response.get(0).thumbnail());
    }


    private List<BoardFavoritesResponse> getBoardFavoritesResponseList() {
        BoardFavoritesResponse responseDto = new BoardFavoritesResponse(
                "abcded1",
                "board1",
                0L,
                "news",
                "제목",
                "내용",
                "URL",
                "thumbnail",
                LocalDateTime.now()
        );
        return Arrays.asList(responseDto);
    }
}
