package distributorecaffè;

public class AutomaDistributore implements State {

    private State stato;
    float soldi = 0.50f;
    float tot;

    public AutomaDistributore() {
        stato = new Attesa();
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
                stato = new Attesa();
                tot += soldi;
            } else if (e instanceof Caffè) {
                if (tot < 0.45f) {
                    stato = new Attesa();
                    System.out.println("Soldi insufficienti");
                } else if (tot >= 0.45f) {
                    stato = new Erogazione();
                }
            } else if (e instanceof Resto) {
                if (tot > 0) {
                    stato = new Attesa();
                    System.out.println("Il resto è di " + tot + " euro");
                    tot = 0f;
                    System.out.println("Erogazione resto...");
                    System.out.println("Il resto è di " + tot + " euro");
                } else if (tot == 0) {
                    stato = new Attesa();
                }
            } else {
                System.out.println("Errore");
            }
        }

    }

    private class Erogazione implements State {

        @Override
        public void next(Event e) {
            if (e instanceof CaffèPronto) {
                tot = tot - 0.45f;
                stato = new Pronto();
            } else {
                System.out.println("Errore");
            }
        }
    }

    private class Pronto implements State {

        @Override
        public void next(Event e) {
            if (e instanceof Ritiro) {
                stato = new Attesa();
            } else {
                System.out.println("Errore");
            }
        }
    }
}
