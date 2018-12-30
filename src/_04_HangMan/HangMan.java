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
	String a;
	Integer [] ints;
	int j;
	int k;
	int wordsleft;
	public static void main(String[] args) {
		HangMan h = new HangMan();
		h.HangMan();
	}
	private void HangMan() {
		
		String a = JOptionPane.showInputDialog("How many words would like to guess?");
		wordsleft = Integer.parseInt(a);
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
		
		length = b.length();
		ints = new Integer[length];
		for (int i = 0; i < ints.length; i++) {
			ints[i] = 0;
		}
		label.setText("_");
		for (int i = 0; i < length -1 ; i++) {
			label.setText(label.getText()+"_");	
		}
		label.setText(label.getText() + "Lives Remaiming" + lives);
		frame.pack();

	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		j = 0;
		k = 0;
		label.setText("");
		// TODO Auto-generated method stub		
		char character = e.getKeyChar();
		for (int i = 0; i < length; i++) {
			if(b.charAt(i)== character) {
				label.setText(label.getText()+character);
				ints[i] = 1;
				}
			else if(ints[i] == 1 && b.charAt(i) != character ){
				label.setText(label.getText() + b.charAt(i));	
				j++;
			}
			else{
				label.setText(label.getText()+"_");
				j++;
				k++;
			}
			
			}
		if(j == b.length()){
			lives--;
		}
		label.setText(label.getText() + " Lives Remaning:" + lives);
		frame.pack();
		if(lives == 0){
			JOptionPane.showMessageDialog(null, "You ran out of lives. The word was " + b);
			String answer = JOptionPane.showInputDialog("Do you want to play again (1:yes, 0:no)");
			int answer4 = Integer.parseInt(answer);
			if(answer4 == 1) {
				String a = JOptionPane.showInputDialog("How many words would like to guess?");
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
				wordsleft = Integer.parseInt(a);
				 b = words.pop();	 
				length = b.length();
				ints = new Integer[length];
				for (int j = 0; j< ints.length; j++) {
					ints[i] = 0;
				}
				label.setText("_");
				for (int k = 0; k < length -1 ; k++) {
						label.setText(label.getText()+"_");	
				}
				label.setText(label.getText() + "Lives Remaiming" + lives);
				frame.pack();
				ints = new Integer[length];
				for (int l = 0; l < ints.length; l++) {
					ints[l] = 0;
				}
				lives=10;
			}
			}
		}
		if(k == 0){
			JOptionPane.showMessageDialog(null, "Good Job");
			wordsleft--;
			if(wordsleft == 0){
			String answer2 = JOptionPane.showInputDialog("Do you want to play again (1:yes, 0:no)");
			int answer3 = Integer.parseInt(answer2);
			if(answer3 == 1) {
				String a = JOptionPane.showInputDialog("How many words would like to guess?");
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
				
				wordsleft = Integer.parseInt(a);
				 b = words.pop();
			
				length = b.length();
				ints = new Integer[length];
				for (int j = 0; j < ints.length; j++) {
					ints[i] = 0;
				}
				label.setText("_");
				for (int k = 0; k < length -1 ; k++) {
						label.setText(label.getText()+"_");	
				}
				label.setText(label.getText() + "Lives Remaiming" + lives);
				frame.pack();
				ints = new Integer[length];
				for (int l = 0; l < ints.length; l++) {
					ints[l] = 0;
				}
				}
			}
			}	
			else{
			 b = words.pop();
			 
			length = b.length();
			ints = new Integer[length];
			for (int i = 0; i < ints.length; i++) {
				ints[i] = 0;
			}
			label.setText("_");
			for (int i = 0; i < length -1 ; i++) {
					label.setText(label.getText()+"_");	
			}
			label.setText(label.getText() + "Lives Remaiming" + lives);
			frame.pack();
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
