1. Dependencies and syntax for media player

java

    implementation "androidx.media3:media3-exoplayer:1.1.1"
    implementation "androidx.media3:media3-exoplayer-dash:1.1.1"
    implementation "androidx.media3:media3-ui:1.1.1"

    compileOptions {
    targetCompatibility JavaVersion.VERSION_1_8
    }
    

    ExoPlayer player = new ExoPlayer.Builder(context).build();

    playerView.setPlayer(player);

    MediaItem mediaItem = MediaItem.fromUri(Uri.parse(videoUri));

    player.setMediaItem(mediaItem);

    player.prepare();

    player.play();
    player.pause();
    player.seekTO();



2. Dependencies for splash screen

java
implementation 'androidx.core:core-splashscreen:1.0.1'


3. Splash screen theme changes

java
 <item name="android:windowSplashScreenAnimatedIcon">@drawable/bread</item>


4. Intents syntax

java
Intent intent  = new Intent(Intent.ACTION_VIEW);
intent.setData(Uri.parse("website"));

Intent intent2 = new Intent(this, SecondActivity.class);
startActivity(intent2)


5. Calculator, usual onclick syntax

java
onCreate{
button.setOnClickListener(this::onClick);
}

@Override
public void onClick(View view){
    int id = view.getId();
}


java
button.setOnclickListener(new View.setOnClickLister(){
    @Override
    public void onClick(View view){
        ...
    }
})


6. Graphical primitives

java
public class MainActivity extends AppCompatActivity {

        DemoView demoview;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            demoview = new DemoView(this);
            setContentView(demoview);
        }

        private class DemoView extends View {
            public DemoView(Context context) {
                super(context);
            }

            @Override
            protected void onDraw(Canvas canvas) {
                super.onDraw(canvas);
                Paint paint = new Paint();
                paint.setStyle(Paint.Style.FILL);
                paint.setColor(Color.WHITE);
                canvas.drawPaint(paint);

                paint.setColor(Color.BLUE);
                paint.setAntiAlias(true);
                canvas.drawRect(100, 150, 700, 800, paint);
                canvas.rotate(90);
                canvas.drawCircle(250,400, 80,paint);
                paint.setColor(Color.BLACK);
                paint.setTextSize(80);
                canvas.drawText("Bot behaviour", 150, 900, paint);

            }
        }
    }



7. Menu

xml
<menu>
    <item
    android:id = "@+/id1"
    android:title = ""
    android:icon = "@drawable/"
    >
    <!--for sub menus -->
    <menu>
        <item ... />
    </menu>
    </item>
</menu>


under main class

java
 @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.demo, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Toast.makeText(this, "Selected Item: " + item.getTitle(), Toast.LENGTH_SHORT)
                .show();
        return true;
    }