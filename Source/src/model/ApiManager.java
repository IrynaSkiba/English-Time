package model;

import javax.net.ssl.HttpsURLConnection;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Scanner;

public class ApiManager {
    private static String API_KEY = "trnsl.1.1.20181119T120745Z.802fac940f617ba3.8a6802ef513bed1ca08fd95f1f5dfd5fb7788ade";
    private static final String SERVICE_HOST = "https://translate.yandex.net";
    private static final String SERVICE_PATH = "/api/v1.5/tr.json/detect";
    private String jsonRequest;

    public String translate(String inputWord) throws IOException {
        String lang = determineLanguage(inputWord);
        jsonRequest = "https://translate.yandex.net/api/v1.5/tr.json/translate?key=" + API_KEY;

        URL urlObj = new URL(jsonRequest);
        HttpsURLConnection connection = (HttpsURLConnection) urlObj.openConnection();
        connection.setRequestMethod("POST");
        connection.setDoOutput(true);
        DataOutputStream dataOutputStream = new DataOutputStream(connection.getOutputStream());
        if (lang.equals("en"))
            dataOutputStream.writeBytes("text=" + URLEncoder.encode(inputWord, "UTF-8") + "&lang=en-ru");
        else dataOutputStream.writeBytes("text=" + URLEncoder.encode(inputWord, "UTF-8") + "&lang=ru-en");

        InputStream response = connection.getInputStream();
        String json = new Scanner(response).nextLine();
        int start = json.indexOf("[");
        int end = json.indexOf("]");

        return json.substring(start + 2, end - 1);
    }

    private String determineLanguage(String inputWord) throws IOException {
        jsonRequest = SERVICE_HOST + SERVICE_PATH + "?key=" + API_KEY;

        URL urlObj = new URL(jsonRequest);
        HttpsURLConnection connection = (HttpsURLConnection) urlObj.openConnection();
        connection.setRequestMethod("POST");
        connection.setDoOutput(true);
        DataOutputStream dataOutputStream = new DataOutputStream(connection.getOutputStream());
        dataOutputStream.writeBytes("text=" + URLEncoder.encode(inputWord, "UTF-8") + "?hint=en,ru");

        InputStream response = connection.getInputStream();
        String json = new Scanner(response).nextLine();
        int start = json.indexOf("[");
        int end = json.indexOf("}");
        return json.substring(start + 21, end - 1);
    }
}