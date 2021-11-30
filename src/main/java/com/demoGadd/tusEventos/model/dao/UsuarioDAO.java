package com.demoGadd.tusEventos.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.demoGadd.tusEventos.model.ConnectionManager;
import com.demoGadd.tusEventos.model.pojo.Usuario;

public class UsuarioDAO {

	private static UsuarioDAO INSTANCE = null;
	
	private static final String SQL_EXISTE = "SELECT id, nombre, contrasena FROM usuarios WHERE nombre=? AND contrasena=?";
	
	public static synchronized UsuarioDAO getInstance() {

		if (INSTANCE == null) {
			INSTANCE = new UsuarioDAO();
		}

		return INSTANCE;

	}
	
	
	
	public Usuario existe(String nombre, String contrasenya) {

		Usuario usuario = null;

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(SQL_EXISTE);) {

			pst.setString(1, nombre);
			pst.setString(2, contrasenya);

			
			try (ResultSet rs = pst.executeQuery()) {

				if (rs.next()) {
					usuario = mapper(rs);
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return usuario;
	}
	
	private Usuario mapper(ResultSet rs) throws SQLException {

		Usuario u = new Usuario();
		u.setId(rs.getInt("id"));
		u.setNombre(rs.getString("nombre"));
		u.setContrasena(rs.getString("contrasena"));

		return u;
	}
}
