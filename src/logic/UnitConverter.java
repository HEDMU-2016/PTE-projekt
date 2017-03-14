package logic;

import java.math.BigDecimal;

import presentation.FrontPage;
import presentation.FrontPageMediator;

public class UnitConverter {

	private double convertFromGram(double g){
		return g/1000;
	}
	private double convertFromTon(double ton){
		return ton*1000;
	}
	public double convertToKg(String currentWeightValue,String currentUnit){
		if(currentUnit == "G"){
			return convertFromGram(Double.parseDouble(currentWeightValue) );
		}
		if(currentUnit == "Kg"){
			return Double.parseDouble(currentWeightValue);
		}
		if(currentUnit == "T"){
			return convertFromTon(Double.parseDouble(currentWeightValue));
		}
		return -1;
	}
}
