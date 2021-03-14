package es.studium.myavatar;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

public class DialogoNombre extends DialogFragment
{
    OnNuevoDialogoListener mListener;
    EditText editNombre;
    @Override
    public Dialog onCreateDialog(@Nullable Bundle saveInstanceState)
    {
        // Construir el diálogo
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View MyView = inflater.inflate(R.layout.dialog_nombre, null);
        editNombre = MyView.findViewById(R.id.nombreDialog);
        builder.setView(MyView)
                .setTitle("Elige nombre a su avatar")
                // Añadir el botón Aceptar
                .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Capturar los datos introducidos en el editText nombre
                        try
                        {
                            if(!editNombre.getText().toString().isEmpty())
                            {
                                mListener.onDataSetDialogNombre(editNombre.getText().toString());
                                mListener.onDialogoMostrarSexo();
                            }
                            else
                            {
                                Toast.makeText(getActivity(), "No has rellenado los campos!", Toast.LENGTH_LONG).show();
                            }
                        }
                        catch(Exception e)
                        {
                            Toast.makeText(getActivity(), "No has rellenado los campos!", Toast.LENGTH_LONG).show();
                        }
                        dialog.dismiss();
                    }
                })
                // Añadir el botón Cancelar
                .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
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
