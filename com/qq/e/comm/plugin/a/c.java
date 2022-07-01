package com.qq.e.comm.plugin.a;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.StringUtil;
import org.json.JSONException;
import org.json.JSONObject;

public final class c implements Parcelable {
  public static final Parcelable.Creator<c> a = new Parcelable.Creator<c>() {
      public c a(Parcel param1Parcel) {
        return new c(param1Parcel);
      }
      
      public c[] a(int param1Int) {
        return new c[param1Int];
      }
    };
  
  private int b;
  
  private final int c;
  
  private int d;
  
  private final String e;
  
  private final String f;
  
  private final String g;
  
  private final String h;
  
  private final String i;
  
  private final String j;
  
  private final String k;
  
  private final String l;
  
  private final String m;
  
  private final long n;
  
  private int o = 0;
  
  private final Bundle p;
  
  private boolean q;
  
  private transient Bitmap r;
  
  private c(Bundle paramBundle) {
    this(paramBundle.getString("adId"), paramBundle.getString("targetId"), paramBundle.getString("clickId"), paramBundle.getString("iconUrl"), paramBundle.getString("targetUrl"), paramBundle.getString("targetAppName"), paramBundle.getString("targetPkgName"), paramBundle.getBundle("property"), paramBundle.getInt("createNetType"), paramBundle.getLong("createTime"), paramBundle.getInt("status"), paramBundle.getString("title"), paramBundle.getString("desc"));
    b(paramBundle.getInt("taskId"));
    c(paramBundle.getInt("flag"));
  }
  
  private c(Parcel paramParcel) {
    this(paramParcel.readString(), paramParcel.readString(), paramParcel.readString(), paramParcel.readString(), paramParcel.readString(), paramParcel.readString(), paramParcel.readString(), paramParcel.readBundle(), paramParcel.readInt(), paramParcel.readLong(), paramParcel.readInt(), paramParcel.readString(), paramParcel.readString());
    b(paramParcel.readInt());
    c(paramParcel.readInt());
  }
  
  public c(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, int paramInt, String paramString8, String paramString9) {
    this(paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7, new Bundle(), paramInt, System.currentTimeMillis(), 0, paramString8, paramString9);
  }
  
  public c(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, Bundle paramBundle, int paramInt1, long paramLong, int paramInt2, String paramString8, String paramString9) {
    this.e = paramString1;
    this.f = paramString2;
    this.g = paramString3;
    this.h = paramString4;
    this.k = paramString5;
    this.l = paramString6;
    this.m = paramString7;
    this.c = paramInt1;
    this.d = paramInt2;
    this.n = paramLong;
    this.i = paramString8;
    this.j = paramString9;
    Bundle bundle = paramBundle;
    if (paramBundle == null)
      bundle = new Bundle(); 
    this.p = bundle;
    a("notifyId", 0);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("GDT_DOWNLOAD_NOTIFY_TAG_");
    stringBuilder.append(h());
    a("notifyTag", stringBuilder.toString());
    a("autoInstall", true);
  }
  
  static c a(Bundle paramBundle) {
    return (paramBundle == null) ? null : new c(paramBundle);
  }
  
  private Bundle v() {
    return this.p;
  }
  
  public String a() {
    return this.i;
  }
  
  public String a(String paramString) {
    return this.p.getString(paramString);
  }
  
  public void a(int paramInt) {
    this.d = paramInt;
  }
  
  public void a(Bitmap paramBitmap) {
    this.r = paramBitmap;
  }
  
  public void a(String paramString, int paramInt) {
    this.p.putInt(paramString, paramInt);
  }
  
  public void a(String paramString, long paramLong) {
    this.p.putLong(paramString, paramLong);
  }
  
  public void a(String paramString1, String paramString2) {
    if (!TextUtils.isEmpty(paramString1) && !TextUtils.isEmpty(paramString2))
      this.p.putString(paramString1, paramString2); 
  }
  
  public void a(String paramString, JSONObject paramJSONObject, boolean paramBoolean) {
    JSONObject jSONObject = new JSONObject();
    try {
      jSONObject.put("customized_invoke_url", paramString);
      jSONObject.put("reportUrl", paramJSONObject);
      jSONObject.put("autoInstall", paramBoolean);
    } catch (JSONException jSONException) {}
    a("launchParam", jSONObject.toString());
  }
  
  public void a(String paramString, boolean paramBoolean) {
    this.p.putBoolean(paramString, paramBoolean);
  }
  
  public void a(JSONObject paramJSONObject) {
    if (paramJSONObject != null)
      a("launchParam", paramJSONObject.toString()); 
  }
  
  public void a(boolean paramBoolean) {
    this.q = paramBoolean;
  }
  
  public int b(String paramString) {
    return this.p.getInt(paramString);
  }
  
  public String b() {
    return this.j;
  }
  
  public void b(int paramInt) {
    this.b = paramInt;
  }
  
  public void b(boolean paramBoolean) {
    if (paramBoolean) {
      d(4);
      return;
    } 
    e(4);
  }
  
  public long c(String paramString) {
    return this.p.getLong(paramString);
  }
  
  public void c(int paramInt) {
    this.o = paramInt;
  }
  
  public boolean c() {
    return this.q;
  }
  
  public long d() {
    return this.n;
  }
  
  public void d(int paramInt) {
    this.o = paramInt | this.o;
  }
  
  public boolean d(String paramString) {
    return this.p.getBoolean(paramString);
  }
  
  public int describeContents() {
    return 0;
  }
  
  public int e() {
    return this.c;
  }
  
  public void e(int paramInt) {
    this.o = paramInt & this.o;
  }
  
  public void e(String paramString) {
    a("failReason", paramString);
  }
  
  public String f() {
    return this.l;
  }
  
  public String g() {
    return this.k;
  }
  
  public String h() {
    return this.m;
  }
  
  public String i() {
    return this.h;
  }
  
  public String j() {
    return this.f;
  }
  
  public String k() {
    return this.g;
  }
  
  public String l() {
    return this.e;
  }
  
  public int m() {
    return this.b;
  }
  
  public int n() {
    return this.o;
  }
  
  public int o() {
    return this.d;
  }
  
  public Bitmap p() {
    return this.r;
  }
  
  public boolean q() {
    return ((this.o & 0x1) != 0);
  }
  
  public boolean r() {
    return ((this.o & 0x4) != 0);
  }
  
  public JSONObject s() {
    String str = a("launchParam");
    try {
      if (!StringUtil.isEmpty(str))
        return new JSONObject(str); 
    } catch (JSONException jSONException) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("JSON Parse launchParam Error,launchParam : ");
      stringBuilder.append(str);
      GDTLogger.report(stringBuilder.toString(), (Throwable)jSONException);
    } 
    return null;
  }
  
  String t() {
    JSONObject jSONObject = s();
    return (jSONObject != null) ? jSONObject.optString("customized_invoke_url") : null;
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("ApkDownloadTask{taskId=");
    stringBuilder.append(this.b);
    stringBuilder.append(", createNetType=");
    stringBuilder.append(this.c);
    stringBuilder.append(", status=");
    stringBuilder.append(this.d);
    stringBuilder.append(", targetAppName='");
    stringBuilder.append(this.l);
    stringBuilder.append('\'');
    stringBuilder.append(", targetPkgName='");
    stringBuilder.append(this.m);
    stringBuilder.append('\'');
    stringBuilder.append(", createTime=");
    stringBuilder.append(this.n);
    stringBuilder.append(", isReturned=");
    stringBuilder.append(this.q);
    stringBuilder.append('}');
    return stringBuilder.toString();
  }
  
  Bundle u() {
    Bundle bundle = new Bundle();
    bundle.putString("adId", this.e);
    bundle.putInt("taskId", this.b);
    bundle.putString("targetId", this.f);
    bundle.putString("clickId", this.g);
    bundle.putString("iconUrl", this.h);
    bundle.putString("targetUrl", this.k);
    bundle.putString("targetAppName", this.l);
    bundle.putString("targetPkgName", this.m);
    bundle.putInt("createNetType", this.c);
    bundle.putLong("createTime", this.n);
    bundle.putInt("status", this.d);
    bundle.putInt("flag", this.o);
    bundle.putBundle("property", this.p);
    bundle.putString("title", this.i);
    bundle.putString("desc", this.j);
    return bundle;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {
    paramParcel.writeString(l());
    paramParcel.writeString(j());
    paramParcel.writeString(k());
    paramParcel.writeString(i());
    paramParcel.writeString(g());
    paramParcel.writeString(f());
    paramParcel.writeString(h());
    paramParcel.writeBundle(v());
    paramParcel.writeInt(e());
    paramParcel.writeLong(d());
    paramParcel.writeInt(o());
    paramParcel.writeString(a());
    paramParcel.writeString(b());
    paramParcel.writeInt(m());
    paramParcel.writeInt(n());
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\a\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */