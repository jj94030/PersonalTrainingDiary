package pl.coderslab.service;

import pl.coderslab.entity.PersonalTrainer;
import pl.coderslab.model.PersonalTrainerDTO;
import pl.coderslab.validator.EmailExistsException;

public interface IPersonalTrainerService {
	PersonalTrainer registerNewUserAccount(PersonalTrainerDTO accountDto) 
		      throws EmailExistsException;
}
