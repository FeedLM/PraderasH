/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import abstractt.Table;
import static gui.Desktop.manejadorBD;
import java.util.ArrayList;
import javax.swing.DefaultCellEditor;
import javax.swing.table.TableColumn;

import java.awt.event.ActionListener;

/**
 *
 * @author Developer GAGS
 */
public class Proveedor {

    public String id_proveedor;
    public String descripcion;
    public Pais pais;
    public Estado estado;
    public Ciudad ciudad;
    public String direccion;
    public String email;
    public String telefono;
    public String p_fisica_moral;

    public static EstadoSelector estadoSelector;
    public static CiudadSelector ciudadSelector;
    public static PaisSelector paisSelector;

    public Proveedor() {
        limpiarValores();
    }

    public void limpiarValores() {

        id_proveedor = "";
        descripcion = "";
        pais = new Pais();
        estado = new Estado();
        ciudad = new Ciudad();
        direccion = "";
        email = "";
        telefono = "";    
        p_fisica_moral = "";    
    }

    public void cargarPorId(String a_id_proveedor) {

        manejadorBD.consulta(""
                + "SELECT id_proveedor, descripcion, COALESCE(id_pais,''),\n"
                + "       COALESCE(id_estado,''),    COALESCE(id_ciudad,''),\n"
                + "       COALESCE(direccion,''),    COALESCE(email,''),\n"
                + "       COALESCE(telefono,''),     COALESCE(p_fisica_moral,'') \n"
                + "FROM   proveedor "
                + "WHERE  id_proveedor   =    '" + a_id_proveedor + "'\n"
                + "AND    status = 'A'");

        if (manejadorBD.getColumnCount() > 0) {

            asignarValores();
        } else {

            limpiarValores();
        }
    }

    public void cargarPorDescripcion(String a_descripcion) {

        manejadorBD.consulta(""
                + "SELECT id_proveedor, descripcion, COALESCE(id_pais,''),\n"
                + "       COALESCE(id_estado,''),    COALESCE(id_ciudad,''),\n"
                + "       COALESCE(direccion,''),    COALESCE(email,''),\n"
                + "       COALESCE(telefono,''),     COALESCE(p_fisica_moral,'') \n"
                + "FROM proveedor \n"
                + "WHERE descripcion  =    '" + a_descripcion + "'\n"
                + "AND status = 'A'");

        if (manejadorBD.getColumnCount() > 0) {

            asignarValores();
        } else {

            limpiarValores();
        }
    }

    public void asignarValores() {

        String id_pais, id_estado, id_ciudad;

        id_proveedor = manejadorBD.getValorString(0, 0);
        descripcion = manejadorBD.getValorString(0, 1);
        id_pais = manejadorBD.getValorString(0, 2);
        id_estado = manejadorBD.getValorString(0, 3);
        id_ciudad = manejadorBD.getValorString(0, 4);
        direccion = manejadorBD.getValorString(0, 5);
        email = manejadorBD.getValorString(0, 6);
        telefono = manejadorBD.getValorString(0, 7);
        p_fisica_moral = manejadorBD.getValorString(0, 8);

        pais.cargarPorId(id_pais);
        estado.cargarPorId(id_estado);
        ciudad.cargarPorId(id_ciudad, estado);
    }

    public String toString() {

        String salida;

        salida = "{id_proveedor=" + id_proveedor + ","
                + " descripcion='" + descripcion + "',"
                + "pais=" + pais.toString() + ","
                + "estado=" + estado.toString() + ","
                + "ciudad=" + ciudad.toString() + ","
                + "direccion=" + direccion + ","
                + "email=" + email + ","
                + "telefono=" + telefono + ","
                + "p_fisica_moral="+ p_fisica_moral +"}";

        return salida;
    }

    public static ArrayList cargarProveedores() {

        ArrayList array = new ArrayList();

        array.add("");
        manejadorBD.consulta(""
                + "SELECT descripcion \n"
                + "FROM   proveedor\n"
                + "WHERE  status = 'A' \n"
                + "ORDER BY descripcion");

        for (int i = 0; i < manejadorBD.getRowCount(); i++) {

            array.add(manejadorBD.getValueAt(i, 0).toString());
        }
        return array;
    }

    public static String proveedor(Integer id_proveedor) {

        manejadorBD.consulta(""
                + "SELECT descripcion "
                + "FROM   proveedor "
                + "WHERE  id_proveedor  =   " + id_proveedor);

        if (manejadorBD.getColumnCount() > 0) {

            return manejadorBD.getValorString(0, 0);
        }

        return "";
    }

    public static Integer proveedor(String proveedor) {

        manejadorBD.consulta(""
                + "SELECT id_proveedor "
                + "FROM proveedor "
                + "WHERE descripcion  =    '" + proveedor + "'"
                + "AND status = 'A'"
        );

        if (manejadorBD.getColumnCount() > 0) {

            return manejadorBD.getValorInt(0, 0);
        }

        return 0;
    }

    public static void cargarProveedores(Table tabla) {

        estadoSelector = new EstadoSelector();
        paisSelector = new PaisSelector();
        paisSelector.cargar();
        estadoSelector.cargar();

        tabla = crearTablaProveedores(tabla);

        String consulta = ""
                + "SELECT   id_proveedor, proveedor.descripcion, COALESCE(pais.descripcion,''), \n"
                + "         COALESCE(estado.descripcion,''),COALESCE(ciudad.descripcion_ciudad,''), \n"
                + "         direccion, email, telefono  \n"
                + "FROM     proveedor LEFT OUTER JOIN pais ON \n"
                + "             proveedor.id_pais   = pais.id_pais \n "
                + "                   LEFT OUTER JOIN estado ON \n"
                + "             proveedor.id_estado = estado.id_estado \n"
                + "                   LEFT OUTER JOIN ciudad ON \n"
                + "             proveedor.id_ciudad = ciudad.id_ciudad \n"
                + "         AND proveedor.id_estado = ciudad.id_estado\n"
                + "WHERE    status  =   'A'";

        manejadorBD.consulta(consulta);

        manejadorBD.asignarTable(tabla);

        tabla.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        int[] tamaños = new int[]{
            100, //Id_Proveedor
            150, //Descripcion
            100, //Pais
            150, //Estado
            150, //Ciudad
            200, //Direccion
            150, //Email
            100, //telefono
        };

        tabla.tamañoColumna(tamaños);

        tabla.agregarItemStatus();
/*
        //Agregar ComboBox de Estados
        TableColumn col;

        col = tabla.getColumnModel().getColumn(2);
        col.setCellEditor(new DefaultCellEditor(paisSelector));//AGREGO EL COMBO AL CELLEDITOR

        col = tabla.getColumnModel().getColumn(3);
        col.setCellEditor(new DefaultCellEditor(estadoSelector));//AGREGO EL COMBO AL CELLEDITOR
*/
        tabla.ocultarcolumna(0);
        // tabla.ocultarcolumna(2);
    }

    public static final int colPais = 2;
    public static final int colEstado = 3;
    public static final int colCiudad = 4;
    public static final int colDireccion = 5;
    public static final int colEmail = 6;
    public static final int colTelefono = 7;


    /*
     ActionListener actionListenerComboBox = new ActionListener() {
     public void actionPerformed(ActionEvent actionEvent) {
     CambiojComboBox();
     };
     */
    private void CambiojComboBox() {
        System.out.println("Passed");
    }

    public static Table crearTablaProveedores(Table tabla) {

        if (tabla == null) {
            tabla = new Table();
        }

        String titulos[] = {
            "IdProveedor", "Descripción", "Pais", "Estado", "Ciudad", "Direccion", "E-mail", "Telefono"};

        tabla.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                titulos
        ));

        tabla.setTitulos(titulos);
        // tabla.cambiarTitulos();
        tabla.setFormato(new int[]{
            Table.letra, Table.letra, Table.letra, Table.letra, 
            Table.letra, Table.letra, Table.letra, Table.letra});

        return tabla;
    }

    public boolean crear() {

        manejadorBD.parametrosSP = new ParametrosSP();
        manejadorBD.parametrosSP.agregarParametro(descripcion, "varProveedor", "STRING", "IN");
        manejadorBD.parametrosSP.agregarParametro(pais.id_pais, "varIdPais", "STRING", "IN");
        manejadorBD.parametrosSP.agregarParametro(estado.id_estado, "varIdEstado", "STRING", "IN");
        manejadorBD.parametrosSP.agregarParametro(ciudad.id_ciudad, "varIdCiudad", "STRING", "IN");
        manejadorBD.parametrosSP.agregarParametro(direccion, "varDireccion", "STRING", "IN");
        manejadorBD.parametrosSP.agregarParametro(email, "varEmail", "STRING", "IN");
        manejadorBD.parametrosSP.agregarParametro(telefono, "varTelefono", "STRING", "IN");
        manejadorBD.parametrosSP.agregarParametro(p_fisica_moral, "varPFisicaMoral", "STRING", "IN");

        if (manejadorBD.ejecutarSP("{ call agregarProveedor(?,?,?,?,?,?,?, ?) }") == 0) {
            
            return true;
        }

        return false;
    }

    public boolean actualizar() {

        manejadorBD.parametrosSP = new ParametrosSP();
        manejadorBD.parametrosSP.agregarParametro(id_proveedor, "varIdProveedor", "STRING", "IN");
        manejadorBD.parametrosSP.agregarParametro(descripcion, "varProveedor", "STRING", "IN");
        manejadorBD.parametrosSP.agregarParametro(pais.id_pais, "varIdPais", "STRING", "IN");
        manejadorBD.parametrosSP.agregarParametro(estado.id_estado, "varIdEstado", "STRING", "IN");
        manejadorBD.parametrosSP.agregarParametro(ciudad.id_ciudad, "varIdCiudad", "STRING", "IN");
        manejadorBD.parametrosSP.agregarParametro(direccion, "varDireccion", "STRING", "IN");
        manejadorBD.parametrosSP.agregarParametro(email, "varEmail", "STRING", "IN");
        manejadorBD.parametrosSP.agregarParametro(telefono, "varTelefono", "STRING", "IN");
        manejadorBD.parametrosSP.agregarParametro(p_fisica_moral, "varPFisicaMoral", "STRING", "IN");

        if (manejadorBD.ejecutarSP("{ call actualizarProveedor(?,?,?,?,?,?,?,?,?) }") == 0) {

            return true;
        }

        return false;
    }

    public boolean eliminar() {
        manejadorBD.parametrosSP = new ParametrosSP();

        manejadorBD.parametrosSP.agregarParametro(id_proveedor, "varIdProveedor", "STRING", "IN");

        if (manejadorBD.ejecutarSP("{ call eliminarProveedor(?) }") == 0) {

            return true;
        } else {

            return false;
        }
    }
}
