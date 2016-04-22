package eg.edu.guc.yugioh.exceptions;

@SuppressWarnings("serial")
public class MonsterMultipleAttackException extends RuntimeException {

	public MonsterMultipleAttackException() {
		super("Can't attack more than once in the same turn using the same monster");
	}

	public MonsterMultipleAttackException(String message) {
		super("Can't attack more than once in the same turn using the same monster");
	}

}
