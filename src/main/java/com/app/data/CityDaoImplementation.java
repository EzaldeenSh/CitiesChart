package com.app.data;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
//import java.util.Map;
//import java.util.HashMap;


public class CityDaoImplementation implements CityDao {
	private final Connection connection;
	private static CityDaoImplementation instance;
	private ResultSet resultSet;

//	Map<Integer , City> cities; All the map content goes later for caching

	private CityDaoImplementation() throws SQLException {
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/world" , "root" , "1234");
	}

	public static CityDaoImplementation getInstance() throws SQLException {
		if(instance == null) {
			instance = new CityDaoImplementation();
		}
		return instance;
	}



	@Override
	public List<City> getAllCities() throws SQLException {
		String sql = "select * from city limit 12";
		PreparedStatement preparedStatement =connection.prepareStatement(sql);
		resultSet = preparedStatement.executeQuery();
		List<City> cities = new ArrayList<>();
		while(resultSet.next()){
			cities.add(populateCity(resultSet));
		}
		closeResources();
		return cities;

	}

	private City populateCity(ResultSet resultSet) throws SQLException {
		City city = new City();

		city.setId(resultSet.getInt(1));
		city.setName(resultSet.getString(2));
		city.setCountryCode(resultSet.getString(3));
		city.setDistrict(resultSet.getString(4));
		city.setPopulation(resultSet.getInt(5));

		return city;
	}
	private void closeResources() throws SQLException{
		resultSet.close();
		connection.close();
	}

}
