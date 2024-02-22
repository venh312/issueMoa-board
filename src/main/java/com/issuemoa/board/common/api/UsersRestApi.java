package com.issuemoa.board.common.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.issuemoa.board.common.ConvertUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

@Slf4j
@Component
public class UsersRestApi {
    @Value("${endpoint.users.info}")
    private String endpointUserInfo;

    private HashMap<String, Object> getUserInfo(HttpServletRequest httpServletRequest) throws JsonProcessingException {
        String bearerToken = httpServletRequest.getHeader(HttpHeaders.AUTHORIZATION);
        log.info("==> [UsersRestApi.getUserInfo] BearerToken :: {}", bearerToken);

        if (StringUtils.isBlank(bearerToken))
            throw new UsersNotFoundException("BearerToken 이 존재하지 않습니다.");

        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", bearerToken);

        return ConvertUtil.toUserInfoMap(new RestTemplate().exchange(endpointUserInfo, HttpMethod.GET, new HttpEntity<>(headers), String.class).getBody());
    }

    public String getUserId(HttpServletRequest httpServletRequest) throws JsonProcessingException {
        HashMap<String, Object> userInfo = getUserInfo(httpServletRequest);
        return (String) userInfo.get("id");
    }

}
