package com.soft.blued.ui.feed.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.blued.android.core.image.ImageFileLoader;
import com.blued.android.core.image.ImageLoadResult;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.imagecache.MemoryRequest;
import com.blued.android.core.imagecache.RecyclingUtils;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.framework.utils.Houyi;
import com.github.chrisbanes.photoview.PhotoViewAttacher;
import com.soft.blued.customview.CommonTopTitleNoTrans;
import com.soft.blued.utils.ImageUtils;
import java.io.File;

public class SendPhotoFragment extends BaseFragment {
  private Context d;
  
  private View e;
  
  private TextView f;
  
  private CommonTopTitleNoTrans g;
  
  private ImageView h;
  
  private LinearLayout i;
  
  private String j;
  
  private ImageView k;
  
  private PhotoViewAttacher l;
  
  private ProgressBar m;
  
  private String n;
  
  private int o;
  
  private int p;
  
  private int q;
  
  private boolean r = false;
  
  private void a() {
    Bundle bundle = getArguments();
    if (bundle != null) {
      this.j = bundle.getString("photo_path");
      this.n = bundle.getString("msg_path");
      this.r = bundle.getBoolean("KEY_IS_GROUP");
    } 
  }
  
  public static void a(BaseFragment paramBaseFragment, String paramString1, int paramInt, String paramString2, boolean paramBoolean) {
    Bundle bundle = new Bundle();
    bundle.putString("photo_path", paramString1);
    bundle.putString("msg_path", paramString2);
    bundle.putBoolean("KEY_IS_GROUP", paramBoolean);
    TerminalActivity.a((Fragment)paramBaseFragment, SendPhotoFragment.class, bundle, paramInt);
  }
  
  private void a(String paramString) {
    if ((new File(paramString)).exists()) {
      int[] arrayOfInt = ImageUtils.b(paramString);
      this.p = arrayOfInt[0];
      this.q = arrayOfInt[1];
    } 
  }
  
  private void k() {
    this.g = (CommonTopTitleNoTrans)this.e.findViewById(2131300300);
    this.g.a();
    this.g.setCenterText(getString(2131758696));
    this.g.setLeftText(2131755726);
    this.g.setLeftClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            this.a.getActivity().finish();
          }
        });
    this.f = (TextView)this.e.findViewById(2131299890);
    this.f.setVisibility(0);
    this.f.setText(this.d.getResources().getString(2131758680));
    this.k = (ImageView)this.e.findViewById(2131299472);
    this.m = (ProgressBar)this.e.findViewById(2131299159);
    this.h = (ImageView)this.e.findViewById(2131296921);
    this.i = (LinearLayout)this.e.findViewById(2131296922);
    if (this.r) {
      this.i.setVisibility(8);
    } else {
      this.i.setVisibility(0);
    } 
    this.l = new PhotoViewAttacher(this.k);
    this.i.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            if (SendPhotoFragment.a(this.a) == 1) {
              SendPhotoFragment.b(this.a).setImageResource(2131231377);
              SendPhotoFragment.a(this.a, 0);
              return;
            } 
            SendPhotoFragment.b(this.a).setImageResource(2131231378);
            SendPhotoFragment.a(this.a, 1);
          }
        });
    this.f.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            try {
              String str;
              if (!TextUtils.isEmpty(SendPhotoFragment.c(this.a))) {
                str = SendPhotoFragment.c(this.a);
              } else {
                str = RecyclingUtils.e("photo");
              } 
              Houyi.a().a(SendPhotoFragment.d(this.a), str).b();
              ImageFileLoader.a((IRequestHost)this.a.w_()).c(str).a();
              SendPhotoFragment.a(this.a, str);
              Intent intent = new Intent();
              intent.putExtra("photo_path", str);
              intent.putExtra("photo_width", SendPhotoFragment.e(this.a));
              intent.putExtra("photo_height", SendPhotoFragment.f(this.a));
              intent.putExtra("destroy_switch", SendPhotoFragment.a(this.a));
              this.a.getActivity().setResult(-1, intent);
              this.a.getActivity().finish();
              return;
            } catch (OutOfMemoryError outOfMemoryError) {
              MemoryRequest.a().b();
              return;
            } 
          }
        });
    ImageLoader.d((IRequestHost)w_(), this.j).a(new ImageLoadResult(this, (IRequestHost)w_()) {
          public void a() {
            SendPhotoFragment.g(this.a).g();
          }
        }).a(this.k);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    this.d = (Context)getActivity();
    View view = this.e;
    if (view == null) {
      this.e = paramLayoutInflater.inflate(2131493309, paramViewGroup, false);
      a();
      k();
    } else if (view.getParent() != null) {
      ((ViewGroup)this.e.getParent()).removeView(this.e);
    } 
    return this.e;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\feed\fragment\SendPhotoFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */