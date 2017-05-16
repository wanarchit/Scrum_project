package scrum.noyau;

import java.util.*;

public class Specie {
  /**
   * Name of the specie
   */
  private String name;

  public Specie(String n) {
	name = n;
  }

  public final String getName() {
    return name;
  }
  
  public String toString(){
        return getName();
  }

}
