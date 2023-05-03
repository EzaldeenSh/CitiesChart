package com.app.data;

import java.sql.SQLException;
import java.util.List;

public interface CityDao {
	List<City> getAllCities() throws SQLException;
	

}
