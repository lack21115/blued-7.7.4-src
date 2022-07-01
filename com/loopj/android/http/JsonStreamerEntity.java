package com.loopj.android.http;

import android.util.Log;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.GZIPOutputStream;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.message.BasicHeader;
import org.json.JSONArray;
import org.json.JSONObject;

public class JsonStreamerEntity implements HttpEntity {
  private static final int BUFFER_SIZE = 4096;
  
  private static final StringBuilder BUILDER;
  
  private static final UnsupportedOperationException ERR_UNSUPPORTED = new UnsupportedOperationException("Unsupported operation in this implementation.");
  
  private static final Header HEADER_GZIP_ENCODING;
  
  private static final Header HEADER_JSON_CONTENT;
  
  private static final byte[] JSON_FALSE;
  
  private static final byte[] JSON_NULL;
  
  private static final byte[] JSON_TRUE;
  
  private static final String LOG_TAG = "JsonStreamerEntity";
  
  private static final byte[] STREAM_CONTENTS;
  
  private static final byte[] STREAM_ELAPSED;
  
  private static final byte[] STREAM_NAME;
  
  private static final byte[] STREAM_TYPE;
  
  private final byte[] buffer = new byte[4096];
  
  private final Header contentEncoding;
  
  private final Map<String, Object> jsonParams = new HashMap<String, Object>();
  
  private final ResponseHandlerInterface progressHandler;
  
  static {
    BUILDER = new StringBuilder(128);
    JSON_TRUE = "true".getBytes();
    JSON_FALSE = "false".getBytes();
    JSON_NULL = "null".getBytes();
    STREAM_NAME = escape("name");
    STREAM_TYPE = escape("type");
    STREAM_CONTENTS = escape("contents");
    STREAM_ELAPSED = escape("_elapsed");
    HEADER_JSON_CONTENT = (Header)new BasicHeader("Content-Type", "application/json");
    HEADER_GZIP_ENCODING = (Header)new BasicHeader("Content-Encoding", "gzip");
  }
  
  public JsonStreamerEntity(ResponseHandlerInterface paramResponseHandlerInterface, boolean paramBoolean) {
    this.progressHandler = paramResponseHandlerInterface;
    if (paramBoolean) {
      Header header = HEADER_GZIP_ENCODING;
    } else {
      paramResponseHandlerInterface = null;
    } 
    this.contentEncoding = (Header)paramResponseHandlerInterface;
  }
  
  private void endMetaData(OutputStream paramOutputStream) throws IOException {
    paramOutputStream.write(34);
  }
  
  static byte[] escape(String paramString) {
    // Byte code:
    //   0: aload_0
    //   1: ifnonnull -> 8
    //   4: getstatic com/loopj/android/http/JsonStreamerEntity.JSON_NULL : [B
    //   7: areturn
    //   8: getstatic com/loopj/android/http/JsonStreamerEntity.BUILDER : Ljava/lang/StringBuilder;
    //   11: bipush #34
    //   13: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   16: pop
    //   17: aload_0
    //   18: invokevirtual length : ()I
    //   21: istore #4
    //   23: iconst_m1
    //   24: istore_2
    //   25: iload_2
    //   26: iconst_1
    //   27: iadd
    //   28: istore_3
    //   29: iconst_0
    //   30: istore_2
    //   31: iload_3
    //   32: iload #4
    //   34: if_icmpge -> 310
    //   37: aload_0
    //   38: iload_3
    //   39: invokevirtual charAt : (I)C
    //   42: istore_1
    //   43: iload_1
    //   44: bipush #12
    //   46: if_icmpeq -> 296
    //   49: iload_1
    //   50: bipush #13
    //   52: if_icmpeq -> 282
    //   55: iload_1
    //   56: bipush #34
    //   58: if_icmpeq -> 268
    //   61: iload_1
    //   62: bipush #92
    //   64: if_icmpeq -> 254
    //   67: iload_1
    //   68: tableswitch default -> 96, 8 -> 240, 9 -> 226, 10 -> 212
    //   96: iload_1
    //   97: iflt -> 106
    //   100: iload_1
    //   101: bipush #31
    //   103: if_icmple -> 133
    //   106: iload_1
    //   107: bipush #127
    //   109: if_icmplt -> 119
    //   112: iload_1
    //   113: sipush #159
    //   116: if_icmple -> 133
    //   119: iload_1
    //   120: sipush #8192
    //   123: if_icmplt -> 199
    //   126: iload_1
    //   127: sipush #8447
    //   130: if_icmpgt -> 199
    //   133: iload_1
    //   134: invokestatic toHexString : (I)Ljava/lang/String;
    //   137: astore #6
    //   139: getstatic com/loopj/android/http/JsonStreamerEntity.BUILDER : Ljava/lang/StringBuilder;
    //   142: ldc '\u'
    //   144: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   147: pop
    //   148: aload #6
    //   150: invokevirtual length : ()I
    //   153: istore #5
    //   155: iload_2
    //   156: iconst_4
    //   157: iload #5
    //   159: isub
    //   160: if_icmpge -> 179
    //   163: getstatic com/loopj/android/http/JsonStreamerEntity.BUILDER : Ljava/lang/StringBuilder;
    //   166: bipush #48
    //   168: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   171: pop
    //   172: iload_2
    //   173: iconst_1
    //   174: iadd
    //   175: istore_2
    //   176: goto -> 155
    //   179: getstatic com/loopj/android/http/JsonStreamerEntity.BUILDER : Ljava/lang/StringBuilder;
    //   182: aload #6
    //   184: getstatic java/util/Locale.US : Ljava/util/Locale;
    //   187: invokevirtual toUpperCase : (Ljava/util/Locale;)Ljava/lang/String;
    //   190: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   193: pop
    //   194: iload_3
    //   195: istore_2
    //   196: goto -> 25
    //   199: getstatic com/loopj/android/http/JsonStreamerEntity.BUILDER : Ljava/lang/StringBuilder;
    //   202: iload_1
    //   203: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   206: pop
    //   207: iload_3
    //   208: istore_2
    //   209: goto -> 25
    //   212: getstatic com/loopj/android/http/JsonStreamerEntity.BUILDER : Ljava/lang/StringBuilder;
    //   215: ldc '\n'
    //   217: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   220: pop
    //   221: iload_3
    //   222: istore_2
    //   223: goto -> 25
    //   226: getstatic com/loopj/android/http/JsonStreamerEntity.BUILDER : Ljava/lang/StringBuilder;
    //   229: ldc '\t'
    //   231: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   234: pop
    //   235: iload_3
    //   236: istore_2
    //   237: goto -> 25
    //   240: getstatic com/loopj/android/http/JsonStreamerEntity.BUILDER : Ljava/lang/StringBuilder;
    //   243: ldc '\b'
    //   245: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   248: pop
    //   249: iload_3
    //   250: istore_2
    //   251: goto -> 25
    //   254: getstatic com/loopj/android/http/JsonStreamerEntity.BUILDER : Ljava/lang/StringBuilder;
    //   257: ldc '\\'
    //   259: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   262: pop
    //   263: iload_3
    //   264: istore_2
    //   265: goto -> 25
    //   268: getstatic com/loopj/android/http/JsonStreamerEntity.BUILDER : Ljava/lang/StringBuilder;
    //   271: ldc '\"'
    //   273: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   276: pop
    //   277: iload_3
    //   278: istore_2
    //   279: goto -> 25
    //   282: getstatic com/loopj/android/http/JsonStreamerEntity.BUILDER : Ljava/lang/StringBuilder;
    //   285: ldc '\r'
    //   287: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   290: pop
    //   291: iload_3
    //   292: istore_2
    //   293: goto -> 25
    //   296: getstatic com/loopj/android/http/JsonStreamerEntity.BUILDER : Ljava/lang/StringBuilder;
    //   299: ldc '\f'
    //   301: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   304: pop
    //   305: iload_3
    //   306: istore_2
    //   307: goto -> 25
    //   310: getstatic com/loopj/android/http/JsonStreamerEntity.BUILDER : Ljava/lang/StringBuilder;
    //   313: bipush #34
    //   315: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   318: pop
    //   319: getstatic com/loopj/android/http/JsonStreamerEntity.BUILDER : Ljava/lang/StringBuilder;
    //   322: invokevirtual toString : ()Ljava/lang/String;
    //   325: invokevirtual getBytes : ()[B
    //   328: astore_0
    //   329: getstatic com/loopj/android/http/JsonStreamerEntity.BUILDER : Ljava/lang/StringBuilder;
    //   332: iconst_0
    //   333: invokevirtual setLength : (I)V
    //   336: aload_0
    //   337: areturn
    //   338: astore_0
    //   339: getstatic com/loopj/android/http/JsonStreamerEntity.BUILDER : Ljava/lang/StringBuilder;
    //   342: iconst_0
    //   343: invokevirtual setLength : (I)V
    //   346: aload_0
    //   347: athrow
    // Exception table:
    //   from	to	target	type
    //   319	329	338	finally
  }
  
  private void writeMetaData(OutputStream paramOutputStream, String paramString1, String paramString2) throws IOException {
    paramOutputStream.write(STREAM_NAME);
    paramOutputStream.write(58);
    paramOutputStream.write(escape(paramString1));
    paramOutputStream.write(44);
    paramOutputStream.write(STREAM_TYPE);
    paramOutputStream.write(58);
    paramOutputStream.write(escape(paramString2));
    paramOutputStream.write(44);
    paramOutputStream.write(STREAM_CONTENTS);
    paramOutputStream.write(58);
    paramOutputStream.write(34);
  }
  
  private void writeToFromFile(OutputStream paramOutputStream, RequestParams.FileWrapper paramFileWrapper) throws IOException {
    writeMetaData(paramOutputStream, paramFileWrapper.file.getName(), paramFileWrapper.contentType);
    int j = (int)paramFileWrapper.file.length();
    FileInputStream fileInputStream = new FileInputStream(paramFileWrapper.file);
    Base64OutputStream base64OutputStream = new Base64OutputStream(paramOutputStream, 18);
    int i = 0;
    while (true) {
      int k = fileInputStream.read(this.buffer);
      if (k != -1) {
        base64OutputStream.write(this.buffer, 0, k);
        i += k;
        this.progressHandler.sendProgressMessage(i, j);
        continue;
      } 
      AsyncHttpClient.silentCloseOutputStream(base64OutputStream);
      endMetaData(paramOutputStream);
      AsyncHttpClient.silentCloseInputStream(fileInputStream);
      return;
    } 
  }
  
  private void writeToFromStream(OutputStream paramOutputStream, RequestParams.StreamWrapper paramStreamWrapper) throws IOException {
    writeMetaData(paramOutputStream, paramStreamWrapper.name, paramStreamWrapper.contentType);
    Base64OutputStream base64OutputStream = new Base64OutputStream(paramOutputStream, 18);
    while (true) {
      int i = paramStreamWrapper.inputStream.read(this.buffer);
      if (i != -1) {
        base64OutputStream.write(this.buffer, 0, i);
        continue;
      } 
      AsyncHttpClient.silentCloseOutputStream(base64OutputStream);
      endMetaData(paramOutputStream);
      if (paramStreamWrapper.autoClose)
        AsyncHttpClient.silentCloseInputStream(paramStreamWrapper.inputStream); 
      return;
    } 
  }
  
  public void addPart(String paramString, Object paramObject) {
    this.jsonParams.put(paramString, paramObject);
  }
  
  public void consumeContent() throws IOException, UnsupportedOperationException {}
  
  public InputStream getContent() throws IOException, UnsupportedOperationException {
    throw ERR_UNSUPPORTED;
  }
  
  public Header getContentEncoding() {
    return this.contentEncoding;
  }
  
  public long getContentLength() {
    return -1L;
  }
  
  public Header getContentType() {
    return HEADER_JSON_CONTENT;
  }
  
  public boolean isChunked() {
    return false;
  }
  
  public boolean isRepeatable() {
    return false;
  }
  
  public boolean isStreaming() {
    return false;
  }
  
  public void writeTo(OutputStream paramOutputStream) throws IOException {
    if (paramOutputStream != null) {
      long l = System.currentTimeMillis();
      OutputStream outputStream = paramOutputStream;
      if (this.contentEncoding != null)
        outputStream = new GZIPOutputStream(paramOutputStream, 4096); 
      outputStream.write(123);
      for (String str : this.jsonParams.keySet()) {
        paramOutputStream = (OutputStream)this.jsonParams.get(str);
        if (paramOutputStream == null)
          continue; 
        outputStream.write(escape(str));
        outputStream.write(58);
        boolean bool = paramOutputStream instanceof RequestParams.FileWrapper;
        if (bool || paramOutputStream instanceof RequestParams.StreamWrapper) {
          outputStream.write(123);
          if (bool) {
            writeToFromFile(outputStream, (RequestParams.FileWrapper)paramOutputStream);
          } else {
            writeToFromStream(outputStream, (RequestParams.StreamWrapper)paramOutputStream);
          } 
          outputStream.write(125);
        } else if (paramOutputStream instanceof JsonValueInterface) {
          outputStream.write(((JsonValueInterface)paramOutputStream).getEscapedJsonValue());
        } else if (paramOutputStream instanceof JSONObject) {
          outputStream.write(((JSONObject)paramOutputStream).toString().getBytes());
        } else if (paramOutputStream instanceof JSONArray) {
          outputStream.write(((JSONArray)paramOutputStream).toString().getBytes());
        } else {
          byte[] arrayOfByte;
          if (paramOutputStream instanceof Boolean) {
            if (((Boolean)paramOutputStream).booleanValue()) {
              arrayOfByte = JSON_TRUE;
            } else {
              arrayOfByte = JSON_FALSE;
            } 
            outputStream.write(arrayOfByte);
          } else if (arrayOfByte instanceof Long) {
            StringBuilder stringBuilder1 = new StringBuilder();
            stringBuilder1.append(((Number)arrayOfByte).longValue());
            stringBuilder1.append("");
            outputStream.write(stringBuilder1.toString().getBytes());
          } else if (arrayOfByte instanceof Double) {
            StringBuilder stringBuilder1 = new StringBuilder();
            stringBuilder1.append(((Number)arrayOfByte).doubleValue());
            stringBuilder1.append("");
            outputStream.write(stringBuilder1.toString().getBytes());
          } else if (arrayOfByte instanceof Float) {
            StringBuilder stringBuilder1 = new StringBuilder();
            stringBuilder1.append(((Number)arrayOfByte).floatValue());
            stringBuilder1.append("");
            outputStream.write(stringBuilder1.toString().getBytes());
          } else if (arrayOfByte instanceof Integer) {
            StringBuilder stringBuilder1 = new StringBuilder();
            stringBuilder1.append(((Number)arrayOfByte).intValue());
            stringBuilder1.append("");
            outputStream.write(stringBuilder1.toString().getBytes());
          } else {
            outputStream.write(escape(arrayOfByte.toString()));
          } 
        } 
        outputStream.write(44);
      } 
      outputStream.write(STREAM_ELAPSED);
      outputStream.write(58);
      l = System.currentTimeMillis() - l;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(l);
      stringBuilder.append("}");
      outputStream.write(stringBuilder.toString().getBytes());
      stringBuilder = new StringBuilder();
      stringBuilder.append("Uploaded JSON in ");
      stringBuilder.append(Math.floor((l / 1000L)));
      stringBuilder.append(" seconds");
      Log.i("JsonStreamerEntity", stringBuilder.toString());
      outputStream.flush();
      AsyncHttpClient.silentCloseOutputStream(outputStream);
      return;
    } 
    throw new IllegalStateException("Output stream cannot be null.");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\loopj\android\http\JsonStreamerEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */