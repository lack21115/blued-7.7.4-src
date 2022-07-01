package com.facebook.stetho.inspector.elements;

import com.facebook.stetho.json.annotation.JsonValue;

public enum Origin {
  INJECTED("injected"),
  INSPECTOR("injected"),
  REGULAR("injected"),
  USER_AGENT("user-agent");
  
  private final String mValue;
  
  static {
    INSPECTOR = new Origin("INSPECTOR", 2, "inspector");
    REGULAR = new Origin("REGULAR", 3, "regular");
    $VALUES = new Origin[] { INJECTED, USER_AGENT, INSPECTOR, REGULAR };
  }
  
  Origin(String paramString1) {
    this.mValue = paramString1;
  }
  
  @JsonValue
  public String getProtocolValue() {
    return this.mValue;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\facebook\stetho\inspector\elements\Origin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */