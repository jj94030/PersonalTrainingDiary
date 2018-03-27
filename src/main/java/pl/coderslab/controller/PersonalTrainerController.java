package pl.coderslab.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import pl.coderslab.entity.PersonalTrainer;
import pl.coderslab.repository.PersonalTrainerRepository;

@Controller
public class PersonalTrainerController {

	@Autowired
	PersonalTrainerRepository personalTrainerRepo;
	
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
	
}
