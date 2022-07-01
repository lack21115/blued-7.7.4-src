package com.qq.e.comm.plugin.ab.f;

import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Pair;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.plugin.ab.j;
import com.qq.e.comm.plugin.util.ak;
import com.qq.e.comm.plugin.util.bb;
import com.qq.e.comm.util.GDTLogger;
import java.io.InputStream;

class g {
  public Pair<? extends InputStream, bb.a> a(boolean paramBoolean, Uri paramUri) {
    if (paramBoolean) {
      if (!j.e().a()) {
        ak.a("UnJsWebViewDelegate", "enableProxy == false");
        return null;
      } 
      bb.a a = bb.c(bb.a(paramUri));
      return new Pair(j.e().a(paramUri), a);
    } 
    return null;
  }
  
  public boolean a(String paramString) {
    if (!TextUtils.isEmpty(paramString) && !bb.a(paramString))
      try {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Try to open third party scheme: ");
        stringBuilder.append(paramString);
        GDTLogger.d(stringBuilder.toString());
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(paramString));
        intent.addFlags(268435456);
        GDTADManager.getInstance().getAppContext().startActivity(intent);
        return true;
      } catch (Exception exception) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Open third party scheme exception: ");
        stringBuilder.append(exception.getMessage());
        GDTLogger.d(stringBuilder.toString());
        com.qq.e.comm.plugin.c.g.a(1, exception, null);
        return true;
      }  
    return false;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\ab\f\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */