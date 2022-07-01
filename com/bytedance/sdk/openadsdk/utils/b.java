package com.bytedance.sdk.openadsdk.utils;

import android.content.Context;
import android.content.Intent;

public class b {
  public static void a(Context paramContext, Intent paramIntent, a parama) {
    if (paramContext != null) {
      if (paramIntent == null)
        return; 
      try {
        if (!(paramContext instanceof android.app.Activity))
          paramIntent.addFlags(268435456); 
        paramContext.startActivity(paramIntent);
      } finally {
        paramContext = null;
      } 
    } 
  }
  
  public static interface a {
    void a();
    
    void a(Throwable param1Throwable);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsd\\utils\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */