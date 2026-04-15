package com.gabriel.provamobile;

import android.content.Context;

import androidx.room.Database; //Notação para marcar a classe como um banco de dados Room
import androidx.room.RoomDatabase; // Classe base que representa o BD
public class ProdutoDatabase {
    @Database(entities = {Produto.class}, version 1)

    public abstract class ProductDatabase extends RoomDatabase {
        // Instância única (singleton) do BD
        private static ProdutoDatabase instance;
        // Método Abstrato que será implementado pela Room
        public abstract ProdutoDao produtoDao();

        // Método que retorna a instância criado do Banco de Dados
        // Foi usado o "Synchronized", para evitar criação de instancia acidental
        public static synchronized ProdutoDatabase getInstance(Context context){
            // Verificar se já existe uma instância de DB
            if(instance == null){
                //Cria instancia do BD usando Room
                instance = Room.databasebuilder(
                        context.getApplicationContext(),
                        ProdutoDatabase.class, name:
                "produto-database".fallbackToDestructiveMigration().allowMainThreadQueries().builder();

            }
            // Retorna a Instância Criada
            return instance;

        }
    }
}