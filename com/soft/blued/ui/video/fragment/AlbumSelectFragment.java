package com.soft.blued.ui.video.fragment;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.blued.android.core.AppMethods;
import com.blued.android.core.imagecache.RecyclingUtils;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.permission.PermissionCallbacks;
import com.blued.android.framework.pool.ThreadExecutor;
import com.blued.android.framework.pool.ThreadManager;
import com.blued.android.framework.utils.FileUtils;
import com.blued.android.framework.utils.LogUtils;
import com.blued.android.framework.view.CustomDialog;
import com.blued.android.module.base.shortvideo.ShortVideoProxy;
import com.blued.android.module.common.utils.DialogUtils;
import com.blued.android.module.live_china.manager.LiveFloatManager;
import com.blued.android.module.media.selector.fragment.AlbumBaseFragment;
import com.blued.android.module.media.selector.model.AlbumDataManager;
import com.blued.android.module.media.selector.model.AlbumSelectInfo;
import com.blued.android.module.media.selector.present.AlbumBasePresenter;
import com.blued.android.module.media.selector.present.MediaBasePresent;
import com.blued.android.module.player.media.model.MediaInfo;
import com.soft.blued.app.permission.PermissionHelper;
import com.soft.blued.ui.feed.fragment.TakePhotoFragment;
import com.soft.blued.ui.find.observer.FeedRefreshObserver;
import com.soft.blued.ui.msg.DialogSkipFragment;
import com.soft.blued.ui.video.presenter.AlbumSelectPresent;
import com.soft.blued.ui.video.view.AlbumTabsView;
import com.soft.blued.utils.AppUtils;
import com.soft.blued.utils.PopMenuUtils;

public class AlbumSelectFragment extends AlbumBaseFragment implements FeedRefreshObserver.IFeedRefreshObserver, AlbumTabsView.ITabsClickListener {
  protected int d;
  
  private int g;
  
  private int h;
  
  private int i;
  
  private AlbumSelectPresent j;
  
  private CustomDialog k;
  
  private View l;
  
  private TextView m;
  
  private TextView n;
  
  private TextView o;
  
  private TextView p;
  
  private Dialog q;
  
  public static Bundle a(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    Bundle bundle = new Bundle();
    bundle.putInt("from", paramInt1);
    bundle.putInt("page_type", paramInt4);
    bundle.putInt("select_photo_max_num", paramInt3);
    bundle.putInt("album_data_type", paramInt2);
    return bundle;
  }
  
  private void a(ViewGroup paramViewGroup) {
    this.l = LayoutInflater.from(getContext()).inflate(2131493743, paramViewGroup, false);
    this.m = (TextView)this.l.findViewById(2131301409);
    this.m.setVisibility(8);
    this.o = (TextView)this.l.findViewById(2131300611);
    this.o.setText(2131755726);
    this.n = (TextView)this.l.findViewById(2131301130);
    this.n.setText(2131758968);
    this.p = (TextView)this.l.findViewById(2131300703);
    this.p.setText(getString(2131758679));
  }
  
  public static void a(Object paramObject, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    a(paramObject, paramInt1, paramInt2, paramInt3, 0, paramInt4);
  }
  
  public static void a(Object paramObject, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {
    Context context;
    if (paramObject instanceof Fragment) {
      context = ((Fragment)paramObject).getContext();
    } else {
      context = (Context)paramObject;
    } 
    if (context == null)
      return; 
    if (Build.VERSION.SDK_INT < 18) {
      AppMethods.d(2131757818);
      return;
    } 
    if (!PopMenuUtils.a(context, null)) {
      if (LiveFloatManager.a().F()) {
        DialogSkipFragment.a(context, 4);
        return;
      } 
      PermissionHelper.g(new PermissionCallbacks(paramInt1, paramInt2, paramInt3, paramInt4, paramObject, paramInt5) {
            public void a(String[] param1ArrayOfString) {}
            
            public void aa_() {
              Bundle bundle = AlbumSelectFragment.a(this.a, this.b, this.c, this.d);
              Object object = this.e;
              if (object instanceof Activity) {
                TerminalActivity.a((Context)object, AlbumSelectFragment.class, bundle, this.f);
                return;
              } 
              if (object instanceof Fragment) {
                TerminalActivity.a((Fragment)object, AlbumSelectFragment.class, bundle, this.f);
                return;
              } 
              if (object instanceof android.app.Application)
                TerminalActivity.d((Context)object, AlbumSelectFragment.class, bundle); 
            }
          });
    } 
  }
  
  public void D() {}
  
  public void E() {
    if (((AlbumBasePresenter)this.e).c() > 0) {
      b(1);
      return;
    } 
    if (this.g == 1) {
      c();
      return;
    } 
    ShortVideoProxy.e().a(b(), this.d, 2, 1001);
  }
  
  public void F() {
    if (((AlbumBasePresenter)this.e).c() > 0) {
      b(3);
      return;
    } 
    TakePhotoFragment.a(b(), 1002, 11, "");
  }
  
  public int S_() {
    return this.h;
  }
  
  public long T_() {
    return 2950L;
  }
  
  public long U_() {
    return this.j.a();
  }
  
  protected void a(int paramInt) {
    AlbumPreviewFragment.a(b(), this.d, paramInt, 1);
  }
  
  public void a(Object paramObject, int paramInt) {
    if (paramInt == 3)
      ShortVideoProxy.e().c(); 
  }
  
  public boolean a(int paramInt, MediaInfo paramMediaInfo) {
    if (paramMediaInfo != null)
      if (paramMediaInfo.media_type == AlbumBasePresenter.m()) {
        LogUtils.c("start video copy");
        if (AlbumDataManager.getSelectImageSize() <= 0 && paramMediaInfo != null)
          if (Build.VERSION.SDK_INT >= 29 && !Environment.isExternalStorageLegacy() && !AppUtils.b(paramMediaInfo.path)) {
            this.q.show();
            ThreadManager.a().a(new ThreadExecutor(this, "CopyVideo", paramMediaInfo) {
                  public void execute() {
                    LogUtils.c("start video copy thread");
                    String str = RecyclingUtils.e("video");
                    FileUtils.a(this.a.path, str);
                    this.a.path = str;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("finish video copy thread: ");
                    stringBuilder.append(str);
                    LogUtils.c(stringBuilder.toString());
                    this.b.a(new Runnable(this) {
                          public void run() {
                            LogUtils.c("start showShortVideoTrim");
                            if (AlbumSelectFragment.a(this.a.b) != null)
                              AlbumSelectFragment.a(this.a.b).dismiss(); 
                            ShortVideoProxy.e().a(this.a.b.b(), this.a.a.path, this.a.b.d, 1000);
                          }
                        });
                  }
                });
          } else {
            ShortVideoProxy.e().a(b(), paramMediaInfo.path, this.d, 1000);
          }  
      } else {
        a(paramInt);
      }  
    return true;
  }
  
  public boolean a(Activity paramActivity, int paramInt1, int paramInt2, Intent paramIntent) {
    if (paramInt2 == -1) {
      if (paramInt1 != 1)
        switch (paramInt1) {
          default:
            return false;
          case 1000:
          case 1001:
          case 1002:
            break;
        }  
      if (paramIntent != null && paramIntent.getBooleanExtra("close_page", false)) {
        getActivity().setResult(-1, paramIntent);
        c();
        return true;
      } 
    } 
    return false;
  }
  
  public boolean a(AlbumSelectInfo paramAlbumSelectInfo) {
    if (paramAlbumSelectInfo != null) {
      AlbumSelectPresent albumSelectPresent = this.j;
      if (albumSelectPresent != null) {
        albumSelectPresent.a(b(), paramAlbumSelectInfo, this.d, 1000);
        return true;
      } 
    } 
    return false;
  }
  
  public void b(int paramInt) {
    if (this.k == null) {
      this.k = new CustomDialog(getContext(), 2131821111);
      this.k.requestWindowFeature(1);
      this.k.getWindow().setFlags(1024, 1024);
      this.k.setContentView(this.l);
      this.k.setCancelable(false);
    } 
    CustomDialog customDialog = this.k;
    if (customDialog != null && customDialog.isShowing())
      this.k.dismiss(); 
    this.o.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            AlbumSelectFragment.b(this.a).dismiss();
          }
        });
    this.n.setOnClickListener(new View.OnClickListener(this, paramInt) {
          public void onClick(View param1View) {
            AlbumSelectFragment.b(this.b).dismiss();
            if (AlbumSelectFragment.c(this.b) != null) {
              AlbumBasePresenter.o();
              this.b.d();
            } 
            int i = this.a;
            if (i != 1) {
              if (i != 3) {
                this.b.c();
                return;
              } 
              this.b.F();
              return;
            } 
            this.b.E();
          }
        });
    this.k.show();
  }
  
  public int i() {
    int i = this.d;
    return (i == 1 || i == 7) ? 2 : this.i;
  }
  
  public void k() {
    if (getArguments() == null)
      return; 
    this.d = getArguments().getInt("from");
    this.g = getArguments().getInt("page_type");
    this.h = getArguments().getInt("select_photo_max_num", 9);
    this.i = getArguments().getInt("album_data_type", 3);
  }
  
  public int l() {
    return 4;
  }
  
  public CharSequence o() {
    String str = getString(2131756172);
    int i = str.indexOf("^");
    int j = str.lastIndexOf("^");
    int k = str.length();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(str.substring(0, i));
    stringBuilder.append(str.substring(i + 1, j));
    stringBuilder.append(str.substring(j + 1, k));
    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(stringBuilder.toString());
    spannableStringBuilder.setSpan(new ForegroundColorSpan(getResources().getColor(2131100538)), i, j - 1, 33);
    return (CharSequence)spannableStringBuilder;
  }
  
  public void onActivityCreated(Bundle paramBundle) {
    super.onActivityCreated(paramBundle);
    v().setTextColor(BluedSkinUtils.a(getContext(), 2131100838));
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    a(paramViewGroup);
    this.j = new AlbumSelectPresent((Activity)getActivity());
    ShortVideoProxy.e().a(getClass().getSimpleName());
    FeedRefreshObserver.a().a(this);
    this.q = DialogUtils.a((Context)getActivity());
    return super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
  }
  
  public void onDestroyView() {
    FeedRefreshObserver.a().b(this);
    ShortVideoProxy.e().b(getClass().getSimpleName());
    super.onDestroyView();
  }
  
  public int p() {
    return 6;
  }
  
  public View q() {
    if (this.d != 4) {
      AlbumTabsView albumTabsView = new AlbumTabsView(getContext());
      if (this.d == 1) {
        albumTabsView.a(this, false, 2);
        return (View)albumTabsView;
      } 
      albumTabsView.a(this, true, 2);
      return (View)albumTabsView;
    } 
    return null;
  }
  
  public Drawable t() {
    return BluedSkinUtils.b(getContext(), 2131233084);
  }
  
  public Drawable u() {
    return BluedSkinUtils.b(getContext(), 2131233085);
  }
  
  public int w() {
    return getContext().getResources().getColor(2131099781);
  }
  
  public boolean x() {
    return (this.d == 1);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\video\fragment\AlbumSelectFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */