package _04_HangMan;

import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
public class HangMan {
	JLabel label;
	JPanel panel;
	JFrame frame;
	Stack<String> words;
	public HangMan() {
		String a = JOptionPane.showInputDialog("How many words would like to guess?");
		label = new JLabel();
		panel = new JPanel();
		frame = new JFrame();
		frame.add(panel);
		panel.add(label);
		frame.setVisible(true);
		frame.pack();
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
		int lives = 10;
		String b = words.pop();
		System.out.println(b);
		int length = b.length();
		label.setText("-");
		for (int i = 0; i < length -1 ; i++) {
			label.setText(label.getText()+"-");	
		}
		label.setText(label.getText()+"Lives Remaining:"+ lives);	
		frame.pack();
	}
	
	public static void main(String[] args) {
		 new HangMan();
		
	}

	
	
}
