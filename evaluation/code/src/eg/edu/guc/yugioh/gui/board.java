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
import javax.swing.JPanel;
import javax.swing.RepaintManager;

import org.hamcrest.core.IsInstanceOf;

import eg.edu.guc.yugioh.board.Board;
import eg.edu.guc.yugioh.board.player.Phase;
import eg.edu.guc.yugioh.board.player.Player;
import eg.edu.guc.yugioh.cards.Card;
import eg.edu.guc.yugioh.cards.Mode;
import eg.edu.guc.yugioh.cards.MonsterCard;
import eg.edu.guc.yugioh.cards.spells.SpellCard;

public class board extends JFrame implements ActionListener {
    Board h;
    
	 JPanel handp1;
	 JPanel handp2;
	JPanel monsterarea2 ;
	JPanel monsterarea1;
	JPanel spellarea1;
	JPanel spellarea2; 
	
	 JButton deckp1;
	 JButton deckp2;
      Player p1;
	 Player p2;
	JLabel playername1;
	JLabel player1lifepoints;
	JLabel playername2;
	JLabel player2lifepoints;
	JButton endturnp1;
	JButton endturnp2;
	JButton endphasep1;
	JButton enturnp2;
	JButton endphasep2;
	JButton phase;
	 JButton j;
	 JButton j2;
	 int hand1;
	 int hand2;
	 JLabel size1;
   JLabel size2;
	JButton turn;
	JPanel graveyardp2 ;
	JPanel graveyardp1;

	
	public board() 
	{	
		setSize(1400,800);
			
	playername1 = new JLabel();
	playername1.setBounds(20, 20,100,70);
	playername2 = new JLabel();
	playername1.setForeground(Color.WHITE);
	playername2.setForeground(Color.WHITE);
	playername2.setBounds(20,580,100, 70);
	player1lifepoints = new JLabel();
	player1lifepoints.setBounds(20,40,100,70);
	player1lifepoints.setForeground(Color.WHITE);

	player2lifepoints = new JLabel();
	
	player2lifepoints.setBounds(20,600,100,70);
	player2lifepoints.setForeground(Color.WHITE);
	turn = new JButton();
	turn.setBounds(20,300,100,50);
	phase = new JButton ("MAIN1");
	phase.setBounds(20,360,100,50);
	endturnp1 = new JButton ("END TURN");
	endphasep1= new JButton ("END PHASE");
	endturnp1.setBounds(20,120,100,50);
	endphasep1.setBounds(20,200,100,50);
	endturnp2 = new JButton ("END TURN");
	endphasep2= new JButton ("END PHASE");
	endturnp1.addActionListener(new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent arg0) {
			 {
				p1.endTurn();
				phase.setText("" + p2.getField().getPhase());
				turn.setText("p2 turn");
				handp1.setVisible(false);
				handp2.setVisible(true);
				addcardtohand(p2.getField().getHand().get(p2.getField().getHand().size()-1),p2);
				update();
				if(Card.getBoard().getWinner()!=null)
				{  setVisible(false);
					winner w =new winner(Card.getBoard().getWinner().getName());
					w.setVisible(true);
				}
				
				
			}
		}
		
	});	
	endturnp2.addActionListener(new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent arg0) {
			{
				p2.endTurn();
				phase.setText("" + p1.getField().getPhase());
				turn.setText("p1 turn");
				handp2.setVisible(false);
				handp1.setVisible(true);
				addcardtohand(p1.getField().getHand().get(p1.getField().getHand().size()-1),p1);
				update();
				if(Card.getBoard().getWinner()!=null)
				{  setVisible(false);
					winner w =new winner(Card.getBoard().getWinner().getName());
					w.setVisible(true);
				}
			}}
		
	});	
	
	
	
	
	endphasep1.addActionListener(new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent e) {
			if (p1 == h.getActivePlayer()&&h.getActivePlayer().getField().getPhase()!=Phase.MAIN2) {
				handp2.setVisible(false);
				handp1.setVisible(true);
				p1.endPhase();
				phase.setText("" + p1.getField().getPhase());
				}
			}
		
	});
	endphasep2.addActionListener(new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent e) {
			if (p2 == h.getActivePlayer()&&
					h.getActivePlayer().getField().getPhase()!=Phase.MAIN2) {
				handp1.setVisible(false);
				handp2.setVisible(true);
				p2.endPhase();
				phase.setText("" + p2.getField().getPhase());
				
			}
		}
	});
	
	
	endturnp2.setBounds(20,520,100,50);
	endphasep2.setBounds(20,440,100,50);
	
	
	
	 monsterarea1 = new JPanel();
	monsterarea1.setBackground(Color.lightGray);
	monsterarea1.setOpaque(false);
	monsterarea1.setBounds(300,245,800,125);
	 monsterarea2 = new JPanel();
	monsterarea2.setBackground(Color.lightGray);
	monsterarea2.setOpaque(false);
	monsterarea2.setBounds(300, 350,800, 125);
	 spellarea2 = new JPanel();
	spellarea2.setBackground(Color.lightGray);
	spellarea2.setOpaque(false);
	spellarea2.setBounds(300,440,800, 125);
	/*JLabel n1 = new JLabel("SpellArea");
	n1.setForeground(Color.WHITE);
	n1.setBounds(200,50,75,20);
	JLabel p = new JLabel("SpellArea");
	p.setBounds(270,470,75,20);
	p.setForeground(Color.WHITE);
	JLabel m1= new JLabel("MonsterArea");
	n1.setBounds(270,245,50,20);
	JLabel q= new JLabel("MonsterArea");
	q.setBounds(270,245,50,20);*/
	
	 spellarea1 = new JPanel();
	spellarea1.setBackground(Color.lightGray);
	spellarea1.setOpaque(false);
	spellarea1.setBounds(300,135,800, 125);
	
    handp1= new JPanel();
	handp1.setBackground(Color.lightGray);
	handp1.setOpaque(false);
	handp1.setBounds(300, 0,900, 85);

	
	
	 handp2 = new JPanel();
	handp2.setBackground(Color.lightGray);
	handp2.setOpaque(false);
	handp2.setBounds(300, 575,900, 85);
	 graveyardp1 = new JPanel();
	graveyardp1.setBackground(Color.lightGray);
	graveyardp1.setOpaque(false);
	graveyardp1.setBounds(150,85,75,170);
	graveyardp2 = new JPanel();
	graveyardp2.setBackground(Color.lightGray);
	graveyardp2.setOpaque(false);
	graveyardp2.setBounds(150,375,75,170);

	
	
	 deckp1= new JButton("Deck1 20");
	
	
	deckp1.setBounds(1100,180,100,75);
	deckp2= new JButton("Deck2 20");

	
	deckp2.setBounds(1100,375,100,75);
	

	size1 = new JLabel ("20");
	//deckp1.add(size1); size1.setBounds(20,50,50,20);
	 size2 = new JLabel ("20");
	//deckp2.add(size2); size2.setBounds(20,50,50,20);
	
	

	
		
			
		JButton n = new JButton();
		n.setBounds(0,85,75,75);
		graveyardp2.add(n);
		JButton g = new JButton();
        g.setBounds(0,85,75,75);
		graveyardp1.add(g);
	
	
	
	for(int i=0;i<5;i++)
	{
		JButton m = new JButton();
		m.setBounds(i*100,20,100,75);
		spellarea1.add(m);
		
	}
	for(int i=0;i<5;i++)
	{
		JButton m = new JButton();
		m.setBounds(i*100,20,100,75);
		spellarea2.add(m);
		
	}
	for(int i=0;i<5;i++)
	{
		JButton m = new JButton();
		m.setBounds(i*100,0,100,75);
		monsterarea1.add(m);
	}
	for(int i=0;i<5;i++)
	{
		JButton m = new JButton();
		m.setBounds(i*100,20,100,75);
		monsterarea2.add(m);
	}
	try{
		setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("C:\\Users\\win8.1\\Desktop\\3.jpg")))));
		// String x = JOptionPane.showInputDialog("Enter the first name");
		 }catch(Exception e)
		 {
		System.out.println("mafeeeeeeeeee4");
		 }
	
	/*n1.setLayout(null);
	getContentPane().add(n1);
	getContentPane().add(m1);
	getContentPane().add(p);
	getContentPane().add(q);*/
	playername1.setLayout(null);
	getContentPane().add(playername1);
    playername2.setLayout(null);
	getContentPane().add(playername2);
	player1lifepoints.setLayout(null);
	getContentPane().add(player1lifepoints);
	player2lifepoints.setLayout(null);
	getContentPane().add(player2lifepoints);
	endphasep1.setLayout(null);
	getContentPane().add(endphasep1);
	endturnp1.setLayout(null);
	getContentPane().add(endturnp1);
	endphasep2.setLayout(null);
	getContentPane().add(endphasep2);
	endturnp2.setLayout(null);
	getContentPane().add(endturnp2);
	
	monsterarea1.setLayout(null);
	spellarea1.setLayout(null);
	spellarea2.setLayout(null);monsterarea2.setLayout(null); handp1.setLayout(null);handp2.setLayout(null);graveyardp1.setLayout(null);
	graveyardp2.setLayout(null);
	deckp1.setLayout(null);
	deckp2.setLayout(null);
	getContentPane().setLayout(null);
	getContentPane().add(monsterarea1);
	getContentPane().add(spellarea1);
	getContentPane().add(spellarea2);
	getContentPane().add(monsterarea2);
	getContentPane().add(handp1);
	getContentPane().add(handp2);
	getContentPane().add(graveyardp1);
	getContentPane().add(graveyardp2);
	getContentPane().add(deckp1);
	getContentPane().add(deckp2);
	phase.setLayout(null);
	getContentPane().add(phase);
	turn.setLayout(null);
	getContentPane().add(turn);
	
	
}
	public  void addcardtohand (Card s,Player p)
	{ 
		if(p==p1)
		{ if((Integer.parseInt(size1.getText())>0))
		{ 
			if(s instanceof MonsterCard )
			{	
				MonsterButton m = new MonsterButton((MonsterCard)s,this);
				
			 m.setText(s.getName());
	m.setBounds(hand1*100,10,100,75);
	hand1++;
	handp1.add(m);
	size1.setText(""+(Integer.parseInt(size1.getText())-1));
			}
		if(s instanceof SpellCard ){
			SpellButton m= new SpellButton((SpellCard)s,this);
			
			 m.setText(s.getName());
	m.setBounds(hand1*100,10,100,75);
	hand1++;
	handp1.add(m);
	size1.setText(""+(Integer.parseInt(size1.getText())-1));
		

		}	}}if(p==p2)
		{  if((Integer.parseInt(size2.getText())>0))
				{	if(s instanceof MonsterCard )
				{
				
			MonsterButton m = new MonsterButton((MonsterCard)s,this);
			
			 m.setText(s.getName());
	m.setBounds(hand2*100,10,100,75);
	hand2++;
	handp2.add(m);
	size2.setText(""+(Integer.parseInt(size2.getText())-1));
			}
		if(s instanceof SpellCard ){
			SpellButton m= new SpellButton((SpellCard)s,this);
			
			 m.setText(s.getName());
	m.setBounds(hand2*100,10,100,75);
	hand2++;
	handp2.add(m);
	size2.setText(""+(Integer.parseInt(size2.getText())-1));
		}
		}
		}}
public  void update ()
{ if(Card.getBoard().getActivePlayer()==p1)
{   handp1.removeAll(); 
	hand1=0;
	for(int i=0;i<p1.getField().getHand().size();i++)
	{
		addcardtohand(p1.getField().getHand().get(i),p1);
	}
	size1.setText(""+p1.getField().getDeck().getDeck().size());
	size2.setText(""+p2.getField().getDeck().getDeck().size());
	handp1.repaint();
	handp1.validate();
}else
{handp2.removeAll(); 
hand2=0;
for(int i=0;i<p2.getField().getHand().size();i++)
{
	addcardtohand(p2.getField().getHand().get(i),p2);
}
size1.setText(""+p1.getField().getDeck().getDeck().size());
size2.setText(""+p2.getField().getDeck().getDeck().size());
handp2.repaint();
handp2.validate();

	
}
  monsterarea1.removeAll();
  {int i;
	  for( i=0;i<p1.getField().getMonstersArea().size();i++)
		{
			MonsterButton m = new MonsterButton(p1.getField().getMonstersArea().get(i),this);
			m.setBounds(i*150,0,150,75);
			m.location=monsterarea1;
			if(p1.getField().getMonstersArea().get(i).getMode()==Mode.ATTACK)
			{	m.setText(p1.getField().getMonstersArea().get(i).getName()+
					"  "+(p1.getField().getMonstersArea().get(i).getAttackPoints()));
			monsterarea1.add(m);}
			else{
				if(p1==Card.getBoard().getActivePlayer())
	 				m.setText(p1.getField().getMonstersArea().get(i).getName()
	 						);
	 			else m.setText("Set");
	 			monsterarea1.add(m);
			
		} }if(i<5) 
			for(int j=i;j<5;j++)
			{
		JButton m = new JButton();
				m.setBounds(j*150,0,150,75);
				monsterarea1.add(m);
			}
  }
   monsterarea1.repaint();
   monsterarea1.validate();
   monsterarea2.removeAll();
   {int i;
 	  for( i=0;i<p2.getField().getMonstersArea().size();i++)
 		{
 			MonsterButton m = new MonsterButton(p2.getField().getMonstersArea().get(i),this);
 			m.setBounds(i*150,20,150,75);
 			m.location=monsterarea2;
 			if(p2.getField().getMonstersArea().get(i).getMode()==Mode.ATTACK)
 			{	m.setText(p2.getField().getMonstersArea().get(i).getName());
 			monsterarea2.add(m);}
 			else {if(p2==Card.getBoard().getActivePlayer())
 				m.setText(p2.getField().getMonstersArea().get(i).getName());
 			else m.setText("Set");
 			monsterarea2.add(m);
 		}} if(i<5) 
 			for(int j=i;j<5;j++)
 			{
 				JButton m = new JButton();
 				m.setBounds(j*150,20,150,75);
 				monsterarea2.add(m);
 			}
   }
    monsterarea2.repaint();
    monsterarea2.validate();
    //spellarea1.repaint();
    //spellarea1.validate();
    spellarea2.removeAll();
    int i;
  	  for( i=0;i<p2.getField().getSpellArea().size();i++)
  		{
  			SpellButton m = new SpellButton(p2.getField().getSpellArea().get(i),this);
  			m.setBounds(i*150,20,150,75);
  			m.setText(p2.getField().getSpellArea().get(i).getName());
  			//m.setBackground(Color.GREEN);
  			m.location=spellarea2;
  			if(p2.getField().getSpellArea().get(i).isHidden()&&
  					p2==Card.getBoard().getActivePlayer())
 			{	m.setText(p2.getField().getSpellArea().get(i).getName());
 			}
  			if(p2.getField().getSpellArea().get(i).isHidden()&&
  					p1==Card.getBoard().getActivePlayer())
  			
 	{m.setText("Set");}
 			spellarea2.add(m);
 		}
  			
  		if(i<5) 
  			for(int j=i;j<5;j++)
  			{
  				JButton m = new JButton();
  				m.setBounds(j*150,20,150,75);
  				spellarea2.add(m);
  			}
    
  spellarea2.repaint();
    spellarea2.validate();
    // spellarea1.repaint();
     spellarea1.removeAll();
     {int t;
 	  for( t=0;t<p1.getField().getSpellArea().size();t++)
 		{
 			SpellButton m = new SpellButton(p1.getField().getSpellArea().get(t),this);
 			m.setBounds(t*150,20,150,75);
 			m.setText(p1.getField().getSpellArea().get(t).getName());
 			//m.setBackground(Color.GREEN);
 			spellarea1.add(m);
 			m.location=spellarea1;
 			if(p1.getField().getSpellArea().get(t).isHidden()&&
  					p1==Card.getBoard().getActivePlayer())
 			{	m.setText(p1.getField().getSpellArea().get(t).getName());
 			}
  			if(p1.getField().getSpellArea().get(t).isHidden()&&
  					p2==Card.getBoard().getActivePlayer())
  			
 	{m.setText("Set");}
 			spellarea1.add(m);
 		} if(t<5) 
 			for(int j=t;j<5;j++)
 			{
 				JButton m = new JButton();
 				m.setBounds(j*150,20,150,75);
 				spellarea1.add(m);
 			}
   }
    spellarea1.repaint();
    spellarea1.validate();
    if(p1.getField().getGraveyard().size()>0)
    {
    graveyardp1.removeAll();
    if(p1.getField().getGraveyard()
    		.get(p1.getField().getGraveyard().size()-1) instanceof MonsterCard)
    { MonsterButton b= new MonsterButton ((MonsterCard)p1.getField().getGraveyard()
    		.get(p1.getField().getGraveyard().size()-1),this);
    b.setBounds(0,85,75,75);
    graveyardp1.add(b);}
    else{
    	SpellButton b =new SpellButton ((SpellCard)p1.getField().getGraveyard()
        		.get(p1.getField().getGraveyard().size()-1),this);
    	 b.setBounds(0,85,75,75);
    	 graveyardp1.add(b);
    }
    
    
    }
    graveyardp1.repaint();
    graveyardp1.validate();
    if(p2.getField().getGraveyard().size()>0)
    {
    graveyardp2.removeAll();
    if(p2.getField().getGraveyard()
    		.get(p2.getField().getGraveyard().size()-1) instanceof MonsterCard)
    { MonsterButton b= new MonsterButton ((MonsterCard)p2.getField().getGraveyard()
    		.get(p2.getField().getGraveyard().size()-1),this);
    b.setBounds(0,85,75,75);
    graveyardp2.add(b);}
    else{
    	SpellButton b =new SpellButton ((SpellCard)p2.getField().getGraveyard()
        		.get(p2.getField().getGraveyard().size()-1),this);
    	 b.setBounds(0,85,75,75);
    	 graveyardp2.add(b);
    }
    }
    graveyardp2.repaint();
    graveyardp2.validate();
deckp1.setText("Deck1: "+ size1.getText());
deckp2.setText("Deck2: "+ size2.getText());
   
}
	
	
	
	
	
	
	
	
	
	
	
	public static void main (String [] args)
	{
		board b = new board ();
		b.setVisible(true);
	}
	
	
	
	
	
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
