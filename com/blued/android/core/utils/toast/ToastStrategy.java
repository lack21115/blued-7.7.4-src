package com.blued.android.core.utils.toast;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentHashMap;

public class ToastStrategy extends Handler implements IToastStrategy {
  private volatile ArrayBlockingQueue<CharSequence> a = new ArrayBlockingQueue<CharSequence>(3);
  
  private volatile ConcurrentHashMap<CharSequence, Integer> b = new ConcurrentHashMap<CharSequence, Integer>(3);
  
  private volatile boolean c;
  
  private Toast d;
  
  public ToastStrategy() {
    super(Looper.getMainLooper());
  }
  
  private static boolean a() {
    String str1 = Build.MANUFACTURER;
    String str2 = Build.BRAND;
    String str3 = Build.MODEL;
    return ((Build.VERSION.SDK_INT == 25 && !TextUtils.isEmpty(str3) && str3.toLowerCase().contains("redmi")) || (Build.VERSION.SDK_INT >= 27 && (a(str1, "huawei") || a(str2, "huawei") || a(str2, "honor"))));
  }
  
  private static boolean a(String paramString1, String paramString2) {
    return (!TextUtils.isEmpty(paramString1) && paramString1.equalsIgnoreCase(paramString2));
  }
  
  public void a(Toast paramToast) {
    this.d = paramToast;
  }
  
  public void a(CharSequence paramCharSequence, int paramInt) {
    if (this.a.isEmpty() || !this.a.contains(paramCharSequence)) {
      if (!this.a.offer(paramCharSequence)) {
        this.a.poll();
        this.a.offer(paramCharSequence);
      } 
      this.b.put(paramCharSequence, Integer.valueOf(paramInt));
    } 
    if (!this.c) {
      this.c = true;
      sendEmptyMessage(1);
    } 
  }
  
  public void handleMessage(Message paramMessage) {
    int i = paramMessage.what;
    if (i != 1) {
      if (i != 2) {
        if (i != 3)
          return; 
        this.c = false;
        this.a.clear();
        this.b.clear();
        this.d.cancel();
        return;
      } 
      this.b.remove(this.a.poll());
      if (this.a.isEmpty()) {
        this.c = false;
        return;
      } 
      sendEmptyMessage(1);
      return;
    } 
    CharSequence charSequence = this.a.peek();
    if (charSequence != null) {
      i = ((Integer)this.b.get(charSequence)).intValue();
      if (a()) {
        Toast toast = this.d;
        toast.setView((View)ToastUtils.a(toast.getView().getContext().getApplicationContext()));
      } 
      this.d.setText(charSequence);
      this.d.setDuration(i);
      this.d.show();
      if (i == 0) {
        i = 2000;
      } else {
        i = 3500;
      } 
      sendEmptyMessageDelayed(2, (i + 300));
      return;
    } 
    this.c = false;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\cor\\utils\toast\ToastStrategy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */