package com.ishumei.l111l11111Il.l1111l111111Il;

import android.content.Context;

public final class l11l1111I1ll extends l111l1111lI1l {
  private Context l1111l111111Il;
  
  l11l1111I1ll(Context paramContext) {
    this.l1111l111111Il = paramContext;
  }
  
  public final String l1111l111111Il() {
    try {
      Class<?> clazz = Class.forName("com.android.id.impl.IdProviderImpl");
      Object object = clazz.newInstance();
      return (String)clazz.getMethod("getOAID", new Class[] { Context.class }).invoke(object, new Object[] { this.l1111l111111Il });
    } catch (Exception exception) {
      return "";
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\ishumei\l111l11111Il\l1111l111111Il\l11l1111I1ll.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */