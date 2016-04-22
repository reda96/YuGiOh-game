package eg.edu.guc.yugioh.exceptions;

@SuppressWarnings("serial")
public class WrongPhaseException extends RuntimeException {

	public WrongPhaseException() {
		super("Can't perform such action in this phase");
	}

	public WrongPhaseException(String message) {
		super("Can't perform such action in this phase");
	}

}
