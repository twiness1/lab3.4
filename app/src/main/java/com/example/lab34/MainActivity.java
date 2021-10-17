package com.example.lab34;

import java.util.ArrayList;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.NotificationManager;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

@SuppressLint("NewApi")
public class MainActivity extends Activity implements OnClickListener{
    Button button1;
    Button button2;
    NotificationManager manager;
    int nid;
    String[] items={"唱歌","学习","跑步"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showListView();
    }

    private void showListView(){
        ListView listview = (ListView) findViewById(R.id.listview);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,getData());
        listview.setAdapter(adapter);
        this.registerForContextMenu(listview);
    }
    @Override

    public void onCreateContextMenu(ContextMenu menu,View v,ContextMenuInfo menuInfo){
        super.onCreateContextMenu(menu,v,menuInfo);
        //设置Menu显示内容
        menu.setHeaderTitle("文件操作");
        menu.setHeaderIcon(R.drawable.ic_launcher);
        menu.add(1,1,1,"复制");
        menu.add(1,2,1,"粘贴");
        menu.add(1,3,1,"剪切");
        menu.add(1,4,1,"重命名");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item){
        switch(item.getItemId()){
            case 1:
                Toast.makeText(MainActivity.this,"点击复制",Toast.LENGTH_SHORT).show();
                break;
            case 2:
                Toast.makeText(MainActivity.this,"点击粘贴",Toast.LENGTH_SHORT).show();
                break;
            case 3:
                Toast.makeText(MainActivity.this,"点击剪切",Toast.LENGTH_SHORT).show();
                break;
            case 4:
                Toast.makeText(MainActivity.this,"点击重命名",Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onContextItemSelected(item);
    }

    private ArrayList<String> getData(){
        ArrayList<String> list = new ArrayList<String>();
        for(int i=0;i<5;i++){
            list.add("文件"+(i+1));
        }
        return list;
    }
    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub

    }

}