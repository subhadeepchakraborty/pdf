package com.ss.pdfreadernew;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity<string> extends AppCompatActivity {
    Button button;
    private AdView adView;
    ArrayAdapter<String> adapter;
    private static final int  PICK_PDF_CODE = 1000;
    File path;
    EditText ed;
    ListView list;
    public static Map<String,String> link=new HashMap<String, String>();
    public static ArrayList<String> pdf_paths=new ArrayList<String>();
    public static ArrayList<String> pdf_names=new ArrayList<String>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ed=findViewById(R.id.ed);
        list=(ListView)findViewById(R.id.lv);
        pdf_paths.clear();
        pdf_names.clear();


        path = new File(Environment.getExternalStorageDirectory() + "");
        new Thread( new Runnable() { @Override public void run() {
            searchFolderRecursive1(path);
        } } ).start();
         adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, pdf_names);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                                    long arg3) {

                String name= (String) list.getAdapter().getItem(arg2);
                String path=link.get(name);

                Intent i=new Intent(MainActivity.this,Main2Activity.class);

               i.putExtra("path",path);
                i.putExtra("pos",arg2);
               startActivity(i);



            }
        });
        ed.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                (MainActivity.this).adapter.getFilter().filter(charSequence);

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }
 
    private static void searchFolderRecursive1(File folder)
    {
        if (folder != null)
        {
            if (folder.listFiles() != null)
            {
                for (File file : folder.listFiles())
                {
                    if (file.isFile())
                    {
                        //.pdf files
                        if(file.getName().contains(".pdf"))
                        {
                            file.getPath();
                            pdf_names.add(file.getName());
                            pdf_paths.add(file.getPath());
                            link.put(file.getName().toString(),file.getPath().toString());
                        }
                    }
                    else
                    {
                        searchFolderRecursive1(file);
                    }
                }
            }
        }
    }


}






