package me.leeyuseon.springbootdeveloper.repository;

import me.leeyuseon.springbootdeveloper.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Article, Long> {
}
