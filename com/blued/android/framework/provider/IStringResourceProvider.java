package com.blued.android.framework.provider;

public interface IStringResourceProvider {
  public static final EmptyImpl a = new EmptyImpl();
  
  String a();
  
  String a(int paramInt);
  
  String b();
  
  public static class EmptyImpl implements IStringResourceProvider {
    public String a() {
      return "Upload file";
    }
    
    public String a(int param1Int) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("network error:(");
      stringBuilder.append(param1Int);
      stringBuilder.append(")");
      return stringBuilder.toString();
    }
    
    public String b() {
      return "Unstable network, please try again later.";
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\framework\provider\IStringResourceProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */