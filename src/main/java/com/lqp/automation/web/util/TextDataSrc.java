package com.lqp.automation.web.util;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TextDataSrc {

    public List<String[]> readTextFile(String fileName, String splitter) throws IOException {
        List<String[]> allLogRows = new ArrayList<String[]>();
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(fileName);
        } catch (FileNotFoundException e1) {
            // TODO Auto-generated catch block
            //e1.printStackTrace();

            return allLogRows;
        }
        //Construct BufferedReader from InputStreamReader
        BufferedReader br = new BufferedReader(new InputStreamReader(fis));
        String line = null;
        try {
            while ((line = br.readLine()) != null) {
                //line = line.replaceAll("(^\\[|\\]$)", "");
                String[] arr = line.split(splitter, -1);
                String[] brr = new String[arr.length];
                for (int i = 0; i < arr.length; i++) {
                    brr[i] = arr[i].trim();
                }
                allLogRows.add(brr);
            }
        } finally {
            br.close();
        }

        return allLogRows;
    }

    public List<JSONObject> getJSONObject(String file, String key, String type, String strEvtKey) throws Exception {
        FileReader reader = new FileReader(file);

        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);

        // get an array from the JSON object
        JSONArray lang = (JSONArray) jsonObject.get(type);
        Iterator i = lang.iterator();
        int j = 0;
        // take each value from the json array separately
        List<JSONObject> list = new ArrayList<>();
        while (i.hasNext()) {
            j++;
            JSONObject innerObj = (JSONObject) i.next();
            if (innerObj.get(strEvtKey).equals(key)) {
                list.add(innerObj);
            }
        }
        // handle a structure into the json object

        return list;
    }
}
