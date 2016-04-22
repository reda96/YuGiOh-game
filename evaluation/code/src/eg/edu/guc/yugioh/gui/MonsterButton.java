package eg.edu.guc.yugioh.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import eg.edu.guc.yugioh.board.player.Phase;
import eg.edu.guc.yugioh.cards.Card;
import eg.edu.guc.yugioh.cards.Location;
import eg.edu.guc.yugioh.cards.Mode;
import eg.edu.guc.yugioh.cards.MonsterCard;
import eg.edu.guc.yugioh.exceptions.DefenseMonsterAttackException;
import eg.edu.guc.yugioh.exceptions.MonsterMultipleAttackException;
import eg.edu.guc.yugioh.exceptions.MultipleMonsterAdditionException;
import eg.edu.guc.yugioh.exceptions.NoMonsterSpaceException;
import eg.edu.guc.yugioh.exceptions.NoSpellSpaceException;
import eg.edu.guc.yugioh.exceptions.WrongPhaseException;

public class MonsterButton extends JButton {
	JPanel location;
	MonsterCard monster;
	private board gui;

	public board getGui() {
		return gui;
	}

	public void setGui(board gui) {
		this.gui = gui;
	}

	public MonsterButton(MonsterCard s, board gui) {
		super();
		this.gui = gui;
		monster = s;
		try {
			addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {

					{
						if (s.getLocation() == Location.HAND) {
							String[] x = {
									"MONSTER",
									"attackpoints:"
											+ ((MonsterCard) s)
													.getAttackPoints(),
									"defensepoints:"
											+ ""
											+ ((MonsterCard) s)
													.getDefensePoints(),
									"levl:" + ((MonsterCard) s).getLevel() };

							JOptionPane j = new JOptionPane();
							int n = j
									.showConfirmDialog(
											null,
											x,
											"Do you want to set or summon this monster?",
											JOptionPane.YES_NO_OPTION);
							j.setSize(200, 200);
							// n.setMessage("Do you want to set or summon this monster?");
							// JOptionPane.showMessageDialog(null,x);
							if (n == JOptionPane.YES_OPTION) {
								Object[] options = { "Set", "Summon" };

								int z = JOptionPane
										.showOptionDialog(
												null,
												"Would you like to set or summon this monster?",
												" ", JOptionPane.YES_NO_OPTION,
												JOptionPane.QUESTION_MESSAGE,
												null, options, options[0]);

								if (z == 0 || z == 1) {
									if (s.getLevel() <= 4) {
										if (z == 0)
											try {
												Card.getBoard()
														.getActivePlayer()
														.setMonster(monster);
											} catch (
													MultipleMonsterAdditionException
													| WrongPhaseException
													| NoMonsterSpaceException ex) {
												JOptionPane.showMessageDialog(
														null, ex.getMessage());
											}
										if (z == 1)
											try {
												Card.getBoard()
														.getActivePlayer()
														.summonMonster(monster);
											} catch (
													MultipleMonsterAdditionException
													| WrongPhaseException
													| NoMonsterSpaceException ex) {
												JOptionPane.showMessageDialog(
														null, ex.getMessage());
											}
										gui.update();
									} else {
										if (s.getLevel() <= 6) {
											int r = JOptionPane
													.showConfirmDialog(null,
															"you need 1 sacrifice please choose one monster from monsters Area");
											if (r == JOptionPane.YES_OPTION) {
												if (Card.getBoard()
														.getActivePlayer()
														.getField()
														.getMonstersArea()
														.size() > 0) {
													Object monsters[] = new Object[Card
															.getBoard()
															.getActivePlayer()
															.getField()
															.getMonstersArea()
															.size()];
													for (int i = 0; i < monsters.length; i++) {
														monsters[i] = Card
																.getBoard()
																.getActivePlayer()
																.getField()
																.getMonstersArea()
																.get(i)
																.getName();
													}
													int t = JOptionPane
															.showOptionDialog(
																	null,
																	"choose one sacrifice",
																	"",
																	JOptionPane.YES_NO_OPTION,
																	JOptionPane.QUESTION_MESSAGE,
																	null,
																	monsters,
																	monsters[0]);
													ArrayList<MonsterCard> ar = new ArrayList<MonsterCard>();
													ar.add(Card.getBoard()
															.getActivePlayer()
															.getField()
															.getMonstersArea()
															.get(t));
													if (z == 0)
														try {
															Card.getBoard()
																	.getActivePlayer()
																	.setMonster(
																			monster,
																			ar);
														} catch (
																MultipleMonsterAdditionException
																| WrongPhaseException
																| NoMonsterSpaceException ex) {
															JOptionPane
																	.showMessageDialog(
																			null,
																			ex.getMessage());
														}
													if (z == 1)
														try {
															Card.getBoard()
																	.getActivePlayer()
																	.summonMonster(
																			monster,
																			ar);
														} catch (
																MultipleMonsterAdditionException
																| WrongPhaseException
																| NoMonsterSpaceException ex) {
															JOptionPane
																	.showMessageDialog(
																			null,
																			ex.getMessage());
														}
													gui.update();

												} else
													JOptionPane
															.showMessageDialog(
																	null,
																	"sorry there is no monsters");
											}
										} else {
											if (s.getLevel() <= 8) {
												int r = JOptionPane
														.showConfirmDialog(
																null,
																"you need 2 sacrifice please choose one monster from monsters Area");
												if (r == JOptionPane.YES_OPTION) {
													if (Card.getBoard()
															.getActivePlayer()
															.getField()
															.getMonstersArea()
															.size() > 1) {
														Object monsters[] = new Object[Card
																.getBoard()
																.getActivePlayer()
																.getField()
																.getMonstersArea()
																.size()];
														for (int i = 0; i < monsters.length; i++) {

															monsters[i] = Card
																	.getBoard()
																	.getActivePlayer()
																	.getField()
																	.getMonstersArea()
																	.get(i)
																	.getName();
														}
														int t = JOptionPane
																.showOptionDialog(
																		null,
																		"choose first sacrifice",
																		"",
																		JOptionPane.YES_NO_OPTION,
																		JOptionPane.QUESTION_MESSAGE,
																		null,
																		monsters,
																		monsters[0]);
														Object monsters2[] = new Object[Card
																.getBoard()
																.getActivePlayer()
																.getField()
																.getMonstersArea()
																.size() - 1];
														if(t==0||t==1||t==2||t==4||t==3)
														{
														for (int i = 0; i < monsters2.length; i++) {
															if (i != t)
																monsters2[i] = Card
																		.getBoard()
																		.getActivePlayer()
																		.getField()
																		.getMonstersArea()
																		.get(i)
																		.getName();
														}
														int l = JOptionPane
																.showOptionDialog(
																		null,
																		"choose another sacrifice",
																		"",
																		JOptionPane.YES_NO_OPTION,
																		JOptionPane.QUESTION_MESSAGE,
																		null,
																		monsters2,
																		monsters2[0]);

														ArrayList<MonsterCard> ar = new ArrayList<MonsterCard>();
														ar.add(Card
																.getBoard()
																.getActivePlayer()
																.getField()
																.getMonstersArea()
																.get(t));
														ar.add(Card
																.getBoard()
																.getActivePlayer()
																.getField()
																.getMonstersArea()
																.get(l));

														if (z == 0)
															try {
																Card.getBoard()
																		.getActivePlayer()
																		.setMonster(
																				monster,
																				ar);
															} catch (
																	MultipleMonsterAdditionException
																	| WrongPhaseException
																	| NoMonsterSpaceException ex) {
																JOptionPane
																		.showMessageDialog(
																				null,
																				ex.getMessage());
															}
														if (z == 1)
															try {
																Card.getBoard()
																		.getActivePlayer()
																		.summonMonster(
																				monster,
																				ar);
															} catch (
																	MultipleMonsterAdditionException
																	| WrongPhaseException
																	| NoMonsterSpaceException ex) {
																JOptionPane
																		.showMessageDialog(
																				null,
																				ex.getMessage());
															}
														gui.update();

														}} else
														JOptionPane
																.showMessageDialog(
																		null,
																		"m3ak4 y2dy");
												}
											}
										}
									}
								}
							}
						} else if (s.getLocation() == Location.FIELD) {

							if ((location == gui.monsterarea1 && gui.p1 == Card
									.getBoard().getActivePlayer())
									|| (location == gui.monsterarea2 && gui.p2 == Card
											.getBoard().getActivePlayer())) {

								String[] x = {
										"MONSTER",
										"attackpoints:"
												+ ((MonsterCard) s)
														.getAttackPoints(),
										"defensepoints:"
												+ ""
												+ ((MonsterCard) s)
														.getDefensePoints(),
										"levl:" + ((MonsterCard) s).getLevel(),
										"Mode :" + ((MonsterCard) s).getMode() };

								JOptionPane j = new JOptionPane();
								int n = j.showConfirmDialog(null, x,
										"Do you want to attack with this monster? "
												+ "or change the mode",
										JOptionPane.YES_NO_OPTION);
								if (n == JOptionPane.YES_NO_OPTION) {
									boolean exist = false;
									if (Card.getBoard().getActivePlayer() == gui.p1
											&& location == gui.monsterarea1) {
										exist = true;
									}
									if (Card.getBoard().getActivePlayer() == gui.p2
											&& location == gui.monsterarea2) {
										exist = true;
									}

									if (exist) {
										Object[] options = { "change the mode",
												"attack your opponent" };
										int l = JOptionPane
												.showOptionDialog(
														null,
														"Mode :"
																+ monster
																		.getMode()
																+ " Would you like to change the mode of this monster?",
														" ",
														JOptionPane.YES_NO_OPTION,
														JOptionPane.QUESTION_MESSAGE,
														null, options,
														options[0]);
										if (l == 0) {
											try{
											Card.getBoard().getActivePlayer()
													.switchMonsterMode(s);}
catch(WrongPhaseException ex)
											{
	                                           JOptionPane.showMessageDialog(null, ex.getMessage());
											}
											if (monster.getMode() == Mode.ATTACK)
												setText(monster.getName());
											else
												setText("Set");

										} else {
											if (Card.getBoard()
													.getOpponentPlayer()
													.getField()
													.getMonstersArea().size() == 0) {
												try {
													Card.getBoard()
															.getActivePlayer()
															.declareAttack(
																	monster);
												} catch (
														MonsterMultipleAttackException
														| WrongPhaseException
														| DefenseMonsterAttackException ex) {
													JOptionPane
															.showMessageDialog(
																	null,
																	ex.getMessage());
												}
												gui.player1lifepoints
														.setText(""
																+ gui.p1.getLifePoints());
												gui.player2lifepoints
														.setText(""
																+ gui.p2.getLifePoints());
											} else {
												String[] choices = new String[Card
														.getBoard()
														.getOpponentPlayer()
														.getField()
														.getMonstersArea()
														.size()];
												for (int i = 0; i < choices.length; i++) {
													if (Card.getBoard()
															.getOpponentPlayer()
															.getField()
															.getMonstersArea()
															.get(i).getMode() == Mode.ATTACK)
														choices[i] = Card
																.getBoard()
																.getOpponentPlayer()
																.getField()
																.getMonstersArea()
																.get(i)
																.getName();
													else
														choices[i] = "Set";
												}
												int z = JOptionPane
														.showOptionDialog(
																null,
																"please choose one monster to attack it",
																" ",
																JOptionPane.YES_NO_OPTION,
																JOptionPane.QUESTION_MESSAGE,
																null, choices,
																choices[0]);
												for (int i = 0; i < choices.length; i++) {
													if (z == i)
														try {
															Card.getBoard()
																	.getActivePlayer()
																	.declareAttack(
																			monster,
																			Card.getBoard()
																					.getOpponentPlayer()
																					.getField()
																					.getMonstersArea()
																					.get(i));
														} catch (
																MonsterMultipleAttackException
																| WrongPhaseException
																| DefenseMonsterAttackException ex) {
															JOptionPane
																	.showMessageDialog(
																			null,
																			ex.getMessage());
														}
												}
												gui.update();
												gui.player1lifepoints
														.setText(""
																+ gui.p1.getLifePoints());
												gui.player2lifepoints
														.setText(""
																+ gui.p2.getLifePoints());

											}
										}
									}
								}

							}

						} else {
							if (monster.getLocation() == Location.GRAVEYARD) {
								String[] x = {
										"MONSTER",
										"attackpoints:"
												+ ((MonsterCard) s)
														.getAttackPoints(),
										"defensepoints:"
												+ ""
												+ ((MonsterCard) s)
														.getDefensePoints(),
										"levl:" + ((MonsterCard) s).getLevel() };
								JOptionPane.showMessageDialog(null, x);
							}

						}
					}
					if (Card.getBoard().getWinner() != null) {
						gui.setVisible(false);
						winner w = new winner(Card.getBoard().getWinner()
								.getName());
						w.setVisible(true);
					}
				}

			});
		} catch (DefenseMonsterAttackException | WrongPhaseException
				| MonsterMultipleAttackException | NoMonsterSpaceException
				| MultipleMonsterAdditionException ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage());
		}
	}
}