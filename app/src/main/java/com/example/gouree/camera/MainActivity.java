package com.example.gouree.camera;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends ActionBarActivity {

    //button and image view to display the image clicked
    private Button btnCamera;
    private ImageView capturedImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //button and image
        btnCamera = (Button) findViewById(R.id.btnCamera);

        capturedImage= (ImageView) findViewById(R.id.capturedImage);
        btnCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //call method opencamera on click of button
                openCamera();
            }
        });

    }

    //display image when clicked ok on imageview

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // TODO Auto-generated method stub
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK) {
            //get clicked image
            Bitmap bp = (Bitmap) data.getExtras().get("data");
            //display the image in image view
            capturedImage.setImageBitmap(bp);
        }
    }


    private void openCamera() {
        //open camera
        Intent intent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, 0);
    }
}