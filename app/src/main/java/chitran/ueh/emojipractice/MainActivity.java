package chitran.ueh.emojipractice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    GridView gridView;
    ArrayList<Emoji> data;
    EmojiAdapter adapter;
    int myrandom;
    int wrong = 0;
    TextView txtselect;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridView = findViewById(R.id.gr_view);
        data = new ArrayList<>();
        data.add(new Emoji("Khoc",R.drawable.khoc));
        data.add(new Emoji("Cuoi hip mat",R.drawable.cuoihipmat));
        data.add(new Emoji("Cuoi ra nuoc mat",R.drawable.cuoiranuocmat));
        data.add(new Emoji("Nhay Mat",R.drawable.nhaymat));
        data.add(new Emoji("Gieu cot",R.drawable.gieucot));
        data.add(new Emoji("Hoang so",R.drawable.hoangso));
        data.add(new Emoji("Mat trai tim",R.drawable.mattraitim));
        data.add(new Emoji("Suy ngam",R.drawable.suyngam));
        data.add(new Emoji("Tuc gian",R.drawable.tucgian));


        Random rd = new Random();
        myrandom = rd.nextInt(data.size());
        txtselect = findViewById(R.id.txtviewselect);
        txtselect.setText(data.get(myrandom).name);

        adapter = new EmojiAdapter(this,R.layout.emoji,data);
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String select = data.get(i).name;
                if(txtselect.getText().toString() == select){
                    data.remove(i);
                    adapter.notifyDataSetChanged();
                    Intent sucess = new Intent(MainActivity.this,Sucessful.class);
                    startActivity(sucess);
                }
                else {
                    wrong++;
                    Toast.makeText(getApplicationContext(),"Fail",Toast.LENGTH_LONG).show();
                    if(wrong > 3){
                        Intent fail = new Intent(MainActivity.this,Failed.class);
                        startActivity(fail);
                    }

                }
            }
        });
    }
}