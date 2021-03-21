import model.Player;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        System.out.println("Start");

        List<Player> players = new ArrayList<>();

        String selectQuery = "SELECT * from player";

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/stats", "root", "slack");
            PreparedStatement preparedStatement = conn.prepareStatement(selectQuery))
        {
            if (conn != null)
            {
                System.out.println("Connected to the database!");
            }
            else
            {
                System.out.println("Failed to make connection!");
            }

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next())
            {
                int id = resultSet.getInt(("id"));
                String firstname = resultSet.getString("FIRSTNAME");
                String lastname = resultSet.getString("LASTNAME");

                Player p = new Player();

                p.setId(id);
                p.setFirstname(firstname);
                p.setFirstname(lastname);

                System.out.println("ID:" + id + "Firstname:" + firstname + "Lastname:" + lastname );
                players.add(p);
                System.out.println("Player added.");
            }

            System.out.println("Displaying players:");
            players.forEach(p -> System.out.println(p));

        }
        catch (SQLException e)
        {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
