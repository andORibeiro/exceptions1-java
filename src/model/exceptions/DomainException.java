package model.exceptions;

public class DomainException extends Exception{ 
	//Mantendo como Exception para que o tratamento seja obrigat�rio
	private static final long serialVersionUID = 1L;
	
	public DomainException(String msg) {
		super(msg);
	}

}
