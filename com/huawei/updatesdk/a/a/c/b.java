package com.huawei.updatesdk.a.a.c;

import java.io.UnsupportedEncodingException;

public class b {
  private byte[] a = null;
  
  private int b = 1024;
  
  private int c = 0;
  
  public b() {
    this.a = new byte[this.b];
  }
  
  public static String a(byte[] paramArrayOfbyte) {
    char[] arrayOfChar1 = new char[16];
    arrayOfChar1[0] = '0';
    arrayOfChar1[1] = '1';
    arrayOfChar1[2] = '2';
    arrayOfChar1[3] = '3';
    arrayOfChar1[4] = '4';
    arrayOfChar1[5] = '5';
    arrayOfChar1[6] = '6';
    arrayOfChar1[7] = '7';
    arrayOfChar1[8] = '8';
    arrayOfChar1[9] = '9';
    arrayOfChar1[10] = 'A';
    arrayOfChar1[11] = 'B';
    arrayOfChar1[12] = 'C';
    arrayOfChar1[13] = 'D';
    arrayOfChar1[14] = 'E';
    arrayOfChar1[15] = 'F';
    char[] arrayOfChar2 = new char[paramArrayOfbyte.length * 2];
    int k = paramArrayOfbyte.length;
    int i = 0;
    int j = 0;
    while (i < k) {
      byte b1 = paramArrayOfbyte[i];
      int m = j + 1;
      arrayOfChar2[j] = arrayOfChar1[b1 >>> 4 & 0xF];
      j = m + 1;
      arrayOfChar2[m] = arrayOfChar1[b1 & 0xF];
      i++;
    } 
    return String.valueOf(arrayOfChar2);
  }
  
  public String a() {
    int i = this.c;
    if (i <= 0)
      return null; 
    try {
      return new String(this.a, 0, i, "UTF-8");
    } catch (UnsupportedEncodingException unsupportedEncodingException) {
      return null;
    } 
  }
  
  public void a(byte[] paramArrayOfbyte, int paramInt) {
    if (paramInt <= 0)
      return; 
    byte[] arrayOfByte = this.a;
    int i = arrayOfByte.length;
    int j = this.c;
    if (i - j >= paramInt) {
      System.arraycopy(paramArrayOfbyte, 0, arrayOfByte, j, paramInt);
    } else {
      byte[] arrayOfByte1 = new byte[arrayOfByte.length + paramInt << 1];
      System.arraycopy(arrayOfByte, 0, arrayOfByte1, 0, j);
      System.arraycopy(paramArrayOfbyte, 0, arrayOfByte1, this.c, paramInt);
      this.a = arrayOfByte1;
    } 
    this.c += paramInt;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawe\\updatesdk\a\a\c\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */