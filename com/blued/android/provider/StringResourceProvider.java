package com.blued.android.provider;

import com.blued.android.core.AppInfo;
import com.blued.android.framework.provider.IStringResourceProvider;

public class StringResourceProvider implements IStringResourceProvider {
  public String a() {
    return AppInfo.d().getString(2131759344);
  }
  
  public String a(int paramInt) {
    String str = AppInfo.d().getResources().getString(2131756082);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(str);
    stringBuilder.append(" (");
    stringBuilder.append(paramInt);
    stringBuilder.append(")");
    return stringBuilder.toString();
  }
  
  public String b() {
    return AppInfo.d().getResources().getString(2131758203);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\provider\StringResourceProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */