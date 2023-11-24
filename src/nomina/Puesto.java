/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nomina;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;


public class Puesto {
    //Atributos
    private int idPuesto;
    private String nombrePuesto;
    private double salarioPorDia;
    private double pagoPorHoraExtra;
    private static List<Puesto> puestos;
    
    //Metodos set y get 

    public int getIdPuesto() {
        return idPuesto;
    }

    public void setIdPuesto(int idPuesto) {
        this.idPuesto = idPuesto;
    }

    public String getNombrePuesto() {
        return nombrePuesto;
    }

    public void setNombrePuesto(String nombrePuesto) {
        this.nombrePuesto = nombrePuesto;
    }

    public List<Puesto> getPuestos() {
        return puestos;
    }

    public void setPuestos(List<Puesto> puestos) {
        Puesto.puestos = puestos;
    }

    
    public double getSalarioPorDia() {
        return salarioPorDia;
    }

    public void setSalarioPorDia(double salarioPorDia) {
        this.salarioPorDia = salarioPorDia;
    }

    public double getPagoPorHoraExtra() {
        return pagoPorHoraExtra;
    }

    public void setPagoPorHoraExtra(double pagoPorHoraExtra) {
        this.pagoPorHoraExtra = pagoPorHoraExtra;
    }
    //Constructores

    public Puesto(int idPuesto, String nombrePuesto, double salarioPorDia, double pagoPorHoraExtra) {
        this.idPuesto = idPuesto;
        this.nombrePuesto = nombrePuesto;
        this.salarioPorDia = salarioPorDia;
        this.pagoPorHoraExtra = pagoPorHoraExtra;
    }

    public Puesto() {
    }
    //Metodos de comportamiento     
    public void ini(){
        puestos= new ArrayList<>();
    }
    
    //Agregar puesto
    public void ListaPuestos(Puesto puesto) {
        puestos.add(puesto);
    }
    
    //Mostrar todos los puesto 
     public void Puestos() {
        for (Puesto e : puestos) {
            System.out.printf("ID: " + e.getIdPuesto(),
                    "\nPuesto: " + e.getNombrePuesto(),
                    "\nSalario por día: " + e.getSalarioPorDia(),
                    "\nHora extra: "+ e.getPagoPorHoraExtra() );
            
        }
    }
    
    //Eliminar
    public void eliminarPuesto(Puesto puesto) {
        puestos.remove(puesto);
    }
    
    //Buscar el puesto por nombre 
    public Puesto PuestoNombre(String nombrePuesto) {
        for (Puesto puesto : puestos) {
            if (puesto.getNombrePuesto().equalsIgnoreCase(nombrePuesto)) {
                return puesto;
            }
        }
        return null;
    }
    
    public Puesto ExistenciaP() {
        Puesto puesto;
        do {
            puesto = PuestoNombre(new Scanner(System.in).nextLine());
            if (puesto == null) {
                System.out.println("Id incorrecto o inexistente");
            }
        } while (puesto == null);

        return puesto;
    }
    
    //metodo para buscar por id 
    public Puesto PuestoPorID(int idPuesto) {
        for (Puesto puesto : puestos) {
            if (puesto.getIdPuesto() == idPuesto) {
                return puesto;
            }
        }
        return null;
    }
    
   //Buscar el puesto por Id
    public int PuestoId() {
        System.out.println("ID: ");

        int idPuesto;
        Puesto puesto;

        do {
            try {
                System.out.println("ID: ");
                idPuesto = new Scanner(System.in).nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Caracter invalido");
                new Scanner(System.in).nextLine();
                continue;
            }
            puesto = PuestoPorID(idPuesto);

            if (puesto != null) {
                System.out.println("Id ya existente");
            } else {
                return idPuesto;
            }
        } while (true);
    }
}
