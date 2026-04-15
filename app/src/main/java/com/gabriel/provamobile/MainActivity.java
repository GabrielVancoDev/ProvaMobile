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

        productDao = db.productDao();

//        Botão de Salvar Produtos
        btnSalvar.setOnClickListener(v -> {
            Log.d("MainActivity", "Botão salvar clicado");

//            Criando variáveis que recebem os dados digitados
            String nome = etNome.getText().toString().trim();
            String codigo = etCodigo.getText().toString().trim();
            String precoStr = etPreco.getText().toString().trim();
            String quantidadeStr = etQuantidade.getText().toString().trim();

// Validações:
//  Campos Vazios
    if (nome.isEmpty() || codigo.isEmpty() | precoStr.isEmpty() || quantidade.isEmpty()){
        Toast.makeText(this, "Preencha todos os campos!", Toast.LENGTH_SHORT).show();
        return;
    }
            // Preço positivo até duas casas
            if (!precoStr.matches("^\\d+(\\.\\d{1,2})?$")) {
                Toast.makeText(this, "Preço inválido! Use até 2 casas decimais.", Toast.LENGTH_SHORT).show();
                return;
            }

            double preco = Double.parseDouble(precoStr);
            if (preco <= 0) {
                Toast.makeText(this, "Preço deve ser positivo!", Toast.LENGTH_SHORT).show();
                return;
            }

            // Números Inteiros Positivos
            if (!quantidadeStr.matches("^\\d+$")) {
                Toast.makeText(this, "Quantidade inválida!", Toast.LENGTH_SHORT).show();
                return;
            }

            //  Criar produto
            Product product = new Product();
            product.nome = nome;
            product.codigo = codigo;
            product.preco = preco;
            product.quantidade = quantidade;

            //  Salvar no banco
            productDao.inserir(product);

            Log.d("MainActivity", "Produto salvo com sucesso");

            Toast.makeText(this, "Produto cadastrado!", Toast.LENGTH_SHORT).show();

            // limpar campos
            etNome.setText("");
            etCodigo.setText("");
            etPreco.setText("");
            etQuantidade.setText("");
        });

        // BOTÃO LISTA
        btnLista.setOnClickListener(v ->
                startActivity(new Intent(MainActivity.this, ListaActivity.class))
        );
    }

    }
