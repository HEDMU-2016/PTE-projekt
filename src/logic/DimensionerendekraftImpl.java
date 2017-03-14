package logic;

public class DimensionerendekraftImpl implements Dimensionerendekraft {

	double kg;
	double newton;
	String mellemRegning;

	public double getNewton() {
		return kg * tyngdekraft;
	}

	@Override
	public void setKg(double kg) {
		this.kg = kg;
		newton = kg * tyngdekraft;
		setMellemRegning("FDim = kg * g +" +"\n" + getNewton() + "=" + getKg() + "*" + tyngdekraft);
	}

	@Override
	public double getKg() {
		return kg;
	}

	@Override
	public void setMellemRegning(String mellemRegning) {
		this.mellemRegning = mellemRegning;
	}

	@Override
	public String getMellemRegning() {
		return mellemRegning;
	}

}
