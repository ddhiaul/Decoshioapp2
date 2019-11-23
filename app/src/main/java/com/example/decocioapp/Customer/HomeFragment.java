package com.example.decocioapp.Customer;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.example.decocioapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    Button btnWedding, btnParty, btnCamp, btnGraduate;
    ImageView imgHelp;


    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

//        HomeFragment hg = new HomeFragment();
//        FragmentManager fragmentManager = getFragmentManager();
//        //Replace intent with Bundle and put it in the transaction
//        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//        fragmentTransaction.add(R.id.framehome, hg);
//        fragmentTransaction.replace(R.id.framehome,hg);
//        fragmentTransaction.commit();


        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_home, container, false);


        btnWedding = v.findViewById(R.id.btn_wedding);
        btnCamp = v.findViewById(R.id.btn_camp);
        btnGraduate = v.findViewById(R.id.btn_graduate);
        btnParty = v.findViewById(R.id.btn_party);
        imgHelp = v.findViewById(R.id.img_help);


        btnWedding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), Wedding.class);
                startActivity(intent);
            }
        });
        btnParty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), Party.class);
                startActivity(intent);
            }
        });
        btnCamp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), Camp.class);
                startActivity(intent);
            }
        });
        btnGraduate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), Graduate.class);
                startActivity(intent);
            }
        });

        imgHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), HelpUser.class);
                startActivity(intent);
            }

        });

        return v;
    }
}
