package com.amdocs.myproject.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.amdocs.myproject.util.DbUtil;
import com.amdocs.myproject.dao.PlantDao;
import com.amdocs.myproject.entity.Plant;


public class PlantNurseryDaoImpl implements PlantDao {

	public static void main(String[] args) {
		

	}

	@Override
	public int addPlant(Plant plant) throws SQLException {private static final String INSERT_PLANT="insert into Plants (Plant_Name, OriginCountry_Name, Sunlight_Required, Plant_Type,waterSupply_Frequency,Plant_Cost) values(?,?,?,?,?,?)";
	private  Connection connection=DbUtil.getConnection();
		
		PreparedStatement ps=connection.prepareStatement(INSERT_PLANT);
		// Set The value
		ps.setString(1, plant.getPlantName());
		ps.setString(2, plant.getOriginCountryName());
		ps.setBoolean(3,plant.isSunlightRequired());
		ps.setString(4, plant.getPantType());
		ps.setString(5, plant.getWaterSupplyFrequency());
		ps.setDouble(6, plant.getCost());
		
		int executeUpdate = ps.executeUpdate();
		ps.close();
		if(executeUpdate>0) {
			return 1;
		}
	
		return 0;
	}

	@Override
	public int delete(int plantId) throws SQLException {
		Connection connection=DbUtil.getConnection();
		String DELETE_PLANTS="delete from Plants where Plant_id=?";
		PreparedStatement ps=connection.prepareStatement(DELETE_PLANTS);
		// Set The value
		ps.setInt(1, plantId);
		int result = ps.executeUpdate();
		ps.close();
		return result;
		return 0;
	}

	@Override
	public boolean updatePlantCost(int plantId, double cost) throws SQLException {
		Connection connection=DbUtil.getConnection();
		String UPDATE_PLANTS="update customers set Plant_Cost=? where Plant_id=?";
		PreparedStatement ps=connection.prepareStatement(UPDATE_PLANTS);
		// Set The value
		ps.setDouble(1, cost);
		
		int result = ps.executeUpdate();
		ps.close();
		return true;
		
		return false;
	}

	@Override
	public List<String> showAllPlants() throws SQLException {
		Connection connection=DbUtil.getConnection();
		String SHOW_ALL_PLANTS="select * from Plants";
		PreparedStatement ps=connection.prepareStatement(SHOW_ALL_PLANTS);
	
		//Execute Statement
		ResultSet result = ps.executeQuery();
		while(result.next()) {
			String PlantName= result.getString("Plant_Name");
			String showCountryByOrigin= result.getString("OriginCountry_Name");
			String sunlightRequired= result.getString("Sunlight_Required");
			String waterSupplyFrequency= result.getString("waterSupply_Frequency");
			String cost= result.getString("Plant_Cost");
			
			System.out.println(" PlantName:" + PlantName
					+" " + " Country By Origin"+showCountryByOrigin+" "+ " " +"Sunlight Required Plants: " 
					+ sunlightRequired + " " + "Water Supply Frequency Plants: " 
					+ waterSupplyFrequency + " " + "Cost of Plant" +  cost   );
				}
		ps.close();
		
		return null;
	}


	@Override
	public List<String> searchByOriginCountryName(String originCountryName) throws SQLException {
		
		return null;
	}

	@Override
	public List<Integer> searchOutdoorPlantsWithSunlight() throws SQLException {
		
		return null;
	}

	@Override
	public int countryPlantsByWaterSupplyFrequency(String waterSupplyFrequency) {
		// TODO Auto-generated method stub
		return 0;
	}

}
