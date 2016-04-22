package eg.edu.guc.yugioh.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import eg.edu.guc.yugioh.board.player.Player;

public class winner extends JFrame{
	
	public winner (String  p) {
	setSize(1000,800);

		JLabel w = new JLabel ();
		w.setText(p+" is the winner");
		w.setForeground(Color.RED);
		w.setSize(300,300);;
	
		w.setBounds(0,200,700,100);
	w.setFont(new Font("", 75, 75));
	JButton play = new JButton("play again");
	play.setBounds(700,600,100,50);
	play.addActionListener(new ActionListener() {
			@Override
		public void actionPerformed(ActionEvent arg0) {
			start s = new start();
			setVisible(false);
			s.setVisible(true);
			
			
		}
	});
	getContentPane().setLayout(null);
	getContentPane().add(w);
	getContentPane().add(play);
		
	
		
		
	}public static void main(String [] args)
	{
		winner v = new winner("ahmed");
		v.setVisible(true);
	}

}
