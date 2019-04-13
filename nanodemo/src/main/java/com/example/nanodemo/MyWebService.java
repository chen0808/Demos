package com.example.nanodemo;

import android.content.Context;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import fi.iki.elonen.NanoHTTPD;

public class MyWebService extends NanoHTTPD {

    private static final String FILE_NAME = "configM.json";
    private final Context _mainContext;

    public MyWebService(Context context, int port) throws IOException {
        super(port);
        _mainContext = context;
        start();
    }

    @Override
    public Response serve(IHTTPSession session) {
        String uri = session.getUri();
        Log.d("MyWebService", "uri:" + uri + "--------method:" + session.getMethod());
        String filename = uri.substring(1);
        if (uri.equals("/")) {
            filename = FILE_NAME;
        }

        String mimetype = "text/html";
        boolean is_ascii = true;
        if (filename.contains(".html") || filename.contains(".htm")) {
            mimetype = "text/html";
            is_ascii = true;
        } else if (filename.contains(".js")) {
            if (filename.contains(".json")) {
                mimetype = "text/json";
                is_ascii = true;
            } else {
                mimetype = "text/jacascript";
                is_ascii = true;
            }
        } else if (filename.contains(".css")) {
            mimetype = "text/css";
            is_ascii = true;
        } else if (filename.contains(".gif")) {
            mimetype = "text/gif";
            is_ascii = false;
        } else if (filename.contains(".jpeg") || filename.contains(".jpg")) {
            mimetype = "text/jpeg";
            is_ascii = false;
        } else if (filename.contains(".png")) {
            mimetype = "image/png";
            is_ascii = false;
        } else if (filename.contains(".mp4")) {
            mimetype = "video/mp4";
            is_ascii = false;
        } else {
            filename = FILE_NAME;
            mimetype = "text/html";
        }

        if (is_ascii) {
            String response = "";
            String line = "";
            BufferedReader reader = null;
            try {
                reader = new BufferedReader(new InputStreamReader(_mainContext.getAssets().open(filename)));

                while ((line = reader.readLine()) != null) {
                    response += line;
                }
                reader.close();

            } catch (IOException e) {
                e.printStackTrace();
                Log.e("MyWebService", e.getMessage());
            }
            return newFixedLengthResponse(Response.Status.OK, mimetype, response);
        } else {
            InputStream isr;
            try {
                isr = _mainContext.getAssets().open(filename);
                return newFixedLengthResponse(Response.Status.OK, mimetype, isr, isr.available());
            } catch (IOException e) {
                e.printStackTrace();
                Log.e("MyWebService", e.getMessage());
                return newFixedLengthResponse(Response.Status.OK, mimetype, "");
            }
        }
    }
}
