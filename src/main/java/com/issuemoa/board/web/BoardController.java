package com.issuemoa.board.web;

import com.issuemoa.board.message.RestMessage;
import com.issuemoa.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Locale;

@Slf4j
@RequiredArgsConstructor
@RestController
public class BoardController {
    private final BoardService boardService;
    private final MessageSource messages;

    @GetMapping("/board/{type}/list")
        public ResponseEntity<RestMessage> findAll(Locale locale,
                                        @PathVariable("type") String type,
                                        @RequestParam(required = false, defaultValue = "0") Integer skip,
                                        @RequestParam(required = false, defaultValue = "20") Integer limit) {

        //log.info("local message : {}", messages.getMessage("board.select.empty", null, locale));
        return ResponseEntity.ok()
            .headers(new HttpHeaders())
            .body(new RestMessage(HttpStatus.OK, boardService.findByType(type, skip, limit)));
    }
}
