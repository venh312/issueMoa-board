package com.issuemoa.board.service.inquiry;

import com.issuemoa.board.consumer.InquiryProducer;
import com.issuemoa.board.domain.inquiry.InquiryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class InquiryService {
    private final InquiryRepository inquiryRepository;
    private final InquiryProducer inquiryConsumer;

    public Long save(InquirySaveRequest inquirySaveRequest) {
        Long result = inquiryRepository.save(inquirySaveRequest.toEntity()).getId();

        if (result > 0) {
            inquiryConsumer.sendMessage(new InquirySaveProducerRequest(result, "새로운 고객문의가 등록되었습니다."));
        }

        return result;
    }
}
