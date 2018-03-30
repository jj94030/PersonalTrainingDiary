package pl.coderslab.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import pl.coderslab.entity.PersonalTrainer;
import pl.coderslab.model.PersonalTrainerDTO;
import pl.coderslab.repository.PersonalTrainerRepository;
import pl.coderslab.service.IPersonalTrainerService;
import pl.coderslab.validator.EmailExistsException;

@Controller
//@SessionAttributes({ "loggedInPersonalTrainer" })
public class PersonalTrainerController {

	@Autowired
	PersonalTrainerRepository personalTrainerRepo;

	@Autowired
	IPersonalTrainerService trainerService;

	@GetMapping("/login")
	public ModelAndView login() {
		ModelAndView model = new ModelAndView();
		model.setViewName("loginPersonalTrainerForm");
		return model;
	}

	@GetMapping("/register")
	public String register(WebRequest request, Model model) {
		PersonalTrainerDTO trainerDTO = new PersonalTrainerDTO();
		model.addAttribute("trainerDTO", trainerDTO);
		return "registerPersonalTrainerForm";
	}

	@PostMapping("/register")
	public String registerUserAccount(@ModelAttribute("personalTrainer") @Valid PersonalTrainerDTO accountDTO,
			BindingResult result, WebRequest request, Errors errors, RedirectAttributes redirectAttributes) {
		PersonalTrainer registered = new PersonalTrainer();
		if (!result.hasErrors()) {
			registered = createPersonalTrainerAccount(accountDTO, result);
		}
		if (registered == null) {
			result.rejectValue("email", "message.regError");
		}
		if (result.hasErrors()) {
			return "register";
		} else {
			redirectAttributes.addFlashAttribute("msg", "Registration successful!");
			return "redirect:/";
		}
	}

	private PersonalTrainer createPersonalTrainerAccount(PersonalTrainerDTO accountDto, BindingResult result) {
		PersonalTrainer registered = null;
		try {
			registered = trainerService.registerNewUserAccount(accountDto);
		} catch (EmailExistsException e) {
			return null;
		}
		return registered;
	}

	// // register
	// @GetMapping("/register")
	// public String registerPersonalTrainer(Model model) {
	// model.addAttribute("personalTrainer", new PersonalTrainer());
	// return "registerPersonalTrainerForm";
	// }
	//
	// @PostMapping("/register")
	// public String registerPersonalTrainerPost(@Valid @ModelAttribute
	// PersonalTrainer personalTrainer,
	// BindingResult bindingResult) {
	// if (bindingResult.hasErrors()) {
	// return "registerPersonalTrainerForm";
	// }
	// this.personalTrainerRepo.save(personalTrainer);
	// return "redirect:/";
	// }
	//
	// // login
	// @GetMapping("/login")
	// public String loginPersonalTrainer(Model model) {
	// model.addAttribute("personalTrainerDTO", new PersonalTrainerDTO());
	// return "loginPersonalTrainerForm";
	// }
	//
	// @PostMapping("/login")
	// public String loginPersonalTrainerPost(@Valid @ModelAttribute
	// PersonalTrainerDTO personalTrainerDTO,
	// BindingResult bindingResult, Model model) {
	// PersonalTrainer personalTrainer =
	// this.personalTrainerRepo.findOneByEmail(personalTrainerDTO.getEmail());
	// if (personalTrainer != null &&
	// personalTrainer.isPasswordCorrect(personalTrainerDTO.getPassword())) {
	// model.addAttribute("loggedInPersonalTrainer", personalTrainer);
	// return "redirect:/";
	// }
	// return "redirect:/";
	// }

	// // main page
	// @GetMapping("")
	// public String mainPage() {
	// return "mainPage";
	// }
	//
	// edit profile
//	@GetMapping("/edit/{id}")
//	public String editPersonalTrainerProfile(HttpSession session, @PathVariable long id, Model model) {
//		PersonalTrainer trainer = (PersonalTrainer) session.getAttribute("loggedInPersonalTrainer");
//		trainer = personalTrainerRepo.findOne(id);
//		model.addAttribute("trainer", trainer);
//		return "editTrainerProfileForm";
//	}

	// @PostMapping("/edit/{id}")
	// public String editPersonalTrainerProfilePost(@PathVariable long id,
	// @Valid @ModelAttribute PersonalTrainer trainer,
	// BindingResult bindingResult, Model model) {
	// if (bindingResult.hasErrors()) {
	// return "editTrainerProfileForm";
	// }
	// this.personalTrainerRepo.save(trainer);
	// return "redirect:/";
	// }

	// // logout
	// @GetMapping("/logout")
	// public String logoutPersonalTrainer(SessionStatus sessionStatus) {
	// sessionStatus.setComplete();
	// return "redirect:/";
	// }

}
