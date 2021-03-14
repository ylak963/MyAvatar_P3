package es.studium.myavatar;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.fragment.app.DialogFragment;

public class DialogoEspecie extends DialogFragment
{
    OnNuevoDialogoListener mListener;
    RadioButton rbElfo;
    RadioButton rbEnano;
    RadioButton rbHobbit;
    RadioButton rbHumano;


    public Dialog onCreateDialog(Bundle savedInstanceState)
    {
        //Se construye un objeto de la clase AlertDialog mediante el builder asociado a la actividad
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View dialogEspec = inflater.inflate(R.layout.dialog_especie,null);
        builder.setView(dialogEspec);
        rbElfo = dialogEspec.findViewById(R.id.rbElf);
        rbEnano = dialogEspec.findViewById(R.id.rbDwarf);
        rbHobbit = dialogEspec.findViewById(R.id.rbHobbit);
        rbHumano = dialogEspec.findViewById(R.id.rbHuman);
        builder.setTitle("Elige tu especie")
        .setPositiveButton("Confirmar", new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                if(rbElfo.isChecked())
                {
                    mListener.onDataSetDialogEspecie("Elfo");
                    mListener.onDialogoMostrarProfesion();
                    dialog.dismiss();
                }
                else if(rbEnano.isChecked())
                {
                    mListener.onDataSetDialogEspecie("Enano");
                    mListener.onDialogoMostrarProfesion();
                    dialog.dismiss();
                }
                else if(rbHobbit.isChecked())
                {
                    mListener.onDataSetDialogEspecie("Hobbit");
                    mListener.onDialogoMostrarProfesion();
                    dialog.dismiss();
                }
                else if(rbHumano.isChecked())
                {
                    mListener.onDataSetDialogEspecie("Humano");
                    mListener.onDialogoMostrarProfesion();
                    dialog.dismiss();
                }
                dialog.dismiss();
            }
        })
        .setNegativeButton("Cancelar", new DialogInterface.OnClickListener()
        {
            public void onClick(DialogInterface dialog, int which)
            {
                dialog.dismiss();
            }
        });
        return builder.create();
    }
    public void onAttach(Context context)
    {
        super.onAttach(context);
        //Verificamos que la actividad principal ha implementado el interfaz
        try
        {
            //Instanciamos OnNuevoDialogoListener para poder enviar eventos a la clase principal
            mListener = (OnNuevoDialogoListener) context;
        }
        catch (ClassCastException e)
        {
            //La actividad no implementa el interfaz
            throw new ClassCastException(context.toString() + " debe implementar OnNuevoDialogoListener");
        }
    }
}
