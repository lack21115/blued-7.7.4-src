package com.huawei.secure.android.common.ssl.util;

import android.content.Context;
import android.os.AsyncTask;
import com.huawei.secure.android.common.ssl.SSFSecureX509SingleInstance;
import java.io.InputStream;

public class e extends AsyncTask<Context, Integer, InputStream> {
  private static final String a = e.class.getSimpleName();
  
  protected InputStream a(Context... paramVarArgs) {
    long l = System.currentTimeMillis();
    try {
      InputStream inputStream = BksUtil.a(paramVarArgs[0]);
    } catch (Exception exception) {
      String str1 = a;
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("doInBackground: exception : ");
      stringBuilder1.append(exception.getMessage());
      g.d(str1, stringBuilder1.toString());
      exception = null;
    } 
    String str = a;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("doInBackground: get bks from hms tss cost : ");
    stringBuilder.append(System.currentTimeMillis() - l);
    stringBuilder.append(" ms");
    g.a(str, stringBuilder.toString());
    return (InputStream)exception;
  }
  
  protected void a(InputStream paramInputStream) {
    String str = a;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("onPostExecute: current thread name is : ");
    stringBuilder.append(Thread.currentThread().getName());
    g.a(str, stringBuilder.toString());
    if (paramInputStream == null) {
      g.d(a, "get bks from tss error");
      return;
    } 
    SSFSecureX509SingleInstance.a(paramInputStream);
  }
  
  protected void a(Integer... paramVarArgs) {
    String str = a;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("onProgressUpdate: current thread name is : ");
    stringBuilder.append(Thread.currentThread().getName());
    g.b(str, stringBuilder.toString());
  }
  
  protected void onPreExecute() {
    String str = a;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("onPreExecute: current thread name is : ");
    stringBuilder.append(Thread.currentThread().getName());
    g.a(str, stringBuilder.toString());
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\secure\android\common\ss\\util\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */