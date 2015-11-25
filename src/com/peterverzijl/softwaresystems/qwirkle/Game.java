package com.peterverzijl.softwaresystems.qwirkle;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import com.peterverzijl.softwaresystems.qwirkle.gameengine.Input;

/**
 * Master class for the game, this handles the setting up and running of the game
 * @author Peter Verzijl
 *
 */
public class Game {
	
	BlockBag bag;
	
	List<Player> players = new ArrayList<Player>();
	
	/**
	 * Function gets called on startup once
	 */
	public void start() {
		System.out.println("The game has started, aw yeah!");
		System.out.println("Shuffeling bag of blocks...");
		bag = new BlockBag();
		
		// Create a bunch of players
		int playerCount = 4;
		for (int i = 0; i < playerCount; i++) {
			Player p = new Player();
			p.initHand(bag, 6);
			players.add(p);
		}
		
		// Print all players their blocks
		for (int j = 0; j < players.size(); j++) {
			System.out.print("Player " + j + "'s hand: ");
			for (int i = 0; i < players.get(0).getmHand().size(); i++)
			{
				Block b = players.get(j).getmHand().get(i);
				System.out.print(b.getColor().toString().charAt(0) + " " + BlockPrinter.getChar(b) + ", ");
			}
			System.out.println();			
		}
		
		// Print amount of left over blocks after players have drawn
		System.out.println(bag.blocks.size() + " blocks left in the bag.");	// Should be 84, and it is!!
	}

	/**
	 * Function gets called every frame
	 */
	public void tick() {
		System.out.println(Input.mousePosition.normalized().toString());
	}
}