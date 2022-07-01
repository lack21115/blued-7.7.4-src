package com.blued.android.framework.provider;

public interface IAppInfoProvider {
  public static final EmptyImpl a = new EmptyImpl();
  
  String a();
  
  String b();
  
  public static class EmptyImpl implements IAppInfoProvider {
    public String a() {
      return "0";
    }
    
    public String b() {
      return "";
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\framework\provider\IAppInfoProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */