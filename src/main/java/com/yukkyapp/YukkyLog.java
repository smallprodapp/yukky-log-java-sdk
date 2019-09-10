package com.yukkyapp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;
import com.google.gson.Gson;

public class YukkyLog {
    private static String appkey;
    private static String appsecret;
    private static Boolean debug = false;

    public static void init(String appkey, String appsecret, Boolean debug) {
        YukkyLog.appkey = appkey;
        YukkyLog.appsecret = appsecret;
        YukkyLog.debug = debug;
    }

    public static void init(String appkey, String appsecret) {
        YukkyLog.appkey = appkey;
        YukkyLog.appsecret = appsecret;
    }

    private static void request(FullLog data) {
        try {
            Request req = new Request(data, YukkyLog.appkey, YukkyLog.appsecret);
            Gson g = new Gson();
            String json = g.toJson(req);
            System.out.println(json);
            URL obj = new URL("https://api.yukkyapp.com/log");
            HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();
            con.setRequestMethod("POST");
            con.setRequestProperty("Content-Type", "application/json");
            con.setRequestProperty("Accept", "application/json");
            con.setDoOutput(true);
            OutputStream os = con.getOutputStream();
            byte[] input = json.getBytes("utf-8");
            os.write(input, 0, input.length);
            InputStreamReader isr = new InputStreamReader(con.getInputStream(), "utf-8");
            BufferedReader br = new BufferedReader(isr);
            StringBuilder response = new StringBuilder();
            String responseline = null;
            while ((responseline = br.readLine()) != null) {
                response.append(responseline.trim());
            }
        } catch (Exception ex) {
            if (YukkyLog.debug) {
                System.out.println(ex);
            }
        }
    }

    public static void error(Log data) {
        try {
            FullLog log = new FullLog(data, "error");
            request(log);
        } catch (Exception ex) {
            if (YukkyLog.debug) {
                System.out.println(ex);
            }
        }
    }

    public static void warning(Log data) {
        try {
            FullLog log = new FullLog(data, "warning");
            request(log);
        } catch (Exception ex) {
            if (YukkyLog.debug) {
                System.out.println(ex);
            }
        }
    }

    public static void info(Log data) {
        try {
            FullLog log = new FullLog(data, "info");
            request(log);
        } catch (Exception ex) {
            if (YukkyLog.debug) {
                System.out.println(ex);
            }
        }
    }

    public static void custom(FullLog data) {
        try {
            request(data);
        } catch (Exception ex) {
            if (YukkyLog.debug) {
                System.out.println(ex);
            }
        }
    }
}