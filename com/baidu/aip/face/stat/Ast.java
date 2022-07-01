package com.baidu.aip.face.stat;

import android.content.Context;
import android.text.TextUtils;
import android.util.SparseArray;
import com.baidu.idl.facesdk.FaceInfo;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Ast {
  private static final String AS_FILE_NAME = "ast";
  
  private static final String FACE_HIT_KEY_LASSTTIME = "FACE_HIT_KEY_LASSTTIME";
  
  private static final long SAVE_INTERVAL = 15000L;
  
  private static final long UPADTE_DEFUALT_DELAY_TIME = 15000L;
  
  private static final String UPLOAD_LASSTTIME = "UPLOAD_LASSTTIME";
  
  private static Ast instance;
  
  private File asFile;
  
  private Context context;
  
  private Dev dev;
  
  ExecutorService es = Executors.newSingleThreadExecutor();
  
  private String faceHitKey = "";
  
  private SparseArray<Integer> faceIds = new SparseArray();
  
  Future future = null;
  
  private boolean isInit;
  
  private long lastSavetime;
  
  private Properties properties;
  
  private String scene;
  
  private void clear() {
    this.properties.clear();
  }
  
  private String generateFaceHitKey(String paramString) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append((new SimpleDateFormat("yyyy_MM_dd_HH")).format(new Date()));
    stringBuilder.append("_");
    stringBuilder.append(paramString);
    return stringBuilder.toString();
  }
  
  public static Ast getInstance() {
    // Byte code:
    //   0: getstatic com/baidu/aip/face/stat/Ast.instance : Lcom/baidu/aip/face/stat/Ast;
    //   3: ifnonnull -> 31
    //   6: ldc com/baidu/aip/face/stat/Ast
    //   8: monitorenter
    //   9: new com/baidu/aip/face/stat/Ast
    //   12: dup
    //   13: invokespecial <init> : ()V
    //   16: putstatic com/baidu/aip/face/stat/Ast.instance : Lcom/baidu/aip/face/stat/Ast;
    //   19: ldc com/baidu/aip/face/stat/Ast
    //   21: monitorexit
    //   22: goto -> 31
    //   25: astore_0
    //   26: ldc com/baidu/aip/face/stat/Ast
    //   28: monitorexit
    //   29: aload_0
    //   30: athrow
    //   31: getstatic com/baidu/aip/face/stat/Ast.instance : Lcom/baidu/aip/face/stat/Ast;
    //   34: areturn
    // Exception table:
    //   from	to	target	type
    //   9	22	25	finally
    //   26	29	25	finally
  }
  
  private boolean initFile() {
    this.asFile = new File(this.context.getFilesDir(), "ast");
    this.properties = new Properties();
    return !FileUtil.createFile(this.asFile) ? false : FileUtil.loadPropertiesFile(this.asFile, this.properties);
  }
  
  private void netRequest() {
    if (this.properties.size() == 0)
      return; 
    NetUtil.uploadData(new NetUtil.RequestAdapter() {
          public String getRequestString() {
            try {
              JSONObject jSONObject = new JSONObject();
              jSONObject.put("mh", "faceSdkStatistic");
              Iterator<Map.Entry<Object, Object>> iterator = ((Properties)Ast.this.properties.clone()).entrySet().iterator();
              JSONArray jSONArray = new JSONArray();
              while (iterator.hasNext()) {
                Map.Entry entry = iterator.next();
                String str1 = (String)entry.getKey();
                String str2 = (String)entry.getValue();
                if (str1.equalsIgnoreCase("FACE_HIT_KEY_LASSTTIME") || str1.equalsIgnoreCase("UPLOAD_LASSTTIME"))
                  continue; 
                JSONObject jSONObject1 = new JSONObject();
                jSONObject1.put("type", "facesdk");
                jSONObject1.put("scene", Ast.this.scene);
                jSONObject1.put("appid", Ast.this.dev.getPackagename());
                jSONObject1.put("device", Ast.this.dev.getBrand());
                jSONObject1.put("imei", Ast.this.dev.getUniqueID());
                jSONObject1.put("os", "Android");
                jSONObject1.put("system", Ast.this.dev.getSysVersion());
                jSONObject1.put("version", Ast.this.dev.getSdkVersion());
                boolean bool = str1.contains("liveness");
                if (bool) {
                  jSONObject1.put("isliving", "true");
                } else {
                  jSONObject1.put("isliving", "false");
                } 
                jSONObject1.put("finish", "1");
                String[] arrayOfString = str1.split("_");
                if (arrayOfString.length > 4) {
                  jSONObject1.put("year", arrayOfString[0]);
                  jSONObject1.put("month", arrayOfString[1]);
                  jSONObject1.put("day", arrayOfString[2]);
                  jSONObject1.put("hour", arrayOfString[3]);
                } 
                jSONObject1.put("num", str2);
                jSONArray.put(jSONObject1);
              } 
              jSONObject.put("dt", jSONArray);
              return jSONObject.toString();
            } catch (JSONException jSONException) {
              jSONException.printStackTrace();
              return "";
            } 
          }
          
          public String getURL() {
            return "http://brain.baidu.com/record/api";
          }
          
          public void parseResponse(InputStream param1InputStream) throws IOException, JSONException {
            // Byte code:
            //   0: new java/io/ByteArrayOutputStream
            //   3: dup
            //   4: invokespecial <init> : ()V
            //   7: astore_3
            //   8: sipush #1024
            //   11: newarray byte
            //   13: astore #4
            //   15: aload_1
            //   16: aload #4
            //   18: invokevirtual read : ([B)I
            //   21: istore_2
            //   22: iload_2
            //   23: ifle -> 37
            //   26: aload_3
            //   27: aload #4
            //   29: iconst_0
            //   30: iload_2
            //   31: invokevirtual write : ([BII)V
            //   34: goto -> 15
            //   37: aload_3
            //   38: invokevirtual flush : ()V
            //   41: new org/json/JSONObject
            //   44: dup
            //   45: new java/lang/String
            //   48: dup
            //   49: aload_3
            //   50: invokevirtual toByteArray : ()[B
            //   53: ldc 'UTF-8'
            //   55: invokespecial <init> : ([BLjava/lang/String;)V
            //   58: invokespecial <init> : (Ljava/lang/String;)V
            //   61: ldc 'code'
            //   63: invokevirtual optInt : (Ljava/lang/String;)I
            //   66: ifne -> 127
            //   69: aload_0
            //   70: getfield this$0 : Lcom/baidu/aip/face/stat/Ast;
            //   73: invokestatic access$100 : (Lcom/baidu/aip/face/stat/Ast;)Ljava/util/Properties;
            //   76: invokevirtual clear : ()V
            //   79: aload_0
            //   80: getfield this$0 : Lcom/baidu/aip/face/stat/Ast;
            //   83: invokestatic access$300 : (Lcom/baidu/aip/face/stat/Ast;)Lcom/baidu/aip/face/stat/Dev;
            //   86: iconst_0
            //   87: invokevirtual setFirstRun : (Z)V
            //   90: aload_0
            //   91: getfield this$0 : Lcom/baidu/aip/face/stat/Ast;
            //   94: invokestatic access$400 : (Lcom/baidu/aip/face/stat/Ast;)Ljava/io/File;
            //   97: aload_0
            //   98: getfield this$0 : Lcom/baidu/aip/face/stat/Ast;
            //   101: invokestatic access$100 : (Lcom/baidu/aip/face/stat/Ast;)Ljava/util/Properties;
            //   104: invokestatic savePropertiesFile : (Ljava/io/File;Ljava/util/Properties;)Z
            //   107: pop
            //   108: aload_0
            //   109: getfield this$0 : Lcom/baidu/aip/face/stat/Ast;
            //   112: invokestatic access$100 : (Lcom/baidu/aip/face/stat/Ast;)Ljava/util/Properties;
            //   115: ldc 'UPLOAD_LASSTTIME'
            //   117: invokestatic currentTimeMillis : ()J
            //   120: invokestatic valueOf : (J)Ljava/lang/String;
            //   123: invokevirtual setProperty : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
            //   126: pop
            //   127: aload_3
            //   128: invokevirtual close : ()V
            //   131: return
            //   132: astore_1
            //   133: aload_1
            //   134: invokevirtual printStackTrace : ()V
            //   137: return
            //   138: astore_1
            //   139: aload_3
            //   140: invokevirtual close : ()V
            //   143: goto -> 151
            //   146: astore_3
            //   147: aload_3
            //   148: invokevirtual printStackTrace : ()V
            //   151: aload_1
            //   152: athrow
            // Exception table:
            //   from	to	target	type
            //   15	22	138	finally
            //   26	34	138	finally
            //   37	127	138	finally
            //   127	131	132	java/io/IOException
            //   139	143	146	java/io/IOException
          }
        });
  }
  
  private void sendData() {
    Future future = this.future;
    if (future != null && !future.isDone())
      return; 
    this.future = this.es.submit(new Runnable() {
          public void run() {
            Ast.this.netRequest();
          }
        });
  }
  
  public void faceHit() {
    faceHit("liveness", 15000L, 1);
  }
  
  public void faceHit(String paramString) {
    faceHit(paramString, 15000L, 1);
  }
  
  public void faceHit(String paramString, int paramInt) {
    faceHit(paramString, 15000L, paramInt);
  }
  
  public void faceHit(String paramString, int paramInt, FaceInfo[] paramArrayOfFaceInfo) {
    if (paramArrayOfFaceInfo == null) {
      this.faceIds.clear();
      return;
    } 
    int k = paramArrayOfFaceInfo.length;
    int i = 0;
    int j;
    for (j = 0; i < k; j = m) {
      FaceInfo faceInfo = paramArrayOfFaceInfo[i];
      int m = j;
      if ((Integer)this.faceIds.get(faceInfo.face_id) == null) {
        this.faceIds.put(faceInfo.face_id, Integer.valueOf(faceInfo.face_id));
        m = j + 1;
      } 
      i++;
    } 
    if (j == 0)
      return; 
    faceHit(paramString, paramInt, j);
  }
  
  public void faceHit(String paramString, long paramLong, int paramInt) {
    long l1;
    paramString = generateFaceHitKey(paramString);
    String str = this.properties.getProperty(paramString);
    if (TextUtils.isEmpty(str)) {
      this.properties.setProperty(paramString, String.valueOf(paramInt));
      this.properties.setProperty("FACE_HIT_KEY_LASSTTIME", String.valueOf(System.currentTimeMillis()));
    } else {
      int i = Integer.parseInt(str);
      this.properties.setProperty(paramString, String.valueOf(i + paramInt));
    } 
    paramString = this.properties.getProperty("FACE_HIT_KEY_LASSTTIME");
    long l2 = 0L;
    try {
      l1 = Long.parseLong(paramString);
    } catch (Exception exception) {
      exception.printStackTrace();
      l1 = 0L;
    } 
    if (System.currentTimeMillis() - l1 > 15000L) {
      System.currentTimeMillis();
      FileUtil.savePropertiesFile(this.asFile, this.properties);
      this.properties.setProperty("FACE_HIT_KEY_LASSTTIME", String.valueOf(System.currentTimeMillis()));
    } 
    paramString = this.properties.getProperty("UPLOAD_LASSTTIME");
    try {
      l1 = Long.parseLong(paramString);
    } catch (Exception exception) {
      exception.printStackTrace();
      l1 = l2;
    } 
    if (!this.dev.getFirstRun() && System.currentTimeMillis() - l1 < paramLong)
      return; 
    sendData();
  }
  
  public void immediatelyUpload() {
    sendData();
  }
  
  public boolean init(Context paramContext, String paramString1, String paramString2) {
    if (this.isInit)
      return true; 
    if (paramContext != null) {
      this.context = paramContext.getApplicationContext();
      this.dev = new Dev();
      this.dev.init(paramContext);
      this.dev.setSdkVersion(paramString1);
      this.scene = paramString2;
      initFile();
    } 
    return true;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\aip\face\stat\Ast.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */