package com.blued.android.framework.provider;

public interface IUserInfoProvider {
  public static final EmptyImpl a = new EmptyImpl();
  
  String a();
  
  void a(String paramString);
  
  String b();
  
  void c();
  
  void d();
  
  public static class EmptyImpl implements IUserInfoProvider {
    public String a() {
      return null;
    }
    
    public void a(String param1String) {}
    
    public String b() {
      return null;
    }
    
    public void c() {}
    
    public void d() {}
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\framework\provider\IUserInfoProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */