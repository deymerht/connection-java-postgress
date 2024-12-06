import java.sql.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Connection connection = null;
//        Statement statement = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        String url = "jdbc:postgresql://localhost:5432/postgres";
        String user = "postgres";
        String password = "root";
//        String query = "SELECT * FROM public.users;";

        String userId = "df209ada-9aa0-4014-bf84-4e8c0b334986";
        String newEmail = "deymerh@deymerhh.com";
        String lastName = "Torres";
//        String firstName = "Deymer";
//        String lastName = "Hernandez";
//        String email = "deymerh@example.com";
//        String lastConnection = "2024-12-27"; // Formato de fecha adecuado
//        String country = "USA";
//        String website = "http://deymerh.com";
//        String username = "deymerh";
//        int followers = 10;
//        int following = 20;

//        String query = "INSERT INTO public.users (first_name, last_name, email, last_connection, country, website, username, followers, following) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
//        String updateQuery = "UPDATE public.users SET email = ? WHERE id = ? ";
//        String updateQuery = "UPDATE public.users SET last_name = ? WHERE id = ? ";
        String userIdToDelete = "df209ada-9aa0-4014-bf84-4e8c0b334986";
        String deleteQuery = "DELETE FROM public.users WHERE id = ?";

        try {
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Conection succesfull");
//            statement = connection.createStatement();
//            preparedStatement = connection.prepareStatement(query);
//            preparedStatement = connection.prepareStatement(updateQuery);
            preparedStatement = connection.prepareStatement(deleteQuery);
            preparedStatement.setString(1, userIdToDelete);
//            preparedStatement.setString(2, userId);
//            preparedStatement.setString(2, lastName);
//            preparedStatement.setString(3, email);
//            preparedStatement.setString(4, lastConnection);
//            preparedStatement.setString(5, country);
//            preparedStatement.setString(6, website);
//            preparedStatement.setString(7, username);
//            preparedStatement.setInt(8, followers);
//            preparedStatement.setInt(9, following);

//            while (resultSet.next()) {
            int rowsAffected = preparedStatement.executeUpdate();
//            if (rowsAffected > 0) {
////                System.out.println(resultSet.getString("first_name"));
//                System.out.println("Rows affected: " + rowsAffected);
//            }
            if (rowsAffected > 0) {
                System.out.println("User email updated successfully. Rows affected: " + rowsAffected);
            } else {
                System.out.println("No user found with the specified ID.");
            }
        } catch (SQLException e) {
            System.out.println("We have an error" + e);
            throw new RuntimeException(e);
        } finally {
            try {
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}