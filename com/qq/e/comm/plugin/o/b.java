package com.qq.e.comm.plugin.o;

import android.content.Intent;
import android.os.Parcelable;
import com.qq.e.ads.hybrid.HybridADListener;
import com.qq.e.ads.hybrid.HybridADSetting;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.pi.HADI;
import com.qq.e.comm.plugin.util.ak;
import com.qq.e.comm.plugin.util.at;
import com.qq.e.comm.plugin.util.y;
import com.qq.e.comm.plugin.y.u;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class b implements HADI {
  private static AtomicInteger a = new AtomicInteger();
  
  private static HashMap<Integer, WeakReference<HybridADListener>> b = new HashMap<Integer, WeakReference<HybridADListener>>();
  
  private final HybridADListener c;
  
  private final HybridADSetting d;
  
  private final int e;
  
  public b(HybridADSetting paramHybridADSetting, HybridADListener paramHybridADListener) {
    this.d = paramHybridADSetting;
    this.c = paramHybridADListener;
    this.e = a.incrementAndGet();
    b.put(Integer.valueOf(this.e), new WeakReference<HybridADListener>(paramHybridADListener));
  }
  
  static HybridADListener a(int paramInt) {
    WeakReference<HybridADListener> weakReference = b.get(Integer.valueOf(paramInt));
    return (weakReference != null) ? weakReference.get() : null;
  }
  
  public void loadUrl(String paramString) {
    ak.a("gdt_tag_callback", "loadUrl(url)");
    Intent intent = new Intent();
    intent.setClassName(GDTADManager.getInstance().getAppContext(), at.a());
    intent.addFlags(268435456);
    intent.putExtra("appid", GDTADManager.getInstance().getAppStatus().getAPPID());
    intent.putExtra("gdt_activity_delegate_name", "hybridADPage");
    intent.putExtra("id", this.e);
    HybridADSetting hybridADSetting2 = this.d;
    HybridADSetting hybridADSetting1 = hybridADSetting2;
    if (hybridADSetting2 == null)
      hybridADSetting1 = new HybridADSetting(); 
    intent.putExtra("setting", (Parcelable)hybridADSetting1);
    intent.putExtra("url", paramString);
    GDTADManager.getInstance().getAppContext().startActivity(intent);
    y.a(new Runnable(this) {
          public void run() {
            if (b.a(this.a) != null)
              b.a(this.a).onPageShow(); 
          }
        });
    u.a(21042, 1, null);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\o\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */