package com.example.project2_wod_cs.Database.entities;

import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;
import androidx.room.Relation;

import com.example.project2_wod_cs.Database.AppDatabase;

import java.util.List;
import java.util.Objects;

@Entity(tableName = AppDatabase.CHARACTER_SHEET_TABLE,
        foreignKeys =
                {@ForeignKey(
                        entity = User.class,
                        parentColumns = "id", //Pulls the User.java id field as the key to relate this table to
                        childColumns = "ownerId")}, //Curly braces because it stores the info in an array
                indices = @Index("ownerId") )

public class CharacterSheet {
    @PrimaryKey(autoGenerate = true)
    private int id;

    private int ownerId;//needs to be set to the User id that owns the sheet

    // General Character Sheet Info
    //Labels
    public final static String NAME = "NAME: ";
    public final static String PLAYER_NAME = "PLAYER: ";
    public final static String CHRONICLE = "Chronicle: ";
    public final static String NATURE = "Nature: ";
    public final static String DEMEANOR = "Demeanor: ";
    public final static String CONCEPT = "Concept: ";
    //sheet by sheet
    private String characterName = "";
    private String playerName = "";
    private String chronicle = "";
    private String nature = "";
    private String demeanor = "";
    private String concept = "";
    private int experience = 0;

    //Vampire Specific
    //Labels
    public final static String GENERATION = "Generation: ";
    public final static String SIRE = "Sire: ";
    public final static String TITLE = "Title: ";
    //sheet by sheet
    private String generation = "";
    private String sire = "";
    private String title = "";

    //Mage Specific
    //Labels
    public static final String ESSENCE = "Essence: ";
    public static final String AFFILIATION = "Affiliation: ";
    public static final String SECT = "Sect: ";
    //sheet by sheet
    private String essence = "";
    private String affiliation = "";
    private String sect = "";

    //WereWolf Specific
    //Labels
    public static final String BREED = "Breed: ";
    public static final String AUSPICE = "Auspice: ";
    public static final String TRIBE = "Tribe: ";
    public static final String PACK_NAME = "Pack Name: ";
    public static final String PACK_TOTEM = "Pack Totem: ";
    //sheet by sheet
    private String breed = "";
    private String auspice = "";
    private String tribe = "";
    private String packName = "";
    private String packTotem = "";

    //Hunter Specific
    //Labels
    public static final String PRIMARY_VIRTUE = "Primary Virtue: ";
    public static final String CREED = "Creed: ";
    public static final String STARTING_CONVICTION = "Starting Conviction: ";
    //Sheet by sheet
    private String primaryVirtue = "";
    private String creed = "";
    private String startingConviction = "";

    //Sheet Checks
    private boolean isVampire;
    private boolean isMage;
    private boolean isWereWolf;
    private boolean isHunter;

    //Character Attributes

        //Physical
    private int strengthScore;
    private int dexterityScore;
    private int staminaScore;

        //Social
    private int charismaScore;
    private int manipulationScore;
    private int appearanceScore;

        //Mental
    private int perceptionScore;
    private int intelligenceScore;
    private int witsScore;

        //Other
    //All
    private int currentWillRating;
    private int maxWillRating;
    private int healthRating;
    //Vampire
    private int humanityRating;
    private int bloodPoolRating;
    //Hunter
    private int convictionRating;
    //Mage
    private int areteRating;
    private int quintescenceRating;
    private int straitsRating;

    public CharacterSheet(int ownerId){
        this.ownerId = ownerId;
    }

    //Inner class because I don't want to make a whole new file for the relational POJO
    public static class UserWithCharacterSheets{
        @Embedded
        public User user;
        @Relation(parentColumn = "id", entityColumn = "ownerId")
        public List<CharacterSheet> characterSheets;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        CharacterSheet that = (CharacterSheet) o;
        return id == that.id && ownerId == that.ownerId && experience == that.experience && isVampire == that.isVampire && isMage == that.isMage && isWereWolf == that.isWereWolf && isHunter == that.isHunter && strengthScore == that.strengthScore && dexterityScore == that.dexterityScore && staminaScore == that.staminaScore && charismaScore == that.charismaScore && manipulationScore == that.manipulationScore && appearanceScore == that.appearanceScore && perceptionScore == that.perceptionScore && intelligenceScore == that.intelligenceScore && witsScore == that.witsScore && currentWillRating == that.currentWillRating && maxWillRating == that.maxWillRating && healthRating == that.healthRating && humanityRating == that.humanityRating && bloodPoolRating == that.bloodPoolRating && convictionRating == that.convictionRating && areteRating == that.areteRating && quintescenceRating == that.quintescenceRating && straitsRating == that.straitsRating && Objects.equals(characterName, that.characterName) && Objects.equals(playerName, that.playerName) && Objects.equals(chronicle, that.chronicle) && Objects.equals(nature, that.nature) && Objects.equals(demeanor, that.demeanor) && Objects.equals(concept, that.concept) && Objects.equals(generation, that.generation) && Objects.equals(sire, that.sire) && Objects.equals(title, that.title) && Objects.equals(essence, that.essence) && Objects.equals(affiliation, that.affiliation) && Objects.equals(sect, that.sect) && Objects.equals(breed, that.breed) && Objects.equals(auspice, that.auspice) && Objects.equals(tribe, that.tribe) && Objects.equals(packName, that.packName) && Objects.equals(packTotem, that.packTotem) && Objects.equals(primaryVirtue, that.primaryVirtue) && Objects.equals(creed, that.creed) && Objects.equals(startingConviction, that.startingConviction);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, ownerId, characterName, playerName, chronicle, nature, demeanor, concept, experience, generation, sire, title, essence, affiliation, sect, breed, auspice, tribe, packName, packTotem, primaryVirtue, creed, startingConviction, isVampire, isMage, isWereWolf, isHunter, strengthScore, dexterityScore, staminaScore, charismaScore, manipulationScore, appearanceScore, perceptionScore, intelligenceScore, witsScore, currentWillRating, maxWillRating, healthRating, humanityRating, bloodPoolRating, convictionRating, areteRating, quintescenceRating, straitsRating);
    }

    public int getStrengthScore() {
        return strengthScore;
    }

    public void setStrengthScore(int strengthScore) {
        this.strengthScore = strengthScore;
    }

    public int getDexterityScore() {
        return dexterityScore;
    }

    public void setDexterityScore(int dexterityScore) {
        this.dexterityScore = dexterityScore;
    }

    public int getStaminaScore() {
        return staminaScore;
    }

    public void setStaminaScore(int staminaScore) {
        this.staminaScore = staminaScore;
    }

    public int getCharismaScore() {
        return charismaScore;
    }

    public void setCharismaScore(int charismaScore) {
        this.charismaScore = charismaScore;
    }

    public int getManipulationScore() {
        return manipulationScore;
    }

    public void setManipulationScore(int manipulationScore) {
        this.manipulationScore = manipulationScore;
    }

    public int getAppearanceScore() {
        return appearanceScore;
    }

    public void setAppearanceScore(int appearanceScore) {
        this.appearanceScore = appearanceScore;
    }

    public int getPerceptionScore() {
        return perceptionScore;
    }

    public void setPerceptionScore(int perceptionScore) {
        this.perceptionScore = perceptionScore;
    }

    public int getIntelligenceScore() {
        return intelligenceScore;
    }

    public void setIntelligenceScore(int intelligenceScore) {
        this.intelligenceScore = intelligenceScore;
    }

    public int getWitsScore() {
        return witsScore;
    }

    public void setWitsScore(int witsScore) {
        this.witsScore = witsScore;
    }

    public int getCurrentWillRating() {
        return currentWillRating;
    }

    public void setCurrentWillRating(int currentWillRating) {
        this.currentWillRating = currentWillRating;
    }

    public int getMaxWillRating() {
        return maxWillRating;
    }

    public void setMaxWillRating(int maxWillRating) {
        this.maxWillRating = maxWillRating;
    }

    public int getHealthRating() {
        return healthRating;
    }

    public void setHealthRating(int healthRating) {
        this.healthRating = healthRating;
    }

    public int getHumanityRating() {
        return humanityRating;
    }

    public void setHumanityRating(int humanityRating) {
        this.humanityRating = humanityRating;
    }

    public int getBloodPoolRating() {
        return bloodPoolRating;
    }

    public void setBloodPoolRating(int bloodPoolRating) {
        this.bloodPoolRating = bloodPoolRating;
    }

    public int getConvictionRating() {
        return convictionRating;
    }

    public void setConvictionRating(int convictionRating) {
        this.convictionRating = convictionRating;
    }

    public int getAreteRating() {
        return areteRating;
    }

    public void setAreteRating(int areteRating) {
        this.areteRating = areteRating;
    }

    public int getQuintescenceRating() {
        return quintescenceRating;
    }

    public void setQuintescenceRating(int quintescenceRating) {
        this.quintescenceRating = quintescenceRating;
    }

    public int getStraitsRating() {
        return straitsRating;
    }

    public void setStraitsRating(int straitsRating) {
        this.straitsRating = straitsRating;
    }

    public String getCharacterName() {
        return characterName;
    }

    public void setCharacterName(String characterName) {
        this.characterName = characterName;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getChronicle() {
        return chronicle;
    }

    public void setChronicle(String chronicle) {
        this.chronicle = chronicle;
    }

    public String getNature() {
        return nature;
    }

    public void setNature(String nature) {
        this.nature = nature;
    }

    public String getDemeanor() {
        return demeanor;
    }

    public void setDemeanor(String demeanor) {
        this.demeanor = demeanor;
    }

    public String getConcept() {
        return concept;
    }

    public void setConcept(String concept) {
        this.concept = concept;
    }

    public String getGeneration() {
        return generation;
    }

    public void setGeneration(String generation) {
        this.generation = generation;
    }

    public String getSire() {
        return sire;
    }

    public void setSire(String sire) {
        this.sire = sire;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEssence() {
        return essence;
    }

    public void setEssence(String essence) {
        this.essence = essence;
    }

    public String getAffiliation() {
        return affiliation;
    }

    public void setAffiliation(String affiliation) {
        this.affiliation = affiliation;
    }

    public String getSect() {
        return sect;
    }

    public void setSect(String sect) {
        this.sect = sect;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getAuspice() {
        return auspice;
    }

    public void setAuspice(String auspice) {
        this.auspice = auspice;
    }

    public String getTribe() {
        return tribe;
    }

    public void setTribe(String tribe) {
        this.tribe = tribe;
    }

    public String getPackName() {
        return packName;
    }

    public void setPackName(String packName) {
        this.packName = packName;
    }

    public String getPackTotem() {
        return packTotem;
    }

    public void setPackTotem(String packTotem) {
        this.packTotem = packTotem;
    }

    public String getPrimaryVirtue() {
        return primaryVirtue;
    }

    public void setPrimaryVirtue(String primaryVirtue) {
        this.primaryVirtue = primaryVirtue;
    }

    public String getCreed() {
        return creed;
    }

    public void setCreed(String creed) {
        this.creed = creed;
    }

    public String getStartingConviction() {
        return startingConviction;
    }

    public void setStartingConviction(String startingConviction) {
        this.startingConviction = startingConviction;
    }

    public boolean isVampire() {
        return isVampire;
    }

    public void setVampire(boolean vampire) {
        isVampire = vampire;
    }

    public boolean isMage() {
        return isMage;
    }

    public void setMage(boolean mage) {
        isMage = mage;
    }

    public boolean isWereWolf() {
        return isWereWolf;
    }

    public void setWereWolf(boolean wereWolf) {
        isWereWolf = wereWolf;
    }

    public boolean isHunter() {
        return isHunter;
    }

    public void setHunter(boolean hunter) {
        isHunter = hunter;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
