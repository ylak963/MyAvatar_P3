package es.studium.myavatar;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;


public class DialogoProfesion extends DialogFragment
{
    OnNuevoDialogoListener mListener;
    RadioButton rbArquero;
    RadioButton rbGuerrero;
    RadioButton rbMago;
    RadioButton rbHerrero;
    RadioButton rbMinero;
    @Override
    public Dialog onCreateDialog(@Nullable Bundle saveInstanceState)
    {
        // Construir el diálogo
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View dialogProf = inflater.inflate(R.layout.dialog_profesion, null);
        rbArquero = dialogProf.findViewById(R.id.rbArquer);
        rbGuerrero = dialogProf.findViewById(R.id.rbWarrior);
        rbMago = dialogProf.findViewById(R.id.rbWizard);
        rbHerrero = dialogProf.findViewById(R.id.rbSmith);
        rbMinero = dialogProf.findViewById(R.id.rbMiner);
        builder.setView(dialogProf);
        builder.setTitle("Elige tu profesión");
        builder.setPositiveButton("Confirmar", new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialog, int i)
            {
                // Capturar la elección de la profesión
                if (rbArquero.isChecked())
                {
                    mListener.onDataSetDialogProfesion("Arquero");
                    mListener.randomPoderes();
                    dialog.dismiss();
                } else if (rbGuerrero.isChecked())
                {
                    mListener.onDataSetDialogProfesion("Guerrero");
                    mListener.randomPoderes();
                    dialog.dismiss();
                } else if (rbMago.isChecked())
                {
                    mListener.onDataSetDialogProfesion("Mago");
                    mListener.randomPoderes();
                    dialog.dismiss();
                } else if (rbHerrero.isChecked())
                {
                    mListener.onDataSetDialogProfesion("Herrero");
                    mListener.randomPoderes();
                    dialog.dismiss();
                } else
                {
                    mListener.onDataSetDialogProfesion("Minero");
                    mListener.randomPoderes();
                }
                // Cerrar el diálogo
                dialog.dismiss();
            }
        });
        builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                // Cerrar el diálogo
                dialog.dismiss();
            }
        });
        // Crear el objeto y devolverlo
        return builder.create();
    }

    @Override
    public void onAttach(Context context)
    {
        super.onAttach(context);
        // Verificamos que la actividad principal ha implementado el interfaz
        try
        {
            // Instanciamos OnDialogoAceptarListener para poder enviar eventos a la clase principal
            mListener = (OnNuevoDialogoListener) context;
        }
        catch (ClassCastException e)
        {
            // La actividad no implementa el interfaz
            throw new ClassCastException(context.toString() + " debe implementar OnDialogoListener");
        }
    }
}