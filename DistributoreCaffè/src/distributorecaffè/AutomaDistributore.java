package distributorecaffè;

public class AutomaDistributore implements State {

    private State stato;
    private double tot;

    public AutomaDistributore() {
        stato = new Attesa();
        tot = 0;
    }

    @Override
    public void next(Event e) {
        System.out.println("Siamo nello stato " + stato);
        System.out.println("Ricevuto evento " + e);
        stato.next(e);
        System.out.println("Siamo passati nello stato " + stato);
    }

    private class Attesa implements State {

        @Override
        public void next(Event e) {
            if (e instanceof Soldi) {
                //stato = new Attesa();
                tot += ((Soldi) e).getSoldi();
            } else if (e instanceof Caffè) {
                if (tot < 0.45) {
                    //stato = new Attesa();
                    System.out.println("Soldi insufficienti");
                } else {
                    stato = new Erogazione();
                }
            } else if (e instanceof Resto) {
                if (tot > 0) {
                    System.out.println("Il resto è di " + tot + " euro");
                    tot = 0;
                    System.out.println("Erogazione resto...");
                } else {
                    System.out.println("Nessun resto da dare.");
                }
            } else {
                System.out.println("Ricevuto evento inatteso.");
            }
        }

    }

    private class Erogazione implements State {

        @Override
        public void next(Event e) {
            if (e instanceof CaffèPronto) {
                tot -= 0.45;
                stato = new Pronto();
            } else {
                System.out.println("Ricevuto evento inatteso.");
            }
        }
    }

    private class Pronto implements State {

        @Override
        public void next(Event e) {
            if (e instanceof Ritiro) {
                stato = new Attesa();
            } else {
                System.out.println("Ricevuto evento inatteso");
            }
        }
    }
}
