/**
 * Copyright (c) 2004-2006 Regents of the University of California.
 * See "license-prefuse.txt" for licensing terms.
 */
package prefuse.demos;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.lang.reflect.*;

/**
 * A simple wrapper for the demo applications.
 * 
 * @author Hanns Holger Rutz
 */
public class Demos implements Runnable {
	private static final Class[] clz = {
		AggregateDemo.class,
		Congress.class,
		DataMountain.class,
		FisheyeMenu.class,
		GraphView.class,
		RadialGraphView.class,
		ScatterPlot.class,
		TreeMap.class,
		TreeView.class,
		ZipDecode.class
	};
	
    public static void main(String[] argv) {
		EventQueue.invokeLater( new Demos() );
    }
    
	public void run() {
		final JFrame f = new JFrame( "Prefuse Demos" );
		f.setResizable( false );
		final Container cp = f.getContentPane();
//		cp.setLayout( new BoxLayout( cp, BoxLayout.Y_AXIS ));
		cp.setLayout( new GridLayout( clz.length, 1 ));
		for( int i = 0; i < clz.length; i++ ) {
			final Class c = clz[ i ];
			final String cn = c.getName();
			final String name = cn.substring( cn.lastIndexOf( '.' ) + 1 ); 
			final JButton b = new JButton( new AbstractAction( name ) {
				public void actionPerformed( ActionEvent e ) {
					try {
						final Method m = c.getMethod( "main", new Class[] { String[].class });
						m.invoke( null, new Object[] { new String[] {} });
					} catch( Throwable e1 ) {
						e1.printStackTrace();
					}
				}
			});
			cp.add( b );
			b.setFocusable( false );
			b.putClientProperty( "JButton.buttonType", "bevel" );
		}
		f.pack();
		f.setLocationRelativeTo( null );
		f.setDefaultCloseOperation( WindowConstants.EXIT_ON_CLOSE );
		f.setVisible( true );
	}
}