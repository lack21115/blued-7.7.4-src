package com.loopj.android.http;

import android.util.Log;
import org.apache.http.Header;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JsonHttpResponseHandler extends TextHttpResponseHandler {
  private static final String LOG_TAG = "JsonHttpResponseHandler";
  
  public JsonHttpResponseHandler() {
    super("UTF-8");
  }
  
  public JsonHttpResponseHandler(String paramString) {
    super(paramString);
  }
  
  public void onFailure(int paramInt, Header[] paramArrayOfHeader, String paramString, Throwable paramThrowable) {
    Log.w("JsonHttpResponseHandler", "onFailure(int, Header[], String, Throwable) was not overriden, but callback was received", paramThrowable);
  }
  
  public void onFailure(int paramInt, Header[] paramArrayOfHeader, Throwable paramThrowable, JSONArray paramJSONArray) {
    Log.w("JsonHttpResponseHandler", "onFailure(int, Header[], Throwable, JSONArray) was not overriden, but callback was received", paramThrowable);
  }
  
  public void onFailure(int paramInt, Header[] paramArrayOfHeader, Throwable paramThrowable, JSONObject paramJSONObject) {
    Log.w("JsonHttpResponseHandler", "onFailure(int, Header[], Throwable, JSONObject) was not overriden, but callback was received", paramThrowable);
  }
  
  public final void onFailure(final int statusCode, final Header[] headers, final byte[] responseBytes, final Throwable throwable) {
    Runnable runnable;
    if (responseBytes != null) {
      runnable = new Runnable() {
          public void run() {
            try {
              final Object jsonResponse = JsonHttpResponseHandler.this.parseResponse(responseBytes);
              JsonHttpResponseHandler.this.postRunnable(new Runnable() {
                    public void run() {
                      Object object = jsonResponse;
                      if (object instanceof JSONObject) {
                        JsonHttpResponseHandler.this.onFailure(statusCode, headers, throwable, (JSONObject)jsonResponse);
                        return;
                      } 
                      if (object instanceof JSONArray) {
                        JsonHttpResponseHandler.this.onFailure(statusCode, headers, throwable, (JSONArray)jsonResponse);
                        return;
                      } 
                      if (object instanceof String) {
                        JsonHttpResponseHandler.this.onFailure(statusCode, headers, (String)jsonResponse, throwable);
                        return;
                      } 
                      object = JsonHttpResponseHandler.this;
                      int i = statusCode;
                      Header[] arrayOfHeader = headers;
                      StringBuilder stringBuilder = new StringBuilder();
                      stringBuilder.append("Unexpected response type ");
                      stringBuilder.append(jsonResponse.getClass().getName());
                      object.onFailure(i, arrayOfHeader, (Throwable)new JSONException(stringBuilder.toString()), (JSONObject)null);
                    }
                  });
              return;
            } catch (JSONException jSONException) {
              JsonHttpResponseHandler.this.postRunnable(new Runnable() {
                    public void run() {
                      JsonHttpResponseHandler.this.onFailure(statusCode, headers, (Throwable)ex, (JSONObject)null);
                    }
                  });
              return;
            } 
          }
        };
      if (!getUseSynchronousMode()) {
        (new Thread(runnable)).start();
        return;
      } 
      runnable.run();
      return;
    } 
    Log.v("JsonHttpResponseHandler", "response body is null, calling onFailure(Throwable, JSONObject)");
    onFailure(statusCode, (Header[])runnable, throwable, (JSONObject)null);
  }
  
  public void onSuccess(int paramInt, Header[] paramArrayOfHeader, String paramString) {
    Log.w("JsonHttpResponseHandler", "onSuccess(int, Header[], String) was not overriden, but callback was received");
  }
  
  public void onSuccess(int paramInt, Header[] paramArrayOfHeader, JSONArray paramJSONArray) {
    Log.w("JsonHttpResponseHandler", "onSuccess(int, Header[], JSONArray) was not overriden, but callback was received");
  }
  
  public void onSuccess(int paramInt, Header[] paramArrayOfHeader, JSONObject paramJSONObject) {
    Log.w("JsonHttpResponseHandler", "onSuccess(int, Header[], JSONObject) was not overriden, but callback was received");
  }
  
  public final void onSuccess(final int statusCode, final Header[] headers, final byte[] responseBytes) {
    Runnable runnable;
    if (statusCode != 204) {
      runnable = new Runnable() {
          public void run() {
            try {
              final Object jsonResponse = JsonHttpResponseHandler.this.parseResponse(responseBytes);
              JsonHttpResponseHandler.this.postRunnable(new Runnable() {
                    public void run() {
                      Object object = jsonResponse;
                      if (object instanceof JSONObject) {
                        JsonHttpResponseHandler.this.onSuccess(statusCode, headers, (JSONObject)jsonResponse);
                        return;
                      } 
                      if (object instanceof JSONArray) {
                        JsonHttpResponseHandler.this.onSuccess(statusCode, headers, (JSONArray)jsonResponse);
                        return;
                      } 
                      if (object instanceof String) {
                        JsonHttpResponseHandler.this.onFailure(statusCode, headers, (String)jsonResponse, (Throwable)new JSONException("Response cannot be parsed as JSON data"));
                        return;
                      } 
                      object = JsonHttpResponseHandler.this;
                      int i = statusCode;
                      Header[] arrayOfHeader = headers;
                      StringBuilder stringBuilder = new StringBuilder();
                      stringBuilder.append("Unexpected response type ");
                      stringBuilder.append(jsonResponse.getClass().getName());
                      object.onFailure(i, arrayOfHeader, (Throwable)new JSONException(stringBuilder.toString()), (JSONObject)null);
                    }
                  });
              return;
            } catch (JSONException jSONException) {
              JsonHttpResponseHandler.this.postRunnable(new Runnable() {
                    public void run() {
                      JsonHttpResponseHandler.this.onFailure(statusCode, headers, (Throwable)ex, (JSONObject)null);
                    }
                  });
              return;
            } 
          }
        };
      if (!getUseSynchronousMode()) {
        (new Thread(runnable)).start();
        return;
      } 
      runnable.run();
      return;
    } 
    onSuccess(statusCode, (Header[])runnable, new JSONObject());
  }
  
  protected Object parseResponse(byte[] paramArrayOfbyte) throws JSONException {
    // Byte code:
    //   0: aconst_null
    //   1: astore #4
    //   3: aload_1
    //   4: ifnonnull -> 9
    //   7: aconst_null
    //   8: areturn
    //   9: aload_1
    //   10: aload_0
    //   11: invokevirtual getCharset : ()Ljava/lang/String;
    //   14: invokestatic getResponseString : ([BLjava/lang/String;)Ljava/lang/String;
    //   17: astore_1
    //   18: aload #4
    //   20: astore_3
    //   21: aload_1
    //   22: astore_2
    //   23: aload_1
    //   24: ifnull -> 86
    //   27: aload_1
    //   28: invokevirtual trim : ()Ljava/lang/String;
    //   31: astore_2
    //   32: aload_2
    //   33: astore_1
    //   34: aload_2
    //   35: ldc '﻿'
    //   37: invokevirtual startsWith : (Ljava/lang/String;)Z
    //   40: ifeq -> 49
    //   43: aload_2
    //   44: iconst_1
    //   45: invokevirtual substring : (I)Ljava/lang/String;
    //   48: astore_1
    //   49: aload_1
    //   50: ldc '{'
    //   52: invokevirtual startsWith : (Ljava/lang/String;)Z
    //   55: ifne -> 72
    //   58: aload #4
    //   60: astore_3
    //   61: aload_1
    //   62: astore_2
    //   63: aload_1
    //   64: ldc '['
    //   66: invokevirtual startsWith : (Ljava/lang/String;)Z
    //   69: ifeq -> 86
    //   72: new org/json/JSONTokener
    //   75: dup
    //   76: aload_1
    //   77: invokespecial <init> : (Ljava/lang/String;)V
    //   80: invokevirtual nextValue : ()Ljava/lang/Object;
    //   83: astore_3
    //   84: aload_1
    //   85: astore_2
    //   86: aload_3
    //   87: ifnonnull -> 92
    //   90: aload_2
    //   91: areturn
    //   92: aload_3
    //   93: areturn
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\loopj\android\http\JsonHttpResponseHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */