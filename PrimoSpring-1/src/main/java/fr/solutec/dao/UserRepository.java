package fr.solutec.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.solutec.entities.User;


public interface UserRepository extends JpaRepository<User, Long>{

}
