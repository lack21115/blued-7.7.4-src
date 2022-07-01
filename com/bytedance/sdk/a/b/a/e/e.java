package com.bytedance.sdk.a.b.a.e;

import com.bytedance.sdk.a.a.f;
import com.bytedance.sdk.a.b.a.c;
import java.io.IOException;

public final class e {
  static final f a = f.a("PRI * HTTP/2.0\r\n\r\nSM\r\n\r\n");
  
  static final String[] b;
  
  static final String[] c;
  
  private static final String[] d = new String[] { "DATA", "HEADERS", "PRIORITY", "RST_STREAM", "SETTINGS", "PUSH_PROMISE", "PING", "GOAWAY", "WINDOW_UPDATE", "CONTINUATION" };
  
  static {
    b = new String[64];
    c = new String[256];
    boolean bool = false;
    int i = 0;
    while (true) {
      String[] arrayOfString1 = c;
      if (i < arrayOfString1.length) {
        arrayOfString1[i] = c.a("%8s", new Object[] { Integer.toBinaryString(i) }).replace(' ', '0');
        i++;
        continue;
      } 
      String[] arrayOfString2 = b;
      arrayOfString2[0] = "";
      arrayOfString2[1] = "END_STREAM";
      int[] arrayOfInt1 = new int[1];
      arrayOfInt1[0] = 1;
      arrayOfString2[8] = "PADDED";
      int j = arrayOfInt1.length;
      for (i = 0; i < j; i++) {
        int m = arrayOfInt1[i];
        arrayOfString2 = b;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(b[m]);
        stringBuilder.append("|PADDED");
        arrayOfString2[m | 0x8] = stringBuilder.toString();
      } 
      arrayOfString2 = b;
      arrayOfString2[4] = "END_HEADERS";
      arrayOfString2[32] = "PRIORITY";
      arrayOfString2[36] = "END_HEADERS|PRIORITY";
      int[] arrayOfInt2 = new int[3];
      arrayOfInt2[0] = 4;
      arrayOfInt2[1] = 32;
      arrayOfInt2[2] = 36;
      int k = arrayOfInt2.length;
      i = 0;
      while (true) {
        j = bool;
        if (i < k) {
          int m = arrayOfInt2[i];
          int n = arrayOfInt1.length;
          for (j = 0; j < n; j++) {
            int i1 = arrayOfInt1[j];
            String[] arrayOfString = b;
            int i2 = i1 | m;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(b[i1]);
            stringBuilder.append('|');
            stringBuilder.append(b[m]);
            arrayOfString[i2] = stringBuilder.toString();
            arrayOfString = b;
            stringBuilder = new StringBuilder();
            stringBuilder.append(b[i1]);
            stringBuilder.append('|');
            stringBuilder.append(b[m]);
            stringBuilder.append("|PADDED");
            arrayOfString[i2 | 0x8] = stringBuilder.toString();
          } 
          i++;
          continue;
        } 
        break;
      } 
      while (true) {
        String[] arrayOfString = b;
        if (j < arrayOfString.length) {
          if (arrayOfString[j] == null)
            arrayOfString[j] = c[j]; 
          j++;
          continue;
        } 
        break;
      } 
      return;
    } 
  }
  
  static IllegalArgumentException a(String paramString, Object... paramVarArgs) {
    throw new IllegalArgumentException(c.a(paramString, paramVarArgs));
  }
  
  static String a(byte paramByte1, byte paramByte2) {
    if (paramByte2 == 0)
      return ""; 
    if (paramByte1 != 2 && paramByte1 != 3)
      if (paramByte1 != 4 && paramByte1 != 6) {
        if (paramByte1 != 7 && paramByte1 != 8) {
          String str;
          String[] arrayOfString = b;
          if (paramByte2 < arrayOfString.length) {
            str = arrayOfString[paramByte2];
          } else {
            str = c[paramByte2];
          } 
          return (paramByte1 == 5 && (paramByte2 & 0x4) != 0) ? str.replace("HEADERS", "PUSH_PROMISE") : ((paramByte1 == 0 && (paramByte2 & 0x20) != 0) ? str.replace("PRIORITY", "COMPRESSED") : str);
        } 
      } else {
        return (paramByte2 == 1) ? "ACK" : c[paramByte2];
      }  
    return c[paramByte2];
  }
  
  static String a(boolean paramBoolean, int paramInt1, int paramInt2, byte paramByte1, byte paramByte2) {
    String str1;
    String str2;
    String[] arrayOfString = d;
    if (paramByte1 < arrayOfString.length) {
      str1 = arrayOfString[paramByte1];
    } else {
      str1 = c.a("0x%02x", new Object[] { Byte.valueOf(paramByte1) });
    } 
    String str3 = a(paramByte1, paramByte2);
    if (paramBoolean) {
      str2 = "<<";
    } else {
      str2 = ">>";
    } 
    return c.a("%s 0x%08x %5d %-13s %s", new Object[] { str2, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), str1, str3 });
  }
  
  static IOException b(String paramString, Object... paramVarArgs) throws IOException {
    throw new IOException(c.a(paramString, paramVarArgs));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\a\b\a\e\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */