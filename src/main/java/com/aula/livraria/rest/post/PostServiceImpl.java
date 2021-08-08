package com.aula.livraria.rest.post;

import com.aula.livraria.integration.dbjson.DbJsonIntegration;
import com.aula.livraria.integration.dbjson.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {

    private final DbJsonIntegration dbJsonIntegration;

    @Autowired
    PostServiceImpl(DbJsonIntegration dbJsonIntegration) {
        this.dbJsonIntegration = dbJsonIntegration;
    }

    @Override
    public Post testPost(Post post) {
        return this.dbJsonIntegration.testPost(post);
    }

    @Override
    public Post testPut(Post post, Long id) {
        return this.dbJsonIntegration.testPut(post, id);
    }

    @Override
    public void testDelete(Long id) {
        this.dbJsonIntegration.testDelete(id);
    }
}
