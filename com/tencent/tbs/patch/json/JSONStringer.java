package com.tencent.tbs.patch.json;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JSONStringer {
  final StringBuilder a = new StringBuilder();
  
  private final List<a> b = new ArrayList<a>();
  
  private final String c;
  
  public JSONStringer() {
    this.c = null;
  }
  
  JSONStringer(int paramInt) {
    char[] arrayOfChar = new char[paramInt];
    Arrays.fill(arrayOfChar, ' ');
    this.c = new String(arrayOfChar);
  }
  
  private a a() {
    if (!this.b.isEmpty()) {
      List<a> list = this.b;
      return list.get(list.size() - 1);
    } 
    throw new JSONException("Nesting problem");
  }
  
  private void a(a parama) {
    List<a> list = this.b;
    list.set(list.size() - 1, parama);
  }
  
  private void a(String paramString) {
    this.a.append("\"");
    int j = paramString.length();
    for (int i = 0; i < j; i++) {
      char c = paramString.charAt(i);
      if (c != '"' && c != '/' && c != '\\') {
        StringBuilder stringBuilder;
        String str;
        switch (c) {
          default:
            switch (c) {
              default:
                if (c <= '\037') {
                  this.a.append(String.format("\\u%04x", new Object[] { Integer.valueOf(c) }));
                  break;
                } 
                stringBuilder = this.a;
                break;
              case '\r':
                stringBuilder = this.a;
                str = "\\r";
                stringBuilder.append(str);
                break;
              case '\f':
                stringBuilder = this.a;
                str = "\\f";
                stringBuilder.append(str);
                break;
            } 
            stringBuilder.append(c);
          case '\n':
            stringBuilder = this.a;
            str = "\\n";
            stringBuilder.append(str);
            break;
          case '\t':
            stringBuilder = this.a;
            str = "\\t";
            stringBuilder.append(str);
            break;
          case '\b':
            stringBuilder = this.a;
            str = "\\b";
            stringBuilder.append(str);
            break;
        } 
      } else {
        StringBuilder stringBuilder = this.a;
        stringBuilder.append('\\');
        stringBuilder.append(c);
      } 
    } 
    this.a.append("\"");
  }
  
  private void b() {
    if (this.c == null)
      return; 
    this.a.append("\n");
    for (int i = 0; i < this.b.size(); i++)
      this.a.append(this.c); 
  }
  
  private void c() {
    a a = a();
    if (a == a.e) {
      this.a.append(',');
    } else if (a != a.c) {
      throw new JSONException("Nesting problem");
    } 
    b();
    a(a.d);
  }
  
  private void d() {
    if (this.b.isEmpty())
      return; 
    a a = a();
    if (a == a.a) {
      a(a.b);
    } else if (a == a.b) {
      this.a.append(',');
    } else {
      String str;
      if (a == a.d) {
        StringBuilder stringBuilder = this.a;
        if (this.c == null) {
          str = ":";
        } else {
          str = ": ";
        } 
        stringBuilder.append(str);
        a(a.e);
        return;
      } 
      if (str == a.f)
        return; 
      throw new JSONException("Nesting problem");
    } 
    b();
  }
  
  JSONStringer a(a parama1, a parama2, String paramString) {
    a a1 = a();
    if (a1 == parama2 || a1 == parama1) {
      List<a> list = this.b;
      list.remove(list.size() - 1);
      if (a1 == parama2)
        b(); 
      this.a.append(paramString);
      return this;
    } 
    throw new JSONException("Nesting problem");
  }
  
  JSONStringer a(a parama, String paramString) {
    if (!this.b.isEmpty() || this.a.length() <= 0) {
      d();
      this.b.add(parama);
      this.a.append(paramString);
      return this;
    } 
    throw new JSONException("Nesting problem: multiple top-level roots");
  }
  
  public JSONStringer array() {
    return a(a.a, "[");
  }
  
  public JSONStringer endArray() {
    return a(a.a, a.b, "]");
  }
  
  public JSONStringer endObject() {
    return a(a.c, a.e, "}");
  }
  
  public JSONStringer key(String paramString) {
    if (paramString != null) {
      c();
      a(paramString);
      return this;
    } 
    throw new JSONException("Names must be non-null");
  }
  
  public JSONStringer object() {
    return a(a.c, "{");
  }
  
  public String toString() {
    return (this.a.length() == 0) ? null : this.a.toString();
  }
  
  public JSONStringer value(double paramDouble) {
    if (!this.b.isEmpty()) {
      d();
      this.a.append(JSONObject.numberToString(Double.valueOf(paramDouble)));
      return this;
    } 
    throw new JSONException("Nesting problem");
  }
  
  public JSONStringer value(long paramLong) {
    if (!this.b.isEmpty()) {
      d();
      this.a.append(paramLong);
      return this;
    } 
    throw new JSONException("Nesting problem");
  }
  
  public JSONStringer value(Object paramObject) {
    if (!this.b.isEmpty()) {
      if (paramObject instanceof JSONArray) {
        ((JSONArray)paramObject).a(this);
        return this;
      } 
      if (paramObject instanceof JSONObject) {
        ((JSONObject)paramObject).a(this);
        return this;
      } 
      d();
      if (paramObject == null || paramObject instanceof Boolean || paramObject == JSONObject.NULL) {
        this.a.append(paramObject);
        return this;
      } 
      if (paramObject instanceof Number) {
        this.a.append(JSONObject.numberToString((Number)paramObject));
        return this;
      } 
      a(paramObject.toString());
      return this;
    } 
    throw new JSONException("Nesting problem");
  }
  
  public JSONStringer value(boolean paramBoolean) {
    if (!this.b.isEmpty()) {
      d();
      this.a.append(paramBoolean);
      return this;
    } 
    throw new JSONException("Nesting problem");
  }
  
  enum a {
    a, b, c, d, e, f;
    
    static {
      throw new VerifyError("bad dex opcode");
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued209820-dex2jar.jar!\com\tencent\tbs\patch\json\JSONStringer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */