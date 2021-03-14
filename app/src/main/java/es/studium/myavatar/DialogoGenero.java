package es.studium.myavatar;

//import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

public class DialogoGenero extends DialogFragment
{
    OnNuevoDialogoListener mListener;
    RadioButton rbHombre;
    RadioButton rbMujer;

    public Dialog onCreateDialog(Bundle savedInstance)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View dialogSex = inflater.inflate(R.layout.dialog_genero,null);
        rbHombre = dialogSex.findViewById(R.id.rbMen);
        rbMujer =dialogSex.findViewById(R.id.rbWoman);
        builder.setView(dialogSex);
        builder.setTitle("Elige su sexo")
        .setPositiveButton("Confirmar", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which)
                    {
                        if (rbHombre.isChecked())
                        {
                            mListener.onDataSetDialogSexo("Hombre");
                            mListener.onDialogoMostrarEspecie();
                        }
                        else
                            {
                            mListener.onDataSetDialogSexo("Mujer");
                            mListener.onDialogoMostrarEspecie();
                        }
                        dialog.dismiss();
                    }
                })
                .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
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
