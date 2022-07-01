package com.bytedance.sdk.openadsdk.utils;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import com.bytedance.sdk.openadsdk.g.a.b;
import com.bytedance.sdk.openadsdk.g.e;

public class n {
  public static Drawable a(byte[] paramArrayOfbyte, int paramInt) {
    if (paramArrayOfbyte == null || paramArrayOfbyte.length <= 0)
      return (Drawable)new ColorDrawable(0); 
    try {
      return (Drawable)new BitmapDrawable(BitmapFactory.decodeByteArray(paramArrayOfbyte, 0, paramArrayOfbyte.length));
    } finally {
      paramArrayOfbyte = null;
    } 
  }
  
  public static void a(Context paramContext, String paramString, int paramInt, a parama) {
    e.a(paramContext).f().a(paramString, new b.b(parama) {
          public void a() {}
          
          public void a(b.c param1c) {}
          
          public void a(String param1String, byte[] param1ArrayOfbyte) {
            if (param1ArrayOfbyte != null && param1ArrayOfbyte.length > 0 && this.a != null) {
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("图片数据返回成功");
              stringBuilder.append(param1ArrayOfbyte.length);
              t.b("ImageBytesHelper: ", stringBuilder.toString());
              this.a.a(param1ArrayOfbyte);
              return;
            } 
            n.a a1 = this.a;
            if (a1 != null)
              a1.a(); 
          }
          
          public void b(b.c param1c) {
            n.a a1 = this.a;
            if (a1 != null)
              a1.a(); 
          }
        }paramInt, paramInt);
  }
  
  public static interface a {
    void a();
    
    void a(byte[] param1ArrayOfbyte);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsd\\utils\n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */