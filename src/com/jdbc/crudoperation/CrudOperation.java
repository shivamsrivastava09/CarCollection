package com.jdbc.crudoperation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import com.jdbc.connection.ConnectionClass;

import om.jdbc.carcollection.CarEntity;

public class CrudOperation {
	Connection connection=ConnectionClass.getCarConnection();
	public final String insert="insert into carcollection(modelid,modelname,units,inpurchase,garage) values(?,?,?,?,?)";
	
	public CarEntity insertCarDetails(CarEntity carEntity) {
		try {
			PreparedStatement ps=connection.prepareStatement(insert);
			ps.setInt(1, carEntity.getModelId());
			ps.setString(2, carEntity.getModelName());
			ps.setInt(3, carEntity.getUnits());
			ps.setInt(4, carEntity.getInPurchase());
			ps.setInt(5, carEntity.getGarage());
			ps.execute();
			return carEntity;
			
		}
		catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	public final String delete="delete from carcollection where modelid=?";
	
	public CarEntity deleteCarDetails(int modelId) {
		try {
			PreparedStatement ps=connection.prepareStatement(delete);
			ps.setInt(1, modelId);
			CarEntity carEntity=selectCarDetails(modelId, new CarEntity());
			if(carEntity!=null) {
				ps.executeUpdate();
				return carEntity;
			}
			else {
				return null;
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public final String update="update carcollection set modelname=?, units=?,inpurchase=?,garage=? where modelid=?";
	public CarEntity updateCarDetails(CarEntity carEntity) {
		try {
			PreparedStatement ps=connection.prepareStatement(update);
			ps.setString(1, carEntity.getModelName());
			ps.setInt(2, carEntity.getUnits());
			ps.setInt(3, carEntity.getInPurchase());
			ps.setInt(4, carEntity.getGarage());
			ps.setInt(5, carEntity.getModelId());
			int a=ps.executeUpdate();
			if(a!=0) {
				return selectCarDetails(carEntity.getModelId(),new CarEntity());
			}
			else {
				return null;
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	public final String selectId="select * from carcollection where modelid=?";
	
	public CarEntity selectCarDetails(int modelId,CarEntity carEntity) {
		
		try {
			PreparedStatement ps2=connection.prepareStatement(selectId);
			ps2.setInt(1, modelId);
			ResultSet res=ps2.executeQuery();
			if(res.next()) {
				carEntity.setModelId(res.getInt("modelid"));
				carEntity.setModelName(res.getString("modelname"));
				carEntity.setUnits(res.getInt("units"));
				carEntity.setInPurchase(res.getInt("inpurchase"));
				carEntity.setGarage(res.getInt("garage"));
				return carEntity;
			}
			else {
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
	}
	public final String select="select * from carcollection";
	
	public boolean checkIdAvailablity(int modelId) {
			CarEntity carEntity=selectCarDetails(modelId, new CarEntity());
			if(carEntity!=null) {
				return modelId==carEntity.getModelId();
			}
			else {
				return false;
			}
		}
	
	public void displayCarCollectionTable() {
		try {
			PreparedStatement ps=connection.prepareStatement(select);
			ResultSet res=ps.executeQuery();
			while(res.next()) {
				int modelId=res.getInt("modelid");
				String modelName=res.getString("modelname");
				int units=res.getInt("units");
				int inPurchase=res.getInt("inpurchase");
				int garage=res.getInt("garage");
				CarEntity carEntity=new CarEntity(modelId, modelName, units, inPurchase, garage);
				System.out.println(carEntity.toString());
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void displayCarCollectionTableById(int modelId) {
		CarEntity carEntity=selectCarDetails(modelId, new CarEntity());
		if(carEntity!=null) {
			System.out.println(carEntity.toString());
		}
		else {
			System.out.println("MODEL NOT FOUND");
		}
	}
	
	

}
