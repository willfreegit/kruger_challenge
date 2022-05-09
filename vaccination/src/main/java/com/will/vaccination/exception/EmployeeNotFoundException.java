package com.will.vaccination.exception;

public class EmployeeNotFoundException extends RuntimeException {
    public EmployeeNotFoundException(String id) {
        super("No se pudo encontrar el empleado " + id);
    }
}
