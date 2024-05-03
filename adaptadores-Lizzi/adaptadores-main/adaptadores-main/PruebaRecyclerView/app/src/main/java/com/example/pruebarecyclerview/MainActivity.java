package com.example.pruebarecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.pruebarecyclerview.adaptadores.UsuarioAdaptador;
import com.example.pruebarecyclerview.clases.Usuario;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements UsuarioAdaptador.OnItemClickListener {

    RecyclerView rcv_usuarios;
    List<Usuario> usuarioList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rcv_usuarios = findViewById(R.id.rcv_usuarios);

        Usuario usu1 = new Usuario("https://iv1.lisimg.com/image/1071081/740full-harry-potter-and-the-goblet-of-fire-photo.jpg", "HARRY", "ACTOR");
        Usuario usu2 = new Usuario("https://vignette.wikia.nocookie.net/warner-bros-entertainment/images/6/6e/VoldemortHeadshot_DHP1.png/revision/latest?cb=20180126164438", "SR VOLDY", "HECHICERO");
        Usuario usu3 = new Usuario("https://lh6.googleusercontent.com/-Ev_4mU1K5h8/TXE8W_kJx-I/AAAAAAAAAFE/IA0_YuW5m4w/s1600/tumblr_lhhvbsxJlx1qajz3yo1_1280.jpg", "HERMIONE", "BRUJA");

        usuarioList.add(usu1);
        usuarioList.add(usu2);
        usuarioList.add(usu3);

        rcv_usuarios.setLayoutManager(new LinearLayoutManager(this));
        rcv_usuarios.setAdapter(new UsuarioAdaptador(usuarioList));

        UsuarioAdaptador adaptador = new UsuarioAdaptador(usuarioList);
        rcv_usuarios.setAdapter(adaptador);
        adaptador.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(Usuario usuario) {
        Intent i = new Intent(MainActivity.this, MainActivity2.class);
        startActivity(i);
    }
}