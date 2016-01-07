package irose.server.service;

import irose.entity.Player;
import irose.entity.PlayerSkill;
import irose.entity.PlayerSkillRequeriment;
import irose.util.ListHelper;

public class PlayerService
{
	public boolean hasSkillRequeriment(Player player, PlayerSkill skill)
	{
		if(skill.getRequeriments().isEmpty())
		{
			return true;
		}
		else
		{
			for(PlayerSkillRequeriment requerimentSkill : skill.getRequeriments())
			{
				for(PlayerSkill playerSkill : player.getSkills())
				{
					if(playerSkill.getId().equals(requerimentSkill.getId()))
					{
						if(playerSkill.getLevel() >= requerimentSkill.getMinLevel() && player.getSkillPoints() >= skill.getSkillPoints() && skill.getLevel() < skill.getMaxLevel())
						{
							return true;
						}
					}
				}
			}
			
			return false;
		}
	}
	
	public boolean addSkill(Player player, PlayerSkill skill)
	{
		if(hasSkillRequeriment(player, skill))
		{
			player.setSp(player.getSkillPoints());
			player.getSkills().add(skill);
			
			// TODO save into db
			
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public boolean updateSkill(Player player, PlayerSkill skill)
	{
		if(player.getSkills().contains(skill))
		{
			skill = (PlayerSkill) ListHelper.get(player.getSkills(), skill);
			
			if(hasSkillRequeriment(player, skill))
			{
				skill.setLevel(skill.getLevel() + 1);
			}
		}
		
		// TODO save into db
		
		return false;
	}
}
