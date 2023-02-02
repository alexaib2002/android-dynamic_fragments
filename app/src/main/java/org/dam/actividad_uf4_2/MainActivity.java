package org.dam.actividad_uf4_2;

import android.content.DialogInterface;
import android.os.Bundle;
import android.text.InputType;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {
    
    private int tam;
    private String text;
    private Button sizeBtn;
    private InicioFragment frag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tam = 24;
        text = getString(R.string.frag_placeholder);
        updateFragment();
        sizeBtn = findViewById(R.id.sizeBtn);
        sizeBtn.setOnClickListener(l -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle(R.string.dialog_size_title);

            EditText input = new EditText(this);
            input.setInputType(InputType.TYPE_CLASS_NUMBER);
            builder.setView(input);

            builder.setPositiveButton(R.string.dialog_accept, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    tam = Integer.parseInt(input.getText().toString());
                    updateFragment();
                }
            });
            builder.setNegativeButton(R.string.dialog_cancel, (d, w) -> {
                d.cancel();
            });
            builder.show();
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_opts, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_java || item.getItemId() == R.id.action_python) {
            if (item.getItemId() == R.id.action_java) {
                text = getString(R.string.txt_java);
            } else {
                text = getString(R.string.txt_python);
            }
            updateFragment();
        } else if (item.getItemId() == R.id.action_exit) {
            AlertDialog dialog = new AlertDialog.Builder(this)
                    .setTitle(R.string.dialog_exit_title)
                    .setPositiveButton(R.string.dialog_exit_ok, (d, w) -> {
                        finish();
                    })
                    .setNegativeButton(R.string.dialog_exit_cancel, null)
                    .create();
            dialog.show();
        }
        return super.onOptionsItemSelected(item);
    }

    private void updateFragment() {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        frag = InicioFragment.newInstance(tam, text);
        transaction.replace(R.id.fragCont, frag);
        transaction.commit();
    }
}