package com.qq.e.comm.plugin.u;

import android.text.TextUtils;
import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.managers.status.NetworkType;
import com.qq.e.comm.plugin.aa.a.a;
import com.qq.e.comm.plugin.ad.c;
import com.qq.e.comm.plugin.ad.d;
import com.qq.e.comm.plugin.ad.e;
import com.qq.e.comm.plugin.ad.m;
import com.qq.e.comm.plugin.ad.q;
import com.qq.e.comm.plugin.k.a;
import com.qq.e.comm.plugin.s.f;
import com.qq.e.comm.plugin.s.h;
import com.qq.e.comm.plugin.util.aj;
import com.qq.e.comm.plugin.w.e;
import com.qq.e.comm.plugin.y.c;
import com.qq.e.comm.plugin.y.u;
import com.qq.e.comm.util.GDTLogger;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class b {
  private static final b a = new b();
  
  private final Object b = new Object();
  
  public static b a() {
    return a;
  }
  
  private File a(String paramString) {
    return aj.b(paramString);
  }
  
  public static List<f> a(List<f> paramList) {
    ArrayList<f> arrayList = new ArrayList();
    if (paramList != null && paramList.size() > 0) {
      Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT+8"));
      String str = (new SimpleDateFormat("yyyy-MM-dd", Locale.US)).format(calendar.getTime());
      for (f f : paramList) {
        ArrayList<h> arrayList1 = new ArrayList();
        List list = f.j();
        boolean bool3 = false;
        boolean bool1 = false;
        boolean bool2 = bool3;
        if (list != null) {
          bool2 = bool3;
          if (list.size() > 0) {
            Iterator<h> iterator = list.iterator();
            while (true) {
              bool2 = bool1;
              if (iterator.hasNext()) {
                h h = iterator.next();
                if (str.equals(h.a())) {
                  arrayList1.add(h);
                  bool1 = true;
                } 
                continue;
              } 
              break;
            } 
          } 
        } 
        if (bool2) {
          f.e(arrayList1);
          arrayList.add(f);
        } 
      } 
    } 
    return arrayList;
  }
  
  private void a(String paramString1, String paramString2, boolean paramBoolean, q paramq) {
    if (!TextUtils.isEmpty(paramString1) && !TextUtils.isEmpty(paramString2)) {
      if (paramBoolean && (GDTADManager.getInstance().getSM().getInteger("preloadResNetwork", NetworkType.WIFI.getPermValue()) & GDTADManager.getInstance().getDeviceStatus().getNetworkType().getPermValue()) <= 0) {
        paramString1 = "当前设备的网络类型不符合预加载广告资源的条件，请尝试WIFI环境。如仍有问题请联系客服";
      } else {
        File file = a(paramString1, paramString2);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("准备缓存 url ");
        stringBuilder.append(paramString2);
        GDTLogger.i(stringBuilder.toString());
        stringBuilder = new StringBuilder();
        stringBuilder.append("准备缓存 fileName ");
        stringBuilder.append(file.getAbsolutePath());
        GDTLogger.i(stringBuilder.toString());
        if (file.exists()) {
          paramString1 = "闪屏资源已经缓存在";
        } else {
          com.qq.e.comm.plugin.aa.a.b b1 = (new com.qq.e.comm.plugin.aa.a.b.a()).b(paramString2).a(a(paramString1)).a(b(paramString2)).a();
          a.a().a(b1, paramString2, new a(b1, paramString1));
          return;
        } 
      } 
      GDTLogger.i(paramString1);
      return;
    } 
  }
  
  private void a(JSONObject paramJSONObject, e parame, String paramString1, String paramString2, m paramm, String paramString3) {
    a(paramJSONObject, parame, paramString1, paramString2, paramm, paramString3, (f)null);
  }
  
  private void a(JSONObject paramJSONObject, e parame, String paramString1, String paramString2, m paramm, String paramString3, f paramf) {
    c c = (new c()).a(paramString2);
    int i = paramJSONObject.optInt("ret");
    if (i != 0) {
      u.a(100062, i, c);
      return;
    } 
    JSONObject jSONObject = paramJSONObject.optJSONObject("data");
    if (jSONObject == null) {
      i = 100072;
    } else {
      jSONObject = jSONObject.optJSONObject(paramString2);
      if (jSONObject == null) {
        i = 100082;
      } else {
        int j = jSONObject.optInt("ret");
        if (j != 0) {
          i = 100092;
        } else {
          JSONArray jSONArray = jSONObject.optJSONArray("list");
          if (jSONArray == null || jSONArray.length() <= 0) {
            i = 100102;
          } else {
            synchronized (this.b) {
              aj.b();
              aj.a(aj.c(paramString2), jSONArray.toString());
              for (i = 0; i < jSONArray.length(); i++) {
                null = jSONArray.optJSONObject(i);
                f f1 = new f(paramString1, paramString2, paramString3, parame);
                f1.g((JSONObject)null);
                if (!TextUtils.isEmpty(f1.al()) && !TextUtils.isEmpty(f1.ak()) && !paramString2.equals(f1.al()))
                  a(paramJSONObject, parame, paramString1, f1.al(), paramm, paramString3, f1); 
                j = f1.F();
                if (j != 0) {
                  if (j == 1) {
                    a(paramString2, f1.o(), false, q.a);
                    a(paramString2, f1.G(), true, q.b);
                  } 
                } else {
                  a(paramString2, f1.o(), false, q.a);
                } 
                if (paramf != null && paramf.am() == null && f1.B().equals(paramf.al()) && f1.f().equals(paramf.ak())) {
                  paramf.a(f1);
                  return;
                } 
              } 
            } 
            return;
          } 
        } 
        u.a(i, j, c);
        return;
      } 
    } 
    u.a(i, 0, c);
  }
  
  private String b(String paramString) {
    return aj.a(paramString);
  }
  
  public File a(String paramString1, String paramString2) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(a(paramString1).getAbsolutePath());
    stringBuilder.append(File.separator);
    stringBuilder.append(b(paramString2));
    return new File(stringBuilder.toString());
  }
  
  public List<f> a(String paramString1, String paramString2, String paramString3, e parame) {
    return a(paramString1, paramString2, paramString3, parame, null);
  }
  
  public List<f> a(String paramString1, String paramString2, String paramString3, e parame, f paramf) {
    ArrayList<f> arrayList = new ArrayList();
    if (!TextUtils.isEmpty(paramString2))
      synchronized (this.b) {
        String str = aj.c(aj.c(paramString2));
        if (!TextUtils.isEmpty(str)) {
          try {
            null = new JSONArray(str);
          } catch (JSONException null) {
            null = null;
          } 
          if (null != null && null.length() > 0) {
            int i;
            for (i = 0; i < null.length(); i++) {
              JSONObject jSONObject = null.optJSONObject(i);
              f f1 = new f(paramString1, paramString2, paramString3, parame);
              f1.g(jSONObject);
              arrayList.add(f1);
              if (!TextUtils.isEmpty(f1.al()) && !TextUtils.isEmpty(f1.ak()) && !paramString2.equals(f1.al()))
                a(paramString1, f1.al(), paramString3, parame, f1); 
              if (paramf != null && paramf.am() == null && f1.B().equals(paramf.al()) && f1.f().equals(paramf.ak())) {
                paramf.a(f1);
                return arrayList;
              } 
            } 
          } 
        } 
      }  
    return arrayList;
  }
  
  public void a(e parame, String paramString1, String paramString2, m paramm, String paramString3, LoadAdParams paramLoadAdParams, int paramInt) {
    int i = GDTADManager.getInstance().getSM().getInteger("preloadNetwork", -1);
    NetworkType networkType = GDTADManager.getInstance().getDeviceStatus().getNetworkType();
    if ((i & networkType.getPermValue()) <= 0) {
      u.a(100052, networkType.getPermValue(), (new c()).a(paramString2));
      GDTLogger.i("当前设备的网络类型不符合预加载广告的条件，请尝试WIFI环境。如仍有问题请联系客服");
      return;
    } 
    com.qq.e.comm.plugin.w.b b1 = new com.qq.e.comm.plugin.w.b(paramString3, parame, paramString2);
    com.qq.e.comm.plugin.ad.b b2 = new com.qq.e.comm.plugin.ad.b();
    b2.a(true);
    b2.a(paramString2);
    b2.c(1);
    b2.d(GDTADManager.getInstance().getSM().getInteger("splashPreloadAdCount", 5));
    b2.e(2);
    b2.h(parame.b());
    d d = c.a(parame, GDTADManager.getInstance().getDeviceStatus().getDeviceDensity());
    b2.f(d.a());
    b2.g(d.b());
    b2.n(paramInt);
    b2.q(1);
    if (paramLoadAdParams != null) {
      b2.f(paramLoadAdParams.getUin());
      b2.e(paramLoadAdParams.getLoginOpenid());
      b2.g(paramLoadAdParams.getLoginAppId());
      b2.m(paramLoadAdParams.getBlockEffectValue());
    } 
    e.a(b2, b1, new e.a(this, parame, paramString1, paramString2, paramm, paramString3) {
          public void a(a param1a) {
            GDTLogger.e("预加载失败！", (Throwable)param1a);
            u.a(100042, 0, (new c()).a(this.c));
          }
          
          public void a(JSONObject param1JSONObject) {
            b.a(this.f, param1JSONObject, this.a, this.b, this.c, this.d, this.e);
          }
        });
  }
  
  public List<f> b(String paramString1, String paramString2, String paramString3, e parame) {
    return a(a(paramString1, paramString2, paramString3, parame));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugi\\u\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */