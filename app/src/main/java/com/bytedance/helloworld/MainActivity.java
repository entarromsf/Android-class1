package com.bytedance.helloworld;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private SeekBar sb_normal;
    private TextView txt_cur;
    private Context mContext;
    private ProgressBar progress_bar;
    private Button btn;

    private void bindViews() {
        sb_normal = (SeekBar) findViewById(R.id.sb_normal);
        txt_cur = (TextView) findViewById(R.id.txt_cur);
        sb_normal.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                txt_cur.setText("当前进度值:" + progress + "  / 100 ");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Log.d("Mainactivity","touch");
                Toast.makeText(mContext, "触碰SeekBar", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Log.d("Mainactivity","untouch");
                Toast.makeText(mContext, "放开SeekBar", Toast.LENGTH_SHORT).show();
            }
        });
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn1 = findViewById(R.id.button);
        final TextView tv1 = findViewById(R.id.textView);

        mContext = MainActivity.this;
        bindViews();

        initView();
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Log.d("Mainactivity","click");
                String text = tv1.getText().toString();
                if(text.equals("Do")){
                    tv1.setText("Undo");
                }
                else {
                    tv1.setText("Do");
                }
            }
        });

    }
    private void initView() {
        progress_bar = (ProgressBar) findViewById(R.id.progress_bar);
        btn = (Button) findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                switch (v.getId()) {
                    case R.id.btn:
                        if(progress_bar.getVisibility()==View.GONE)
                        {
                            //设置为可见的状态
                            progress_bar.setVisibility(View.VISIBLE);
                        }
                        else
                        {
                            //设置为不可见的状态，且不占用任何空间位置
                            progress_bar.setVisibility(View.GONE);
                        }
                        break;
                        
                }
            }
        });
    }
}
