package edu.cs.schmitdm4798.AssignmentOne;

/**
 * Created by Dave 10/12/2016.
 *
 * The purpose of this class is to be a connector for the GUI and a Database
 */

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HenryDAO {

        //JDBC driver identifier and database URL
    static final String DB_URL = "jdbc:oracle:thin:@dario.cs.uwec.edu:1521:csdev";

        //Database credentials
    static final String USER = "SCHMITDM4798";
    static final String PASS = "NTT4SWUF";

    private Connection connection = null;
    private Statement statement = null;
    private ResultSet resultSet = null;


    public HenryDAO(){

            // Create holder objects


//        ResultSet resultSet = null;

        try{
                //Open the connection to the database
            connection = DriverManager.getConnection(DB_URL, USER, PASS);

                //TESTING

//            String sql = "SELECT * FROM mlb_team";
//
//            resultSet = statement.executeQuery(sql);
//
//            while(resultSet.next()){
//                System.out.println(resultSet.getString("name"));
//            }
//

        }catch(SQLException ex){
            ex.printStackTrace();
        }

    }

    public List<String> getAuthorList(){


        String sql = "SELECT author_last, author_first FROM henry_author";
        List<String> authorList = new ArrayList<>();

        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);

            while(resultSet.next()){


                authorList.add(resultSet.getString("author_first").trim() + " " +resultSet.getString("author_last").trim());

            }


        }catch (SQLException ex){
            ex.printStackTrace();
        }


        return authorList;
    }

    public Author getBookData(){

        Author author = new Author();

       // String sql = "SELECT title, price, branch_name, on_hand FROM henry_book INNER JOIN henry_wrote ON henry_book.book_code = henry_wrote.book_code
        // INNER JOIN henry_inventory ON henry_book.book_code = henry_inventory.book_code
        // INNER JOIN henry_branch ON henry_inventory.branch_num = henry_branch.branch_num
        // INNER JOIN henry_author ON henry_author.author_num = henry_wrote.author_num ON henry_author.author_num = henry_wrote.author_num;";
        String sql = "SELECT * FROM henry_book INNER JOIN henry_wrote on henry_book.book_code = henry_wrote.book_code INNER JOIN henry_inventory ON henry_book.book_code = henry_inventory.book_code " +
                "INNER JOIN henry_branch ON henry_inventory.branch_num = henry_branch.branch_num INNER JOIN henry_author ON henry_author.author_num = henry_wrote.author_num" +
                " WHERE author_first = 'Dick' AND author_last = 'Francis'";

        try{
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);

            while(resultSet.next()){

                String bookCode = resultSet.getString("book_code");
                String title = resultSet.getString("title");
                Float price = resultSet.getFloat("price");
                String location = resultSet.getString("branch_name");
                int onHand = resultSet.getInt("on_hand");

                Book book = new Book(bookCode,title,price,location,onHand);
                author.addBook(book);

            }

        }catch (SQLException ex){
            ex.printStackTrace();
        }


        return author;
    }

    public static void main(String[] args) {
        new HenryDAO();
    }

}