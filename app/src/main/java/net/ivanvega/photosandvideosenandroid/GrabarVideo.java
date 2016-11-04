package net.ivanvega.photosandvideosenandroid;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

public class GrabarVideo extends AppCompatActivity {
    VideoView vvw;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grabar_video);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        vvw = (VideoView)findViewById(R.id.vvwrepro);
        vvw.setMediaController(new MediaController(this));

    }

    public void btnVideo_click (View v){
        startActivityForResult(
                new Intent(MediaStore.ACTION_VIDEO_CAPTURE)
                , 1016);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Toast.makeText(this,
                data.getData().toString(),
                Toast.LENGTH_LONG).show();

        vvw.setVideoURI(data.getData());
        super.onActivityResult(requestCode, resultCode, data);
    }

}






