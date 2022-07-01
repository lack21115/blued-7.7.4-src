package com.geetest.onelogin.h;

import android.content.Context;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.geetest.onelogin.j.c;
import com.geetest.onelogin.j.g;
import com.geetest.onelogin.listener.e;
import com.geetest.sdk.GT3ConfigBean;
import com.geetest.sdk.GT3ErrorBean;
import com.geetest.sdk.GT3GeetestUtils;
import com.geetest.sdk.GT3Listener;
import org.json.JSONObject;

public class b {
  private int a = 10000;
  
  private String b;
  
  private String c;
  
  private GT3GeetestUtils d;
  
  private GT3ConfigBean e;
  
  private Context f;
  
  private e g;
  
  private boolean h = false;
  
  public void a() {
    if (this.h)
      return; 
    this.h = true;
    this.e = new GT3ConfigBean();
    this.e.setPattern(1);
    this.e.setCanceledOnTouchOutside(false);
    this.e.setLang(null);
    this.e.setTimeout(this.a);
    this.e.setWebviewTimeout(this.a);
    this.e.setListener(new GT3Listener(this) {
          public void onApi1Result(String param1String) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("GT3BaseListener-->onApi1Result-->");
            stringBuilder.append(param1String);
            c.a(stringBuilder.toString());
          }
          
          public void onApi2Result(String param1String) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("GT3BaseListener-->onApi2Result-->");
            stringBuilder.append(param1String);
            c.a(stringBuilder.toString());
          }
          
          public void onButtonClick() {
            c.a("GT3BaseListener-->onButtonClick");
            (new b.a(this.a)).execute((Object[])new Void[0]);
          }
          
          public void onClosed(int param1Int) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("GT3BaseListener-->onClosed-->");
            stringBuilder.append(param1Int);
            c.a(stringBuilder.toString());
            b.a(this.a, false);
          }
          
          public void onDialogReady(String param1String) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("GT3BaseListener-->onDialogReady-->");
            stringBuilder.append(param1String);
            c.a(stringBuilder.toString());
          }
          
          public void onDialogResult(String param1String) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("GT3BaseListener-->onDialogResult-->");
            stringBuilder.append(param1String);
            c.a(stringBuilder.toString());
            (new b.b(this.a)).execute((Object[])new String[] { param1String });
          }
          
          public void onFailed(GT3ErrorBean param1GT3ErrorBean) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("GT3BaseListener-->onFailed-->");
            stringBuilder.append(param1GT3ErrorBean.toString());
            c.a(stringBuilder.toString());
            if (b.a(this.a) != null)
              b.a(this.a).b(); 
            b.a(this.a, false);
          }
          
          public void onStatistics(String param1String) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("GT3BaseListener-->onStatistics-->");
            stringBuilder.append(param1String);
            c.a(stringBuilder.toString());
          }
          
          public void onSuccess(String param1String) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("GT3BaseListener-->onSuccess-->");
            stringBuilder.append(param1String);
            c.a(stringBuilder.toString());
            if (b.a(this.a) != null)
              b.a(this.a).a(); 
            b.a(this.a, false);
          }
        });
    this.d.init(this.e);
    this.d.startCustomFlow();
  }
  
  public void a(Context paramContext, String paramString1, String paramString2, int paramInt, e parame) {
    this.d = new GT3GeetestUtils(paramContext);
    this.f = paramContext;
    this.b = paramString1;
    this.c = paramString2;
    this.a = paramInt;
    this.g = parame;
  }
  
  class a extends AsyncTask<Void, Void, JSONObject> {
    a(b this$0) {}
    
    protected JSONObject a(Void... param1VarArgs) {
      String str = g.a(b.b(this.a), b.c(this.a));
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("doInBackground: ");
      stringBuilder.append(str);
      c.a(stringBuilder.toString());
      try {
        return new JSONObject(str);
      } catch (Exception exception) {
        exception.printStackTrace();
        return null;
      } 
    }
    
    protected void a(JSONObject param1JSONObject) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("RequestAPI1-->onPostExecute: ");
      stringBuilder.append(param1JSONObject);
      c.a(stringBuilder.toString());
      b.d(this.a).setApi1Json(param1JSONObject);
      b.e(this.a).getGeetest();
    }
  }
  
  class b extends AsyncTask<String, Void, String> {
    b(b this$0) {}
    
    protected String a(String... param1VarArgs) {
      return !TextUtils.isEmpty(param1VarArgs[0]) ? g.a(b.f(this.a), param1VarArgs[0], b.c(this.a)) : null;
    }
    
    protected void a(String param1String) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("RequestAPI2-->onPostExecute: ");
      stringBuilder.append(param1String);
      c.a(stringBuilder.toString());
      if (!TextUtils.isEmpty(param1String))
        try {
          if ("success".equals((new JSONObject(param1String)).getString("status"))) {
            b.e(this.a).showSuccessDialog();
            return;
          } 
          b.e(this.a).showFailedDialog();
          return;
        } catch (Exception exception) {
          b.e(this.a).showFailedDialog();
          exception.printStackTrace();
          return;
        }  
      b.e(this.a).showFailedDialog();
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\geetest\onelogin\h\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */