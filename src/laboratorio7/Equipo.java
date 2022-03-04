/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package laboratorio7;

import java.awt.image.PixelGrabber;
import java.text.DecimalFormat;
import java.text.ParsePosition;
import javax.security.auth.AuthPermission;

/**
 *
 * @author Diego Carcamo
 */
public class Equipo {
    
    private int PartJ,PartG,PartE,PartP,GolesF,GolesC,GolesD,Puntos;
    
    
    private  String nombre;

    public Equipo() {
    }
    
    
    
    

    public Equipo(String nombre,int PartJ, int PartG, int PartE, int PartP, int GolesF, int GolesC, int GolesD, int Puntos) {
        
        this.nombre=nombre;
        this.PartJ = PartJ;
        this.PartG = PartG;
        this.PartE = PartE;
        this.PartP = PartP;
        this.GolesF = GolesF;
        this.GolesC = GolesC;
        this.GolesD = GolesD;
        this.Puntos = Puntos;
    }

    public int getPartJ() {
        return PartJ;
    }

    public int getPartG() {
        return PartG;
    }

    public int getPartE() {
        return PartE;
    }

    public int getPartP() {
        return PartP;
    }

    public String getNombre() {
        return nombre;
    }
    

    public int getGolesF() {
        return GolesF;
    }

    public int getGolesC() {
        return GolesC;
    }

    public int getGolesD() {
        return GolesD;
    }

    public int getPuntos() {
        return Puntos;
    }

    public void setPartJ(int PartJ) {
        this.PartJ = PartJ;
    }

    public void setPartG(int PartG) {
        this.PartG = PartG;
    }

    public void setPartE(int PartE) {
        this.PartE = PartE;
    }

    public void setPartP(int PartP) {
        this.PartP = PartP;
    }

    public void setGolesF(int GolesF) {
        this.GolesF = GolesF;
    }

    public void setGolesC(int GolesC) {
        this.GolesC = GolesC;
    }

    public void setGolesD(int GolesD) {
        this.GolesD = GolesD;
    }

    public void setPuntos(int Puntos) {
        this.Puntos = Puntos;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString(){
    
        return nombre;
    
    
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
