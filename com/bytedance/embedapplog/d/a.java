package com.bytedance.embedapplog.d;

import android.content.ContentValues;
import android.database.Cursor;
import com.bytedance.embedapplog.util.h;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class a implements Cloneable {
  private static final SimpleDateFormat h = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);
  
  public long a = System.currentTimeMillis();
  
  public long b;
  
  public String c;
  
  public String d;
  
  public String e;
  
  public String f;
  
  String g;
  
  public static a a(String paramString) {
    try {
      return ((a)b.a.get(jSONObject.optString("k_cls", ""))).g().b(jSONObject);
    } finally {
      paramString = null;
      h.a((Throwable)paramString);
    } 
  }
  
  public static String a(long paramLong) {
    return h.format(new Date(paramLong));
  }
  
  public abstract a a(Cursor paramCursor);
  
  protected abstract void a(ContentValues paramContentValues);
  
  protected abstract void a(JSONObject paramJSONObject);
  
  protected abstract String[] a();
  
  final ContentValues b(ContentValues paramContentValues) {
    if (paramContentValues == null) {
      paramContentValues = new ContentValues();
    } else {
      paramContentValues.clear();
    } 
    a(paramContentValues);
    return paramContentValues;
  }
  
  protected abstract a b(JSONObject paramJSONObject);
  
  protected abstract JSONObject b();
  
  final String c() {
    String[] arrayOfString = a();
    if (arrayOfString != null) {
      StringBuilder stringBuilder = new StringBuilder(128);
      stringBuilder.append("create table if not exists ");
      stringBuilder.append(d());
      stringBuilder.append("(");
      for (int i = 0; i < arrayOfString.length; i += 2) {
        stringBuilder.append(arrayOfString[i]);
        stringBuilder.append(" ");
        stringBuilder.append(arrayOfString[i + 1]);
        stringBuilder.append(",");
      } 
      stringBuilder.delete(stringBuilder.length() - 1, stringBuilder.length());
      stringBuilder.append(")");
      return stringBuilder.toString();
    } 
    return null;
  }
  
  abstract String d();
  
  public final JSONObject e() {
    JSONObject jSONObject = new JSONObject();
    try {
      jSONObject.put("k_cls", d());
      a(jSONObject);
      return jSONObject;
    } catch (JSONException jSONException) {
      h.a((Throwable)jSONException);
      return jSONObject;
    } 
  }
  
  final JSONObject f() {
    try {
      this.g = a(this.a);
      return b();
    } catch (JSONException jSONException) {
      h.a((Throwable)jSONException);
      return null;
    } 
  }
  
  public a g() {
    try {
      return (a)super.clone();
    } catch (CloneNotSupportedException cloneNotSupportedException) {
      h.a(cloneNotSupportedException);
      return null;
    } 
  }
  
  protected String h() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("sid:");
    stringBuilder.append(this.c);
    return stringBuilder.toString();
  }
  
  public String toString() {
    if (h.b) {
      String str1 = d();
      String str2 = str1;
      if (!getClass().getSimpleName().equalsIgnoreCase(str1)) {
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append(str1);
        stringBuilder1.append(", ");
        stringBuilder1.append(getClass().getSimpleName());
        str2 = stringBuilder1.toString();
      } 
      String str3 = this.c;
      str1 = "-";
      if (str3 != null) {
        int i = str3.indexOf("-");
        str1 = str3;
        if (i >= 0)
          str1 = str3.substring(0, i); 
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("{");
      stringBuilder.append(str2);
      stringBuilder.append(", ");
      stringBuilder.append(h());
      stringBuilder.append(", ");
      stringBuilder.append(str1);
      stringBuilder.append(", ");
      stringBuilder.append(this.a);
      stringBuilder.append("}");
      return stringBuilder.toString();
    } 
    return super.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\embedapplog\d\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */