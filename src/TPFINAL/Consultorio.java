package TPFINAL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Consultorio {
    Connection conexion = null;
    Statement sentencia = null;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Consultorio m = new Consultorio();

        m.conectar();
        boolean salir = false;
        do {
            switch (menuPrin()) {
                case 1:
                    m.consultarTabla();
                    break;
                case 2:
                    m.agregarTablaPacientes();
                    break;
                case 3:
                    m.eliminarRegistoEmpleados();
                    break;
                case 4:
                    m.agregarTablaMedicos();
                    break;
                case 5:
                    m.eliminarRegistroMedico();
                    break;
                case 6:
                    m.mostrarTablaMedicos();
                    break;
                case 0:
                    System.out.println("Vuelva pronto");
                    m.desconectar();
                    salir = true;
                    break;
                default:
                    System.out.println("Opción incorrecta");
                    break;
            }
        } while (!salir);

    }

    //MENU PRINCIPAL:
    private static int menuPrin() {

        Scanner sc = new Scanner(System.in);

        System.out.println("--------------------------------");
        System.out.println("Conexión de bbdd MySQL");
        System.out.println("--------------------------------");
        System.out.println("6.MOSTRAR EL CONTENIDO DE LA TABLA MEDICOS");
        System.out.println("5.ELIMINAR UN REGISTRO DE LA TABLA MEDICOS");
        System.out.println("4.INSERTAR UN REGISTRO EN LA TABLA MEDICOS");
        System.out.println("3.ELIMINAR UN REGISTRO EN LA TABLA PACIENTES");
        System.out.println("2.INSERTAR UN REGISTRO EN LA TABLA PACIENTES");
        System.out.println("1.MOSTRAR EL CONTENIDO DE LA TABLA PACIENTES");
        System.out.println("0.SALIR");
        System.out.println("\n Por favor, escoja una opción.");
        System.out.println("--------------------------------");

        return sc.nextInt(); //Recibo un entero

    }


    public void conectar() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/consultorio", "root", "Jamaika#13");
            System.out.println("**************************************");
            System.out.println(" * CONEXIÓN REALIZADA CORRECTAMENTE * ");
            System.out.println("**************************************");
        } catch (Exception e) {
            System.out.println("*****************************************");
            System.out.println(" * NO SE HA PODIDO REALIZAR LA CONEXIÓN * ");
            System.out.println("******************************************");
        }

    }


    private void desconectar() {
        try {
            conexion.close();
            System.out.println("\n************************************************************\n");
            System.out.println("La conexion a la base de datos se ha terminado");
            System.out.println("\n************************************************************");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }
    private void consultarTabla() {

        ResultSet r = buscar("select PacDNI,PacNombre ,PacDomicilio from pacientes");
        try {
            System.out.println("REGISTROS DE LA TABLA PACIENTES");

            while (r.next()) {

                System.out.println(r.getInt("PacDNI") + " | " + r.getString("PacNombre") + " | " + r.getString("PacDomicilio"));
            }
        } catch (SQLException ex) {
            //     Logger.getLogger(PruebaC.class.getName()).log(Level.SEVERE, null, ex);
        }

    }


    ResultSet buscar(String sql) {
        try {
            sentencia = conexion.createStatement();

            return sentencia.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(Consultorio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }



    private void agregarTablaPacientes() {
        String usuario="root";
        String password="Jamaika#13";
        Scanner sc = new Scanner(System.in);

        System.out.println("Escriba el DNI del Paciente: ");
        int PacDni  = sc.nextInt(); //asigna la entrada de usuario a la DNI

        System.out.println("Ingrese el nombre del Paciente:  ");
        String PacNom = sc.next();

        System.out.println("Ingrese el domicilio del Paciente:  ");
        String PacDom = sc.next();

        String sql = "insert into pacientes (PacDNI,PacNombre,PacDomicilio) values ('"+PacDni+"','"+PacNom+"','"+PacDom+"')";
        Connection con=null;
        try{

            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/consultorio", usuario, password);
            Statement sentencia = con.createStatement();

            int m = sentencia.executeUpdate(sql);
            if (m == 1)
                System.out.println("Se realizo correctamente la insercion : "+sql);
            else
                System.out.println("fallo la insercion");
            con.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }



    /*MÉTODO PARA REALIZAR UNA ELIMINACION A UNA TABLA MYSQL*/
    private void eliminarRegistoEmpleados() {
        String usuario="root";
        String password="Jamaika#13";
        Scanner sc = new Scanner(System.in);

        System.out.println("Escriba el DNI del Paciente a eliminar:...");
        int PacDni  = sc.nextInt();

        String sql ="DELETE FROM pacientes WHERE PacDNI = '"+PacDni+"'";
        Connection con=null;

        try {
            //Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/consultorio", usuario, password);
            Statement sentencia = conexion.createStatement();
            sentencia.execute(sql);
            System.out.println("El registro se elimino!!");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error en el borrado del registro!!");
        }
    }
    private void agregarTablaMedicos() {
        String usuario="root";
        String password="Jamaika#13";
        Scanner sc = new Scanner(System.in);

        System.out.println("Escriba la matricula del Medico: ");
        int MedMatricula  = sc.nextInt(); //asigna la entrada de usuario a la DNI

        System.out.println("Ingrese el nombre del Medico:  ");
        String MedNombre = sc.next();

        System.out.println("Ingrese la especialidad del Medico:  ");
        String MedEspecialidad = sc.next();

        String sql = "insert into medico (MedMatricula,MedNombre,MedEspecialidad) values ('"+MedMatricula+"','"+MedNombre+"','"+MedEspecialidad+"')";
        Connection con=null;
        try{

            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/consultorio", usuario, password);
            Statement sentencia = con.createStatement();

            int m = sentencia.executeUpdate(sql);
            if (m == 1)
                System.out.println("Se realizo correctamente la insercion : "+sql);
            else
                System.out.println("fallo la insercion");
            con.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    private void eliminarRegistroMedico() {
        String usuario="root";
        String password="Jamaika#13";
        Scanner sc = new Scanner(System.in);

        System.out.println("Escriba la matricula del medico a eliminar:...");
        int MedMatricula  = sc.nextInt();

        String sql ="DELETE FROM medico WHERE MedMatricula = '"+MedMatricula+"'";
        Connection con=null;

        try {
            //Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/consultorio", usuario, password);
            Statement sentencia = conexion.createStatement();
            sentencia.execute(sql);
            System.out.println("El registro se elimino!!");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error en el borrado del registro!!");
        }
    }

    private void mostrarTablaMedicos() {

        ResultSet r = buscar("select MedMatricula,MedNombre ,MedEspecialidad from medico");
        try {
            System.out.println("REGISTROS DE LA TABLA MEDICOS");

            while (r.next()) {

                System.out.println(r.getInt("MedMatricula") + " | " + r.getString("MedNombre") + " | " + r.getString("MedEspecialidad"));
            }
        } catch (SQLException ex) {
            //     Logger.getLogger(PruebaC.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}