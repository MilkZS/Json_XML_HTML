package com.milkzs.android.json_xml_html.xml.SAX;

import android.util.Log;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SAXAnalyXmlProvider extends DefaultHandler {

    private String TAG = "SAXAnalyXmlProvider";

    @Override
    public void startDocument() throws SAXException {
        super.startDocument();
        Log.d(TAG,"startDocument");
    }

    @Override
    public void endDocument() throws SAXException {
        super.endDocument();
        Log.d(TAG,"endDocument");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        super.startElement(uri, localName, qName, attributes);
        Log.d(TAG,"startElement");
        Log.d(TAG,"startElement - uri = " + uri);
        Log.d(TAG,"startElement - localName = " + localName);
        Log.d(TAG,"startElement - qName = " + qName);
        if ("service".equals(localName)){
            Log.e(TAG,"find = " + attributes.toString());
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        super.endElement(uri, localName, qName);
        Log.d(TAG,"endElement");
    }

    @Override
    public void startPrefixMapping(String prefix, String uri) throws SAXException {
        super.startPrefixMapping(prefix, uri);
        Log.d(TAG,"startPrefixMapping");
    }
}
