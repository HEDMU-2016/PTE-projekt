package exceptions;

public class NegativKgException extends Exception{
	
	private static final long serialVersionUID = -8025225322443942548L;
	public static String exceptionMessage;
	
	private static NegativKgException negativKgException;
	
	
	public static void Instantiate(String message){
		exceptionMessage = message;
		new NegativKgException(message);
	}
	
	private NegativKgException(String exceptionMessage){
		System.out.println(exceptionMessage);
		negativKgException.printStackTrace();
	}
}
