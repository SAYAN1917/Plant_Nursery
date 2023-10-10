package com.amdocs.myproject.dao;

import java.sql.SQLException;
import java.util.List;

import com.amdocs.myproject.entity.Plant;


public interface PlantDao {
	
    int addPlant(Plant plant) throws SQLException ;
    int delete(int plantId) throws SQLException;
    boolean updatePlantCost(int plantId,double cost) throws SQLException;
    List<String> showAllPlants() throws SQLException;
    List<String> searchByOriginCountryName(String originCountryName) throws SQLException;
    List<String> searchOutdoorPlantsWithSunlight() throws SQLException;
    int countryPlantsByWaterSupplyFrequency(String waterSupplyFrequency);
    
    
    
}


