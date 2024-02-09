package com.issuemoa.board.web;

import com.issuemoa.board.domain.board.Board;
import com.issuemoa.board.message.RestMessage;
import com.issuemoa.board.service.board.BoardFavoriteSave;
import com.issuemoa.board.service.board.BoardFavoriteSearch;
import com.issuemoa.board.service.board.BoardService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Locale;

@Tag(name = "Issue", description = "Issue API")
@Slf4j
@RequiredArgsConstructor
@RestController
public class BoardController {
    private final BoardService boardService;
    private final MessageSource messages;

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "조회 성공", content = @Content(schema = @Schema(implementation = Board.class))),
            @ApiResponse(responseCode = "404", description = "존재하지 않는 리소스 접근")})
    @Operation(summary = "Issue 목록", description = "NEWS / YOUTUBE 목록을 불러온다.")
    @GetMapping("/board/{type}")
    public ResponseEntity<RestMessage> findAll(Locale locale,
        @Parameter(description = "news / youtube") @PathVariable("type") String type,
        @Parameter(description = "페이지 번호 1씩 증가") @RequestParam(required = false, defaultValue = "0") Integer skip,
        @RequestParam(required = false, defaultValue = "20") Integer limit) {

        //log.info("local message : {}", messages.getMessage("board.select.empty", null, locale));
        return ResponseEntity.ok()
                    .headers(new HttpHeaders())
                    .body(new RestMessage(HttpStatus.OK, boardService.findByType(type, skip, limit)));
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "등록 성공", content = @Content(schema = @Schema(implementation = Board.class))),
            @ApiResponse(responseCode = "404", description = "존재하지 않는 리소스 접근")})
    @Operation(summary = "관심 게시글 등록", description = "관심 게시글을 등록한다.")
    @PostMapping("/board/favorite")
    public ResponseEntity<RestMessage> addFavoriteBoards(@RequestBody BoardFavoriteSave boardFavoriteSave) {
        return ResponseEntity.ok()
                    .headers(new HttpHeaders())
                    .body(new RestMessage(HttpStatus.OK, boardService.addFavoriteBoards(boardFavoriteSave)));
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "조회 성공", content = @Content(schema = @Schema(implementation = Board.class))),
            @ApiResponse(responseCode = "404", description = "존재하지 않는 리소스 접근")})
    @Operation(summary = "관심 게시글 목록", description = "관심 NEWS / YOUTUBE 목록을 불러온다.")
    @GetMapping("/board/favorite")
    public ResponseEntity<RestMessage> findByFavoriteUserIdsContaining(BoardFavoriteSearch boardFavoriteSearch) {
        return ResponseEntity.ok()
                    .headers(new HttpHeaders())
                    .body(new RestMessage(HttpStatus.OK, boardService.findByFavoriteUserIdsContaining(boardFavoriteSearch)));
    }
}
