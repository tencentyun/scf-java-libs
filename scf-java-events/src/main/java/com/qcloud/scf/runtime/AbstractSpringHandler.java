package com.qcloud.scf.runtime;

import com.alibaba.fastjson.JSONObject;
import com.qcloud.services.scf.runtime.events.APIGatewayProxyRequestEvent;
import com.qcloud.services.scf.runtime.events.APIGatewayProxyResponseEvent;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.StandardCharsets;
import java.util.*;

public abstract class AbstractSpringHandler implements HandlerInterface {
    private static final String HOST_IP = "http://127.0.0.1:8080";
    private static volatile boolean cold_launch;

    // initialize phase, initialize cold_launch
    static {
        System.out.println("initialize");
        cold_launch = true;
    }

    // Start spring application
    public abstract void startApp();

    // 设置需要转换base64的媒体类型
    public List<MediaType> getBinaryTypes() {
        return Collections.singletonList(MediaType.ALL);
    }

    // Entry Function
    public String mainHandler(APIGatewayProxyRequestEvent req) {
        if (cold_launch) {
            System.out.println("start spring");
            startApp();
            System.out.println("stop spring");
            cold_launch = false;
        }
        ResponseEntity<byte[]> response = springHttpRequest(req);
        //等待 spring 业务返回处理结构 -> apiGW response
        APIGatewayProxyResponseEvent resp = composeApiGWResponse(response);
        return resp.toString();
    }

    private boolean isBinaryContentType(MediaType contentType) {
        List<MediaType> binaryTypes = getBinaryTypes();
        System.out.println("need convert to base64 media types:");
        System.out.println(getBinaryTypes());
        boolean isBinary = false;
        boolean isCompatible = false;
        if (binaryTypes.size() > 0) {
            boolean isInclude = binaryTypes.contains(contentType);
            for (MediaType type : binaryTypes) {
                isCompatible = type.isCompatibleWith(contentType);
            }
            isBinary = isInclude || isCompatible;
        }
        return isBinary;
    }

    protected APIGatewayProxyResponseEvent composeApiGWResponse(ResponseEntity<byte[]> response) {
        APIGatewayProxyResponseEvent resp = new APIGatewayProxyResponseEvent();
        boolean isBinary = isBinaryContentType(response.getHeaders().getContentType());
        if (isBinary) {
            resp.setIsBase64Encoded(true);
            // 将byte[]转换为base64
            String base64 = Base64.getEncoder().encodeToString(response.getBody());
            resp.setBody(base64);
            System.out.println("Response body as base64");
        } else {
            resp.setIsBase64Encoded(false);
            String temp = new String(response.getBody(), StandardCharsets.UTF_8);
            resp.setBody(temp);
            System.out.println("Response body as string");
        }
        resp.setStatusCode(response.getStatusCodeValue());
        HttpHeaders orgHeaders = response.getHeaders();
        JSONObject headerObj = new JSONObject();
        for (String key : orgHeaders.keySet()) {
            if (orgHeaders.getValuesAsList(key).size() > 1) {
                headerObj.put(key, orgHeaders.getValuesAsList(key));
            } else {
                headerObj.put(key, orgHeaders.getValuesAsList(key).get(0));
            }
        }
        resp.setHeaders(headerObj);
        return resp;
    }

    protected ResponseEntity<byte[]> springHttpRequest(APIGatewayProxyRequestEvent req) {
        String path = req.getPath();
        String method = req.getHttpMethod();
        String body = req.getBody();
        Map<String, String> headerMap = req.getHeaders();
        HttpMethod httpMethod = HttpMethod.resolve(method);
        HttpHeaders headers = new HttpHeaders();
        headers.setAll(headerMap);
        RestTemplate client = new RestTemplate();
        HttpEntity<String> entity = new HttpEntity<>(body, headers);
        String url = HOST_IP + path;
        return client.exchange(url, httpMethod, entity, byte[].class);
    }
}

