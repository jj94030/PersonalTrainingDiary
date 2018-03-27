package pl.coderslab.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import pl.coderslab.entity.PersonalTrainer;
import pl.coderslab.model.PersonalTrainerDTO;
import pl.coderslab.repository.PersonalTrainerRepository;

@Controller
@SessionAttributes({"loggedInPersonalTrainer"})
public class PersonalTrainerController {

	@Autowired
	PersonalTrainerRepository personalTrainerRepo;
	
// register ---------------------------------------------------------------------------------	
	@GetMapping("/register")
	public String registerPersonalTrainer(Model model){
		model.addAttribute("personalTrainer", new PersonalTrainer());
		return "registerPersonalTrainerForm";
	}
	
	@PostMapping("/register")
	public String registerPersonalTrainerPost(@Valid @ModelAttribute PersonalTrainer personalTrainer, BindingResult bindingResult){
		personalTrainerRepo.save(personalTrainer);
		return "redirect:/";
	}
	
// login ------------------------------------------------------------------------------------
	@GetMapping("/login")
	public String loginPersonalTrainer(Model model){
		model.addAttribute("personalTrainerDTO", new PersonalTrainerDTO());
		return "loginPersonalTrainerForm";
	}
	@PostMapping("/login")
	public String loginPersonalTrainerPost(@Valid @ModelAttribute PersonalTrainerDTO personalTrainerDTO, BindingResult bindingResult, Model model){
		PersonalTrainer personalTrainer = personalTrainerRepo.findOneByEmail(personalTrainerDTO.getEmail());
		if(personalTrainer != null && personalTrainer.isPasswordCorrect(personalTrainerDTO.getPassword())){
			model.addAttribute("loggedInPersonalTrainer", personalTrainer);
			return "redirect:/";
		}
		return "redirect:/";
	}
// logout ----------------------------------------------------------------------------------------	
	@GetMapping("/logout")
	public String logoutPersonalTrainer(SessionStatus sessionStatus){
		sessionStatus.setComplete();
		return "redirect:/";
	}
	
	
}
