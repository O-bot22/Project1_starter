import javax.swing.*;
import java.awt.event.*;
import javax.sound.midi.*;
import java.util.*;

/**
 * Handles mouse press, release, and drag events on the Piano.
 */
public class PianoMouseListener extends MouseAdapter {
	// You are free to add more instance variables if you wish.
	private List<Key> _keys;
	private int old_x;
	private int old_y;

	/**
	 * @param keys the list of keys in the piano.
	 */
	public PianoMouseListener (List<Key> keys) {
		_keys = keys;
	}

	// TODO implement this method.
	@Override
	/**
	 * This method is called by Swing whenever the user drags the mouse.
	 * @param e the MouseEvent containing the (x,y) location, relative to the upper-left-hand corner
	 * of the entire piano, of where the mouse is currently located.
	 */
	public void mouseDragged (MouseEvent e) {
		final int x_pos = e.getX();
		final int y_pos = e.getY();
		boolean key_state = false;
		for(int i=0; i<_keys.size(); i++){
			key_state = _keys.get(i).getPolygon().contains(x_pos, y_pos);
			_keys.get(i).play(key_state);
		}
	}

	// TODO implement this method.
	@Override
	/**
	 * This method is called by Swing whenever the user presses the mouse.
	 * @param e the MouseEvent containing the (x,y) location, relative to the upper-left-hand corner
	 * of the entire piano, of where the mouse is currently located.
	 */
	public void mousePressed (MouseEvent e) {
		// To test whether a certain key received the mouse event, you could write something like:
		//	if (key.getPolygon().contains(e.getX(), e.getY())) {
		// To turn a key "on", you could then write:
		//      key.play(true);  // Note that the key should eventually be turned off!
		// turn on whichever key is currently pressed and turn off every other
		final int x_pos = e.getX();
		final int y_pos = e.getY();
		boolean key_state = false;
		for(int i=0; i<_keys.size(); i++){
			key_state = _keys.get(i).getPolygon().contains(x_pos, y_pos);
			_keys.get(i).play(key_state);
		}
	}

	// TODO implement this method.
	@Override
	/**
	 * This method is called by Swing whenever the user releases the mouse.
	 * @param e the MouseEvent containing the (x,y) location, relative to the upper-left-hand corner
	 * of the entire piano, of where the mouse is currently located.
	 */
	public void mouseReleased (MouseEvent e) {
		// set all the keys to off
		for(int i=0; i<_keys.size(); i++){
			_keys.get(i).play(false);
		}
	}
}
