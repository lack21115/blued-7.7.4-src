package c.t.maploc.lite.tsa;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.Date;

final class z extends Handler {
  StringBuffer a = new StringBuffer(15360);
  
  public z(y paramy, Looper paramLooper) {
    super(paramLooper);
  }
  
  public final void handleMessage(Message paramMessage) {
    try {
      int i = paramMessage.what;
      if (i != 1) {
        if (i != 2) {
          if (i != 3) {
            if (i != 4) {
              if (i != 5)
                return; 
              return;
            } 
            return;
          } 
          StringBuffer stringBuffer = this.a;
          stringBuffer.append('$');
          stringBuffer.append((String)paramMessage.obj);
          return;
        } 
      } else {
        String str = this.a.toString();
        k k = (y.b()).b;
        this.a.setLength(0);
        StringBuffer stringBuffer = this.a;
        stringBuffer.append("LOC_CORE,");
        stringBuffer.append(y.a(this.b).format(new Date()));
        stringBuffer.append(',');
        stringBuffer.append(k.g());
        stringBuffer.append(',');
        stringBuffer.append(k.h());
        stringBuffer.append(',');
        stringBuffer.append(k.f().replaceAll(":", "").toUpperCase());
        stringBuffer.append(',');
        stringBuffer.append("Lite");
        if (!b.a(str))
          this.a.append(str); 
        y y1 = this.b;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(k.c);
        stringBuilder.append("_");
        stringBuilder.append(k.d);
        stringBuilder.append("_");
        stringBuilder.append(k.b);
        stringBuilder.append("_");
        stringBuilder.append(k.a);
        stringBuilder.append(',');
        stringBuilder.append(y.c());
        stringBuilder.append(',');
        stringBuilder.append((y.b()).b.g());
        stringBuilder.append(',');
        stringBuilder.append(Build.MODEL);
        stringBuilder.append(',');
        stringBuilder.append(Build.VERSION.SDK_INT);
        y1.a("SYSTEM", stringBuilder.toString());
      } 
      removeMessages(2);
      this.b.a("PERMISSION", y.a(y.d()));
      return;
    } finally {
      paramMessage = null;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\c\t\maploc\lite\tsa\z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */