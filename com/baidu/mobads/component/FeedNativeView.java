package com.baidu.mobads.component;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.mobad.feeds.XAdNativeResponse;
import com.baidu.mobads.f.b;
import com.baidu.mobads.q;
import dalvik.system.DexClassLoader;

public class FeedNativeView extends RelativeLayout {
  private View mAdView;
  
  private Context mContext;
  
  private DexClassLoader mLoader;
  
  private String mRemoteClassName = "com.style.widget.RemoteNativeView";
  
  public FeedNativeView(Context paramContext) {
    super(paramContext);
    init(paramContext);
  }
  
  public FeedNativeView(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    init(paramContext);
  }
  
  public FeedNativeView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramContext);
  }
  
  private void init(Context paramContext) {
    this.mContext = paramContext;
    paramContext = this.mContext;
    this.mLoader = b.d();
    if (this.mLoader == null)
      this.mLoader = q.a(this.mContext); 
    this.mAdView = (View)q.a(this.mRemoteClassName, (ClassLoader)this.mLoader, new Class[] { Context.class }, new Object[] { paramContext });
    View view = this.mAdView;
    if (view != null)
      addView(view, (ViewGroup.LayoutParams)new RelativeLayout.LayoutParams(-2, -2)); 
  }
  
  public void changeViewLayoutParams(Object paramObject) {
    View view = this.mAdView;
    if (view != null)
      q.a(this.mRemoteClassName, view, (ClassLoader)this.mLoader, "changeLayoutParams", new Class[] { Object.class }, new Object[] { paramObject }); 
  }
  
  public int getAdContainerHeight() {
    View view = this.mAdView;
    int i = 0;
    if (view != null)
      i = ((Integer)q.a(this.mRemoteClassName, view, (ClassLoader)this.mLoader, "getAdContainerHeight", new Class[0], new Object[0])).intValue(); 
    return i;
  }
  
  public int getAdContainerWidth() {
    View view = this.mAdView;
    int i = 0;
    if (view != null)
      i = ((Integer)q.a(this.mRemoteClassName, view, (ClassLoader)this.mLoader, "getAdContainerWidth", new Class[0], new Object[0])).intValue(); 
    return i;
  }
  
  public RelativeLayout getContainerView() {
    View view = this.mAdView;
    return (view != null) ? (RelativeLayout)q.a(this.mRemoteClassName, view, (ClassLoader)this.mLoader, "getAdView", new Class[0], new Object[0]) : null;
  }
  
  public void setAdData(XAdNativeResponse paramXAdNativeResponse) {
    View view = this.mAdView;
    if (view != null)
      q.a(this.mRemoteClassName, view, (ClassLoader)this.mLoader, "setAdResponse", new Class[] { Object.class }, new Object[] { paramXAdNativeResponse }); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\mobads\component\FeedNativeView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */