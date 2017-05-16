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
   * Status of the order
   */
  private OrderStatus status = OrderStatus.inProgress;

  /**
   * Constructor for the Order
   */
  public Order(Customer customer) {
	this.customer = customer;
	status = OrderStatus.inProgress;
  }

  /**
   * List of samples to analyse
   */
  private List<Sample> samples;

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
