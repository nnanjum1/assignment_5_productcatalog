package com.example.productcatalog;

import android.os.Bundle;
import androidx.appcompat.widget.SearchView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SearchView searchView = findViewById(R.id.searchView);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<Product> productList = new ArrayList<>();
        productList.add(new Product("Ballpoint Pen", "Smooth writing pen", 5.0, R.drawable.img));
        productList.add(new Product("Notebook", "100 pages ruled notebook", 70.0, R.drawable.img_1));
        productList.add(new Product("Eraser", "High-quality eraser", 10.0, R.drawable.img_2));
        productList.add(new Product("Pencil", "Pack of 10 pencils", 80.0, R.drawable.img_3));
        productList.add(new Product("Sharpener", "Durable dual-hole sharpener", 15.0, R.drawable.img_4));
        productList.add(new Product("Highlighter", "Bright yellow highlighter", 40.0, R.drawable.img_5));
        productList.add(new Product("Sticky Notes", "100-sheet sticky notes", 60.0, R.drawable.img_6));
        productList.add(new Product("Glue Stick", "Non-toxic glue stick", 30.0, R.drawable.img_7));
        productList.add(new Product("Scissors", "Stainless steel scissors", 40.0, R.drawable.img_8));
        productList.add(new Product("Ruler", "12-inch transparent ruler", 50, R.drawable.img_9));


        ProductAdapter adapter = new ProductAdapter(productList);
        recyclerView.setAdapter(adapter);


        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                List<Product> filteredList = new ArrayList<>();
                for (Product product : productList) {
                    if (product.getName().toLowerCase().contains(newText.toLowerCase())) {
                        filteredList.add(product);
                    }
                }
                adapter.filterList(filteredList); // Update RecyclerView
                return true;
            }
        });
    }
}