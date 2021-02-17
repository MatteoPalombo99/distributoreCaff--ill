package distributorecaffè;

import jdk.jfr.Event;

public class AutomaDistributore implements State {

    private State stato;

    public AutomaDistributore() {
    }

    @Override
    public void next(Event e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private class Attesa implements State {

        @Override
        public void next(Event e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
