package cluedo.logic.cards.parser;

import cluedo.logic.cards.Card;
import cluedo.tools.languagestring.LanguageStrings;
import cluedo.tools.languagestring.Language;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;

import java.util.Objects;

/**
 *
 * @author Szaya
 */
public class CardTest {
	public static final String testName = "testName";
	public static final String testImage = "testImage";
	public static final String testUiStringKey = "TestNameForUI";
	public static final String TestNameForUI_eng = "TestNameForUI_eng";
	public static final String TestNameForUI_hun = "TestNameForUI_hun";
	
    @Test
    public void ConstructTest () {
		Card cardWeapon = new Card (testName, testImage, testUiStringKey, Card.Type.WEAPON);
		assertNotNull (cardWeapon);
		Card cardPerson = new Card (testName, testImage, testUiStringKey, Card.Type.PERSON);
		assertNotNull (cardPerson);
		Card cardRoom = new Card (testName, testImage, testUiStringKey, Card.Type.ROOM);
		assertNotNull (cardRoom);
	}
	
    @Test
    public void ConstructWithGivenBadArgumentTest () {
		final String nullErrorMessage = "The Card class can cunstructed with given null param.";
		try {
			Card card = new Card (null, testImage, testUiStringKey, Card.Type.WEAPON);
			fail(nullErrorMessage);
		} catch (IllegalArgumentException e) { }
		try {
			Card card = new Card (testName, null, testUiStringKey, Card.Type.WEAPON);
			fail(nullErrorMessage);
		} catch (IllegalArgumentException e) { }
		try {
			Card card = new Card (testName, testImage, null, Card.Type.WEAPON);
			fail(nullErrorMessage);
		} catch (IllegalArgumentException e) { }
		try {
			Card card = new Card (testName, testImage, testUiStringKey, null);
			fail(nullErrorMessage);
		} catch (IllegalArgumentException e) { }
		
		
		final String badErrorMessage = "The Card class can cunstructed with given bad param.";
		try {
			Card card = new Card ("", testImage, testUiStringKey, Card.Type.WEAPON);
			fail(nullErrorMessage);
		} catch (IllegalArgumentException e) { }
		try {
			Card card = new Card (testName, "", testUiStringKey, Card.Type.WEAPON);
			fail(nullErrorMessage);
		} catch (IllegalArgumentException e) { }
		try {
			Card card = new Card (testName, testImage, "", Card.Type.WEAPON);
			fail(nullErrorMessage);
		} catch (IllegalArgumentException e) { }
		try {
			Card card = new Card (testName, testImage, testUiStringKey, Card.Type.UNKNOWN);
			fail(nullErrorMessage);
		} catch (IllegalArgumentException e) { }
	}

	@Test
	public void GeterTest () {
		Card card = new Card (testName, testImage, testUiStringKey, Card.Type.WEAPON);
		assertNotNull (card);
		
		assertEquals (testName, card.getName());
		assertEquals (testImage, card.getImageName());
		assertEquals (testImage, card.getImageName());
		assertEquals (testUiStringKey, card.getUiStringKey());
		assertEquals (TestNameForUI_eng, card.getNameForUI());
		
		final String str =  "Type : WEAPON, " +
							"Name : " + testName + ", " +
							"Image : " + testImage + ", " +
							"UIKey : " + testUiStringKey + ", " + 
							"UIString : " + TestNameForUI_eng;
							
		assertEquals (str, card.toString());
	}

	@Test 
	public void EqualsTest () {
		Card cardWeapon = new Card (testName, testImage, testUiStringKey, Card.Type.WEAPON);
		assertNotNull (cardWeapon);
		Card cardWeapon_2 = new Card (testName, testImage, testUiStringKey, Card.Type.WEAPON);
		assertNotNull (cardWeapon_2);
		
		assertTrue (cardWeapon.equals (cardWeapon_2));
		assertTrue (cardWeapon.equals (cardWeapon));
		
		assertFalse (cardWeapon.equals (null));
		assertFalse (cardWeapon.equals (new String("wrong object class")));
		
		
		Card cardPerson = new Card (testName, testImage, testUiStringKey, Card.Type.PERSON);
		assertNotNull (cardPerson);
		
		assertFalse (cardWeapon.equals (cardPerson));
	}

	@Test 
	public void HashCodeTest () {
		Card card = new Card (testName, testImage, testUiStringKey, Card.Type.WEAPON);
		assertNotNull (card);
		
        assertEquals (Objects.hash(Card.Type.WEAPON, testName), card.hashCode());
    }
	
	@Test 
	public void CloneTest () {
		Card card = new Card (testName, testImage, testUiStringKey, Card.Type.WEAPON);
		assertNotNull (card);
		
		Object obj = card.cloneObject ();
		assertNotNull (obj);
		assertTrue (obj.getClass() == Card.class);
        Card cloneCard=(Card)obj;
		
		assertTrue (card.equals (cloneCard));
    }
	
}