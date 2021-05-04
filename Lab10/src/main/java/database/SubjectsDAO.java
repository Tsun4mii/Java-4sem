package database;

import Models.Subject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SubjectsDAO {
    private final Connection _connection;

    public SubjectsDAO() throws Exception {
        _connection = new DbConnection().getConnection();
    }

    public boolean Create(Subject subject) {
        String query = " INSERT INTO Subjects(name, teacher, faculty) VALUES (?, ?, ?);";

        try {
            PreparedStatement statement = _connection.prepareStatement(query);

            statement.setString(1, subject.getName());
            statement.setString(2, subject.getTeacher());
            statement.setString(3, subject.getFaculty());
            statement.executeUpdate();

            statement.close();
        } catch (SQLException exception) {
            return false;
        }

        return true;
    }

    public boolean Remove(int id) {
        String query = "DELETE FROM Subjects WHERE id = (?);";

        try {
            PreparedStatement statement = _connection.prepareStatement(query);

            statement.setInt(1, id);
            statement.executeUpdate();

            statement.close();
        } catch (SQLException exception) {
            return false;
        }
        return true;
    }

    public boolean Update(int id, Subject subject) {
        String query = "UPDATE Subjects SET name = (?), teacher = (?), faculty = (?) WHERE id = (?);";

        try {
            PreparedStatement statement = _connection.prepareStatement(query);

            statement.setString(4, subject.getName());
            statement.setString(1, subject.getTeacher());
            statement.setString(2, subject.getFaculty());
            statement.setInt(3, id);
            statement.executeUpdate();

            statement.close();
        } catch (SQLException exception) {
            return false;
        }
        return false;
    }

    public Subject Get(int id) {
        String query = "SELECT * FROM Subjects WHERE id=(?);";

        try {
            PreparedStatement statement = _connection.prepareStatement(query);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Subject subject = new Subject();
                subject.setId(resultSet.getInt(4));
                subject.setName(resultSet.getString(1));
                subject.setTeacher(resultSet.getString(2));
                subject.setFaculty(resultSet.getString(3));

                return subject;
            }
        } catch (SQLException exception) {
        }
        return null;
    }

    public ArrayList<Subject> GetAll() {
        String query = "SELECT * FROM Subjects;";
        ArrayList<Subject> result = new ArrayList<>();

        try {
            PreparedStatement statement = _connection.prepareStatement(query);

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Subject subject = new Subject();
                subject.setId(resultSet.getInt(4));
                subject.setName(resultSet.getString(1));
                subject.setTeacher(resultSet.getString(2));
                subject.setFaculty(resultSet.getString(3));

                result.add(subject);
            }
        } catch (SQLException exception) {
        }

        return result;
    }

}
