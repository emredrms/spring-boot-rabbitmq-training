package com.course.rabbitmqproducer.utility;

import java.util.Base64;
import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Proxy to RabbitMQ Http API. USe API for maintenance only, not transactional
 * 
 * @author timpamungkas
 *
 */
@Service
public class RabbitmqProxyService {

    private RestTemplate restTemplate = new RestTemplate();

    public static HttpHeaders createBasicAuthHeaders() {
        return new HttpHeaders() {
            private static final long serialVersionUID = 1L;
            {
                String auth = "guest:guest";
                byte[] encodedAuth = Base64.getEncoder().encode(auth.getBytes());
                String authHeader = "Basic " + new String(encodedAuth);
                set("Authorization", authHeader);
            }
        };
    }

    public List<RabbitmqQueue> getAllQueues() {
        var endpoint = "http://localhost:15672/api/queues";
        var httpEntity = new HttpEntity<>(createBasicAuthHeaders());
        ResponseEntity<List<RabbitmqQueue>> response = restTemplate.exchange(endpoint, HttpMethod.GET, httpEntity,
                new ParameterizedTypeReference<List<RabbitmqQueue>>() {
                });

        return response.getBody();
    }

}
