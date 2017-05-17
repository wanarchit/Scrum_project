package scrum.Interface.TableRenderer;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

import scrum.noyau.OrderStatus;

public class OrderTableCellRenderer extends DefaultTableCellRenderer {
	
	public OrderTableCellRenderer() {
            super();
            setHorizontalAlignment(SwingConstants.CENTER);
	}
	
	/**
     * Permet la gestion de l'affichage de la cellule
     */
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        if(value instanceof OrderStatus){
        	if(OrderStatus.toAnalyze.equals(value)){
                    setText("To analyze");
                    setForeground(Color.BLACK);
                    setBackground(Color.ORANGE);
        	}
                else if (OrderStatus.inAnalysis.equals(value)) {
                    setText("In analysis");
                    setForeground(Color.BLACK);
                    setBackground(Color.YELLOW);
                }
        	else if (OrderStatus.completed.equals(value)) {
                    setText("Completed");
                    setForeground(Color.BLACK);
                    setBackground(Color.GREEN);
                }
        	else if(OrderStatus.inProgress.equals(value) ){
                    setText("In progress");
                    setForeground(Color.BLACK);
                    setBackground(Color.RED);
        	}
        }
        else if(column==2)
        	setForeground(Color.GREEN);
        else if(column==3)
        	setForeground(Color.RED);
        else
        	setForeground(Color.BLACK);
        return this;
    }

}
