package com.example.alex.berich;

import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Alex on 1/27/2016.
 */
public class RestClient {

    private static final String DOMAIN = "https://api.parse.com/1/";

    private static final String TAG = RestClient.class.getSimpleName();
    private static final String USERAGENT = "android";
    private static final String API_KEY = "apikey";
    private static final String TOKEN = "token";

    public static   void put(final String URN,final HashMap<String, String> params, final boolean appKeyRequired, final RequestJSONObjectResponse requestResponse ){
        executeObjectRequest(Request.Method.PUT, URN, params, appKeyRequired, requestResponse);
    }

    public static   void post(final String URN,final HashMap<String, String> params, final boolean appKeyRequired, final RequestJSONObjectResponse requestResponse ){
        executeObjectRequest(Request.Method.POST, URN, params, appKeyRequired, requestResponse);
    }

    public static   void postWithEntity(final String URN, final String entity, final boolean appKeyRequired, final RequestJSONObjectResponse requestResponse ){
        executeObjectRequestWithEntity(Request.Method.POST, URN, entity, appKeyRequired, requestResponse);
    }

    public static   void getAuthenticatedWithParams(final String URN,final HashMap<String, String> params, final RequestJSONObjectResponse requestResponse ){
        executeObjectRequest(Request.Method.GET, URN, params, true, requestResponse);
    }


    public static   void getAuthenticated(final String URN, final RequestJSONObjectResponse requestResponse ){
        executeObjectRequest(Request.Method.GET, URN, null, true, requestResponse);
    }

    public static   void get(final String URN, final HashMap<String, String> params, final boolean appKeyRequired, final RequestJSONArrayResponse requestResponse ){
        executeArrayRequest(Request.Method.GET, URN, params, appKeyRequired, requestResponse);
    }

    private static void executeObjectRequest(int method, final String URN, final HashMap<String, String> params, final boolean appKeyRequired, final RequestJSONObjectResponse requestResponse){

        StringRequest stringRequest = new StringRequest
                (method, getAbsoluteUrl(URN), new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if (response != null) {
                            Log.d(TAG, "--> Request succeded: " + DOMAIN + URN);

                            if (requestResponse != null)
                                try {
                                    requestResponse.onSuccess(new JSONObject(response));
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                        } else {
                            Log.d(TAG, "--> Request failed: " + DOMAIN + URN);
                        }
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        error.printStackTrace();
                        if (error != null) {
                            Log.d(TAG, "--> Request failed: " + DOMAIN + URN + ":" + error.toString());
                        }
                        if (requestResponse != null) {
                            requestResponse.onFailed(error.toString());
                        }
                    }
                }){

            @Override
            public Map<String, String> getHeaders(){
                Map<String, String> headers = new HashMap<String, String>();
                headers.put("User-agent", USERAGENT);
                if (appKeyRequired){
                   // headers.put(API_KEY, CiApp.getCtx().getSharedPreferences("UserPrefs", 0).getString(TOKEN, ""));
                }
                return headers;
            }

            @Override
            protected Map<String, String> getParams() {
                if (params!= null) {
                    return params;
                }else{
                    return params;
                }

            }
        };

        stringRequest.setShouldCache(false);
        stringRequest.setRetryPolicy(new DefaultRetryPolicy(
                2000,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

        VolleySingleton.getInstance(BeRichApp.getAppContext()).getRequestQueue().add(stringRequest);
    }

    private static void executeObjectRequestWithEntity(int method, final String URN, final String entity, final boolean appKeyRequired, final RequestJSONObjectResponse requestResponse){

        StringRequest stringRequest = new StringRequest
                (method, getAbsoluteUrl(URN), new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if (response != null) {
                            Log.d(TAG, "--> Request succeded: " + DOMAIN + URN );

                            if (requestResponse != null)
                                try {
                                    requestResponse.onSuccess(new JSONObject(response));
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                        } else {
                            Log.d(TAG, "--> Request failed: " + DOMAIN + URN);
                        }
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        error.printStackTrace();
                        if (error != null) {
                            Log.d(TAG, "--> Request failed: " + DOMAIN + URN + ":" + error.toString());
                        }
                        if (requestResponse != null) {
                            requestResponse.onFailed(error.toString());
                        }
                    }
                }){

            @Override
            public Map<String, String> getHeaders(){
                Map<String, String> headers = new HashMap<String, String>();
                headers.put("User-agent", USERAGENT);
                if (appKeyRequired){
                    headers.put(API_KEY, BeRichApp.getAppContext().getSharedPreferences("UserPrefs", 0).getString(TOKEN, ""));
                }
                return headers;
            }

            @Override
            public byte[] getBody() throws AuthFailureError {
                return entity.getBytes();
            }
        };

        stringRequest.setShouldCache(false);
        stringRequest.setRetryPolicy(new DefaultRetryPolicy(
                2000,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

        VolleySingleton.getInstance(BeRichApp.getAppContext()).getRequestQueue().add(stringRequest);
    }

    private static void executeArrayRequest(int method, final String URN, final HashMap<String, String> params, final boolean appKeyRequired, final RequestJSONArrayResponse requestResponse){

        StringRequest stringRequest = new StringRequest
                (method, getAbsoluteUrl(URN), new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if (response != null) {
                            Log.d(TAG, "--> Request succeded: " + DOMAIN + URN );

                            if (requestResponse != null)
                                try {
                                    requestResponse.onSuccess(new JSONArray(response));
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                        } else {
                            Log.d(TAG, "-->  Request failed: " + DOMAIN + URN + ":"  + response.toString());
                        }
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        error.printStackTrace();
                        if (error != null) {
                            Log.d(TAG, "-->  Request failed: " + DOMAIN + URN + ":" + error.toString());
                        }
                        if (requestResponse != null) {
                            requestResponse.onFailed(error.toString());
                        }
                    }
                }){

            @Override
            public Map<String, String> getHeaders(){
                Map<String, String> headers = new HashMap<String, String>();
                headers.put("User-agent", USERAGENT);
                if (appKeyRequired){
                    headers.put(API_KEY, BeRichApp.getAppContext().getSharedPreferences("UserPrefs", 0).getString(TOKEN, ""));
                }
                return headers;
            }

            @Override
            protected Map<String, String> getParams() {
                if (params!= null) {
                    return params;
                }else{
                    return params;
                }

            }
        };

        stringRequest.setShouldCache(false);
        stringRequest.setRetryPolicy(new DefaultRetryPolicy(
                2000,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

        VolleySingleton.getInstance(BeRichApp.getAppContext()).getRequestQueue().add(stringRequest);
    }

    private static String getAbsoluteUrl(String relativeUrl) {
        return DOMAIN + relativeUrl;
    }

    public interface  RequestJSONObjectResponse{
        public void onSuccess(JSONObject response);
        public void onFailed(String response);
    }

    public interface  RequestJSONArrayResponse{
        public void onSuccess(JSONArray response);
        public void onFailed(String response);
    }

}