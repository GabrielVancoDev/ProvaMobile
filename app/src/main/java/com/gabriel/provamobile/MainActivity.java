package com.gabriel.provamobile;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;
import android.util.Log;


public class MainActivity extends AppCompatActivity {

    // Listando as entidades, para possibilitar salvar, editar e excluir
    private EditText etNome, etCodigo, etPreco, etQuantidade;
    private ProductDao productDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Campos
        etNome = findViewById(R.id.etNome);
        etCodigo = findViewById(R.id.etCodigo);
        etPreco = findViewById(R.id.etPreco);
        etQuantidade = findViewById(R.id.etQuantidade);

        // Botões
        Button btnSalvar = findViewById(R.id.btnSalvar);
        Button btnLista = findViewById(R.id.btnLista);


        // Banco de dados
        ProductDatabase db = Room.databaseBuilder(
                getApplicationContext(),
                ProductDatabase.class,
                "product-db"
        ).allowMainThreadQueries().build();

        // Banco de dados
        ProductDatabase db = Room.databaseBuilder(
                getApplicationContext(),
                ProductDatabase.class,
                "product-db"
        ).allowMainThreadQueries().build();

        productDao = db.productDao();

//        Botão de Salvar Produtos
        btnSalvar.setOnClickListener(v -> {
            Log.d("MainActivity", "Botão salvar clicado");

//            Criando variáveis que recebem os dados digitados
            String nome = etNome.getText().toString().trim();
            String codigo = etCodigo.getText().toString().trim();
            String precoStr = etPreco.getText().toString().trim();
            String quantidadeStr = etQuantidade.getText().toString().trim();



        });
    }

}