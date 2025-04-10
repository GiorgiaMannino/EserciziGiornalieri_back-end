package it.epicode.Pratica_S5_L4.pizze;


import org.springframework.data.jpa.repository.JpaRepository;

public interface PizzaRepository extends JpaRepository<Pizza, Long> {
}