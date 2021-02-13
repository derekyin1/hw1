import java.util.Scanner;

public class TeamManager{
  public static final int MAX_TEAMS = 5;
  private Team[] teams;

  public static void startMenu(){

  }

  public static void main(String[] args){
    Team userTeam = new Team();
    System.out.println("Welcome to Team Manager! \n ");
    System.out.println("Team 1 is currently selected. \n");
    boolean isRunning = true;
//menu
while(isRunning){
System.out.print("Please select an option: \n A) Add Player. \n G) Get Player stats. \n L) Get leader in a stat. \n R) Remove a player. \n P) Print a player. \n S) Size of team. \n T) Select team. \n C) Clone team. \n E) Team equals. \n U) Update stat. \n Q) Quit. \n");
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
  userTeam.addPlayer(newPlayer, position);
  System.out.println("Player added: " + name + " - " + hits + " hits, " + errors + " errors");
}
if (s.equals("G") || s.equals("g")){
  System.out.println("Enter the position:");
  int position = in.nextInt();
  if (position <= userTeam.size()){
    System.out.println(userTeam.getPlayer(position).getName() + " - " + userTeam.getPlayer(position).getNumHits() + " hits, " + userTeam.getPlayer(position).getNumErrors() + " errors");
  }
}
}
}



  }
