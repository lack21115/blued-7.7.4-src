package com.soft.blued.ui.feed.fragment;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.blued.android.core.image.ImageLoadResult;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.imagecache.RecyclingUtils;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.framework.permission.PermissionCallbacks;
import com.blued.android.framework.pool.ThreadExecutor;
import com.blued.android.framework.pool.ThreadManager;
import com.blued.android.framework.utils.FileUtils;
import com.blued.android.framework.utils.Houyi;
import com.blued.android.framework.utils.LogUtils;
import com.blued.android.module.common.utils.DialogUtils;
import com.github.chrisbanes.photoview.PhotoViewAttacher;
import com.soft.blued.app.permission.PermissionHelper;
import com.soft.blued.ui.feed.manager.SelectPhotoManager;
import com.soft.blued.ui.feed.model.ChildImageInfo;
import com.soft.blued.utils.FileUtils;
import com.soft.blued.utils.Logger;
import java.io.File;

public class TakePhotoFragment extends BaseFragment {
  private Context d;
  
  private View e;
  
  private TextView f;
  
  private View g;
  
  private TextView h;
  
  private ImageView i;
  
  private ImageView j;
  
  private String k;
  
  private String l;
  
  private ImageView m;
  
  private PhotoViewAttacher n;
  
  private ProgressBar o;
  
  private int p;
  
  private String q;
  
  private Dialog r;
  
  private String s;
  
  public static void a(BaseFragment paramBaseFragment, int paramInt1, int paramInt2, String paramString) {
    PermissionHelper.b(new PermissionCallbacks(paramInt2, paramString, paramBaseFragment, paramInt1) {
          public void a(String[] param1ArrayOfString) {}
          
          public void aa_() {
            Bundle bundle = new Bundle();
            bundle.putInt("select_photo", this.a);
            bundle.putString("super_topic_id", this.b);
            TerminalActivity.a((Fragment)this.c, TakePhotoFragment.class, bundle, this.d);
          }
        });
  }
  
  private void l() {
    this.g = this.e.findViewById(2131300273);
    this.i = (ImageView)this.g.findViewById(2131296863);
    this.h = (TextView)this.g.findViewById(2131296857);
    this.j = (ImageView)this.g.findViewById(2131296867);
    this.f = (TextView)this.e.findViewById(2131296955);
    this.j.setVisibility(8);
    this.f.setVisibility(0);
    this.f.setText(this.d.getResources().getString(2131758381));
    this.m = (ImageView)this.e.findViewById(2131299472);
    this.o = (ProgressBar)this.e.findViewById(2131299159);
    this.n = new PhotoViewAttacher(this.m);
    this.i.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            this.a.getActivity().finish();
          }
        });
    this.f.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            ChildImageInfo childImageInfo = new ChildImageInfo();
            childImageInfo.mImagePath = TakePhotoFragment.a(this.a);
            childImageInfo.mSelect = true;
            SelectPhotoManager.a().a(childImageInfo);
            this.a.getActivity().setResult(-1);
            this.a.getActivity().finish();
            int i = TakePhotoFragment.b(this.a);
            if (i != 5) {
              if (i != 7) {
                FeedPostFragment.a(TakePhotoFragment.c(this.a));
                return;
              } 
              SelectPhotoManager.a().c().addAll(0, PhotoSelectFragment.d);
              return;
            } 
            SelectPhotoManager.a().c().addAll(0, PhotoSelectFragment.d);
            PhotosRefreshObserver.a().b();
          }
        });
  }
  
  private void m() {
    ImageLoader.d((IRequestHost)w_(), this.k).a(new ImageLoadResult(this, (IRequestHost)w_()) {
          public void a() {
            TakePhotoFragment.d(this.a).g();
          }
        }).a(this.m);
  }
  
  public void a() {
    Bundle bundle = getArguments();
    if (bundle != null) {
      this.p = bundle.getInt("select_photo", 0);
      this.q = bundle.getString("super_topic_id");
    } 
  }
  
  public void k() {
    String str = RecyclingUtils.a();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(System.currentTimeMillis());
    stringBuilder.append(".jpg");
    this.l = stringBuilder.toString();
    stringBuilder = new StringBuilder();
    stringBuilder.append(str);
    stringBuilder.append(File.separator);
    stringBuilder.append(this.l);
    this.k = stringBuilder.toString();
    File file = new File(str);
    if (!file.exists())
      file.mkdirs(); 
    Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
    intent.addFlags(1);
    intent.addFlags(2);
    intent.putExtra("output", (Parcelable)FileUtils.b(this.k));
    startActivityForResult(intent, 0);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
    Logger.a("onActivityResult", new Object[] { "requestCode = ", Integer.valueOf(paramInt1) });
    if (paramInt2 == 0) {
      if (paramInt1 == 0)
        getActivity().setResult(0, paramIntent); 
      getActivity().finish();
      return;
    } 
    if (paramInt1 == 0)
      PermissionHelper.e(new PermissionCallbacks(this) {
            public void a(String[] param1ArrayOfString) {}
            
            public void aa_() {
              Logger.a("onActivityResult", new Object[] { "requestCode TAKE_PHOTO" });
              String str = TakePhotoFragment.a(this.a);
              StringBuilder stringBuilder2 = new StringBuilder();
              stringBuilder2.append("oldPath: ");
              stringBuilder2.append(str);
              LogUtils.c(stringBuilder2.toString());
              if (TakePhotoFragment.e(this.a) == null) {
                TakePhotoFragment takePhotoFragment1 = this.a;
                TakePhotoFragment.a(takePhotoFragment1, DialogUtils.a((Context)takePhotoFragment1.getActivity()));
              } 
              TakePhotoFragment.e(this.a).show();
              File file = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
              TakePhotoFragment takePhotoFragment = this.a;
              StringBuilder stringBuilder3 = new StringBuilder();
              stringBuilder3.append(file.getAbsolutePath());
              stringBuilder3.append(File.separator);
              stringBuilder3.append("blued");
              stringBuilder3.append(File.separator);
              stringBuilder3.append(TakePhotoFragment.f(this.a));
              TakePhotoFragment.a(takePhotoFragment, stringBuilder3.toString());
              StringBuilder stringBuilder1 = new StringBuilder();
              stringBuilder1.append("oldPath: ");
              stringBuilder1.append(str);
              stringBuilder1.append(", imgSavePath: ");
              stringBuilder1.append(TakePhotoFragment.g(this.a));
              stringBuilder1.append(", mFileName: ");
              stringBuilder1.append(TakePhotoFragment.f(this.a));
              LogUtils.c(stringBuilder1.toString());
              ThreadManager.a().a(new ThreadExecutor(this, "saveImgToPicDir", str) {
                    public void execute() {
                      FileUtils.a(this.a, TakePhotoFragment.g(this.b.a), TakePhotoFragment.f(this.b.a));
                      Houyi.a().a(TakePhotoFragment.a(this.b.a)).b();
                      this.b.a.a(new Runnable(this) {
                            public void run() {
                              if (TakePhotoFragment.e(this.a.b.a) != null)
                                TakePhotoFragment.e(this.a.b.a).dismiss(); 
                              FragmentActivity fragmentActivity = this.a.b.a.getActivity();
                              StringBuilder stringBuilder = new StringBuilder();
                              stringBuilder.append("file://");
                              stringBuilder.append(TakePhotoFragment.g(this.a.b.a));
                              fragmentActivity.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.parse(stringBuilder.toString())));
                              TakePhotoFragment.h(this.a.b.a);
                            }
                          });
                    }
                  });
            }
          }); 
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    this.d = (Context)getActivity();
    View view = this.e;
    if (view == null) {
      this.e = paramLayoutInflater.inflate(2131493311, paramViewGroup, false);
      l();
      a();
    } else if (view.getParent() != null) {
      ((ViewGroup)this.e.getParent()).removeView(this.e);
    } 
    if (paramBundle == null) {
      k();
    } else {
      this.k = paramBundle.getString("path");
      this.l = paramBundle.getString("name");
    } 
    return this.e;
  }
  
  public void onSaveInstanceState(Bundle paramBundle) {
    paramBundle.putString("path", this.k);
    paramBundle.putString("name", this.l);
    super.onSaveInstanceState(paramBundle);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\feed\fragment\TakePhotoFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */