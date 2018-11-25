package _04_HangMan;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
public class HangMan implements KeyListener{
	JLabel label;
	JPanel panel;
	JFrame frame;
	Stack<String> words;
	String b;
	int length;
	int lives;
	public static void main(String[] args) {
		HangMan h = new HangMan();
		h.HangMan();
	}
	private void HangMan() {
		
		String a = JOptionPane.showInputDialog("How many words would like to guess?");
		label = new JLabel();
		panel = new JPanel();
		frame = new JFrame();
		frame.add(panel);
		panel.add(label);
		frame.setVisible(true);
		frame.pack();
		frame.addKeyListener(this);
		words = new Stack<String>();
		int z = Integer.parseInt(a);
		for (int i = 0; i < z; i++) {
			String word = Utilities.readRandomLineFromFile("src/_04_HangMan/dictionary.txt");
			if(words.contains(word)) {
				i = words.size();
			}
			else {
			words.push(word);
			}           
		}
		 lives = 10;
		 b = words.pop();
		System.out.println(b);
		length = b.length();
		label.setText("-");
		for (int i = 0; i < length -1 ; i++) {
			label.setText(label.getText()+"-");	
		}
		frame.pack();

	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		label.setText("");
		// TODO Auto-generated method stub		
		char character = e.getKeyChar();
		for (int i = 0; i < length; i++) {
			if(b.charAt(i)== character) {
				label.setText(label.getText()+character);
				}
			else {
				label.setText(label.getText()+"-");
			}
			}
			

		}
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


				
				
	

	
	
}
