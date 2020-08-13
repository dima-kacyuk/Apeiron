package game.apeiron.controllers;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.google.gson.Gson;
import game.apeiron.models.CharacterData;
import game.apeiron.models.User;
import game.apeiron.repositories.UserRepository;

@RestController
public class GameController {
	@Autowired
	private UserRepository userRepo;

	@GetMapping("/game/getCharacter")
	public CharacterData getCharacter(@RequestParam("player") String login) {
		System.err.println("It is me, " + login);
		User user = userRepo.findByLogin(login).get();
		CharacterData character = new CharacterData(user);

		return character;
	}

	@PostMapping("/game/setCharacter")
	public @ResponseBody ResponseEntity<User> SetCharacter(@RequestParam("player") String login,
			@RequestBody String characterData, HttpServletResponse response) throws UnsupportedEncodingException {

		characterData = characterData.substring(characterData.indexOf(login, 5) + login.length() + 1);

		characterData = characterData.replaceAll("=", "");
		characterData = characterData.replaceAll("%7B", "{");
		characterData = characterData.replaceAll("%22", "\"");
		characterData = characterData.replaceAll("%7D", "}");
		characterData = characterData.replaceAll("%3A", ":");
		characterData = characterData.replaceAll("%2C", ",");

		System.err.println("Your data is\n " + characterData);

		User user = userRepo.findByLogin(login).get();

		Gson gson = new Gson();

		CharacterData data = gson.fromJson(characterData, CharacterData.class);

		user.setEquipment(data.getData());

		return ResponseEntity.ok().body(userRepo.saveAndFlush(user));
	}

	@PostMapping("/game/gameOver")
	public void calcResults(@RequestBody String characterData, @RequestParam("winner") String winnerLogin,
			@RequestParam("loser") String loserLogin, HttpServletResponse response)
			throws UnsupportedEncodingException {
		System.err.println("And the winner is " + winnerLogin + "!");
		System.err.println("And " + loserLogin + " is noob!");

		User winner = userRepo.findByLogin(winnerLogin).get();
		User loser = userRepo.findByLogin(loserLogin).get();

		winner.setRating(winner.getRating() + 17);

		if (loser.getRating() >= 13) {
			loser.setRating(loser.getRating() - 13);
		}

		userRepo.saveAll(Arrays.asList(winner, loser));
		userRepo.flush();
	}
}