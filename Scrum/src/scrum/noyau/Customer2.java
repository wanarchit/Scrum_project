package scrum.noyau;

public class Customer2 extends Customer{
    
    private String login;
    private String password;
	
        /**
         * Constructeur du client
         * @param n : customer name
         * @param t : customer password
         * @param log : customer login
         * @param passwrd : customer password
         */
	public Customer2(String n, String t, String log, String passwrd){
		super(n,t);
                login = log;
                password = passwrd;
	}
	
	/**
   * Adds an order for this customer if this order doesn't exist
   * 
   * @param theOrder the order to be added
   */
  public void addOrder(Order theOrder) {
	  if(!this.getOrders().contains(theOrder))
		  this.getOrders().add(theOrder);
  }
  
  
  public String toString(){
	  return this.getName()+" "+this.getTown();
  }
  
  public String getPassword(){
      return password;
  }
  
  public String getLogin(){
      return login;
  }

}
