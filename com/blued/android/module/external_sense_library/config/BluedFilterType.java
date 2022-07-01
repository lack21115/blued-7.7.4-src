package com.blued.android.module.external_sense_library.config;

import java.io.Serializable;

public interface BluedFilterType {
  public enum FILER implements BluedFilterType, Serializable {
    BABYPINK("filter_style_babypink_1.5.0.model"),
    CITY("filter_style_city_1.5.0.model"),
    MODERN("filter_style_modern_1.5.0.model"),
    PANSY("filter_style_pansy_1.5.0.model"),
    RUBY("filter_style_ruby_1.5.0.model");
    
    private String value;
    
    static {
    
    }
    
    FILER(String param1String1) {
      this.value = param1String1;
    }
    
    public String getValue() {
      return this.value;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\external_sense_library\config\BluedFilterType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */