package pl.coderslab.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.coderslab.entity.Client;
import pl.coderslab.entity.PersonalTrainer;


public interface ClientRepository extends JpaRepository <Client, Long> {
	List<Client> findClientsByPersonalTrainer(PersonalTrainer trainer);
}
