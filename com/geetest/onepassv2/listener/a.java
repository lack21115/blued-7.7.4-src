package com.geetest.onepassv2.listener;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.geetest.onelogin.j.h;
import org.json.JSONObject;

public class a {
  private static Handler a = new Handler(Looper.getMainLooper()) {
      public void handleMessage(Message param1Message) {
        super.handleMessage(param1Message);
      }
    };
  
  public static void a(OnePassListener paramOnePassListener, com.geetest.onepassv2.a.a parama) {
    try {
      JSONObject jSONObject = com.geetest.onepassv2.d.a.a(parama);
      if (a()) {
        c(paramOnePassListener, jSONObject);
        return;
      } 
      a.post(new Runnable(paramOnePassListener, jSONObject) {
            public void run() {
              a.a(this.a, this.b);
            }
          });
      return;
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("提交 onTokenSuccess 接口时发生错误,错误信息为: ");
      stringBuilder.append(exception.toString());
      h.c(stringBuilder.toString());
      return;
    } 
  }
  
  public static void a(OnePassListener paramOnePassListener, String paramString1, String paramString2, com.geetest.onepassv2.a.a parama) {
    try {
      e(paramOnePassListener, com.geetest.onepassv2.d.a.a(paramString1, com.geetest.onepassv2.d.a.a(paramString2), parama));
      return;
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("提交 onTokenFail 接口时发生错误,错误信息为: ");
      stringBuilder.append(exception.toString());
      h.c(stringBuilder.toString());
      return;
    } 
  }
  
  public static void a(OnePassListener paramOnePassListener, String paramString, JSONObject paramJSONObject, com.geetest.onepassv2.a.a parama) {
    try {
      e(paramOnePassListener, com.geetest.onepassv2.d.a.a(paramString, paramJSONObject, parama));
      return;
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("提交 onTokenFail 接口时发生错误,错误信息为: ");
      stringBuilder.append(exception.toString());
      h.c(stringBuilder.toString());
      return;
    } 
  }
  
  private static boolean a() {
    return (Looper.getMainLooper() == Looper.myLooper());
  }
  
  private static void c(OnePassListener paramOnePassListener, JSONObject paramJSONObject) {
    try {
      paramOnePassListener.onTokenSuccess(paramJSONObject);
      return;
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("提交 onTokenSuccess 接口时发生错误,错误信息为: ");
      stringBuilder.append(exception.toString());
      h.c(stringBuilder.toString());
      return;
    } 
  }
  
  private static void d(OnePassListener paramOnePassListener, JSONObject paramJSONObject) {
    try {
      paramOnePassListener.onTokenFail(paramJSONObject);
      return;
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("提交 onTokenFail 接口时发生错误,错误信息为: ");
      stringBuilder.append(exception.toString());
      h.c(stringBuilder.toString());
      return;
    } 
  }
  
  private static void e(OnePassListener paramOnePassListener, JSONObject paramJSONObject) {
    if (a()) {
      d(paramOnePassListener, paramJSONObject);
      return;
    } 
    a.post(new Runnable(paramOnePassListener, paramJSONObject) {
          public void run() {
            a.b(this.a, this.b);
          }
        });
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\geetest\onepassv2\listener\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */