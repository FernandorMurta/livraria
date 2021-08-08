package com.aula.livraria.integration.dbjson;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class DbJsonIntegration {

    @Value("${db.json.domain}")
    private String url;


    public Post testPost(Post post) {
        HttpEntity<Post> entity = new HttpEntity<>(post);

        RestTemplate restTemplate = new RestTemplate();

        return restTemplate.postForObject(this.getEntityUrl(), entity, Post.class);
    }

    public Post testPut(Post post, Long id) {
        HttpEntity<Post> entity = new HttpEntity<>(post);

        RestTemplate restTemplate = new RestTemplate();

       return restTemplate.exchange(this.getEntityUrl() + "/" + id.toString(), HttpMethod.PUT,  entity, Post.class).getBody();
    }

    public void testDelete(Long id){
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(this.getEntityUrl() + "/" + id.toString());
    }

    private String getEntityUrl() {
        return this.url + "posts";
    }
}
