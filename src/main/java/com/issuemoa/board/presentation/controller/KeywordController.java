package com.issuemoa.board.presentation.controller;

import com.issuemoa.board.application.KeywordService;
import com.issuemoa.board.domain.keyword.Keyword;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "Keyword", description = "키워드 API")
@RequiredArgsConstructor
@RestController
public class KeywordController {
    private final KeywordService keywordService;

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "조회 성공", content = @Content(schema = @Schema(implementation = Keyword.class)))})
    @Operation(summary = "[TOP 10] 키워드 목록 조회")
    @GetMapping("/keyword")
    public ResponseEntity<List<Keyword>> findAll(
                @Parameter(description = "값 1: (Today -1 Day), 2: (Today -2 Day) ...")
                @RequestParam(required = false, defaultValue = "1") int minusDay) {
        return ResponseEntity.ok(keywordService.findTop10ByBaseDateTimeOrderByCountDesc(minusDay));
    }
}
