package com.example.subhash.microprocessor;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.SearchView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.miguelcatalan.materialsearchview.MaterialSearchView;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class First extends Fragment {

    private List<pdfViewer> pdfList = new ArrayList<>();
    private RecyclerView recyclerView;
    private pdf mpdf;
    private int flag=0;
    private String[] b,c;
    private String[] ab= new String[]{"ab","bb","cb","db","eb","abc","bbc","cbc","dbc","ebc","a","b","c","d","e","a","b","c","d","e"};
    public First() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view= inflater.inflate(R.layout.fragment_first, container, false);
        setHasOptionsMenu(true);
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
        pdfList.clear();
        for(int i=0;i<20;i++)
        {
            pdfViewer a=new pdfViewer(ab[i]);
            pdfList.add(a);
        }
       return view;
    }
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {

        // Implementing ActionBar Search inside a fragment
        MenuItem item = menu.add("Search");
        item.setIcon(R.drawable.ic_action_name); // sets icon
        item.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
        SearchView sv = new SearchView(getActivity());


        // modifying the text inside edittext component

        // implementing the listener
        sv.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {

                 if(s.length()==0)
                {
                    pdfList.clear();
                    for(int i=0;i<20;i++)
                    {
                        pdfViewer a=new pdfViewer(ab[i]);
                        pdfList.add(a);
                    }
                }
                else
                {
                    pdfList.clear();
                    for(int i=0;i<20;i++)
                    {
                        if(ab[i].contains(s)){
                            pdfViewer a=new pdfViewer(ab[i]);
                            pdfList.add(a);
                            flag=1;
                        }

                    }
                    if(flag==0)
                    {
                        Toast.makeText(getActivity(),
                                "No Such Function Exists",
                                Toast.LENGTH_LONG).show();
                        pdfList.clear();
                        for(int i=0;i<20;i++)
                        {
                            pdfViewer a=new pdfViewer(ab[i]);
                            pdfList.add(a);
                        }
                    }
                    flag=0;
                }
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                pdfList.clear();
                newText=newText.toLowerCase();
                for(int i=0;i<20;i++)
                {
                    if(ab[i].contains(newText))
                    {
                        pdfViewer a=new pdfViewer(ab[i]);
                        pdfList.add(a);
                    }
                }
                return false;
            }

        });

        item.setActionView(sv);
    }

}
