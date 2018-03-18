package com.example.subhash.campress;

/**
 * Created by Subhash on 15/01/2018.
 */

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 */
public class First extends Fragment {

    private List<pdfViewer> pdfList = new ArrayList<>();
    private RecyclerView recyclerView;
    private pdf mpdf;
    public First() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_first, container, false);
        recyclerView=(RecyclerView)view.findViewById(R.id.recyclerview);
        mpdf=new pdf(pdfList);
        RecyclerView.LayoutManager mLayoutmanager=new LinearLayoutManager(getActivity().getApplicationContext());
        recyclerView.setLayoutManager(mLayoutmanager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(mpdf);
        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getActivity().getApplicationContext(),recyclerView,new RecyclerTouchListener.ClickListener(){
            @Override
            public void onClick(View view, int position) {
                pdfViewer pdfk = pdfList.get(position);
                Toast.makeText(getActivity().getApplicationContext(), "Your file is being downloaded....", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));
        prepareData();
        return view;
    }
    private void prepareData() {
        pdfViewer l=new pdfViewer("DATA");
        pdfList.add(l);
        pdfViewer l1=new pdfViewer("DATA");
        pdfList.add(l1);
        pdfViewer l2=new pdfViewer("DATA");
        pdfList.add(l2);
        pdfViewer l3=new pdfViewer("DATA");
        pdfList.add(l3);
        pdfViewer l4=new pdfViewer("DATA");
        pdfList.add(l4);
        pdfViewer l5=new pdfViewer("DATA");
        pdfList.add(l5);
        pdfViewer l6=new pdfViewer("DATA");
        pdfList.add(l6);
        mpdf.notifyDataSetChanged();
    }

}
