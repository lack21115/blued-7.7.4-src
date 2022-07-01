package cn.shuzilm.core;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.PhoneStateListener;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import android.util.Log;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.channels.FileLock;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import javax.net.ssl.HostnameVerifier;
import org.json.JSONException;
import org.json.JSONObject;

public class DUHelper extends PhoneStateListener {
  public static final int MAIN_DU_ASYNCHRONOUS = 1;
  
  public static final int MAIN_DU_SYNCHRONOUS = 0;
  
  private static final String a = "du.lock";
  
  private static final String b = "du";
  
  private static AIClient c;
  
  private static final DUHelper d = new DUHelper();
  
  private static final Lock e = new ReentrantLock();
  
  private static final Lock f = new ReentrantLock();
  
  private static final ReentrantReadWriteLock g = new ReentrantReadWriteLock();
  
  private static boolean i = false;
  
  private static String j = null;
  
  private static String k = null;
  
  private static final JSONObject l = new JSONObject();
  
  private static final JSONObject m = new JSONObject();
  
  public static Context mContext;
  
  public static int mMeic;
  
  public static int mPopu;
  
  public static int mPort;
  
  private static JSONObject n = null;
  
  private static final ThreadLocal o = new ThreadLocal();
  
  private static String p = null;
  
  private static JSONObject q = new JSONObject();
  
  private static final ExecutorService r = Executors.newSingleThreadExecutor();
  
  private static final ExecutorService s = Executors.newSingleThreadExecutor();
  
  private static HostnameVerifier t = null;
  
  private boolean h = false;
  
  public static void ZVTFJRA(Context paramContext, Listener paramListener) {
    try {
      paramContext = paramContext.getApplicationContext();
      s.execute(new f(paramContext, paramListener));
      return;
    } catch (Exception exception) {
      paramListener.handler("NA_E");
      exception.printStackTrace();
      return;
    } 
  }
  
  public static void ZVTFJRAAsyn(Context paramContext, DUListener paramDUListener) {
    try {
      paramContext = paramContext.getApplicationContext();
      s.execute(new e(paramContext, paramDUListener));
      return;
    } catch (Exception exception) {
      exception.printStackTrace();
      return;
    } 
  }
  
  private void a(Context paramContext, SensorManager paramSensorManager, Sensor paramSensor) {
    paramSensorManager.registerListener(new c(this, paramContext, paramSensorManager), paramSensor, 1);
  }
  
  private void a(Context paramContext, String paramString, int paramInt) {
    synchronized (q) {
      JSONObject jSONObject = q;
      try {
        if (!jSONObject.has(paramString))
          jSONObject.put(paramString, 0); 
        jSONObject.put(paramString, jSONObject.getInt(paramString) + 1);
      } catch (JSONException jSONException) {
        jSONException.printStackTrace();
      } 
      return;
    } 
  }
  
  private void a(Context paramContext, String paramString1, String paramString2, DUListener paramDUListener) {
    try {
      r.execute(new n(this, paramContext, paramString1, paramString2, paramDUListener));
      return;
    } catch (Exception exception) {
      exception.printStackTrace();
      return;
    } 
  }
  
  private void a(Context paramContext, String paramString1, String paramString2, Listener paramListener) {
    try {
      r.execute(new b(this, paramContext, paramString1, paramString2, paramListener));
      return;
    } catch (Exception exception) {
      exception.printStackTrace();
      return;
    } 
  }
  
  private void a(Context paramContext, String paramString1, String paramString2, String paramString3, DUListener paramDUListener) {
    r.execute(new l(this, paramContext, paramString1, paramString2, paramString3, paramDUListener));
  }
  
  private void a(Context paramContext, String paramString1, String paramString2, String paramString3, Listener paramListener) {
    r.execute(new m(this, paramContext, paramString1, paramString2, paramString3, paramListener));
  }
  
  private void a(Context paramContext, JSONObject paramJSONObject, String paramString) {
    try {
      if (paramJSONObject.isNull("url")) {
        String str = (String)c(paramContext, "url");
        if (str != null)
          paramJSONObject.put("url", str); 
      } 
      if (paramJSONObject.isNull("store")) {
        String str = paramString;
        if (paramString == null) {
          paramString = e(paramContext);
          str = paramString;
          if (paramString == null)
            str = (String)c(paramContext, "store"); 
        } 
        if (str != null)
          paramJSONObject.put("store", str); 
      } 
      if (paramJSONObject.isNull("apiKey")) {
        String str = (String)c(paramContext, "apiKey");
        if (str != null)
          paramJSONObject.put("apiKey", str); 
      } 
      return;
    } catch (Exception exception) {
      exception.printStackTrace();
      return;
    } 
  }
  
  private void a(String paramString1, String paramString2) {
    try {
      JSONObject jSONObject = o.get();
      if (jSONObject != null) {
        jSONObject.put(paramString1, paramString2);
        return;
      } 
      jSONObject = new JSONObject();
      jSONObject.put(paramString1, paramString2);
      o.set(jSONObject);
      return;
    } catch (JSONException jSONException) {
      jSONException.printStackTrace();
      return;
    } 
  }
  
  private void a(JSONObject paramJSONObject, String paramString) {
    try {
      Iterator<String> iterator = (new JSONObject(paramString)).keys();
      while (iterator.hasNext())
        paramJSONObject.remove(iterator.next()); 
    } catch (JSONException jSONException) {
      jSONException.printStackTrace();
    } 
  }
  
  private void a(JSONObject paramJSONObject, String paramString1, String paramString2) {
    paramJSONObject.put(paramString1, paramString2);
  }
  
  private static int b(Context paramContext) {
    try {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramContext.getPackageName());
      stringBuilder.append("_dna");
      SharedPreferences sharedPreferences = paramContext.getSharedPreferences(stringBuilder.toString(), 0);
      if (sharedPreferences != null) {
        String str = sharedPreferences.getString("pt", null);
        if (str != null) {
          mPort = Integer.parseInt(str);
          return 0;
        } 
        int i = (new Random()).nextInt(10000) + 20000;
        mPort = i;
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("pt", String.valueOf(i));
        editor.commit();
        return 0;
      } 
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
    return -1;
  }
  
  private String b(Context paramContext, String paramString) {
    try {
      InputStream inputStream = paramContext.getAssets().open(paramString);
      StringBuilder stringBuilder = new StringBuilder();
      BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
      while (true) {
        String str = bufferedReader.readLine();
        if (str != null) {
          stringBuilder.append(str);
          continue;
        } 
        bufferedReader.close();
        inputStream.close();
        return stringBuilder.toString();
      } 
    } catch (IOException iOException) {
      return null;
    } 
  }
  
  private String b(Context paramContext, String paramString1, String paramString2, String paramString3) {
    a(paramContext, paramString1, 0);
    String str4 = null;
    String str5 = null;
    String str3 = null;
    String str1 = str4;
    String str2 = str5;
    try {
      String str6;
      if (!d.c(paramContext)) {
        str1 = str4;
        str2 = str5;
        Log.e("[shuzilm]", "network is unavailable.");
        return null;
      } 
      str1 = str4;
      str2 = str5;
      a("type", "2");
      str1 = str4;
      str2 = str5;
      a("pEventCode", paramString1);
      str1 = str4;
      str2 = str5;
      a("apiKey", j);
      if (paramString2 != null) {
        str1 = str4;
        str2 = str5;
        a("mEventCode", paramString2);
      } 
      str1 = str4;
      str2 = str5;
      if (o.get() != null) {
        str1 = str4;
        str2 = str5;
        paramString1 = ((JSONObject)o.get()).toString();
      } else {
        paramString1 = null;
      } 
      str1 = str4;
      str2 = str5;
      String str7 = l.toString();
      str1 = str4;
      str2 = str5;
      JSONObject jSONObject = q;
      str1 = str4;
      str2 = str5;
      /* monitor enter ClassFileLocalVariableReferenceExpression{type=ObjectType{org/json/JSONObject}, name=null} */
      paramString2 = str3;
      try {
        q.put("custom", paramString3);
        paramString2 = str3;
        paramString3 = q.toString();
        paramString2 = str3;
        str6 = onEvent(paramContext, paramString1, str7, paramString3);
      } finally {
        paramString1 = null;
      } 
      paramString2 = str6;
      /* monitor exit ClassFileLocalVariableReferenceExpression{type=ObjectType{org/json/JSONObject}, name=null} */
      str1 = str6;
      str2 = str6;
      throw paramString1;
    } catch (Exception exception) {
      exception.printStackTrace();
      return str2;
    } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
      unsatisfiedLinkError.printStackTrace();
      return str1;
    } 
  }
  
  private void b(JSONObject paramJSONObject, String paramString) {
    a(paramJSONObject, "custom", paramString);
  }
  
  private Object c(Context paramContext, String paramString) {
    try {
      JSONObject jSONObject2 = n;
      JSONObject jSONObject1 = jSONObject2;
      if (jSONObject2 == null) {
        jSONObject1 = d(paramContext);
        n = jSONObject1;
      } 
      return jSONObject1.opt(paramString);
    } catch (Exception exception) {
      return null;
    } 
  }
  
  private String c(Context paramContext, String paramString1, String paramString2) {
    try {
      if (!d.c(paramContext)) {
        Log.e("[shuzilm]", "network is unavailable.");
        return null;
      } 
      setConfig("apiKey", j);
      a(paramContext, m, paramString1);
      b(l, paramString2);
      return query(paramContext, m.toString(), l.toString());
    } catch (Exception exception) {
      exception.printStackTrace();
      return null;
    } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
      unsatisfiedLinkError.printStackTrace();
      return null;
    } 
  }
  
  private boolean c(Context paramContext) {
    try {
      ConnectivityManager connectivityManager = (ConnectivityManager)paramContext.getSystemService("connectivity");
      if (connectivityManager != null) {
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()) {
          NetworkInfo.State state1 = networkInfo.getState();
          NetworkInfo.State state2 = NetworkInfo.State.CONNECTED;
          if (state1 == state2)
            return true; 
        } 
      } 
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
    return false;
  }
  
  private String d(Context paramContext, String paramString) {
    try {
      Object object = (paramContext.getPackageManager().getApplicationInfo(paramContext.getPackageName(), 128)).metaData.get(paramString);
      if (object != null)
        return object.toString(); 
    } catch (Exception exception) {}
    return null;
  }
  
  private JSONObject d(Context paramContext) {
    String str = b(paramContext, "cn.shuzilm.config.json");
    return (str != null) ? new JSONObject(str) : null;
  }
  
  private String e(Context paramContext) {
    try {
      Object object = d.c(paramContext, "store");
      if (object instanceof String)
        return null; 
      object = (new JSONObject(object.toString())).getJSONObject("metadata");
      return d.d(paramContext, object.getString("name"));
    } catch (Exception exception) {
      return null;
    } 
  }
  
  private String f(Context paramContext) {
    String str;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramContext.getPackageName());
    stringBuilder.append("_dna");
    SharedPreferences sharedPreferences = paramContext.getSharedPreferences(stringBuilder.toString(), 0);
    paramContext = null;
    if (sharedPreferences != null)
      str = sharedPreferences.getString("device_id", null); 
    return str;
  }
  
  private static void g() {
    if (!i)
      try {
        s.execute(new h());
        return;
      } finally {
        Exception exception = null;
      }  
  }
  
  private void g(Context paramContext) {
    SensorManager sensorManager = (SensorManager)paramContext.getSystemService("sensor");
    Sensor sensor = sensorManager.getDefaultSensor(9);
    if (sensor != null)
      a(paramContext, sensorManager, sensor); 
    sensor = sensorManager.getDefaultSensor(3);
    if (sensor != null)
      a(paramContext, sensorManager, sensor); 
    sensor = sensorManager.getDefaultSensor(11);
    if (sensor != null)
      a(paramContext, sensorManager, sensor); 
    sensor = sensorManager.getDefaultSensor(19);
    if (sensor != null)
      a(paramContext, sensorManager, sensor); 
    sensor = sensorManager.getDefaultSensor(6);
    if (sensor != null)
      a(paramContext, sensorManager, sensor); 
    sensor = sensorManager.getDefaultSensor(1);
    if (sensor != null)
      a(paramContext, sensorManager, sensor); 
    sensor = sensorManager.getDefaultSensor(4);
    if (sensor != null)
      a(paramContext, sensorManager, sensor); 
    sensor = sensorManager.getDefaultSensor(5);
    if (sensor != null)
      a(paramContext, sensorManager, sensor); 
    sensor = sensorManager.getDefaultSensor(2);
    if (sensor != null)
      a(paramContext, sensorManager, sensor); 
  }
  
  public static String getQueryID(Context paramContext, String paramString1, String paramString2) {
    try {
      return (String)getQueryID(paramContext, paramString1, paramString2, 0, null).get("device_id");
    } catch (NullPointerException nullPointerException) {
      return "";
    } 
  }
  
  public static Map getQueryID(Context paramContext, String paramString1, String paramString2, int paramInt, Listener paramListener) {
    try {
      HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
      String str2 = "0";
      Context context = paramContext.getApplicationContext();
      if (paramInt == 1) {
        d.a(context, paramString1, paramString2, paramListener);
        return null;
      } 
      boolean bool = e.tryLock();
      if (!bool) {
        String str = d.f(context);
        if (str == null)
          d.a(context, paramString1, paramString2, paramListener); 
        hashMap.put("device_id", str);
        hashMap.put("valid", "0");
        return hashMap;
      } 
      paramString2 = d.c(context, paramString1, paramString2);
      paramString1 = str2;
      if (paramString2 != null) {
        p = paramString2;
        paramString1 = "1";
      } 
      String str1 = paramString2;
      if (paramString2 == null)
        if (p != null) {
          str1 = p;
        } else {
          str1 = d.f(context);
        }  
      hashMap.put("device_id", str1);
      hashMap.put("valid", paramString1);
      e.unlock();
      return hashMap;
    } catch (Exception exception) {
      exception.printStackTrace();
      return null;
    } 
  }
  
  public static Map getQueryIDDUCallback(Context paramContext, String paramString1, String paramString2, int paramInt, DUListener paramDUListener) {
    try {
      HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
      String str2 = "0";
      Context context = paramContext.getApplicationContext();
      if (paramInt == 1) {
        d.a(context, paramString1, paramString2, paramDUListener);
        return null;
      } 
      boolean bool = e.tryLock();
      if (!bool) {
        String str = d.f(context);
        if (str == null)
          d.a(context, paramString1, paramString2, paramDUListener); 
        hashMap.put("device_id", str);
        hashMap.put("valid", "0");
        return hashMap;
      } 
      paramString2 = d.c(context, paramString1, paramString2);
      paramString1 = str2;
      if (paramString2 != null) {
        p = paramString2;
        paramString1 = "1";
      } 
      String str1 = paramString2;
      if (paramString2 == null)
        if (p != null) {
          str1 = p;
        } else {
          str1 = d.f(context);
        }  
      hashMap.put("device_id", str1);
      hashMap.put("valid", paramString1);
      e.unlock();
      return hashMap;
    } catch (Exception exception) {
      exception.printStackTrace();
      return null;
    } 
  }
  
  public static String getQuickQueryID(Context paramContext) {
    try {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramContext.getPackageName());
      stringBuilder.append("_dna");
      SharedPreferences sharedPreferences = paramContext.getSharedPreferences(stringBuilder.toString(), 0);
      if (sharedPreferences != null)
        return sharedPreferences.getString("device_id", null); 
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
    return null;
  }
  
  public static void go(Context paramContext, String paramString1, String paramString2) {
    try {
      paramContext = paramContext.getApplicationContext();
      if (!d.c(paramContext)) {
        Log.e("[shuzilm]", "network is unavailable.");
        return;
      } 
      boolean bool = e.tryLock();
      if (!bool)
        return; 
      try {
        r.execute(new i(paramContext, paramString1, paramString2));
      } catch (Exception exception) {}
      e.unlock();
      return;
    } catch (Exception exception) {
      exception.printStackTrace();
      return;
    } 
  }
  
  private static int h(Context paramContext) {
    SharedPreferences.Editor editor;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramContext.getPackageName());
    stringBuilder.append("_dna");
    SharedPreferences sharedPreferences = paramContext.getSharedPreferences(stringBuilder.toString(), 0);
    if (sharedPreferences != null) {
      if (sharedPreferences.getString("pt", null) != null) {
        int i = (new Random()).nextInt(10000) + 20000;
        mPort = i;
        editor = sharedPreferences.edit();
        editor.putString("pt", String.valueOf(i));
        editor.commit();
        return 0;
      } 
    } else {
      b((Context)editor);
    } 
    return 0;
  }
  
  public static void init(Context paramContext, String paramString) {
    try {
      mContext = paramContext.getApplicationContext();
      FileOutputStream fileOutputStream = paramContext.openFileOutput("du.lock", 0);
      FileLock fileLock = fileOutputStream.getChannel().tryLock();
      if (!fileLock.isValid()) {
        fileOutputStream.close();
        return;
      } 
      g();
      b(mContext);
      j = paramString;
      r.execute(new g(paramContext));
      fileLock.release();
      fileOutputStream.close();
      return;
    } catch (Exception exception) {
      exception.printStackTrace();
      return;
    } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
      unsatisfiedLinkError.printStackTrace();
      return;
    } 
  }
  
  public static void loadLibrary() {
    r.execute(new a());
  }
  
  private static native String onEvent(Context paramContext, String paramString1, String paramString2, String paramString3);
  
  public static Map onEvent(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt, Listener paramListener) {
    try {
      HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
      if (paramString1 == null)
        return null; 
      paramContext = paramContext.getApplicationContext();
      if (paramInt == 1) {
        d.a(paramContext, paramString1, paramString2, paramString3, paramListener);
        return null;
      } 
      if (!e.tryLock()) {
        d.a(paramContext, paramString1, paramString2, paramString3, paramListener);
        return null;
      } 
      hashMap.put("SessionID", d.b(paramContext, paramString1, paramString2, paramString3));
      hashMap.put("QueryID", p);
      e.unlock();
      return hashMap;
    } catch (Exception exception) {
      exception.printStackTrace();
      return null;
    } 
  }
  
  public static Map onEventDUCallback(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt, DUListener paramDUListener) {
    try {
      HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
      if (paramString1 == null)
        return null; 
      paramContext = paramContext.getApplicationContext();
      if (paramInt == 1) {
        d.a(paramContext, paramString1, paramString2, paramString3, paramDUListener);
        return null;
      } 
      if (!e.tryLock()) {
        d.a(paramContext, paramString1, paramString2, paramString3, paramDUListener);
        return null;
      } 
      hashMap.put("SessionID", d.b(paramContext, paramString1, paramString2, paramString3));
      hashMap.put("QueryID", p);
      e.unlock();
      return hashMap;
    } catch (Exception exception) {
      exception.printStackTrace();
      return null;
    } 
  }
  
  private static native String onIEvent(Context paramContext, String paramString1, String paramString2, String paramString3);
  
  public static void onIEvent(Context paramContext, String paramString) {
    Context context = paramContext.getApplicationContext();
    try {
      r.execute(new d(paramContext, paramString, context));
      return;
    } catch (Exception exception) {
      return;
    } 
  }
  
  private static native void onSSChanged(Context paramContext, SignalStrength paramSignalStrength);
  
  private static native void onSensorChanged(Context paramContext, SensorEvent paramSensorEvent);
  
  private static native String query(Context paramContext, String paramString1, String paramString2);
  
  public static int rOnEvent(Context paramContext, String paramString) {
    try {
      setData("pkg", paramString);
      onEvent(paramContext, "du_wk_f", null, null, 1, null);
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
    return 0;
  }
  
  public static void report(Context paramContext, String paramString1, String paramString2) {
    try {
      paramContext = paramContext.getApplicationContext();
      if (!d.c(paramContext)) {
        Log.e("[shuzilm]", "network is unavailable.");
        return;
      } 
      boolean bool = e.tryLock();
      if (!bool)
        return; 
      try {
        r.execute(new j(paramContext, paramString1, paramString2));
      } catch (Exception exception) {}
      e.unlock();
      return;
    } catch (Exception exception) {
      exception.printStackTrace();
      return;
    } 
  }
  
  private static native String reportRun(Context paramContext, String paramString1, String paramString2);
  
  private static native String run(Context paramContext, String paramString1, String paramString2);
  
  public static int setConfig(String paramString1, String paramString2) {
    d.a(m, paramString1, paramString2);
    return 0;
  }
  
  public static int setData(String paramString1, String paramString2) {
    d.a(l, paramString1, paramString2);
    return 0;
  }
  
  public static String startService(Context paramContext, ServiceConnection paramServiceConnection, String paramString, int paramInt) {
    try {
      Context context = paramContext.getApplicationContext();
      String str = context.getPackageName();
      Intent intent = new Intent();
      intent.setComponent(new ComponentName(str, DUService.class.getName()));
      intent.putExtra("apikey", paramString);
      context.bindService(intent, paramServiceConnection, 1);
      if (paramInt == 1)
        return getQuickQueryID(paramContext); 
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
    return null;
  }
  
  public static int unResListener() {
    try {
      ((TelephonyManager)mContext.getSystemService("phone")).listen(d, 0);
      return 0;
    } catch (Exception exception) {
      return -1;
    } 
  }
  
  public static HostnameVerifier v() {
    if (t == null)
      t = new k(); 
    return t;
  }
  
  private static native String zZVTFJRA(Context paramContext, String paramString);
  
  public void onSignalStrengthsChanged(SignalStrength paramSignalStrength) {
    super.onSignalStrengthsChanged(paramSignalStrength);
    try {
      onSSChanged(mContext, paramSignalStrength);
      return;
    } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
      unsatisfiedLinkError.printStackTrace();
      return;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\cn\shuzilm\core\DUHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */