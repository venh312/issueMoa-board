package com.issuemoa.board.presentation.controller;

import com.issuemoa.board.application.BoardService;
import com.issuemoa.board.presentation.dto.BoardResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Locale;

@Tag(name = "Issue", description = "이슈(NEWS / YOUTUBE) API")
@Slf4j
@RequiredArgsConstructor
@RestController
public class BoardController {
    private final BoardService boardService;
    private final MessageSource messages;

    @Operation(summary = "NEWS / YOUTUBE 목록 조회")
    @GetMapping("/board/{type}")
    public ResponseEntity<List<BoardResponse>> findAll(Locale locale,
            @Parameter(description = "news / youtube") @PathVariable("type") String type,
            @Parameter(description = "페이지 번호 1씩 증가") @RequestParam(required = false, defaultValue = "0") Integer skip,
            @RequestParam(required = false, defaultValue = "20") Integer limit) {
        //log.info("local message : {}", messages.getMessage("board.select.empty", null, locale));
        return ResponseEntity.ok(boardService.findByType(type, skip, limit));
    }

    @Operation(summary = "이슈 목록 조회(제목 검색)")
    @GetMapping("/board")
    public ResponseEntity<List<BoardResponse>> findByTitleContaining(
            @Parameter(description = "제목") @RequestParam("title") String title) {
        return ResponseEntity.ok(boardService.findByTitleContaining(title));
    }
}
