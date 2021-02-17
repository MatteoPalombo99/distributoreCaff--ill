
package distributorecaffè;

import jdk.jfr.Event;


public interface State {
    
    void next(Event e);
}
