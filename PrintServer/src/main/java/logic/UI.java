package logic;

public class UI {
	
	
	public void printOptions() {
		/*
		String options = "+--- MENU ------------------------------------------------------+\n"
					   + "│                                                               │"
					   + "│      See options(1)       Login / Logout(2)        Exit(3)    │"
					   + "│                                                               │"
					   + "+---COMMAND --------------DESCRIPTION---------------------------+"
					   + "│ print         │ prints file filename on the specified printer │"
					   + "│ queue         │ lists the print queue for a given printer     │"
					   + "│ topQueue      │ moves job to the top of the queue             │"
					   + "│ start         │ starts the print server                       │"
					   + "│ stop          │ stops the print se                            │"
					   + "│ restart       │ stops, clears and restart server              │"
					   + "│ status        │ prints status of printer                      │"
					   + ""
					   + ""
					   + "";
		*/
		
	    System.out.println("+--- MENU ------------------------------------------------------+");
	    System.out.println("'                                                               '");
	    System.out.println("'      See options(1)       Login / Logout(2)        Exit(3)    '");
	    System.out.println("'                                                               '");
	    System.out.println("+---COMMAND --------------DESCRIPTION---------------------------+");
	    System.out.println("' print         │ prints file filename on the specified printer '");
	    System.out.println("' queue         │ lists the print queue for a given printer     '");
	    System.out.println("' topQueue      │ moves job to the top of the queue             '");
	    System.out.println("' start         │ starts the print server                       '");
	    System.out.println("' stop          │ stops the print se                            '");
	    System.out.println("' restart       │ stops, clears and restart server              '");
	    System.out.println("' status        │ prints status of printer                      '");
	    System.out.println("' forgot        │ return users password                         '");
	    System.out.println("' exit          │ exits application                             '");
	    System.out.println("+---------------------------------------------------------------+");
	}
	

}
