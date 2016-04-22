package eg.edu.guc.yugioh.exceptions;

@SuppressWarnings("serial")
public class MultipleMonsterAdditionException extends RuntimeException {

	public MultipleMonsterAdditionException() {
		super("you are allowed to add only one monster to the field in any mode per turn");
	}

	public MultipleMonsterAdditionException(String message) {
		super("you are allowed to add only one monster to the field in any mode per turn");
	}

}
