package com.example.SA2.SubirBajarFicheros.exception;

public class CityNotFoundException extends RuntimeException {
    public CityNotFoundException(){
        super();
    }
    public CityNotFoundException(String message){
        super(message);
    }
    public CityNotFoundException(Integer id){
        super("City not found: "+id);
    }
}
