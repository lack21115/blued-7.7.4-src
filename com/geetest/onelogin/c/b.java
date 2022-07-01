package com.geetest.onelogin.c;

import android.content.Context;
import com.geetest.deepknow.DPAPI;
import com.geetest.deepknow.DPListener;
import com.geetest.onelogin.j.h;
import com.geetest.onelogin.j.p;
import org.json.JSONObject;

public class b {
  private static boolean a = false;
  
  public static void a(Context paramContext, boolean paramBoolean) {
    try {
      if (a && a.b())
        return; 
      if (!a)
        DPAPI.getInstance(paramContext, "6d4291cb7d2a8ecc871e67e2ec3b60ba"); 
      p.a().a("DPGetSessionId");
      DPListener dPListener = new DPListener() {
          public void onSessionResult(JSONObject param1JSONObject) {
            try {
              int i = param1JSONObject.getInt("status");
              if (i == 1) {
                a.a(param1JSONObject.getString("session_id"));
                h.b("DeepKnow: get sessionId success");
              } else {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("DeepKnow: get sessionId error, status: ");
                stringBuilder.append(i);
                h.b(stringBuilder.toString());
              } 
            } catch (Exception exception) {
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("DeepKnow: get sessionId error: ");
              stringBuilder.append(exception.getMessage());
              h.b(stringBuilder.toString());
            } 
            p.a().b("DPGetSessionId");
          }
          
          public void onSessionStatus(boolean param1Boolean) {}
        };
      DPAPI.getInstance(paramContext).getSessionStatus(dPListener);
      return;
    } finally {
      paramContext = null;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\geetest\onelogin\c\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */