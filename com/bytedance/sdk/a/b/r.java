package com.bytedance.sdk.a.b;

import com.bytedance.sdk.a.b.a.c;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class r {
  private final String[] a;
  
  r(a parama) {
    this.a = parama.a.<String>toArray(new String[parama.a.size()]);
  }
  
  private static String a(String[] paramArrayOfString, String paramString) {
    for (int i = paramArrayOfString.length - 2; i >= 0; i -= 2) {
      if (paramString.equalsIgnoreCase(paramArrayOfString[i]))
        return paramArrayOfString[i + 1]; 
    } 
    return null;
  }
  
  public int a() {
    return this.a.length / 2;
  }
  
  public String a(int paramInt) {
    return this.a[paramInt * 2];
  }
  
  public String a(String paramString) {
    return a(this.a, paramString);
  }
  
  public a b() {
    a a = new a();
    Collections.addAll(a.a, this.a);
    return a;
  }
  
  public String b(int paramInt) {
    return this.a[paramInt * 2 + 1];
  }
  
  public List<String> b(String paramString) {
    int j = a();
    ArrayList<String> arrayList = null;
    int i = 0;
    while (i < j) {
      ArrayList<String> arrayList1 = arrayList;
      if (paramString.equalsIgnoreCase(a(i))) {
        arrayList1 = arrayList;
        if (arrayList == null)
          arrayList1 = new ArrayList(2); 
        arrayList1.add(b(i));
      } 
      i++;
      arrayList = arrayList1;
    } 
    return (arrayList != null) ? Collections.unmodifiableList(arrayList) : Collections.emptyList();
  }
  
  public boolean equals(Object paramObject) {
    return (paramObject instanceof r && Arrays.equals((Object[])((r)paramObject).a, (Object[])this.a));
  }
  
  public int hashCode() {
    return Arrays.hashCode((Object[])this.a);
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    int j = a();
    for (int i = 0; i < j; i++) {
      stringBuilder.append(a(i));
      stringBuilder.append(": ");
      stringBuilder.append(b(i));
      stringBuilder.append("\n");
    } 
    return stringBuilder.toString();
  }
  
  public static final class a {
    final List<String> a = new ArrayList<String>(20);
    
    private void d(String param1String1, String param1String2) {
      if (param1String1 != null) {
        if (!param1String1.isEmpty()) {
          int j = param1String1.length();
          int i = 0;
          while (i < j) {
            char c = param1String1.charAt(i);
            if (c > ' ' && c < '') {
              i++;
              continue;
            } 
            throw new IllegalArgumentException(c.a("Unexpected char %#04x at %d in header name: %s", new Object[] { Integer.valueOf(c), Integer.valueOf(i), param1String1 }));
          } 
          if (param1String2 != null) {
            j = param1String2.length();
            i = 0;
            while (i < j) {
              char c = param1String2.charAt(i);
              if ((c > '\037' || c == '\t') && c < '') {
                i++;
                continue;
              } 
              throw new IllegalArgumentException(c.a("Unexpected char %#04x at %d in %s value: %s", new Object[] { Integer.valueOf(c), Integer.valueOf(i), param1String1, param1String2 }));
            } 
            return;
          } 
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("value for name ");
          stringBuilder.append(param1String1);
          stringBuilder.append(" == null");
          throw new NullPointerException(stringBuilder.toString());
        } 
        throw new IllegalArgumentException("name is empty");
      } 
      throw new NullPointerException("name == null");
    }
    
    a a(String param1String) {
      int i = param1String.indexOf(":", 1);
      return (i != -1) ? b(param1String.substring(0, i), param1String.substring(i + 1)) : (param1String.startsWith(":") ? b("", param1String.substring(1)) : b("", param1String));
    }
    
    public a a(String param1String1, String param1String2) {
      d(param1String1, param1String2);
      return b(param1String1, param1String2);
    }
    
    public r a() {
      return new r(this);
    }
    
    public a b(String param1String) {
      for (int i = 0; i < this.a.size(); i = j + 2) {
        int j = i;
        if (param1String.equalsIgnoreCase(this.a.get(i))) {
          this.a.remove(i);
          this.a.remove(i);
          j = i - 2;
        } 
      } 
      return this;
    }
    
    a b(String param1String1, String param1String2) {
      this.a.add(param1String1);
      this.a.add(param1String2.trim());
      return this;
    }
    
    public a c(String param1String1, String param1String2) {
      d(param1String1, param1String2);
      b(param1String1);
      b(param1String1, param1String2);
      return this;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\a\b\r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */