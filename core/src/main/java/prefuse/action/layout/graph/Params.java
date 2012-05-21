package prefuse.action.layout.graph;

import prefuse.visual.NodeItem;

/**
 * Wrapper class holding parameters used for each node in this layout.
 * Moved out of NodeLinkTreeLayout because of access issues/interoperability
 * with Scala.
 * 
 * @author <a href="http://jheer.org">jeffrey heer</a>
 */
public class Params implements Cloneable {
    public double prelim;
    public double mod;
    public double shift;
    public double change;
    public int    number = -2;
    public NodeItem ancestor = null;
    public NodeItem thread = null;
    
    public void init(NodeItem item) {
        ancestor = item;
        number = -1;
    }
    
    public void clear() {
        number = -2;
        prelim = mod = shift = change = 0;
        ancestor = thread = null;
    }
}