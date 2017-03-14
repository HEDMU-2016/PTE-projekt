package logic;

import exceptions.erUnderFejlgraenseException;

public class VinkelImpl implements Vinkel {

	private double grader;
	private boolean erMaaltTilLodret;
	private double graderMaaltTilLodret;
	private double graderMaaltTilVandret;
	private String mellemregning;

	@Override
	public double getGrader() {
		if (getMaaltTilLodret()) {
			graderMaaltTilLodret = grader;
			graderMaaltTilVandret = 90 - grader;

			return graderMaaltTilLodret;
		} else {
			graderMaaltTilVandret = grader;
			graderMaaltTilLodret = 90 - grader;

			return graderMaaltTilVandret;
		}
	}

	@Override
	public boolean getMaaltTilLodret() {
		return erMaaltTilLodret;
	}
	@Override
	public void setMaaltTilLodret(boolean erMaaltTilLodret) {
		this.erMaaltTilLodret = erMaaltTilLodret;
	}

	@Override
	public void setGrader(double grader)throws erUnderFejlgraenseException {
		if (grader<0) 
			throw new erUnderFejlgraenseException();
//		else if (0<this.grader && this.grader>90) 
			this.grader = grader;
	}
}
