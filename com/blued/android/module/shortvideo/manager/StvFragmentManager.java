package com.blued.android.module.shortvideo.manager;

import android.app.Activity;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.module.shortvideo.R;
import com.blued.android.module.shortvideo.fragment.EditFragment;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class StvFragmentManager {
  private static StvFragmentManager a;
  
  private List<String> b = new LinkedList<String>();
  
  public static StvFragmentManager a() {
    // Byte code:
    //   0: getstatic com/blued/android/module/shortvideo/manager/StvFragmentManager.a : Lcom/blued/android/module/shortvideo/manager/StvFragmentManager;
    //   3: ifnonnull -> 37
    //   6: ldc com/blued/android/module/shortvideo/manager/StvFragmentManager
    //   8: monitorenter
    //   9: getstatic com/blued/android/module/shortvideo/manager/StvFragmentManager.a : Lcom/blued/android/module/shortvideo/manager/StvFragmentManager;
    //   12: ifnonnull -> 25
    //   15: new com/blued/android/module/shortvideo/manager/StvFragmentManager
    //   18: dup
    //   19: invokespecial <init> : ()V
    //   22: putstatic com/blued/android/module/shortvideo/manager/StvFragmentManager.a : Lcom/blued/android/module/shortvideo/manager/StvFragmentManager;
    //   25: ldc com/blued/android/module/shortvideo/manager/StvFragmentManager
    //   27: monitorexit
    //   28: goto -> 37
    //   31: astore_0
    //   32: ldc com/blued/android/module/shortvideo/manager/StvFragmentManager
    //   34: monitorexit
    //   35: aload_0
    //   36: athrow
    //   37: getstatic com/blued/android/module/shortvideo/manager/StvFragmentManager.a : Lcom/blued/android/module/shortvideo/manager/StvFragmentManager;
    //   40: areturn
    // Exception table:
    //   from	to	target	type
    //   9	25	31	finally
    //   25	28	31	finally
    //   32	35	31	finally
  }
  
  public void a(String paramString) {
    if (!TextUtils.isEmpty(paramString) && !this.b.contains(paramString))
      this.b.add(paramString); 
  }
  
  public void b() {
    try {
      Class<?> clazz = Class.forName("android.app.ActivityThread");
      null = clazz.getMethod("currentActivityThread", new Class[0]).invoke(null, new Object[0]);
      field = clazz.getDeclaredField("mActivities");
      field.setAccessible(true);
      for (Field field : ((Map)field.get(null)).values()) {
        Field field1 = field.getClass().getDeclaredField("activity");
        field1.setAccessible(true);
        Activity activity = (Activity)field1.get(field);
        if (activity != null && activity.getClass().getSimpleName().equals(TerminalActivity.class.getSimpleName())) {
          Fragment fragment = ((TerminalActivity)activity).getSupportFragmentManager().findFragmentById(R.id.root_view);
          if (fragment != null) {
            String str = fragment.getClass().getSimpleName();
            if (c(str)) {
              b(str);
              activity.finish();
            } 
          } 
        } 
      } 
    } catch (ClassNotFoundException classNotFoundException) {
      classNotFoundException.printStackTrace();
    } catch (NoSuchMethodException noSuchMethodException) {
      noSuchMethodException.printStackTrace();
      return;
    } catch (IllegalAccessException illegalAccessException) {
      illegalAccessException.printStackTrace();
      return;
    } catch (InvocationTargetException invocationTargetException) {
      invocationTargetException.printStackTrace();
      return;
    } catch (NoSuchFieldException noSuchFieldException) {
      noSuchFieldException.printStackTrace();
      return;
    } 
  }
  
  public void b(String paramString) {
    if (!TextUtils.isEmpty(paramString) && this.b.contains(paramString))
      this.b.remove(paramString); 
  }
  
  public boolean c() {
    List<String> list = this.b;
    return !(list == null || list.size() <= 0);
  }
  
  public boolean c(String paramString) {
    return (!TextUtils.isEmpty(paramString) && this.b.contains(paramString));
  }
  
  public boolean d() {
    return c(EditFragment.class.getSimpleName());
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\module\shortvideo\manager\StvFragmentManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */