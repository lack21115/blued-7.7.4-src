package com.blued.android.framework.provider;

public class ProviderHolder {
  private static ProviderHolder a;
  
  private IAppInfoProvider b;
  
  private IUserInfoProvider c;
  
  private IStringResourceProvider d;
  
  private IPageLifecycleProvider e;
  
  public static ProviderHolder a() {
    // Byte code:
    //   0: getstatic com/blued/android/framework/provider/ProviderHolder.a : Lcom/blued/android/framework/provider/ProviderHolder;
    //   3: ifnonnull -> 47
    //   6: ldc com/blued/android/framework/provider/ProviderHolder
    //   8: monitorenter
    //   9: getstatic com/blued/android/framework/provider/ProviderHolder.a : Lcom/blued/android/framework/provider/ProviderHolder;
    //   12: ifnonnull -> 35
    //   15: new com/blued/android/framework/provider/ProviderHolder
    //   18: dup
    //   19: invokespecial <init> : ()V
    //   22: putstatic com/blued/android/framework/provider/ProviderHolder.a : Lcom/blued/android/framework/provider/ProviderHolder;
    //   25: new com/blued/android/framework/ui/CorePageCallback
    //   28: dup
    //   29: invokespecial <init> : ()V
    //   32: invokestatic a : (Lcom/blued/android/core/ui/UIPageCallback;)V
    //   35: ldc com/blued/android/framework/provider/ProviderHolder
    //   37: monitorexit
    //   38: goto -> 47
    //   41: astore_0
    //   42: ldc com/blued/android/framework/provider/ProviderHolder
    //   44: monitorexit
    //   45: aload_0
    //   46: athrow
    //   47: getstatic com/blued/android/framework/provider/ProviderHolder.a : Lcom/blued/android/framework/provider/ProviderHolder;
    //   50: areturn
    // Exception table:
    //   from	to	target	type
    //   9	35	41	finally
    //   35	38	41	finally
    //   42	45	41	finally
  }
  
  public void a(IAppInfoProvider paramIAppInfoProvider) {
    this.b = paramIAppInfoProvider;
  }
  
  public void a(IPageLifecycleProvider paramIPageLifecycleProvider) {
    this.e = paramIPageLifecycleProvider;
  }
  
  public void a(IStringResourceProvider paramIStringResourceProvider) {
    this.d = paramIStringResourceProvider;
  }
  
  public void a(IUserInfoProvider paramIUserInfoProvider) {
    this.c = paramIUserInfoProvider;
  }
  
  public IUserInfoProvider b() {
    IUserInfoProvider iUserInfoProvider = this.c;
    return (iUserInfoProvider != null) ? iUserInfoProvider : IUserInfoProvider.a;
  }
  
  public IStringResourceProvider c() {
    IStringResourceProvider iStringResourceProvider = this.d;
    return (iStringResourceProvider != null) ? iStringResourceProvider : IStringResourceProvider.a;
  }
  
  public IPageLifecycleProvider d() {
    IPageLifecycleProvider iPageLifecycleProvider = this.e;
    return (iPageLifecycleProvider != null) ? iPageLifecycleProvider : IPageLifecycleProvider.a;
  }
  
  public IAppInfoProvider e() {
    IAppInfoProvider iAppInfoProvider = this.b;
    return (iAppInfoProvider != null) ? iAppInfoProvider : IAppInfoProvider.a;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\framework\provider\ProviderHolder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */