package monopoly;

import java.util.ArrayList;

/**
 * Represents a double linked list of game tiles.
 */
public abstract class Tile {
  // These are the only fields you need.
  private Tile next;
  private Tile prev;

  // a tile knows what objects (players) are currently on the tile, these are
  // never used for anything else than comparing object references
  // thus we can store them at the highest level of abstraction - as Object instances
  ArrayList<Object> playersOnTile;  

  protected Tile() {
    // the next and prev links should point to the object created
    // note that no complex logic like loops or if statements are needed and should not be used
    // work out the correct way of setting the links using object diagrams

    this.next = this; // Point to itself
    this.prev = this; // Point to itself

    playersOnTile = new ArrayList<>();
  }

  protected Tile(Tile prevTile) {
    // the object created should be inserted into the linked list as the next tile after prevTile
    // note that no complex logic like loops or if statements are needed and should not be used
    // work out the correct way of setting the links using object diagrams

    this.prev = prevTile; // Linking the new tile to the previous tile
    this.next = prevTile.next; // Pointing right after the previous tile

    prevTile.next.prev = this; // Inserting the new tile into the list after the previous tile
    prevTile.next = this; // Inserting the new tile into the list


    playersOnTile = new ArrayList<>();
  }

  public Tile getNext() {
    return next;
  }

  public Tile getPrev() {
    return prev;
  }

  /**
  * Checks if a player is on the tile.
  */
  public boolean isOnTile(Player player) {
    return playersOnTile.contains(player);
  }

  /**
  * Called when a player moves over a tile.
  */
  public abstract void visit(Player player);

  /**
  * Called when a player stops on a tile.
  * Subclasses need to call super if overridden.
  */
  public void stoppedOn(Player player) {
    playersOnTile.add(player);
  }

  /**
  * Called when a player moves away from the tile stopped on.
  * Subclasses need to call super if overridden.
  */
  public void startOn(Player player) {
    playersOnTile.remove(player);
  }

  /**
  * Called when a player wants to buy a tile.
  */
  public abstract boolean buy(Player player);
}
