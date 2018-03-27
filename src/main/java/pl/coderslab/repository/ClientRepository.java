package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.coderslab.entity.Client;


public interface ClientRepository extends JpaRepository <Client, Long> {

}
