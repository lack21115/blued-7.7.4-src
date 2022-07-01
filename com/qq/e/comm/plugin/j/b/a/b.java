package com.qq.e.comm.plugin.j.b.a;

import android.text.TextUtils;
import com.qq.e.comm.plugin.t.j;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class b {
  private final int a;
  
  private final int b;
  
  private final boolean c;
  
  public b(int paramInt1, int paramInt2, boolean paramBoolean) {
    this.a = paramInt1;
    this.b = paramInt2;
    this.c = paramBoolean;
  }
  
  private String a(long paramLong1, long paramLong2) {
    if (paramLong1 >= 0L) {
      if (paramLong2 > 0L) {
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("bytes=");
        stringBuilder1.append(paramLong1);
        stringBuilder1.append("-");
        stringBuilder1.append(paramLong1 + paramLong2 - 1L);
        return stringBuilder1.toString();
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("bytes=");
      stringBuilder.append(paramLong1);
      stringBuilder.append("-");
      return stringBuilder.toString();
    } 
    return null;
  }
  
  private HttpURLConnection b(String paramString, long paramLong1, long paramLong2) throws IOException {
    HttpURLConnection httpURLConnection = (HttpURLConnection)(new URL(paramString)).openConnection();
    httpURLConnection.setRequestProperty("User-Agent", j.a);
    httpURLConnection.setConnectTimeout(this.a);
    httpURLConnection.setReadTimeout(this.b);
    if (this.c) {
      String str = a(paramLong1, paramLong2);
      if (!TextUtils.isEmpty(str))
        httpURLConnection.setRequestProperty("Range", str); 
    } 
    return httpURLConnection;
  }
  
  public a a(String paramString, long paramLong1, long paramLong2) throws IOException {
    return new a(b(paramString, paramLong1, paramLong2), 0, null);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\j\b\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */