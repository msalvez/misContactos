package muustack.com.miscontactos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;

public class DetalleContacto extends AppCompatActivity {

    private TextView textViewNombre;
    private TextView textViewTelefono;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_contacto);

        Bundle parametros = getIntent().getExtras();
        String nombre = parametros.getString("Nombre");
        String telefono = parametros.getString("Telefono");

        textViewNombre = (TextView) findViewById(R.id.textViewNombre);
        textViewTelefono = (TextView) findViewById(R.id.textViewTelefono);


        textViewNombre.setText(nombre);
        textViewTelefono.setText(telefono);

    }

    public void llamar(View v){
        String telefono = textViewTelefono.getText().toString();
        startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + telefono)));
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event){
        if(keyCode == KeyEvent.KEYCODE_BACK){
            Intent intent = new Intent(DetalleContacto.this, MainActivity.class);
            startActivity(intent);
        }
        return super.onKeyDown(keyCode, event);
    }
}