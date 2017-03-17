package logic;

import exceptions.NegativArealException;

public interface Areal {
	public double getMm2();
	
	public void setMm2(double mm2) throws NegativArealException;
	

}
