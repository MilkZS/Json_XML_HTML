package com.milkzs.android.json_xml_html.xml.PULL;

import android.os.AsyncTask;
import android.util.Xml;
import android.view.ViewOutlineProvider;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class PULLTask extends AsyncTask<Void, Void, Void> {
    @Override
    protected Void doInBackground(Void... voids) {

        URL url = null;
        try {
            url = new URL("https://github.com/MilkZS/Android-Demo/blob/master/res/person.xml");

            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            //httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setConnectTimeout(5000);

            InputStream is = httpURLConnection.getInputStream();

            XmlPullParser pullParser = Xml.newPullParser();
            pullParser.setInput(is, "UTF-8");
            int event = pullParser.getEventType();
            while (event != XmlPullParser.END_DOCUMENT) {

                switch (event) {
                    case XmlPullParser.START_DOCUMENT:
                    case XmlPullParser.START_TAG:{
                        String id = pullParser.getAttributeName(0);
                        //String name = pullParser.getName();
                        if("name".equals(pullParser.getName())){
                            String anem = pullParser.nextText();
                        }
                    }break;
                }

                event = pullParser.next();
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        }


        return null;
    }
}
