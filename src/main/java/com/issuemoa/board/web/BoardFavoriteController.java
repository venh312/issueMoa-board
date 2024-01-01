package com.issuemoa.board.web;

import com.issuemoa.board.domain.board.favorite.BoardFavorite;
import com.issuemoa.board.dto.boardfavorite.BoardFavoriteSave;
import com.issuemoa.board.message.RestMessage;
import com.issuemoa.board.service.BoardFavoriteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Issue Favorite", description = "Issue Favorite API")
@Slf4j
@RequiredArgsConstructor
@RestController
public class BoardFavoriteController {
    private final BoardFavoriteService boardFavoriteService;

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "등록 성공"),
            @ApiResponse(responseCode = "404", description = "존재하지 않는 리소스 접근")})
    @Operation(summary = "관심 이슈 등록", description = "관심 이슈를 등록한다.")
    @PostMapping("/board-favorite/save")
    public ResponseEntity<RestMessage> save(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "첫 번째 RequestBody",
                    required = true,
                    content = @Content(schema = @Schema(implementation = BoardFavoriteSave.class))
            )
            BoardFavoriteSave request) {
        return ResponseEntity.ok()
                .headers(new HttpHeaders())
                .body(new RestMessage(HttpStatus.OK, boardFavoriteService.save(request)));
    }
    
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "조회 성공", content = @Content(schema = @Schema(implementation = BoardFavorite.class))),
            @ApiResponse(responseCode = "404", description = "존재하지 않는 리소스 접근")})
    @Operation(summary = "관심 이슈 목록", description = "사용자가 등록한 관심 이슈 목록을 불러온다.")
    @GetMapping("/board-favorite/list")
    public ResponseEntity<RestMessage> findAll(
        BoardFavorite request,
        @Parameter(description = "페이지 번호 1씩 증가") @RequestParam(required = false, defaultValue = "0") Integer skip,
        @RequestParam(required = false, defaultValue = "20") Integer limit) {

        return ResponseEntity.ok()
            .headers(new HttpHeaders())
            .body(new RestMessage(HttpStatus.OK, boardFavoriteService.findAll(request, skip, limit)));
    }
}
