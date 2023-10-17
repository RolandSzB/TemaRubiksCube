package tema.main;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

import tema.dao.*;
import tema.helpers.*;
import tema.pojo.*;

public class Main {

	public static void main(String[] args) throws SQLException {

		ArrayList<Rubic> rubic = RubicDAO.getAll();
		for (Rubic r : rubic) {
			System.out.println(r.getId() + "   " + r.getBrand());
		}

		Rubic r1 = RubicDAO.getById(1);
		if (r1 != null) {
			System.out.println("Cubul Rubic cu id=1 are ca si brand " + r1.getBrand());
		} else {
			System.out.println("Nu exista cub rubic cu id 1 ");
		}

		r1.setId(8);
		r1.setBrand("Cubic");
		boolean actualizat = RubicDAO.update(r1);
		if (actualizat == true) {
			System.out.println("RubicCube a fost actualizat");
		} else {
			System.out.println("Cubul rubic nu a fot gasit in db");
		}
		
//		String deleted = RubicDAO.delete("Rubic");
//		System.out.println(deleted);
		
		Date manufactured = new Date(System.currentTimeMillis());
		Rubic cub = new Rubic("Cuber", 3.1 , 678, manufactured);
		RubicDAO.create(cub);
		 
		
		 
        RubicHelper.closeConnection();
	}

}
