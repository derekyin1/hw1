//Derek Yin 113251504 Recitation Section 1
public class Team{
  public static final int MAX_PLAYERS = 40;
  private int manyItems;
  private Player[] players;

  public Team(){
    players = new Player[MAX_PLAYERS];
    manyItems = 0;
  }

  public Object clone(){
    Object copy = new Team();
    for (int i = 0; i < manyItems; i++){


    }
  }

  public boolean equals(Object obj){
  if (obj instanceof Player){
    Player p = (Player) obj;
    return this.getNumHits() == p.getNumHits() && this.getNumErrors() == p.getNumErrors() && this.getName().equals(p.getName());
  }
  return false;
  }

  public int size(){
    return manyItems;
  }

  public void addPlayer(Player p, int position){


  }

  public void removePlayer(int position){

  }

  public Player getPlayer(int position){
    if (position > manyItems || position-1 < 0){
      throw new IllegalArgumentException("Invalid position");
    }
    else return players[position-1];

  }

  public Player getLeader(String stat){
    if (stat.equals("hits")){
      Player currentBest = players[0];
      for (int i = 0; i < manyItems; i++){
        if (players[i].getNumHits() > currentBest.getNumHits()){
          currentBest = players[i];
        }
      }
      return currentBest;
    }
    if (stat.equals("errors")){
      Player currentBest = players[0];
      for (int i = 0; i < manyItems; i++){
        if (players[i].getNumErrors() < currentBest.getNumErrors()){
          currentBest = players[i];
        }
      }
      return currentBest;
    }
    else throw IllegalArgumentException("No such statistic.");

  }

  public void printAllPlayers(){

  }

//  public String toString(){

//  }


}
