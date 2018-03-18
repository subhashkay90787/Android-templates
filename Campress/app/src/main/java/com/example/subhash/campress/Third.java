package com.example.subhash.campress;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import java.util.ArrayList;
import java.util.List;
/**
 * A simple {@link Fragment} subclass.
 */
public class Third extends Fragment {
    private List<carddesign> Cardslist = new ArrayList<>();
    private RecyclerView recyclerview;
    private List<String> a=new ArrayList<>();
    private List<String> b=new ArrayList<>();
    private Card cardm;
   // public static final String URL_DATA="http://192.168.56.1/baseurl/api.php";

    DatabaseReference t=FirebaseDatabase.getInstance().getReference();
    public Third() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_third, container, false);
        recyclerview = (RecyclerView) view.findViewById(R.id.recyclerview2);
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getActivity().getApplicationContext(), 1);
        recyclerview.setLayoutManager(mLayoutManager);
        recyclerview.setAdapter(cardm);
        Cardslist.add(new carddesign("Kaley Cuocu","https://i.pinimg.com/originals/56/d1/0a/56d10ae78b2e5d86e8ca882e9f3f81c2.jpg"));
        //preparedata();
        return view;

    }

    /*private void preparedata() {
    t.addValueEventListener(new ValueEventListener() {
        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {
            carddesign d=dataSnapshot.getValue(carddesign.class);
            Cardslist.add(d);
        }

        @Override
        public void onCancelled(DatabaseError databaseError) {

        }
    });
}*/
}