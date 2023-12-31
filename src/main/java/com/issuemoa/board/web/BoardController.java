package com.issuemoa.board.web;

import com.issuemoa.board.message.RestMessage;
import com.issuemoa.board.service.BoardService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
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

    @Operation(summary = "Issue 목록", description = "NEWS / YOUTUBE 목록을 불러온다.")
    @GetMapping("/board/{type}/list")
        public ResponseEntity<RestMessage> findAll(Locale locale,
            @Parameter(description = "news / youtube") @PathVariable("type") String type,
            @Parameter(description = "페이지 번호 1씩 증가") @RequestParam(required = false, defaultValue = "0") Integer skip,
            @RequestParam(required = false, defaultValue = "20") Integer limit) {

        //log.info("local message : {}", messages.getMessage("board.select.empty", null, locale));
        return ResponseEntity.ok()
            .headers(new HttpHeaders())
            .body(new RestMessage(HttpStatus.OK, boardService.findByType(type, skip, limit)));
    }
}
