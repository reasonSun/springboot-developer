package me.leeyuseon.springbootdeveloper.service;

import lombok.RequiredArgsConstructor;
import me.leeyuseon.springbootdeveloper.domain.Article;
import me.leeyuseon.springbootdeveloper.dto.AddArticleRequest;
import me.leeyuseon.springbootdeveloper.dto.UpdateArticleRequest;
import me.leeyuseon.springbootdeveloper.repository.BlogRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BlogService {

    private final BlogRepository blogRepository;

    public Article save(AddArticleRequest addArticleRequest) {
        return blogRepository.save(addArticleRequest.toEntity());
    }

    public List<Article> findAll() { return blogRepository.findAll(); }

    public Article findById(Long id) {
        return blogRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found: "+ id)); }

    @Transactional
    public void delete(long id){
        blogRepository.deleteById(id);
    }

    @Transactional
    public Article update(long id, UpdateArticleRequest request) {
        Article article = blogRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found: "+ id));

        article.update(request.getTitle(), request.getContent());

        return article;
    }

}
