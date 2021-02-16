//Derek Yin 113251504 Recitation Section 1
/** This class represents a team, which stores Players.
*
*/
public class Team{
/** MAX_PLAYERS represents maximum amount of players in a TeamManager
*
*/

  public static final int MAX_PLAYERS = 40;
  private int pCount;
  private Player[] players;

/** This is a constructor that creates a new Team
*
*/
  public Team(){
    players = new Player[MAX_PLAYERS];
    pCount = 0;
  }
/** This is a method that creates a clone of a Team
*
* @return
* returns clone of team
*
* @throws
* FullTeamException when team is full
*/
  public Object clone() {
    Team copy = new Team();
    for (int i = 1; i <= this.size(); i++){
      try{
        copy.addPlayer(this.getPlayer(i),i);
      }
      catch (FullTeamException e){

      }
    }
    return copy;
  }
/** This is a method that compares an object to a Team and sees if they are equal
*
* @param obj
* This is the object that the Team will be compared to
*
* @return
* returns true if the two teams are equal, false if they are not
*/
  public boolean equals(Object obj){
  if (obj instanceof Team){
    Team p = (Team) obj;
    if (p.size() == pCount){
    for (int i = 0; i < pCount; i++){
      if (!(p.getPlayer(i+1).equals(players[i]))){
        return false;
      }
    }
    return true;
  }
  return false;
  }
  return false;
  }
/** This method finds the size of the Team
*
* @return
* returns the size of the Team
*
*/
  public int size(){
    return pCount;
  }
/** This method adds a Player to a Team
*
* @param p
* The Player to be added
*
* @param position
* the position in the Team that the Player will be
*
* @throws FullTeamException
* when team is full
*
* @throws IllegalArgumentException
* when the position is negative or invalid
*/
  public void addPlayer(Player p, int position) throws FullTeamException{
    if (position >= 1 && position <= pCount+1){
      if (position <= MAX_PLAYERS){
        for (int i = pCount-1; i >= position-1; i--){
         players[i+1] = players[i];
       }
       players[position-1] = p;
       pCount++;
     }
   }
   else throw new IllegalArgumentException("Invalid position.");

  }
/** This method removes a player from a Team
*
* @param position
* The position of the player to be removed
*
* @throws IllegalArgumentException
* when position is negative or invalid
*/
  public void removePlayer(int position){
    if (position >= 1 && position <= pCount){
      for (int i = position; i < pCount; i++){
         players[i-1] = players[i];
       }
       players[pCount-1] = null;
       pCount--;
     }
    else throw new IllegalArgumentException("Invalid position.");
  }
/** This method gets the player from a certain position in the team
*
* @param position
* This is the position of the desired player
*
* @return
* Returns desired player
*
* @throws IllegalArgumentException
* when position is invalid
*/
  public Player getPlayer(int position){
    if (position > pCount || position-1 < 0){
      throw new IllegalArgumentException("Invalid position.");
    }
    else return players[position-1];

  }
/** This method gets the leader of a Team in designated stat
*
* @param stat
* Indicates the desired stat, hits or errors
*
* @return
* Returns the Player in the team which is the Leader in the designated stat
*
* @throws IllegalArgumentException
* when stat is neither "hits" nor "errors", invalid stat
*/
  public Player getLeader(String stat){
    if (stat.equals("hits")){
      Player currentBest = players[0];
      for (int i = 0; i < pCount; i++){
        if (players[i].getNumHits() > currentBest.getNumHits()){
          currentBest = players[i];
        }
      }
      return currentBest;
    }
    if (stat.equals("errors")){
      Player currentBest = players[0];
      for (int i = 0; i < pCount; i++){
        if (players[i].getNumErrors() < currentBest.getNumErrors()){
          currentBest = players[i];
        }
      }
      return currentBest;
    }
    else throw new IllegalArgumentException("No such statistic.");

  }


/** This method prints out the players of the team in a formatted table
*
*/
  public void printAllPlayers(){
    System.out.print(this.toString());
  }
/** This method compiles the players and stats of a team into a formatted string
*
* @return
* Returns an organized, formatted String to be printed in the terminal
*
*/
  public String toString(){
    String finalString = "";
    finalString += String.format("%-21s%-26s%-19s%6s", "Player#", "Name", "Hits", "Errors");
    finalString += String.format("\n-------------------------------------------------------------------------\n");
    for (int i = 1; i <= pCount; i++){
      finalString += String.format("%-21d%-26s%-19d%6s", i, this.getPlayer(i).getName(), this.getPlayer(i).getNumHits(), this.getPlayer(i).getNumErrors() + "\n");
    }
return finalString;
  }

public static void main(String[] args) {
  Team test = new Team();
  Player tester = new Player();
  tester.setName("James");
  tester.setNumHits(10);
  tester.setNumErrors(10);
  try{
  test.addPlayer(tester, 1);
} catch (FullTeamException e){}
  System.out.println(test.clone().toString());
}
}
