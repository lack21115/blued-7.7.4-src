package com.facebook.stetho.inspector.network;

import com.facebook.stetho.inspector.protocol.module.Page;

public enum PrettyPrinterDisplayType {
  HTML,
  JSON(Page.ResourceType.XHR),
  TEXT(Page.ResourceType.XHR);
  
  private final Page.ResourceType mResourceType;
  
  static {
    HTML = new PrettyPrinterDisplayType("HTML", 1, Page.ResourceType.DOCUMENT);
    TEXT = new PrettyPrinterDisplayType("TEXT", 2, Page.ResourceType.DOCUMENT);
    $VALUES = new PrettyPrinterDisplayType[] { JSON, HTML, TEXT };
  }
  
  PrettyPrinterDisplayType(Page.ResourceType paramResourceType) {
    this.mResourceType = paramResourceType;
  }
  
  public Page.ResourceType getResourceType() {
    return this.mResourceType;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\facebook\stetho\inspector\network\PrettyPrinterDisplayType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */