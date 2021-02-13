//Derek Yin 113251504 Recitation Section 1
public class Team{
  public static final int MAX_PLAYERS = 40;
  private int pCount;
  private Player[] players;

  public Team(){
    players = new Player[MAX_PLAYERS];
    pCount = 0;
  }

  public Object clone(){
    Object copy = new Team();
    for (int i = 0; i < pCount; i++){


    }
    return copy;
  }

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

  public int size(){
    int counter = 2;
    for (int i=0; i < MAX_PLAYERS; i++){
    //  if ()

    }
    return counter;
  }

  public void addPlayer(Player p, int position){
    if (position >= 1 && position <= pCount+1){
      if(position < MAX_PLAYERS){
        for (int i = pCount-1; i >= position-1; i--){
         players[i+1] = players[i];
       }
       players[position-1] = p;
       pCount++;
     }
     //else throw new FullTeamException("Team is full");
   }
   else throw new IllegalArgumentException("Invalid position.");

  }

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

  public Player getPlayer(int position){
    if (position > pCount || position-1 < 0){
      throw new IllegalArgumentException("Invalid position");
    }
    else return players[position-1];

  }

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

  /*public void printAllPlayers(){
    System.out.printf("%-21s%-26s%-19s%6s", "Player#", "Name", "Hits", "Errors");
    System.out.printf("\n-------------------------------------------------------------------------\n");
    for (int i = 1; i <= pCount; i++){
      System.out.printf("%-21d%-26s%-19d%6s", i, this.getPlayer(i).getName(), this.getPlayer(i).getNumHits(), this.getPlayer(i).getNumErrors() + "\n");
    }
  }
*/

  public void printAllPlayers(){
    System.out.print(this.toString());
  }
  
  public String toString(){
    String finalString = "";
    finalString += String.format("%-21s%-26s%-19s%6s", "Player#", "Name", "Hits", "Errors");
    finalString += String.format("\n-------------------------------------------------------------------------\n");
    for (int i = 1; i <= pCount; i++){
      finalString += String.format("%-21d%-26s%-19d%6s", i, this.getPlayer(i).getName(), this.getPlayer(i).getNumHits(), this.getPlayer(i).getNumErrors() + "\n");
    }
return finalString;
  }
public static void main(String[] args){
  Team t1 = new Team();
  Team t2 = new Team();
  Player p = new Player("Jose", 10, 10);
  Player p2 = new Player("Derek", 20, 1);
  Player p3 = new Player("Avery", 10, 10);
  t1.addPlayer(p, 1);
  t1.addPlayer(p2, 1);
  t1.removePlayer(1);
  t2.addPlayer(p, 1);
  t2.addPlayer(p2, 1);
  t2.addPlayer(p3, 2);
  System.out.println(t1.getPlayer(1));
//  System.out.println(t1.getPlayer(2));
  System.out.println(t2.getPlayer(1));
  System.out.println(t2.getPlayer(2));
  System.out.println(t2.getLeader("errors").toString());
  System.out.println(t1.equals(t2));
  t2.printAllPlayers();
  System.out.println(t2.toString());
}

}
