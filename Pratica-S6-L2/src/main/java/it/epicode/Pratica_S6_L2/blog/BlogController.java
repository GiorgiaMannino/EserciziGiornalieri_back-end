
package it.epicode.Pratica_S6_L2.blog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blog")
public class BlogController {

    @Autowired
    private BlogService blogService;

    // get lista di blog
    @GetMapping
    public List<BlogResponse> find() {
        return blogService.findAll();
    }

    // get blog con id
    @GetMapping("/{id}")
    public BlogResponse find(@PathVariable Long id) {
        return blogService.findById(id);
    }

    // post creo blog
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BlogResponse save(BlogRequest blogRequest) {
        return blogService.save(blogRequest);
    }

    // put modifico blog con id
    @PutMapping("/{id}")
    public BlogResponse update(@PathVariable Long id, @RequestBody BlogRequest blogRequest) {
        return blogService.update(id, blogRequest);
    }

    // delete blog con id
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        blogService.deleteById(id);
    }

}

