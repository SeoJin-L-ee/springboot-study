package me.leeseojin.springbootdeveloper.service;

import lombok.RequiredArgsConstructor;
import me.leeseojin.springbootdeveloper.domain.Article;
import me.leeseojin.springbootdeveloper.dto.AddArticleRequest;
import me.leeseojin.springbootdeveloper.dto.ArticleResponse;
import me.leeseojin.springbootdeveloper.dto.UpdateArticleRequest;
import me.leeseojin.springbootdeveloper.repository.BlogRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BlogService {

    private final BlogRepository blogRepository;

    //블로그 글 추가 메서드
    public Article save(AddArticleRequest request) {
        return blogRepository.save(request.toEntity());
    }

    //블로그 글 전체 검색 메서드
    public List<Article> findAll() {
        return blogRepository.findAll();
    }

    //블로그 글 하나 조회하는 메서드
    public Article findById(long id) {
        return blogRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found: " + id));
    }

    public void delete(long id) {
        blogRepository.deleteById(id);
    }

    @Transactional //트랜잭션: DB에서 데이터를 바꾸기 위한 작업 단위를 말함.
    public Article update(long id, UpdateArticleRequest request) {
        Article article = blogRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found: " + id));

        article.update(request.getTitle(), request.getContent());

        return article;
    }

}
