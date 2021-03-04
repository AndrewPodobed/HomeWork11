package com.company.db;

import com.company.entity.Address;

import java.io.UTFDataFormatException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AddressConnector {
    public static final String URL = "jdbc:mysql://localhost:3306/addresses?useUnicode=true&serverTimezone=UTC";
    public static final String USER = "root";
    public static final String PASS = "root";

    public static Connection getConnection() {
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(URL, USER, PASS);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return connection;
    }

    private static final String INSERT = "INSERT INTO addresses (id, city, street, numHome, building, numApart) " +
            "VALUES(?, ?, ?, ?, ?, ?)";
    private static final String SELECT_ADDRESS_DATA = "SELECT id, city, street, numHome, building, numApart " +
            "FROM addresses";
    private static final String DELETE_ID = "DELETE FROM addresses WHERE id = ?";
    private static final String UPDATE = "UPDATE addresses SET city = ?, street = ?, numHome = ?, building = ?, " +
            "numApart = ? WHERE id=?";

    public static void add(List<Address> addresses) throws SQLException {
        Connection connection = AddressConnector.getConnection();
        for (Address address : addresses) {
            try (PreparedStatement statement = connection.prepareStatement(INSERT)) {
                statement.setInt(1, address.getId());
                statement.setString(2, address.getCity());
                statement.setString(3, address.getStreet());
                statement.setString(4, address.getNumHome());
                statement.setInt(5, address.getBuilding());
                statement.setInt(6, address.getNumApart());

                statement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        connection.close();
    }
    public static List<Address> readAll() {
        List<Address> result = new ArrayList<>();
        Connection connection = AddressConnector.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(SELECT_ADDRESS_DATA)) {
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String city = resultSet.getString("city");
                String street = resultSet.getString("street");
                String numHome = resultSet.getString("numHome");
                int building = resultSet.getInt("building");
                int numApart = resultSet.getInt("numApart");

                result.add(new Address(id, city, street, numHome, building, numApart));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static void delete(int id) throws SQLException {
        Connection connection = AddressConnector.getConnection();
        try {
            PreparedStatement delId = connection.prepareStatement(DELETE_ID);
            delId.setInt(1,id);
            delId.executeUpdate();
        } catch(Exception e) {
            System.out.println(e);
        }
        connection.close();
    }

    public static void upDate(Address address) {
        Connection connection = AddressConnector.getConnection();

            try (PreparedStatement upDate = connection.prepareStatement(UPDATE)) {
                upDate.setString(1, address.getCity());
                upDate.setString(2, address.getStreet());
                upDate.setString(3, address.getNumHome());
                upDate.setInt(4, address.getBuilding());
                upDate.setInt(5, address.getNumApart());
                upDate.setInt(6, address.getId());

                upDate.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
}
