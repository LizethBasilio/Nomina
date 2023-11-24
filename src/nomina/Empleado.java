/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nomina;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Abigail Linares
 */
public class Empleado extends Persona {
    //Atributos
    private int diasTrabajados;
    private int horasExtras;
    private Puesto puestos;
    private static List<Empleado>empleados;
    private double SalarioBase;
    
    
    //Metodos get y set
    public double getSalarioBase() {
        return SalarioBase;
    }

    public void setSalarioBase(double SalarioBase) {
        this.SalarioBase = SalarioBase;
    }

    public static List<Empleado> getEmpleados() {
        return empleados;
    }

    public static void setEmpleados(List<Empleado> empleados) {
        Empleado.empleados = empleados;
    }

    public int getDiasTrabajados() {
        return diasTrabajados;
    }

    public void setDiasTrabajados(int diasTrabajados) {
        this.diasTrabajados = diasTrabajados;
    }

    public int getHorasExtras() {
        return horasExtras;
    }

    public void setHorasExtras(int horasExtras) {
        this.horasExtras = horasExtras;
    }

    public Puesto getPuestos() {
        return puestos;
    }

    public void setPuesto(Puesto puestos) {
        this.puestos = puestos;
    }
    //Constructores
    public Empleado(int id, String nombre, String apellido, String domicilio, int edad,int diasDeTrabajo, int horasExtra, Puesto puestos) {
        super(id, nombre, apellido, domicilio, edad);
        this.diasTrabajados = diasTrabajados;
        this.horasExtras = horasExtras;
        this.puestos = puestos;
    }

    

  

    public Empleado() {
        super();
        this.diasTrabajados = 0;
        this.horasExtras = 0;
        this.puestos = null;
    }
      
    //Metodos de comportamiento
    public void Ini(){
        empleados=new ArrayList<>();
    }
    //Agregar
    public void ListaEmpleados(Empleado emple) {
        empleados.add(emple);
    } 
     
    //Mostrar todos los empleados
    public void TodosEmpleados() {
       for (Empleado e : Empleado.getEmpleados()) {
            System.out.println("ID: " + e.getId()+
                   "\nNombre: " + e.getNombre()+" "+ e.getApellido()+
                   "\nEdad: " + e.getEdad());
            System.out.println( "Puesto: " + e.getPuestos().getNombrePuesto() + "\n");
       }
    }
    
    //Elminar 
    public void eliminarEmpleado(Empleado empleado) {
        empleados.remove(empleado);
    }
    
    //Modificar datos por opciones
    public void actualizarEmpleado(Empleado empleado) {
        int opcion;
        do {
            System.out.println("Actualizar datos\n"
            +"1. Nombre\n"
            +"2. Apellido\n"
            +"3. Edad\n"
            +"4. Dirección\n"
            + "5. Regresar al menu anterior");
            try {
                System.out.println("Ingrese la opcion deseada: ");
                opcion = new Scanner(System.in).nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Opcion invalida. Solo se permiten caracteres numericos.");
                new Scanner(System.in).nextLine();
                continue;
            }
            switch (opcion) {
                case 1 -> {
                    // Cambiar nombre
                    System.out.println("Ingrese el nuevo nombre: ");
                    empleado.setNombre(new Scanner(System.in).nextLine());
                    System.out.println("Se actualizo el Nombre: " +
                            empleado.getNombre());
                }
                case 2 -> {
                    // Cambiar apellido
                    System.out.println("Ingrese el nuevo apellido: ");
                    empleado.setApellido(new Scanner(System.in).nextLine());
                    System.out.println("Se actualizo el Apellido: " +
                            empleado.getApellido());
                }
                case 3 -> {
                    // Cambiar edad
                    do {
                        try {
                            System.out.println("Ingrese la nueva edad: ");
                            empleado.setEdad(new Scanner(System.in).nextInt());
                            break;
                        } catch (InputMismatchException e) {
                            System.out.println("Caracter Invalido");
                        }
                    } while (true);

                    System.out.println("Se actualizo la Edad: " +
                            empleado.getEdad());
                }
                case 4 ->{
                    //Cambiar dirección
                    System.out.println("Ingrese la dirección ");
                    empleado.setDomicilio(new Scanner(System.in).nextLine());
                    System.out.println("Se actualizo la Dirección: " +
                            empleado.getDomicilio());

                }
                
            }
            if (opcion == 5) {
                break;
            }
        } while (true);
    }
    
     //Agregar dia laborados por empleado
    public void DiasLaboradosEmpleado() {
        int dias;
        do {
            try {
                System.out.println("Dias laborados: ");
                dias = new Scanner(System.in).nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Caracter invalido");
                continue;
            }
            if (dias > 1 && dias <= 20) {
                this.setDiasTrabajados(dias);
                System.out.println("Se han agregado "+this.getDiasTrabajados()+" dias laborados a tu registro");
                break;
            } else if (dias > 20) {
                System.out.println("Excede tus dias laborados");
                System.out.println("Dias laborados: ");
            }
        } while (true);
    }
    //Registrar dias laborados a empleados
    public void DiasLaborados() {
        int dias;
        do {
            try {
                System.out.println("Dias laborados: ");
                dias = new Scanner(System.in).nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Caracter invalido");
                continue;
            }
            if (dias > 0 && dias <= 20) {
                for (Empleado empleado : empleados) {
                    empleado.setDiasTrabajados(dias);
                }
                System.out.println("Se han agragado tus dias laborados a tu registro");
                break;
            } else if (dias > 20){
                System.out.println("Excede de tus días laborales");
            } 
        } while (true);
        
    }
    public int Diaslaborales() {
        int dias;
        do {
            try {
                System.out.println("Dias de laborados:");
                dias = new Scanner(System.in).nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Caracter invalido");
                continue;
            }
            if (dias > 20 || dias < 0) {
                System.out.println("Excede de los dias laborales permitidos");
            } else {
                return dias;
            }
        } while (true);
    }

    //Agregar horas extras por empleado
    public void HorasExtraEmpleado() {
        int horas;
        do {
            try {
                System.out.println("Horas extra: ");
                horas = new Scanner(System.in).nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Solo se permiten caracteres numericos.");
                continue;
            }
            if (horas > 1 && horas <= 40) {
                this.setHorasExtras(horas);
                System.out.println("Se han agregado "+this.getHorasExtras()+" horras extras a tu registro");
                break;
            } else if (horas > 40) {
                System.out.println("Excede el tiempo de horas permitidas");
                
            }
        } while (true);
    }
    //verificar horas extras
    public int HorasExtra() {
        int horas;
        do {
            try {
                System.out.println("Horas extra: ");
                horas = new Scanner(System.in).nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Caracter invalido");
                continue;
            }
            if (horas > 40 || horas < 1) {
                System.out.println("Excede el numero de horas extra permitidas");
            } else {
                return horas;
            }
        } while (true);
    }
   
    //Metodo para buscar por Id al empleado
    public Empleado EmpleadoID(int id) {
        for (Empleado empleado : empleados) {
            if (empleado.getId() == id) {
                return empleado;
            }
        }
        return null;
    }
    
    //Busqueda
    public Empleado BuscarEmpleado() {
        Empleado empleado;
        do {
            try {
                empleado = EmpleadoID(new Scanner(System.in).nextInt());
            } catch (InputMismatchException e) {
                System.out.println("Caracter invalido");
                continue;
            }
            if (empleado == null) {
                System.out.println("ID incorrecto o inexistente.\n Ingresa ID: ");
            } else {
                break;
            }
        } while (true);
        return empleado;
    }
   
   
}
