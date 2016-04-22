package eg.edu.guc.yugioh.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import eg.edu.guc.yugioh.cards.Card;
import eg.edu.guc.yugioh.cards.Location;
import eg.edu.guc.yugioh.cards.spells.SpellCard;
import eg.edu.guc.yugioh.exceptions.NoSpellSpaceException;
import eg.edu.guc.yugioh.exceptions.WrongPhaseException;

public class SpellButton extends JButton{
	SpellCard spell;
	JPanel location;
	 private board gui ;
		public board getGui() {
			return gui;
		}
		public void setGui(board gui) {
			this.gui = gui;
		}
	public SpellButton (SpellCard s,board gui)

	{	super();
	spell=s;
	try{
	addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
	String[] x = {"SPELL",
			"name:"+((SpellCard) s).getName(),
			"description:"+""+((SpellCard) s).getDescription(),
			
			};
	if(s.getLocation()==Location.HAND)
	{
	JOptionPane j = new JOptionPane();
			int m= j.showConfirmDialog(null, x,
					"Do you want to set or activate this spell?",
					JOptionPane.YES_NO_OPTION);
			
			if (m == JOptionPane.YES_OPTION) {
				Object[] options = { "Set", "Activate" };
				int n=JOptionPane.showOptionDialog(null,
						"Would you like to set or activate this spell?",
						" ", JOptionPane.YES_NO_OPTION,
						JOptionPane.QUESTION_MESSAGE, null, options,
						options[0]);
				if(n==0)
				{ try{
					Card.getBoard().getActivePlayer().setSpell(spell);
				}
				catch(WrongPhaseException | NoSpellSpaceException ex){
					JOptionPane.showMessageDialog(null, ex.getMessage());}
				
				}gui.update();
				if(n==1)
				{   try{
					activatespell(spell);
				}catch(WrongPhaseException | NoSpellSpaceException ex){
					JOptionPane.showMessageDialog(null, ex.getMessage());}
					gui.update();
				}
				

			}
			} else   if(spell.getLocation()==Location.FIELD)
			{
				if((location==gui.spellarea1&&gui.p1==Card.getBoard().getActivePlayer())||
						(location==gui.spellarea2&&gui.p2==Card.getBoard().getActivePlayer())	)
				
				{   
					int n = JOptionPane.showConfirmDialog(null, x,
							"Do you want to  activate this spell?",
							JOptionPane.YES_NO_OPTION);
					
					if (n == JOptionPane.YES_OPTION) {
						activatespell(spell);
						gui.update();
						
					}
				}
			}
			else{if(spell.getLocation()==Location.GRAVEYARD)
	{
		
		String[] y= {"SPELL",
				"name:"+((SpellCard) s).getName(),
				"description:"+""+((SpellCard) s).getDescription(),
				
				};
	JOptionPane.showMessageDialog(null,y);
		
	
		}}if(Card.getBoard().getWinner()!=null)
		{  gui.setVisible(false);
		winner w =new winner(Card.getBoard().getWinner().getName());
		w.setVisible(true);
	}
}
//JOptionPane.showMessageDialog(null,x);
});}
	catch(WrongPhaseException | NoSpellSpaceException ex){
		JOptionPane.showMessageDialog(null, ex.getMessage());}

	} public void activatespell(SpellCard s)
	{
		switch(s.getName())
		{
		case"Card Destruction": Card.getBoard().getActivePlayer().activateSpell(s,null);break;
		case"Change Of Heart": 
		Object monsters[] = new Object[Card.getBoard().getOpponentPlayer().getField().getMonstersArea().size()];
		if(Card.getBoard().getOpponentPlayer().getField().getMonstersArea().size()>0)
		{
	for (int i = 0; i < monsters.length; i++) {
		
	monsters[i] = Card.getBoard().getOpponentPlayer().getField().getMonstersArea().get(i).getName()
			+" "+Card.getBoard().getOpponentPlayer().getField().getMonstersArea().get(i).getAttackPoints()
	+" "+Card.getBoard().getOpponentPlayer().getField().getMonstersArea().get(i).getAttackPoints();
								}
								int t = JOptionPane
										.showOptionDialog(
												null,
												"choose one monster to add it to your field",
												"",
												JOptionPane.YES_NO_OPTION,
												JOptionPane.QUESTION_MESSAGE,
												null, monsters,
												monsters[0]);
	Card.getBoard().getActivePlayer().activateSpell(s,Card.getBoard().getOpponentPlayer().getField()
			.getMonstersArea().get(t));}
	else{
		JOptionPane.showMessageDialog(null,"There is no monsters in your opponent field");
	}
	break;
		case"Dark Hole":  Card.getBoard().getActivePlayer().activateSpell(s,null);break;
		case"Graceful Dice":  Card.getBoard().getActivePlayer().activateSpell(s,null);break;
		case"Harpie's Feather Duster":Card.getBoard().getActivePlayer().activateSpell(s,null);break;
		case"Heavy Storm":Card.getBoard().getActivePlayer().activateSpell(s,null);break;
		case"Mage Power":
			if(Card.getBoard().getActivePlayer().getField().getMonstersArea().size()>0){
			Object monster[] = new Object[Card.getBoard().getActivePlayer().getField().getMonstersArea().size()];
			for (int i = 0; i < monster.length; i++) {
			monster[i] = Card.getBoard().getActivePlayer().getField().getMonstersArea().get(i).getName()
					+""+Card.getBoard().getActivePlayer().getField().getMonstersArea().get(i).getAttackPoints()
			+""+Card.getBoard().getActivePlayer().getField().getMonstersArea().get(i).getAttackPoints();
										}
										int c = JOptionPane
												.showOptionDialog(
														null,
														"choose one monster to add it to your field",
														"",
														JOptionPane.YES_NO_OPTION,
														JOptionPane.QUESTION_MESSAGE,
														null, monster,
														monster[0]);
Card.getBoard().getActivePlayer().activateSpell(s,
		Card.getBoard().getActivePlayer().getField().getMonstersArea().get(c));}
		else JOptionPane.showMessageDialog(null,"there is no monsters in your field");
		break;
		case"Monster Reborn":Card.getBoard().getActivePlayer().activateSpell(s,null);break;
		case"Pot of Greed":Card.getBoard().getActivePlayer().activateSpell(s,null);break;
		case"Raigeki":Card.getBoard().getActivePlayer().activateSpell(s,null);
		}
		
		
	}

}
