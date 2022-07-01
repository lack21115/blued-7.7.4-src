package com.blued.android.core.ui;

import android.app.Activity;
import java.util.Stack;

public class ActivityStack {
  private static ActivityStack a;
  
  private final Stack<Activity> b = new Stack<Activity>();
  
  public static ActivityStack a() {
    // Byte code:
    //   0: ldc com/blued/android/core/ui/ActivityStack
    //   2: monitorenter
    //   3: getstatic com/blued/android/core/ui/ActivityStack.a : Lcom/blued/android/core/ui/ActivityStack;
    //   6: ifnonnull -> 19
    //   9: new com/blued/android/core/ui/ActivityStack
    //   12: dup
    //   13: invokespecial <init> : ()V
    //   16: putstatic com/blued/android/core/ui/ActivityStack.a : Lcom/blued/android/core/ui/ActivityStack;
    //   19: getstatic com/blued/android/core/ui/ActivityStack.a : Lcom/blued/android/core/ui/ActivityStack;
    //   22: astore_0
    //   23: ldc com/blued/android/core/ui/ActivityStack
    //   25: monitorexit
    //   26: aload_0
    //   27: areturn
    //   28: astore_0
    //   29: ldc com/blued/android/core/ui/ActivityStack
    //   31: monitorexit
    //   32: aload_0
    //   33: athrow
    // Exception table:
    //   from	to	target	type
    //   3	19	28	finally
    //   19	23	28	finally
  }
  
  public void a(Activity paramActivity) {
    if (paramActivity != null)
      this.b.add(paramActivity); 
  }
  
  public void a(Class<? extends Activity> paramClass) {
    Activity[] arrayOfActivity = new Activity[this.b.size()];
    this.b.copyInto((Object[])arrayOfActivity);
    int j = arrayOfActivity.length;
    Activity activity = null;
    for (int i = 0; i < j; i++) {
      Activity activity1 = arrayOfActivity[i];
      if (activity1.getClass() != paramClass) {
        activity1.finish();
      } else {
        if (activity != null && activity != activity1)
          activity.finish(); 
        activity = activity1;
      } 
    } 
    this.b.clear();
    if (activity != null)
      this.b.add(activity); 
  }
  
  public Stack<Activity> b() {
    Stack<Activity> stack1 = new Stack();
    Stack<Activity> stack2 = this.b;
    if (stack2 != null)
      stack1.addAll(stack2); 
    return stack1;
  }
  
  public void b(Activity paramActivity) {
    if (paramActivity != null)
      this.b.remove(paramActivity); 
  }
  
  public void c() {
    Activity[] arrayOfActivity = new Activity[this.b.size()];
    this.b.copyInto((Object[])arrayOfActivity);
    int j = arrayOfActivity.length;
    for (int i = 0; i < j; i++)
      arrayOfActivity[i].finish(); 
    this.b.clear();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\cor\\ui\ActivityStack.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */