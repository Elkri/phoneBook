package phoneBook;

import java.io.IOException;
import java.sql.*;
import java.util.Scanner;

public class notebook {
    public static void main(String[] args) throws IOException, SQLException {

        noteManager noteControl = new noteManager();
        noteRecord bookMenu = new noteRecord();
        Scanner stdin = new Scanner(System.in);

        // Menu call
        bookMenu.menu();

        int menuOption;
        menuOption = stdin.nextInt();
        while (menuOption != 6) {

            if      (menuOption == 1) {noteControl.addRecord(); }
            else if (menuOption == 2) {noteControl.searchRecord();}
            else if (menuOption == 3) {noteControl.deleteRecord();}
            else if (menuOption == 4) {noteControl.editRecord();}
            else if (menuOption == 5) {noteControl.displayRecord();}
            else if (menuOption == 6) {break;}

            System.out.println("=======================");
            System.out.println("Returned to main menu");
            System.out.println("=======================");
            System.out.println("Returned to main menu");
            bookMenu.menu();
            menuOption = stdin.nextInt();

        }


    }
}







