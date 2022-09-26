package com.example;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.flowable.common.engine.api.delegate.Expression;
import org.flowable.engine.delegate.DelegateExecution;
import org.flowable.engine.delegate.ExecutionListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
@Slf4j
public class HttpExec implements ExecutionListener {

    @Autowired
    private RestTemplate restTemplate;

    private Expression method;
    private Expression url;
    private Expression header;
    private Expression query;
    private Expression body;
    private Expression json;

    @Override
    public void notify(DelegateExecution execution) {
        String m = (String) method.getValue(execution);
        String u = (String) url.getValue(execution);
        String h = (String) header.getValue(execution);
        String q = (String) query.getValue(execution);
        String b = (String) body.getValue(execution);
        String j = (String) json.getValue(execution);

        req(m, u, h, q, b, j);
    }


    /**
     * 参数
     * @param method
     * @param url
     * @param header
     * @param query
     * @param body
     * @param json
     */
    public void req(String method, String url, String header, String query, String body, String json) {
        HttpMethod httpMethod = HttpMethod.resolve(method.toUpperCase());
        if (httpMethod == null) {
            log.error("HTTP 请求方法错误 请求方法: {} ", method);
            throw new IllegalArgumentException("HTTP 请求方法错误");
        }

        HttpHeaders headers = new HttpHeaders();
        if (header != null && header.length() > 0) {
            JSONObject headerObj = JSONUtil.parseObj(header);
            headerObj.keySet().forEach(v -> {
                headers.set(v, (String) headerObj.get(v));
            });
        }

        Map<String, Object> requestBody = null;
        switch (method) {
            case "get":
                if (query != null && query.length() > 0) {
                    Map<String, String> params = JSONUtil.parseObj(query).toBean(Map.class);
                    url += "?";
                    for(String paramName :params.keySet()) {
                        url += String.format("%s=%s&", paramName, params.get(paramName));
                    }
                    url = url.substring(0, url.length() - 1);
                }
                break;
            case "post":
                if (body != null && body.length() > 0) {
                    requestBody = JSONUtil.parseObj(body).toBean(Map.class);
                } else if (json != null && json.length() > 0) {
                    headers.setContentType(MediaType.APPLICATION_JSON);
                    requestBody = JSONUtil.parse(json).toBean(Map.class);
                }
                break;
            case "put":
            case "delete":
                if (json != null && json.length() > 0) {
                    headers.setContentType(MediaType.APPLICATION_JSON);
                    requestBody = JSONUtil.parse(json).toBean(Map.class);
                }
                break;
        }

        HttpEntity requestEntity = new HttpEntity(requestBody, headers);
        ResponseEntity<Map> resp = null;
        try {
            resp = restTemplate.exchange(url, httpMethod, requestEntity, Map.class);
        } catch (Exception e) {
            log.error("调用接口发生错误", e);
        } finally {
            log.info("调用: [{}] {}", method, url);
            log.info("请求头: {}", headers);
            log.info("请求参数: {}", requestBody);
            if (resp != null ) {
                log.info("返回: {}", resp.getBody());
            }
        }
    }
}
