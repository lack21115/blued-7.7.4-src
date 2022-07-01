package com.blued.android.provider;

import com.blued.android.core.AppInfo;
import com.blued.android.framework.provider.IStringResourceProvider;

public class StringResourceProviderForSimilarity implements IStringResourceProvider {
  public String a() {
    return AppInfo.d().getString(2131759344);
  }
  
  public String a(int paramInt) {
    String str;
    if (paramInt != 0) {
      if (paramInt != 410) {
        if (paramInt != 415) {
          if (paramInt != 422) {
            if (paramInt != 429) {
              if (paramInt != 500) {
                StringBuilder stringBuilder1;
                switch (paramInt) {
                  default:
                    str = AppInfo.d().getResources().getString(2131756082);
                    stringBuilder1 = new StringBuilder();
                    stringBuilder1.append(str);
                    stringBuilder1.append(":(");
                    stringBuilder1.append(paramInt);
                    stringBuilder1.append(")");
                    return stringBuilder1.toString();
                  case 405:
                    str = AppInfo.d().getResources().getString(2131756331);
                    stringBuilder1 = new StringBuilder();
                    stringBuilder1.append(str);
                    stringBuilder1.append(":(");
                    stringBuilder1.append(paramInt);
                    stringBuilder1.append(")");
                    return stringBuilder1.toString();
                  case 404:
                    str = AppInfo.d().getResources().getString(2131756327);
                    stringBuilder1 = new StringBuilder();
                    stringBuilder1.append(str);
                    stringBuilder1.append(":(");
                    stringBuilder1.append(paramInt);
                    stringBuilder1.append(")");
                    return stringBuilder1.toString();
                  case 403:
                    str = AppInfo.d().getResources().getString(2131756236);
                    stringBuilder1 = new StringBuilder();
                    stringBuilder1.append(str);
                    stringBuilder1.append(":(");
                    stringBuilder1.append(paramInt);
                    stringBuilder1.append(")");
                    return stringBuilder1.toString();
                  case 402:
                    str = AppInfo.d().getResources().getString(2131756235);
                    stringBuilder1 = new StringBuilder();
                    stringBuilder1.append(str);
                    stringBuilder1.append(":(");
                    stringBuilder1.append(paramInt);
                    stringBuilder1.append(")");
                    return stringBuilder1.toString();
                  case 401:
                    str = AppInfo.d().getResources().getString(2131755217);
                    stringBuilder1 = new StringBuilder();
                    stringBuilder1.append(str);
                    stringBuilder1.append(":(");
                    stringBuilder1.append(paramInt);
                    stringBuilder1.append(")");
                    return stringBuilder1.toString();
                  case 400:
                    break;
                } 
                str = AppInfo.d().getResources().getString(2131756228);
              } else {
                str = AppInfo.d().getResources().getString(2131756082);
              } 
            } else {
              str = AppInfo.d().getResources().getString(2131756335);
            } 
          } else {
            str = AppInfo.d().getResources().getString(2131756334);
          } 
        } else {
          str = AppInfo.d().getResources().getString(2131756333);
        } 
      } else {
        str = AppInfo.d().getResources().getString(2131756332);
      } 
    } else {
      str = AppInfo.d().getResources().getString(2131758203);
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(str);
    stringBuilder.append(":(");
    stringBuilder.append(paramInt);
    stringBuilder.append(")");
    return stringBuilder.toString();
  }
  
  public String b() {
    return AppInfo.d().getResources().getString(2131758203);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\provider\StringResourceProviderForSimilarity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */