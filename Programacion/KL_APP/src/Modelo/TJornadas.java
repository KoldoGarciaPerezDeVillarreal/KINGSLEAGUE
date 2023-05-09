package Modelo;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TJornadas {

    public static void insertar(Jornada jorn) throws Exception
    {
        BaseDato.abrirConexion();
        PreparedStatement ps = BaseDato.getCon().prepareStatement("insert into jornadas values (?,?,?)");
        ps.setInt(1, jorn.getTemporada().getID());
        ps.setInt(2, jorn.getNumJornada());
        ps.setDate(3, Date.valueOf(jorn.getFecha()));
        ps.executeUpdate();
        BaseDato.cerrarConexion();
    }

    public static int update(Jornada jorn) throws SQLException {
        BaseDato.abrirConexion();
        PreparedStatement ps = BaseDato.getCon().prepareStatement("update jornadas set id_temporada = ?, num_jornada = ?, fecha = ? where id_jornada = ?`");
        ps.setInt(1, jorn.getTemporada().getID());
        ps.setInt(2, jorn.getNumJornada());
        ps.setDate(3, Date.valueOf(jorn.getFecha()));
        ps.setInt(4,jorn.getID());
        int n = ps.executeUpdate();
        BaseDato.cerrarConexion();
        return n;
    }

    public static int delete(Jornada jorn) throws Exception {
        BaseDato.abrirConexion();
        PreparedStatement ps = BaseDato.getCon().prepareStatement("delete from jornadas where id_jornada = ?");
        ps.setInt(1, jorn.getID());
        int n=ps.executeUpdate();
        BaseDato.cerrarConexion();
        return n;
    }

    public static ArrayList<Jornada> buscarTodo() throws Exception {
        ArrayList<Jornada> listaJornadas = new ArrayList<>();
        BaseDato.abrirConexion();
        PreparedStatement ps = BaseDato.getCon().prepareStatement("select * from jornadas");
        ResultSet resultado = ps.executeQuery();
        Jornada jornada;
        while (resultado.next())
        {
            jornada = new Jornada(resultado.getInt("id_jornada"), resultado.getInt("num_jornada"), resultado.getDate("fecha").toLocalDate(), TTemporadas.buscarTemporada(new Temporada(resultado.getDate("fecha_inicio").toLocalDate(), resultado.getDate("fecha_fin").toLocalDate())));
            listaJornadas.add(jornada);
        }
        BaseDato.cerrarConexion();
        return listaJornadas;
    }

    public static Jornada buscarPorFecha(Jornada jorn) throws Exception {
        BaseDato.abrirConexion();
        PreparedStatement ps = BaseDato.getCon().prepareStatement("select * from jornadas where id_jornada = ?");
        ps.setInt(1,jorn.getID());
        ResultSet resultado = ps.executeQuery();
        Jornada jornada;
        if (resultado.next())
        {
            jornada = new Jornada();
            jornada.setID(resultado.getInt("id_jornada"));
        }
        else
            jornada = null;
        BaseDato.cerrarConexion();
        return jornada;
    }

}
