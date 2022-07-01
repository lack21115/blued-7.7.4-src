package com.blued.android.module.media.selector.model;

import com.blued.android.module.media.selector.contract.IBaseCallback;

public abstract class BaseModel<T extends IBaseCallback> {
  protected T a;
  
  public BaseModel(T paramT) {
    this.a = paramT;
  }
  
  public void d() {
    this.a = null;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\media\selector\model\BaseModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */