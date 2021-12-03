package com.codewithankit.listview;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
String name[]={"a","b","c","d","e","f","g","h"};
int image[]={R.drawable.a,R.drawable.b,R.drawable.c,R.drawable.d,R.drawable.e,R.drawable.f,R.drawable.g};
ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    listView=findViewById(R.id.listview);
    myadapter myadapter=new myadapter(this,name,image);
    listView.setAdapter(myadapter);
    }

    class myadapter extends ArrayAdapter<String> {
       String name[];
       int image[];
       Context context;

        myadapter(Context context, String name[], int image[]){
        super(context,R.layout.customlist,name);
        this.context=context;
        this.image=image;
        this.name=name;
       }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
       LayoutInflater inflater=(LayoutInflater)getApplicationContext().getSystemService(context.LAYOUT_INFLATER_SERVICE);
       View view=inflater.inflate(R.layout.customlist,parent,false);
            TextView uname=view.findViewById(R.id.name);
            ImageView uimage=view.findViewById(R.id.image);
            uname.setText(name[position]);
            uimage.setImageResource(image[position]);
            return view;
        }
    }

}