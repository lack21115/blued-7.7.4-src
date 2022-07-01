package com.loc;

public final class dd {
  public long a;
  
  public String b;
  
  public int c = -113;
  
  public int d;
  
  public long e;
  
  public long f = 0L;
  
  public short g;
  
  public boolean h;
  
  public dd(boolean paramBoolean) {
    this.h = paramBoolean;
  }
  
  public static long a(String paramString) {
    if (paramString != null) {
      Object object1;
      Object object2;
      if (paramString.length() == 0)
        return 0L; 
      boolean bool = false;
      int i = paramString.length() - 1;
      long l = 0L;
      while (i >= 0) {
        long l2 = paramString.charAt(i);
        if (l2 >= 48L && l2 <= 57L) {
          l1 = l2 - 48L;
        } else {
          Object object;
          long l3 = 97L;
          if (l2 < 97L || l2 > 102L) {
            l3 = 65L;
            if (l2 < 65L || l2 > 70L) {
              Object object3 = object1;
              object = object2;
              if (l2 != 58L) {
                object3 = object1;
                object = object2;
                if (l2 != 124L)
                  return 0L; 
              } 
              continue;
            } 
          } 
          l1 = l2 - object + 10L;
        } 
        long l1 = object2 + (l1 << object1);
        int j = object1 + 4;
        continue;
        i--;
        object1 = SYNTHETIC_LOCAL_VARIABLE_3;
        object2 = SYNTHETIC_LOCAL_VARIABLE_6;
      } 
      return (object1 != 48) ? 0L : object2;
    } 
    return 0L;
  }
  
  public final String toString() {
    StringBuilder stringBuilder = new StringBuilder("AmapWifi{mac=");
    stringBuilder.append(this.a);
    stringBuilder.append(", ssid='");
    stringBuilder.append(this.b);
    stringBuilder.append('\'');
    stringBuilder.append(", rssi=");
    stringBuilder.append(this.c);
    stringBuilder.append(", frequency=");
    stringBuilder.append(this.d);
    stringBuilder.append(", timestamp=");
    stringBuilder.append(this.e);
    stringBuilder.append(", lastUpdateUtcMills=");
    stringBuilder.append(this.f);
    stringBuilder.append(", freshness=");
    stringBuilder.append(this.g);
    stringBuilder.append(", connected=");
    stringBuilder.append(this.h);
    stringBuilder.append('}');
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\loc\dd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */