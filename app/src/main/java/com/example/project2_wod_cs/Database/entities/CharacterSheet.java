package com.example.project2_wod_cs.Database.entities;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.example.project2_wod_cs.Database.AppDatabase;

@Entity(tableName = AppDatabase.CHARACTER_SHEET_TABLE)
public class CharacterSheet {
    @PrimaryKey(autoGenerate = true)
    private int id;

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
