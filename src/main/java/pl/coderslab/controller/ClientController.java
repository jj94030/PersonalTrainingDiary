package pl.coderslab.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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

	// ADD CLIENT:
	@GetMapping("/addClient")
	public String addClientByPersonalTrainer(Model model) {
		model.addAttribute("client", new Client());
		return "addClientByPersonalTrainerForm";
	}

	@PostMapping("/addClient")
	public String addClientByPersonalTrainerPost(HttpSession session, @Valid @ModelAttribute Client client,
			BindingResult bindingResult, Model model) {
		model.addAttribute(client);
		if (bindingResult.hasErrors()) {
			return "addClientByPersonalTrainerForm";
		}
		PersonalTrainer trainer = (PersonalTrainer) session.getAttribute("loggedInPersonalTrainer");
		client.setPersonalTrainer(trainer);
		this.clientRepo.save(client);
		return "redirect:/";
	}

	// EDIT CLIENT:
	@GetMapping("/editClient/{id}")
	public String editClientByPersonalTrainer(@PathVariable long id, Model model) {
		Client client = clientRepo.findOne(id);
		model.addAttribute("client", client);
		return "addClientByPersonalTrainerForm";
	}

	@PostMapping("/editClient/{id}")
	public String editClientByPersonalTrainerPost(HttpSession session, @PathVariable long id, Model model,
			@Valid @ModelAttribute Client client, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "addClientByPersonalTrainerForm";
		}
		PersonalTrainer trainer = (PersonalTrainer) session.getAttribute("loggedInPersonalTrainer");
		client.setPersonalTrainer(trainer);
		clientRepo.save(client);
		return "redirect:/clientsList";
	}

	// DELETE CLIENT:
	@GetMapping("/deleteClient/{id}")
	public String deleteClientByPersonalTrainer(@PathVariable long id) {
		clientRepo.delete(id);
		return "redirect:/clientsList";
	}

	// MODEL ATTRIBUTES:
	@ModelAttribute("clients")
	public List<Client> getClient(HttpSession session) {

		PersonalTrainer trainer = (PersonalTrainer) session.getAttribute("loggedInPersonalTrainer");
		return this.clientRepo.findClientsByPersonalTrainer(trainer);
	}

	@ModelAttribute("daysOfWeek")
	public Collection<String> daysOfWeek() {
		List<String> week = new ArrayList<String>();
		week.add("MONDAY");
		week.add("TUESDAY");
		week.add("WEDNESDAY");
		week.add("THURSDAY");
		week.add("FRIDAY");
		week.add("SATURDAY");
		return week;
	}

}
