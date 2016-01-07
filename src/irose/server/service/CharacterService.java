package irose.server.service;

import irose.entity.Character;
import irose.entity.CharacterSkill;
import irose.entity.CharacterType;
import irose.entity.Summon;

public class CharacterService
{
	public boolean isSkillApplicable(CharacterSkill skill, Character sourceCharacter, Character targetCharacter)
	{
		boolean isEnemy = false;
		
		for(CharacterType enemyCharacterType : sourceCharacter.getAttackableBy())
		{
			if(enemyCharacterType == targetCharacter.getType())
			{
				if(targetCharacter.getType() == CharacterType.SUMMON && targetCharacter instanceof Summon)
				{
					if(!((Summon) targetCharacter).getPlayer().getId().equals(sourceCharacter.getId()))
					{
						isEnemy = true;
					}
				}
				else
				{
					isEnemy = true;
				}
			}
		}
		
		switch(skill.getCategory())
		{
			case CRAFT:
			{
				return false;
			}
			case OFFENSIVE:
			case CURSE:
			{
				return isEnemy;
			}
			case BLESS:
			{
				return !isEnemy;
			}
			default:
			{
				return false;
			}
		}
	}
}
