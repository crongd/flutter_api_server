package com.apiserver;

import lombok.RequiredArgsConstructor;
import net.minidev.json.JSONObject;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestOperations;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class PortOneService {

    private final RestOperations restOperations;
    // token 발급 url
    private final String PORTONE_ACCESS_TOKEN_URL = "https://api.iamport.kr/users/getToken";
    private final String PORTONE_CERTIFICATION_CI_URI = "https://api.iamport.kr/certifications/{impUID}";

    // access_token 발급키
    private final String PORTONE_API_KEY = "8843414326450430";
    private final String PORTONE_API_SECRET = "6PJKx8uc4mNqPaOtjeIZ19DKx8gxU9O3VFu3E0dIQIHijPCRDHVvFPa1YXu1mVkDgNhSnPyexo7A7xfF";

    // portone 기능을 사용하기 위한 access_token 발급받기
    public String get_access_token() {
        Map<String, String> bodyData = Map.of(
                "imp_key", PORTONE_API_KEY,
                "imp_secret", PORTONE_API_SECRET
        );

        RequestEntity<String> requestEntity = RequestEntity
                .post(PORTONE_ACCESS_TOKEN_URL)
                .contentType(MediaType.APPLICATION_JSON)
                .body(JSONObject.toJSONString(bodyData));

        ResponseEntity<JSONObject> response = restOperations.exchange(requestEntity, JSONObject.class);
        System.out.println(response);
        JSONObject responseBody = response.getBody();
        Map data = (Map) responseBody.get("response");
        return (String) data.get("access_token");
    }

    // 유저 ci값 가져오기
    public String get_user_certification(String impUID, String token) throws Exception{
        RequestEntity requestEntity = RequestEntity
                .get(PORTONE_CERTIFICATION_CI_URI, impUID)
                .header("Authorization", token)
                .build();

        ResponseEntity<JSONObject> responseEntity = restOperations.exchange(requestEntity, JSONObject.class);
        return ((Map) responseEntity.getBody().get("response")).get("unique_key").toString();
    }

    public String get_user_certification_phone(String impUID, String token)  {
        RequestEntity requestEntity = RequestEntity
                .get(PORTONE_CERTIFICATION_CI_URI, impUID)
                .header("Authorization", token)
                .build();

        ResponseEntity<JSONObject> responseEntity = restOperations.exchange(requestEntity, JSONObject.class);
//        System.out.println(responseEntity.getBody().get("response"));
        return ((Map) responseEntity.getBody().get("response")).get("phone").toString();
    }
}
