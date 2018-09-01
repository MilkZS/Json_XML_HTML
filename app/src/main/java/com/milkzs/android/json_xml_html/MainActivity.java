package com.milkzs.android.json_xml_html;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.milkzs.android.json_xml_html.xml.DOM.DOMTask;
import com.milkzs.android.json_xml_html.xml.SAX.SAXTask;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       // new SAXTask().execute(0);

        new DOMTask().execute();
    }
}
