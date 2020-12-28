package com.qcloud.scf.runtime;

import com.alibaba.fastjson.JSONObject;
import com.qcloud.services.scf.runtime.events.APIGatewayProxyRequestEvent;
import com.qcloud.services.scf.runtime.events.APIGatewayProxyResponseEvent;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

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

    // Entry Function
    public String mainHandler(APIGatewayProxyRequestEvent req) {
        if (cold_launch) {
            System.out.println("start spring");
            startApp();
            System.out.println("stop spring");
            cold_launch = false;
        }

        ResponseEntity<String> response = springHttpRequset(req);
        //等待 spring 业务返回处理结构 -> apiGW response
        APIGatewayProxyResponseEvent resp = composeApiGWResponse(response);
        System.out.println("response body: " + response.getBody());
        return resp.toString();
    }

    protected APIGatewayProxyResponseEvent composeApiGWResponse(ResponseEntity<String> response) {
        APIGatewayProxyResponseEvent resp = new APIGatewayProxyResponseEvent();
        resp.setIsBase64Encoded(false);
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
        resp.setBody(response.getBody());
        return resp;
    }

    protected ResponseEntity<String> springHttpRequset(APIGatewayProxyRequestEvent req) {
        // apiGW event -> spring request
        String path = req.getPath();
        String method = req.getHttpMethod();
        String body = req.getBody();
        Map<String, String> hdrs = req.getHeaders();
        HttpMethod m = HttpMethod.resolve(method);
        HttpHeaders headers = new HttpHeaders();
        headers.setAll(hdrs);
        RestTemplate client = new RestTemplate();
        HttpEntity<String> entity = new HttpEntity<String>(body, headers);
        String url = HOST_IP + path;
        return client.exchange(url, m, entity, String.class);
    }
}

