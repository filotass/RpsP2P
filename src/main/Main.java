package main;

import gui.StartForm;
import gui.Utils;

public class Main {

	public static void main(String[] args) {
		StartForm st = new StartForm();
                Utils.centralize(st);
                st.setVisible(true);
	}

}
