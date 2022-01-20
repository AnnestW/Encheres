package fr.eni.ecole.encheres.dal;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import fr.eni.ecole.encheres.bo.Retrait;

public class RetraitDAOImpl implements RetraitDAO {

	private  final static String INSERT= "INSER INTO RETRAITS (no_article,rue,code_postal,ville)VALUES(?,?,?,?)";
	
	
	
	@Override
	public void insert(Retrait retrait) throws DALException {
		

	}

	@Override
	public void update(Retrait retrait) throws DALException {
		

	}

	@Override
	public List<Retrait> getAll() throws DALException {
		
		return null;
	}

	@Override
	public Retrait map(ResultSet rs) throws SQLException {
		
		return null;
	}

}
