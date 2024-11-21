/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.carrerahilos;


import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alumno
 */
public class CarreraHilos implements Runnable {
    
    private int cocheId; 
    private CarreraVisual carrera;
    
    public CarreraHilos(int cocheId, CarreraVisual carrera) {
        this.cocheId = cocheId;
        this.carrera = carrera;
    }
    
    @Override
    public void run() {
        
       
    }

    
}
