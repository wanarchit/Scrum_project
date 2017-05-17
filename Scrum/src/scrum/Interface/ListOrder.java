package scrum.Interface;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

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
		this.setSize(new Dimension(1000,750));
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
                tableOrders.setFont(new java.awt.Font(Font.DIALOG,Font.BOLD,20));
		tableOrders.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableOrders.setRowHeight(80);
		tableOrders.setDefaultRenderer(OrderStatus.class, new OrderTableCellRenderer());
		tableOrders.setDefaultRenderer(Integer.class, new OrderTableCellRenderer());
		tableOrders.setDefaultRenderer(String.class, new OrderTableCellRenderer());
	}

}
