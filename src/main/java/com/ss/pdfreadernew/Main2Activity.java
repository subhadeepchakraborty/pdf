package com.ss.pdfreadernew;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.link.DefaultLinkHandler;
import com.github.barteksc.pdfviewer.scroll.DefaultScrollHandle;
import com.github.barteksc.pdfviewer.util.FitPolicy;

import java.io.File;

public class Main2Activity extends AppCompatActivity {
   PDFView pdfview;
   int position=-1;
   String path1="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        pdfview=findViewById(R.id.pdfView);
        position=getIntent().getIntExtra("pos",-1);

        path1=getIntent().getStringExtra("path");
        File file1=new File(path1);
        pdfview.fromFile(file1)
                .enableSwipe(true) // allows to block changing pages using swipe
                .swipeHorizontal(false)
                .enableDoubletap(true)
                .defaultPage(0)
                .password(null)
                .scrollHandle(null)
                .spacing(0)

                .linkHandler(new DefaultLinkHandler(pdfview))
                .pageFitPolicy(FitPolicy.WIDTH) // mode to fit pages in the view
                .load();




    }
 

}
