package eg.edu.guc.yugioh.exceptions;

@SuppressWarnings("serial")
public class NoSpellSpaceException extends NoSpaceException {

	public NoSpellSpaceException() {
		super("no space for more spells in the field");
	}

	public NoSpellSpaceException(String arg0) {
		super("no space for more spells in the field");
	}

}
