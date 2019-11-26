package api;


/**
 * Database
 *
 * @author tyronsamaroo
 */


import java.sql.*;

public class Database {
    private static final String url = "jdbc:derby:EtsyDb";//;shutdown=true





    public static void dropTable(){
        try {
            Connection conn = DriverManager.getConnection(url);
            Statement statement = conn.createStatement();
            String drop = "DROP TABLE Users";
            statement.execute(drop);
        }catch ( Exception e ){
            e.printStackTrace();
        }
    }


    public static Boolean updateColByUserId(String userId, String colName, String value){
        Connection conn     = null;
        PreparedStatement statement = null;
        ResultSet res       = null;
        String query        ="update Users SET "+colName+"=? where user_id=?";
        try {
            conn = DriverManager.getConnection(url);
            statement = conn.prepareStatement(query);
            statement.setString(1, value);
            statement.setString(2, userId);
            int rowsUpdated = statement.executeUpdate();
            if( rowsUpdated == 1 ){
                return true;
            }
        } catch (SQLException e) {
            //e.printStackTrace();
            return false;
        }
        return false;
    }


    public static Boolean userExists(String userName) {
        Connection conn     = null;
        PreparedStatement statement = null;
        ResultSet res       = null;
        String query        = "SELECT user_name FROM Users WHERE user_name=?";
        try {
            conn = DriverManager.getConnection(url);
            statement = conn.prepareStatement(query);
            statement.setString(1, userName);
            res = statement.executeQuery();

            if( res.next() ) {
                if( res.getString("user_name").equals(userName) ){
                    return true;
                }
            }
            else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return false;
    }


    public static User userExists(String userName, String password) {

        Connection conn     = null;
        PreparedStatement statement = null;
        ResultSet res       = null;
        String query        = "SELECT * FROM Users WHERE user_name=? AND password=?";
        try {
            conn = DriverManager.getConnection(url);
            statement = conn.prepareStatement(query);
            statement.setString(1, userName);
            statement.setString(2, password);
            res = statement.executeQuery();
            if( res.next() ) {
                if( res.getString("user_name").equals(userName)
                        && res.getString("password").equals(password)){
                    String userId = res.getString("user_id");
                    String username = res.getString("user_name");
                    String pass = res.getString("password");
                    return new User(userId, username, pass);
                }
            }
            else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return null;
    }


    public static void printAllTableRows(String tableName){
        Connection conn     = null;
        Statement statement = null;
        ResultSet res       = null;
        String query        = "SELECT * FROM " + tableName;
        try {
            conn = DriverManager.getConnection(url);
            statement = conn.createStatement();
            res = statement.executeQuery(query);
            while (res.next() ){
                System.out.print("User id: " + res.getString("user_id"));
                System.out.print("    Username: " + res.getString("user_name"));
                System.out.print("    pass: " + res.getString("password"));
                System.out.println();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static Boolean addNewUser(String userName, String password){
        Connection conn     = null;
        PreparedStatement statement = null;
        String query        = "INSERT INTO Users (user_name, password) VALUES ( ?, ? )";
        try {
            conn = DriverManager.getConnection(url);
            statement = conn.prepareStatement(query);
            statement.setString(1, userName);
            statement.setString(2, password);
            statement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }


    public static boolean deleteUser(String userName){
        Connection conn     = null;
        PreparedStatement statement = null;
        ResultSet res       = null;
        String query        = "UPDATE Users SET deleted=1 WHERE user_name=?";
        try {
            conn = DriverManager.getConnection(url);
            statement = conn.prepareStatement(query);
            statement.setString(1, userName);
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return false;
    }


    public static void main(String[] args) {

        printAllTableRows("Users");

    }
}
