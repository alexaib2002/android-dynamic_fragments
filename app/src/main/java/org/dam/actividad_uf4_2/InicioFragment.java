package org.dam.actividad_uf4_2;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link InicioFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class InicioFragment extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private int mParam1;
    private String mParam2;

    public InicioFragment() {
        // Required empty public constructor
    }

    public static InicioFragment newInstance(int size, String text) {
        InicioFragment fragment = new InicioFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_PARAM1, size);
        args.putString(ARG_PARAM2, text);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getInt(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
            assert mParam2 != null;
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_inicio, container, false);
        TextView tv = (TextView) view.findViewById(R.id.txtFragView);
        // Initialize the views
        tv.setTextSize(TypedValue.COMPLEX_UNIT_SP, mParam1);
        tv.setText(mParam2);
        return view;
    }
}