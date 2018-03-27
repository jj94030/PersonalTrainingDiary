package pl.coderslab.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import pl.coderslab.entity.Client;
import pl.coderslab.entity.PersonalTrainer;
import pl.coderslab.repository.ClientRepository;

@Controller
public class ClientController {

	@Autowired
	ClientRepository clientRepo;

	@RequestMapping("/clientsList")
	public String allClientsList() {
		return "allTrainerClientsList";
	}
	
	@GetMapping("/addClient")
	public String addClientByPersonalTrainer(Model model) {
		model.addAttribute("client", new Client());
		return "addClientByPersonalTrainerForm";
	}

	@PostMapping("/addClient")
	@ResponseBody
	public String addClientByPersonalTrainerPost(HttpSession session, @Valid @ModelAttribute Client client,
			BindingResult bindingResult, Model model) {
		model.addAttribute(client);
		if (bindingResult.hasErrors()) {
			return "addClientByPersonalTrainerForm";
		}
		PersonalTrainer trainer = (PersonalTrainer) session.getAttribute("loggedInPersonalTrainer");
		client.setPersonalTrainer(trainer);
		this.clientRepo.save(client);
		return "dodano nowego kienta";
	}
	
	@ModelAttribute("clients")
	public List<Client> getClient(HttpSession session) {
		PersonalTrainer trainer = (PersonalTrainer) session.getAttribute("loggedInPersonalTrainer");
		return trainer.getClients();
		
	}

}
