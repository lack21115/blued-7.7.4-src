package com.bumptech.glide.manager;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.View;
import androidx.collection.ArrayMap;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.Util;
import java.util.HashMap;
import java.util.Map;

public class RequestManagerRetriever implements Handler.Callback {
  private static final RequestManagerFactory i = new RequestManagerFactory() {
      public RequestManager a(Glide param1Glide, Lifecycle param1Lifecycle, RequestManagerTreeNode param1RequestManagerTreeNode, Context param1Context) {
        return new RequestManager(param1Glide, param1Lifecycle, param1RequestManagerTreeNode, param1Context);
      }
    };
  
  final Map<FragmentManager, RequestManagerFragment> a = new HashMap<FragmentManager, RequestManagerFragment>();
  
  final Map<FragmentManager, SupportRequestManagerFragment> b = new HashMap<FragmentManager, SupportRequestManagerFragment>();
  
  private volatile RequestManager c;
  
  private final Handler d;
  
  private final RequestManagerFactory e;
  
  private final ArrayMap<View, Fragment> f = new ArrayMap();
  
  private final ArrayMap<View, Fragment> g = new ArrayMap();
  
  private final Bundle h = new Bundle();
  
  public RequestManagerRetriever(RequestManagerFactory paramRequestManagerFactory) {
    if (paramRequestManagerFactory == null)
      paramRequestManagerFactory = i; 
    this.e = paramRequestManagerFactory;
    this.d = new Handler(Looper.getMainLooper(), this);
  }
  
  @Deprecated
  private RequestManager a(Context paramContext, FragmentManager paramFragmentManager, Fragment paramFragment, boolean paramBoolean) {
    RequestManagerFragment requestManagerFragment = a(paramFragmentManager, paramFragment, paramBoolean);
    RequestManager requestManager2 = requestManagerFragment.b();
    RequestManager requestManager1 = requestManager2;
    if (requestManager2 == null) {
      Glide glide = Glide.a(paramContext);
      requestManager1 = this.e.a(glide, requestManagerFragment.a(), requestManagerFragment.c(), paramContext);
      requestManagerFragment.a(requestManager1);
    } 
    return requestManager1;
  }
  
  private RequestManager a(Context paramContext, FragmentManager paramFragmentManager, Fragment paramFragment, boolean paramBoolean) {
    SupportRequestManagerFragment supportRequestManagerFragment = a(paramFragmentManager, paramFragment, paramBoolean);
    RequestManager requestManager2 = supportRequestManagerFragment.b();
    RequestManager requestManager1 = requestManager2;
    if (requestManager2 == null) {
      Glide glide = Glide.a(paramContext);
      requestManager1 = this.e.a(glide, supportRequestManagerFragment.a(), supportRequestManagerFragment.c(), paramContext);
      supportRequestManagerFragment.a(requestManager1);
    } 
    return requestManager1;
  }
  
  private RequestManagerFragment a(FragmentManager paramFragmentManager, Fragment paramFragment, boolean paramBoolean) {
    RequestManagerFragment requestManagerFragment2 = (RequestManagerFragment)paramFragmentManager.findFragmentByTag("com.bumptech.glide.manager");
    RequestManagerFragment requestManagerFragment1 = requestManagerFragment2;
    if (requestManagerFragment2 == null) {
      requestManagerFragment2 = this.a.get(paramFragmentManager);
      requestManagerFragment1 = requestManagerFragment2;
      if (requestManagerFragment2 == null) {
        requestManagerFragment1 = new RequestManagerFragment();
        requestManagerFragment1.a(paramFragment);
        if (paramBoolean)
          requestManagerFragment1.a().a(); 
        this.a.put(paramFragmentManager, requestManagerFragment1);
        paramFragmentManager.beginTransaction().add(requestManagerFragment1, "com.bumptech.glide.manager").commitAllowingStateLoss();
        this.d.obtainMessage(1, paramFragmentManager).sendToTarget();
      } 
    } 
    return requestManagerFragment1;
  }
  
  private SupportRequestManagerFragment a(FragmentManager paramFragmentManager, Fragment paramFragment, boolean paramBoolean) {
    SupportRequestManagerFragment supportRequestManagerFragment2 = (SupportRequestManagerFragment)paramFragmentManager.findFragmentByTag("com.bumptech.glide.manager");
    SupportRequestManagerFragment supportRequestManagerFragment1 = supportRequestManagerFragment2;
    if (supportRequestManagerFragment2 == null) {
      supportRequestManagerFragment2 = this.b.get(paramFragmentManager);
      supportRequestManagerFragment1 = supportRequestManagerFragment2;
      if (supportRequestManagerFragment2 == null) {
        supportRequestManagerFragment1 = new SupportRequestManagerFragment();
        supportRequestManagerFragment1.a(paramFragment);
        if (paramBoolean)
          supportRequestManagerFragment1.a().a(); 
        this.b.put(paramFragmentManager, supportRequestManagerFragment1);
        paramFragmentManager.beginTransaction().add(supportRequestManagerFragment1, "com.bumptech.glide.manager").commitAllowingStateLoss();
        this.d.obtainMessage(2, paramFragmentManager).sendToTarget();
      } 
    } 
    return supportRequestManagerFragment1;
  }
  
  private RequestManager b(Context paramContext) {
    // Byte code:
    //   0: aload_0
    //   1: getfield c : Lcom/bumptech/glide/RequestManager;
    //   4: ifnonnull -> 66
    //   7: aload_0
    //   8: monitorenter
    //   9: aload_0
    //   10: getfield c : Lcom/bumptech/glide/RequestManager;
    //   13: ifnonnull -> 56
    //   16: aload_1
    //   17: invokevirtual getApplicationContext : ()Landroid/content/Context;
    //   20: invokestatic a : (Landroid/content/Context;)Lcom/bumptech/glide/Glide;
    //   23: astore_2
    //   24: aload_0
    //   25: aload_0
    //   26: getfield e : Lcom/bumptech/glide/manager/RequestManagerRetriever$RequestManagerFactory;
    //   29: aload_2
    //   30: new com/bumptech/glide/manager/ApplicationLifecycle
    //   33: dup
    //   34: invokespecial <init> : ()V
    //   37: new com/bumptech/glide/manager/EmptyRequestManagerTreeNode
    //   40: dup
    //   41: invokespecial <init> : ()V
    //   44: aload_1
    //   45: invokevirtual getApplicationContext : ()Landroid/content/Context;
    //   48: invokeinterface a : (Lcom/bumptech/glide/Glide;Lcom/bumptech/glide/manager/Lifecycle;Lcom/bumptech/glide/manager/RequestManagerTreeNode;Landroid/content/Context;)Lcom/bumptech/glide/RequestManager;
    //   53: putfield c : Lcom/bumptech/glide/RequestManager;
    //   56: aload_0
    //   57: monitorexit
    //   58: goto -> 66
    //   61: astore_1
    //   62: aload_0
    //   63: monitorexit
    //   64: aload_1
    //   65: athrow
    //   66: aload_0
    //   67: getfield c : Lcom/bumptech/glide/RequestManager;
    //   70: areturn
    // Exception table:
    //   from	to	target	type
    //   9	56	61	finally
    //   56	58	61	finally
    //   62	64	61	finally
  }
  
  private static Activity c(Context paramContext) {
    return (paramContext instanceof Activity) ? (Activity)paramContext : ((paramContext instanceof ContextWrapper) ? c(((ContextWrapper)paramContext).getBaseContext()) : null);
  }
  
  private static void c(Activity paramActivity) {
    if (Build.VERSION.SDK_INT >= 17) {
      if (!paramActivity.isDestroyed())
        return; 
      throw new IllegalArgumentException("You cannot start a load for a destroyed activity");
    } 
  }
  
  private static boolean d(Context paramContext) {
    Activity activity = c(paramContext);
    return (activity == null || !activity.isFinishing());
  }
  
  public RequestManager a(Activity paramActivity) {
    if (Util.d())
      return a(paramActivity.getApplicationContext()); 
    c(paramActivity);
    return a((Context)paramActivity, paramActivity.getFragmentManager(), (Fragment)null, d((Context)paramActivity));
  }
  
  public RequestManager a(Context paramContext) {
    if (paramContext != null) {
      if (Util.c() && !(paramContext instanceof android.app.Application)) {
        if (paramContext instanceof FragmentActivity)
          return a((FragmentActivity)paramContext); 
        if (paramContext instanceof Activity)
          return a((Activity)paramContext); 
        if (paramContext instanceof ContextWrapper) {
          ContextWrapper contextWrapper = (ContextWrapper)paramContext;
          if (contextWrapper.getBaseContext().getApplicationContext() != null)
            return a(contextWrapper.getBaseContext()); 
        } 
      } 
      return b(paramContext);
    } 
    throw new IllegalArgumentException("You cannot start a load on a null Context");
  }
  
  public RequestManager a(Fragment paramFragment) {
    Preconditions.a(paramFragment.getContext(), "You cannot start a load on a fragment before it is attached or after it is destroyed");
    if (Util.d())
      return a(paramFragment.getContext().getApplicationContext()); 
    FragmentManager fragmentManager = paramFragment.getChildFragmentManager();
    return a(paramFragment.getContext(), fragmentManager, paramFragment, paramFragment.isVisible());
  }
  
  public RequestManager a(FragmentActivity paramFragmentActivity) {
    if (Util.d())
      return a(paramFragmentActivity.getApplicationContext()); 
    c((Activity)paramFragmentActivity);
    return a((Context)paramFragmentActivity, paramFragmentActivity.getSupportFragmentManager(), (Fragment)null, d((Context)paramFragmentActivity));
  }
  
  SupportRequestManagerFragment a(Context paramContext, FragmentManager paramFragmentManager) {
    return a(paramFragmentManager, (Fragment)null, d(paramContext));
  }
  
  @Deprecated
  RequestManagerFragment b(Activity paramActivity) {
    return a(paramActivity.getFragmentManager(), (Fragment)null, d((Context)paramActivity));
  }
  
  public boolean handleMessage(Message paramMessage) {
    FragmentManager fragmentManager1;
    FragmentManager fragmentManager;
    int i = paramMessage.what;
    Message message = null;
    boolean bool = true;
    if (i != 1) {
      if (i != 2) {
        bool = false;
        Message message1 = null;
        paramMessage = message;
        message = message1;
      } else {
        fragmentManager1 = (FragmentManager)paramMessage.obj;
        message = (Message)this.b.remove(fragmentManager1);
      } 
    } else {
      fragmentManager = (FragmentManager)((Message)fragmentManager1).obj;
      message = (Message)this.a.remove(fragmentManager);
    } 
    if (bool && message == null && Log.isLoggable("RMRetriever", 5)) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Failed to remove expected request manager fragment, manager: ");
      stringBuilder.append(fragmentManager);
      Log.w("RMRetriever", stringBuilder.toString());
    } 
    return bool;
  }
  
  public static interface RequestManagerFactory {
    RequestManager a(Glide param1Glide, Lifecycle param1Lifecycle, RequestManagerTreeNode param1RequestManagerTreeNode, Context param1Context);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bumptech\glide\manager\RequestManagerRetriever.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */