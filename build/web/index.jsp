<%-- 
    Document   : index
    Created on : 29-oct-2015, 9:22:48
    Author     : alumno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="tags" prefix="partidos"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Resultados Real Madrid</title>
    <style>
      body {
        font-family: Calibri, sans-serif;
        font-size: 16px;
      }
      table {
        border: 2px solid darkblue;
        border-collapse: collapse;
        margin: auto;
      }
      td.titulo {
        font-weight: bold;
        border-bottom: 4px solid darkblue;
        background-color: lightblue;
      }
      td.seccion {
        font-weight: bold;
        text-align: left;
        border-bottom: 2px solid darkblue;
        background-color: lightblue;
      }
      td.apartado {
        text-align: left;
        border-bottom: 2px solid darkblue;
        background-color: lightblue;
      }
      td.etiqueta {
        border: 2px solid darkblue;
        background-color: lightgreen;
      }
      td.dato {
        border: 2px solid darkblue;
        background-color: yellow;
      }
    </style>
  </head>
  <body>
    <table>
      <tr><td class="titulo" colspan="3">RESULTADOS DE LA SEMANA</td></tr>
      <tr><td class="seccion" colspan="3">CHAMPIONS</td></tr>
      <tr><td class="apartado" colspan="3">CASA</td></tr>
      <partidos:resultados lugar="CASA" categoria="CHAMPION"/>
      <tr><td class="apartado" colspan="3">FUERA</td></tr>
      <partidos:resultados lugar="FUERA" categoria="CHAMPION"/>
      <tr><td class="seccion" colspan="3">LIGA</td></tr>
      <tr><td class="apartado" colspan="3">CASA</td></tr>
      <partidos:resultados lugar="CASA" categoria="LIGA"/>
      <tr><td class="apartado" colspan="3">FUERA</td></tr>
      <partidos:resultados lugar="FUERA" categoria="LIGA"/>
    </table>
  </body>
</html>
