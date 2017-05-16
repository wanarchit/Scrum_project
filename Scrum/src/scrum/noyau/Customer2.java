package scrum.noyau;

public class Customer2 extends Customer{
	
	public Customer2(String n, String t){
		super(n,t);
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

}
