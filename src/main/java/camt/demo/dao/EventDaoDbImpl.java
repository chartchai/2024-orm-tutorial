package camt.demo.dao;

import camt.demo.entity.Event;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Profile("db")
@Repository
@RequiredArgsConstructor
public class EventDaoDbImpl implements EventDao {

    @Override
    public Integer getEventSize() {
        return null;
    }

    @Override
    public List<Event> getEvents() {
        String url = "jdbc:mysql://localhost:3306/trainOrm";
        String username = "root";
        String password = "password";

        System.out.println("Connecting to the database...");
        List<Event> events = new ArrayList<>();


        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            System.out.println("Connected successfully!");
            String sql = "SELECT * FROM events";
            PreparedStatement statement = conn.prepareStatement(sql);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Event event = new Event();
                event.setPetAllowed(resultSet.getBoolean("pet_allowed"));
                event.setId(resultSet.getLong("id"));
                event.setCategory(resultSet.getString("category"));
                event.setDate(resultSet.getString("date"));
                event.setDescription(resultSet.getString("description"));
                event.setLocation(resultSet.getString("location"));
                event.setOrganizer(resultSet.getString("organizer"));
                event.setTime(resultSet.getString("time"));
                event.setTitle(resultSet.getString("title"));

                // Now you have an Event object filled with data from the 'events' table
                // You can add it to a list or use it right away
                events.add(event);
            }
        } catch (SQLException e) {
            System.out.println("Connection failed!");
            e.printStackTrace();
        }
        return events;

    }



    @Override
    public Event getEvent(Long id) {
        String url = "jdbc:mysql://localhost:3306/trainOrm";
        String username = "root";
        String password = "password";

        System.out.println("Connecting to the database...");
        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            String sql = "SELECT * FROM events WHERE id = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setLong(1, id);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                Event event = new Event();
                event.setPetAllowed(resultSet.getBoolean("pet_allowed"));
                event.setId(resultSet.getLong("id"));
                event.setCategory(resultSet.getString("category"));
                event.setDate(resultSet.getString("date"));
                event.setDescription(resultSet.getString("description"));
                event.setLocation(resultSet.getString("location"));
                event.setOrganizer(resultSet.getString("organizer"));
                event.setTime(resultSet.getString("time"));
                event.setTitle(resultSet.getString("title"));

                // Now you have an Event object filled with data from the 'events' table
                // You can handle the retrieved event object here.
                return event;
            } else {
                System.out.println("No event found with the provided id.");
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Database error!");
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public Event save(Event event) {
        String url = "jdbc:mysql://localhost:3306/trainOrm";
        String username = "root";
        String password = "password";

        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            // Initialize the event object
            String sql = "INSERT INTO events (pet_allowed, category, date, description, location, organizer, time, title) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setBoolean(1, event.getPetAllowed());
            statement.setString(2, event.getCategory());
            statement.setString(3, event.getDate());
            statement.setString(4, event.getDescription());
            statement.setString(5, event.getLocation());
            statement.setString(6, event.getOrganizer());
            statement.setString(7, event.getTime());
            statement.setString(8, event.getTitle());

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new event was inserted successfully!");
                return event;
            }
        } catch (SQLException e) {
            System.out.println("Database error!");
            e.printStackTrace();
        }
        return null;
    }
}
