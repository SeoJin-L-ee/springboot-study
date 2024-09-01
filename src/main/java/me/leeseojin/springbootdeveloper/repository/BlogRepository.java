package me.leeseojin.springbootdeveloper.repository;

import me.leeseojin.springbootdeveloper.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Article, Long> {
}
