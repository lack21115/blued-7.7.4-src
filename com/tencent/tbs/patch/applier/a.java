package com.tencent.tbs.patch.applier;

import com.tencent.tbs.patch.common.NativeRequirement;

abstract class a<T extends BasicApplierConfig> extends NativeRequirement {
  protected T a;
  
  private ApplierListener b = new BaseApplierListener();
  
  public a(T paramT) {
    this.a = paramT;
  }
  
  protected void a(String paramString) {
    ApplierListener applierListener = this.b;
    if (applierListener != null)
      applierListener.onApplyFinished(paramString); 
  }
  
  protected void b(String paramString) {
    ApplierListener applierListener = this.b;
    if (applierListener != null)
      applierListener.onApplyFinished(paramString); 
  }
  
  public abstract void doApply();
  
  public void setListener(ApplierListener paramApplierListener) {
    if (paramApplierListener != null)
      this.b = paramApplierListener; 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued209820-dex2jar.jar!\com\tencent\tbs\patch\applier\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */