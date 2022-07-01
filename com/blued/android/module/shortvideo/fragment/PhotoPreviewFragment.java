package com.blued.android.module.shortvideo.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.blued.android.core.image.ImageLoadResult;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.framework.permission.PermissionCallbacks;
import com.blued.android.module.base.album.TakePhotoProxy;
import com.blued.android.module.shortvideo.R;
import com.blued.android.module.shortvideo.permission.PermissionHelper;
import com.github.chrisbanes.photoview.PhotoViewAttacher;
import java.io.File;

public class PhotoPreviewFragment extends BaseFragment {
  private Context d;
  
  private View e;
  
  private TextView f;
  
  private View g;
  
  private TextView h;
  
  private ImageView i;
  
  private ImageView j;
  
  private String k;
  
  private ImageView l;
  
  private PhotoViewAttacher m;
  
  private ProgressBar n;
  
  public static void a(BaseFragment paramBaseFragment, String paramString, int paramInt) {
    PermissionHelper.a(new PermissionCallbacks(paramString, paramBaseFragment, paramInt) {
          public void a(String[] param1ArrayOfString) {}
          
          public void aa_() {
            Bundle bundle = new Bundle();
            bundle.putString("frame_path", this.a);
            TerminalActivity.a((Fragment)this.b, PhotoPreviewFragment.class, bundle, this.c);
          }
        });
  }
  
  private void k() {
    this.g = this.e.findViewById(R.id.top_title);
    this.i = (ImageView)this.g.findViewById(R.id.top_ctt_left);
    this.h = (TextView)this.g.findViewById(R.id.top_ctt_center);
    this.j = (ImageView)this.g.findViewById(R.id.top_ctt_right);
    this.f = (TextView)this.e.findViewById(R.id.top_done_view);
    this.j.setVisibility(8);
    this.f.setVisibility(0);
    this.f.setText(this.d.getResources().getString(R.string.photo_end));
    this.l = (ImageView)this.e.findViewById(R.id.photo_pre_view_img);
    this.n = (ProgressBar)this.e.findViewById(R.id.photo_pre_loading_view);
    this.m = new PhotoViewAttacher(this.l);
    this.i.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            File file = new File(PhotoPreviewFragment.a(this.a));
            if (file.exists())
              file.delete(); 
            this.a.getActivity().finish();
          }
        });
    this.f.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            TakePhotoProxy.a().a(PhotoPreviewFragment.a(this.a));
            this.a.getActivity().setResult(-1);
            this.a.getActivity().finish();
          }
        });
  }
  
  private void l() {
    this.n.setVisibility(0);
    ImageLoader.d((IRequestHost)w_(), this.k).a(new ImageLoadResult(this, (IRequestHost)w_()) {
          public void a() {
            PhotoPreviewFragment.b(this.a).g();
          }
          
          public void b() {
            PhotoPreviewFragment.c(this.a).setVisibility(8);
          }
        }).a(this.l);
  }
  
  public void a() {
    Bundle bundle = getArguments();
    if (bundle != null)
      this.k = bundle.getString("frame_path"); 
  }
  
  public void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    if (paramBundle != null)
      this.k = paramBundle.getString("frame_path"); 
    this.d = (Context)getActivity();
    View view = this.e;
    if (view == null) {
      this.e = paramLayoutInflater.inflate(R.layout.fragment_photo_preview, paramViewGroup, false);
      k();
      a();
      l();
    } else if (view.getParent() != null) {
      ((ViewGroup)this.e.getParent()).removeView(this.e);
    } 
    return this.e;
  }
  
  public void onSaveInstanceState(Bundle paramBundle) {
    paramBundle.putString("frame_path", this.k);
    super.onSaveInstanceState(paramBundle);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\module\shortvideo\fragment\PhotoPreviewFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */