package com.huawei.hms.framework.network.grs.c;

import android.content.Context;
import android.os.SystemClock;
import com.huawei.hms.framework.common.IoUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.huawei.hms.framework.network.grs.b.b;
import com.huawei.hms.framework.network.grs.d.a.a;
import com.huawei.hms.framework.network.grs.local.model.a;
import com.huawei.hms.framework.network.grs.local.model.c;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import javax.net.ssl.HttpsURLConnection;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class i extends b implements Callable<e> {
  private static final String h = "i";
  
  private GrsBaseInfo i;
  
  public i(String paramString1, int paramInt, a parama, Context paramContext, String paramString2, GrsBaseInfo paramGrsBaseInfo) {
    super(paramString1, paramInt, parama, paramContext, paramString2, paramGrsBaseInfo);
    this.i = paramGrsBaseInfo;
  }
  
  private String h() {
    HashSet<String> hashSet = new HashSet();
    a a = b.a(b().getPackageName(), this.i).a();
    if (a == null) {
      Logger.w(h, "get local assets appGrs is null.");
      return "";
    } 
    Map map = a.b();
    if (map != null) {
      if (map.isEmpty())
        return ""; 
      Iterator<Map.Entry> iterator1 = map.entrySet().iterator();
      while (iterator1.hasNext())
        hashSet.add(((c)((Map.Entry)iterator1.next()).getValue()).b()); 
      if (hashSet.isEmpty())
        return ""; 
      JSONObject jSONObject = new JSONObject();
      JSONArray jSONArray = new JSONArray();
      Iterator<String> iterator = hashSet.iterator();
      while (iterator.hasNext())
        jSONArray.put(iterator.next()); 
      try {
        jSONObject.put("services", jSONArray);
        Logger.v(h, "post service list is:%s,and appName is:%s", new Object[] { jSONObject.toString(), a.a() });
        return jSONObject.toString();
      } catch (JSONException jSONException) {
        return "";
      } 
    } 
    return "";
  }
  
  public e call() {
    Logger.i(h, "Post call execute");
    long l1 = 0L;
    try {
      long l = SystemClock.elapsedRealtime();
      try {
        byte[] arrayOfByte;
        l2 = System.currentTimeMillis();
        l1 = l2;
        HttpsURLConnection httpsURLConnection = a.a(c(), b(), e());
        String str1 = null;
        String str2 = null;
        if (httpsURLConnection == null) {
          l1 = l2;
          str1 = h;
          l1 = l2;
          Logger.w(str1, "create HttpsURLConnection instance by url return null.");
          return null;
        } 
        l1 = l2;
        httpsURLConnection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
        l1 = l2;
        httpsURLConnection.setRequestMethod("POST");
        l1 = l2;
        httpsURLConnection.setDoOutput(true);
        l1 = l2;
        httpsURLConnection.setDoInput(true);
        l1 = l2;
        httpsURLConnection.connect();
        l1 = l2;
        OutputStream outputStream = httpsURLConnection.getOutputStream();
        l1 = l2;
        String str3 = h();
        l1 = l2;
        outputStream.write(str3.getBytes("UTF-8"));
        l1 = l2;
        outputStream.close();
        l1 = l2;
        int j = httpsURLConnection.getResponseCode();
        if (j == 200) {
          str1 = str2;
          try {
            InputStream inputStream2 = httpsURLConnection.getInputStream();
            InputStream inputStream1 = inputStream2;
            byte[] arrayOfByte1 = IoUtils.toByteArray(inputStream2);
          } finally {
            l1 = l2;
            IoUtils.closeSecure((InputStream)arrayOfByte);
            l1 = l2;
          } 
        } 
        l1 = l2;
        Map<String, List<String>> map = httpsURLConnection.getHeaderFields();
        l1 = l2;
        httpsURLConnection.disconnect();
        l1 = l2;
        long l6 = SystemClock.elapsedRealtime();
        l1 = l2;
        long l5 = System.currentTimeMillis();
        if (arrayOfByte == null) {
          l1 = l2;
          arrayOfByte = new byte[0];
        } 
        l1 = l2;
        this.a = new e(j, map, arrayOfByte, l6 - l);
        l1 = l2;
        l2 = l5;
      } catch (IOException null) {
        l2 = l;
      } 
    } catch (IOException iOException) {
      l2 = 0L;
    } 
    long l4 = SystemClock.elapsedRealtime();
    long l3 = System.currentTimeMillis();
    Logger.w(h, "RequestCallableV2 run task catch IOException", iOException);
    this.a = new e(iOException, l4 - l2);
    long l2 = l3;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\framework\network\grs\c\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */