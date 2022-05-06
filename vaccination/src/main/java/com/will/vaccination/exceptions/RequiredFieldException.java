package com.will.vaccination.exceptions;

public class RequiredFieldException extends Exception{
    public RequiredFieldException(){
        super("Los campos cedula, nombre, apellido y correo son obligatorios");
    }
}
