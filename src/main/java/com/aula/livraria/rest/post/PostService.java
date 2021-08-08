package com.aula.livraria.rest.post;

import com.aula.livraria.integration.dbjson.Post;

public interface PostService {

    Post testPost(Post post);

    Post testPut(Post post, Long id);

    void testDelete(Long id);
}
