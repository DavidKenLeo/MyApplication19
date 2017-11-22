package com.dkl.auser.myapplication;

/**
 * Created by auser on 2017/11/1.
 */

import android.util.Log;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;

/**
 * Created by auser on 2017/10/30.
 */

//public class MyDataHandler extends DefaultHandler {
//    boolean isTitle = false;
//    boolean isItem = false;
//    public ArrayList<String> titles = new ArrayList();
//    @Override
//    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
//        super.startElement(uri, localName, qName, attributes);
//        if (qName.equals("title"))
//        {
//            isTitle = true;
//        }
//        if (qName.equals("item"))
//        {
//            isItem = true;
//        }
//    }
//
//    @Override
//    public void endElement(String uri, String localName, String qName) throws SAXException {
//        super.endElement(uri, localName, qName);
//        if (qName.equals("title"))
//        {
//            isTitle = false;
//        }
//        if (qName.equals("item"))
//        {
//            isItem = false;
//        }
//    }
//
//    @Override
//    public void characters(char[] ch, int start, int length) throws SAXException {
//        super.characters(ch, start, length);
//        if (isTitle && isItem)
//        {
//            String data = new String(ch, start, length);
//            Log.d("MyTitle", data);
//            titles.add(data);
//        }
//    }


//    @Override
//    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
//        super.startElement(uri, localName, qName, attributes);
//        if (qName.equals("title"))
//        {
//            isTitle = true;
//        }
//    }
//
//    @Override
//    public void endElement(String uri, String localName, String qName) throws SAXException {
//        super.endElement(uri, localName, qName);
//        if (qName.equals("title"))
//        {
//            isTitle = false;
//        }
//    }
//
//    @Override
//    public void characters(char[] ch, int start, int length) throws SAXException {
//        super.characters(ch, start, length);
//        if (isTitle)
//        {
//            String data = new String(ch, start, length);
//            Log.d("MyTitle",data);
//        }
//    }


public class MyDataHandler extends DefaultHandler {
    boolean isTitle = false;
    boolean isLink = false;
    boolean isItem = false;
    public ArrayList<String> titles = new ArrayList();
    public ArrayList<String> links = new ArrayList();
                StringBuilder titleTemp = new StringBuilder();
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        super.startElement(uri, localName, qName, attributes);
        if (qName.equals("title"))
        {
            isTitle = true;
        }
        if (qName.equals("item"))
        {
            isItem = true;
        }
        if (qName.equals("link"))
        {
            isLink = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        super.endElement(uri, localName, qName);
        if (qName.equals("title"))
        {
            if(isItem) {
                                titles.add(titleTemp.toString());
                                titleTemp = new StringBuilder();

            }
            isTitle = false;
        }
        if (qName.equals("item"))
        {
            isItem = false;
        }
        if (qName.equals("link"))
        {
            isLink = false;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        super.characters(ch, start, length);
        if (isTitle && isItem)
        {
            String data = new String(ch, start, length);
            Log.d("MyTitle", data);
                        titleTemp.append(data);
//            titles.add(data);
        }
        if (isLink && isItem)
        {
            String data = new String(ch, start, length);
            Log.d("MyLink", data);
            links.add(data);
        }
    }
}

