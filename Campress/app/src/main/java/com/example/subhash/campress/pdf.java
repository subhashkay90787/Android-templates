package com.example.subhash.campress;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Subhash on 15/01/2018.
 */

public class pdf extends RecyclerView.Adapter<pdf.PdfAdapter> {
    private List<pdfViewer> pdfList;

    public class PdfAdapter extends RecyclerView.ViewHolder {
        public TextView vName;

        public RelativeLayout relativeLayout;
        public PdfAdapter(View view) {
            super(view);
            vName = (TextView) view.findViewById(R.id.Pdf);


        }
    }
    public pdf(List<pdfViewer> pdfList) {
        this.pdfList = pdfList;
    }

    @Override
    public pdf.PdfAdapter onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout, parent, false);
        return new pdf.PdfAdapter(itemView);
    }

    @Override
    public void onBindViewHolder(pdf.PdfAdapter holder, int position) {
        pdfViewer pdfview = pdfList.get(position);
        holder.vName.setText(pdfview.getName());


    }

    @Override
    public int getItemCount() {
        return pdfList.size();
    }



}