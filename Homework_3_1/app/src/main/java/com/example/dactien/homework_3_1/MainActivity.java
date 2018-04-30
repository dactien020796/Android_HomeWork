package com.example.dactien.homework_3_1;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class MainActivity extends AppCompatActivity {

    ListView lvDish;
    List<Item> itemList;
    DishAdapter dishAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addControls();
        addEvents();
        if (kiemTraKetNoiInternet())
            getTask("http://feeds.feedburner.com/elise/simplyrecipes");
        else
            Toast.makeText(MainActivity.this, "Thiết bị chưa kết nối Internet", Toast.LENGTH_LONG).show();


    }

    public boolean kiemTraKetNoiInternet() {
        ConnectivityManager connectivity = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivity == null) {
            return false;
        } else {
            NetworkInfo[] info = connectivity.getAllNetworkInfo();
            if (info != null) {
                for (int i = 0; i < info.length; i++) {
                    if (info[i].getState() == NetworkInfo.State.CONNECTED) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private void addEvents() {

    }

    private void addControls() {
        lvDish = (ListView) findViewById(R.id.lvDish);
        itemList = new ArrayList<>();
        dishAdapter = new DishAdapter(this, R.layout.custom_list_item, itemList);
        lvDish.setAdapter(dishAdapter);
    }

    void getTask(String path) {
        try {
            new MyAsyncTask().execute(new URL(path));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    class MyAsyncTask extends AsyncTask<URL, Void, List<Item>> {

        @Override
        protected List<Item> doInBackground(URL... urls) {
            URLConnection urlConnection = null;
            try {
                urlConnection = urls[0].openConnection();
                HttpURLConnection httpURLConnection = (HttpURLConnection) urlConnection;
                int respCode = httpURLConnection.getResponseCode();
                if (respCode == HttpURLConnection.HTTP_OK) {
                    InputStream is = httpURLConnection.getInputStream();
                    itemList = parseRSSFeeds(is);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return itemList;
        }


        private List<Item> parseRSSFeeds(InputStream is) {
            List<Item> list = new ArrayList<>();
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            try {
                DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
                Document document = documentBuilder.parse(is);
                if (document != null) {
                    NodeList itemList = document.getElementsByTagName("item");
                    if (itemList != null) {
                        for (int i = 0; i < itemList.getLength(); i++) {
                            Node item = itemList.item(i);
                            Item feed = new Item();
                            NodeList childrenItems = item.getChildNodes();
                            for (int j = 0; j < childrenItems.getLength(); j++) {
                                Node child = childrenItems.item(j);
                                String contents = child.getTextContent();
                                switch (child.getNodeName()) {
                                    case Item.TITLE:
                                        feed.setTitle(contents);
                                        break;
                                    case Item.DESCRIPTION:
                                        String temp[] = contents.split("/>");
                                        feed.setLink_img(temp[0].split("src=\"")[1].split("\"")[0].trim());
                                        break;
                                    case Item.LINK:
                                        feed.setLink(contents);
                                        break;
                                }
                            }
                            list.add(feed);
                        }
                    }
                }
            } catch (ParserConfigurationException e) {
                e.printStackTrace();
            } catch (SAXException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return list;
        }

        @Override
        protected void onPostExecute(List<Item> items) {
            super.onPostExecute(items);
            dishAdapter.clear();
            dishAdapter.addAll(items);
            dishAdapter.notifyDataSetChanged();

        }
    }
}
