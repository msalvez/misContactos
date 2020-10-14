package muustack.com.miscontactos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toolbar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Contacto> contactos;
    private RecyclerView listaContactos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        listaContactos = (RecyclerView) findViewById(R.id.rvContactos);

       /*LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);*/

        GridLayoutManager glm = new GridLayoutManager(this,2);

        listaContactos.setLayoutManager(glm);
        inicializarListaDeContactos();
        inicializarAdaptador();

        /*ArrayList<String> nombresContacto = new ArrayList<>();
        for (Contacto contacto : contactos) {
            nombresContacto.add(contacto.getNombre());
        }*/

        /*ListView lstContactos = (ListView) findViewById(R.id.contactos);
        lstContactos.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, nombresContacto));

        lstContactos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, DetalleContacto.class);
                intent.putExtra("Nombre",contactos.get(position).getNombre());
                intent.putExtra("Telefono",contactos.get(position).getTelefono());
                intent.putExtra("Email",contactos.get(position).getEmail());
                startActivity(intent);
                finish();
            }
        }); */
    }
    public ContactoAdaptador adaptador;
    private void inicializarAdaptador(){
        adaptador = new ContactoAdaptador(contactos, this);
        listaContactos.setAdapter(adaptador);
    }

    private void setSupportActionBar(Toolbar miActionBar) {
    }

    public void inicializarListaDeContactos(){
        contactos = new ArrayList<Contacto>();

        contactos.add(new Contacto(R.drawable.images2,"Mathias Alvez", "092564184", "mathias@mathias.com"));
        contactos.add(new Contacto(R.drawable.images3,"Pepe Reina", "099123456", "pepe@gmail.com"));
        contactos.add(new Contacto(R.drawable.images4,"Cristina Ronalda", "099777000", "cr7@gmail.com"));
        contactos.add(new Contacto(R.drawable.descarga,"Lionela Messi", "099101010", "leo10@gmail.com"));
        contactos.add(new Contacto(R.drawable.images,"Luis Suarez", "099999999", "pistolero@gmail.com"));
    }
}