package cn.com.chinatelecom.account.api.d;

import android.text.TextUtils;
import cn.com.chinatelecom.account.api.a.d;
import org.json.JSONException;
import org.json.JSONObject;

public class j {
  public static final byte[] a = new byte[] { 
      -30, -91, -67, -20, -69, -120, -30, -68, -113, -20, 
      -99, -68 };
  
  public static final byte[] b = new byte[] { 
      -30, -91, -67, -20, -69, -120, -19, -73, -101, -19, 
      -79, -106, -17, -74, -120, -17, -78, -78 };
  
  public static final byte[] c = new byte[] { 
      -17, -103, -121, -17, -80, -98, -19, -86, -117, -29, 
      -98, -109, -30, -91, -91 };
  
  public static final byte[] d = new byte[] { 
      -20, -99, -86, -19, -73, -101, -19, -79, -106, -30, 
      -75, -108, -20, -124, -81 };
  
  public static final byte[] e = new byte[] { 
      -19, -83, -79, -17, Byte.MIN_VALUE, -94, -19, -73, -101, -19, 
      -79, -106, -20, -106, -96, -17, -74, -118, -17, -102, 
      -91 };
  
  public static final byte[] f = new byte[] { 
      89, 101, 105, 97, 111, 126, -30, -68, -113, -20, 
      -99, -68, -17, -74, -120, -17, -78, -78 };
  
  public static final byte[] g = new byte[] { 
      -17, -107, -107, -17, -102, -121, -30, -83, -87, -20, 
      -108, -102, -17, -74, -120, -17, -78, -78 };
  
  public static final byte[] h = new byte[] { 67, 69, -17, -74, -120, -17, -78, -78 };
  
  public static final byte[] i = new byte[] { 
      -19, -109, -79, -17, -73, -97, -19, -79, -103, -20, 
      -108, -106, -18, -78, -80, -19, -93, -80 };
  
  public static final byte[] j = new byte[] { 
      -19, -109, -79, -17, -73, -97, -17, -74, -120, -17, 
      -78, -78 };
  
  public static final byte[] k = new byte[] { 
      -29, -88, -114, -19, -109, -79, -17, -73, -97, -17, 
      -74, -120, -17, -78, -78 };
  
  public static final byte[] l = new byte[] { 
      -30, -91, -67, -17, -113, -126, -17, -126, -105, -17, 
      -83, -127, -17, -122, -100, 89, 78, 65 };
  
  public static final byte[] m = new byte[] { 
      -19, -98, -94, -20, -126, -67, -17, -113, -71, -29, 
      -99, -89, -19, -97, -122, -29, -105, -88 };
  
  public static final byte[] n = new byte[] { 
      -17, -113, -68, -18, -79, -100, -19, -109, -79, -17, 
      -73, -97, -20, -100, -77, -17, -74, -123 };
  
  public static final byte[] o = new byte[] { 
      93, 67, 76, 67, -17, -126, -115, -20, -121, -88, 
      -30, -68, -113, -20, -99, -68 };
  
  public static final byte[] p = new byte[] { 
      93, 67, 76, 67, -17, -126, -115, -20, -121, -88, 
      -17, -74, -120, -17, -78, -78 };
  
  public static final byte[] q = new byte[] { 
      -17, -125, -121, -19, -73, -92, -17, -107, -107, -17, 
      -102, -121, -30, -83, -87, -20, -108, -102, -17, -82, 
      -69, -30, -66, -81 };
  
  public static String a() {
    return a(80003, d.a(d));
  }
  
  public static String a(int paramInt, String paramString) {
    return a(paramInt, paramString, null);
  }
  
  public static String a(int paramInt, String paramString1, String paramString2) {
    JSONObject jSONObject = new JSONObject();
    try {
      jSONObject.put("result", paramInt);
      jSONObject.put("msg", paramString1);
      if (!TextUtils.isEmpty(paramString2))
        jSONObject.put("reqId", paramString2); 
    } catch (JSONException jSONException) {
      jSONException.printStackTrace();
    } 
    return jSONObject.toString();
  }
  
  public static String b() {
    return a(80001, d.a(b));
  }
  
  public static String c() {
    return a(80000, d.a(a));
  }
  
  public static String d() {
    return a(80004, d.a(e));
  }
  
  public static String e() {
    return a(80103, d.a(l));
  }
  
  public static String f() {
    return a(80102, d.a(k));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\cn\com\chinatelecom\account\api\d\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */