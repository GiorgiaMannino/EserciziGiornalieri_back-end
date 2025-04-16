package it.epicode.Pratica_S6_L3.blog;

import it.epicode.Pratica_S6_L3.autori.Autore;
import it.epicode.Pratica_S6_L3.autori.AutoreRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class BlogService {

    @Autowired
    private BlogRepository blogRepository;

    @Autowired
    private AutoreRepository autoreRepository;

    // find all
    public Page<BlogResponse> findAll(Pageable pageable) {
        return blogRepository.findAll(pageable)
                .map(this::fromEntity);
    }

    public BlogResponse fromEntity(Blog blog) {
        BlogResponse response = new BlogResponse();
        BeanUtils.copyProperties(blog, response);
        return response;
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
    public BlogResponse save(@Valid BlogRequest blogRequest) {
        Blog blog = new Blog();
        blog.setCategoria(blogRequest.getCategoria());
        blog.setTitolo(blogRequest.getTitolo());
        blog.setContenuto(blogRequest.getContenuto());
        blog.setTempoDiLettura(blogRequest.getTempoDiLettura());

        // Set autore
        Autore autore = autoreRepository.findById(blogRequest.getAutoreId())
                .orElseThrow(() -> new RuntimeException("Autore non trovato"));
        blog.setAutore(autore);

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

        // Set nuovo autore, se cambiato
        Autore autore = autoreRepository.findById(blogRequest.getAutoreId())
                .orElseThrow(() -> new RuntimeException("Autore non trovato"));
        blog.setAutore(autore);

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
