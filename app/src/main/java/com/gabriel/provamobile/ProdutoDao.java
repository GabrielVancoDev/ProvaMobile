package com.gabriel.provamobile;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Delete;
import androidx.room.Update;

@Dao
public interface ProductDao {

    // Inserção de Produtos
    @Insert
    void inserir(Product product);

    // Listagem de Produtos
    @Query("SELECT * FROM products ORDER BY nome ASC")
    List<Product> listarTodos();
}
