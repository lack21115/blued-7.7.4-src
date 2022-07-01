package com.baidu.mobads.command;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Process;
import com.baidu.mobads.interfaces.utils.IXAdLogger;
import com.baidu.mobads.openad.interfaces.download.IOAdDownloader;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public class a implements Serializable {
  private long A;
  
  private boolean B;
  
  public String a;
  
  public String b;
  
  public String c;
  
  public long d = -1L;
  
  public int e = 0;
  
  public int f;
  
  public IOAdDownloader.DownloadStatus g = IOAdDownloader.DownloadStatus.NONE;
  
  public Object h = null;
  
  public String i;
  
  public String j;
  
  public String k;
  
  public boolean l;
  
  public boolean m = true;
  
  public String n;
  
  public String o;
  
  public String p;
  
  public String q;
  
  public int r = 0;
  
  public boolean s = false;
  
  public long t;
  
  protected long u;
  
  protected long v;
  
  public boolean w = false;
  
  public String x = null;
  
  protected final IXAdLogger y = XAdSDKFoundationFacade.getInstance().getAdLogger();
  
  private long z;
  
  public a(String paramString1, String paramString2) {
    this.i = paramString1;
    this.a = paramString2;
  }
  
  public static a a(Context paramContext, String paramString) {
    IOAdDownloader.DownloadStatus[] arrayOfDownloadStatus1;
    StringBuilder stringBuilder2 = null;
    IOAdDownloader.DownloadStatus[] arrayOfDownloadStatus2 = null;
    StringBuilder stringBuilder1 = stringBuilder2;
    if (paramString != null) {
      stringBuilder1 = stringBuilder2;
      if (!"".equals(paramString)) {
        IOAdDownloader.DownloadStatus[] arrayOfDownloadStatus;
        int i = 0;
        try {
          SharedPreferences sharedPreferences = paramContext.getSharedPreferences("__sdk_remote_dl_2", 0);
          stringBuilder1 = new StringBuilder();
          stringBuilder1.append(paramString);
          stringBuilder1.append("#$#");
          stringBuilder1.append(b());
          String str = sharedPreferences.getString(stringBuilder1.toString(), null);
          stringBuilder1 = stringBuilder2;
          if (str != null) {
            JSONObject jSONObject = new JSONObject(str);
            String str1 = jSONObject.getString("title");
            str = jSONObject.optString("url", jSONObject.getString("turl"));
            a a2 = new a(paramString, str1);
            try {
              a2.a(jSONObject.optString("qk"), jSONObject.optString("adid"), str, jSONObject.optBoolean("autoOpen"));
              a2.m = jSONObject.optBoolean("popNotify");
              a2.a(jSONObject.getString("filename"), jSONObject.getString("folder"));
              a2.b(jSONObject.optString("placeId"), jSONObject.optString("prod"));
              int j = jSONObject.getInt("dl");
              arrayOfDownloadStatus2 = IOAdDownloader.DownloadStatus.values();
              IOAdDownloader.DownloadStatus downloadStatus = IOAdDownloader.DownloadStatus.NONE;
              while (true) {
                if (i < arrayOfDownloadStatus2.length) {
                  if (arrayOfDownloadStatus2[i].getCode() == j)
                    downloadStatus = arrayOfDownloadStatus2[i]; 
                } else {
                  a2.g = downloadStatus;
                  a2.s = jSONObject.optBoolean("mnCfm");
                  a2.r = jSONObject.getInt("dlCnt");
                  a2.t = jSONObject.optLong("cts");
                  a2.u = jSONObject.optLong("ts");
                  a2.v = jSONObject.optInt("clickProcId");
                  return a2;
                } 
                i++;
              } 
            } catch (Exception exception1) {
              a a3 = a2;
              exception = exception1;
            } 
          } else {
            return (a)exception1;
          } 
        } catch (Exception exception) {
          arrayOfDownloadStatus = arrayOfDownloadStatus2;
        } 
        XAdSDKFoundationFacade.getInstance().getAdLogger().d(exception);
        com.baidu.mobads.b.a a1 = com.baidu.mobads.b.a.a();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("get stored download info failed: ");
        stringBuilder.append(exception.toString());
        a1.a(stringBuilder.toString());
        arrayOfDownloadStatus1 = arrayOfDownloadStatus;
      } 
    } 
    return (a)arrayOfDownloadStatus1;
  }
  
  public static List<String> a(Context paramContext, long paramLong) {
    ArrayList<String> arrayList = new ArrayList();
    try {
      for (Map.Entry entry : paramContext.getSharedPreferences("__sdk_remote_dl_2", 0).getAll().entrySet()) {
        try {
          String str2 = b();
          String str1 = (String)entry.getKey();
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("#$#");
          stringBuilder.append(str2);
          if (!str1.contains(stringBuilder.toString()))
            continue; 
          JSONObject jSONObject = new JSONObject((String)entry.getValue());
          if (jSONObject.getLong("cts") < paramLong)
            continue; 
          int i = jSONObject.getInt("dl");
          if (i == 0 || i == 1 || i == 4)
            arrayList.add(str1.substring(0, str1.indexOf("#$#"))); 
        } catch (Exception exception) {
          XAdSDKFoundationFacade.getInstance().getAdLogger().d("XAdDownloaderManager", exception.getMessage());
        } 
      } 
    } catch (Exception exception) {
      XAdSDKFoundationFacade.getInstance().getAdLogger().d(exception);
    } 
    return arrayList;
  }
  
  public static String b() {
    return XAdSDKFoundationFacade.getInstance().getSystemUtils().getCurrentProcessName(XAdSDKFoundationFacade.getInstance().getApplicationContext());
  }
  
  public JSONObject a() {
    JSONObject jSONObject = new JSONObject();
    try {
      jSONObject.put("dl", this.g.getCode());
      jSONObject.put("filename", this.b);
      jSONObject.put("folder", this.c);
      jSONObject.put("title", this.a);
      jSONObject.put("contentLength", this.d);
      jSONObject.put("pk", this.i);
      jSONObject.put("qk", this.n);
      jSONObject.put("autoOpen", this.l);
      jSONObject.put("popNotify", this.m);
      jSONObject.put("adid", this.o);
      jSONObject.put("placeId", this.p);
      jSONObject.put("prod", this.q);
      jSONObject.put("dlTunnel", 4);
      if (this.k != null && this.k.length() > 0) {
        jSONObject.put("turl", this.k);
      } else {
        jSONObject.put("url", this.j);
      } 
      jSONObject.put("mnCfm", this.s);
      jSONObject.put("dlCnt", this.r);
      jSONObject.put("cts", this.t);
      if (this.r == 1) {
        this.u = System.currentTimeMillis();
        this.v = Process.myPid();
      } 
      jSONObject.put("ts", this.u);
      jSONObject.put("clickProcId", this.v);
      return jSONObject;
    } catch (Exception exception) {
      this.y.d(exception);
      return jSONObject;
    } 
  }
  
  public void a(long paramLong) {
    this.z = paramLong;
  }
  
  public void a(Context paramContext) {
    String str = this.i;
    if (str != null && !"".equals(str))
      try {
        SharedPreferences.Editor editor = paramContext.getSharedPreferences("__sdk_remote_dl_2", 0).edit();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.i);
        stringBuilder.append("#$#");
        stringBuilder.append(b());
        editor.putString(stringBuilder.toString(), a().toString());
        if (Build.VERSION.SDK_INT >= 9) {
          editor.apply();
          return;
        } 
        editor.commit();
        return;
      } catch (Exception exception) {
        XAdSDKFoundationFacade.getInstance().getAdLogger().d("XAdAPKDownloadExtraInfo", exception);
      }  
  }
  
  public void a(String paramString1, String paramString2) {
    this.b = paramString1;
    this.c = paramString2;
  }
  
  public void a(String paramString1, String paramString2, String paramString3, boolean paramBoolean) {
    this.n = paramString1;
    this.o = paramString2;
    this.j = paramString3;
    this.l = paramBoolean;
  }
  
  public void a(boolean paramBoolean) {
    this.B = paramBoolean;
  }
  
  public void b(long paramLong) {
    this.A = paramLong;
  }
  
  public void b(String paramString1, String paramString2) {
    this.p = paramString1;
    this.q = paramString2;
  }
  
  public long c() {
    return this.z;
  }
  
  public String d() {
    return this.i;
  }
  
  public long e() {
    return this.A;
  }
  
  public boolean f() {
    return this.B;
  }
  
  public String g() {
    return this.o;
  }
  
  public String h() {
    return this.n;
  }
  
  public String i() {
    return this.q;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\mobads\command\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */