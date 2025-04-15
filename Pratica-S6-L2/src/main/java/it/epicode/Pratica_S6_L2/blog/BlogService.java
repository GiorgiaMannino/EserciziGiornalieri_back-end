package it.epicode.Pratica_S6_L2.blog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

@Service
public class BlogService {

    @Autowired
    private BlogRepository blogRepository;

    // find all
    public List<BlogResponse> findAll() {
        List<Blog> blog = blogRepository.findAll();
        return blog.stream()
                .map(blog1 -> new BlogResponse(
                        blog1.getId(),
                        blog1.getCategoria(),
                        blog1.getTitolo(),
                        blog1.getAutore().getNome() + " " + blog1.getAutore().getCognome()
                ))
                .toList();
    }

    // find by id
    public BlogResponse findById(Long id) {
        Blog blog = blogRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Blog non trovato"));
        return new BlogResponse(
                blog.getId(),
                blog.getCategoria(),
                blog.getTitolo(),
                blog.getAutore().getNome() + " " + blog.getAutore().getCognome()
        );
    }

    // save
    public BlogResponse save(BlogRequest blogRequest) {
        Blog blog = new Blog();
        blog.setCategoria(blogRequest.getCategoria());
        blog.setTitolo(blogRequest.getTitolo());
        blog.setContenuto(blogRequest.getContenuto());
        blog.setTempoDiLettura(blogRequest.getTempoDiLettura());
        blogRepository.save(blog);
        return new BlogResponse(
                blog.getId(),
                blog.getCategoria(),
                blog.getTitolo(),
                blog.getAutore().getNome() + " " + blog.getAutore().getCognome()
        );
    }

    // update
    public BlogResponse update(Long id, BlogRequest blogRequest) {
        Blog blog = blogRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Blog non trovato"));
        blog.setCategoria(blogRequest.getCategoria());
        blog.setTitolo(blogRequest.getTitolo());
        blog.setContenuto(blogRequest.getContenuto());
        blog.setTempoDiLettura(blogRequest.getTempoDiLettura());
        blogRepository.save(blog);
        return new BlogResponse(
                blog.getId(),
                blog.getCategoria(),
                blog.getTitolo(),
                blog.getAutore().getNome() + " " + blog.getAutore().getCognome()
        );
    }

    // delete
    public void deleteById(Long id) {
       Blog blog = blogRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Blog non trovato"));
        blogRepository.delete(blog);
    }

}
