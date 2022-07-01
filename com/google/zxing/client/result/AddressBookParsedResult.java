package com.google.zxing.client.result;

public final class AddressBookParsedResult extends ParsedResult {
  private final String[] a;
  
  private final String[] b;
  
  private final String c;
  
  private final String[] d;
  
  private final String[] e;
  
  private final String f;
  
  private final String g;
  
  private final String[] h;
  
  private final String i;
  
  private final String j;
  
  private final String k;
  
  private final String[] l;
  
  private final String[] m;
  
  public String a() {
    StringBuilder stringBuilder = new StringBuilder(100);
    a(this.a, stringBuilder);
    a(this.b, stringBuilder);
    a(this.c, stringBuilder);
    a(this.k, stringBuilder);
    a(this.i, stringBuilder);
    a(this.h, stringBuilder);
    a(this.d, stringBuilder);
    a(this.e, stringBuilder);
    a(this.f, stringBuilder);
    a(this.l, stringBuilder);
    a(this.j, stringBuilder);
    a(this.m, stringBuilder);
    a(this.g, stringBuilder);
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\zxing\client\result\AddressBookParsedResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */