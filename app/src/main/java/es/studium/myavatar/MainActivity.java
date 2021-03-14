package es.studium.myavatar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, OnNuevoDialogoListener
{
        //Creamos los objetos de los diálogos
        DialogoNombre dialogoNombre;
        DialogoGenero dialogoGenero;
        DialogoEspecie dialogoEspecie;
        DialogoProfesion dialogoProfesion;

        //ImageView imgEsquina;
        Button btnCrearAvatar;
        Button btnSalir;
        ImageView imgAvatar;
        ImageView imgProfesion;

        TextView txtNombre;
        String sexoAvatar;
        TextView txtEspecie;
        TextView txtProfesion;

        TextView txtVida;
        TextView txtMagia;
        TextView txtFuerza;
        TextView txtVelocidad;
        Random aleatorio = new Random();

        @Override
        protected void onCreate(Bundle savedInstanceState)
        {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            //Toolbar toolbar = findViewById(R.id.toolbar);
            //setSupportActionBar(toolbar);
            btnCrearAvatar = findViewById(R.id.buttonCreate);
            btnSalir = findViewById(R.id.buttonExit);
            //imgEsquina=findViewById(R.id.imageButton);
            imgAvatar=findViewById(R.id.imageAvat);
            imgProfesion=findViewById(R.id.imageProfes);
            txtNombre=findViewById(R.id.txtNombre);
            txtEspecie=findViewById(R.id.txtEspecie);
            txtProfesion=findViewById(R.id.txtProfesion);

            txtVida=findViewById(R.id.editTextNumberHP);
            txtMagia=findViewById(R.id.editTextMagician);
            txtFuerza=findViewById(R.id.ediTextStrength);
            txtVelocidad=findViewById(R.id.editTextVelocity);
            //Listeners
            btnCrearAvatar.setOnClickListener(this);
            btnSalir.setOnClickListener(this);
        }

        @Override
        public void onClick(View v)
        {
            if (v.equals(btnCrearAvatar))
            {
                dialogoNombre = new DialogoNombre();
                dialogoNombre.setCancelable(false); //Lo establecemos modal por si pulsamos fuera del diálogo no se cierre
                dialogoNombre.show(getSupportFragmentManager(), "Diálogo Nombre");
                //btnCrearAvatar.setVisibility(View.INVISIBLE);
            }
            if (v.equals(btnSalir))
            {
                finish();
            }
        }
        public void onDialogoMostrarSexo()
        {
            dialogoGenero = new DialogoGenero();
            dialogoGenero.setCancelable(false);
            dialogoGenero.show(getSupportFragmentManager(), "Diálogo Sexo");
            //btnCrearAvatar.setVisibility(View.INVISIBLE);
        }

        @Override
        public void onDialogoMostrarEspecie()
        {
            dialogoEspecie = new DialogoEspecie();
            dialogoEspecie.setCancelable(false);
            dialogoEspecie.show(getSupportFragmentManager(), "Diálogo Sexo");
            //btnCrearAvatar.setVisibility(View.INVISIBLE);
        }

        @Override
        public void onDialogoMostrarProfesion()
        {
            dialogoProfesion = new DialogoProfesion();
            dialogoProfesion.setCancelable(false);
            dialogoProfesion.show(getSupportFragmentManager(), "Diálogo Profesión");
            //btnCrearAvatar.setVisibility(View.INVISIBLE);
        }

        @Override
         public void onDataSetDialogNombre(String nombre)
        {
             txtNombre.setText(nombre);
        }

        @Override
        public void onDataSetDialogSexo(String sexo)
        {
            sexoAvatar= sexo;
        }

        @Override
        public void onDataSetDialogEspecie(String especie)
        {
            if(sexoAvatar.equals("Hombre"))
            {
                if(especie.equals("Elfo"))
                {
                    imgAvatar.setImageResource(R.drawable.ic_elfo);
                }
                else if(especie.equals("Enano"))
                {
                    imgAvatar.setImageResource(R.drawable.ic_enano);
                }
                else if(especie.equals("Hobbit"))
                {
                    imgAvatar.setImageResource(R.drawable.ic_hobbith);
                }else
                {
                    imgAvatar.setImageResource(R.drawable.ic_humano);
                }
                txtEspecie.setText(especie);
            }
            if(sexoAvatar.equals("Mujer"))
            {
                if(especie.equals("Elfo"))
                {
                    imgAvatar.setImageResource(R.drawable.ic_elfa);
                }
                else if(especie.equals("Enano"))
                {
                    imgAvatar.setImageResource(R.drawable.ic_enana_dys);
                }
                else if(especie.equals("Hobbit"))
                {
                    imgAvatar.setImageResource(R.drawable.ic_hobbitm);
                }else
                {
                    imgAvatar.setImageResource(R.drawable.ic_humana);
                }
                txtEspecie.setText(especie);
            }
        }

        @Override
        public void onDataSetDialogProfesion(String profesion)
        {
            if(profesion.equals("Arquero"))
            {
                imgProfesion.setImageResource(R.drawable.ic_arco);
            }
            else if(profesion.equals("Guerrero"))
            {
                imgProfesion.setImageResource(R.drawable.ic_espada);
            }
            else if(profesion.equals("Mago"))
            {
                imgProfesion.setImageResource(R.drawable.ic_mago);
            }
            else if(profesion.equals("Herrero"))
            {
                imgProfesion.setImageResource(R.drawable.ic_herrero);
            }
            else
            {
                imgProfesion.setImageResource(R.drawable.ic_minero);
            }
            txtProfesion.setText(profesion);
        }

        @Override
        public void randomPoderes()
        {
            int vida = aleatorio.nextInt(101);
            txtVida.setText("HP--> "+vida);
            int magia = aleatorio.nextInt(11);
            txtMagia.setText("MG--> "+magia);
            int fuerza = aleatorio.nextInt(21);
            txtFuerza.setText("ST--> "+fuerza);
            int velocidad = aleatorio.nextInt(6);
            txtVelocidad.setText("SP--> "+velocidad);
        }
}