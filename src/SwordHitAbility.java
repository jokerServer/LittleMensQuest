
public class SwordHitAbility extends Ability {

	public SwordHitAbility(Equipment weapon) {
		super(0, "SwordHit", weapon);
	}

	@Override
	public boolean cast(Entity target) {
		target.getDamaged(50);
		return true;
	}

}
