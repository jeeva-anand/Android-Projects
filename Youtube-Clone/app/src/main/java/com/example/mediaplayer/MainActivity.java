package com.example.mediaplayer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.media3.common.MediaItem;
import androidx.media3.exoplayer.ExoPlayer;
import androidx.media3.ui.PlayerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    PlayerView playView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        playView = findViewById(R.id.plView);
        ExoPlayer exoPlayer = new ExoPlayer.Builder(this).build();
        MediaItem md = MediaItem.fromUri("https://storage.googleapis.com/gtv-videos-bucket/sample/TearsOfSteel.mp4");
        exoPlayer.setMediaItem(md);
        playView.setPlayer(exoPlayer);

        exoPlayer.prepare();
        exoPlayer.play();

    }
}