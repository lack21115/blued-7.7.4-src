package com.blued.android.framework.mvp;

import android.content.Context;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.utils.LogUtils;

public abstract class BasePresenter<T extends BaseView> implements IPresenter {
  protected T a;
  
  protected Context b;
  
  protected IRequestHost c;
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\framework\mvp\BasePresenter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */