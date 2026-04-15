package com.gabriel.provamobile;

import androidx.room.Dao;
import androidx.room.Entity;
import androidx.room.Insert;
import androidx.room.PrimaryKey;
import androidx.room.Query;

import java.util.List;

//  Entidades
@Entity
public class Produto {

//Auto gera as chaves primárias
    @PrimaryKey(autoGenerate = true)
    public int id;

    public String nome;
    public String codigo;
    public double preco;
    public int quantidade;


}
