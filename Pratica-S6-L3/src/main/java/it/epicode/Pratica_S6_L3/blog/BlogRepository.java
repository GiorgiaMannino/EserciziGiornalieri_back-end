package it.epicode.Pratica_S6_L3.blog;


import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Blog, Long> {
}