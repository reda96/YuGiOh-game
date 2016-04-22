package eg.edu.guc.yugioh.board.player;

import eg.edu.guc.yugioh.cards.Card;
import eg.edu.guc.yugioh.cards.Location;
import eg.edu.guc.yugioh.cards.MonsterCard;
import eg.edu.guc.yugioh.cards.spells.CardDestruction;
import eg.edu.guc.yugioh.cards.spells.ChangeOfHeart;
import eg.edu.guc.yugioh.cards.spells.DarkHole;
import eg.edu.guc.yugioh.cards.spells.GracefulDice;
import eg.edu.guc.yugioh.cards.spells.HarpieFeatherDuster;
import eg.edu.guc.yugioh.cards.spells.HeavyStorm;
import eg.edu.guc.yugioh.cards.spells.MagePower;
import eg.edu.guc.yugioh.cards.spells.MonsterReborn;
import eg.edu.guc.yugioh.cards.spells.PotOfGreed;
import eg.edu.guc.yugioh.cards.spells.Raigeki;
import eg.edu.guc.yugioh.cards.spells.SpellCard;
import eg.edu.guc.yugioh.exceptions.EmptyFieldException;
import eg.edu.guc.yugioh.exceptions.MissingFieldException;
import eg.edu.guc.yugioh.exceptions.UnexpectedFormatException;
import eg.edu.guc.yugioh.exceptions.UnknownCardTypeException;
import eg.edu.guc.yugioh.exceptions.UnknownSpellCardException;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class Deck {

	private static ArrayList<Card> monsters;
	private static ArrayList<Card> spells;

	private static String monstersPath = "Database-Monsters.csv";
	private static String spellsPath = "Database-Spells.csv";

	private final ArrayList<Card> deck;
	int trials = 0;
	private static int player= 1;

	private void buildYugiDeck()
	{
	/** Cards in Deck
		Big Shield Gardna
		Baby Dragon
		Dark Magician Girl
		Pot of Greed
		Dark Hole
		Alexandrite Dragon
		Change Of Heart
		Kuriboh
		Mage Power
		Card Destruction
		Dark Magician
		Gaia The Fierce Knight
		Curse Of Dragon
		Kuriboh
		Dark Magician
		Alpha The Magnet Warrior
		Beta The Magnet Warrior
		Gamma The Magnet Warrior
		Kuriboh
		Baby Dragon
		**/
		
		addMonsterToDeck("Big Shield Gardna");
		addMonsterToDeck("Baby Dragon");
		addMonsterToDeck("Dark Magician Girl");
		addSpellToDeck("Pot of Greed");
		addSpellToDeck("Dark Hole");
		addMonsterToDeck("Alexandrite Dragon");
		addSpellToDeck("Change Of Heart");
		addMonsterToDeck("Kuriboh");
		addSpellToDeck("Mage Power");
		addSpellToDeck("Card Destruction");
		addMonsterToDeck("Dark Magician");
		addMonsterToDeck("Gaia The Fierce Knight");
		addMonsterToDeck("Curse Of Dragon");
		addMonsterToDeck("Kuriboh");
		addMonsterToDeck("Dark Magician");
		addMonsterToDeck("Alpha The Magnet Warrior");
		addMonsterToDeck("Beta The Magnet Warrior");
		addMonsterToDeck("Gamma The Magnet Warrior");
		addMonsterToDeck("Kuriboh");
		addMonsterToDeck("Baby Dragon");
	}
	
	private void buildKaibaDeck()
	{
	/** Cards in Deck
		Pot of Greed
		Vorse Raider
		Witty Phantom
		Vorse Raider
		Mokey Mokey
		Vorse Raider
		Mokey Mokey
		Witty Phantom
		Blue-Eyes White Dragon
		Cyber Jar
		Witty Phantom
		Pot of Greed
		Pot of Greed
		Pot of Greed
		Cyber Jar
		Blue-Eyes White Dragon
		Cyber Jar
		Blue-Eyes White Dragon
		Baby Dragon
		Pot of Greed
		**/
		
		addSpellToDeck("Pot of Greed");
		addMonsterToDeck("Vorse Raider");
		addMonsterToDeck("Witty Phantom");
		addMonsterToDeck("Vorse Raider");
		addMonsterToDeck("Mokey Mokey");
		addMonsterToDeck("Vorse Raider");
		addMonsterToDeck("Mokey Mokey");
		addMonsterToDeck("Witty Phantom");
		addMonsterToDeck("Blue-Eyes White Dragon");
		addMonsterToDeck("Cyber Jar");
		addMonsterToDeck("Witty Phantom");
		addSpellToDeck("Pot of Greed");
		addSpellToDeck("Pot of Greed");
		addSpellToDeck("Pot of Greed");
		addMonsterToDeck("Cyber Jar");
		addMonsterToDeck("Blue-Eyes White Dragon");
		addMonsterToDeck("Cyber Jar");
		addMonsterToDeck("Blue-Eyes White Dragon");
		addMonsterToDeck("Baby Dragon");
		addSpellToDeck("Pot of Greed");
	}
	
	private void addMonsterToDeck(String s)
	{
		Card c = getMonsterByName(s);
		MonsterCard m = (MonsterCard) c;
		MonsterCard n = new MonsterCard(m.getName(), m.getDescription(),
				m.getLevel(), m.getAttackPoints(), m.getDefensePoints());
		n.setMode(m.getMode());
		n.setHidden(m.isHidden());
		n.setLocation(Location.DECK);
		deck.add(n);
	}
	
	private void addSpellToDeck(String s)
	{
		Card temp = getSpellByName(s);
		SpellCard clone;
		switch (temp.getName()) {

		case "Card Destruction":
			clone = new CardDestruction(temp.getName(),
					temp.getDescription());
			clone.setLocation(Location.DECK);
			deck.add(clone);
			break;
		case "Change Of Heart":
			clone = new ChangeOfHeart(temp.getName(), temp.getDescription());
			clone.setLocation(Location.DECK);
			deck.add(clone);
			break;
		case "Dark Hole":
			clone = new DarkHole(temp.getName(), temp.getDescription());
			clone.setLocation(Location.DECK);
			deck.add(clone);
			break;
		case "Graceful Dice":
			clone = new GracefulDice(temp.getName(), temp.getDescription());
			clone.setLocation(Location.DECK);
			deck.add(clone);
			break;
		case "Harpie's Feather Duster":
			clone = new HarpieFeatherDuster(temp.getName(),
					temp.getDescription());
			clone.setLocation(Location.DECK);
			deck.add(clone);
			break;
		case "Heavy Storm":
			clone = new HeavyStorm(temp.getName(), temp.getDescription());
			clone.setLocation(Location.DECK);
			deck.add(clone);
			break;
		case "Mage Power":
			clone = new MagePower(temp.getName(), temp.getDescription());
			clone.setLocation(Location.DECK);
			deck.add(clone);
			break;
		case "Monster Reborn":
			clone = new MonsterReborn(temp.getName(), temp.getDescription());
			clone.setLocation(Location.DECK);
			deck.add(clone);
			break;
		case "Pot of Greed":
			clone = new PotOfGreed(temp.getName(), temp.getDescription());
			clone.setLocation(Location.DECK);
			deck.add(clone);
			break;
		case "Raigeki":
			clone = new Raigeki(temp.getName(), temp.getDescription());
			clone.setLocation(Location.DECK);
			deck.add(clone);
			break;

		}
	}
	
	
	private Card getMonsterByName(String s)
	{
		for(Card c : monsters)
		{
			if (c.getName().equals(s))
			{
				return c;
			}
		}
		
		throw new NullPointerException("No Such Monster " + s);
	}
	
	private Card getSpellByName(String s)
	{
		for(Card c : spells)
		{
			if (c.getName().equals(s))
			{
				return c;
			}
		}
		
		throw new NullPointerException("No Such Spell " + s);
	}

	public Deck() throws IOException, NumberFormatException,
			UnexpectedFormatException {

		if ((monsters == null) || (spells == null)) {

			Scanner sc = new Scanner(System.in);

			while (true) {

				try {

					monsters = loadCardsFromFile(Deck.getMonstersPath());
					spells = loadCardsFromFile(Deck.getSpellsPath());
					break;

				} catch (UnexpectedFormatException e) {

					if (trials >= 3) {
						sc.close();
						throw e;
					}

					System.out.println("Error in reading from file "
							+ e.getSourceFile() + " at line "
							+ e.getSourceLine());
					System.out.println(e.getMessage());
					System.out.println("Please enter another path:");

					trials++;

					if (e.getSourceFile().equalsIgnoreCase(
							Deck.getMonstersPath())) {
						Deck.setMonstersPath(sc.nextLine());
					}
					if (e.getSourceFile()
							.equalsIgnoreCase(Deck.getSpellsPath())) {
						Deck.setSpellsPath(sc.nextLine());
					}

				} catch (FileNotFoundException e) {

					if (trials >= 3) {
						sc.close();
						throw e;
					}

					String s = (monsters == null) ? Deck.getMonstersPath()
							: Deck.getSpellsPath();

					System.out.println("The file \"" + s + "\" is not found.");
					System.out.println("Please enter another path:");

					trials++;
					String path = sc.nextLine();

					if (monsters == null)
						Deck.setMonstersPath(path);
					else
						Deck.setSpellsPath(path);

				}

			}

			sc.close();

		}

		deck = new ArrayList<Card>();
		if(player == 1)
		{
			buildYugiDeck();
			player++;
		}
		else
		{
			buildKaibaDeck();
		}

	}

	public ArrayList<Card> loadCardsFromFile(String path) throws IOException,
			UnexpectedFormatException {

		ArrayList<Card> temp = new ArrayList<Card>();

		String line;

		BufferedReader br = new BufferedReader(new FileReader(path));

		int lineNumber = 0;

		while ((line = br.readLine()) != null) {

			lineNumber++;

			String[] cardInfo = line.split(",");

			if (cardInfo.length == 0) {

				br.close();
				throw new MissingFieldException(
						"The number of fields in the line did not match the expected.",
						path, lineNumber);

			} else {

				if (cardInfo[0].equalsIgnoreCase("Monster")
						&& cardInfo.length != 6) {

					br.close();
					throw new MissingFieldException(
							"The number of fields in the line did not match the expected.",
							path, lineNumber);

				} else if (cardInfo[0].equalsIgnoreCase("Spell")
						&& cardInfo.length != 3) {

					br.close();
					throw new MissingFieldException(
							"The number of fields in the line did not match the expected.",
							path, lineNumber);

				}

			}

			for (int i = 0; i < cardInfo.length; i++)
				if (cardInfo[i].equals("") || cardInfo[i].equals(" ")) {

					br.close();
					throw new EmptyFieldException("Empty Field.", path,
							lineNumber, i + 1);

				}

			if (cardInfo[0].equalsIgnoreCase("Monster")) {

				temp.add(new MonsterCard(cardInfo[1], cardInfo[2], Integer
						.parseInt(cardInfo[5]), Integer.parseInt(cardInfo[3]),
						Integer.parseInt(cardInfo[4])));

			} else {

				if (!cardInfo[0].equalsIgnoreCase("Spell")) {

					br.close();
					throw new UnknownCardTypeException("Unknown Card type.",
							path, lineNumber, cardInfo[0]);

				}

				switch (cardInfo[1]) {

				case "Card Destruction":
					temp.add(new CardDestruction(cardInfo[1], cardInfo[2]));
					break;
				case "Change Of Heart":
					temp.add(new ChangeOfHeart(cardInfo[1], cardInfo[2]));
					break;
				case "Dark Hole":
					temp.add(new DarkHole(cardInfo[1], cardInfo[2]));
					break;
				case "Graceful Dice":
					temp.add(new GracefulDice(cardInfo[1], cardInfo[2]));
					break;
				case "Harpie's Feather Duster":
					temp.add(new HarpieFeatherDuster(cardInfo[1], cardInfo[2]));
					break;
				case "Heavy Storm":
					temp.add(new HeavyStorm(cardInfo[1], cardInfo[2]));
					break;
				case "Mage Power":
					temp.add(new MagePower(cardInfo[1], cardInfo[2]));
					break;
				case "Monster Reborn":
					temp.add(new MonsterReborn(cardInfo[1], cardInfo[2]));
					break;
				case "Pot of Greed":
					temp.add(new PotOfGreed(cardInfo[1], cardInfo[2]));
					break;
				case "Raigeki":
					temp.add(new Raigeki(cardInfo[1], cardInfo[2]));
					break;
				default:
					throw new UnknownSpellCardException("Unknown Spell card",
							path, lineNumber, cardInfo[1]);

				}

			}

		}

		br.close();

		return (temp);

	}

	private void buildDeck(ArrayList<Card> Monsters, ArrayList<Card> Spells) {

		int monstersQouta = 15;
		int spellsQouta = 5;

		Random r = new Random();

		for (; monstersQouta > 0; monstersQouta--) {

			MonsterCard monster = (MonsterCard) monsters.get(r.nextInt(monsters
					.size()));

			MonsterCard clone = new MonsterCard(monster.getName(),
					monster.getDescription(), monster.getLevel(),
					monster.getAttackPoints(), monster.getDefensePoints());
			clone.setMode(monster.getMode());
			clone.setHidden(monster.isHidden());
			clone.setLocation(Location.DECK);

			deck.add(clone);

		}

		for (; spellsQouta > 0; spellsQouta--) {

			Card spell = spells.get(r.nextInt(spells.size()));

			SpellCard clone;

			if (spell instanceof CardDestruction) {

				clone = new CardDestruction(spell.getName(),
						spell.getDescription());
				clone.setLocation(Location.DECK);
				deck.add(clone);
				continue;

			}

			if (spell instanceof ChangeOfHeart) {

				clone = new ChangeOfHeart(spell.getName(),
						spell.getDescription());
				clone.setLocation(Location.DECK);
				deck.add(clone);
				continue;

			}

			if (spell instanceof DarkHole) {

				clone = new DarkHole(spell.getName(), spell.getDescription());
				clone.setLocation(Location.DECK);
				deck.add(clone);
				continue;

			}

			if (spell instanceof GracefulDice) {

				clone = new GracefulDice(spell.getName(),
						spell.getDescription());
				clone.setLocation(Location.DECK);
				deck.add(clone);
				continue;

			}

			if (spell instanceof HarpieFeatherDuster) {

				clone = new HarpieFeatherDuster(spell.getName(),
						spell.getDescription());
				clone.setLocation(Location.DECK);
				deck.add(clone);
				continue;

			}

			if (spell instanceof HeavyStorm) {

				clone = new HeavyStorm(spell.getName(), spell.getDescription());
				clone.setLocation(Location.DECK);
				deck.add(clone);
				continue;

			}

			if (spell instanceof MagePower) {

				clone = new MagePower(spell.getName(), spell.getDescription());
				clone.setLocation(Location.DECK);
				deck.add(clone);
				continue;

			}

			if (spell instanceof MonsterReborn) {

				clone = new MonsterReborn(spell.getName(),
						spell.getDescription());
				clone.setLocation(Location.DECK);
				deck.add(clone);
				continue;

			}

			if (spell instanceof PotOfGreed) {

				clone = new PotOfGreed(spell.getName(), spell.getDescription());
				clone.setLocation(Location.DECK);
				deck.add(clone);
				continue;

			}

			if (spell instanceof Raigeki) {

				clone = new Raigeki(spell.getName(), spell.getDescription());
				clone.setLocation(Location.DECK);
				deck.add(clone);
				continue;

			}

		}

	}

	private void shuffleDeck() {

		Collections.shuffle(deck);

	}

	public ArrayList<Card> drawNCards(int n) {

		ArrayList<Card> cards = new ArrayList<Card>(n);

		for (int i = 0; i < n; i++)
			cards.add(deck.remove(0));

		return (cards);

	}

	public Card drawOneCard() {

		return (deck.remove(0));

	}

	public static ArrayList<Card> getMonsters() {
		return monsters;
	}

	public static void setMonsters(ArrayList<Card> monsters) {
		Deck.monsters = monsters;
	}

	public static ArrayList<Card> getSpells() {
		return spells;
	}

	public static void setSpells(ArrayList<Card> spells) {
		Deck.spells = spells;
	}

	public ArrayList<Card> getDeck() {
		return deck;
	}

	public static String getMonstersPath() {
		return monstersPath;
	}

	public static void setMonstersPath(String monstersPath) {
		Deck.monstersPath = monstersPath;
	}

	public static String getSpellsPath() {
		return spellsPath;
	}

	public static void setSpellsPath(String spellsPath) {
		Deck.spellsPath = spellsPath;
	}

}
