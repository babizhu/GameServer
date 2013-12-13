package org.bbz.game.cfg.fighter;

import org.jdom2.Element;

/**
 * 模版
 * @author liukun
 * 2013-12-11 17:28:32
 */
public class NpcTemplet {

    /**
	 * id
	 */
    private final int id;



	/**
	 * id
	 */
	public int getId() {
		return id;
	}/**
	 * 名称
	 */
    private final String name;



	/**
	 * 名称
	 */
	public String getName() {
		return name;
	}/**
	 * 描述
	 */
    private final String desc;



	/**
	 * 描述
	 */
	public String getDesc() {
		return desc;
	}/**
	 * 生命基础值
	 */
    private final int hpBase;



	/**
	 * 生命基础值
	 */
	public int getHpBase() {
		return hpBase;
	}/**
	 * 物攻
	 */
    private final int phyAttackBase;



	/**
	 * 物攻
	 */
	public int getPhyAttackBase() {
		return phyAttackBase;
	}/**
	 * 物防
	 */
    private final int phyDefendBase;



	/**
	 * 物防
	 */
	public int getPhyDefendBase() {
		return phyDefendBase;
	}/**
	 * 魔攻
	 */
    private final int magicAttackBase;



	/**
	 * 魔攻
	 */
	public int getMagicAttackBase() {
		return magicAttackBase;
	}/**
	 * 魔防
	 */
    private final int magicDefendBase;



	/**
	 * 魔防
	 */
	public int getMagicDefendBase() {
		return magicDefendBase;
	}/**
	 * 速度
	 */
    private final int speed;



	/**
	 * 速度
	 */
	public int getSpeed() {
		return speed;
	}/**
	 * 躲避
	 */
    private final int dodge;



	/**
	 * 躲避
	 */
	public int getDodge() {
		return dodge;
	}/**
	 * 暴击
	 */
    private final int crit;



	/**
	 * 暴击
	 */
	public int getCrit() {
		return crit;
	}/**
	 * 暴击倍数
	 */
    private final int critMultiple;



	/**
	 * 暴击倍数
	 */
	public int getCritMultiple() {
		return critMultiple;
	}/**
	 * 技能
	 */
    private final int skillTempletId;



	/**
	 * 技能
	 */
	public int getSkillTempletId() {
		return skillTempletId;
	}/**
	 * 掉落物品
	 */
    private final String dropItem;



	/**
	 * 掉落物品
	 */
	public String getDropItem() {
		return dropItem;
	}

	public NpcTemplet( Element element ) {
		id = Integer.parseInt( element.getChildText("id").trim() );
name = element.getChildText("name").trim();
desc = element.getChildText("desc").trim();
hpBase = Integer.parseInt( element.getChildText("hpBase").trim() );
phyAttackBase = Integer.parseInt( element.getChildText("phyAttackBase").trim() );
phyDefendBase = Integer.parseInt( element.getChildText("phyDefendBase").trim() );
magicAttackBase = Integer.parseInt( element.getChildText("magicAttackBase").trim() );
magicDefendBase = Integer.parseInt( element.getChildText("magicDefendBase").trim() );
speed = Integer.parseInt( element.getChildText("speed").trim() );
dodge = Integer.parseInt( element.getChildText("dodge").trim() );
crit = Integer.parseInt( element.getChildText("crit").trim() );
critMultiple = Integer.parseInt( element.getChildText("critMultiple").trim() );
skillTempletId = Integer.parseInt( element.getChildText("skillTempletId").trim() );
dropItem = element.getChildText("dropItem").trim();

	}

	@Override
	public String toString() {
		return "NpcTemplet [id = " + id + ",name = " + name + ",desc = " + desc + ",hpBase = " + hpBase + ",phyAttackBase = " + phyAttackBase + ",phyDefendBase = " + phyDefendBase + ",magicAttackBase = " + magicAttackBase + ",magicDefendBase = " + magicDefendBase + ",speed = " + speed + ",dodge = " + dodge + ",crit = " + crit + ",critMultiple = " + critMultiple + ",skillTempletId = " + skillTempletId + ",dropItem = " + dropItem + "]";
	}

	/*自定义代码开始*//*自定义代码结束*/
}
