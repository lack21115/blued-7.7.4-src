package com.blued.android.framework;

import java.util.ArrayList;

public class Hashids {
  private String a = "";
  
  private String b = "";
  
  private String c = "cfhistuCFHISTU";
  
  private int d = 0;
  
  private String e;
  
  public Hashids() {
    this("");
  }
  
  public Hashids(String paramString) {
    this(paramString, 0);
  }
  
  public Hashids(String paramString, int paramInt) {
    this(paramString, paramInt, "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ123567890");
  }
  
  public Hashids(String paramString1, int paramInt, String paramString2) {
    this.a = paramString1;
    if (paramInt < 0) {
      this.d = 0;
    } else {
      this.d = paramInt;
    } 
    this.b = paramString2;
    paramString1 = "";
    paramInt = 0;
    while (paramInt < this.b.length()) {
      String str;
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("");
      stringBuilder1.append(this.b.charAt(paramInt));
      paramString2 = paramString1;
      if (!paramString1.contains(stringBuilder1.toString())) {
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(paramString1);
        stringBuilder2.append("");
        stringBuilder2.append(this.b.charAt(paramInt));
        str = stringBuilder2.toString();
      } 
      paramInt++;
      paramString1 = str;
    } 
    this.b = paramString1;
    if (this.b.length() >= 16) {
      if (!this.b.contains(" ")) {
        for (paramInt = 0; paramInt < this.c.length(); paramInt++) {
          int i = this.b.indexOf(this.c.charAt(paramInt));
          if (i == -1) {
            StringBuilder stringBuilder1 = new StringBuilder();
            stringBuilder1.append(this.c.substring(0, paramInt));
            stringBuilder1.append(" ");
            stringBuilder1.append(this.c.substring(paramInt + 1));
            this.c = stringBuilder1.toString();
          } else {
            StringBuilder stringBuilder1 = new StringBuilder();
            stringBuilder1.append(this.b.substring(0, i));
            stringBuilder1.append(" ");
            stringBuilder1.append(this.b.substring(i + 1));
            this.b = stringBuilder1.toString();
          } 
        } 
        this.b = this.b.replaceAll("\\s+", "");
        this.c = this.c.replaceAll("\\s+", "");
        this.c = b(this.c, this.a);
        if (this.c.equals("") || (this.b.length() / this.c.length()) > 3.5D) {
          int i = (int)Math.ceil(this.b.length() / 3.5D);
          paramInt = i;
          if (i == 1)
            paramInt = i + 1; 
          if (paramInt > this.c.length()) {
            paramInt -= this.c.length();
            StringBuilder stringBuilder1 = new StringBuilder();
            stringBuilder1.append(this.c);
            stringBuilder1.append(this.b.substring(0, paramInt));
            this.c = stringBuilder1.toString();
            this.b = this.b.substring(paramInt);
          } else {
            this.c = this.c.substring(0, paramInt);
          } 
        } 
        this.b = b(this.b, this.a);
        paramInt = (int)Math.ceil(this.b.length() / 12);
        if (this.b.length() < 3) {
          this.e = this.c.substring(0, paramInt);
          this.c = this.c.substring(paramInt);
          return;
        } 
        this.e = this.b.substring(0, paramInt);
        this.b = this.b.substring(paramInt);
        return;
      } 
      throw new IllegalArgumentException("alphabet cannot contains spaces");
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("alphabet must contain at least ");
    stringBuilder.append(16);
    stringBuilder.append(" unique characters");
    throw new IllegalArgumentException(stringBuilder.toString());
  }
  
  private String a(long paramLong, String paramString) {
    int i = paramString.length();
    char[] arrayOfChar = paramString.toCharArray();
    paramString = "";
    while (true) {
      StringBuilder stringBuilder = new StringBuilder();
      long l = i;
      stringBuilder.append(arrayOfChar[(int)(paramLong % l)]);
      stringBuilder.append(paramString);
      String str = stringBuilder.toString();
      l = paramLong / l;
      paramString = str;
      paramLong = l;
      if (l <= 0L)
        return str; 
    } 
  }
  
  private long[] a(String paramString1, String paramString2) {
    ArrayList<Long> arrayList = new ArrayList();
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append("[");
    stringBuilder1.append(this.e);
    stringBuilder1.append("]");
    String[] arrayOfString = paramString1.replaceAll(stringBuilder1.toString(), " ").split(" ");
    if (arrayOfString.length == 3 || arrayOfString.length == 2) {
      null = 1;
    } else {
      null = 0;
    } 
    String str = arrayOfString[null];
    char c = str.toCharArray()[0];
    str = str.substring(1);
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append("[");
    stringBuilder2.append(this.c);
    stringBuilder2.append("]");
    for (String str1 : str.replaceAll(stringBuilder2.toString(), " ").split(" ")) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(c);
      stringBuilder.append(this.a);
      stringBuilder.append(paramString2);
      paramString2 = b(paramString2, stringBuilder.toString().substring(0, paramString2.length()));
      arrayList.add(c(str1, paramString2));
    } 
    long[] arrayOfLong2 = new long[arrayList.size()];
    int i;
    for (i = 0; i < arrayOfLong2.length; i++)
      arrayOfLong2[i] = ((Long)arrayList.get(i)).longValue(); 
    long[] arrayOfLong1 = arrayOfLong2;
    if (!b(arrayOfLong2).equals(paramString1))
      arrayOfLong1 = new long[0]; 
    return arrayOfLong1;
  }
  
  private String b(String paramString1, String paramString2) {
    if (paramString2.length() <= 0)
      return paramString1; 
    char[] arrayOfChar = paramString2.toCharArray();
    int i = paramString1.length() - 1;
    int k = 0;
    int j = 0;
    while (i > 0) {
      k %= paramString2.length();
      char c2 = arrayOfChar[k];
      j += c2;
      int m = (c2 + k + j) % i;
      char c1 = paramString1.charAt(m);
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramString1.substring(0, m));
      stringBuilder.append(paramString1.charAt(i));
      stringBuilder.append(paramString1.substring(m + 1));
      paramString1 = stringBuilder.toString();
      stringBuilder = new StringBuilder();
      stringBuilder.append(paramString1.substring(0, i));
      stringBuilder.append(c1);
      stringBuilder.append(paramString1.substring(i + 1));
      paramString1 = stringBuilder.toString();
      i--;
      k++;
    } 
    return paramString1;
  }
  
  private String b(long... paramVarArgs) {
    int j = 0;
    int i = 0;
    while (j < paramVarArgs.length) {
      i = (int)(i + paramVarArgs[j] % (j + 100));
      j++;
    } 
    String str2 = this.b;
    char c = str2.toCharArray()[i % str2.length()];
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(c);
    stringBuilder.append("");
    String str3 = stringBuilder.toString();
    for (j = 0; j < paramVarArgs.length; j = k) {
      long l = paramVarArgs[j];
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(c);
      stringBuilder1.append(this.a);
      stringBuilder1.append(str2);
      str2 = b(str2, stringBuilder1.toString().substring(0, str2.length()));
      String str5 = a(l, str2);
      stringBuilder1 = new StringBuilder();
      stringBuilder1.append(str3);
      stringBuilder1.append(str5);
      String str4 = stringBuilder1.toString();
      int k = j + 1;
      str3 = str4;
      if (k < paramVarArgs.length) {
        j = (int)(l % (str5.toCharArray()[0] + j) % this.c.length());
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(str4);
        stringBuilder2.append(this.c.toCharArray()[j]);
        str3 = stringBuilder2.toString();
      } 
    } 
    String str1 = str3;
    if (str3.length() < this.d) {
      j = str3.toCharArray()[0];
      int k = this.e.length();
      c = this.e.toCharArray()[(j + i) % k];
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(c);
      stringBuilder1.append(str3);
      str3 = stringBuilder1.toString();
      String str = str3;
      if (str3.length() < this.d) {
        j = str3.toCharArray()[2];
        k = this.e.length();
        c = this.e.toCharArray()[(i + j) % k];
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(str3);
        stringBuilder2.append(c);
        str1 = stringBuilder2.toString();
      } 
    } 
    i = str2.length() / 2;
    while (str1.length() < this.d) {
      str2 = b(str2, str2);
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(str2.substring(i));
      stringBuilder1.append(str1);
      stringBuilder1.append(str2.substring(0, i));
      String str = stringBuilder1.toString();
      int k = str.length();
      j = this.d;
      k -= j;
      str1 = str;
      if (k > 0) {
        k /= 2;
        str1 = str.substring(k, j + k);
      } 
    } 
    return str1;
  }
  
  private Long c(String paramString1, String paramString2) {
    char[] arrayOfChar = paramString1.toCharArray();
    long l = 0L;
    for (int i = 0; i < paramString1.length(); i++) {
      long l1 = paramString2.indexOf(arrayOfChar[i]);
      l = (long)(l + l1 * Math.pow(paramString2.length(), (paramString1.length() - i - 1)));
    } 
    return Long.valueOf(l);
  }
  
  public String a(long... paramVarArgs) {
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j) {
      if (paramVarArgs[i] <= 9007199254740992L) {
        i++;
        continue;
      } 
      throw new IllegalArgumentException("number can not be greater than 9007199254740992L");
    } 
    return (paramVarArgs.length == 0) ? "" : b(paramVarArgs);
  }
  
  public long[] a(String paramString) {
    return paramString.equals("") ? new long[0] : a(paramString, this.b);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\framework\Hashids.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */