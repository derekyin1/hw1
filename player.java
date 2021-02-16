/** Derek Yin 113251504 Recitation Section 1
* This class represents the Player object
* Each player has an associated name, number of hits, and number of errors
*
* @author
* Derek Yin
*/
public class Player{
  private String name;
  private int numHits;
  private int numErrors;


/** This is a constructor used to create a new Player object
*
*/
  public Player(){

  }

/** This is a method used to get the name of a Player
* @return
* The name of the Player
*/
  public String getName(){
    return name;
  }
/** This is a method used to get the number of hits of a Player
* @return
* The number of hits of the Player
*/
  public int getNumHits(){
    return numHits;
  }
/** This method is used to get the number of errors of a Player
* @return
* The number of errors of a Player
*
*/
  public int getNumErrors(){
    return numErrors;
  }
/** This method is used to set the Name of a Player
* @param name1
* The name of the player
*
*/
  public void setName(String name1){
    name = name1;
  }
/** This method is used to set the number of hits of a Player
*
* @param numHits1
* The number of hits of the player
*
* @throws IllegalArgumentException
* when the number is negative
*/
  public void setNumHits(int numHits1){
    if (numHits1 < 0){
      throw new IllegalArgumentException("Invalid number");
    }
    numHits = numHits1;
  }
/** This method is used to set the number of errors of a player
*
* @param numErrors1
* The number of errors of the player
*
* @throws IllegalArgumentException
* when the number is negative
*/
  public void setNumErrors(int numErrors1){
    if (numErrors1 < 0){
      throw new IllegalArgumentException("Invalid number");
    }
    numErrors = numErrors1;
  }
/** This method compares two Players and sees if they are equals
*
* @param obj
* the object that the player will be compared to
*
* @return
* true if the players are equal, false if they are not
*/
  public boolean equals(Object obj){
  if (obj instanceof Player){
    Player p = (Player) obj;
    return this.getNumHits() == p.getNumHits() && this.getNumErrors() == p.getNumErrors() && this.getName().equals(p.getName());
  }
  return false;
  }
/** This method converts a Player's name, hits, and errors into a String
*
* @return
* Player's name, hits, and errors as a String
*
*/
  public String toString(){
    return name + ", " + String.valueOf(numHits) + ", " + String.valueOf(numErrors);
  }

}
