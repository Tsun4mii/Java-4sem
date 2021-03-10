package Library;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MyDAO_Books implements IGenDAO<Books, Integer> {
    public final Connection connection;
    public  MyDAO_Books(Connection connection){
        this.connection = connection;
    }

    public List<Books> booksyear() throws SQLException {
        Statement st = connection.createStatement();
        String sql = "select * from books where year(released) =year(getdate()) or\n" +
                "year(released) = year(dateadd(year, -1, getdate()));";
        PreparedStatement stm = connection.prepareStatement(sql);
        ResultSet rs = stm.executeQuery();
        List<Books> list = new ArrayList<Books>();

        ResulSetListBooks(rs, list);
        return list;
    }

    public void ResulSetListBooks(ResultSet rs, List<Books> list) throws SQLException {
        while (rs.next()) {
            Books books = new Books();
            books.author = rs.getString("author");
            books.name_of_book = rs.getString("name_of_book");
            books.publishing_house = rs.getString("publishing_house");
            books.released = rs.getString("released");
            books.id_book = rs.getInt("id_book");
            list.add(books);
        }
    }


    @Override
    public List<Books> getAll() throws SQLException{
        Statement st = connection.createStatement();
        String sql = "SELECT * FROM books;";
        PreparedStatement stm = connection.prepareStatement(sql);
        ResultSet rs = stm.executeQuery();
        List<Books> list = new ArrayList<Books>();

        ResulSetListBooks(rs, list);
        return list;
    }




    public List<Books> deleteBooks() throws SQLException {

        Statement st = connection.createStatement();
        Scanner in = new Scanner(System.in);
        System.out.print("Введите год: ");
        int year = in.nextInt();
        String sql = "delete from books where released < " + "'"+ year +"'" +
                "SELECT  * from books;" ;
        PreparedStatement stm = connection.prepareStatement(sql);
        ResultSet rs = stm.executeQuery();
        List<Books> list = new ArrayList<Books>();

        ResulSetListBooks(rs, list);
        return list;
    }
}
