package fr.eni.ecole.encheres.dal;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import fr.eni.ecole.encheres.bo.Retrait;

public interface RetraitDAO {
	public void insert(Retrait retrait) throws DALException;
	public void update (Retrait retrait) throws DALException;
	public List<Retrait> getAll() throws DALException; 
	public Retrait map(ResultSet rs) throws SQLException;	

}
