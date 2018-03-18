package com.example.subhash.microprocessor;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class Second extends Fragment {

    private RecyclerView recyclerView;
    public Second() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        setHasOptionsMenu(true);
        return inflater.inflate(R.layout.fragment_second, container, false);
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
                if (s.length() < 4) {
                    Toast.makeText(getActivity(),
                            "Your search query must not be less than 3 characters",
                            Toast.LENGTH_LONG).show();
                    return true;
                } else {
                    Toast.makeText(getActivity(),
                            "Waah",
                            Toast.LENGTH_LONG).show();
                    return false;
                }
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                Toast.makeText(getActivity(),
                        newText,
                        Toast.LENGTH_SHORT).show();
            return true;}
        });
        item.setActionView(sv);
    }

}
