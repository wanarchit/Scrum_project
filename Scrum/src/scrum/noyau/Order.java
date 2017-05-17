package scrum.noyau;

import java.util.*;

/**
 * Describes the orders for the customers
 */
public class Order {
  /**
   * link to the customer
   */
  private Customer customer;
  
  /**
   * List of samples to analyse
   */
  private List<Sample> samples;

  /**
   * Status of the order
   */
  private OrderStatus status = OrderStatus.inProgress;
  
  /**
   * Factory for unique ids
   */
  private static UniqueIdSample idFactory;

  /**
   * Id number for the sample.
   * The id must be unique.
   * It is assigned during sample creation
   */
  private int idOrder;

  /**
   * Constructor for the Order
   */
  public Order(Customer customer) {
        if (idFactory==null) idFactory = new UniqueIdSample();
	
	idOrder = idFactory.newNumber();
	this.customer = customer;
	status = OrderStatus.inProgress;
  }

  public int getId(){
      return idOrder;
  }

  public final OrderStatus getStatus() {
    return status;
  }

  public void setStatus(OrderStatus value) {
    status = value;
  }

  public final Customer getCustomer() {
    return customer;
  }

  public List<Sample> getSamples() {
	return samples;
  }

  public void setSamples(List<Sample> s) {
	samples = s;
	status = OrderStatus.toAnalyze;
  }

}
