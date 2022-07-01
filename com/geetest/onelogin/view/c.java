package com.geetest.onelogin.view;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import com.geetest.onelogin.j.e;
import com.geetest.onelogin.j.f;

public class c {
  private View a;
  
  private f b;
  
  public c(View paramView) {
    this.a = paramView;
  }
  
  public void a(Context paramContext, String paramString) {
    if (TextUtils.isEmpty(paramString))
      return; 
    try {
      int i = a.b(paramString, paramContext);
      paramString = e.a(paramContext.getResources().openRawResource(i));
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("loading image type:");
      stringBuilder.append(paramString);
      com.geetest.onelogin.j.c.a(stringBuilder.toString());
      if (e.a(paramString)) {
        this.b = new f();
        this.b.a(paramContext, i);
        this.b.a(this.a);
        return;
      } 
      View view = this.a;
      if (view instanceof ImageView) {
        ((ImageView)view).setImageResource(i);
        return;
      } 
      view.setBackgroundResource(i);
      return;
    } catch (Exception exception) {
      exception.printStackTrace();
      return;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\geetest\onelogin\view\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */