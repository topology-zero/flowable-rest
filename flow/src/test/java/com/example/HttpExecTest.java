package com.example;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.*;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.util.Map;
import java.util.Set;

@ContextConfiguration(classes = {RestConfig.class})
@RunWith(SpringRunner.class)
@Slf4j
class HttpExecTest {

    @Autowired
    private RestTemplate restTemplate;

    @Test
    public void Get() {
        String m = "get";
        String u = "http://localhost:8080/service/repository/deployments";
        String h = "{\"b\":\"2\"}";
        String q = "{\"name\":\"xxx\"}";
        String b = "{\"c\":3}";
        String j = "";
        req(m, u, h, q, b, j);
    }

    @Test
    public void Post1() {
        String m = "post";
        String u = "http://localhost:8080/service/repository/deployments";
        String h = "{\"b\":\"2\"}";
        String q = "{\"a\":1}";
        String b = "{\"c\":3}";
        String j = "";
        req(m, u, h, q, b, j);
    }

    @Test
    public void Post2() {
        String m = "post";
        String u = "http://localhost:8080/service/repository/deployments";
        String h = "{\"b\":\"2\"}";
        String q = "{\"a\":1}";
        String b = "";
        String j = "{\"c\":3}";
        req(m, u, h, q, b, j);
    }

    @Test
    public void Put() {
        String m = "put";
        String u = "http://localhost:8080/service/repository/deployments";
        String h = "{\"b\":\"2\"}";
        String q = "{\"a\":1}";
        String b = "{\"c\":3}";
        String j = "";
        req(m, u, h, q, b, j);
    }

    @Test
    public void Delete() {
        String m = "delete";
        String u = "http://localhost:8080/service/repository/deployments/1";
        String h = "{\"b\":\"2\"}";
        String q = "{\"a\":1}";
        String b = "{\"c\":3}";
        String j = "";
        req(m, u, h, q, b, j);
    }

    public void req(String m, String u, String h, String q, String b, String j) {
        HttpMethod httpMethod = HttpMethod.resolve(m.toUpperCase());
        if (httpMethod == null) {
            log.error("HTTP 请求方法错误 请求方法: {} ", m);
            throw new IllegalArgumentException("HTTP 请求方法错误");
        }

        HttpHeaders headers = new HttpHeaders();
        if (h != null && h.length() > 0) {
            JSONObject headerObj = JSONUtil.parseObj(h);
            headerObj.keySet().forEach(v -> {
                headers.set(v, (String) headerObj.get(v));
            });
        }


        Map<String, Object> body = null;
        switch (m) {
            case "get":
                if (q != null && q.length() > 0) {
                    Map<String, String> query = JSONUtil.parseObj(q).toBean(Map.class);
                    u += "?";
                    for(String paramName :query.keySet()) {
                        u += String.format("%s=%s&", paramName, query.get(paramName));
                    }
                    u = u.substring(0, u.length() - 1);
                }
                break;
            case "post":
                if (b != null && b.length() > 0) {
                    body = JSONUtil.parseObj(b).toBean(Map.class);
                } else if (j != null && j.length() > 0) {
                    headers.setContentType(MediaType.APPLICATION_JSON);
                    body = JSONUtil.parse(j).toBean(Map.class);
                }
                break;
            case "put":
            case "delete":
                if (j != null && j.length() > 0) {
                    headers.setContentType(MediaType.APPLICATION_JSON);
                    body = JSONUtil.parse(j).toBean(Map.class);
                }
                break;
        }

        HttpEntity requestEntity = new HttpEntity(body, headers);
        ResponseEntity<Map> resp = null;
        try {
            resp = restTemplate.exchange(u, httpMethod, requestEntity, Map.class);
        } catch (Exception e) {
            log.error("调用接口发生错误", e);
        } finally {
            log.info("调用: [{}] {}", m, u);
            log.info("请求头: {}", headers);
            log.info("请求参数: {}", body);
            if (resp != null ) {
                log.info("返回: {}", resp.getBody());
            }
        }
    }

}