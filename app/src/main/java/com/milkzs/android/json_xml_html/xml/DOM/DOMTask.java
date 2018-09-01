package com.milkzs.android.json_xml_html.xml.DOM;

import android.os.AsyncTask;
import android.util.Log;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class DOMTask extends AsyncTask<Void, Void, Void> {

    private String TAG = "DOMTask";

    @Override
    protected Void doInBackground(Void... voids) {

        URL url = null;
        try {
            url = new URL("https://github.com/MilkZS/Android-Demo/blob/master/res/person.xml");

            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            //httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setConnectTimeout(5000);

            InputStream is = httpURLConnection.getInputStream();

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(is);

            Element element = document.getDocumentElement();
            NodeList nodeList = element.getElementsByTagName("persion");
            for(int i=0;i<nodeList.getLength();i++){
                Element element1 = (Element) nodeList.item(i);
                String id = element1.getAttribute("id");
                Log.d(TAG,"id = " + id);
                Element element2 = (Element) element1.getElementsByTagName("name").item(0);
                String name = element2.getTextContent();
                Log.d(TAG,"name = " + name);
            }



        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }


        return null;
    }
}
