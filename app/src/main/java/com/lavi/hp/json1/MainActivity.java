package com.lavi.hp.json1;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String json = "{" +
                "        \"glossary\": {\n" +
                "      \"title\": \"example glossary\",\n" +
                "  \t\t\t\"GlossDiv\": {\n" +
                "        \"title\": \"S\",\n" +
                "  \t\t\t\"GlossList\": {\n" +
                "           \"GlossEntry\": {\n" +
                "                  \"ID\": \"SGML\",\n" +
                "  \t\t\t\t\t\t\t\t\"SortAs\": \"SGML\",\n" +
                "  \t\t\t\t\t\t\t\t\"GlossTerm\": \"Standard Generalized Markup Language\",\n" +
                "  \t\t\t\t\t\t\t\t\"Acronym\": \"SGML\",\n" +
                "  \t\t\t\t\t\t\t\t\"Abbrev\": \"ISO 8879:1986\",\n" +
                "  \t\t\tt\t\t\t\t\t\"GlossDef\": {\n" +
                "             \"para\": \"A meta-markup language, used to create markup languages such as DocBook.\",\n" +
                " \t\t\t\t\t\"GlossSeeAlso\": [\"GML\", \"XML\"]\n" +
                "                },\n" +
                "\t\t\t\t\t\t\t\"GlossSee\": \"markup\"\n" +
                "            }" +
                "        }" +
                "   }" +
                "}" +
                "}";
        try {
            JsonDemo(json);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void JsonDemo(String json) throws JSONException {


        JSONObject jObj = new JSONObject(json);
        JSONObject sub = jObj.getJSONObject("glossary");

        String title = sub.getString("title");
        Log.d("myJson", "title:" + title);

        JSONObject subSubObj = sub.getJSONObject("GlossDiv");
        String subtitle = subSubObj.getString("title");
        Log.d("myJson", "subtitle:" + subtitle);

        JSONObject listObj = subSubObj.getJSONObject("GlossList");
        JSONObject entryObj = listObj.getJSONObject("GlossEntry");
        String id = entryObj.getString("ID");
        Log.d("myJson", "id:" + id);

        String sortAs = entryObj.getString("SortAs");
        Log.d("myJson", "sortAs:" + sortAs);

        String glossTerm = entryObj.getString("GlossTerm");
        Log.d("myJson", "glossTerm:" + glossTerm);

        String acronym = entryObj.getString("Acronym");
        Log.d("myJson", "acronym:" + acronym);

        String abbrev = entryObj.getString("Abbrev");
        Log.d("myJson", "abbrev:" + abbrev);

        JSONObject defObj = entryObj.getJSONObject("GlossDef");
        String para = defObj.getString("para");
        Log.d("myJson", "para:" + para);

        JSONArray seeAlso = defObj.getJSONArray("GlossSeeAlso");
        for (int i = 0; i < seeAlso.length(); i++) {
            String temp = seeAlso.getString(i);
            Log.d("myJson", "seeAlso" + temp);
        }
    }
}

