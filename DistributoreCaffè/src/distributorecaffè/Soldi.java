package distributorecaffè;

public class Soldi implements Event {

    private final double soldi;

    public Soldi(double soldi) {
        this.soldi = soldi;
    }

    public double getSoldi() {
        return soldi;
    }

}
