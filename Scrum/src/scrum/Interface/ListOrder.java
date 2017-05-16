package scrum.Interface;

import java.awt.GridLayout;
import java.net.URL;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import scrum.Interface.TableRenderer.OrderTable;
import scrum.Interface.TableRenderer.OrderTableCellRenderer;
import scrum.noyau.Customer;
import scrum.noyau.OrderStatus;

public class ListOrder extends JFrame{
	
	private Customer customer;
	private OrderTable modeleTable;
	private JTable tableOrders;
	
	public ListOrder(Customer customer){
		this.pack();
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Orders list of "+customer.getName()+" from "+customer.getTown());
		this.customer = customer;
		this.setLayout(new GridLayout());
		initComposant();
	}
	
	/**
	 * Permet l'initialisation des composants du JPanel
	 */
	private void initComposant() {
		modeleTable = new OrderTable(customer);
		initJTable();
		this.add(new JScrollPane(tableOrders));
	}
	
	/**
	 * Permet d'initialiser la JTable
	 */
	private void initJTable(){
		this.tableOrders = new JTable(modeleTable);
		tableOrders.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableOrders.setRowHeight(80);
		tableOrders.setDefaultRenderer(OrderStatus.class, new OrderTableCellRenderer());
	}

}
