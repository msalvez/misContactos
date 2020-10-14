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
    private TextView textViewEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_contacto);

        Bundle parametros = getIntent().getExtras();
        String nombre = parametros.getString("Nombre");
        String telefono = parametros.getString("Telefono");
        String email = parametros.getString("Email");

        textViewNombre = (TextView) findViewById(R.id.textViewNombre);
        textViewTelefono = (TextView) findViewById(R.id.textViewTelefono);
        textViewEmail = (TextView) findViewById(R.id.textViewEmail);


        textViewNombre.setText(nombre);
        textViewTelefono.setText(telefono);
        textViewEmail.setText(email);

    }

    public void llamar(View v){
        String telefono = textViewTelefono.getText().toString();
        startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + telefono)));
    }

    public void enviarMail(View v){
        String email = textViewEmail.getText().toString();
        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.putExtra(Intent.EXTRA_EMAIL, email);
        emailIntent.setType("message/rfc822");
        startActivity(Intent.createChooser(emailIntent, "Email "));
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