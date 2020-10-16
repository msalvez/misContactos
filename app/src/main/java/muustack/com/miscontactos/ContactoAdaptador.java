package muustack.com.miscontactos;

import android.app.Activity;
import android.content.Intent;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.security.PublicKey;
import java.util.ArrayList;

public class ContactoAdaptador extends RecyclerView.Adapter<ContactoAdaptador.ContactoViewHolder>{

    ArrayList<Contacto> contactos;
    Activity activity;

    public ContactoAdaptador(ArrayList<Contacto> contactos, Activity activity) {
        this.contactos = contactos;
        this.activity = activity;
    }

    @NonNull
    @Override
    public ContactoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_contacto, parent, false);
        return new ContactoViewHolder(v);
    }

    //Asocia los elementos de las vistas con cada view
    @Override
    public void onBindViewHolder(@NonNull ContactoViewHolder contactoViewHolder, int position) {
        final Contacto contacto = contactos.get(position);
        contactoViewHolder.imgContact.setImageResource(contacto.getFoto());
        contactoViewHolder.nombreContacto.setText(contacto.getNombre());
        contactoViewHolder.telefonoContacto.setText(contacto.getTelefono());

        contactoViewHolder.imgContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity, contacto.getNombre(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(activity, DetalleContacto.class);
                intent.putExtra("Nombre", contacto.getNombre());
                intent.putExtra("Telefono", contacto.getTelefono());
                activity.startActivity(intent);
            }
        });

        contactoViewHolder.btnLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity, "Diste like a "+ contacto.getNombre(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return contactos.size();
    }

    public static class ContactoViewHolder extends RecyclerView.ViewHolder {

        private ImageView imgContact;
        private TextView nombreContacto;
        private TextView telefonoContacto;
        private ImageButton btnLike;

        public ContactoViewHolder(@NonNull View itemView) {
            super(itemView);

            imgContact = (ImageView) itemView.findViewById(R.id.imgContact);
            nombreContacto = (TextView) itemView.findViewById(R.id.nombreContacto);
            telefonoContacto = (TextView) itemView.findViewById(R.id.likes);
            btnLike = (ImageButton) itemView.findViewById(R.id.btnLike);

        }
    }

}
