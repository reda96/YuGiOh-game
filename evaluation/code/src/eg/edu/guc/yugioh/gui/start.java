package eg.edu.guc.yugioh.gui;



import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import eg.edu.guc.yugioh.board.Board;
import eg.edu.guc.yugioh.board.player.Player;
import eg.edu.guc.yugioh.cards.Card;

public class  start extends JFrame implements ActionListener {
	
	board gui;
	JLabel myLabel;
	JLabel myLabel2;
	JTextField p1;
	JTextField p2;
    
    JButton b;
	
	
	
	public start()
	{ setBounds(0,0,1000,700);
	 myLabel=new JLabel("Enter First Player");
	
	 myLabel.setBounds(10,400,170,30);
	 p1=new JTextField();
	 p1.setBounds(170,410,100,20);

	 myLabel2=new JLabel("Enter Second Player");
	 myLabel2.setForeground(Color.WHITE);
	 myLabel.setForeground(Color.WHITE);
	 myLabel2.setBounds(450,400,170,30);
	 p2=new JTextField();
	 p2.setBounds(600,410,100,20);
	 
	 b = new JButton(); b.setText("Start a Game"); 
	 b.setBounds(800,600,150,50);
	 getContentPane().setLayout(null);
	 try{
			setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("C:\\Users\\win8.1\\Desktop\\yu.jpg")))));
			// String x = JOptionPane.showInputDialog("Enter the first name");
			 }catch(Exception e)
			 {
			System.out.println("mafeeeeeeeeee4");
			 }
	
	 //getContentPane().setBackground(image,);
	 getContentPane().add(myLabel);
	 getContentPane().add(p1);
	 getContentPane().add(b);
	 b.addActionListener(this);
	 getContentPane().add(myLabel2);
	 getContentPane().add(p2);
	
	 
		
        
		}
	public static void main(String[] args) {
		
		start s = new start();
		s.setVisible(true);
		
		}
	@Override
	public void actionPerformed(ActionEvent arg0)  {
	{
		board b=new board(); 
		b.setVisible(true);
	    this.setVisible(false);
		b.playername1.setText("p1: "+p1.getText());
		b.playername2.setText("p2: "+p2.getText());
		b.player1lifepoints.setText("8000");
		b.player2lifepoints.setText("8000");
		try {b.h=new Board();
			b.p1=new Player (p1.getText());
		b.p2 = new Player (p2.getText());
		
			b.h.startGame(b.p1,b.p2);
			for(int i=0;i<5;i++){
				b.addcardtohand(Card.getBoard().getActivePlayer().getField().getHand().get(i),
						Card.getBoard().getActivePlayer());
				b.addcardtohand(Card.getBoard().getOpponentPlayer().getField().getHand().get(i),
						Card.getBoard().getOpponentPlayer());
			}
			b.addcardtohand(Card.getBoard().getActivePlayer().getField().getHand().get(5),
			
					
					Card.getBoard().getActivePlayer());
			b.update();
	if(b.p1==b.h.getActivePlayer()) b.turn.setText("p1 turn");
	else
		b.turn.setText("p2 turn");
		} catch (Exception e) {
		
			e.printStackTrace();
		}if (b.p1==b.h.getActivePlayer() ){
			b.handp2.setVisible(false);
			b.handp1.setVisible(true);}
			else{
				b.handp1.setVisible(false);
				b.handp2.setVisible(true);
				
				
			}
		}
		
		
		
		
	} 
}
