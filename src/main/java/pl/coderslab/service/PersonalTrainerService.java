package pl.coderslab.service;

import java.util.Arrays;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.coderslab.entity.PersonalTrainer;
import pl.coderslab.model.PersonalTrainerDTO;
import pl.coderslab.repository.PersonalTrainerRepository;
import pl.coderslab.validator.EmailExistsException;

@Service
public class PersonalTrainerService implements IPersonalTrainerService {
	@Autowired
	private PersonalTrainerRepository repository;

	@Transactional
    public PersonalTrainer registerNewUserAccount(PersonalTrainerDTO accountDto) 
      throws EmailExistsException {
        
        if (emailExist(accountDto.getEmail())) {   
            throw new EmailExistsException(
              "There is an account with that email address: " + accountDto.getEmail());
        }
        PersonalTrainer trainer = new PersonalTrainer();    
        trainer.setName(accountDto.getName());
        trainer.setSurname(accountDto.getSurname());
        trainer.setPhoneNumber(accountDto.getPhoneNumber());
        trainer.setPassword(accountDto.getPassword());
        trainer.setEmail(accountDto.getEmail());
        trainer.setRoles(Arrays.asList("ROLE_ADMIN"));
        return repository.save(trainer);       
    }

	private boolean emailExist(String email) {
		PersonalTrainer trainer = repository.findByEmail(email);
		if (trainer != null) {
			return true;
		}
		return false;
	}
}