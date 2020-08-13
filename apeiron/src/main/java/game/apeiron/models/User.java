package game.apeiron.models;

import java.util.Collection;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	protected long id;
	private String login;
	private String email;
	private String password;
	private Integer age;
	private String country;
	private String gender;
	private Integer gamesCount = 0;
	private Integer winsCount = 0;
	private Integer rating = 0;

	@ElementCollection(targetClass = Role.class)
	@Enumerated(EnumType.ORDINAL)
	@CollectionTable(name = "user_role")
	@Column(name = "role")
	private Collection<Role> roles;

	@Enumerated(EnumType.ORDINAL)
	private Biome biome = Biome.FOREST;
	@Enumerated(EnumType.ORDINAL)
	private Torso torso = Torso.ROBE;
	@Enumerated(EnumType.ORDINAL)
	private Shoulders shoulders = Shoulders.MISSING;
	@Enumerated(EnumType.ORDINAL)
	private Pants pants = Pants.SKIRT;
	@Enumerated(EnumType.ORDINAL)
	private Helmet helmet = Helmet.MISSING;
	@Enumerated(EnumType.ORDINAL)
	private Gloves gloves = Gloves.MISSING;
	@Enumerated(EnumType.ORDINAL)
	private Boots boots = Boots.MISSING;
	@Enumerated(EnumType.ORDINAL)
	private Belt belt = Belt.MISSING;
	@Enumerated(EnumType.ORDINAL)
	private BodyType bodyType = BodyType.SKELETON;
	@Enumerated(EnumType.ORDINAL)
	private WeakSpell weakSpell = WeakSpell.FIREBOLT;
	@Enumerated(EnumType.ORDINAL)
	private StrongSpell strongSpell = StrongSpell.BLAST;
	@Enumerated(EnumType.ORDINAL)
	private HealingSpell healingSpell = HealingSpell.PERIODIC;
	@Enumerated(EnumType.ORDINAL)
	private ProtectionSpell protectionSpell = ProtectionSpell.MAGIC;

	public void lose() {
		gamesCount++;
	}

	public void win() {
		gamesCount++;
		winsCount++;
	}

	public void setEquipment(Character character) {
		this.torso = Torso.valueOf(character.getTorso().toUpperCase());
		this.shoulders = Shoulders.valueOf(character.getShoulders().toUpperCase());
		this.pants = Pants.valueOf(character.getPants().toUpperCase());
		this.helmet = Helmet.valueOf(character.getHelmet().toUpperCase());
		this.gloves = Gloves.valueOf(character.getGloves().toUpperCase());
		this.boots = Boots.valueOf(character.getBoots().toUpperCase());
		this.belt = Belt.valueOf(character.getBelt().toUpperCase());
		this.bodyType = BodyType.valueOf(character.getBodyType().toUpperCase());
		this.weakSpell = WeakSpell.valueOf(character.getWeakSpell().toUpperCase());
		this.strongSpell = StrongSpell.valueOf(character.getStrongSpell().toUpperCase());
		this.healingSpell = HealingSpell.valueOf(character.getHealingSpell().toUpperCase());
		this.protectionSpell = ProtectionSpell.valueOf(character.getProtectionSpell().toUpperCase());
		this.biome = Biome.valueOf(character.getBiome().toUpperCase());
	}

	public Biome getBiome() {
		return biome;
	}

	public void setBiome(Biome biome) {
		this.biome = biome;
	}

	public void setGamesCount(int gamesCount) {
		this.gamesCount = gamesCount;
	}

	public long getId() {
		return id;
	}

	public String getLogin() {
		return login;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Collection<Role> getRoles() {
		return roles;
	}

	public void setRoles(Collection<Role> roles) {
		this.roles = roles;
	}

	public Integer getWinsCount() {
		return winsCount;
	}

	public void setWinsCount(Integer winsCount) {
		this.winsCount = winsCount;
	}

	public Integer getGamesCount() {
		return gamesCount;
	}

	public void setGamesCount(Integer gamesCount) {
		this.gamesCount = gamesCount;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Torso getTorso() {
		return torso;
	}

	public void setTorso(Torso torso) {
		this.torso = torso;
	}

	public Shoulders getShoulders() {
		return shoulders;
	}

	public void setShoulders(Shoulders shoulders) {
		this.shoulders = shoulders;
	}

	public Pants getPants() {
		return pants;
	}

	public void setPants(Pants pants) {
		this.pants = pants;
	}

	public Helmet getHelmet() {
		return helmet;
	}

	public void setHelmet(Helmet helmet) {
		this.helmet = helmet;
	}

	public Gloves getGloves() {
		return gloves;
	}

	public void setGloves(Gloves gloves) {
		this.gloves = gloves;
	}

	public Boots getBoots() {
		return boots;
	}

	public void setBoots(Boots boots) {
		this.boots = boots;
	}

	public Belt getBelt() {
		return belt;
	}

	public void setBelt(Belt belt) {
		this.belt = belt;
	}

	public BodyType getBodyType() {
		return bodyType;
	}

	public void setBodyType(BodyType bodyType) {
		this.bodyType = bodyType;
	}

	public WeakSpell getWeakSpell() {
		return weakSpell;
	}

	public void setWeakSpell(WeakSpell weakSpell) {
		this.weakSpell = weakSpell;
	}

	public StrongSpell getStrongSpell() {
		return strongSpell;
	}

	public void setStrongSpell(StrongSpell strongSpell) {
		this.strongSpell = strongSpell;
	}

	public HealingSpell getHealingSpell() {
		return healingSpell;
	}

	public void setHealingSpell(HealingSpell healingSpell) {
		this.healingSpell = healingSpell;
	}

	public ProtectionSpell getProtectionSpell() {
		return protectionSpell;
	}

	public void setProtectionSpell(ProtectionSpell protectionSpell) {
		this.protectionSpell = protectionSpell;
	}
}

enum Biome {
	FOREST, DESERT
}

enum Torso {
	ROBE, LEATHER, ARMORED, SHIRT, MAIL
}

enum Shoulders {
	MISSING, ARMORED, LEATHER
}

enum Pants {
	SKIRT, GREEN, ARMORED
}

enum Helmet {
	MISSING, USUAL, MAIL, BLONDHAIR, HAT, ARMORED, HOOD
}

enum Gloves {
	MISSING, ARMORED
}

enum Boots {
	MISSING, ARMORED, LEATHER
}

enum Belt {
	LEATHER, ROPE, MISSING
}

enum BodyType {
	SKELETON, HUMAN
}

enum WeakSpell {
	FIREBOLT(1), FIRECLOAK(5), FIRESTREAM(0.1);

	public final double cooldown;

	private WeakSpell(double cooldown) {
		this.cooldown = cooldown;
	}
}

enum StrongSpell {
	BLAST(6), PYROBLAST(4), BREATH(5);

	public final double cooldown;

	private StrongSpell(double cooldown) {
		this.cooldown = cooldown;
	}
}

enum HealingSpell {
	INSTANT(9), PERIODIC(0);

	public final double cooldown;

	private HealingSpell(double cooldown) {
		this.cooldown = cooldown;
	}
}

enum ProtectionSpell {
	MAGIC(5), SHIELD(0);

	public final int cooldown;

	private ProtectionSpell(int cooldown) {
		this.cooldown = cooldown;
	}
}