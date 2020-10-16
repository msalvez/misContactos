package muustack.com.miscontactos;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toolbar;

import androidx.appcompat.app.AppCompatActivity;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Favoritos extends AppCompatActivity {
    private RecyclerView listMascotas;
    private ImageButton atras;
    ArrayList<Mascota> mascotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.favoritos);

        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);


        listMascotas = (RecyclerView) findViewById(R.id.rvFavoritos);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listMascotas.setLayoutManager(llm);

        initMascotas();
        inicilizarAdaptador();

        atras = (ImageButton) findViewById(R.id.atras);
        atras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    private void setSupportActionBar(Toolbar miActionBar) {
    }

    private void inicilizarAdaptador(){
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas,this);
        listMascotas.setAdapter(adaptador);
    }

    public void initMascotas(){
        mascotas = new ArrayList<Mascota>();
        mascotas.add(new Mascota(1,"Malebo",R.drawable.perro1,"4"));
        mascotas.add(new Mascota(1,"Bestia",R.drawable.perro2,"6"));
        mascotas.add(new Mascota(1,"Coki",R.drawable.perro3,"8"));
        mascotas.add(new Mascota(1,"Rico",R.drawable.perro4,"5"));
        mascotas.add(new Mascota(1,"Yimbo",R.drawable.perro5,"1"));

    }
}
