package scrum.Interface.TableRenderer;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import scrum.noyau.Customer;
import scrum.noyau.Order;
import scrum.noyau.Sample;

public class OrderTable extends AbstractTableModel {

	private ArrayList<Order> donnees;
	private Customer customer;
	private final String[] entetes = {"Customer", "Status", "Number of analyzed sample", "Number of not analyzed sample"}; // La liste des en-tête de la table

	public OrderTable(Customer customer) {
		super();
		this.customer = customer;
		this.donnees = new ArrayList<Order>();
		initDonnees();
	}

	private void initDonnees() {
		if(!donnees.isEmpty())
			donnees.removeAll(donnees);
		for (Order cl : customer.getOrders()) {
			donnees.add(cl);
		}
		reload();
	}

	/**
	 * Permet de recharger la table
	 */
	public void reload(){
		fireTableDataChanged();
	}

	/**
	 * Permet de récupérer le nombre de ligne de la table
	 */
	public int getRowCount() {
		return donnees.size();
	}

	/**
	 * Permet de récupérer le nombre de colonne
	 */
	public int getColumnCount() {
		return entetes.length;
	}

	/**
	 * Permet de récupérer le nom d'une colonne
	 */
	public String getColumnName(int columnIndex) {
		return entetes[columnIndex];
	}

	/**
	 * Permet de récupérer la valeur d'une case donnée
	 */
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch(columnIndex){
		case 0:
			return "Order "+donnees.get(rowIndex).getId();
		case 1:
			return donnees.get(rowIndex).getStatus();
		case 2:
			int numAnalyzed = 0;
			if(donnees.get(rowIndex).getSamples() == null)
				return numAnalyzed;
			else{
				for (Sample sample : donnees.get(rowIndex).getSamples()) {
					if(sample.isCompleted())
						numAnalyzed++;
				}
			}
			return numAnalyzed;
		case 3:
			int numNotAnalyzed = 0;
			if(donnees.get(rowIndex).getSamples() == null)
				return numNotAnalyzed;
			else{
				for (Sample sample : donnees.get(rowIndex).getSamples()) {
					if(!sample.isCompleted())
						numNotAnalyzed++;
				}
			}
			return numNotAnalyzed;
		default:
			return null; //Ne devrait jamais arriver
		}
	}

	/**
	 * Permet de savoir si une cellule est modifiable
	 */
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}

	/**
	 * Permet de modifier la valeur d'une cellule
	 */
	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
	}

	/**
	 * Permet de connaitre la classe d'objet d'une colonne donné
	 */
	@Override
	public Class getColumnClass(int columnIndex){
		return getValueAt(0, columnIndex).getClass();
	}

	/**
	 * Permet de récupérer l'objet d'une ligne
	 * @param rowIndex La ligne dont on souhaite l'objet
	 * @return L'élève de la ligne donnée
	 */
	public Order getOrderRow(int rowIndex){
		return donnees.get(rowIndex);
	}

}
