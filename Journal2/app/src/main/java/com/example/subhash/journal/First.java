package com.example.subhash.journal;

/**
 * Created by Subhash on 15/01/2018.
 */

import android.icu.text.SimpleDateFormat;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Calendar;
import java.util.TimeZone;

/**
 * A simple {@link Fragment} subclass.
 */
public class First extends Fragment {
    TextView t1,t2;
    EditText t3;
    TimeZone tz= TimeZone.getTimeZone("GMT+05:30");
    Calendar c= Calendar.getInstance(tz);
    SimpleDateFormat t= new SimpleDateFormat("dd-MM-YYYY");
    SimpleDateFormat u=new SimpleDateFormat("HH:mm:SS");
    public First() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_first, container, false);
        t1=(TextView)view.findViewById(R.id.textView2);
        t2=(TextView)view.findViewById(R.id.textView3);
        t3=(EditText)view.findViewById(R.id.textView4);
        String d= t.format(c.getTime());
        String d1=u.format(c.getTime());
        t1.setText(d);
        t2.setText(d1);
        String r=t3.getText().toString();
        return view;
    }


}
