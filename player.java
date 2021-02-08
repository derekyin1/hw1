public class Player{
private String name;
private int numHits;
private int numErrors;

public Player(){

}

public String getName(){
  return name;
}

public int getNumHits(){
  return numHits;
}

public int numErrors(){
  return numErrors;
}

public void setName(String name1){
  name = name1;
}

public void setNumHits(int numHits1){
  if (numHits1 < 0){
    throw new IllegalArgumentException();
  }
  numHits = numHits1;
}

public void setNumErrors(int numErrors1){
  if (numErrors1 < 0){
    throw new IllegalArgumentException();
  }
  numErrors = numErrors1;
}

public String toString(){
  return "name, numHits, numErrors";
}

}
