package logic;

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
	public void setGrader(double grader) {
		this.grader = grader;
	}
}
