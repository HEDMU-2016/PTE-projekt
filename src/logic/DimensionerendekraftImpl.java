package logic;

public class DimensionerendekraftImpl implements Dimensionerendekraft {

	private double kg;
	private double newton;
	private String mellemRegning;

	@Override
	public double setNewton(double newton) {
		// TODO Auto-generated method stub
		return 0;
	}

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
