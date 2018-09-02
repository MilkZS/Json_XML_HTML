package com.milkzs.android.json_xml_html.HTML.jsoup;

import android.os.AsyncTask;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class JSoupTask extends AsyncTask<Void,Void,Void>{


    @Override
    protected Void doInBackground(Void... voids) {

        try {
            Document document = (Document) Jsoup.connect("https://www.baidu.com/").timeout(5000).get();
            Elements element = document.select("div");
            for (Element e:element) {
                String s = e.select("a").text(); //标题
                String v = e.select("a").attr("href");//链接内容
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


        return null;
    }
}
