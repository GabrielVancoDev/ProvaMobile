package com.gabriel.provamobile;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import java.util.List;

public class ReportActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ProductDao productDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);

        recyclerView = findViewById(R.id.recyclerViewProdutos);

        ProductDatabase db = Room.databaseBuilder(
                getApplicationContext(),
                ProductDatabase.class,
                "product-db"
        ).allowMainThreadQueries().build();

        productDao = db.productDao();

        // Buscar dados
        List<Product> lista = productDao.listarTodos();

        // Adapter
        ProductAdapter adapter = new ProductAdapter(lista);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }

    // botão voltar (usado no XML)
    public void voltarParaCadastro(View view) {
        finish();
    }
}