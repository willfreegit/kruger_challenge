package com.will.vaccination.exception;

public class RequiredFieldException extends Exception{
    public RequiredFieldException(){
        super("Los campos cedula, nombre, apellido y correo son obligatorios");
    }
}
