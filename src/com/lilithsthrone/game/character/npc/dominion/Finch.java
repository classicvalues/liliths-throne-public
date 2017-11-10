package com.lilithsthrone.game.character.npc.dominion;

import com.lilithsthrone.game.character.NameTriplet;
import com.lilithsthrone.game.character.SexualOrientation;
import com.lilithsthrone.game.character.body.Covering;
import com.lilithsthrone.game.character.body.types.BodyCoveringType;
import com.lilithsthrone.game.character.body.valueEnums.PenisSize;
import com.lilithsthrone.game.character.body.valueEnums.TesticleSize;
import com.lilithsthrone.game.character.effects.Fetish;
import com.lilithsthrone.game.character.gender.Gender;
import com.lilithsthrone.game.character.npc.NPC;
import com.lilithsthrone.game.character.race.RaceStage;
import com.lilithsthrone.game.character.race.RacialBody;
import com.lilithsthrone.game.combat.Attack;
import com.lilithsthrone.game.dialogue.DialogueNodeOld;
import com.lilithsthrone.game.dialogue.responses.Response;
import com.lilithsthrone.game.inventory.AbstractCoreItem;
import com.lilithsthrone.game.inventory.CharacterInventory;
import com.lilithsthrone.game.inventory.clothing.AbstractClothing;
import com.lilithsthrone.game.inventory.clothing.AbstractClothingType;
import com.lilithsthrone.game.inventory.clothing.ClothingSet;
import com.lilithsthrone.game.inventory.clothing.ClothingType;
import com.lilithsthrone.utils.Colour;
import com.lilithsthrone.world.WorldType;
import com.lilithsthrone.world.places.SlaverAlley;

/**
 * @since 0.1.83
 * @version 0.1.89
 * @author Innoxia
 */
public class Finch extends NPC {

	private static final long serialVersionUID = 1L;

	private AbstractClothing groin = AbstractClothingType.generateClothing(ClothingType.GROIN_CROTCHLESS_BRIEFS, Colour.CLOTHING_BLACK, false),
			legs = AbstractClothingType.generateClothing(ClothingType.LEG_CROTCHLESS_CHAPS, Colour.CLOTHING_BLACK, false),
			torso = AbstractClothingType.generateClothing(ClothingType.TORSO_SHORT_SLEEVE_SHIRT, Colour.CLOTHING_BLACK, false),
			socks = AbstractClothingType.generateClothing(ClothingType.SOCK_SOCKS, Colour.CLOTHING_BLACK, false),
			shoes = AbstractClothingType.generateClothing(ClothingType.FOOT_WORK_BOOTS, Colour.CLOTHING_BLACK, false);
	
	public Finch() {
		super(new NameTriplet("Finch"),
				"Finch is the manager of Slaver Alley's 'Slave Administration' building."
						+ " Although he acts friendly enough, you can't help but wonder if his disarming disposition is just for show."
						+ " After all, would the manager of Dominion's 'Slave Administration' really have got to that position just by being nice?",
				10,
				Gender.M_P_MALE,
				RacialBody.CAT_MORPH, RaceStage.PARTIAL_FULL, new CharacterInventory(10),
				WorldType.SLAVER_ALLEY, SlaverAlley.SLAVERY_ADMINISTRATION, true);

		this.setSexualOrientation(SexualOrientation.AMBIPHILIC);
		
		this.setEyeCovering(new Covering(BodyCoveringType.EYE_FELINE, Colour.EYE_GREEN));
		this.setHairCovering(new Covering(BodyCoveringType.HAIR_FELINE_FUR, Colour.COVERING_BLACK), true);
		this.setSkinCovering(new Covering(BodyCoveringType.FELINE_FUR, Colour.COVERING_BLACK), true);
		this.setSkinCovering(new Covering(BodyCoveringType.HUMAN, Colour.SKIN_LIGHT), true);
		
		this.setPenisSize(PenisSize.ONE_TINY.getMedianValue());
		this.setTesticleSize(TesticleSize.ONE_TINY.getValue());
		this.setFemininity(25);
		this.setPenisVirgin(false);
		
		this.addFetish(Fetish.FETISH_EXHIBITIONIST);
		this.addFetish(Fetish.FETISH_SADIST);
		this.addFetish(Fetish.FETISH_DEFLOWERING);

		this.setMoney(10);
		
		this.equipClothingFromNowhere(groin, true, this);
		this.equipClothingFromNowhere(legs, true, this);
		this.equipClothingFromNowhere(torso, true, this);
		this.equipClothingFromNowhere(socks, true, this);
		this.equipClothingFromNowhere(shoes, true, this);
		
		dailyReset();
	}

	@Override
	public boolean isUnique() {
		return true;
	}

	@Override
	public void dailyReset() {
		clearNonEquippedInventory();
		
		for(int i = 0; i<6; i++) {
			this.addClothing(AbstractClothingType.generateClothing(ClothingType.NECK_SLAVE_COLLAR), false);
		}
		
		for(AbstractClothingType clothing : ClothingType.getAllClothing()) {
			if(clothing.getClothingSet() == ClothingSet.BDSM) {
				for(int i = 0; i<2; i++) {
					this.addClothing(AbstractClothingType.generateClothing(clothing), false);
				}
			}
		}
	}
	
	@Override
	public void changeFurryLevel(){
	}
	
	@Override
	public DialogueNodeOld getEncounterDialogue() {
		return null;
	}

	@Override
	public String getTraderDescription() {
		return "<p>"
					+ "[finch.speech(Looking for the good stuff, huh?)] [finch.name] says, winking at you as he hands you a 'slaver-exclusive' sales brochure,"
					+ " [finch.speech(Let me know what you fancy!)]"
				+ "</p>";
	}

	@Override
	public boolean isTrader() {
		return true;
	}

	@Override
	public boolean willBuy(AbstractCoreItem item) {
		return item instanceof AbstractClothing;
	}

	@Override
	public void endSex(boolean applyEffects) {
	}

	// Combat:
	@Override
	public String getCombatDescription() {
		return null;// You never fight
	}

	@Override
	public String getAttackDescription(Attack attackType, boolean isHit) {
		return null; // You never fight
	}

	@Override
	public Response endCombat(boolean applyEffects, boolean victory) {
		return null; // You never fight
	}

	@Override
	public Attack attackType() {
		return null; // You never fight
	}

	@Override
	public int getExperienceFromVictory() {
		return 0;
	}

}