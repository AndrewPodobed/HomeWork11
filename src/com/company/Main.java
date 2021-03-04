package com.company;

import com.company.db.AddressConnector;
import com.company.entity.Address;

import java.sql.SQLException;
import java.util.List;

import static com.company.db.AddressConnector.add;

public class Main {

    public static void main(String[] args) throws SQLException {
        Address address1 = new Address(11,"Minsk","Jakubova", "66", 5, 35);
        Address address2 = new Address(12,"Moscow","Lenina", "15", 1, 42);
        Address address3 = new Address(13,"Vitebsk","Malinovskogo", "12", 3, 15);
        Address address4 = new Address(14,"Rio de Janeiro","Avenida Atlântica", "6", 2, 4);
        Address address5 = new Address(15,"Paris","Place Colette", "2", 3, 19);

        List<Address> addresses = List.of(address1, address2, address3, address4, address5);

        AddressConnector.add(addresses);
        AddressConnector.readAll().forEach(System.out::println);

//        AddressConnector.upDate(new Address(11, "Mogilev", "Bogushevicha", "21", 3, 233));
//        AddressConnector.upDate(new Address(12, "Tula", "Kostromskaja", "21", 3, 233));
//        AddressConnector.readAll().forEach(System.out::println);

//        AddressConnector.delete(11);
//        AddressConnector.delete(15);
//        AddressConnector.readAll().forEach(System.out::println);







    }

    

    
}
