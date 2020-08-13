package game.apeiron.models;

public class Character {
	private String name;
	private String biome;
	private String torso;
	private String shoulders;
	private String pants;
	private String helmet;
	private String gloves;
	private String boots;
	private String belt;
	private String bodyType;
	private String weakSpell;
	private String strongSpell;
	private String healingSpell;
	private String protectionSpell;
	private double weakSpellCooldown;
	private double strongSpellCooldown;
	private double healingSpellCooldown;
	private double protectionSpellCooldown;

	public Character() {
	}

	public Character(User user) {
		this.name = user.getLogin();
		this.biome = user.getBiome().name().toLowerCase();
		this.torso = user.getTorso().name().toLowerCase();
		this.shoulders = user.getShoulders().name().toLowerCase();
		this.pants = user.getPants().name().toLowerCase();
		this.helmet = user.getHelmet().name().toLowerCase();
		this.gloves = user.getGloves().name().toLowerCase();
		this.boots = user.getBoots().name().toLowerCase();
		this.belt = user.getBelt().name().toLowerCase();
		this.bodyType = user.getBodyType().name().toLowerCase();
		this.weakSpell = user.getWeakSpell().name().toLowerCase();
		this.weakSpellCooldown = user.getWeakSpell().cooldown;
		this.strongSpell = user.getStrongSpell().name().toLowerCase();
		this.strongSpellCooldown = user.getStrongSpell().cooldown;
		this.healingSpell = user.getHealingSpell().name().toLowerCase();
		this.healingSpellCooldown = user.getHealingSpell().cooldown;
		this.protectionSpell = user.getProtectionSpell().name().toLowerCase();
		this.protectionSpellCooldown = user.getProtectionSpell().cooldown;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTorso() {
		return torso;
	}

	public void setTorso(String torso) {
		this.torso = torso;
	}

	public String getShoulders() {
		return shoulders;
	}

	public void setShoulders(String shoulders) {
		this.shoulders = shoulders;
	}

	public String getPants() {
		return pants;
	}

	public void setPants(String pants) {
		this.pants = pants;
	}

	public String getHelmet() {
		return helmet;
	}

	public void setHelmet(String helmet) {
		this.helmet = helmet;
	}

	public String getGloves() {
		return gloves;
	}

	public void setGloves(String gloves) {
		this.gloves = gloves;
	}

	public String getBoots() {
		return boots;
	}

	public void setBoots(String boots) {
		this.boots = boots;
	}

	public String getBelt() {
		return belt;
	}

	public void setBelt(String belt) {
		this.belt = belt;
	}

	public String getBodyType() {
		return bodyType;
	}

	public void setBodyType(String bodyType) {
		this.bodyType = bodyType;
	}

	public String getWeakSpell() {
		return weakSpell;
	}

	public void setWeakSpell(String weakSpell) {
		this.weakSpell = weakSpell;
	}

	public String getStrongSpell() {
		return strongSpell;
	}

	public void setStrongSpell(String strongSpell) {
		this.strongSpell = strongSpell;
	}

	public String getHealingSpell() {
		return healingSpell;
	}

	public void setHealingSpell(String healingSpell) {
		this.healingSpell = healingSpell;
	}

	public String getProtectionSpell() {
		return protectionSpell;
	}

	public void setProtectionSpell(String protectionSpell) {
		this.protectionSpell = protectionSpell;
	}

	public double getWeakSpellCooldown() {
		return weakSpellCooldown;
	}

	public void setWeakSpellCooldown(double weakSpellCooldown) {
		this.weakSpellCooldown = weakSpellCooldown;
	}

	public double getStrongSpellCooldown() {
		return strongSpellCooldown;
	}

	public void setStrongSpellCooldown(double strongSpellCooldown) {
		this.strongSpellCooldown = strongSpellCooldown;
	}

	public double getHealingSpellCooldown() {
		return healingSpellCooldown;
	}

	public void setHealingSpellCooldown(double healingSpellCooldown) {
		this.healingSpellCooldown = healingSpellCooldown;
	}

	public double getProtectionSpellCooldown() {
		return protectionSpellCooldown;
	}

	public void setProtectionSpellCooldown(double protectionSpellCooldown) {
		this.protectionSpellCooldown = protectionSpellCooldown;
	}

	public String getBiome() {
		return biome;
	}

	public void setBiome(String biome) {
		this.biome = biome;
	}
}