package com.jdbc.controller;

import java.util.Scanner;

import com.jdbc.crudoperation.CrudOperation;

import om.jdbc.carcollection.CarEntity;

public class CarController {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		CrudOperation crudOperation=new CrudOperation();
		while(true) {
			System.out.println("x-----------------------------------------------x\n");
			System.out.println("| ENTER '1' TO INSERT THE CAR DETAILS           |");
			System.out.println("| ENTER '2' TO UPDATE THE CAR DETAILS           |");
			System.out.println("| ENTER '3' TO DELETE THE CAR DETAILS           |");
			System.out.println("| ENTER '4' TO DISPLAY THE DETAILS BY MODEL ID  |");
			System.out.println("| ENTER '5' TO DISPLAY ALL THE CAR DETAILS      |");
			System.out.println("| ENTER '6' TO EXIT THE APPLICATION             |");
			System.out.println("\nx-----------------------------------------------x");
			
			int a=sc.nextInt();
			
			switch(a) {
			
			case 1:
				System.out.println("ENTER THE MODEL ID");
				int modelId=sc.nextInt();
				System.out.println("ENTER THE NAME FOR THE MODEL");
				sc.nextLine();
				String modeName=sc.nextLine();
				System.out.println("ENTER THE UNITS PRESENT IN THE SHOWROOM");
				int units=sc.nextInt();
				System.out.println("ENTER THE ON-GOING PURCHASING UNITS");
				int inPurchase=sc.nextInt();
				System.out.println("ENTER THE UNITS PRESENT IN THE GARAGE");
				int garage=sc.nextInt();
				
				CarEntity carEntity=new CarEntity(modelId, modeName, units, inPurchase, garage);
				CarEntity carEntityOperational=crudOperation.insertCarDetails(carEntity);
				if(carEntityOperational!=null){
					System.out.println(carEntityOperational.toString()+"\nData Stored......");
				}
				else {
					System.out.println("Data In-Appropriate...");
				}
				break;
			case 2:
				System.out.println("ENTER THE MODEL ID TO UPDATE");
				int modelId2=sc.nextInt();
				if(crudOperation.checkIdAvailablity(modelId2)) {
					System.out.println("ENTER THE NEW MODEL NAME");
					sc.nextLine();
					String modelName1=sc.nextLine();
					System.out.println("ENTER THE UNITS PRESENT IN SHOWROOM");
					int units1=sc.nextInt();
					System.out.println("ENTER THE ON-GOING PURCHASING UNITS");
					int inPurchase1=sc.nextInt();
					System.out.println("ENTER THE UNITS PRESENT IN THE GARAGE");
					int garage1=sc.nextInt();
					CarEntity carEntity1=new CarEntity(modelId2, modelName1, units1, inPurchase1, garage1);
					carEntityOperational=crudOperation.updateCarDetails(carEntity1);
					System.out.println(carEntityOperational.toString());
				}
				else {
					System.out.println("MODEL NOT FOUND");
				}
				break;
			case 3:
				System.out.println("ENTER THE MODEL ID TO DELETE");
				int modelId1=sc.nextInt();
				CarEntity carEntity2=crudOperation.deleteCarDetails(modelId1);
				if(carEntity2!=null) {
					System.out.println(carEntity2.toString());
				}
				else {
					System.out.println("MODEL NOT FOUND");
				}				
				break;
			case 4:
				System.out.println("ENTER THE MODEL ID TO SEE THE CAR DETAILS");
				int modelId3=sc.nextInt();
				crudOperation.displayCarCollectionTableById(modelId3);
				break;
			case 5:
				crudOperation.displayCarCollectionTable();
				break;
			case 6:
				sc.close();
				return;
			default:
				System.out.println("INVALID INPUT");
				break;
				
			}
		}
	}
}
