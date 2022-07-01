package com.qq.e.comm.plugin.m;

import android.content.Context;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.View;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.plugin.ac.e;
import com.qq.e.comm.plugin.ad.f;
import com.qq.e.comm.plugin.ad.g;
import com.qq.e.comm.plugin.s.a;
import com.qq.e.comm.plugin.s.c;
import com.qq.e.comm.plugin.util.b;
import com.qq.e.comm.util.GDTLogger;

class d {
  private static f a(View paramView) {
    if (paramView != null) {
      Rect rect = new Rect();
      if (paramView.getGlobalVisibleRect(rect))
        return new f(true, paramView.getWidth(), paramView.getHeight(), rect.width(), rect.height(), paramView.toString()); 
      GDTLogger.d("Ad is not visible.");
    } 
    return null;
  }
  
  static com.qq.e.comm.plugin.w.a.d.b a(int paramInt1, int paramInt2, a parama, View paramView, String paramString, int paramInt3) {
    com.qq.e.comm.plugin.w.a.d.c c;
    int j = GDTADManager.getInstance().getSM().getIntegerForPlacement("download_confirm", parama.B(), 0);
    if (paramView != null) {
      f f = a(paramView);
    } else {
      GDTLogger.e("ExpressAdUtil: AD view is null");
      paramView = null;
    } 
    boolean bool = com.qq.e.comm.plugin.util.d.a(parama);
    int i = paramInt2;
    if (paramInt2 == -1)
      if (bool && !b.d(parama)) {
        i = 1;
      } else {
        i = 0;
      }  
    if (parama.a_() == 48)
      i = 48; 
    if (paramInt3 == 2) {
      c = com.qq.e.comm.plugin.w.a.d.c.b;
    } else {
      c = com.qq.e.comm.plugin.w.a.d.c.a;
    } 
    return (new com.qq.e.comm.plugin.w.a.d.b(i, c)).a(paramInt1).a(paramString).b(j).a((f)paramView);
  }
  
  static String a(String paramString) {
    return g.a(paramString);
  }
  
  static void a(Context paramContext, a parama) {
    c c = parama.l();
    if (c == null)
      return; 
    String str = c.c();
    if (!TextUtils.isEmpty(str))
      (new e(paramContext)).a(str); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\m\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */