package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.bean.LibroBean;
import model.bean.UtenteBean;
import utils.DbConnection;

public class Librodao {
	
	DbConnection dbCon = new DbConnection();

	public List<LibroBean> findAll() {
		String query = "SELECT * FROM libro;";
		Connection con = dbCon.getConnection();

		Statement st = null;
		List<LibroBean> libri = new ArrayList<>();
		try {
			st = con.createStatement();

			ResultSet rs = st.executeQuery(query);

			while (rs.next()) {
				LibroBean libroBean = new LibroBean();

				libroBean.setIdLibro(rs.getLong("id_libro"));
				libroBean.setTitoloLibro(rs.getString("titolo"));
				libroBean.setAutoreLibro(rs.getString("autore"));
				libroBean.setEditoreLibro(rs.getString("editore"));
				libroBean.setPrezzoLibro(rs.getDouble("prezzo"));
				libroBean.setDataCreazioneLibro(rs.getTimestamp("data_creazione").toLocalDateTime());
				libroBean.setDataModificaLibro(rs.getTimestamp("data_modifica").toLocalDateTime());
				libroBean.setFlgCancellatoLibro(rs.getBoolean("flg_cancellato"));
				libroBean.setDataPubblicazioneLibro(rs.getTimestamp("data_pubblicazione").toLocalDateTime().toLocalDate());
				libroBean.setGenereLibro(rs.getString("genere"));
				libroBean.setDisponibilitaLibro(rs.getInt("disponibilità"));
				
				libri.add(libroBean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		dbCon.closeConnection(con);

		return libri;
	}

	public LibroBean findById(Long id) {
		String query = "SELECT * FROM libro WHERE id_libro=?";
		Connection con = dbCon.getConnection();


		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(query);
			ps.setLong(1, id);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		ResultSet rs;
		LibroBean libroBean = new LibroBean();
		try {
			rs = ps.executeQuery();

			while (rs.next()) {

				libroBean.setIdLibro(rs.getLong("id_libro"));
				libroBean.setTitoloLibro(rs.getString("titolo"));
				libroBean.setAutoreLibro(rs.getString("autore"));
				libroBean.setEditoreLibro(rs.getString("editore"));
				libroBean.setPrezzoLibro(rs.getDouble("prezzo"));
				libroBean.setDataCreazioneLibro(rs.getTimestamp("data_creazione").toLocalDateTime());
				libroBean.setDataModificaLibro(rs.getTimestamp("data_modifica").toLocalDateTime());
				libroBean.setFlgCancellatoLibro(rs.getBoolean("flg_cancellato"));
				libroBean.setDataPubblicazioneLibro(
						rs.getTimestamp("data_pubblicazione").toLocalDateTime().toLocalDate());

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		dbCon.closeConnection(con);
		
		return libroBean;
	}

	public LibroBean insert(LibroBean libroBean) {
		String query = "INSERT INTO libro (titolo, autore, editore, prezzo) VALUES (?, ?, ?, ?);";
		Connection con = dbCon.getConnection();


		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

			ps.setString(1, libroBean.getTitoloLibro());
			ps.setString(2, libroBean.getAutoreLibro());
			ps.setString(3, libroBean.getEditoreLibro());
			ps.setDouble(4, libroBean.getPrezzoLibro());
		} catch (SQLException e) {
			e.printStackTrace();
		}

		int insertOutput = 0;
		try {
			insertOutput = ps.executeUpdate();
			if (insertOutput == 1) {
				ResultSet rs = ps.getGeneratedKeys();
				if (rs.next()) {
					Long idNuovoLibro = rs.getLong(1);
					return findById(idNuovoLibro);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		dbCon.closeConnection(con);

		return new LibroBean();
	}

	public int update(LibroBean libroBean) {
		String query = "UPDATE libro SET nome=? WHERE id_libro=?";
		Connection con = dbCon.getConnection();


		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(query);

			ps.setString(1, libroBean.getTitoloLibro());
			ps.setString(2, libroBean.getAutoreLibro());
			ps.setString(3, libroBean.getEditoreLibro());
			ps.setDouble(4, libroBean.getPrezzoLibro());
		} catch (SQLException e) {
			e.printStackTrace();
		}

		int updateOutput = 0;
		try {
			updateOutput = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		dbCon.closeConnection(con);

		return updateOutput;
	}

	public int deleteById(Long id) {
		String query = "DELETE FROM ruolo WHERE id_libro=?";
		Connection con = dbCon.getConnection();


		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(query);

			ps.setLong(1, id);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		int deleteOutput = 0;
		try {
			deleteOutput = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		dbCon.closeConnection(con);

		return deleteOutput;
	}

	
	public List<LibroBean> libriOrdineVista() {
		
		String query = "SELECT * FROM libro order by autore asc, prezzo desc";

		Connection con = dbCon.getConnection();
		Statement st = null;
		List<LibroBean> libri = new ArrayList<>();

		try {
			st = con.createStatement();

			ResultSet rs = st.executeQuery(query);

			while (rs.next()) {
				LibroBean libroBean = new LibroBean();
				
				libroBean.setIdLibro(rs.getLong("id_libro"));
				libroBean.setTitoloLibro(rs.getString("titolo"));
				libroBean.setAutoreLibro(rs.getString("autore"));
				libroBean.setEditoreLibro(rs.getString("editore"));
				libroBean.setGenereLibro(rs.getString("genere"));
				libroBean.setPrezzoLibro(rs.getDouble("prezzo"));
				libroBean.setDisponibilitaLibro(rs.getInt("disponibilità"));
				libroBean.setDataCreazioneLibro(rs.getTimestamp("data_creazione").toLocalDateTime());
				libroBean.setDataModificaLibro(rs.getTimestamp("data_modifica").toLocalDateTime());
				libroBean.setFlgCancellatoLibro(rs.getBoolean("flg_cancellato"));

				libri.add(libroBean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		dbCon.closeConnection(con);
		for (LibroBean u : libri) {
			System.out.println(u);
		}

		return libri;

	}
	
	public List<LibroBean> selectionAuthor() {
		String query = "SELECT DISTINCT autore FROM libro;";
		Connection con = dbCon.getConnection();

		Statement st = null;
		List<LibroBean> libri = new ArrayList<>();
		try {
			st = con.createStatement();

			ResultSet rs = st.executeQuery(query);

			while (rs.next()) {
				LibroBean libroBean = new LibroBean();

				libroBean.setAutoreLibro(rs.getString("autore"));
				
				libri.add(libroBean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		dbCon.closeConnection(con);

		return libri;
	}
	
	public List<LibroBean> findByAuthor(String autore) {
		String query = "SELECT * FROM libro WHERE autore=?";
		Connection con = dbCon.getConnection();


		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(query);
			ps.setString(1, autore);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		ResultSet rs;
		LibroBean libroBean = new LibroBean();
		List<LibroBean> listaLibri = new ArrayList<>();
		try {
			rs = ps.executeQuery();

			while (rs.next()) {

				libroBean.setTitoloLibro(rs.getString("titolo"));
				libroBean.setAutoreLibro(rs.getString("autore"));
				libroBean.setEditoreLibro(rs.getString("editore"));
				libroBean.setPrezzoLibro(rs.getDouble("prezzo"));
				libroBean.setDataPubblicazioneLibro(rs.getTimestamp("data_pubblicazione").toLocalDateTime().toLocalDate());
				libroBean.setGenereLibro(rs.getString("genere"));
				libroBean.setDisponibilitaLibro(rs.getInt("disponibilità"));
				
				listaLibri.add(libroBean);
				
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		dbCon.closeConnection(con);
		
		return listaLibri;
	}
}
