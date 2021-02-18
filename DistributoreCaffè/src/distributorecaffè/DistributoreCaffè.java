package distributorecaffè;

public class DistributoreCaffè {

    public static void main(String[] args) {
        AutomaDistributore ad = new AutomaDistributore();
        ad.next(new Soldi(0.2));
        ad.next(new Soldi(0.1));
        ad.next(new Caffè());
        ad.next(new Soldi(0.2));
        ad.next(new Caffè());
        ad.next(new CaffèPronto());
        ad.next(new Ritiro());
        ad.next(new Resto());
        ad.next(new Resto());
    }
}
