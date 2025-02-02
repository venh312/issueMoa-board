package com.issuemoa.board.presentation.controller;

import com.issuemoa.board.application.BoardFavoritesService;
import com.issuemoa.board.presentation.dto.BoardFavoritesResponse;
import com.issuemoa.board.presentation.dto.BoardFavoritesSave;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Tag(name = "Board Favorites", description = "관심 이슈(NEWS / YOUTUBE) API")
@Slf4j
@RequiredArgsConstructor
@RestController
public class BoardFavoritesController {
    private final BoardFavoritesService boardFavoritesService;

    @Operation(summary = "관심 이슈 등록")
    @PostMapping("/board/favorites")
    public ResponseEntity<BoardFavoritesResponse> save(
            @RequestHeader("Authorization") String token,
            @RequestBody BoardFavoritesSave boardFavoritesSave){
        return ResponseEntity.ok(boardFavoritesService.save(token, boardFavoritesSave));
    }

    @Operation(summary = "관심 NEWS / YOUTUBE 목록 조회")
    @GetMapping("/board/favorites")
    public ResponseEntity<List<BoardFavoritesResponse>> findByUserId(@RequestHeader("Authorization") String token){
        return ResponseEntity.ok(boardFavoritesService.findByUserId(token));
    }
}
