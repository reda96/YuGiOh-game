package eg.edu.guc.yugioh.exceptions;

@SuppressWarnings("serial")
public class DefenseMonsterAttackException extends RuntimeException {

	public DefenseMonsterAttackException() {
		super("Can't attack with a monster in defense mode");
	}

	public DefenseMonsterAttackException(String message) {
		super("Can't attack with a monster in defense mode");
	}
	
	
}
