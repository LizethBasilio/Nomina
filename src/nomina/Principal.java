/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
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
public class Principal {
//Holi
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Puesto ClassPuesto = new Puesto();
        Empleado ClassEmpleado = new Empleado();
        GestionNomina nomina = new GestionNomina();
        
        ClassPuesto.ini();
        ClassEmpleado.Ini();
        Scanner sc = new Scanner(System.in);
        //Agregar puestos
        Puesto p1 =new Puesto(1,"DIRECTOR GENERAL", 1900, 0);
        Puesto p2 =new Puesto(2,"DIRECTOR DE ÁREA", 1000, 0);
        Puesto p3 =new Puesto(3,"SUPERVISOR", 850, 214.67);
        Puesto p4 =new Puesto(4,"ASISTENTE", 750,186.45);
        Puesto p5 =new Puesto(5,"AUXILIAR", 500, 120.34);
        
        ClassPuesto.ListaPuestos(p1);
        ClassPuesto.ListaPuestos(p2);
        ClassPuesto.ListaPuestos(p3);
        ClassPuesto.ListaPuestos(p4);
        ClassPuesto.ListaPuestos(p5);
        
        //empleado de prueba
        
        Empleado em1 =new Empleado(1,"Lizeth","Basilio","Unicornios #3",26,20,2, p2);
        ClassEmpleado.ListaEmpleados(em1);
        
        
        int opcion;

        do {
            System.out.println("Menu principal \n "
            +"1. Ingreso de un colaborador\n"
            +"2. Baja de un colaborador \n"
            +"3. Actualizar empleado\n"
            +"4. Registrar dias trabajados\n"
            +"5. Registrar horas extra\n"
            +"6. Registro de puestos\n"
            +"7. Calcular nomina\n"
            +"8. Ver historial de nomina\n"
            +"9. Salir");
            try {
                opcion = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Caracter invalido");
                sc.nextLine();
                continue;
            }
            switch (opcion) {
                case 1 -> {
                    int op;
                    do {
                        System.out.println("Expediente de Colaboradores\n"
                                + "1.- Ver Expediente\n"
                                + "2.- Nuevo expediente\n"
                                + "3.- Regresar al menu anterior");
                        try {
                            System.out.println("----");
                            op = sc.nextInt();
                        } catch (InputMismatchException e) {
                            System.out.println("Caracter invalido");
                            sc.nextLine();
                            continue;
                        }
                        if (op == 1) {
                             ClassEmpleado.TodosEmpleados();
                        } else if (op == 2) {
                            //System.out.println("ID: ");
                            int id;
                            Empleado empleado;
                            do {
                                try {
                                    System.out.println("ID: ");
                                    id = sc.nextInt();
                                } catch (InputMismatchException e) {
                                    System.out.println("Caracter invalido");
                                    sc.nextLine();
                                    continue;
                                }
                                empleado = ClassEmpleado.EmpleadoID(id);
                                if (empleado != null) {
                                    System.out.println("Este ID ya ha sido registrado anteriormente");
                                           
                                } else {
                                    break;
                                }
                            } while (true);
                           
                            String[] datos = new String[3];
                            int[] n = new int[3];
                            System.out.println("Nombre: ");
                            sc.nextLine();
                            datos[0] = sc.nextLine();
                            System.out.println("Apellido: ");
                            datos[1] = sc.nextLine();
                            System.out.println("Domicilio: ");
                            datos[2] = sc.nextLine();

                            do {
                                try {
                                    System.out.println("Edad: ");
                                    n[0] = sc.nextInt();
                                    break;
                                } catch (InputMismatchException e) {
                                    System.out.println("Caracter invalido");
                                    sc.nextLine();
                                }
                            } while (true);

                            //System.out.println("Dias de trabajo: ");
                            n[1] = ClassEmpleado.Diaslaborales();

                            //System.out.println("Horas extra: ");
                            n[2] = ClassEmpleado.HorasExtra();

                            System.out.println("Ingrese el nombre del puesto \nVacantes disponibles: ");
                            for (Puesto p : ClassPuesto.getPuestos()) {
                                System.out.println("->" + p.getNombrePuesto());
                                
                            }
                            System.out.println("ingrese puesto correspondiente del colaborador ");
                            sc.nextLine();
                            Puesto puesto = ClassPuesto.ExistenciaP();
                            
                            ClassEmpleado.ListaEmpleados(new Empleado(id, datos[0], datos[1], datos[2],
                                    n[0], n[1], n[2],puesto));
                            

                            System.out.println("Ha ingresado "+datos[0]+" "+datos[1]);
                        } else {
                            break;
                        }
                    } while (true);
                }
                case 2 -> {
                    // Dar de baja a un empleado
                    System.out.println("Ingrese el ID del colaborador que desea dar de baja: ");
                    Empleado bajaEmpleado = ClassEmpleado.BuscarEmpleado();
                    if (bajaEmpleado != null) {
                        Empleado.getEmpleados().remove(bajaEmpleado);
                        System.out.println("Usuario dado de baja");
                    }
                }
                case 3 -> {
                    // Actualizar datos de un empleado
                    System.out.println("Ingrese el ID del colaborador: ");
                    Empleado act = ClassEmpleado.BuscarEmpleado();
                    try{
                        sc.nextLine();
                    }catch(InputMismatchException e){
                        System.out.println("Carcater invalido");
                        sc.nextLine();
                        continue;
                    } 
                    ClassEmpleado.actualizarEmpleado(act);
                    
                }
                //dias laborados
                case 4 -> {
                    int op;                  
                    do {
                        System.out.println("Menu para registrar dias laborados\n"
                                + "1.- Empleado\n"
                                + "2.- Empresa\n"
                                + "3.- Regresar al menu anterior ");
                        try {
                            op = sc.nextInt();
                        } catch (InputMismatchException e) {
                            System.out.println("Carcater invalido");
                            sc.nextLine();
                            continue;
                        }
                        // para uno
                        if (op == 1) {
                            System.out.println("Ingrese el ID del empleado: ");
                            Empleado empleado = ClassEmpleado.BuscarEmpleado();
                            sc.nextLine();
                            System.out.println("Ingrese los dias laborados por: " + empleado.getNombre() +" " + empleado.getApellido());
                            empleado.DiasLaboradosEmpleado();
                        //para todos       
                        } else if (op == 2) {
                            System.out.println("Ingrese la cantidad de horas laboradas: ");
                            ClassEmpleado.DiasLaborados();
                        }
                        if (op == 3) {
                            break;
                        }
                    } while (true);
                }
                //Horas extras
                case 5 -> {
                    
                    int op;
                    
                    do {
                        System.out.println("Registro de horas extras\n"
                                + "1.- Colaborador\n"
                                + "2.- Regresar al menu anterior");
                        try {
                            op = sc.nextInt();
                        } catch (InputMismatchException e) {
                            System.out.println("Caracter incorrecto");
                            sc.nextLine();
                            continue;
                        }
                        // Empleado
                        if (op == 1) {
                            System.out.println("Ingrese el ID del empleado: ");
                            Empleado empleado = ClassEmpleado.BuscarEmpleado();
                            System.out.println("Ingrese las horas extra de: " + empleado.getNombre() + " "+ empleado.getApellido());
                            empleado.HorasExtraEmpleado();
                        } 
                        if (op == 2) {
                            break;
                        }
                    } while (true);
                }
                //agregar puesto
                case 6 -> {
                    int op;
                    do {
                        System.out.println("Expediente de Puestos\n"
                                + "1.- Ver puestos\n"
                                + "2.- Nuevo puesto\n"
                                + "3.- Regresar al menu anterior");
                        try {
                            op = sc.nextInt();
                        } catch (InputMismatchException e) {
                            System.out.println("Caracter invalido");
                            sc.nextLine();
                            continue;
                        }
                        if(op == 1) {
                            ClassPuesto.Puestos();
                        } else if (op == 2) {
                            int idPuesto = ClassPuesto.PuestoId();
                            sc.nextLine();
                            
                            System.out.println("Nombre: ");
                            String nombrePuesto;
                            Puesto nuevoPuesto;
                            do {
                                nombrePuesto = sc.nextLine();
                                nuevoPuesto = ClassPuesto.PuestoNombre(nombrePuesto);
                                if (nuevoPuesto != null) {
                                    System.out.println("Puesto ya existente");
                                } else {
                                    break;
                                }
                            } while (true);
                            System.out.println("Salario por dia: ");
                            double salarioPorDia;
                            try {
                                salarioPorDia = sc.nextDouble();
                            } catch (InputMismatchException e) {
                                System.out.println("Caracter invalido");
                                sc.nextLine();
                                continue;
                            }
                            System.out.println("Salario por hora extra: ");
                            double salarioPorHoraExtra;
                            try {
                                salarioPorHoraExtra = sc.nextDouble();
                            } catch (InputMismatchException e) {
                                System.out.println("Caracter invalido");
                                sc.nextLine();
                                continue;
                            }
                            ClassPuesto.getPuestos().add(new Puesto(idPuesto, nombrePuesto, salarioPorDia,salarioPorHoraExtra));
                            System.out.println("Puesto agregado a la lista");
                        } else {
                            break;
                        }
                    } while (true);
                }
                // Calcular nomina
                case 7 -> {
                    int op;
                    
                    do {
                        System.out.println("Calcular nomina:\n"
                                + "1.- Colaborador\n"
                                + "2.- Empresa\n"
                                + "3.- Regresar al menu anterior");
                        try {
                            op = sc.nextInt();
                        } catch (InputMismatchException e) {
                            System.out.println("Caracter invalido");
                            sc.nextLine();
                            continue;
                        }
                        if (op == 1) {
                            System.out.println("Ingrese el ID del colaborador: ");
                            nomina.calcularNominaEmpleado();
                            nomina.guardarNomina();
                        } else if (op == 2) {
                            nomina.calcularNominaEmpresa();
                            System.out.println("La nomina ha sido calculada");
                            nomina.guardarNomina();
                            //System.out.println("Se ha agregado al expediente");
                        }
                        if (op == 3)  {
                            break;
                        }
                    } while (true);
                }
                case 8 -> {
                   // System.out.println("Expediente de nominas");
                   // nomina.ListaNominas();
                    
                    int op;
                    do {
                        System.out.println("Expediente de nominas\n"
                        +"1. Mostrar todas las nominas\n"
                        +"2. Mostrar en orden alfabetico\n"
                        +"3. Mostrar de menor a mayor facturacion\n"
                        +"4. Mostrar de mayor a menor facturacion\n"
                        +"5. Regresar al menu anterior.");
                        try {
                            op = sc.nextInt();
                        } catch (InputMismatchException e) {
                            System.out.println("Carcater invalido");
                            sc.nextLine();
                            continue;
                        }

                        switch (op) {
                            case 1 -> {
                                System.out.println("Listado de Nominas");
                                nomina.ListaNominas();
                            }
                            case 2 -> {
                                System.out.println("Orden Alfabetico");
                                nomina.OrdenAlfabetico();
                            }
                            case 3 -> {
                                System.out.println("Menor a Mayor");
                                nomina.MenorNomina();
                            }
                            case 4 -> {
                                System.out.println("Mayor a Menor");
                                nomina.MayorNomina();
                            }
                        }

                        if (op == 5) {
                            break;
                        }
                    } while (true);
                }
               
            }
            if (opcion == 9) {
                break;
            }
        } while (true);
    }
        
    }
    

