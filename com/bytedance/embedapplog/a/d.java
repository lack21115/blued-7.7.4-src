package com.bytedance.embedapplog.a;

import android.content.Context;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.embedapplog.AppLog;
import com.bytedance.embedapplog.b.h;
import com.bytedance.embedapplog.b.i;
import com.bytedance.embedapplog.c.a;
import com.bytedance.embedapplog.c.b;
import com.bytedance.embedapplog.util.e;
import com.bytedance.embedapplog.util.f;
import com.bytedance.embedapplog.util.i;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONObject;

class d extends c {
  private static final Pattern e = Pattern.compile("[^+0-9]");
  
  private final h b;
  
  private final i c;
  
  private int d = 1;
  
  d(Context paramContext, i parami, h paramh) {
    super(paramContext);
    this.c = parami;
    this.b = paramh;
  }
  
  private static String a(TelephonyManager paramTelephonyManager) {
    String str = e.d(paramTelephonyManager);
    if (TextUtils.isEmpty(str))
      return ""; 
    ArrayList<Pair> arrayList = new ArrayList();
    arrayList.add(Pair.create(Pattern.compile("^(\\+86)?(1\\d{10})$"), "$2"));
    return !TextUtils.isEmpty(a(str, (List)arrayList)) ? f.a(str) : "";
  }
  
  private static String a(String paramString) {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   4: ifne -> 31
    //   7: aload_0
    //   8: ldc 'UTF-8'
    //   10: invokevirtual getBytes : (Ljava/lang/String;)[B
    //   13: astore_0
    //   14: aload_0
    //   15: arraylength
    //   16: istore_2
    //   17: iconst_0
    //   18: istore_1
    //   19: goto -> 37
    //   22: aload_0
    //   23: bipush #10
    //   25: invokestatic encodeToString : ([BI)Ljava/lang/String;
    //   28: astore_0
    //   29: aload_0
    //   30: areturn
    //   31: aconst_null
    //   32: areturn
    //   33: astore_0
    //   34: goto -> 31
    //   37: iload_1
    //   38: iload_2
    //   39: if_icmpge -> 22
    //   42: aload_0
    //   43: iload_1
    //   44: aload_0
    //   45: iload_1
    //   46: baload
    //   47: bipush #-99
    //   49: ixor
    //   50: i2b
    //   51: bastore
    //   52: iload_1
    //   53: iconst_1
    //   54: iadd
    //   55: istore_1
    //   56: goto -> 37
    // Exception table:
    //   from	to	target	type
    //   7	17	33	java/lang/Exception
    //   22	29	33	java/lang/Exception
  }
  
  private static String a(String paramString, List<Pair<Pattern, String>> paramList) {
    if (paramList != null && paramList.size() != 0) {
      if (TextUtils.isEmpty(paramString))
        return null; 
      paramString = e.matcher(paramString).replaceAll("");
      for (Pair<Pattern, String> pair : paramList) {
        Matcher matcher = ((Pattern)pair.first).matcher(paramString);
        if (matcher.matches())
          return matcher.replaceAll((String)pair.second); 
      } 
    } 
    return null;
  }
  
  private static String a(JSONObject paramJSONObject) {
    return (paramJSONObject == null || paramJSONObject.length() == 0) ? null : a(paramJSONObject.toString());
  }
  
  private JSONObject b(String paramString) {
    Exception exception;
    JSONObject jSONObject = new JSONObject();
    HashSet hashSet = this.b.h();
    if (hashSet.isEmpty())
      return null; 
    try {
      TelephonyManager telephonyManager = (TelephonyManager)this.a.getSystemService("phone");
    } finally {
      exception = null;
    } 
    if (hashSet.contains(Integer.valueOf(1)) && jSONObject.isNull("m_phone_number") && e.a("m_phone_number")) {
      try {
        String str = a((TelephonyManager)exception);
      } finally {
        Exception exception1 = null;
      } 
      try {
        String str = e.d((TelephonyManager)exception);
      } finally {
        Exception exception1 = null;
      } 
    } 
    if (hashSet.contains(Integer.valueOf(2)) && jSONObject.isNull("sim_serial") && e.a("sim_serial"))
      try {
        String str = e.b((TelephonyManager)exception);
        if (str != null && str.length() > 0 && str.length() < 30)
          jSONObject.put("sim_serial", str); 
      } finally {
        Exception exception1;
      }  
    if (hashSet.contains(Integer.valueOf(3)) && jSONObject.isNull("subscribe_id") && e.a("subscribe_id"))
      try {
        String str = e.c((TelephonyManager)exception);
        if (str != null && str.length() > 0 && str.length() < 30)
          jSONObject.put("subscribe_id", str); 
      } finally {
        Exception exception1;
      }  
    if (hashSet.contains(Integer.valueOf(4)) && jSONObject.isNull("sim_op") && e.a("sim_op"))
      try {
        String str = exception.getSimOperator();
        if (str != null && str.length() > 0 && str.length() < 30)
          jSONObject.put("sim_op", str); 
      } finally {
        Exception exception1;
      }  
    if (hashSet.contains(Integer.valueOf(4)) && jSONObject.isNull("net_op") && e.a("net_op"))
      try {
        String str = exception.getNetworkOperator();
        if (str != null && str.length() > 0 && str.length() < 30)
          jSONObject.put("net_op", str); 
      } finally {
        Exception exception1;
      }  
    if (hashSet.contains(Integer.valueOf(4)) && jSONObject.isNull("phone_type") && e.a("phone_type"))
      try {
        jSONObject.put("phone_type", exception.getPhoneType());
      } catch (Exception exception1) {} 
    if (hashSet.contains(Integer.valueOf(4)) && jSONObject.isNull("net_type") && e.a("net_type"))
      try {
        jSONObject.put("net_type", exception.getNetworkType());
      } catch (Exception exception1) {} 
    if (hashSet.contains(Integer.valueOf(6)) && e.a("wifi_bssid")) {
      String str = paramString;
      try {
        if (TextUtils.isEmpty(paramString))
          str = com.bytedance.embedapplog.util.d.b(this.a); 
        if (!TextUtils.isEmpty(str))
          jSONObject.put("wifi_bssid", str); 
        return jSONObject;
      } catch (Exception exception1) {
        return jSONObject;
      } 
    } 
    return jSONObject;
  }
  
  boolean a() {
    return true;
  }
  
  long b() {
    long l2 = this.b.g() + 21600000L;
    Long long_ = this.b.i();
    long l1 = l2;
    if (long_ != null) {
      if (long_.longValue() == 0L)
        return 0L; 
      long_ = this.b.k();
      l1 = l2;
      if (long_ != null) {
        long l = long_.longValue() + 1800000L;
        l1 = l2;
        if (l < l2)
          l1 = l; 
      } 
    } 
    return l1;
  }
  
  long[] c() {
    return i.c;
  }
  
  public boolean d() {
    boolean bool1;
    String str1;
    String str2;
    Long long_2;
    JSONObject jSONObject = this.c.a();
    if (this.c.o() != 0 && jSONObject != null) {
      long_2 = this.b.i();
      str2 = null;
      Long long_ = null;
      if (long_2 != null) {
        if (long_2.longValue() == 0L) {
          long_2 = null;
        } else {
          long_ = this.b.k();
          if (long_ != null && System.currentTimeMillis() >= long_.longValue() + 1800000L) {
            str1 = com.bytedance.embedapplog.util.d.b(this.a);
            if (str1 != null && !str1.equals(this.b.j())) {
              String str = str1;
            } else {
              String str = str1;
              boolean bool = false;
            } 
          } else {
            long_2 = null;
            boolean bool = false;
          } 
        } 
        bool1 = true;
      } else {
        str2 = str1;
        str1 = null;
        boolean bool = false;
      } 
    } else {
      return false;
    } 
    boolean bool2 = bool1;
    Long long_1 = long_2;
    if (bool1) {
      JSONObject jSONObject1 = b((String)long_2);
      str1 = a(jSONObject1);
      if (!TextUtils.isEmpty(str1)) {
        String str = jSONObject1.optString("wifi_bssid", null);
        bool2 = bool1;
        str2 = str1;
        str1 = str;
      } else {
        str2 = str1;
        str1 = null;
        bool2 = false;
      } 
    } 
    long l = this.b.g();
    if (bool2 || l + 21600000L <= System.currentTimeMillis()) {
      JSONObject jSONObject2 = new JSONObject();
      jSONObject2.put("magic_tag", "ss_app_log");
      jSONObject2.put("header", jSONObject);
      jSONObject2.put("_gen_time", System.currentTimeMillis());
      jSONObject2.put("fingerprint", str2);
      JSONObject jSONObject1 = a.c(a.a(b.a(this.a, this.c.a(), a.a().getSettingUri(), true, AppLog.getIAppParam()), a.c), jSONObject2);
      AppLog.getDataObserver().onRemoteConfigGet(i.a(jSONObject1, this.b.f()) ^ true, jSONObject1);
      if (jSONObject1 != null) {
        l = this.b.h().size();
        this.b.a(jSONObject1, bool2, str1);
        if (this.b.h().size() > l) {
          int j = this.d;
          if (j > 0) {
            this.d = j - 1;
            return d();
          } 
        } 
        return true;
      } 
    } 
    return false;
  }
  
  String e() {
    return "c";
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\embedapplog\a\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */