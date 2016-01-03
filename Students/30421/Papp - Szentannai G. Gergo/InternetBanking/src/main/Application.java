package main;

import javax.swing.SwingUtilities;

import db.manager.DatabaseConnect;
import gui.MainFrame;

public class Application {

	public static MainFrame mainFrame;

	public Application() {

		// I could have put this inside the Main class too...

		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				mainFrame = new MainFrame();
			}
		});

		// Connect to database:
		// Reconnection/changing connection will be possible using the Settings
		// panel (not yet finished)
		@SuppressWarnings("unused")
		DatabaseConnect databaseConnect = new DatabaseConnect();
	}

}
