package game.apeiron.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CharacterData {
	private boolean c2dictionary = true;

	private Character data;

	public CharacterData() {
	}

	public CharacterData(User user) {
		this.data = new Character(user);
	}

	public CharacterData(Character character) {
		this.data = character;
	}

	public boolean isC2dictionary() {
		return c2dictionary;
	}

	public void setC2dictionary(boolean c2dictionary) {
		this.c2dictionary = c2dictionary;
	}

	public Character getData() {
		return data;
	}

	public void setData(Character data) {
		this.data = data;
	}
}