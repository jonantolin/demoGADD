package com.demoGadd.tusEventos.model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.demoGadd.tusEventos.model.ConnectionManager;
import com.demoGadd.tusEventos.model.pojo.Evento;

public class EventoDAO {

	private static EventoDAO INSTANCE = null;

	private static final String SQL_GET_ALL = "SELECT id, nombre, lugar, fecha, precio, disponibles, vendidas, aforo, img_portada "
			+ "FROM eventos;";

	private static final String SQL_GET_BY_ID = "SELECT id, nombre, lugar, fecha, precio, disponibles, vendidas, aforo, img_portada "
			+ "FROM eventos WHERE id = ?;";

	private static final String SQL_UPDATE = "UPDATE eventos SET nombre=?, lugar=?, fecha=?, precio=?, disponibles=?, vendidas=?, aforo=?, img_portada=? "
			+ "WHERE id=?;";
	
	private static final String SQL_INSERT = "INSERT INTO eventos (nombre, lugar, fecha, precio, disponibles, vendidas, aforo, img_portada) "
			+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
	
	private static final String SQL_DELETE = "DELETE FROM eventos WHERE id=?;";
	
	private static final String SQL_COMPRAR = "UPDATE eventos SET disponibles=disponibles - ?, vendidas=vendidas + ? WHERE id=?";

	public static synchronized EventoDAO getInstance() {

		if (INSTANCE == null) {
			INSTANCE = new EventoDAO();
		}

		return INSTANCE;
	}

	public ArrayList<Evento> getAll() throws SQLException  {

		ArrayList<Evento> listaEventos = new ArrayList<Evento>();

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(SQL_GET_ALL);
				ResultSet rs = pst.executeQuery();) {

			while (rs.next()) {
				listaEventos.add(mapper(rs));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return listaEventos;
	}

	public Evento getById(int id) throws SQLException  {
		Evento evento = new Evento();

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(SQL_GET_BY_ID);) {

			pst.setInt(1, id);

			try (ResultSet rs = pst.executeQuery()) {
				if (rs.next()) {
					evento = mapper(rs);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return evento;
	}
	
	public boolean update(Evento evento) throws SQLException {
		boolean resultado = false;
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(SQL_UPDATE)) {

			pst.setString(1, evento.getNombre());
			pst.setString(2, evento.getLugar());
			pst.setDate(3, evento.getFecha());
			pst.setDouble(4, evento.getPrecio());
			pst.setInt(5, evento.getDisponibles());
			pst.setInt(6, evento.getVendidas());
			pst.setInt(7, evento.getAforo());
			pst.setString(8, evento.getPortadaImg());
			pst.setInt(9, evento.getId());

			int affectedRows = pst.executeUpdate();
			if (affectedRows == 1) {
				resultado = true;
			}

		}
		return resultado;
	}
	
	public Evento create(Evento evento) throws SQLException {
		
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS)) {

			pst.setString(1, evento.getNombre());
			pst.setString(2, evento.getLugar());
			pst.setDate(3, evento.getFecha());
			pst.setDouble(4, evento.getPrecio());
			pst.setInt(5, evento.getDisponibles());
			pst.setInt(6, evento.getVendidas());
			pst.setInt(7, evento.getAforo());
			pst.setString(8, evento.getPortadaImg());
			

			int affectedRows = pst.executeUpdate();
			if (affectedRows == 1) {
				ResultSet rs = pst.getGeneratedKeys();
				if (rs.next()) {
					evento.setId(rs.getInt(1));
				}
			}

		}
		return evento;
	}
	
	public boolean delete(int id) {
		boolean eliminado = false;

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(SQL_DELETE);) {

			pst.setInt(1, id);

			int affetedRows = pst.executeUpdate();
			if (affetedRows == 1) {
				eliminado = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return eliminado;
	}
	
	public boolean comprar(int id, int entradasCompradas) {
		boolean compraExitosa = false;
		
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(SQL_COMPRAR);) {

			pst.setInt(1, entradasCompradas);
			pst.setInt(2, entradasCompradas);
			pst.setInt(3, id);

			int affetedRows = pst.executeUpdate();
			if (affetedRows == 1) {
				compraExitosa = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return compraExitosa;
	}

	public Evento mapper(ResultSet rs) throws SQLException {

		Evento e = new Evento();
		e.setId(rs.getInt(1));
		e.setNombre(rs.getString(2));
		e.setLugar(rs.getString(3));
		e.setFecha(new Date(rs.getTimestamp(4).getTime()));
		e.setPrecio(rs.getDouble(5));
		e.setDisponibles(rs.getInt(6));
		e.setVendidas(rs.getInt(7));
		e.setAforo(rs.getInt(8));
		e.setPortadaImg(rs.getString(9));

		return e;
	}

}
