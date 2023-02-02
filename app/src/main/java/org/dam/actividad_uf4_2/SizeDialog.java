package org.dam.actividad_uf4_2;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

import android.view.View;
import android.widget.EditText;

public class SizeDialog extends DialogFragment {
    private MainActivity mainActivity;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState)
    {
        View view = getActivity().getLayoutInflater().inflate(R.layout.fragment_size_dialog, null);
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(R.string.dialog_size_title);
        builder.setView(view);
        EditText input = view.findViewById(R.id.sizeFragTxtEdit);
        input.setText(String.valueOf(mainActivity.getTam()));
        builder.setPositiveButton(R.string.dialog_accept, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // no se necesita actualizar el texto de MainActivity
                mainActivity.updateData(Integer.parseInt(input.getText().toString()), null);
                mainActivity.updateFragment();
            }
        }).setNegativeButton(R.string.dialog_cancel, (d, w) -> {
            d.dismiss();
        });
        return builder.create();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        try {
            mainActivity = (MainActivity) context;
        } catch (ClassCastException e) {
            System.err.println("Warning, SizeDialog is not attachable to any other activity other than MainActivity");
        }
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}