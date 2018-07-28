package com.szczepaniak.dawid.cardgames;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Debug;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.squareup.picasso.Picasso;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class AccountActivity extends AppCompatActivity {

    private Button logOut;
    private Button play;

    private ImageView accountAvatar;
    private TextView accountName;
    private TextView accountEmail;

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListner;

    private String name;
    private String email;
    private Uri photoUrl;
    private String uid;

    private RelativeLayout container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        mAuth = FirebaseAuth.getInstance();

        mAuthListner =  new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {

                if(firebaseAuth.getCurrentUser() == null){

                    startActivity(new Intent(AccountActivity.this, LoginActivity.class));
                    finish();
                }
            }
        };

        logOut = findViewById(R.id.LogOut);
        accountAvatar = findViewById(R.id.AccountAvatar);
        accountName = findViewById(R.id.AccountName);
        accountEmail = findViewById(R.id.AccountEmail);
        play = findViewById(R.id.Play);
        container = findViewById(R.id.Container);

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //createRoomWindow();
                startActivity(new Intent(AccountActivity.this, RoomsActivity.class));
                finish();
            }
        });


        FirebaseUser user = mAuth.getCurrentUser();
        if (user != null) {
                name = user.getDisplayName();
                email = user.getEmail();
                photoUrl = user.getPhotoUrl();
                Log.i("photoURL","" + photoUrl);
                uid = user.getUid();
        }


        Picasso.get().load(photoUrl.toString()).into(accountAvatar);
//        accountAvatar.setDrawingCacheEnabled(true);
//        RoundedBitmapDrawable avatarDrawble = RoundedBitmapDrawableFactory.create(getResources(),accountAvatar.getDrawingCache());
//        avatarDrawble.setCircular(true);
//        accountAvatar.setImageBitmap(null);
//        accountAvatar.setImageDrawable(avatarDrawble);

       // accountAvatar.setImageDrawable(avatarDrawble);
        accountName.setText(name);
        accountEmail.setText(email);

        logOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mAuth.signOut();

            }
        });
    }

    @Override
    protected void onStart(){
        super.onStart();

        mAuth.addAuthStateListener(mAuthListner);
    }


    void createRoomWindow(){

        LayoutInflater inflater = (LayoutInflater) this.getSystemService(LAYOUT_INFLATER_SERVICE);
        View customView = inflater.inflate(R.layout.create_room,null);

        final PopupWindow popupWindow = new PopupWindow(
                customView,
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        );


        if(Build.VERSION.SDK_INT>=21){
            popupWindow.setElevation(5.0f);
        }

         Button close = customView.findViewById(R.id.Close);
         Button create = customView.findViewById(R.id.Create);
         EditText roomName =  customView.findViewById(R.id.RoomName);

        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                popupWindow.dismiss();
            }
        });

        popupWindow.showAtLocation(container, Gravity.CENTER,0,0);


    }

}
