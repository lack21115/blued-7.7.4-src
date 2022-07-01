package com.idlefish.flutterboost;

import android.app.Application;
import android.content.Context;
import com.idlefish.flutterboost.interfaces.IContainerRecord;
import io.flutter.embedding.android.FlutterView;
import java.util.Map;

public abstract class Platform {
  public FlutterBoost.BoostLifecycleListener b;
  
  public abstract Application a();
  
  public abstract void a(Context paramContext, String paramString, Map<String, Object> paramMap1, int paramInt, Map<String, Object> paramMap2);
  
  public void a(IContainerRecord paramIContainerRecord, Map<String, Object> paramMap1, Map<String, Object> paramMap2) {
    if (paramIContainerRecord == null)
      return; 
    paramIContainerRecord.b().a(paramMap1);
  }
  
  public abstract boolean b();
  
  public abstract String c();
  
  public abstract String d();
  
  public abstract int e();
  
  public abstract FlutterView.RenderMode f();
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\idlefish\flutterboost\Platform.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */