package com.cmic.sso.sdk.utils.a;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PushbackInputStream;

public class a extends d {
  static {
    byte b = 0;
    int i = 0;
    while (true) {
      j = b;
      if (i < 255) {
        c[i] = -1;
        i++;
        continue;
      } 
      break;
    } 
    while (true) {
      char[] arrayOfChar = b;
      if (j < arrayOfChar.length) {
        c[arrayOfChar[j]] = (byte)j;
        j++;
        continue;
      } 
      break;
    } 
  }
  
  protected int a() {
    return 4;
  }
  
  protected void a(PushbackInputStream paramPushbackInputStream, OutputStream paramOutputStream, int paramInt) throws IOException {
    if (paramInt >= 2)
      while (true) {
        byte b2;
        int j;
        int i = paramPushbackInputStream.read();
        byte b1 = -1;
        if (i != -1) {
          if (i != 10 && i != 13) {
            byte[] arrayOfByte = this.a;
            arrayOfByte[0] = (byte)i;
            if (a(paramPushbackInputStream, arrayOfByte, 1, paramInt - 1) != -1) {
              i = paramInt;
              if (paramInt > 3) {
                i = paramInt;
                if (this.a[3] == 61)
                  i = 3; 
              } 
              j = i;
              if (i > 2) {
                j = i;
                if (this.a[2] == 61)
                  j = 2; 
              } 
              if (j != 2) {
                if (j != 3) {
                  if (j != 4) {
                    i = -1;
                    paramInt = b1;
                  } else {
                    byte[] arrayOfByte1 = c;
                    arrayOfByte = this.a;
                    b1 = arrayOfByte1[arrayOfByte[3] & 0xFF];
                    byte b = arrayOfByte1[arrayOfByte[2] & 0xFF];
                    i = arrayOfByte1[arrayOfByte[1] & 0xFF];
                    paramInt = arrayOfByte1[arrayOfByte[0] & 0xFF];
                    if (j != 2) {
                      if (j != 3) {
                        if (j != 4)
                          return; 
                        paramOutputStream.write((byte)(paramInt << 2 & 0xFC | i >>> 4 & 0x3));
                        paramOutputStream.write((byte)(i << 4 & 0xF0 | b >>> 2 & 0xF));
                        paramOutputStream.write((byte)(b << 6 & 0xC0 | b1 & 0x3F));
                        return;
                      } 
                      paramOutputStream.write((byte)(paramInt << 2 & 0xFC | 0x3 & i >>> 4));
                      paramOutputStream.write((byte)(i << 4 & 0xF0 | b >>> 2 & 0xF));
                      return;
                    } 
                  } 
                } else {
                  byte[] arrayOfByte1 = c;
                  arrayOfByte = this.a;
                  byte b = arrayOfByte1[arrayOfByte[2] & 0xFF];
                  i = arrayOfByte1[arrayOfByte[1] & 0xFF];
                  paramInt = arrayOfByte1[arrayOfByte[0] & 0xFF];
                  b1 = -1;
                  if (j != 2) {
                    if (j != 3) {
                      if (j != 4)
                        return; 
                      paramOutputStream.write((byte)(paramInt << 2 & 0xFC | i >>> 4 & 0x3));
                      paramOutputStream.write((byte)(i << 4 & 0xF0 | b >>> 2 & 0xF));
                      paramOutputStream.write((byte)(b << 6 & 0xC0 | b1 & 0x3F));
                      return;
                    } 
                    paramOutputStream.write((byte)(paramInt << 2 & 0xFC | 0x3 & i >>> 4));
                    paramOutputStream.write((byte)(i << 4 & 0xF0 | b >>> 2 & 0xF));
                    return;
                  } 
                } 
              } else {
                byte[] arrayOfByte1 = c;
                arrayOfByte = this.a;
                i = arrayOfByte1[arrayOfByte[1] & 0xFF];
                paramInt = arrayOfByte1[arrayOfByte[0] & 0xFF];
              } 
              b1 = -1;
              b2 = -1;
            } else {
              throw new c();
            } 
          } else {
            continue;
          } 
        } else {
          throw new c();
        } 
        if (j != 2) {
          if (j != 3) {
            if (j != 4)
              return; 
            paramOutputStream.write((byte)(paramInt << 2 & 0xFC | i >>> 4 & 0x3));
            paramOutputStream.write((byte)(i << 4 & 0xF0 | b2 >>> 2 & 0xF));
            paramOutputStream.write((byte)(b2 << 6 & 0xC0 | b1 & 0x3F));
            return;
          } 
          paramOutputStream.write((byte)(paramInt << 2 & 0xFC | 0x3 & i >>> 4));
          paramOutputStream.write((byte)(i << 4 & 0xF0 | b2 >>> 2 & 0xF));
          return;
        } 
      }  
    throw new b("BASE64Decoder: Not enough bytes for an atom.");
  }
  
  protected int b() {
    return 72;
  }
  
  static {
    int j;
  }
  
  private static final char[] b = new char[] { 
      'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 
      'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 
      'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 
      'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 
      'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 
      'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', 
      '8', '9', '+', '/' };
  
  private static final byte[] c = new byte[256];
  
  byte[] a = new byte[4];
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\cmic\sso\sd\\utils\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */