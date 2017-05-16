package scrum.noyau;

import java.util.*;

public abstract class Analysis {
  /**
   * The specie on which the analysis is defined
   */
  private Specie specie;

  /**
   * Name of the analysis
   * 
   * @return the name of the analysis
   */
  public abstract String getName() ;

  public abstract Result newResult() ;

  public final Specie getSpecie() {
    return specie;
  }
  
  public final String toString(){
	  return getName();
  }

  public Analysis(Specie s) {
	specie = s;
  }

}
