package fr.solutec.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.solutec.entities.Bar;

public interface BarRepository extends JpaRepository<Bar, Long>{

}
