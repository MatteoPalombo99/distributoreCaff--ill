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
        stato.next(e);
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
                    tot= tot - 0.45f;
                }
            } else if (e instanceof Resto) {
                if (tot > 0) {
                    stato = new Attesa();
                    System.out.println(tot);
                    tot = 0f;
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

        }

        private class Pronto implements State {

            @Override
            public void next(Event e) {

            }

        }
    }
}
