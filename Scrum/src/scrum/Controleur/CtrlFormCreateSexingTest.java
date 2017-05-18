package scrum.Controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import scrum.Interface.FormCreateSexingTest;

public class CtrlFormCreateSexingTest implements ActionListener{
	
	private FormCreateSexingTest formCreateSexingTest;

	public CtrlFormCreateSexingTest(FormCreateSexingTest formCreateSexingTest) {
		this.formCreateSexingTest = formCreateSexingTest;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(formCreateSexingTest.getButtonValid()))
			formCreateSexingTest.validation();
		else if(e.getSource().equals(formCreateSexingTest.getButtonReturn()))
			formCreateSexingTest.getMenu().afficheMenuValidator();
	}

}
