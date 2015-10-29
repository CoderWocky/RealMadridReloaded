/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tags;

import java.io.IOException;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.tagext.TagSupport;

/**
 *
 * @author alumno
 */
public class ListaResultados extends TagSupport {
  private String categoria;
  private String lugar;
  
  public String getCategoria() { return this.categoria; }
  public String getLugar() { return this.lugar; }
  public void setCategoria(String value) { this.categoria = value.toUpperCase(); }
  public void setLugar(String value) {this.lugar = value.toUpperCase(); }
  
  private ResultSet obtenerResultados() throws SQLException {
    DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
    Connection conexion = DriverManager.getConnection(
        "jdbc:oracle:thin:@localhost:1521:XE", "system", "javaoracle");
    
    String query = "SELECT EQUIPO1, EQUIPO2, RESULTADO FROM RESULTADOS_RM WHERE"
        + " CATEGORIA = ? AND LUGAR = ?";
    PreparedStatement sql = conexion.prepareStatement(query);
    sql.setString(1, this.categoria);
    sql.setString(2, this.lugar);
    return sql.executeQuery();
  }
  
  private String htmlListado(ResultSet datos) throws SQLException {
    String html = "<tr><td class='etiqueta'>Equipo1</td><td class='etiqueta'>"
        + "Equipo2</td><td class='etiqueta'>Resultados</td></tr>";
    while (datos.next()) {
      html += String.format("<tr><td class='dato'>%s</td><td class='dato'>%s"
          + "</td><td class='dato'>%s</td></tr>", datos.getString("EQUIPO1"),
          datos.getString("EQUIPO2"), datos.getString("RESULTADO"));
    }
    return html;
  }
  
  @Override
  public int doStartTag() throws JspTagException {
    return SKIP_BODY;
  }

  @Override
  public int doEndTag() throws JspTagException {
    try {
      String html = htmlListado(obtenerResultados());
      pageContext.getOut().write(html);
      return EVAL_PAGE;
    } catch (SQLException | IOException ex) {
      Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
      return SKIP_PAGE;
    }
  }
}
