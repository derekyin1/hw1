public class Team{
  public static final int MAX_PLAYERS = 40;
  private Player[] players;

  public Team(){
players = new Player[MAX_PLAYERS];
  }

  public Object clone(){
Player[] clone = new Player[MAX_PLAYERS];
for (int i = 0; i < MAX_PLAYERS; i++){
  clone[i] = players[i];
}
return (Object) clone;
}

  public boolean equals(Object obj){
    for(int i = 0; i < MAX_PLAYERS; i++){
      if (obj[i].getName().equals(players[i].getName())){
        if ((obj[i].getNumHits() != players[i].getNumHits()) || (obj[i].getNumErrors() != players[i].getNumErrors())){
          return false;
        }
      }
    }
return true;
  }

  public int size(){
return 0;
  }

  public void addPlayer(Player p, int position){

  }

  public void removePlayer(int position){

  }

  //public Player getPlayer(int position){

//  }

  //public Player getLeader(String stat){

  //}

  public void printAllPlayers(){

  }

//  public String toString(){

//  }


}
