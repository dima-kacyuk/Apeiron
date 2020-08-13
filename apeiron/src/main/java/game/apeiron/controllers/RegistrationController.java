package game.apeiron.controllers;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import game.apeiron.models.ReCaptchaResponse;
import game.apeiron.models.Role;
import game.apeiron.models.User;
import game.apeiron.repositories.UserRepository;

@Controller
public class RegistrationController {
	@Autowired
	private UserRepository userRepo;

	@Autowired
	RestTemplate restTemplate;

	@GetMapping(value = "/registration")
	public String getRegistrationPage() {
		return "registration";
	}

	@PostMapping(value = "/registration")
	private String addUser(@ModelAttribute User user,
			@RequestParam(name = "g-recaptcha-response") String captchaResponse, Model model) {
		String url = "https://www.google.com/recaptcha/api/siteverify";
		String params = "?secret=6LcDYa4UAAAAACq7ndExM4GkxYUlU59S83nfgsAY&response=" + captchaResponse;
		ReCaptchaResponse reCaptchaResponse = restTemplate
				.exchange(url + params, HttpMethod.POST, null, ReCaptchaResponse.class).getBody();
		if (reCaptchaResponse.isSuccess()) {
			boolean isEmpty = !userRepo.findByLogin(user.getLogin()).isPresent();

			if (isEmpty) {
				if(loginContainsUnsupportedSymbols(user)) {
					model.addAttribute("unsupportedSymbols", true);
					return "registration";
				}

				List<Role> roles = Arrays.asList(new Role[] { Role.USER });
				user.setRoles(roles);
				user.setRating(0);
				userRepo.saveAndFlush(user);
				return "redirect:/login";
			}

			model.addAttribute("suchUserExists", true);

			return "registration";
		}
		model.addAttribute("captchaError", "Fill");
		return "registration";
	}

	private boolean loginContainsUnsupportedSymbols(User u) {
		Pattern p = Pattern.compile("[a-zA-Zа-яА-Я0-9_]*");
	     Matcher m = p.matcher(u.getLogin());
	     return !m.matches();
	}
}