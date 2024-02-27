package com.issuemoa.board.presentation.controller;

import com.issuemoa.board.presentation.dto.InquirySaveRequest;
import com.issuemoa.board.application.InquiryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Inquiry", description = "고객문의 API")
@RequiredArgsConstructor
@RestController
public class InquiryController {
    private final InquiryService inquiryService;

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "등록 성공"),
            @ApiResponse(responseCode = "404", description = "존재하지 않는 리소스 접근")})
    @Operation(summary = "고객문의 등록", description = "고객 문의를 등록한다.")
    @PostMapping("/inquiry")
    public ResponseEntity<Long> save(@RequestBody InquirySaveRequest inquirySaveRequest) {
        return ResponseEntity.ok(inquiryService.save(inquirySaveRequest));
    }
}
