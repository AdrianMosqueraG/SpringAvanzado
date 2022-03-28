package com.example.SA2.SubirBajarFicheros.exception;

public class CountryNotFoundException extends RuntimeException {
    public CountryNotFoundException(){
        super();
    }
    public CountryNotFoundException(String id){
        super("Country not found: "+id);

}}
