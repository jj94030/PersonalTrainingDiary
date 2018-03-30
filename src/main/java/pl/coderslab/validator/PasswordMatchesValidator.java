package pl.coderslab.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import pl.coderslab.model.PersonalTrainerDTO;



public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, Object> { 

  public void initialize(PasswordMatches constraintAnnotation) {       
  }

  public boolean isValid(Object obj, ConstraintValidatorContext context){   
      PersonalTrainerDTO trainerDTO = (PersonalTrainerDTO) obj;
      return trainerDTO.getPassword().equals(trainerDTO.getMatchingPassword());    
  }
}
