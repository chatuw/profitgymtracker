package com.pthl;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

public class Links extends Fragment {


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.links, container, false);

        final Button btnurl = (Button) root.findViewById(R.id.button);
        final Button btnurl2 = (Button) root.findViewById(R.id.button2);
        btnurl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                videoOne(view);

            }


        });
        btnurl2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                videoTwo(view);

            }


        });
        return root;
    }

            public void videoOne(View v) {
                Intent Browse= new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=Zy5c2k3W458"));
                startActivity(Browse);
            }

    public void videoTwo(View v) {
        Intent Browse= new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=_KGEkwSRoF0"));
        startActivity(Browse);
    }


}

