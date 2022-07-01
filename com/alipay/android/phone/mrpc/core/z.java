package com.alipay.android.phone.mrpc.core;

import android.os.Looper;
import com.alipay.android.phone.mrpc.core.a.d;
import com.alipay.android.phone.mrpc.core.a.e;
import com.alipay.mobile.framework.service.annotation.OperationType;
import com.alipay.mobile.framework.service.annotation.ResetCookie;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public final class z {
  private static final ThreadLocal<Object> a = new ThreadLocal();
  
  private static final ThreadLocal<Map<String, Object>> b = new ThreadLocal<Map<String, Object>>();
  
  private byte c = 0;
  
  private AtomicInteger d;
  
  private x e;
  
  public z(x paramx) {
    this.e = paramx;
    this.d = new AtomicInteger();
  }
  
  public final Object a(Method paramMethod, Object[] paramArrayOfObject) {
    int i;
    if (Looper.myLooper() != null && Looper.myLooper() == Looper.getMainLooper()) {
      i = 1;
    } else {
      i = 0;
    } 
    if (!i) {
      boolean bool;
      OperationType operationType = paramMethod.<OperationType>getAnnotation(OperationType.class);
      if (paramMethod.getAnnotation(ResetCookie.class) != null) {
        bool = true;
      } else {
        bool = false;
      } 
      Type type = paramMethod.getGenericReturnType();
      paramMethod.getAnnotations();
      a.set(null);
      b.set(null);
      if (operationType != null) {
        String str = operationType.value();
        i = this.d.incrementAndGet();
        try {
          if (this.c == 0) {
            e e = new e(i, str, paramArrayOfObject);
            if (b.get() != null)
              e.a(b.get()); 
            byte[] arrayOfByte2 = e.a();
            byte[] arrayOfByte1 = (byte[])(new j(this.e.a(), paramMethod, i, str, arrayOfByte2, bool)).a();
            b.set(null);
            Object object = (new d(type, arrayOfByte1)).a();
            if (type != void.class)
              a.set(object); 
          } 
          return a.get();
        } catch (RpcException rpcException) {
          rpcException.setOperationType(str);
          throw rpcException;
        } 
      } 
      throw new IllegalStateException("OperationType must be set.");
    } 
    throw new IllegalThreadStateException("can't in main thread call rpc .");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alipay\android\phone\mrpc\core\z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */