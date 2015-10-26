package phoneBook;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class noteManager {


    public void addRecord() throws SQLException {

        dbConnection dbconn = new dbConnection();
        Scanner stdin = new Scanner(System.in);
        dbconn.getConnection().setAutoCommit(false);

        // PREPARED STATEMENT FOR ADDING A RECORD;

        PreparedStatement addStmt = null;
        try {
            addStmt = dbconn.getConnection().prepareStatement
            ("INSERT INTO notebook (name, last_name, company, phone, mail, date_of_birth) VALUES (?, ?, ?, ?, ?, ?)");

        } catch (SQLException e) {
            e.printStackTrace();
        }

        // END OF PREPARED STATEMENT;

        noteRecord newRecord = new noteRecord();

        System.out.println("Adding new record");
        System.out.println("==================");
        System.out.println("Enter a Name");
        newRecord.setFirst_name(stdin.next());
        System.out.println("Enter a Last Name");
        newRecord.setLast_name(stdin.next());
        System.out.println("Enter a Company");
        newRecord.setCompany(stdin.next());
        System.out.println("Enter a Phone number");
        newRecord.setPhone(stdin.next());
        System.out.println("Enter an E-mail");
        newRecord.setMail(stdin.next());
        System.out.println("Enter the Date of birth");
        newRecord.setDate_of_birth(stdin.next());
        System.out.println("===================");
        System.out.println("Thank you, new record created");
        System.out.println("===================");
        try {
            addStmt.setString(1, newRecord.getFirst_name());
            addStmt.setString(2, newRecord.getLast_name());
            addStmt.setString(3, newRecord.getCompany());
            addStmt.setString(4, newRecord.getPhone());
            addStmt.setString(5, newRecord.getMail());
            addStmt.setString(6, newRecord.getDate_of_birth());
            addStmt.executeUpdate();
            dbconn.getConnection().commit();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            addStmt.close();
            dbconn.getConnection().close();
        }

    }

    public void searchRecord() throws SQLException {


        dbConnection dbconn = new dbConnection();
        Scanner stdin = new Scanner(System.in);

        // PREPARED STATEMENT FOR SEARCH
        PreparedStatement stmt_searchByParam = null;
        // END OF STATEMENT

        System.out.println("Where do you want to search?");
        System.out.println("============================");
        System.out.println("1 -- Names");
        System.out.println("2 -- Last Names");
        System.out.println("3 -- Companies");
        System.out.println("4 -- Phone numbers");
        System.out.println("5 -- E-mails");
        System.out.println("6 -- Dates of birth");
        System.out.println("7 -- Names and Phones");
        System.out.println("8 -- Last Names and Companies");

        int searchOption;
        searchOption = stdin.nextInt();

        switch (searchOption) {

            case 1:
                if (searchOption == 1) {


                    String sqlSearch = "SELECT * FROM notebook WHERE name LIKE ?";
                    stmt_searchByParam = dbconn.getConnection().prepareStatement(sqlSearch);
                    System.out.println("Type a few characters: ");
                    String searchChar;
                    searchChar = stdin.next();

                    String fullMatch = searchChar + "%";
                    stmt_searchByParam.setString(1, fullMatch);
                    stmt_searchByParam.executeQuery();
                    ResultSet searchResult = stmt_searchByParam.executeQuery();

                    while (searchResult.next()) {
                        int id = searchResult.getInt("id");
                        String fname = searchResult.getString("name");
                        String lname = searchResult.getString("last_name");
                        String comp = searchResult.getString("company");
                        String tel = searchResult.getString("phone");
                        String email = searchResult.getString("mail");
                        String birth = searchResult.getString("date_of_birth");

                        System.out.println("ID " + id);
                        System.out.println("Name: " + fname);
                        System.out.println("Last Name: " + lname);
                        System.out.println("Company:  " + comp);
                        System.out.println("Phone:  " + tel);
                        System.out.println("E-mail:  " + email);
                        System.out.println("Birth Day " + birth);


                    }
                }
            case 2:
                if (searchOption == 2) {


                    String sqlSearch = "SELECT * FROM notebook WHERE last_name LIKE ?";
                    stmt_searchByParam = dbconn.getConnection().prepareStatement(sqlSearch);
                    System.out.println("Type a few characters: ");
                    String searchChar;
                    searchChar = stdin.next();

                    String fullMatch = searchChar + "%";
                    stmt_searchByParam.setString(1, fullMatch);
                    stmt_searchByParam.executeQuery();
                    ResultSet searchResult = stmt_searchByParam.executeQuery();

                    while (searchResult.next()) {
                        int id = searchResult.getInt("id");
                        String fname = searchResult.getString("name");
                        String lname = searchResult.getString("last_name");
                        String comp = searchResult.getString("company");
                        String tel = searchResult.getString("phone");
                        String email = searchResult.getString("mail");
                        String birth = searchResult.getString("date_of_birth");

                        System.out.println("ID " + id);
                        System.out.println("Name: " + fname);
                        System.out.println("Last Name: " + lname);
                        System.out.println("Company:  " + comp);
                        System.out.println("Phone:  " + tel);
                        System.out.println("E-mail:  " + email);
                        System.out.println("Birth Day " + birth);


                    }
                }

            case 3:
                if (searchOption == 3) {


                    String sqlSearch = "SELECT * FROM notebook WHERE company LIKE ?";
                    stmt_searchByParam = dbconn.getConnection().prepareStatement(sqlSearch);
                    System.out.println("Type a few characters: ");
                    String searchChar;
                    searchChar = stdin.next();

                    String fullMatch = searchChar + "%";
                    stmt_searchByParam.setString(1, fullMatch);
                    stmt_searchByParam.executeQuery();
                    ResultSet searchResult = stmt_searchByParam.executeQuery();

                    while (searchResult.next()) {
                        int id = searchResult.getInt("id");
                        String fname = searchResult.getString("name");
                        String lname = searchResult.getString("last_name");
                        String comp = searchResult.getString("company");
                        String tel = searchResult.getString("phone");
                        String email = searchResult.getString("mail");
                        String birth = searchResult.getString("date_of_birth");

                        System.out.println("ID " + id);
                        System.out.println("Name: " + fname);
                        System.out.println("Last Name: " + lname);
                        System.out.println("Company:  " + comp);
                        System.out.println("Phone:  " + tel);
                        System.out.println("E-mail:  " + email);
                        System.out.println("Birth Day " + birth);


                    }

                }


            case 4:
                if (searchOption == 4) {


                    String sqlSearch = "SELECT * FROM notebook WHERE phone LIKE ?";
                    stmt_searchByParam = dbconn.getConnection().prepareStatement(sqlSearch);
                    System.out.println("Type a few characters: ");
                    String searchChar;
                    searchChar = stdin.next();

                    String fullMatch = searchChar + "%";
                    stmt_searchByParam.setString(1, fullMatch);
                    stmt_searchByParam.executeQuery();
                    ResultSet searchResult = stmt_searchByParam.executeQuery();

                    while (searchResult.next()) {
                        int id = searchResult.getInt("id");
                        String fname = searchResult.getString("name");
                        String lname = searchResult.getString("last_name");
                        String comp = searchResult.getString("company");
                        String tel = searchResult.getString("phone");
                        String email = searchResult.getString("mail");
                        String birth = searchResult.getString("date_of_birth");

                        System.out.println("ID " + id);
                        System.out.println("Name: " + fname);
                        System.out.println("Last Name: " + lname);
                        System.out.println("Company:  " + comp);
                        System.out.println("Phone:  " + tel);
                        System.out.println("E-mail:  " + email);
                        System.out.println("Birth Day " + birth);


                    }

                }

            case 5:
                if (searchOption == 5) {


                    String sqlSearch = "SELECT * FROM notebook WHERE mail LIKE ?";
                    stmt_searchByParam = dbconn.getConnection().prepareStatement(sqlSearch);
                    System.out.println("Type a few characters: ");
                    String searchChar;
                    searchChar = stdin.next();

                    String fullMatch = searchChar + "%";
                    stmt_searchByParam.setString(1, fullMatch);
                    stmt_searchByParam.executeQuery();
                    ResultSet searchResult = stmt_searchByParam.executeQuery();

                    while (searchResult.next()) {
                        int id = searchResult.getInt("id");
                        String fname = searchResult.getString("name");
                        String lname = searchResult.getString("last_name");
                        String comp = searchResult.getString("company");
                        String tel = searchResult.getString("phone");
                        String email = searchResult.getString("mail");
                        String birth = searchResult.getString("date_of_birth");

                        System.out.println("ID " + id);
                        System.out.println("Name: " + fname);
                        System.out.println("Last Name: " + lname);
                        System.out.println("Company:  " + comp);
                        System.out.println("Phone:  " + tel);
                        System.out.println("E-mail:  " + email);
                        System.out.println("Birth Day " + birth);


                    }
                }
            case 6:
                if (searchOption == 6) {


                    String sqlSearch = "SELECT * FROM notebook WHERE day_of_birth LIKE ?";
                    stmt_searchByParam = dbconn.getConnection().prepareStatement(sqlSearch);
                    System.out.println("Type a few characters: ");
                    String searchChar;
                    searchChar = stdin.next();

                    String fullMatch = searchChar + "%";
                    stmt_searchByParam.setString(1, fullMatch);
                    stmt_searchByParam.executeQuery();
                    ResultSet searchResult = stmt_searchByParam.executeQuery();

                    while (searchResult.next()) {
                        int id = searchResult.getInt("id");
                        String fname = searchResult.getString("name");
                        String lname = searchResult.getString("last_name");
                        String comp = searchResult.getString("company");
                        String tel = searchResult.getString("phone");
                        String email = searchResult.getString("mail");
                        String birth = searchResult.getString("date_of_birth");

                        System.out.println("ID " + id);
                        System.out.println("Name: " + fname);
                        System.out.println("Last Name: " + lname);
                        System.out.println("Company:  " + comp);
                        System.out.println("Phone:  " + tel);
                        System.out.println("E-mail:  " + email);
                        System.out.println("Birth Day " + birth);


                    }
                }
            case 7:
                if (searchOption == 7) {
                    String sqlSearch = "SELECT * FROM notebook WHERE name LIKE ? OR phone LIKE ?";
                    stmt_searchByParam = dbconn.getConnection().prepareStatement(sqlSearch);
                    System.out.println("Type a few characters for name: ");
                    String searchChar;
                    searchChar = stdin.next();

                    System.out.println("Type a few characters for phone: ");
                    String searchCharTwo;
                    searchCharTwo = stdin.next();


                    String fullMatch = searchChar + "%";
                    String fullMatchTwo = searchCharTwo + "%";
                    stmt_searchByParam.setString(1, fullMatch);
                    stmt_searchByParam.setString(2, fullMatchTwo);
                    stmt_searchByParam.executeQuery();
                    ResultSet searchResult = stmt_searchByParam.executeQuery();

                    while (searchResult.next()) {
                        int id = searchResult.getInt("id");
                        String fname = searchResult.getString("name");
                        String lname = searchResult.getString("last_name");
                        String comp = searchResult.getString("company");
                        String tel = searchResult.getString("phone");
                        String email = searchResult.getString("mail");
                        String birth = searchResult.getString("date_of_birth");

                        System.out.println("ID " + id);
                        System.out.println("Name: " + fname);
                        System.out.println("Last Name: " + lname);
                        System.out.println("Company:  " + comp);
                        System.out.println("Phone:  " + tel);
                        System.out.println("E-mail:  " + email);
                        System.out.println("Birth Day " + birth);


                    }
                }
            case 8:
                if (searchOption == 8) {
                    String sqlSearch = "SELECT * FROM notebook WHERE last_name LIKE OR company LIKE ?";
                    stmt_searchByParam = dbconn.getConnection().prepareStatement(sqlSearch);
                    System.out.println("Type a few characters for last name: ");
                    String searchChar;
                    searchChar = stdin.next();

                    System.out.println("Type a few characters for company: ");
                    String searchCharTwo;
                    searchCharTwo = stdin.next();

                    String fullMatch = searchChar + "%";
                    String fullMatchTwo = searchCharTwo + "%";
                    stmt_searchByParam.setString(1, fullMatch);
                    stmt_searchByParam.setString(2, fullMatchTwo);
                    stmt_searchByParam.executeQuery();
                    ResultSet searchResult = stmt_searchByParam.executeQuery();


                    while (searchResult.next()) {
                        int id = searchResult.getInt("id");
                        String fname = searchResult.getString("name");
                        String lname = searchResult.getString("last_name");
                        String comp = searchResult.getString("company");
                        String tel = searchResult.getString("phone");
                        String email = searchResult.getString("mail");
                        String birth = searchResult.getString("date_of_birth");

                        System.out.println("ID " + id);
                        System.out.println("Name: " + fname);
                        System.out.println("Last Name: " + lname);
                        System.out.println("Company:  " + comp);
                        System.out.println("Phone:  " + tel);
                        System.out.println("E-mail:  " + email);
                        System.out.println("Birth Day " + birth);

                    }
                }
        }


    }

    public void deleteRecord() throws SQLException {

        dbConnection dbconn = new dbConnection();
        Scanner stdin = new Scanner(System.in);


        // PREPARED STATEMENT FOR SEARCH AND SEE ALL RECORDS
        PreparedStatement stmt_delete = null;
        Statement stmt_seeAll = null;
        String seeAll = "SELECT id, name, last_name, company, phone, mail, date_of_birth FROM notebook";
        stmt_seeAll = dbconn.getConnection().createStatement();
        ResultSet rs_seeAll = stmt_seeAll.executeQuery(seeAll);
        // END OF STATEMENT

        System.out.println("Delete menu");
        System.out.println("===============");
        while (rs_seeAll.next()) {
            int id = rs_seeAll.getInt("id");
            String fname = rs_seeAll.getString("name");
            String lname = rs_seeAll.getString("last_name");
            String comp = rs_seeAll.getString("company");
            String tel = rs_seeAll.getString("phone");
            String email = rs_seeAll.getString("mail");
            String birth = rs_seeAll.getString("date_of_birth");

            System.out.println("-------");
            System.out.println("ID " + id);
            System.out.println("-------");
            System.out.println("Name: " + fname);
            System.out.println("Last Name: " + lname);
            System.out.println("Company:  " + comp);
            System.out.println("Phone:  " + tel);
            System.out.println("E-mail:  " + email);
            System.out.println("Birth Day " + birth);
        }
        System.out.println("====================");
        System.out.println("All records listed, choose option");
        System.out.println("1 -- Delete by ID");
        System.out.println("2 -- Delete by Name");
        System.out.println("3 -- Delete by Company");

        int deleteOption;
        deleteOption = stdin.nextInt();

        switch (deleteOption) {

            case 1:
                if (deleteOption == 1) {

                    String sqlDelete = "DELETE FROM notebook WHERE id = ?";
                    stmt_delete = dbconn.getConnection().prepareStatement(sqlDelete);

                    System.out.println("Type an ID");
                    String deleteChar;
                    deleteChar = stdin.next();

                    stmt_delete.setString(1, deleteChar);
                    stmt_delete.executeUpdate();
                    dbconn.getConnection().commit();
                    System.out.println("Record number " + deleteChar + "deleted");


                }
            case 2:
                if (deleteOption == 2) {

                    String sqlDelete = "DELETE FROM notebook WHERE name = ?";
                    stmt_delete = dbconn.getConnection().prepareStatement(sqlDelete);

                    System.out.println("Type a name");
                    String deleteChar;
                    deleteChar = stdin.next();

                    stmt_delete.setString(1, deleteChar);
                    stmt_delete.executeUpdate();
                    dbconn.getConnection().commit();
                    System.out.println("Record number with a name --  " + deleteChar + " -- deleted");


                }

            case 3:
                if (deleteOption == 3) {

                    String sqlDelete = "DELETE FROM notebook WHERE company = ?";
                    stmt_delete = dbconn.getConnection().prepareStatement(sqlDelete);

                    System.out.println("Type a company");
                    String deleteChar;
                    deleteChar = stdin.next();

                    stmt_delete.setString(1, deleteChar);
                    stmt_delete.executeUpdate();
                    dbconn.getConnection().commit();
                    System.out.println("Record number with a company -- " + deleteChar + " -- deleted");


                }


        }
    }

    public void editRecord() throws SQLException {

        dbConnection dbconn = new dbConnection();
        Scanner stdin = new Scanner(System.in);


        // PREPARED STATEMENT FOR UPDATING AND SEE ALL RECORDS
        PreparedStatement stmt_update = null;
        Statement stmt_seeAll = null;
        String seeAll = "SELECT id, name, last_name, company, phone, mail, date_of_birth FROM notebook";
        stmt_seeAll = dbconn.getConnection().createStatement();
        ResultSet rs_seeAll = stmt_seeAll.executeQuery(seeAll);
        // END OF STATEMENT

        System.out.println("Update menu");
        System.out.println("===============");
        while (rs_seeAll.next()) {
            int id = rs_seeAll.getInt("id");
            String fname = rs_seeAll.getString("name");
            String lname = rs_seeAll.getString("last_name");
            String comp = rs_seeAll.getString("company");


            System.out.println("-------");
            System.out.println("ID " + id);
            System.out.println("-------");
            System.out.println("Name: " + fname);
            System.out.println("Last Name: " + lname);
            System.out.println("Company:  " + comp);

        }
        System.out.println("====================");
        System.out.println("All records listed, choose which one you want to update, by typing one's ID");
        System.out.println("ID:");
        String sqlUpdate;

        String updateID;
        updateID = stdin.next();

        System.out.println("What exactly do you want to edit?");



        System.out.println("-------");
        System.out.println("Last Name: ");
        System.out.println("Company:  ");
        System.out.println("Phone:  ");
        System.out.println("E-mail:  ");


        int updateOption = stdin.nextInt();

        switch (updateOption) {

            case 1: if (updateOption == 1) {

                System.out.println("Enter new last name");
                String updateLname = stdin.next();

                sqlUpdate = "UPDATE notebook SET last_name = ? WHERE ID = ?";

                stmt_update = dbconn.getConnection().prepareStatement(sqlUpdate);
                stmt_update.setString(1, updateLname);
                stmt_update.setString(2, updateID);
                stmt_update.executeUpdate();
                dbconn.getConnection().commit();


            }
            case 2: if (updateOption == 2) {

                String updateCompany = stdin.next();
                System.out.println("Enter new company");

                sqlUpdate = "UPDATE notebook SET company = ? WHERE ID = ?";

                stmt_update = dbconn.getConnection().prepareStatement(sqlUpdate);
                stmt_update.setString(1, updateCompany);
                stmt_update.setString(2, updateID);
                stmt_update.executeUpdate();
                dbconn.getConnection().commit();


            }
            case 3: if (updateOption == 3) {

                String updatePhone = stdin.next();
                System.out.println("Enter new phone number");

                sqlUpdate = "UPDATE notebook SET phone = ? WHERE ID = ?";

                stmt_update = dbconn.getConnection().prepareStatement(sqlUpdate);
                stmt_update.setString(1, updatePhone);
                stmt_update.setString(2, updateID);
                stmt_update.executeUpdate();
                dbconn.getConnection().commit();


            }
            case 4: if (updateOption == 4) {

                String updateMail = stdin.next();
                System.out.println("Enter new e-mail");

                sqlUpdate = "UPDATE notebook SET mail = ? WHERE ID = ?";

                stmt_update = dbconn.getConnection().prepareStatement(sqlUpdate);
                stmt_update.setString(1, updateMail);
                stmt_update.setString(2, updateID);
                stmt_update.executeUpdate();
                dbconn.getConnection().commit();


            }

        }

        System.out.println("Record number - " + updateID + " - was changed successfully");


    }

    public void displayRecord() throws SQLException {


        dbConnection dbconn = new dbConnection();
        Statement stmt_seeAll = null;
        String seeAll = "SELECT id, name, last_name, company, phone, mail, date_of_birth FROM notebook ORDER BY last_name";
        stmt_seeAll = dbconn.getConnection().createStatement();
        ResultSet rs_seeAll = stmt_seeAll.executeQuery(seeAll);

        while (rs_seeAll.next()) {

            int id = rs_seeAll.getInt("id");
            String fname = rs_seeAll.getString("name");
            String lname = rs_seeAll.getString("last_name");
            String comp = rs_seeAll.getString("company");
            String tel = rs_seeAll.getString("phone");
            String email = rs_seeAll.getString("mail");
            String birth = rs_seeAll.getString("date_of_birth");

            System.out.println("=========");
            System.out.println("ID " + id);
            System.out.println("=========");
            System.out.println("Name: " + fname);
            System.out.println("Last Name: " + lname);
            System.out.println("Company: " + comp);
            System.out.println("Phone: " + tel);
            System.out.println("E-mail: " + email);
            System.out.println("Birth Day " + birth);



        }
        System.out.println("------------------------------------");
        System.out.println("Ordered alphabetically by last name");

    }
}



