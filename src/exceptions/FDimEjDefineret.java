package exceptions;

public class FDimEjDefineret extends Exception {
	
	private static final long serialVersionUID = -2013108770500826122L;

	public static String exceptionMessage;
	
	private static FDimEjDefineret fDimEjDefineret;
	
	
	public static void Instantiate(String message){
		exceptionMessage = message;
		new FDimEjDefineret(message);
	}
	
	private FDimEjDefineret(String exceptionMessage){
		System.out.println(exceptionMessage);
		fDimEjDefineret.printStackTrace();
	}
}
