package com.aula.livraria.rest.post;

import com.aula.livraria.integration.dbjson.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = PostController._PATH)
public class PostController {

    public static final String _PATH = "/posts";

    private final PostService postService;


    @Autowired
    PostController(PostServiceImpl postService) {
        this.postService = postService;
    }


    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Post> testPost(@RequestBody Post post) {
        return ResponseEntity.ok(this.postService.testPost(post));
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Post> testPut(@RequestBody Post post, @PathVariable(value = "id") Long id) {
        return ResponseEntity.ok(this.postService.testPut(post, id));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> testDelete(@PathVariable(value = "id") Long id) {
        this.postService.testDelete(id);
        return ResponseEntity.noContent().build();
    }
}
