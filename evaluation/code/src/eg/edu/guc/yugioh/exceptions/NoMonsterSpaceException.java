package eg.edu.guc.yugioh.exceptions;

@SuppressWarnings("serial")
public class NoMonsterSpaceException extends NoSpaceException {

	public NoMonsterSpaceException() {
		super("no space for more monsters in the field");
	}

	public NoMonsterSpaceException(String arg0) {
		super("no space for more monsters in the field");
	}

}
