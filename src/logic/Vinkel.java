package logic;

import exceptions.erUnderFejlgraenseException;

public interface Vinkel {
	public double getGrader();

	public void setGrader(double grader) throws erUnderFejlgraenseException;

	public boolean getMaaltTilLodret();

	public void setMaaltTilLodret(boolean erMaaltTilLodret);

}
