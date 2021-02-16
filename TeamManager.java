//Derek Yin 113251504 Recitation Section 1
/** This class is used to manage a maximum of 5 teams.
*
*
*/
import java.util.Scanner;
public class TeamManager{
/** This integer MAX_TEAMS represents the maximum amount of teams a user can manage
*
*/
  public static final int MAX_TEAMS = 5;
  private Team[] teams;

/** This method displays a menu in the terminal.
*
* Firstly, this method creates an array of Teams and stores MAX_TEAMS teams in it.
* While the menu is "running", many options are displayed to the user.
*
*/
  public static void main(String[] args){
    Team[] teams = new Team[MAX_TEAMS];
    for (int i = 0; i < MAX_TEAMS; i++){
      teams[i] = new Team();
    }
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
  int hits = 0;
  if (in.hasNextInt()){
    hits = in.nextInt();
    if (hits > 0){
      newPlayer.setNumHits(hits);
    }
    System.out.println("Enter the number of errors:");
    int errors = 0;
    if (in.hasNextInt()){
      errors = in.nextInt();
      if (errors > 0){
        newPlayer.setNumErrors(errors);
    }
    System.out.println("Enter the position:");
    int position = 0;
    if (in.hasNextInt()){
      position = in.nextInt();
      if (position > 0 && position <= teams[currentTeam].size()+1){
        try{
        teams[currentTeam].addPlayer(newPlayer, position);
        System.out.println("Player added: " + name + " - " + hits + " hits, " + errors + " errors");
      }
      catch (FullTeamException e){}
      }
      else {
        System.out.println("Invalid position");
        isRunning = false;
        isRunning = true;
      }
    }
    else {
      System.out.println("Invalid input.");
      isRunning = false;
      isRunning = true;
    }
  }
  else {
    System.out.println("Invalid input.");
    isRunning = false;
    isRunning = true;
  }
}
else {
  System.out.println("Invalid input.");
  isRunning = false;
  isRunning = true;
}
}


if (s.equals("G") || s.equals("g")){
  System.out.println("Enter the position:");
  if (in.hasNextInt()){
  int position = in.nextInt();
  if (position <= teams[currentTeam].size() && position > 0){
    System.out.println(teams[currentTeam].getPlayer(position).getName() + " - " + teams[currentTeam].getPlayer(position).getNumHits() + " hits, " + teams[currentTeam].getPlayer(position).getNumErrors() + " errors");
  }
  else {
    System.out.println("Invalid position");
    isRunning = false;
    isRunning = true;
  }
}
else {
  System.out.println("Invalid input");
  isRunning = false;
  isRunning = true;
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
  if (!stat.equals("errors") && !stat.equals("Errors") && !stat.equals("hits") && !stat.equals("Hits")){
    System.out.println("Invalid input.");
    isRunning = false;
    isRunning = true;
  }
}

if (s.equals("R") || s.equals("r")){
  System.out.println("Enter the position:");
  if (in.hasNextInt()){
  int position = in.nextInt();
  if (position > 0 && position <= teams[currentTeam].size()){
    Player temp = teams[currentTeam].getPlayer(position);
    teams[currentTeam].removePlayer(position);
    System.out.println("Player Removed at position " + position + "\n");
    System.out.println(temp.getName() + " has been removed from the team.");
  }
  else {
    System.out.println("Invalid position");
    isRunning = false;
    isRunning = true;
  }
}
else {
  System.out.println("Invalid input");
  isRunning = false;
  isRunning = true;
}
}

if (s.equals("P") || s.equals("p")){
  System.out.println("Select Team Index:");
  if (in.hasNextInt()){
    int index = in.nextInt();
    if (index > 0 && index <= MAX_TEAMS){
    teams[index-1].printAllPlayers();
  }
  else {
    System.out.println("Invalid index");
    isRunning = false;
    isRunning = true;
  }
}
else {
  System.out.println("Invalid input");
  isRunning = false;
  isRunning = true;
}
}

if (s.equals("S") || s.equals("s")){
  System.out.println("There are " + teams[currentTeam].size() + " player(s) in the current Team.");
}

if (s.equals("T") || s.equals("t")){
  System.out.println("Enter team index to select:");
  if (in.hasNextInt()){
    int index = in.nextInt();
    if (index > 0 && index <= MAX_TEAMS){
    currentTeam = index - 1;
  }
  else {
    System.out.println("Invalid index");
    isRunning = false;
    isRunning = true;
  }
  }
  else {
    System.out.println("Invalid input");
    isRunning = false;
    isRunning = true;
  }
}

if (s.equals("C") || s.equals("c")){
  System.out.println("Select team to clone from:");
  if (in.hasNextInt()){
    int fromTeam = in.nextInt();
    if (fromTeam > 0 && fromTeam <= MAX_TEAMS){
      System.out.println("Select team to clone to:");
      if (in.hasNextInt()){
        int toTeam = in.nextInt();
        if (toTeam > 0 && toTeam <= MAX_TEAMS){
          teams[toTeam-1] = (Team) teams[fromTeam-1].clone();
          System.out.println("Team " + fromTeam + " has been cloned to Team " + toTeam + ".");
        }
        else {
          System.out.println("Invalid team index");
          isRunning = false;
          isRunning = true;
        }
      }
      else {
        System.out.println("Invalid input");
        isRunning = false;
        isRunning = true;
      }
    }
    else {
      System.out.println("Invalid team index");
      isRunning = false;
      isRunning = true;
    }
  }
  else {
    System.out.println("Invalid input");
    isRunning = false;
    isRunning = true;
  }
}

if (s.equals("E") || s.equals("e")){
  System.out.println("Select first team index:");
  if (in.hasNextInt()){
    int index1 = in.nextInt();
    if (index1 > 0 && index1 <= MAX_TEAMS){
      System.out.println("Select second team index:");
      if (in.hasNextInt()){
        int index2 = in.nextInt();
        if (index2 > 0 && index2 <= MAX_TEAMS){
          if (teams[index1-1].equals(teams[index2-1])){
            System.out.println("These teams are equal.");
          }
          else System.out.println("These teams are not equal.");
        }
        else {
          System.out.println("Invalid index");
          isRunning = false;
          isRunning = true;
        }
      }
      else {
        System.out.println("Invalid input");
        isRunning = false;
        isRunning = true;
      }
    }
    else {
      System.out.println("Invalid index");
      isRunning = false;
      isRunning = true;
    }
  }
  else {
    System.out.println("Invalid input");
    isRunning = false;
    isRunning = true;
  }
}


if (s.equals("U") || s.equals("u")){
  System.out.println("Enter the player to update:");
  String name = in.nextLine();
  System.out.println("Enter the stat to update:");
  String stat = in.nextLine();
  if (stat.equals("hits")){
    boolean validName = false;
    System.out.println("Enter the new number of hits:");
    if (in.hasNextInt()){
      int hits = in.nextInt();
      if (hits > 0){
        for (int i = 1; i <= teams[currentTeam].size(); i++){
          if (name.equals(teams[currentTeam].getPlayer(i).getName())){
            teams[currentTeam].getPlayer(i).setNumHits(hits);
            validName = true;
          }
        }
      }
      else {
        System.out.println("Invalid number of hits");
        isRunning = false;
        isRunning = true;
      }
      if (validName){
        System.out.println("Updated " + name + " hits.");
      }
      else {
        System.out.println("Invalid input.");
        isRunning = false;
        isRunning = true;
      }
    }
    else {
      System.out.println("Invalid input.");
      isRunning = false;
      isRunning = true;
    }
    }
if (stat.equals("errors")){
  boolean validName = false;
  System.out.println("Enter the new number of errors:");
  if (in.hasNextInt()){
    int errors = in.nextInt();
    if (errors > 0){
      for (int i = 1; i <= teams[currentTeam].size(); i++){
        if (name.equals(teams[currentTeam].getPlayer(i).getName())){
          teams[currentTeam].getPlayer(i).setNumErrors(errors);
          validName = true;
        }
      }
      if (validName){
        System.out.println("Updated " + name + " hits.");
      }
    }
    else {
      System.out.println("Invalid input.");
      isRunning = false;
      isRunning = true;
    }
  }
  else {
    System.out.println("Invalid input.");
    isRunning = false;
    isRunning = true;
  }
  }
if (!stat.equals("errors") && !stat.equals("hits")){
  System.out.println("Invalid stat.");
  isRunning = false;
  isRunning = true;
}
}
}



  }
}
