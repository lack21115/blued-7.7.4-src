package com.soft.blued.ui.feed.fragment;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.blued.android.core.AppInfo;
import com.blued.android.core.image.ImageLoadResult;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.image.ImageWrapper;
import com.blued.android.core.imagecache.LoadOptions;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.framework.utils.ImageUtils;
import com.blued.android.module.common.utils.AvatarUtils;
import com.blued.android.module.player.media.observer.EventCallbackObserver;
import com.github.chrisbanes.photoview.OnOutsidePhotoTapListener;
import com.github.chrisbanes.photoview.OnPhotoTapListener;
import com.github.chrisbanes.photoview.PhotoView;
import com.soft.blued.customview.ActionSheet;
import com.soft.blued.utils.ActivityChangeAnimationUtils;
import com.soft.blued.utils.DeviceUtils;
import com.soft.blued.view.tip.CommonShowBottomWindow;
import java.io.Serializable;

public class ImageDetailFragment extends BaseFragment implements View.OnClickListener {
  private String d;
  
  private PhotoView e;
  
  private ProgressBar f;
  
  private boolean g;
  
  private int h;
  
  private LoadOptions i;
  
  private Bitmap j;
  
  private int k;
  
  private int l;
  
  public static ImageDetailFragment a(String paramString, boolean paramBoolean, int paramInt1, LoadOptions paramLoadOptions, int paramInt2, int paramInt3) {
    ImageDetailFragment imageDetailFragment = new ImageDetailFragment();
    Bundle bundle = new Bundle();
    bundle.putString("url", paramString);
    bundle.putBoolean("islocal", paramBoolean);
    bundle.putInt("come_code", paramInt1);
    bundle.putInt("current_position", paramInt2);
    bundle.putInt("start_position", paramInt3);
    bundle.putSerializable("photo_options", (Serializable)paramLoadOptions);
    imageDetailFragment.setArguments(bundle);
    return imageDetailFragment;
  }
  
  private void a() {
    if (this.k == this.l) {
      if (Build.VERSION.SDK_INT >= 21 && !DeviceUtils.e()) {
        getActivity().finishAfterTransition();
        return;
      } 
      getActivity().finish();
      ActivityChangeAnimationUtils.h((Activity)getActivity());
      return;
    } 
    getActivity().finish();
    ActivityChangeAnimationUtils.h((Activity)getActivity());
  }
  
  private ImageLoadResult k() {
    return new ImageLoadResult(this, (IRequestHost)w_()) {
        public void a() {
          ImageDetailFragment.c(this.a).setOnLongClickListener(new View.OnLongClickListener(this) {
                public boolean onLongClick(View param2View) {
                  String[] arrayOfString = AppInfo.d().getResources().getStringArray(2130903078);
                  CommonShowBottomWindow.a(this.a.a.getActivity(), arrayOfString, "#3494f4", new ActionSheet.ActionSheetListener(this) {
                        public void a(ActionSheet param3ActionSheet, int param3Int) {
                          ImageUtils.a(ImageDetailFragment.d(this.a.a.a));
                        }
                        
                        public void a(ActionSheet param3ActionSheet, boolean param3Boolean) {}
                      });
                  return false;
                }
              });
        }
        
        public void b() {
          ImageDetailFragment.e(this.a).setVisibility(8);
        }
      };
  }
  
  public boolean V_() {
    EventCallbackObserver.a().d();
    a();
    PhotosRefreshObserver.a().b();
    return true;
  }
  
  public void onActivityCreated(Bundle paramBundle) {
    super.onActivityCreated(paramBundle);
    if (!TextUtils.isEmpty(this.d)) {
      this.f.setVisibility(0);
      if (this.g) {
        ImageWrapper imageWrapper;
        this.e.setLayerType(1, null);
        if (this.d.toLowerCase().startsWith("content://")) {
          imageWrapper = ImageLoader.b((IRequestHost)w_(), this.d);
        } else {
          imageWrapper = ImageLoader.d((IRequestHost)w_(), this.d);
        } 
        imageWrapper.a(k()).a((ImageView)this.e);
        return;
      } 
      String str2 = this.d;
      int i = this.h;
      String str1 = str2;
      if (i != 0)
        if (i != 1) {
          str1 = str2;
          if (i != 2)
            str1 = str2; 
        } else {
          str1 = AvatarUtils.a(0, str2);
        }  
      if (this.h == 5) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.d);
        stringBuilder.append("!o.png");
        String str = stringBuilder.toString();
      } else {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.d);
        stringBuilder.append("!original.png");
        str2 = stringBuilder.toString();
      } 
      ImageLoader.a((IRequestHost)w_(), str2).a(str1).e().a(k()).a((ImageView)this.e);
      return;
    } 
    this.e.setImageResource(2131234356);
  }
  
  public void onClick(View paramView) {
    paramView.getId();
  }
  
  public void onCreate(Bundle paramBundle) {
    boolean bool2;
    super.onCreate(paramBundle);
    if (getArguments() != null) {
      String str = getArguments().getString("url");
    } else {
      paramBundle = null;
    } 
    this.d = (String)paramBundle;
    paramBundle = getArguments();
    boolean bool1 = false;
    if (paramBundle != null && getArguments().getBoolean("islocal")) {
      bool2 = true;
    } else {
      bool2 = false;
    } 
    this.g = bool2;
    if (getArguments() != null) {
      i = getArguments().getInt("come_code");
    } else {
      i = 0;
    } 
    this.h = i;
    if (getArguments() != null) {
      i = getArguments().getInt("current_position");
    } else {
      i = 0;
    } 
    this.k = i;
    int i = bool1;
    if (getArguments() != null)
      i = getArguments().getInt("start_position"); 
    this.l = i;
    this.i = (LoadOptions)getArguments().getSerializable("photo_options");
    if (this.i == null)
      this.i = new LoadOptions(); 
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    View view = paramLayoutInflater.inflate(2131493157, paramViewGroup, false);
    this.f = (ProgressBar)view.findViewById(2131299159);
    this.e = (PhotoView)view.findViewById(2131299468);
    this.e.setMaximumScale(5.0F);
    this.e.setOnPhotoTapListener(new OnPhotoTapListener(this) {
          public void a(ImageView param1ImageView, float param1Float1, float param1Float2) {
            if (ImageDetailFragment.a(this.a) != 4) {
              ImageDetailFragment.b(this.a);
              return;
            } 
            EventCallbackObserver.a().a((View)ImageDetailFragment.c(this.a));
          }
        });
    this.e.setOnOutsidePhotoTapListener(new OnOutsidePhotoTapListener(this) {
          public void a(ImageView param1ImageView) {
            if (ImageDetailFragment.a(this.a) != 4) {
              ImageDetailFragment.b(this.a);
              return;
            } 
            EventCallbackObserver.a().b((View)ImageDetailFragment.c(this.a));
          }
        });
    return view;
  }
  
  public void onDestroy() {
    super.onDestroy();
    this.e.setImageDrawable(null);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\feed\fragment\ImageDetailFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */