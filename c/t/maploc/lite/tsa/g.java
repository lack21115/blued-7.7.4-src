package c.t.maploc.lite.tsa;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.map.geoloclite.tsa.TencentLiteLocationListener;

final class g extends Handler {
  g(c paramc, Looper paramLooper) {
    super(paramLooper);
  }
  
  public final void handleMessage(Message paramMessage) {
    byte[] arrayOfByte;
    String str;
    synchronized (c.n(this.a)) {
      Bundle bundle;
      TencentLiteLocationListener tencentLiteLocationListener = c.o(this.a);
      if (tencentLiteLocationListener == null)
        return; 
      switch (paramMessage.what) {
        default:
          return;
        case 1003:
          bundle = paramMessage.getData();
          if (bundle != null) {
            String str1 = bundle.getString("name");
            int i = bundle.getInt("status");
            str = bundle.getString("desc");
            if (tencentLiteLocationListener != null && str1 != null && str != null) {
              tencentLiteLocationListener.onStatusUpdate(str1, i, str);
              return;
            } 
          } 
          return;
        case 1002:
          if (c.m(this.a) != null && tencentLiteLocationListener != null) {
            tencentLiteLocationListener.onLocationChanged(c.m(this.a), c.d(this.a), (String)c.a().get(c.d(this.a)));
            return;
          } 
          return;
        case 1001:
          break;
      } 
      if (c.m(this.a) != null && c.f(this.a) > 0L && tencentLiteLocationListener != null)
        tencentLiteLocationListener.onLocationChanged(c.m(this.a), c.d(this.a), (String)c.a().get(c.d(this.a))); 
      if (c.f(this.a) > 0L)
        sendEmptyMessageDelayed(1001, c.f(this.a)); 
      return;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\c\t\maploc\lite\tsa\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */