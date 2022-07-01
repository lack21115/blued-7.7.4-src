package com.blued.android.module.external_sense_library.utils;

import com.blued.android.module.external_sense_library.config.BluedFilterType;

public class FilterUitls {
  public static BluedFilterType.FILER a(String paramString) {
    for (BluedFilterType.FILER fILER : BluedFilterType.FILER.values()) {
      if (fILER.getValue().equals(paramString))
        return fILER; 
    } 
    return null;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\external_sense_librar\\utils\FilterUitls.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */