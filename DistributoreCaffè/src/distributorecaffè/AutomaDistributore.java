package distributorecaffè;

import jdk.jfr.Event;

public class AutomaDistributore implements State {

    private State stato;
    float tot = 0.45f;

    public AutomaDistributore() {
        stato = new Attesa();
    }

    @Override
    public void next(Event e) {
        stato.next(e);
    }

    private class Attesa implements State {

        @Override
        public void next(Event e) {

            if (e instanceof Caffè) {
                if (tot < 0.45f) {
                    stato = new Attesa();
                    System.out.println("Inserire almeno € 0.45");
                } else if (tot > 0.45f) {
                    stato = new Erogazione();
                }

            } else {
                System.out.println("Errore");
            }
        }

    }

    private class Erogazione implements State {

        @Override
        public void next(Event e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        private class Pronto implements State {

            @Override
            public void next(Event e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

        }
    }
}
