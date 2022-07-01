package com.google.zxing.client.result;

import java.util.Map;

public final class ExpandedProductParsedResult extends ParsedResult {
  private final String a;
  
  private final String b;
  
  private final String c;
  
  private final String d;
  
  private final String e;
  
  private final String f;
  
  private final String g;
  
  private final String h;
  
  private final String i;
  
  private final String j;
  
  private final String k;
  
  private final String l;
  
  private final String m;
  
  private final Map<String, String> n;
  
  private static int a(Object paramObject) {
    return (paramObject == null) ? 0 : paramObject.hashCode();
  }
  
  private static boolean a(Object paramObject1, Object paramObject2) {
    return (paramObject1 == null) ? ((paramObject2 == null)) : paramObject1.equals(paramObject2);
  }
  
  public String a() {
    return String.valueOf(this.a);
  }
  
  public boolean equals(Object paramObject) {
    if (!(paramObject instanceof ExpandedProductParsedResult))
      return false; 
    paramObject = paramObject;
    return (a(this.b, ((ExpandedProductParsedResult)paramObject).b) && a(this.c, ((ExpandedProductParsedResult)paramObject).c) && a(this.d, ((ExpandedProductParsedResult)paramObject).d) && a(this.e, ((ExpandedProductParsedResult)paramObject).e) && a(this.f, ((ExpandedProductParsedResult)paramObject).f) && a(this.g, ((ExpandedProductParsedResult)paramObject).g) && a(this.h, ((ExpandedProductParsedResult)paramObject).h) && a(this.i, ((ExpandedProductParsedResult)paramObject).i) && a(this.j, ((ExpandedProductParsedResult)paramObject).j) && a(this.k, ((ExpandedProductParsedResult)paramObject).k) && a(this.l, ((ExpandedProductParsedResult)paramObject).l) && a(this.m, ((ExpandedProductParsedResult)paramObject).m) && a(this.n, ((ExpandedProductParsedResult)paramObject).n));
  }
  
  public int hashCode() {
    return a(this.b) ^ 0x0 ^ a(this.c) ^ a(this.d) ^ a(this.e) ^ a(this.f) ^ a(this.g) ^ a(this.h) ^ a(this.i) ^ a(this.j) ^ a(this.k) ^ a(this.l) ^ a(this.m) ^ a(this.n);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\zxing\client\result\ExpandedProductParsedResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */