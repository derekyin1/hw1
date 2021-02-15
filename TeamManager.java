//Derek Yin 113251504 Recitation Section 1
import java.util.Scanner;

public class TeamManager{
  public static final int MAX_TEAMS = 5;
  private Team[] teams;

  public static void startMenu(){

  }

  public static void main(String[] args){
    Team[] teams = new Team[5];
    Team team1 = new Team();
    Team team2 = new Team();
    Team team3 = new Team();
    Team team4 = new Team();
    Team team5 = new Team();
    teams[0] = team1;
    teams[1] = team2;
    teams[2] = team3;
    teams[3] = team4;
    teams[4] = team5;
    int currentTeam = 0;
    System.out.println("Welcome to Team Manager! \n ");
    boolean isRunning = true;
//menu
while(isRunning){
  System.out.println("Team " + (currentTeam+1) + " is currently selected.");
System.out.print("\nPlease select an option: \n A) Add Player. \n G) Get Player stats. \n L) Get leader in a stat. \n R) Remove a player. \n P) Print all players. \n S) Size of team. \n T) Select team. \n C) Clone team. \n E) Team equals. \n U) Update stat. \n Q) Quit. \n");
Scanner in = new Scanner(System.in);
String s = in.nextLine();
if (s.equals("Q") || s.equals("q")){
  System.out.println("Program terminating normally...");
  isRunning = false;
}
if (s.equals("A") || s.equals("a")){
  Player newPlayer = new Player();
  System.out.println("Enter the player's name:");
  String name = in.nextLine();
  newPlayer.setName(name);
  System.out.println("Enter the number of hits:");
  int hits = in.nextInt();
  newPlayer.setNumHits(hits);
  System.out.println("Enter the number of errors:");
  int errors = in.nextInt();
  newPlayer.setNumErrors(errors);
  System.out.println("Enter the position:");
  int position = in.nextInt();
  teams[currentTeam].addPlayer(newPlayer, position);
  System.out.println("Player added: " + name + " - " + hits + " hits, " + errors + " errors");
}

if (s.equals("G") || s.equals("g")){
  System.out.println("Enter the position:");
  int position = in.nextInt();
  if (position <= teams[currentTeam].size()){
    System.out.println(teams[currentTeam].getPlayer(position).getName() + " - " + teams[currentTeam].getPlayer(position).getNumHits() + " hits, " + teams[currentTeam].getPlayer(position).getNumErrors() + " errors");
  }
}
if (s.equals("L") || s.equals("l")){
  System.out.println("Enter the stat: ");
  String stat = in.nextLine();
  if (stat.equals("hits") || stat.equals("Hits")){
    System.out.println("Leader in hits: " + teams[currentTeam].getLeader("hits").getName() + " - " + teams[currentTeam].getLeader("hits").getNumHits() + " hits, " + teams[currentTeam].getLeader("hits").getNumErrors() + " errors");
  }
  if (stat.equals("errors") || stat.equals("Errors")){
    System.out.println("Leader in errors: " + teams[currentTeam].getLeader("errors").getName() + " - " + teams[currentTeam].getLeader("errors").getNumHits() + " hits, " + teams[currentTeam].getLeader("errors").getNumErrors() + " errors");
  }
  //else System.out.println("Input error.");
}

if (s.equals("R") || s.equals("r")){
  System.out.println("Enter the position:");
  int position = in.nextInt();
  Player temp = teams[currentTeam].getPlayer(position);
  teams[currentTeam].removePlayer(position);
  System.out.println("Player Removed at position " + position + "\n");
  System.out.println(temp.getName() + " has been removed from the team.");
}

if (s.equals("P") || s.equals("p")){
  System.out.println("Select Team Index:");
  int index = in.nextInt();
  teams[currentTeam].printAllPlayers();
}

if (s.equals("S") || s.equals("s")){
  System.out.println("There are " + teams[currentTeam].size() + " player(s) in the current Team.");
}

if (s.equals("T") || s.equals("t")){
  System.out.println("Enter team index to select:");
  int index = in.nextInt();
  currentTeam = index - 1;
}

if (s.equals("C") || s.equals("c")){
  System.out.println("Select team to clone from:");
  int fromTeam = in.nextInt();
  System.out.println("Select team to clone to:");
  int toTeam = in.nextInt();
  teams[toTeam-1] = (Team) teams[fromTeam-1].clone();
  System.out.println("Team " + fromTeam + " has been cloned to Team " + toTeam + ".");
}

if (s.equals("E") || s.equals("e")){
  System.out.println("Select first team index:");
  int index1 = in.nextInt();
  System.out.println("Select second team index:");
  int index2 = in.nextInt();
  if (teams[index1-1].equals(teams[index2-1])){
    System.out.println("These teams are equal.");
  }
  else System.out.println("These teams are not equal.");

}

if (s.equals("U") || s.equals("u")){
  System.out.println("Enter the player to update:");
  String name = in.nextLine();
  System.out.println("Enter the stat to update:");
  String stat = in.nextLine();
  if (stat.equals("hits")){
    System.out.println("Enter the new number of hits:");
    int hits = in.nextInt();
  for (int i = 1; i <= teams[currentTeam].size(); i++){
    if (name.equals(teams[currentTeam].getPlayer(i).getName())){
      teams[currentTeam].getPlayer(i).setNumHits(hits);
    }
  }
}
if (stat.equals("errors")){
  System.out.println("Enter the new number of errors:");
  int errors = in.nextInt();
for (int i = 1; i <= teams[currentTeam].size(); i++){
  if (name.equals(teams[currentTeam].getPlayer(i).getName())){
    teams[currentTeam].getPlayer(i).setNumErrors(errors);
  }
}
}
//else System.out.println("Input Error.");
}
}



  }
}
