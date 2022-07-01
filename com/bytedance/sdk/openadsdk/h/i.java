package com.bytedance.sdk.openadsdk.h;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.h.g.d;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class i {
  public final c a;
  
  public final List<b> b;
  
  public final a c;
  
  public i(c paramc, List<b> paramList, a parama) {
    this.a = paramc;
    this.b = paramList;
    this.c = parama;
  }
  
  public static i a(InputStream paramInputStream) throws IOException, d {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(paramInputStream, d.a));
    ArrayList<b> arrayList = new ArrayList();
    paramInputStream = null;
    while (true) {
      c c1;
      String str = bufferedReader.readLine();
      if (!TextUtils.isEmpty(str)) {
        str = str.trim();
        if (paramInputStream == null) {
          c1 = c.a(str);
          continue;
        } 
        arrayList.add(b.a(str));
        continue;
      } 
      if (c1 != null)
        return new i(c1, arrayList, a.a(c1, arrayList)); 
      throw new d("request line is null");
    } 
  }
  
  static String a(String paramString1, String paramString2, List<String> paramList) {
    StringBuilder stringBuilder = new StringBuilder(512);
    String str = null;
    while (true) {
      if (str != null) {
        if (paramList.size() == 1)
          return null; 
        paramList.remove(paramList.size() - 1);
      } 
      String str1 = a(stringBuilder, paramString1, paramString2, paramList);
      str = str1;
      if (str1.length() <= 3072)
        return str1; 
    } 
  }
  
  private static String a(StringBuilder paramStringBuilder, String paramString1, String paramString2, List<String> paramList) {
    int k = paramStringBuilder.length();
    int j = 0;
    paramStringBuilder.delete(0, k);
    paramStringBuilder.append("rk");
    paramStringBuilder.append("=");
    paramStringBuilder.append(Uri.encode(paramString1));
    paramStringBuilder.append("&");
    paramStringBuilder.append("k");
    paramStringBuilder.append("=");
    paramStringBuilder.append(Uri.encode(paramString2));
    k = paramList.size();
    while (j < k) {
      paramStringBuilder.append("&");
      paramStringBuilder.append("u");
      paramStringBuilder.append(j);
      paramStringBuilder.append("=");
      paramStringBuilder.append(Uri.encode(paramList.get(j)));
      j++;
    } 
    return paramStringBuilder.toString();
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Request{requestLine=");
    stringBuilder.append(this.a);
    stringBuilder.append(", headers=");
    stringBuilder.append(this.b);
    stringBuilder.append(", extra=");
    stringBuilder.append(this.c);
    stringBuilder.append('}');
    return stringBuilder.toString();
  }
  
  static final class a {
    final int a;
    
    final String b;
    
    final String c;
    
    final int d;
    
    final int e;
    
    final String f;
    
    final List<String> g;
    
    private a(int param1Int1, String param1String1, String param1String2, int param1Int2, int param1Int3, String param1String3, List<String> param1List) {
      this.a = param1Int1;
      this.b = param1String1;
      this.c = param1String2;
      this.d = param1Int2;
      this.e = param1Int3;
      this.f = param1String3;
      this.g = param1List;
    }
    
    static a a(i.c param1c, List<i.b> param1List) throws i.d {
      StringBuilder stringBuilder1;
      boolean bool1;
      boolean bool2;
      CharSequence charSequence1;
      CharSequence charSequence2;
      ArrayList<String> arrayList;
      int i = param1c.b.indexOf("?");
      if (i != -1) {
        arrayList = new ArrayList();
        String[] arrayOfString = param1c.b.substring(i + 1).split("&");
        int j = arrayOfString.length;
        List list = null;
        charSequence2 = null;
        charSequence1 = charSequence2;
        i = 0;
        for (bool2 = false; i < j; bool2 = bool1) {
          CharSequence charSequence3;
          CharSequence charSequence4;
          String[] arrayOfString1 = arrayOfString[i].split("=");
          if (arrayOfString1.length != 2) {
            charSequence3 = charSequence2;
            charSequence4 = charSequence1;
            bool1 = bool2;
          } else if ("rk".equals(arrayOfString1[0])) {
            charSequence3 = Uri.decode(arrayOfString1[1]);
            charSequence4 = charSequence1;
            bool1 = bool2;
          } else if ("k".equals(arrayOfString1[0])) {
            charSequence4 = Uri.decode(arrayOfString1[1]);
            charSequence3 = charSequence2;
            bool1 = bool2;
          } else if (arrayOfString1[0].startsWith("u")) {
            arrayList.add(Uri.decode(arrayOfString1[1]));
            charSequence3 = charSequence2;
            charSequence4 = charSequence1;
            bool1 = bool2;
          } else {
            charSequence3 = charSequence2;
            charSequence4 = charSequence1;
            bool1 = bool2;
            if ("f".equals(arrayOfString1[0])) {
              charSequence3 = charSequence2;
              charSequence4 = charSequence1;
              bool1 = bool2;
              if (d.b(arrayOfString1[1]) == 1) {
                bool1 = true;
                charSequence4 = charSequence1;
                charSequence3 = charSequence2;
              } 
            } 
          } 
          i++;
          charSequence2 = charSequence3;
          charSequence1 = charSequence4;
        } 
        if (!TextUtils.isEmpty(charSequence2) && !TextUtils.isEmpty(charSequence1)) {
          if (param1List != null) {
            Iterator<i.b> iterator = param1List.iterator();
            int k = 0;
            i = 0;
            param1List = list;
            while (true) {
              String str;
              if (iterator.hasNext()) {
                i.b b = iterator.next();
                if (b != null && "Range".equalsIgnoreCase(b.a)) {
                  j = b.b.indexOf("=");
                  if (j != -1) {
                    if ("bytes".equalsIgnoreCase(b.b.substring(0, j).trim())) {
                      String str1 = b.b.substring(j + 1);
                      if (!str1.contains(",")) {
                        j = str1.indexOf("-");
                        if (j != -1) {
                          str = str1.substring(0, j).trim();
                          str1 = str1.substring(j + 1).trim();
                          try {
                            if (str.length() > 0)
                              k = Integer.parseInt(str); 
                            if (str1.length() > 0) {
                              i = Integer.parseInt(str1);
                              if (k > i) {
                                StringBuilder stringBuilder5 = new StringBuilder();
                                stringBuilder5.append("Range format error, Range: ");
                                stringBuilder5.append(b.b);
                                throw new i.d(stringBuilder5.toString());
                              } 
                            } 
                            str = b.b;
                          } catch (NumberFormatException numberFormatException) {
                            StringBuilder stringBuilder5 = new StringBuilder();
                            stringBuilder5.append("Range format error, Range: ");
                            stringBuilder5.append(b.b);
                            throw new i.d(stringBuilder5.toString());
                          } 
                          continue;
                        } 
                        StringBuilder stringBuilder4 = new StringBuilder();
                        stringBuilder4.append("Range format error, Range: ");
                        stringBuilder4.append(b.b);
                        throw new i.d(stringBuilder4.toString());
                      } 
                      StringBuilder stringBuilder3 = new StringBuilder();
                      stringBuilder3.append("Range format error, Range: ");
                      stringBuilder3.append(b.b);
                      throw new i.d(stringBuilder3.toString());
                    } 
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Range format error, Range: ");
                    stringBuilder.append(b.b);
                    throw new i.d(stringBuilder.toString());
                  } 
                  stringBuilder1 = new StringBuilder();
                  stringBuilder1.append("Range format error, Range: ");
                  stringBuilder1.append(b.b);
                  throw new i.d(stringBuilder1.toString());
                } 
                continue;
              } 
              if (!arrayList.isEmpty())
                return new a(bool2, (String)charSequence2, (String)charSequence1, k, i, str, arrayList); 
              stringBuilder2 = new StringBuilder();
              stringBuilder2.append("no url found: path: ");
              stringBuilder2.append(((i.c)stringBuilder1).b);
              throw new i.d(stringBuilder2.toString());
            } 
          } 
          param1List = null;
          i = 0;
          bool1 = false;
        } else {
          stringBuilder2 = new StringBuilder();
          stringBuilder2.append("rawKey or key is empty, path: ");
          stringBuilder2.append(((i.c)stringBuilder1).b);
          throw new i.d(stringBuilder2.toString());
        } 
      } else {
        stringBuilder2 = new StringBuilder();
        stringBuilder2.append("path format error, path: ");
        stringBuilder2.append(((i.c)stringBuilder1).b);
        throw new i.d(stringBuilder2.toString());
      } 
      if (!arrayList.isEmpty())
        return new a(bool2, (String)charSequence2, (String)charSequence1, bool1, i, (String)stringBuilder2, arrayList); 
      StringBuilder stringBuilder2 = new StringBuilder();
      stringBuilder2.append("no url found: path: ");
      stringBuilder2.append(((i.c)stringBuilder1).b);
      throw new i.d(stringBuilder2.toString());
    }
    
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Extra{flag=");
      stringBuilder.append(this.a);
      stringBuilder.append(", rawKey='");
      stringBuilder.append(this.b);
      stringBuilder.append('\'');
      stringBuilder.append(", key='");
      stringBuilder.append(this.c);
      stringBuilder.append('\'');
      stringBuilder.append(", from=");
      stringBuilder.append(this.d);
      stringBuilder.append(", to=");
      stringBuilder.append(this.e);
      stringBuilder.append(", urls=");
      stringBuilder.append(this.g);
      stringBuilder.append('}');
      return stringBuilder.toString();
    }
  }
  
  public static final class b {
    public final String a;
    
    public final String b;
    
    public b(String param1String1, String param1String2) {
      this.a = param1String1;
      this.b = param1String2;
    }
    
    static b a(String param1String) throws i.d {
      int i = param1String.indexOf(":");
      if (i != -1) {
        String str1 = param1String.substring(0, i).trim();
        String str2 = param1String.substring(i + 1).trim();
        if (str1.length() != 0 && str2.length() != 0)
          return new b(str1, str2); 
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("request header format error, header: ");
        stringBuilder1.append(param1String);
        throw new i.d(stringBuilder1.toString());
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("request header format error, header: ");
      stringBuilder.append(param1String);
      throw new i.d(stringBuilder.toString());
    }
    
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Header{name='");
      stringBuilder.append(this.a);
      stringBuilder.append('\'');
      stringBuilder.append(", value='");
      stringBuilder.append(this.b);
      stringBuilder.append('\'');
      stringBuilder.append('}');
      return stringBuilder.toString();
    }
  }
  
  static final class c {
    final String a;
    
    final String b;
    
    final String c;
    
    private c(String param1String1, String param1String2, String param1String3) {
      this.a = param1String1;
      this.b = param1String2;
      this.c = param1String3;
    }
    
    static c a(String param1String) throws i.d {
      int i = param1String.indexOf(' ');
      if (i != -1) {
        int j = param1String.lastIndexOf(' ');
        if (j > i) {
          String str1 = param1String.substring(0, i).trim();
          String str2 = param1String.substring(i + 1, j).trim();
          String str3 = param1String.substring(j + 1).trim();
          if (str1.length() != 0 && str2.length() != 0 && str3.length() != 0)
            return new c(str1, str2, str3); 
          StringBuilder stringBuilder2 = new StringBuilder();
          stringBuilder2.append("request line format error, line: ");
          stringBuilder2.append(param1String);
          throw new i.d(stringBuilder2.toString());
        } 
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("request line format error, line: ");
        stringBuilder1.append(param1String);
        throw new i.d(stringBuilder1.toString());
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("request line format error, line: ");
      stringBuilder.append(param1String);
      throw new i.d(stringBuilder.toString());
    }
    
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("RequestLine{method='");
      stringBuilder.append(this.a);
      stringBuilder.append('\'');
      stringBuilder.append(", path='");
      stringBuilder.append(this.b);
      stringBuilder.append('\'');
      stringBuilder.append(", version='");
      stringBuilder.append(this.c);
      stringBuilder.append('\'');
      stringBuilder.append('}');
      return stringBuilder.toString();
    }
  }
  
  static final class d extends Exception {
    d(String param1String) {
      super(param1String);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\h\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */