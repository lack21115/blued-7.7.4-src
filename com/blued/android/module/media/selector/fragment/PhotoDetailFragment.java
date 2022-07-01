package com.blued.android.module.media.selector.fragment;

import android.app.Activity;
import android.graphics.PorterDuff;
import android.graphics.RectF;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.image.ImageFileLoader;
import com.blued.android.core.image.ImageLoadResult;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.imagecache.LoadOptions;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.StatusBarHelper;
import com.blued.android.module.media.selector.R;
import com.blued.android.module.player.media.observer.EventCallbackObserver;
import com.blued.android.module.player.media.view.ViewDragHelperLayout;
import com.github.chrisbanes.photoview.OnScaleChangedListener;
import com.github.chrisbanes.photoview.PhotoView;
import java.io.File;
import java.io.Serializable;

public class PhotoDetailFragment extends BaseFragment implements GestureDetector.OnDoubleTapListener {
  protected ViewDragHelperLayout d;
  
  protected FrameLayout e;
  
  protected FrameLayout f;
  
  protected PhotoView g;
  
  protected ProgressBar h;
  
  protected LoadOptions i;
  
  public String j;
  
  ViewDragHelperLayout.OnLayoutStateListener k = new ViewDragHelperLayout.OnLayoutStateListener(this) {
      public void a() {
        if (this.a.getActivity() != null) {
          this.a.getActivity().finish();
          this.a.getActivity().overridePendingTransition(0, 0);
        } 
        EventCallbackObserver.a().b();
      }
      
      public void a(int param1Int) {
        EventCallbackObserver.a().a(param1Int);
      }
      
      public void b() {
        EventCallbackObserver.a().c();
      }
      
      public void c() {}
      
      public void d() {}
    };
  
  private View l;
  
  private boolean m = true;
  
  private boolean n = true;
  
  private double o = 1.0D;
  
  private GetConfigCallback p;
  
  private boolean q;
  
  public static Bundle a(String paramString, LoadOptions paramLoadOptions, boolean paramBoolean1, boolean paramBoolean2) {
    return a(paramString, paramLoadOptions, paramBoolean1, paramBoolean2, 1.0D);
  }
  
  public static Bundle a(String paramString, LoadOptions paramLoadOptions, boolean paramBoolean1, boolean paramBoolean2, double paramDouble) {
    Bundle bundle = new Bundle();
    bundle.putString("url", paramString);
    bundle.putSerializable("photo_options", (Serializable)paramLoadOptions);
    bundle.putBoolean("scroll", paramBoolean1);
    bundle.putBoolean("scroll_out", paramBoolean2);
    bundle.putDouble("scale_scroll_out_border_num", paramDouble);
    return bundle;
  }
  
  public static PhotoDetailFragment a(String paramString, LoadOptions paramLoadOptions, boolean paramBoolean) {
    PhotoDetailFragment photoDetailFragment = new PhotoDetailFragment();
    photoDetailFragment.setArguments(a(paramString, paramLoadOptions, true, paramBoolean));
    return photoDetailFragment;
  }
  
  private String a(String paramString) {
    return paramString.replace("!100x100.png", "").replace("!200x200.png", "").replace("!480x480.png", "").replace("!480x720.png", "").replace("!640x640.png", "").replace("!640x960.png", "").replace("!720x720.png", "").replace("!720x1080.png", "").replace("!1080x1080.png", "").replace("!1080x1620.png", "").replace("!o.png", "").replace("!original.png", "");
  }
  
  private void a() {
    this.d = (ViewDragHelperLayout)this.l.findViewById(R.id.view_drag_layout);
    this.h = (ProgressBar)this.l.findViewById(R.id.loading_view);
    new TypedValue();
    this.h.getIndeterminateDrawable().setColorFilter(getContext().getResources().getColor(R.color.colorAccent), PorterDuff.Mode.SRC_ATOP);
    this.g = (PhotoView)this.l.findViewById(R.id.photo_preview);
    this.e = (FrameLayout)this.l.findViewById(R.id.top_title);
    this.f = (FrameLayout)this.l.findViewById(R.id.bottom_tab);
    GetConfigCallback getConfigCallback = this.p;
    if (getConfigCallback != null) {
      this.g.setScaleType(getConfigCallback.c());
      if (this.p.a() != null) {
        this.e.addView(this.p.a(), (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -2));
        this.e.setVisibility(0);
      } else {
        this.e.setVisibility(8);
      } 
      if (this.p.b() != null) {
        this.f.addView(this.p.b(), (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -2));
        this.f.setVisibility(0);
      } else {
        this.f.setVisibility(8);
      } 
    } else {
      this.g.setScaleType(ImageView.ScaleType.FIT_CENTER);
      this.e.setVisibility(8);
      this.f.setVisibility(8);
    } 
    this.g.setZoomTransitionDuration(200);
    PhotoView photoView = this.g;
    photoView.setMediumScale(photoView.getMinimumScale() + 0.001F);
    if (!this.m) {
      this.n = false;
      this.d.setClickable(false);
      this.g.setZoomable(false);
    } else {
      this.d.setClickable(true);
      this.g.setMaximumScale(5.0F);
      this.d.setScrollDisable(this.n);
      this.g.setOnScaleChangeListener(new OnScaleChangedListener(this) {
            public void a(float param1Float1, float param1Float2, float param1Float3) {
              EventCallbackObserver.a().a(param1Float1, param1Float2, param1Float3);
              if (PhotoDetailFragment.a(this.a)) {
                if ((int)this.a.g.getScale() > PhotoDetailFragment.b(this.a)) {
                  this.a.d.setScrollDisable(false);
                  return;
                } 
                this.a.d.setScrollDisable(true);
              } 
            }
          });
      this.g.setOnDoubleTapListener(this);
    } 
    if (this.n)
      this.d.setOnLayoutStateListener(this.k); 
  }
  
  private void a(String paramString1, String paramString2) {
    n();
    ImageLoader.a((IRequestHost)w_(), paramString1).e().a(paramString2).c(R.drawable.album_load_failed_icon).a(new ImageLoadResult(this, (IRequestHost)w_(), paramString2, paramString1) {
          public void a() {
            this.c.p();
            if (PhotoDetailFragment.c(this.c))
              AppInfo.n().post(new -$$Lambda$PhotoDetailFragment$3$Q4Uc6hP3-HdCu7UhUDUqhZVFAm8(this)); 
            ImageFileLoader.a((IRequestHost)this.c.w_()).a(this.b).a(new -$$Lambda$PhotoDetailFragment$3$asdAWbcFuFB9ejKFVVnd8OOZWb4(this)).a();
          }
          
          public void a(int param1Int, Exception param1Exception) {
            this.c.p();
            AppMethods.d(R.string.foudation_media_load_fail);
            ImageFileLoader.a((IRequestHost)this.c.w_()).a(this.a).a(new -$$Lambda$PhotoDetailFragment$3$kX_qZw44nbAU114Ns1BYDdXX-GU(this)).a();
          }
        }).a((ImageView)this.g);
  }
  
  private void b(File paramFile) {
    this.g.setOnLongClickListener(new View.OnLongClickListener(this, paramFile) {
          public boolean onLongClick(View param1View) {
            EventCallbackObserver.a().a(new Object[] { this.b.j, this.a });
            return false;
          }
        });
  }
  
  private void q() {
    if (TextUtils.isEmpty(this.j)) {
      ImageLoader.a((IRequestHost)w_(), R.drawable.user_bg_round).a((ImageView)this.g);
      return;
    } 
    if (this.j.toLowerCase().contains("http://") || this.j.toLowerCase().contains("https://")) {
      String str = new String(this.j);
      if (!this.j.toLowerCase().contains("scontent.cdninstagram.com")) {
        this.j = a(this.j);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.j);
        stringBuilder.append(k());
        this.j = stringBuilder.toString();
      } 
      a(this.j, str);
      return;
    } 
    if (this.j.toLowerCase().startsWith("content://")) {
      ImageLoader.b((IRequestHost)w_(), this.j).a((ImageView)this.g);
      return;
    } 
    ImageLoader.d((IRequestHost)w_(), this.j).a((ImageView)this.g);
  }
  
  public boolean V_() {
    EventCallbackObserver.a().d();
    return true;
  }
  
  public void a(GetConfigCallback paramGetConfigCallback) {
    this.p = paramGetConfigCallback;
  }
  
  protected void a(File paramFile) {}
  
  public String k() {
    return "!o.png";
  }
  
  public void l() {
    double d;
    LoadOptions loadOptions;
    Bundle bundle1 = getArguments();
    Bundle bundle2 = null;
    if (bundle1 != null) {
      String str = getArguments().getString("url");
    } else {
      bundle1 = null;
    } 
    this.j = (String)bundle1;
    bundle1 = bundle2;
    if (getArguments() != null)
      loadOptions = (LoadOptions)getArguments().getSerializable("photo_options"); 
    this.i = loadOptions;
    if (this.i == null)
      this.i = new LoadOptions(); 
    if (getArguments() != null) {
      this.m = getArguments().getBoolean("scroll");
      this.n = getArguments().getBoolean("scroll_out");
    } else {
      this.m = true;
      this.n = true;
    } 
    if (getArguments() != null) {
      d = getArguments().getDouble("scale_scroll_out_border_num");
    } else {
      d = 1.0D;
    } 
    this.o = d;
    if (this.o < 1.0D)
      this.o = 1.0D; 
  }
  
  public void m() {
    // Byte code:
    //   0: aload_0
    //   1: getfield g : Lcom/github/chrisbanes/photoview/PhotoView;
    //   4: astore_3
    //   5: aload_3
    //   6: ifnull -> 134
    //   9: aload_3
    //   10: invokevirtual getAttacher : ()Lcom/github/chrisbanes/photoview/PhotoViewAttacher;
    //   13: ifnull -> 134
    //   16: aload_0
    //   17: getfield g : Lcom/github/chrisbanes/photoview/PhotoView;
    //   20: invokevirtual getAttacher : ()Lcom/github/chrisbanes/photoview/PhotoViewAttacher;
    //   23: invokevirtual a : ()Landroid/graphics/RectF;
    //   26: astore_3
    //   27: aload_3
    //   28: ifnonnull -> 32
    //   31: return
    //   32: aload_3
    //   33: invokevirtual width : ()F
    //   36: fstore_1
    //   37: aload_3
    //   38: invokevirtual height : ()F
    //   41: fstore_2
    //   42: fload_1
    //   43: fload_2
    //   44: fcmpl
    //   45: ifle -> 79
    //   48: fload_1
    //   49: fload_2
    //   50: ldc_w 3.0
    //   53: fmul
    //   54: fcmpl
    //   55: ifle -> 106
    //   58: getstatic com/blued/android/core/AppInfo.m : I
    //   61: aload_0
    //   62: invokevirtual getActivity : ()Landroidx/fragment/app/FragmentActivity;
    //   65: invokestatic a : (Landroid/app/Activity;)I
    //   68: isub
    //   69: i2f
    //   70: fstore_2
    //   71: aload_3
    //   72: invokevirtual height : ()F
    //   75: fstore_1
    //   76: goto -> 99
    //   79: fload_2
    //   80: fload_1
    //   81: ldc_w 3.0
    //   84: fmul
    //   85: fcmpl
    //   86: ifle -> 106
    //   89: getstatic com/blued/android/core/AppInfo.l : I
    //   92: i2f
    //   93: fstore_2
    //   94: aload_3
    //   95: invokevirtual width : ()F
    //   98: fstore_1
    //   99: fload_2
    //   100: fload_1
    //   101: fdiv
    //   102: fstore_1
    //   103: goto -> 108
    //   106: fconst_0
    //   107: fstore_1
    //   108: fload_1
    //   109: fconst_0
    //   110: fcmpl
    //   111: ifeq -> 134
    //   114: fload_1
    //   115: aload_0
    //   116: getfield g : Lcom/github/chrisbanes/photoview/PhotoView;
    //   119: invokevirtual getMediumScale : ()F
    //   122: fcmpl
    //   123: ifle -> 134
    //   126: aload_0
    //   127: getfield g : Lcom/github/chrisbanes/photoview/PhotoView;
    //   130: fload_1
    //   131: invokevirtual setMaximumScale : (F)V
    //   134: return
  }
  
  protected void n() {
    ProgressBar progressBar = this.h;
    if (progressBar != null)
      progressBar.setVisibility(0); 
  }
  
  public boolean o() {
    return this.n;
  }
  
  public void onActivityCreated(Bundle paramBundle) {
    super.onActivityCreated(paramBundle);
    q();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    View view = this.l;
    if (view == null) {
      this.l = paramLayoutInflater.inflate(R.layout.fragment_photo_detail, paramViewGroup, false);
      StatusBarHelper.a((Activity)getActivity());
      l();
      a();
    } else if (view.getParent() != null) {
      ((ViewGroup)this.l.getParent()).removeView(this.l);
    } 
    this.q = true;
    return this.l;
  }
  
  public void onDestroy() {
    super.onDestroy();
    PhotoView photoView = this.g;
    if (photoView != null) {
      ImageLoader.a(null, (ImageView)photoView);
      this.g.setImageDrawable(null);
    } 
  }
  
  public boolean onDoubleTap(MotionEvent paramMotionEvent) {
    try {
      float f1 = this.g.getScale();
      float f2 = paramMotionEvent.getX();
      float f3 = paramMotionEvent.getY();
      if (f1 < this.g.getMaximumScale()) {
        this.g.a(this.g.getMaximumScale(), f2, f3, true);
        return true;
      } 
      this.g.a(this.g.getMinimumScale(), f2, f3, true);
      return true;
    } catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
      return true;
    } 
  }
  
  public boolean onDoubleTapEvent(MotionEvent paramMotionEvent) {
    return false;
  }
  
  public void onPause() {
    super.onPause();
    if (this.g.getVisibility() == 0 && this.g.getAttacher() != null) {
      PhotoView photoView = this.g;
      photoView.a(photoView.getMinimumScale(), true);
    } 
  }
  
  public void onResume() {
    super.onResume();
    ViewDragHelperLayout viewDragHelperLayout = this.d;
    if (viewDragHelperLayout != null)
      viewDragHelperLayout.setScrollDisable(this.n); 
  }
  
  public boolean onSingleTapConfirmed(MotionEvent paramMotionEvent) {
    RectF rectF = this.g.getDisplayRect();
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    if (rectF != null) {
      if (rectF.contains(f1, f2)) {
        EventCallbackObserver.a().a((View)this.g);
        return true;
      } 
      EventCallbackObserver.a().b((View)this.g);
    } 
    return false;
  }
  
  protected void p() {
    ProgressBar progressBar = this.h;
    if (progressBar != null)
      progressBar.setVisibility(8); 
  }
  
  public void setUserVisibleHint(boolean paramBoolean) {
    super.setUserVisibleHint(paramBoolean);
    if (this.q) {
      if (paramBoolean) {
        a();
        return;
      } 
      if (this.g.getVisibility() == 0 && this.g.getAttacher() != null) {
        PhotoView photoView = this.g;
        photoView.a(photoView.getMinimumScale(), true);
        this.d.setScrollDisable(this.n);
      } 
    } 
  }
  
  public static interface GetConfigCallback {
    View a();
    
    View b();
    
    ImageView.ScaleType c();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\media\selector\fragment\PhotoDetailFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */