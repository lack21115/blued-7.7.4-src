package com.loopj.android.http;

import org.apache.http.Header;

public abstract class TextHttpResponseHandler extends AsyncHttpResponseHandler {
  private static final String LOG_TAG = "TextHttpResponseHandler";
  
  public TextHttpResponseHandler() {
    this("UTF-8");
  }
  
  public TextHttpResponseHandler(String paramString) {
    setCharset(paramString);
  }
  
  public static String getResponseString(byte[] paramArrayOfbyte, String paramString) {
    // Byte code:
    //   0: aload_0
    //   1: ifnonnull -> 9
    //   4: aconst_null
    //   5: astore_0
    //   6: goto -> 19
    //   9: new java/lang/String
    //   12: dup
    //   13: aload_0
    //   14: aload_1
    //   15: invokespecial <init> : ([BLjava/lang/String;)V
    //   18: astore_0
    //   19: aload_0
    //   20: ifnull -> 40
    //   23: aload_0
    //   24: ldc '﻿'
    //   26: invokevirtual startsWith : (Ljava/lang/String;)Z
    //   29: ifeq -> 40
    //   32: aload_0
    //   33: iconst_1
    //   34: invokevirtual substring : (I)Ljava/lang/String;
    //   37: astore_0
    //   38: aload_0
    //   39: areturn
    //   40: aload_0
    //   41: areturn
    //   42: astore_0
    //   43: ldc 'TextHttpResponseHandler'
    //   45: ldc 'Encoding response into string failed'
    //   47: aload_0
    //   48: invokestatic e : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   51: pop
    //   52: aconst_null
    //   53: areturn
    // Exception table:
    //   from	to	target	type
    //   9	19	42	java/io/UnsupportedEncodingException
    //   23	38	42	java/io/UnsupportedEncodingException
  }
  
  public abstract void onFailure(int paramInt, Header[] paramArrayOfHeader, String paramString, Throwable paramThrowable);
  
  public void onFailure(int paramInt, Header[] paramArrayOfHeader, byte[] paramArrayOfbyte, Throwable paramThrowable) {
    onFailure(paramInt, paramArrayOfHeader, getResponseString(paramArrayOfbyte, getCharset()), paramThrowable);
  }
  
  public abstract void onSuccess(int paramInt, Header[] paramArrayOfHeader, String paramString);
  
  public void onSuccess(int paramInt, Header[] paramArrayOfHeader, byte[] paramArrayOfbyte) {
    onSuccess(paramInt, paramArrayOfHeader, getResponseString(paramArrayOfbyte, getCharset()));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\loopj\android\http\TextHttpResponseHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */