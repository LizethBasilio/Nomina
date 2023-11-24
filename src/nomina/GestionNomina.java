/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nomina;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;



/**
 *
 * @author Abigail Linares
 */
public class GestionNomina implements CalNomina{
    //Instancia con clases 
    Empleado ClassEmpleado = new Empleado();
    
    // Atributos
    //private double[] Empresa;
    //private double[] nominas;
    private double [] nominaEmpresa;
    private Map<String, double[]> ExpedienteN;

    
    public Empleado getClassEmpleado() {
        return ClassEmpleado;
    }

    public void setClassEmpleado(Empleado ClassEmpleado) {
        this.ClassEmpleado = ClassEmpleado;
    }

    public double[] getNominaEmpresa() {
        return nominaEmpresa;
    }

    // Metodos get y set
/*
    public double[] getEmpresa() {
    return Empresa;
    }
    public void setEmpresa(double[] Empresa) {
    this.Empresa = Empresa;
    }
    public double[] getNominas() {
    return nominas;
    }
    public void setNominas(double[] nominas) {
    this.nominas = nominas;
    }
     */
    public void setNominaEmpresa(double[] nominaEmpresa) {
        this.nominaEmpresa = nominaEmpresa;
    }
    
    public Map<String, double[]> getExpedienteN() {
        return ExpedienteN;
    }

    public void setExpedienteN(Map<String, double[]> ExpedienteN) {
        this.ExpedienteN = ExpedienteN;
    }
    
    
    // Interfaz
      
    @Override
    public void inicializarHistorialDeNomina() {
        ExpedienteN = new LinkedHashMap<>();
        String[] meses = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio",
        "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
        double[] nominaInicial = new double[] {0.0, 0.0, 0.0};
        for (String mes : meses) {
            ExpedienteN.put(mes, nominaInicial);
        }
    }
    
    @Override
    public void calcularNominaEmpresa(){
       double[] nomina = new double[] {0.0, 0.0, 0.0};
        for (Empleado empleado : Empleado.getEmpleados()) { //Error
            nomina[0] += empleado.getDiasTrabajados()* empleado.getPuestos().getSalarioPorDia();
            nomina[1] += empleado.getHorasExtras() * empleado.getPuestos().getPagoPorHoraExtra();
        }
        nomina[2] = nomina[0] + nomina[1];
        setNominaEmpresa(nomina); 
    }
    
    @Override
    public void calcularNominaEmpleado() {
        Empleado empleado = ClassEmpleado.BuscarEmpleado();
        Puesto puesto = empleado.getPuestos();
        empleado.setSalarioBase(empleado.getDiasTrabajados()*puesto.getSalarioPorDia());
        System.out.println("Colaborador: " + empleado.getNombre() + " " + empleado.getApellido() +" Salario Base: " +
                empleado.getSalarioBase() + " Horas Extra: " + empleado.getHorasExtras());
    }

    @Override
    public void guardarNomina() {
       System.out.println("¿Agregar nomina al expediente? \n 1.- Si  2.- No");
        int respuesta = new Scanner(System.in).nextInt();
        if (respuesta == 1) {
            System.out.println("Nomina pagada en el mes: ");
            String mesDeRegistro = new Scanner(System.in).nextLine();
            for (Map.Entry<String, double[]> nom : getExpedienteN().entrySet()) { //error 
                String mes = nom.getKey();
                if (mes.equalsIgnoreCase(mesDeRegistro)) {
                    ExpedienteN.put(mes, getNominaEmpresa());
                }
            }
        }  
    }

    
    @Override
    public void ListaNominas() {
        for (Map.Entry<String, double[]> entradaNomina : getExpedienteN().entrySet()) { //Error
            String mes = entradaNomina.getKey();
            double[] nomina = entradaNomina.getValue();
            System.out.println(mes + " - Salario Total: " + nomina[0] +
                    " - Horas Extra: " + nomina[1] + " - Total: " + nomina[2]);
        }
    }
    

    @Override
    public void OrdenAlfabetico() {
        Comparator<Map.Entry<String, double[]>> comparator = (mes1, mes2) -> mes1.getKey().compareTo(mes2.getKey());
        ExpedienteN.entrySet().stream().sorted(comparator).forEach(entry -> {System.out.println(
                entry.getKey() + "Desglose de la nomina:" + entry.getValue()[0] + 
                  "- Horas extra: " + entry.getValue()[1]
                + " \n Nomina total: " + entry.getValue()[2]
        );
        });
    }

    @Override
    public void MayorNomina() {
     Comparator<Map.Entry<String, double[]>> comparator = (nom1, nom2) -> -Double.compare(nom1.getValue()[2], nom2.getValue()[2]);
        ExpedienteN.entrySet().stream().sorted(comparator).forEach(entry -> {
            System.out.println(
                    entry.getKey() + "Desglose de la nomina: " + entry.getValue()[0] + 
                            " Horas extra: " + entry.getValue()[1]
                            + "\n Nomina total: " + entry.getValue()[2]
            );

        });
    }

    @Override
    public void MenorNomina() {
        Comparator<Map.Entry<String, double[]>> comparator = (nom1, nom2) -> Double.compare(nom1.getValue()[2], nom2.getValue()[2]);
        ExpedienteN.entrySet().stream().sorted(comparator).forEach(entry -> {
            System.out.println(
                    entry.getKey() + " Desglose de la nomina " + entry.getValue()[0] +
                            "- Horas extra: " + entry.getValue()[1]
                            + " \n Nomina total: " + entry.getValue()[2]
            );

        });
    }
    //Fin interfaz
    
    
   
   
    
}
