package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.coderslab.entity.PersonalTrainer;

public interface PersonalTrainerRepository extends JpaRepository <PersonalTrainer, Long> {
	
	//void delete(User user);
	PersonalTrainer findByEmail(String email);
}
