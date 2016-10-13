package appewtc.masterung.bowlingproduce;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class VideoListView extends AppCompatActivity {

    //Explicit
    private ListView listView;
    private String[] strings = new String[]{"VDO 1","VDO 2","VDO 3"};
    private int[] ints = new int[]{R.drawable.video1, R.drawable.video2, R.drawable.video3};

    private int[] videoInts = new int[]{R.raw.master_ung,R.raw.football,R.raw.master_ung};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_list_view);

        listView = (ListView) findViewById(R.id.livShowVideo);
        VideoAdapter videoAdapter = new VideoAdapter(this, strings, ints);
        listView.setAdapter(videoAdapter);

       listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               Intent intent = new Intent(VideoListView.this, ShowVideoActivity.class);
               intent.putExtra("Video", videoInts[position]);
               startActivity(intent);
           }
       });

    }  // Main Method
}  // Main Class
