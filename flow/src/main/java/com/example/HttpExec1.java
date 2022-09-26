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

import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j
public class HttpExec1 implements ExecutionListener {

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
//        String m = (String) method.getValue(execution);
//        String u = (String) url.getValue(execution);
//        String h = (String) header.getValue(execution);
//        String q = (String) query.getValue(execution);
//        String b = (String) body.getValue(execution);
//        String j = (String) json.getValue(execution);
//
//        HttpMethod httpMethod = HttpMethod.resolve(m);
//        if (httpMethod == null) {
//            log.error("HTTP 请求方法错误 请求方法: {} ", m);
//            throw new IllegalArgumentException("HTTP 请求方法错误");
//        }
//
//        HttpHeaders headers = new HttpHeaders();
//        JSONObject headerObj = JSONUtil.parseObj(h);
//        headerObj.keySet().forEach(v -> {
//            headers.set(v, (String) headerObj.get(v));
//        });
//
//        Map body = null;
//        switch (m) {
//            case "get":
//                JSONObject queryObj = JSONUtil.parseObj(q);
//                Map<String, String> map = new HashMap<>();
//                headerObj.keySet().forEach(v -> {
//                    map.put(v, (String) queryObj.get(v));
//                });
//            case "post":
//                if (b != null && b.length() > 0) {
//                    HashMap<String, Object> form = new HashMap<>();
//                    JSONObject bodyObj = JSONUtil.parseObj(b);
//                    bodyObj.keySet().forEach(v -> {
//                        form.put(v, bodyObj.get(v));
//                    });
//                } else if (j != null && j.length() > 0) {
//                    headers.setContentType(MediaType.APPLICATION_JSON);
//                    Map map = JSONUtil.parse(j).toBean(Map.class);
//                }
//                break;
//            case "put":
//                break;
//            case "delete":
//                break;
//        }
//
//        HttpEntity requestEntity = new HttpEntity(postBody, headers);
//
//        ResponseEntity<Map> resp = restTemplate.exchange(u, httpMethod, requestEntity, Map.class);
    }
}
