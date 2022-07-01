package com.loopj.android.http;

import java.io.IOException;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.xml.sax.helpers.DefaultHandler;

public abstract class SaxAsyncHttpResponseHandler<T extends DefaultHandler> extends AsyncHttpResponseHandler {
  private static final String LOG_TAG = "SaxAsyncHttpResponseHandler";
  
  private T handler = null;
  
  public SaxAsyncHttpResponseHandler(T paramT) {
    if (paramT != null) {
      this.handler = paramT;
      return;
    } 
    throw new Error("null instance of <T extends DefaultHandler> passed to constructor");
  }
  
  protected byte[] getResponseData(HttpEntity paramHttpEntity) throws IOException {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aload_1
    //   3: ifnull -> 158
    //   6: aload_1
    //   7: invokeinterface getContent : ()Ljava/io/InputStream;
    //   12: astore #4
    //   14: aload #4
    //   16: ifnull -> 158
    //   19: invokestatic newInstance : ()Ljavax/xml/parsers/SAXParserFactory;
    //   22: invokevirtual newSAXParser : ()Ljavax/xml/parsers/SAXParser;
    //   25: invokevirtual getXMLReader : ()Lorg/xml/sax/XMLReader;
    //   28: astore_3
    //   29: aload_3
    //   30: aload_0
    //   31: getfield handler : Lorg/xml/sax/helpers/DefaultHandler;
    //   34: invokeinterface setContentHandler : (Lorg/xml/sax/ContentHandler;)V
    //   39: new java/io/InputStreamReader
    //   42: dup
    //   43: aload #4
    //   45: ldc 'UTF-8'
    //   47: invokespecial <init> : (Ljava/io/InputStream;Ljava/lang/String;)V
    //   50: astore_1
    //   51: aload_1
    //   52: astore_2
    //   53: aload_3
    //   54: new org/xml/sax/InputSource
    //   57: dup
    //   58: aload_1
    //   59: invokespecial <init> : (Ljava/io/Reader;)V
    //   62: invokeinterface parse : (Lorg/xml/sax/InputSource;)V
    //   67: aload #4
    //   69: invokestatic silentCloseInputStream : (Ljava/io/InputStream;)V
    //   72: aload_1
    //   73: invokevirtual close : ()V
    //   76: aconst_null
    //   77: areturn
    //   78: astore_3
    //   79: goto -> 93
    //   82: astore_3
    //   83: goto -> 119
    //   86: astore_1
    //   87: goto -> 143
    //   90: astore_3
    //   91: aconst_null
    //   92: astore_1
    //   93: aload_1
    //   94: astore_2
    //   95: ldc 'SaxAsyncHttpResponseHandler'
    //   97: ldc 'getResponseData exception'
    //   99: aload_3
    //   100: invokestatic e : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   103: pop
    //   104: aload #4
    //   106: invokestatic silentCloseInputStream : (Ljava/io/InputStream;)V
    //   109: aload_1
    //   110: ifnull -> 158
    //   113: goto -> 72
    //   116: astore_3
    //   117: aconst_null
    //   118: astore_1
    //   119: aload_1
    //   120: astore_2
    //   121: ldc 'SaxAsyncHttpResponseHandler'
    //   123: ldc 'getResponseData exception'
    //   125: aload_3
    //   126: invokestatic e : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   129: pop
    //   130: aload #4
    //   132: invokestatic silentCloseInputStream : (Ljava/io/InputStream;)V
    //   135: aload_1
    //   136: ifnull -> 158
    //   139: goto -> 72
    //   142: astore_1
    //   143: aload #4
    //   145: invokestatic silentCloseInputStream : (Ljava/io/InputStream;)V
    //   148: aload_2
    //   149: ifnull -> 156
    //   152: aload_2
    //   153: invokevirtual close : ()V
    //   156: aload_1
    //   157: athrow
    //   158: aconst_null
    //   159: areturn
    //   160: astore_1
    //   161: aconst_null
    //   162: areturn
    //   163: astore_2
    //   164: goto -> 156
    // Exception table:
    //   from	to	target	type
    //   19	51	116	org/xml/sax/SAXException
    //   19	51	90	javax/xml/parsers/ParserConfigurationException
    //   19	51	86	finally
    //   53	67	82	org/xml/sax/SAXException
    //   53	67	78	javax/xml/parsers/ParserConfigurationException
    //   53	67	142	finally
    //   72	76	160	java/io/IOException
    //   95	104	142	finally
    //   121	130	142	finally
    //   152	156	163	java/io/IOException
  }
  
  public abstract void onFailure(int paramInt, Header[] paramArrayOfHeader, T paramT);
  
  public void onFailure(int paramInt, Header[] paramArrayOfHeader, byte[] paramArrayOfbyte, Throwable paramThrowable) {
    onSuccess(paramInt, paramArrayOfHeader, this.handler);
  }
  
  public abstract void onSuccess(int paramInt, Header[] paramArrayOfHeader, T paramT);
  
  public void onSuccess(int paramInt, Header[] paramArrayOfHeader, byte[] paramArrayOfbyte) {
    onSuccess(paramInt, paramArrayOfHeader, this.handler);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\loopj\android\http\SaxAsyncHttpResponseHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */