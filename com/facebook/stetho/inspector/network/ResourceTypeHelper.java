package com.facebook.stetho.inspector.network;

import com.facebook.stetho.inspector.protocol.module.Page;

public class ResourceTypeHelper {
  private final MimeMatcher<Page.ResourceType> mMimeMatcher = new MimeMatcher<Page.ResourceType>();
  
  public ResourceTypeHelper() {
    this.mMimeMatcher.addRule("text/css", Page.ResourceType.STYLESHEET);
    this.mMimeMatcher.addRule("image/*", Page.ResourceType.IMAGE);
    this.mMimeMatcher.addRule("application/x-javascript", Page.ResourceType.SCRIPT);
    this.mMimeMatcher.addRule("text/javascript", Page.ResourceType.XHR);
    this.mMimeMatcher.addRule("application/json", Page.ResourceType.XHR);
    this.mMimeMatcher.addRule("text/*", Page.ResourceType.DOCUMENT);
    this.mMimeMatcher.addRule("*", Page.ResourceType.OTHER);
  }
  
  public Page.ResourceType determineResourceType(String paramString) {
    paramString = stripContentExtras(paramString);
    return this.mMimeMatcher.match(paramString);
  }
  
  public String stripContentExtras(String paramString) {
    int i = paramString.indexOf(';');
    String str = paramString;
    if (i >= 0)
      str = paramString.substring(0, i); 
    return str;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\facebook\stetho\inspector\network\ResourceTypeHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */