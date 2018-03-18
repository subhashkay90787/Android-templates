package com.example.subhash.journal;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class Third extends Fragment {
    List<Cardview> a=new ArrayList<>();
    RecyclerView r;
    card c;
    Button b;
    EditText e;
    public Third() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_third, container, false);
        c=new card(a);
        b=(Button)view.findViewById(R.id.submit);
        e=(EditText)view.findViewById(R.id.tx1);
        r=(RecyclerView)view.findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager mLayoutmanager=new LinearLayoutManager(getActivity().getApplicationContext());
        r.setLayoutManager(mLayoutmanager);
        //r.addItemDecoration(new DividerItemDecoration(getActivity(), LinearLayoutManager.VERTICAL));
        r.setAdapter(c);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            String re=e.getText().toString();
            }
        });
        return view;

    }

}