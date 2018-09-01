package com.milkzs.android.json_xml_html.xml.SAX;

import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;

import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


public class SAXTask extends AsyncTask<Integer, Void, Void> {

    private String TAG = "SAXTask";

    @Override
    protected Void doInBackground(Integer... integers) {

        Log.d("SAXAnalyXmlProvider","start");
        try {
            URL url = new URL("https://github.com/MilkZS/Android-Demo/blob/master/res/person.xml");
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            //httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setConnectTimeout(5000);

            XMLReader xmlReader = XMLReaderFactory.createXMLReader();

            //File file = new File("C:/Users/milkdz/Desktop/person.xml");
            //InputStream iss = new FileInputStream(file);

            //InputStream is = url.openStream();

            //int code = httpURLConnection.getResponseCode();
            //if (code == 200) {
                InputStream is = httpURLConnection.getInputStream();
                //int index = integers[0];
                SAXAnalyXmlProvider saxAnalyXmlProvider = new SAXAnalyXmlProvider();

            xmlReader.setContentHandler(saxAnalyXmlProvider);
            xmlReader.setErrorHandler(saxAnalyXmlProvider);
            xmlReader.parse(new InputSource(is));


            Log.d("SAXAnalyXmlProvider","end");
            //}
        //} catch (ParserConfigurationException e) {
          //  e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
