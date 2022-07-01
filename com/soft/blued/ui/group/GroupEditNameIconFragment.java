package com.soft.blued.ui.group;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.imagecache.LoadOptions;
import com.blued.android.core.imagecache.RecyclingUtils;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.upload.QiniuUploadTools;
import com.blued.android.module.common.utils.DialogUtils;
import com.soft.blued.customview.ActionSheet;
import com.soft.blued.customview.CommonTopTitleNoTrans;
import com.soft.blued.http.GroupHttpUtils;
import com.soft.blued.model.BluedAlbum;
import com.soft.blued.ui.feed.fragment.PhotoSelectFragment;
import com.soft.blued.ui.photo.fragment.BasePhotoFragment;
import com.soft.blued.utils.StringUtils;
import com.soft.blued.utils.third.QiniuUploadUtils;
import com.soft.blued.view.tip.CommonShowBottomWindow;

public class GroupEditNameIconFragment extends BaseFragment implements View.OnClickListener {
  private String d = GroupEditNameIconFragment.class.getSimpleName();
  
  private View e;
  
  private Context f;
  
  private LinearLayout g;
  
  private LinearLayout h;
  
  private ImageView i;
  
  private LoadOptions j;
  
  private Dialog k;
  
  private TextView l;
  
  private String m;
  
  private String n;
  
  private String o;
  
  private String[] p = new String[2];
  
  private String q;
  
  private boolean r;
  
  private boolean s;
  
  private void a(String paramString) {
    GroupHttpUtils.a(this.f, new BluedUIHttpResponse<BluedEntityA<BluedAlbum>>(this, paramString) {
          protected void a(BluedEntityA<BluedAlbum> param1BluedEntityA) {
            if (param1BluedEntityA != null && param1BluedEntityA.hasData()) {
              BluedAlbum bluedAlbum = (BluedAlbum)param1BluedEntityA.getSingleData();
              GroupEditNameIconFragment.a(this.b, this.a, bluedAlbum);
            } 
          }
        }this.o, (IRequestHost)w_());
  }
  
  private void a(String paramString, BluedAlbum paramBluedAlbum) {
    QiniuUploadUtils.a(paramString, paramBluedAlbum, new QiniuUploadTools.QiNiuListener(this) {
          public void a(String param1String) {}
          
          public void a(String param1String, double param1Double) {}
          
          public void a(String param1String1, String param1String2) {
            GroupEditNameIconFragment.a(this.a, param1String1);
          }
          
          public boolean a() {
            return false;
          }
        });
  }
  
  private void b(String paramString) {
    GroupHttpUtils.j(this.f, new BluedUIHttpResponse<BluedEntityA<BluedAlbum>>(this) {
          protected void a(BluedEntityA<BluedAlbum> param1BluedEntityA) {
            if (param1BluedEntityA != null && param1BluedEntityA.hasData()) {
              ImageLoader.d((IRequestHost)this.a.w_(), GroupEditNameIconFragment.c(this.a)).c().a(GroupEditNameIconFragment.b(this.a));
              GroupEditNameIconFragment.a(this.a, true);
            } 
          }
          
          public void onUIFinish() {
            super.onUIFinish();
            DialogUtils.b(GroupEditNameIconFragment.a(this.a));
          }
          
          public void onUIStart() {
            super.onUIStart();
            DialogUtils.a(GroupEditNameIconFragment.a(this.a));
          }
        }paramString, this.o, (IRequestHost)w_());
  }
  
  private void k() {
    CommonTopTitleNoTrans commonTopTitleNoTrans = (CommonTopTitleNoTrans)this.e.findViewById(2131300300);
    commonTopTitleNoTrans.a();
    commonTopTitleNoTrans.setCenterText(getString(2131756670));
    commonTopTitleNoTrans.setLeftClickListener(this);
  }
  
  private void l() {
    this.k = DialogUtils.a(this.f);
    this.p[0] = this.f.getResources().getString(2131756853);
    this.p[1] = this.f.getResources().getString(2131756854);
    this.g = (LinearLayout)this.e.findViewById(2131298864);
    this.g.setOnClickListener(this);
    this.h = (LinearLayout)this.e.findViewById(2131298865);
    this.h.setOnClickListener(this);
    this.l = (TextView)this.e.findViewById(2131300827);
    this.l.setText(this.m);
    this.i = (ImageView)this.e.findViewById(2131297793);
    if (StringUtils.e(this.n)) {
      this.i.setImageResource(2131232322);
      return;
    } 
    ImageLoader.a((IRequestHost)w_(), this.n).c().a(2131234356).a(this.i);
  }
  
  private void m() {
    if (this.r || this.s) {
      Intent intent = new Intent();
      if (this.r)
        intent.putExtra("name", this.m); 
      if (this.s)
        intent.putExtra("icon", this.q); 
      getActivity().setResult(-1, intent);
    } else {
      getActivity().setResult(-1);
    } 
    getActivity().finish();
  }
  
  public boolean V_() {
    m();
    return super.V_();
  }
  
  public void a() {
    Bundle bundle = getArguments();
    if (bundle == null)
      return; 
    this.o = bundle.getString("gid");
    this.m = bundle.getString("name");
    this.n = bundle.getString("icon");
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
    if (paramInt2 == -1)
      if (paramInt1 != 22) {
        if (paramInt1 != 100) {
          if (paramInt1 == 1000) {
            if (paramIntent != null && !StringUtils.e(paramIntent.getStringExtra("name"))) {
              this.l.setText(paramIntent.getStringExtra("name"));
              this.m = paramIntent.getStringExtra("name");
            } 
            if (paramInt2 == -1)
              this.r = true; 
          } 
        } else if (paramIntent != null) {
          StringUtils.e(paramIntent.getStringExtra("uid"));
        } 
      } else if (paramIntent != null) {
        this.q = paramIntent.getStringExtra("photo_path");
        a(this.q);
      }  
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onClick(View paramView) {
    Bundle bundle;
    switch (paramView.getId()) {
      default:
        return;
      case 2131298865:
        bundle = new Bundle();
        bundle.putString("name", this.m);
        TerminalActivity.a((Fragment)this, ModifyGroupNameFragment.class, bundle, 1000);
        return;
      case 2131298864:
        if (TextUtils.isEmpty(this.n)) {
          this.p = new String[1];
          this.p[0] = this.f.getResources().getString(2131756853);
        } else {
          this.p = new String[2];
          this.p[0] = this.f.getResources().getString(2131756853);
          this.p[1] = this.f.getResources().getString(2131756854);
        } 
        CommonShowBottomWindow.a(getActivity(), this.p, new ActionSheet.ActionSheetListener(this) {
              public void a(ActionSheet param1ActionSheet, int param1Int) {
                if (param1Int == 0) {
                  PhotoSelectFragment.a(this.a, 3, 22);
                  return;
                } 
                if (GroupEditNameIconFragment.d(this.a)) {
                  String str = RecyclingUtils.Scheme.c.b(GroupEditNameIconFragment.c(this.a));
                  Context context1 = GroupEditNameIconFragment.e(this.a);
                  LoadOptions loadOptions1 = GroupEditNameIconFragment.f(this.a);
                  BasePhotoFragment.a(context1, new String[] { str }, 0, 2, loadOptions1);
                  return;
                } 
                if (!StringUtils.e(GroupEditNameIconFragment.g(this.a))) {
                  String str = GroupEditNameIconFragment.g(this.a);
                  Context context1 = GroupEditNameIconFragment.e(this.a);
                  LoadOptions loadOptions1 = GroupEditNameIconFragment.f(this.a);
                  BasePhotoFragment.a(context1, new String[] { str }, 0, 2, loadOptions1);
                  return;
                } 
                Context context = GroupEditNameIconFragment.e(this.a);
                LoadOptions loadOptions = GroupEditNameIconFragment.f(this.a);
                BasePhotoFragment.a(context, new String[] { null }, 0, 2, loadOptions);
              }
              
              public void a(ActionSheet param1ActionSheet, boolean param1Boolean) {}
            });
        return;
      case 2131296863:
        break;
    } 
    m();
  }
  
  public void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    this.f = (Context)getActivity();
    View view = this.e;
    if (view == null) {
      this.e = paramLayoutInflater.inflate(2131493136, paramViewGroup, false);
      a();
      k();
      l();
    } else if (view.getParent() != null) {
      ((ViewGroup)this.e.getParent()).removeView(this.e);
    } 
    return this.e;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\group\GroupEditNameIconFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */