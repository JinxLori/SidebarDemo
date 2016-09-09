package com.jason.sidebardemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.jason.library.widget.Sidebar;
import com.jason.sidebardemo.adapter.MyAdapter;
import com.jason.sidebardemo.model.Contact;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView mListView;
    Sidebar mSidebar;
    MyAdapter mAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {
        mListView = (ListView) findViewById(R.id.list);
        mSidebar = (Sidebar) findViewById(R.id.sidebar);
        mSidebar.setOnAlphabetChangeListener(new Sidebar.OnAlphabetChangeListener() {
            @Override
            public void alphabetChangeListener(View v, String alphabet, int section) {
                mListView.setSelection(mAdapter.getPositionForSection(section));
            }
        });
        mAdapter = new MyAdapter(this, getDatas());
        mListView.setAdapter(mAdapter);
    }

    private List<Contact> getDatas() {
        List<Contact> datas = new ArrayList<>();
        datas.add(new Contact("小熊"));
        datas.add(new Contact("小明"));
        datas.add(new Contact("老王"));
        datas.add(new Contact("老宋"));
        datas.add(new Contact("李死"));
        datas.add(new Contact("小张"));
        datas.add(new Contact("王五"));
        datas.add(new Contact("jason"));
        datas.add(new Contact("java"));
        datas.add(new Contact("python"));
        datas.add(new Contact("c"));
        datas.add(new Contact("c#"));
        datas.add(new Contact("c++"));
        datas.add(new Contact("盲僧"));
        datas.add(new Contact("蛮王"));
        datas.add(new Contact("剑圣"));
        datas.add(new Contact("赵兴"));
        datas.add(new Contact("女警"));
        datas.add(new Contact("亚索"));
        datas.add(new Contact("狗熊"));
        datas.add(new Contact("刀妹"));
        datas.add(new Contact("吸血鬼"));
        datas.add(new Contact("卡萨丁"));
        datas.add(new Contact("火女"));
        datas.add(new Contact("女枪"));
        datas.add(new Contact("奥巴马"));
        Collections.sort(datas);
        return datas;
    }
}
