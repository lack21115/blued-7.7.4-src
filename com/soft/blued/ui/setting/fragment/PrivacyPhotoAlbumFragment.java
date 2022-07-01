package com.soft.blued.ui.setting.fragment;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.ToggleButton;
import androidx.fragment.app.FragmentActivity;
import com.blued.android.core.AppMethods;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.imagecache.LoadOptions;
import com.blued.android.core.imagecache.RecyclingUtils;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.permission.PermissionCallbacks;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.utils.upload.QiniuUploadTools;
import com.blued.android.framework.view.pulltorefresh.RenrenPullToRefreshListView;
import com.blued.android.module.common.utils.DialogUtils;
import com.blued.das.vip.VipProtos;
import com.soft.blued.app.permission.PermissionHelper;
import com.soft.blued.customview.ActionSheet;
import com.soft.blued.customview.CommonTopTitleNoTrans;
import com.soft.blued.customview.DragGridBaseAdapter;
import com.soft.blued.customview.PhotoGridView;
import com.soft.blued.http.LoginRegisterHttpUtils;
import com.soft.blued.http.ProfileHttpUtils;
import com.soft.blued.http.UserHttpUtils;
import com.soft.blued.log.trackUtils.EventTrackVIP;
import com.soft.blued.model.BluedAlbum;
import com.soft.blued.ui.feed.fragment.PhotoSelectFragment;
import com.soft.blued.ui.find.model.UserFindResult;
import com.soft.blued.ui.find.observer.UserInfoDataObserver;
import com.soft.blued.ui.login_register.model.BluedLoginResult;
import com.soft.blued.ui.photo.fragment.BasePhotoFragment;
import com.soft.blued.ui.setting.Contract.PrivacyPhotoAlbumContract;
import com.soft.blued.ui.setting.Presenter.PrivacyPhotoAlbumPresenter;
import com.soft.blued.ui.setting.adapter.PrivacyPhotoAlbumAuthedUsersItemAdapter;
import com.soft.blued.ui.user.model.UserInfoEntity;
import com.soft.blued.ui.user.presenter.PayUtils;
import com.soft.blued.user.UserInfo;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.utils.StringUtils;
import com.soft.blued.utils.third.QiniuUploadUtils;
import com.soft.blued.view.tip.CommonAlertDialog;
import com.soft.blued.view.tip.CommonShowBottomWindow;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PrivacyPhotoAlbumFragment extends BaseFragment implements View.OnClickListener, PrivacyPhotoAlbumContract.IView {
  private List<UserFindResult> A;
  
  private boolean B;
  
  private boolean C = false;
  
  private boolean D = false;
  
  private boolean E = false;
  
  public BluedUIHttpResponse d = new BluedUIHttpResponse<BluedEntityA<UserInfoEntity>>(this) {
      public void a(BluedEntityA<UserInfoEntity> param1BluedEntityA) {
        if (param1BluedEntityA != null) {
          DialogUtils.b(PrivacyPhotoAlbumFragment.m(this.a));
          UserInfoEntity userInfoEntity = param1BluedEntityA.data.get(0);
          if (userInfoEntity != null) {
            if (userInfoEntity.album != null)
              UserInfo.a().i().setAlbum(userInfoEntity.album); 
            this.a.k();
            return;
          } 
          AppMethods.d(2131756584);
          return;
        } 
        AppMethods.d(2131756584);
      }
    };
  
  private Context e;
  
  private PrivacyPhotoAlbumContract.IPresenter f;
  
  private LayoutInflater g;
  
  private View h;
  
  private CommonTopTitleNoTrans i;
  
  private Dialog j;
  
  private View k;
  
  private ListView l;
  
  private RenrenPullToRefreshListView m;
  
  private TextView n;
  
  private TextView o;
  
  private TextView p;
  
  private ToggleButton q;
  
  private RelativeLayout r;
  
  private PhotoGridView s;
  
  private List<BluedAlbum> t = new ArrayList<BluedAlbum>();
  
  private PhotoAlbumGirdAdapter u;
  
  private int v;
  
  private BluedAlbum w;
  
  private int x = 1;
  
  private final int y = 30;
  
  private PrivacyPhotoAlbumAuthedUsersItemAdapter z;
  
  private void a(String paramString1, BluedAlbum paramBluedAlbum, String paramString2) {
    QiniuUploadUtils.a(paramString1, paramBluedAlbum, new QiniuUploadTools.QiNiuListener(this, paramString1, paramString2) {
          double a = 0.0D;
          
          public void a(String param1String) {
            this.d.a(new -$$Lambda$PrivacyPhotoAlbumFragment$5$-RG1rj3v4bq07T0gNjMfd0o6VKU(this, param1String));
          }
          
          public void a(String param1String, double param1Double) {
            if (PrivacyPhotoAlbumFragment.k(this.d))
              return; 
            this.d.a(new -$$Lambda$PrivacyPhotoAlbumFragment$5$SjlIqoO5vjd0tqg0GwhcOLV1oS8(this, param1Double, param1String));
          }
          
          public void a(String param1String1, String param1String2) {
            this.d.a(new -$$Lambda$PrivacyPhotoAlbumFragment$5$AaUkE7cEtNH7BjVPsuaXMvktBO4(this, this.b, param1String1, this.c, param1String2));
          }
          
          public boolean a() {
            return false;
          }
        });
  }
  
  private void a(String paramString1, String paramString2, int paramInt) {
    LoginRegisterHttpUtils.a(this.e, new BluedUIHttpResponse<BluedEntityA<BluedAlbum>>(this, (IRequestHost)w_(), paramInt, paramString1, paramString2) {
          protected void a(BluedEntityA<BluedAlbum> param1BluedEntityA) {
            if (param1BluedEntityA.data != null && param1BluedEntityA.data.size() > 0) {
              BluedAlbum bluedAlbum = param1BluedEntityA.data.get(0);
              ((BluedAlbum)PrivacyPhotoAlbumFragment.h(this.d).get(this.a)).key = bluedAlbum.key;
              PrivacyPhotoAlbumFragment.a(this.d, this.b, bluedAlbum, this.c);
            } 
          }
          
          public boolean onUIFailure(int param1Int, String param1String) {
            PrivacyPhotoAlbumFragment.a(this.d, true);
            return super.onUIFailure(param1Int, param1String);
          }
          
          public void onUIFinish() {
            super.onUIFinish();
            if (PrivacyPhotoAlbumFragment.j(this.d)) {
              ((BluedAlbum)PrivacyPhotoAlbumFragment.h(this.d).get(this.a)).setProgress(this.d.getResources().getString(2131756378));
              PrivacyPhotoAlbumFragment.i(this.d).notifyDataSetChanged();
            } 
          }
          
          public void onUIStart() {
            super.onUIStart();
            PrivacyPhotoAlbumFragment.a(this.d, false);
            ((BluedAlbum)PrivacyPhotoAlbumFragment.h(this.d).get(this.a)).setProgress("0%");
            ((BluedAlbum)PrivacyPhotoAlbumFragment.h(this.d).get(this.a)).setUrl(RecyclingUtils.Scheme.c.b(this.b));
            PrivacyPhotoAlbumFragment.i(this.d).notifyDataSetChanged();
          }
        }(IRequestHost)w_());
  }
  
  private void a(String paramString1, String paramString2, String paramString3, String paramString4) {
    ProfileHttpUtils.a(this.e, new BluedUIHttpResponse<BluedEntityA<BluedAlbum>>(this, (IRequestHost)w_(), paramString4, paramString1) {
          protected void a(BluedEntityA<BluedAlbum> param1BluedEntityA) {
            int i = PrivacyPhotoAlbumFragment.a(this.c, this.a);
            ((BluedAlbum)PrivacyPhotoAlbumFragment.h(this.c).get(i)).setProgress("100%");
            PrivacyPhotoAlbumFragment.i(this.c).notifyDataSetChanged();
            if (param1BluedEntityA.data != null && param1BluedEntityA.data.size() > 0) {
              BluedAlbum bluedAlbum1;
              bluedAlbum2 = param1BluedEntityA.data.get(0);
              ((BluedAlbum)PrivacyPhotoAlbumFragment.h(this.c).get(i)).setPid(bluedAlbum2.getPid());
              ((BluedAlbum)PrivacyPhotoAlbumFragment.h(this.c).get(i)).setProgress("");
              ((BluedAlbum)PrivacyPhotoAlbumFragment.h(this.c).get(i)).audit_status = bluedAlbum2.audit_status;
              PrivacyPhotoAlbumFragment.i(this.c).notifyDataSetChanged();
              List<BluedAlbum> list = UserInfo.a().i().getAlbum();
              if (list.size() > i) {
                bluedAlbum1 = list.get(i);
              } else {
                bluedAlbum1 = new BluedAlbum();
                list.add(bluedAlbum1);
              } 
              bluedAlbum1.setUrl(RecyclingUtils.Scheme.c.b(this.b));
              bluedAlbum1.setPid(bluedAlbum2.getPid());
              bluedAlbum1.audit_status = bluedAlbum2.audit_status;
              for (BluedAlbum bluedAlbum2 : list) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("onUIUpdate bluedAlbum pid:");
                stringBuilder.append(bluedAlbum2.getPid());
                stringBuilder.append(" -- ");
                stringBuilder.append(bluedAlbum2.audit_status);
                Log.v("drb", stringBuilder.toString());
              } 
            } 
            AppMethods.d(2131758209);
            UserInfoDataObserver.a().b();
            UserHttpUtils.a(PrivacyPhotoAlbumFragment.f(this.c), this.c.d, UserInfo.a().i().getName(), (IRequestHost)this.c.w_());
          }
          
          public boolean onUIFailure(int param1Int, String param1String) {
            PrivacyPhotoAlbumFragment.b(this.c, true);
            return super.onUIFailure(param1Int, param1String);
          }
          
          public void onUIFinish() {
            super.onUIFinish();
            if (PrivacyPhotoAlbumFragment.l(this.c)) {
              int i = PrivacyPhotoAlbumFragment.a(this.c, this.a);
              ((BluedAlbum)PrivacyPhotoAlbumFragment.h(this.c).get(i)).setProgress(this.c.getResources().getString(2131756378));
              PrivacyPhotoAlbumFragment.i(this.c).notifyDataSetChanged();
            } 
          }
          
          public void onUIStart() {
            super.onUIStart();
            PrivacyPhotoAlbumFragment.b(this.c, false);
          }
        }paramString2, paramString3, (IRequestHost)w_());
  }
  
  private int b(String paramString) {
    if (!StringUtils.e(paramString))
      for (int i = 0; i < this.t.size(); i++) {
        if (paramString.equals(((BluedAlbum)this.t.get(i)).key))
          return i; 
      }  
    return 0;
  }
  
  private void m() {
    this.i = (CommonTopTitleNoTrans)this.h.findViewById(2131300300);
    this.i.a();
    this.i.setCenterText(getString(2131758447));
    this.i.setLeftClickListener(this);
    this.k = this.g.inflate(2131493402, null);
    this.q = (ToggleButton)this.k.findViewById(2131300183);
    if (BluedPreferences.bB()) {
      this.q.setChecked(true);
    } else {
      this.q.setChecked(false);
    } 
    this.n = (TextView)this.k.findViewById(2131301361);
    this.m = (RenrenPullToRefreshListView)this.h.findViewById(2131299760);
    this.m.setRefreshEnabled(false);
    this.l = (ListView)this.m.getRefreshableView();
    this.l.addHeaderView(this.k);
    this.o = (TextView)this.h.findViewById(2131300680);
    if (this.q.isChecked()) {
      this.o.setVisibility(0);
      this.n.setTextColor(Color.parseColor("#80adafb0"));
    } else {
      this.o.setVisibility(8);
      this.n.setTextColor(BluedSkinUtils.a(this.e, 2131100608));
    } 
    this.p = (TextView)this.h.findViewById(2131300583);
    this.j = DialogUtils.a(this.e);
    this.A = new ArrayList<UserFindResult>();
    this.z = new PrivacyPhotoAlbumAuthedUsersItemAdapter(this.e, (IRequestHost)w_(), this.A);
    this.l.setAdapter((ListAdapter)this.z);
    this.r = (RelativeLayout)this.h.findViewById(2131299700);
    this.r.setOnClickListener(this);
  }
  
  private void n() {
    this.v = ((this.e.getResources().getDisplayMetrics()).widthPixels - DensityUtils.a(this.e, 66.0F)) / 3;
    this.s = (PhotoGridView)this.h.findViewById(2131297289);
    this.u = new PhotoAlbumGirdAdapter(this, this.e);
    this.s.setAdapter((ListAdapter)this.u);
    this.s.setColumnWidth(this.v);
  }
  
  private void o() {
    this.f.a(this.x, 30);
  }
  
  private void p() {
    this.z.a(new PrivacyPhotoAlbumAuthedUsersItemAdapter.OnDeleteClickListener(this) {
          public void a(String param1String, int param1Int) {
            PrivacyPhotoAlbumFragment.a(this.a).a(param1String, param1Int);
          }
        });
    this.m.setOnPullDownListener(new MyPullDownListener());
    this.i.setLeftClickListener(this);
    this.q.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(this) {
          public void onCheckedChanged(CompoundButton param1CompoundButton, boolean param1Boolean) {
            PrivacyPhotoAlbumFragment.a(this.a).a(param1Boolean);
            PrivacyPhotoAlbumFragment.b(this.a).a(param1Boolean);
            if (param1Boolean) {
              if (PrivacyPhotoAlbumFragment.c(this.a).getVisibility() == 0) {
                PrivacyPhotoAlbumFragment.d(this.a).setVisibility(0);
              } else {
                PrivacyPhotoAlbumFragment.d(this.a).setVisibility(8);
              } 
              PrivacyPhotoAlbumFragment.e(this.a).setTextColor(Color.parseColor("#80adafb0"));
              return;
            } 
            PrivacyPhotoAlbumFragment.e(this.a).setTextColor(PrivacyPhotoAlbumFragment.f(this.a).getResources().getColor(2131100608));
            PrivacyPhotoAlbumFragment.d(this.a).setVisibility(8);
          }
        });
    this.p.setOnClickListener(this);
    this.o.setOnClickListener(this);
  }
  
  public void a() {
    this.z.a();
    this.p.setVisibility(8);
    this.n.setText(2131758440);
  }
  
  public void a(int paramInt) {
    List<UserFindResult> list = this.A;
    if (list != null && list.size() == 1) {
      this.p.setVisibility(8);
      this.n.setText(2131758440);
    } 
    this.z.a(paramInt);
  }
  
  public void a(String paramString) {
    int i;
    for (i = 0; i < this.t.size(); i++) {
      if (paramString.equals(((BluedAlbum)this.t.get(i)).getPid())) {
        this.t.remove(i);
        BluedAlbum bluedAlbum = new BluedAlbum();
        if ((UserInfo.a().i()).vip_grade == 0 && i > 5)
          this.C = true; 
        this.t.add(bluedAlbum);
        this.u.notifyDataSetChanged();
        break;
      } 
    } 
    ArrayList<? extends BluedAlbum> arrayList = new ArrayList();
    for (i = 0; i < this.t.size(); i++) {
      if (((BluedAlbum)this.t.get(i)).getUrl() != null)
        arrayList.add(this.t.get(i)); 
    } 
    if (arrayList.size() == 6 && (UserInfo.a().i()).vip_grade == 0) {
      this.t.clear();
      this.t.addAll(arrayList);
      this.r.setVisibility(0);
    } 
  }
  
  public void a(List<UserFindResult> paramList) {
    if (this.f.c()) {
      this.m.o();
    } else {
      this.m.p();
    } 
    if (paramList == null || paramList.size() == 0) {
      this.n.setText(2131758440);
      this.p.setVisibility(8);
      this.o.setVisibility(8);
    } 
    if (paramList != null && paramList.size() > 0) {
      this.p.setVisibility(0);
      if (this.q.isChecked()) {
        this.z.a(true);
        this.o.setVisibility(0);
      } else {
        this.z.a(false);
        this.o.setVisibility(8);
      } 
      this.z.a(paramList);
    } 
  }
  
  public void b() {
    this.m.q();
  }
  
  public void c() {
    DialogUtils.b(this.j);
  }
  
  public void d() {
    DialogUtils.a(this.j);
  }
  
  public void k() {
    int i;
    List<BluedAlbum> list = UserInfo.a().i().getAlbum();
    if (list != null) {
      i = list.size();
    } else {
      list = new LinkedList();
      i = 0;
    } 
    this.t = new LinkedList<BluedAlbum>();
    int j;
    for (j = 0; j < i; j++) {
      bluedAlbum = new BluedAlbum();
      bluedAlbum.setPid(((BluedAlbum)list.get(j)).getPid());
      bluedAlbum.setUrl(((BluedAlbum)list.get(j)).getUrl());
      bluedAlbum.id = ((BluedAlbum)list.get(j)).id;
      bluedAlbum.key = ((BluedAlbum)list.get(j)).key;
      bluedAlbum.audit_status = ((BluedAlbum)list.get(j)).audit_status;
      this.t.add(bluedAlbum);
    } 
    BluedLoginResult bluedLoginResult = UserInfo.a().i();
    if (bluedLoginResult.vip_grade == 0) {
      int k = this.t.size();
      byte b = 6;
      j = i;
      if (k > 6) {
        for (j = i; j < 12; j++) {
          bluedAlbum = new BluedAlbum();
          this.t.add(bluedAlbum);
          this.C = true;
        } 
        if (i == 12)
          for (i = b; i < 12; i++)
            this.C = true;  
        this.r.setVisibility(8);
        EventTrackVIP.a(VipProtos.Event.VIP_PRIVACY_PHOTO_LOCKED_SHOW);
      } else {
        while (j < 6) {
          bluedAlbum = new BluedAlbum();
          this.t.add(bluedAlbum);
          j++;
        } 
        this.r.setVisibility(0);
      } 
    } else if (((BluedLoginResult)bluedAlbum).vip_grade != 0) {
      this.r.setVisibility(8);
      while (i < 12) {
        bluedAlbum = new BluedAlbum();
        this.t.add(bluedAlbum);
        i++;
      } 
    } 
    for (BluedAlbum bluedAlbum : list) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("initPhotoData bluedAlbum pid:");
      stringBuilder.append(bluedAlbum.getPid());
      stringBuilder.append(" -- ");
      stringBuilder.append(bluedAlbum.audit_status);
      Log.v("drb", stringBuilder.toString());
    } 
  }
  
  public void l() {
    Context context = this.e;
    CommonAlertDialog.a(context, "", context.getResources().getString(2131757875), this.e.getResources().getString(2131756100), new DialogInterface.OnClickListener(this) {
          public void onClick(DialogInterface param1DialogInterface, int param1Int) {
            PrivacyPhotoAlbumFragment.a(this.a).b();
          }
        },  this.e.getResources().getString(2131755726), null, null);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
    if (paramInt2 == -1 && paramInt1 == 22 && paramIntent != null) {
      String str = paramIntent.getStringExtra("photo_path");
      if (this.w != null && !StringUtils.e(str))
        a(str, this.w.getPid(), this.w.position); 
    } 
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onClick(View paramView) {
    switch (paramView.getId()) {
      default:
        return;
      case 2131300583:
        l();
        return;
      case 2131299700:
        EventTrackVIP.a(VipProtos.Event.VIP_PRIVACY_PHOTO_EXPAND_CLICK);
        PayUtils.a(this.e, 0, "privacy_photo_expand", 25, VipProtos.FromType.PRIVACY_PHOTO_EXPAND);
        return;
      case 2131296863:
        getActivity().finish();
        break;
      case 2131300680:
        break;
    } 
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    View view = this.h;
    if (view == null) {
      this.h = paramLayoutInflater.inflate(2131493277, paramViewGroup, false);
      this.e = (Context)getActivity();
      this.g = LayoutInflater.from(this.e);
      this.f = (PrivacyPhotoAlbumContract.IPresenter)new PrivacyPhotoAlbumPresenter(this.e, this, (IRequestHost)w_());
      m();
      n();
      o();
    } else if (view.getParent() != null) {
      ((ViewGroup)this.h.getParent()).removeView(this.h);
    } 
    return this.h;
  }
  
  public void onDestroy() {
    super.onDestroy();
    this.B = true;
    for (int i = 0; i < this.t.size(); i = j + 1) {
      int j = i;
      if (!StringUtils.e(((BluedAlbum)this.t.get(i)).progress)) {
        this.t.remove(i);
        j = i - 1;
      } 
    } 
  }
  
  public void onResume() {
    super.onResume();
    k();
    PhotoAlbumGirdAdapter photoAlbumGirdAdapter = this.u;
    if (photoAlbumGirdAdapter != null)
      photoAlbumGirdAdapter.notifyDataSetChanged(); 
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle) {
    super.onViewCreated(paramView, paramBundle);
    p();
    this.f.bb_();
  }
  
  class MyPullDownListener implements RenrenPullToRefreshListView.OnPullDownListener {
    private MyPullDownListener(PrivacyPhotoAlbumFragment this$0) {}
    
    public void a() {}
    
    public void b() {
      PrivacyPhotoAlbumFragment privacyPhotoAlbumFragment = this.a;
      PrivacyPhotoAlbumFragment.a(privacyPhotoAlbumFragment, PrivacyPhotoAlbumFragment.g(privacyPhotoAlbumFragment) + 1);
      PrivacyPhotoAlbumFragment.a(this.a).a(PrivacyPhotoAlbumFragment.g(this.a), 30);
    }
  }
  
  public class PhotoAlbumGirdAdapter extends BaseAdapter implements DragGridBaseAdapter {
    private LayoutInflater b;
    
    private ImageView c;
    
    private TextView d;
    
    private TextView e;
    
    private TextView f;
    
    private int g = -1;
    
    private LoadOptions h;
    
    public PhotoAlbumGirdAdapter(PrivacyPhotoAlbumFragment this$0, Context param1Context) {
      this.b = LayoutInflater.from(param1Context);
    }
    
    public void a(int param1Int) {
      this.g = param1Int;
      notifyDataSetChanged();
    }
    
    public void a(int param1Int1, int param1Int2) {}
    
    public int getCount() {
      return PrivacyPhotoAlbumFragment.h(this.a).size();
    }
    
    public Object getItem(int param1Int) {
      return Integer.valueOf(param1Int);
    }
    
    public long getItemId(int param1Int) {
      return param1Int;
    }
    
    public View getView(int param1Int, View param1View, ViewGroup param1ViewGroup) {
      param1View = this.b.inflate(2131493225, null);
      this.d = (TextView)param1View.findViewById(2131301333);
      FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams)this.d.getLayoutParams();
      layoutParams.height = PrivacyPhotoAlbumFragment.n(this.a);
      this.d.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
      this.e = (TextView)param1View.findViewById(2131301198);
      this.c = (ImageView)param1View.findViewById(2131297362);
      layoutParams = (FrameLayout.LayoutParams)this.c.getLayoutParams();
      layoutParams.height = PrivacyPhotoAlbumFragment.n(this.a);
      this.d.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
      BluedAlbum bluedAlbum = PrivacyPhotoAlbumFragment.h(this.a).get(param1Int);
      if (StringUtils.e(bluedAlbum.progress)) {
        this.e.setVisibility(8);
        this.d.setVisibility(8);
      } else {
        this.d.setVisibility(0);
        this.e.setVisibility(0);
        this.e.setText(bluedAlbum.progress);
      } 
      this.f = (TextView)param1View.findViewById(2131301456);
      if (bluedAlbum.audit_status == 1) {
        this.f.setVisibility(0);
      } else {
        this.f.setVisibility(8);
      } 
      LinearLayout linearLayout = (LinearLayout)param1View.findViewById(2131298929);
      if (PrivacyPhotoAlbumFragment.o(this.a) && param1Int > 5) {
        linearLayout.setVisibility(0);
        this.d.setVisibility(0);
      } 
      linearLayout.setOnClickListener(new View.OnClickListener(this, bluedAlbum, param1Int) {
            public void onClick(View param2View) {
              EventTrackVIP.a(VipProtos.Event.VIP_PRIVACY_PHOTO_LOCKED_CLICK);
              if (!TextUtils.isEmpty(this.a.getUrl())) {
                String[] arrayOfString = this.c.a.getResources().getStringArray(2130903074);
                arrayOfString[0] = this.c.a.getResources().getString(2131758442);
                arrayOfString[1] = this.c.a.getResources().getString(2131758437);
                CommonShowBottomWindow.a((FragmentActivity)PrivacyPhotoAlbumFragment.f(this.c.a), arrayOfString, new ActionSheet.ActionSheetListener(this) {
                      public void a(ActionSheet param3ActionSheet, int param3Int) {
                        boolean bool = false;
                        if (param3Int != 0) {
                          if (param3Int != 1) {
                            if (param3Int != 2)
                              return; 
                            CommonAlertDialog.a(PrivacyPhotoAlbumFragment.f(this.a.c.a), "", this.a.c.a.getResources().getString(2131758432), this.a.c.a.getResources().getString(2131758433), new DialogInterface.OnClickListener(this) {
                                  public void onClick(DialogInterface param4DialogInterface, int param4Int) {
                                    PrivacyPhotoAlbumFragment.a(this.a.a.c.a).a(this.a.a.a.getPid());
                                  }
                                },  this.a.c.a.getResources().getString(2131758431), null, null);
                            return;
                          } 
                          ArrayList<BluedAlbum> arrayList = new ArrayList();
                          for (BluedAlbum bluedAlbum : PrivacyPhotoAlbumFragment.h(this.a.c.a)) {
                            if (bluedAlbum.getPid() != null && StringUtils.e(bluedAlbum.key))
                              arrayList.add(bluedAlbum); 
                          } 
                          String[] arrayOfString1 = new String[arrayList.size()];
                          String[] arrayOfString2 = new String[arrayList.size()];
                          for (param3Int = bool; param3Int < arrayList.size(); param3Int++) {
                            arrayOfString1[param3Int] = ((BluedAlbum)arrayList.get(param3Int)).getUrl();
                            arrayOfString2[param3Int] = ((BluedAlbum)arrayList.get(param3Int)).getPid();
                          } 
                          param3Int = this.a.b;
                          BasePhotoFragment.a(PrivacyPhotoAlbumFragment.f(this.a.c.a), arrayOfString1, arrayOfString2, param3Int, 3, UserInfo.a().i().getName(), PrivacyPhotoAlbumFragment.PhotoAlbumGirdAdapter.a(this.a.c));
                          return;
                        } 
                        EventTrackVIP.a(VipProtos.Event.VIP_PRIVACY_PHOTO_LOCKED_RENEW_CLICK);
                        PayUtils.a(PrivacyPhotoAlbumFragment.f(this.a.c.a), 0, "privacy_photo_locked_renew", 25, VipProtos.FromType.PRIVACY_PHOTO_LOCKED_RENEW);
                      }
                      
                      public void a(ActionSheet param3ActionSheet, boolean param3Boolean) {}
                    });
                return;
              } 
              String str = this.c.a.getResources().getString(2131758442);
              FragmentActivity fragmentActivity = (FragmentActivity)PrivacyPhotoAlbumFragment.f(this.c.a);
              ActionSheet.ActionSheetListener actionSheetListener = new ActionSheet.ActionSheetListener(this) {
                  public void a(ActionSheet param3ActionSheet, int param3Int) {
                    if (param3Int != 0)
                      return; 
                    EventTrackVIP.a(VipProtos.Event.VIP_PRIVACY_PHOTO_LOCKED_RENEW_CLICK);
                    PayUtils.a(PrivacyPhotoAlbumFragment.f(this.a.c.a), 0, "privacy_photo_locked_renew", 25, VipProtos.FromType.PRIVACY_PHOTO_LOCKED_RENEW);
                  }
                  
                  public void a(ActionSheet param3ActionSheet, boolean param3Boolean) {}
                };
              CommonShowBottomWindow.a(fragmentActivity, new String[] { str }, actionSheetListener);
            }
          });
      if (!TextUtils.isEmpty(bluedAlbum.getUrl())) {
        ImageLoader.a((IRequestHost)this.a.w_(), bluedAlbum.getUrl()).a(2131232200).a(6.0F).a(this.c);
      } else {
        this.c.setImageResource(2131232200);
      } 
      this.d.setOnClickListener(new View.OnClickListener(this, bluedAlbum, param1Int) {
            public void onClick(View param2View) {
              if (this.a.progress.equals(this.c.a.getResources().getString(2131756378))) {
                PrivacyPhotoAlbumFragment.a(this.c.a, this.a);
                (PrivacyPhotoAlbumFragment.p(this.c.a)).position = this.b;
                PhotoSelectFragment.a(this.c.a, 2, 22);
              } 
            }
          });
      this.e.setOnClickListener(new View.OnClickListener(this, bluedAlbum, param1Int) {
            public void onClick(View param2View) {
              if (this.a.progress.equals(this.c.a.getResources().getString(2131756378))) {
                PrivacyPhotoAlbumFragment.a(this.c.a, this.a);
                (PrivacyPhotoAlbumFragment.p(this.c.a)).position = this.b;
                PhotoSelectFragment.a(this.c.a, 2, 22);
              } 
            }
          });
      this.c.setOnClickListener(new View.OnClickListener(this, bluedAlbum, param1Int) {
            public void onClick(View param2View) {
              PrivacyPhotoAlbumFragment.a(this.c.a, this.a);
              (PrivacyPhotoAlbumFragment.p(this.c.a)).position = this.b;
              if (TextUtils.isEmpty(this.a.getUrl())) {
                PermissionHelper.e(new PermissionCallbacks(this) {
                      public void a(String[] param3ArrayOfString) {}
                      
                      public void aa_() {
                        PhotoSelectFragment.a(this.a.c.a, 2, 22);
                      }
                    });
                return;
              } 
              String[] arrayOfString = this.c.a.getResources().getStringArray(2130903074);
              arrayOfString[0] = this.c.a.getResources().getString(2131755748);
              CommonShowBottomWindow.a((FragmentActivity)PrivacyPhotoAlbumFragment.f(this.c.a), arrayOfString, new ActionSheet.ActionSheetListener(this) {
                    public void a(ActionSheet param3ActionSheet, int param3Int) {
                      if (param3Int != 0) {
                        if (param3Int != 1) {
                          if (param3Int != 2)
                            return; 
                          CommonAlertDialog.a(PrivacyPhotoAlbumFragment.f(this.a.c.a), "", this.a.c.a.getResources().getString(2131758432), this.a.c.a.getResources().getString(2131758433), new DialogInterface.OnClickListener(this) {
                                public void onClick(DialogInterface param4DialogInterface, int param4Int) {
                                  PrivacyPhotoAlbumFragment.a(this.a.a.c.a).a(this.a.a.a.getPid());
                                }
                              },  this.a.c.a.getResources().getString(2131758431), null, null);
                          return;
                        } 
                        ArrayList<BluedAlbum> arrayList = new ArrayList();
                        for (BluedAlbum bluedAlbum : PrivacyPhotoAlbumFragment.h(this.a.c.a)) {
                          if (bluedAlbum.getPid() != null && StringUtils.e(bluedAlbum.key))
                            arrayList.add(bluedAlbum); 
                        } 
                        String[] arrayOfString1 = new String[arrayList.size()];
                        String[] arrayOfString2 = new String[arrayList.size()];
                        for (param3Int = 0; param3Int < arrayList.size(); param3Int++) {
                          arrayOfString1[param3Int] = ((BluedAlbum)arrayList.get(param3Int)).getUrl();
                          arrayOfString2[param3Int] = ((BluedAlbum)arrayList.get(param3Int)).getPid();
                        } 
                        param3Int = this.a.b;
                        BasePhotoFragment.a(PrivacyPhotoAlbumFragment.f(this.a.c.a), arrayOfString1, arrayOfString2, param3Int, 3, UserInfo.a().i().getName(), PrivacyPhotoAlbumFragment.PhotoAlbumGirdAdapter.a(this.a.c));
                        return;
                      } 
                      PermissionHelper.e(new PermissionCallbacks(this) {
                            public void a(String[] param4ArrayOfString) {}
                            
                            public void aa_() {
                              PhotoSelectFragment.a(this.a.a.c.a, 2, 22);
                            }
                          });
                    }
                    
                    public void a(ActionSheet param3ActionSheet, boolean param3Boolean) {}
                  });
            }
          });
      if (param1Int == this.g)
        param1View.setVisibility(4); 
      return param1View;
    }
  }
  
  class null implements View.OnClickListener {
    null(PrivacyPhotoAlbumFragment this$0, BluedAlbum param1BluedAlbum, int param1Int) {}
    
    public void onClick(View param1View) {
      EventTrackVIP.a(VipProtos.Event.VIP_PRIVACY_PHOTO_LOCKED_CLICK);
      if (!TextUtils.isEmpty(this.a.getUrl())) {
        String[] arrayOfString = this.c.a.getResources().getStringArray(2130903074);
        arrayOfString[0] = this.c.a.getResources().getString(2131758442);
        arrayOfString[1] = this.c.a.getResources().getString(2131758437);
        CommonShowBottomWindow.a((FragmentActivity)PrivacyPhotoAlbumFragment.f(this.c.a), arrayOfString, new ActionSheet.ActionSheetListener(this) {
              public void a(ActionSheet param3ActionSheet, int param3Int) {
                boolean bool = false;
                if (param3Int != 0) {
                  if (param3Int != 1) {
                    if (param3Int != 2)
                      return; 
                    CommonAlertDialog.a(PrivacyPhotoAlbumFragment.f(this.a.c.a), "", this.a.c.a.getResources().getString(2131758432), this.a.c.a.getResources().getString(2131758433), new DialogInterface.OnClickListener(this) {
                          public void onClick(DialogInterface param4DialogInterface, int param4Int) {
                            PrivacyPhotoAlbumFragment.a(this.a.a.c.a).a(this.a.a.a.getPid());
                          }
                        },  this.a.c.a.getResources().getString(2131758431), null, null);
                    return;
                  } 
                  ArrayList<BluedAlbum> arrayList = new ArrayList();
                  for (BluedAlbum bluedAlbum : PrivacyPhotoAlbumFragment.h(this.a.c.a)) {
                    if (bluedAlbum.getPid() != null && StringUtils.e(bluedAlbum.key))
                      arrayList.add(bluedAlbum); 
                  } 
                  String[] arrayOfString1 = new String[arrayList.size()];
                  String[] arrayOfString2 = new String[arrayList.size()];
                  for (param3Int = bool; param3Int < arrayList.size(); param3Int++) {
                    arrayOfString1[param3Int] = ((BluedAlbum)arrayList.get(param3Int)).getUrl();
                    arrayOfString2[param3Int] = ((BluedAlbum)arrayList.get(param3Int)).getPid();
                  } 
                  param3Int = this.a.b;
                  BasePhotoFragment.a(PrivacyPhotoAlbumFragment.f(this.a.c.a), arrayOfString1, arrayOfString2, param3Int, 3, UserInfo.a().i().getName(), PrivacyPhotoAlbumFragment.PhotoAlbumGirdAdapter.a(this.a.c));
                  return;
                } 
                EventTrackVIP.a(VipProtos.Event.VIP_PRIVACY_PHOTO_LOCKED_RENEW_CLICK);
                PayUtils.a(PrivacyPhotoAlbumFragment.f(this.a.c.a), 0, "privacy_photo_locked_renew", 25, VipProtos.FromType.PRIVACY_PHOTO_LOCKED_RENEW);
              }
              
              public void a(ActionSheet param3ActionSheet, boolean param3Boolean) {}
            });
        return;
      } 
      String str = this.c.a.getResources().getString(2131758442);
      FragmentActivity fragmentActivity = (FragmentActivity)PrivacyPhotoAlbumFragment.f(this.c.a);
      ActionSheet.ActionSheetListener actionSheetListener = new ActionSheet.ActionSheetListener(this) {
          public void a(ActionSheet param3ActionSheet, int param3Int) {
            if (param3Int != 0)
              return; 
            EventTrackVIP.a(VipProtos.Event.VIP_PRIVACY_PHOTO_LOCKED_RENEW_CLICK);
            PayUtils.a(PrivacyPhotoAlbumFragment.f(this.a.c.a), 0, "privacy_photo_locked_renew", 25, VipProtos.FromType.PRIVACY_PHOTO_LOCKED_RENEW);
          }
          
          public void a(ActionSheet param3ActionSheet, boolean param3Boolean) {}
        };
      CommonShowBottomWindow.a(fragmentActivity, new String[] { str }, actionSheetListener);
    }
  }
  
  class null implements ActionSheet.ActionSheetListener {
    public void a(ActionSheet param1ActionSheet, int param1Int) {
      boolean bool = false;
      if (param1Int != 0) {
        if (param1Int != 1) {
          if (param1Int != 2)
            return; 
          CommonAlertDialog.a(PrivacyPhotoAlbumFragment.f(this.a.c.a), "", this.a.c.a.getResources().getString(2131758432), this.a.c.a.getResources().getString(2131758433), new DialogInterface.OnClickListener(this) {
                public void onClick(DialogInterface param4DialogInterface, int param4Int) {
                  PrivacyPhotoAlbumFragment.a(this.a.a.c.a).a(this.a.a.a.getPid());
                }
              },  this.a.c.a.getResources().getString(2131758431), null, null);
          return;
        } 
        ArrayList<BluedAlbum> arrayList = new ArrayList();
        for (BluedAlbum bluedAlbum : PrivacyPhotoAlbumFragment.h(this.a.c.a)) {
          if (bluedAlbum.getPid() != null && StringUtils.e(bluedAlbum.key))
            arrayList.add(bluedAlbum); 
        } 
        String[] arrayOfString1 = new String[arrayList.size()];
        String[] arrayOfString2 = new String[arrayList.size()];
        for (param1Int = bool; param1Int < arrayList.size(); param1Int++) {
          arrayOfString1[param1Int] = ((BluedAlbum)arrayList.get(param1Int)).getUrl();
          arrayOfString2[param1Int] = ((BluedAlbum)arrayList.get(param1Int)).getPid();
        } 
        param1Int = this.a.b;
        BasePhotoFragment.a(PrivacyPhotoAlbumFragment.f(this.a.c.a), arrayOfString1, arrayOfString2, param1Int, 3, UserInfo.a().i().getName(), PrivacyPhotoAlbumFragment.PhotoAlbumGirdAdapter.a(this.a.c));
        return;
      } 
      EventTrackVIP.a(VipProtos.Event.VIP_PRIVACY_PHOTO_LOCKED_RENEW_CLICK);
      PayUtils.a(PrivacyPhotoAlbumFragment.f(this.a.c.a), 0, "privacy_photo_locked_renew", 25, VipProtos.FromType.PRIVACY_PHOTO_LOCKED_RENEW);
    }
    
    public void a(ActionSheet param1ActionSheet, boolean param1Boolean) {}
  }
  
  class null implements DialogInterface.OnClickListener {
    public void onClick(DialogInterface param1DialogInterface, int param1Int) {
      PrivacyPhotoAlbumFragment.a(this.a.a.c.a).a(this.a.a.a.getPid());
    }
  }
  
  class null implements ActionSheet.ActionSheetListener {
    public void a(ActionSheet param1ActionSheet, int param1Int) {
      if (param1Int != 0)
        return; 
      EventTrackVIP.a(VipProtos.Event.VIP_PRIVACY_PHOTO_LOCKED_RENEW_CLICK);
      PayUtils.a(PrivacyPhotoAlbumFragment.f(this.a.c.a), 0, "privacy_photo_locked_renew", 25, VipProtos.FromType.PRIVACY_PHOTO_LOCKED_RENEW);
    }
    
    public void a(ActionSheet param1ActionSheet, boolean param1Boolean) {}
  }
  
  class null implements View.OnClickListener {
    null(PrivacyPhotoAlbumFragment this$0, BluedAlbum param1BluedAlbum, int param1Int) {}
    
    public void onClick(View param1View) {
      if (this.a.progress.equals(this.c.a.getResources().getString(2131756378))) {
        PrivacyPhotoAlbumFragment.a(this.c.a, this.a);
        (PrivacyPhotoAlbumFragment.p(this.c.a)).position = this.b;
        PhotoSelectFragment.a(this.c.a, 2, 22);
      } 
    }
  }
  
  class null implements View.OnClickListener {
    null(PrivacyPhotoAlbumFragment this$0, BluedAlbum param1BluedAlbum, int param1Int) {}
    
    public void onClick(View param1View) {
      if (this.a.progress.equals(this.c.a.getResources().getString(2131756378))) {
        PrivacyPhotoAlbumFragment.a(this.c.a, this.a);
        (PrivacyPhotoAlbumFragment.p(this.c.a)).position = this.b;
        PhotoSelectFragment.a(this.c.a, 2, 22);
      } 
    }
  }
  
  class null implements View.OnClickListener {
    null(PrivacyPhotoAlbumFragment this$0, BluedAlbum param1BluedAlbum, int param1Int) {}
    
    public void onClick(View param1View) {
      PrivacyPhotoAlbumFragment.a(this.c.a, this.a);
      (PrivacyPhotoAlbumFragment.p(this.c.a)).position = this.b;
      if (TextUtils.isEmpty(this.a.getUrl())) {
        PermissionHelper.e(new PermissionCallbacks(this) {
              public void a(String[] param3ArrayOfString) {}
              
              public void aa_() {
                PhotoSelectFragment.a(this.a.c.a, 2, 22);
              }
            });
        return;
      } 
      String[] arrayOfString = this.c.a.getResources().getStringArray(2130903074);
      arrayOfString[0] = this.c.a.getResources().getString(2131755748);
      CommonShowBottomWindow.a((FragmentActivity)PrivacyPhotoAlbumFragment.f(this.c.a), arrayOfString, new ActionSheet.ActionSheetListener(this) {
            public void a(ActionSheet param3ActionSheet, int param3Int) {
              if (param3Int != 0) {
                if (param3Int != 1) {
                  if (param3Int != 2)
                    return; 
                  CommonAlertDialog.a(PrivacyPhotoAlbumFragment.f(this.a.c.a), "", this.a.c.a.getResources().getString(2131758432), this.a.c.a.getResources().getString(2131758433), new DialogInterface.OnClickListener(this) {
                        public void onClick(DialogInterface param4DialogInterface, int param4Int) {
                          PrivacyPhotoAlbumFragment.a(this.a.a.c.a).a(this.a.a.a.getPid());
                        }
                      },  this.a.c.a.getResources().getString(2131758431), null, null);
                  return;
                } 
                ArrayList<BluedAlbum> arrayList = new ArrayList();
                for (BluedAlbum bluedAlbum : PrivacyPhotoAlbumFragment.h(this.a.c.a)) {
                  if (bluedAlbum.getPid() != null && StringUtils.e(bluedAlbum.key))
                    arrayList.add(bluedAlbum); 
                } 
                String[] arrayOfString1 = new String[arrayList.size()];
                String[] arrayOfString2 = new String[arrayList.size()];
                for (param3Int = 0; param3Int < arrayList.size(); param3Int++) {
                  arrayOfString1[param3Int] = ((BluedAlbum)arrayList.get(param3Int)).getUrl();
                  arrayOfString2[param3Int] = ((BluedAlbum)arrayList.get(param3Int)).getPid();
                } 
                param3Int = this.a.b;
                BasePhotoFragment.a(PrivacyPhotoAlbumFragment.f(this.a.c.a), arrayOfString1, arrayOfString2, param3Int, 3, UserInfo.a().i().getName(), PrivacyPhotoAlbumFragment.PhotoAlbumGirdAdapter.a(this.a.c));
                return;
              } 
              PermissionHelper.e(new PermissionCallbacks(this) {
                    public void a(String[] param4ArrayOfString) {}
                    
                    public void aa_() {
                      PhotoSelectFragment.a(this.a.a.c.a, 2, 22);
                    }
                  });
            }
            
            public void a(ActionSheet param3ActionSheet, boolean param3Boolean) {}
          });
    }
  }
  
  class null implements PermissionCallbacks {
    public void a(String[] param1ArrayOfString) {}
    
    public void aa_() {
      PhotoSelectFragment.a(this.a.c.a, 2, 22);
    }
  }
  
  class null implements ActionSheet.ActionSheetListener {
    public void a(ActionSheet param1ActionSheet, int param1Int) {
      if (param1Int != 0) {
        if (param1Int != 1) {
          if (param1Int != 2)
            return; 
          CommonAlertDialog.a(PrivacyPhotoAlbumFragment.f(this.a.c.a), "", this.a.c.a.getResources().getString(2131758432), this.a.c.a.getResources().getString(2131758433), new DialogInterface.OnClickListener(this) {
                public void onClick(DialogInterface param4DialogInterface, int param4Int) {
                  PrivacyPhotoAlbumFragment.a(this.a.a.c.a).a(this.a.a.a.getPid());
                }
              },  this.a.c.a.getResources().getString(2131758431), null, null);
          return;
        } 
        ArrayList<BluedAlbum> arrayList = new ArrayList();
        for (BluedAlbum bluedAlbum : PrivacyPhotoAlbumFragment.h(this.a.c.a)) {
          if (bluedAlbum.getPid() != null && StringUtils.e(bluedAlbum.key))
            arrayList.add(bluedAlbum); 
        } 
        String[] arrayOfString1 = new String[arrayList.size()];
        String[] arrayOfString2 = new String[arrayList.size()];
        for (param1Int = 0; param1Int < arrayList.size(); param1Int++) {
          arrayOfString1[param1Int] = ((BluedAlbum)arrayList.get(param1Int)).getUrl();
          arrayOfString2[param1Int] = ((BluedAlbum)arrayList.get(param1Int)).getPid();
        } 
        param1Int = this.a.b;
        BasePhotoFragment.a(PrivacyPhotoAlbumFragment.f(this.a.c.a), arrayOfString1, arrayOfString2, param1Int, 3, UserInfo.a().i().getName(), PrivacyPhotoAlbumFragment.PhotoAlbumGirdAdapter.a(this.a.c));
        return;
      } 
      PermissionHelper.e(new PermissionCallbacks(this) {
            public void a(String[] param4ArrayOfString) {}
            
            public void aa_() {
              PhotoSelectFragment.a(this.a.a.c.a, 2, 22);
            }
          });
    }
    
    public void a(ActionSheet param1ActionSheet, boolean param1Boolean) {}
  }
  
  class null implements PermissionCallbacks {
    public void a(String[] param1ArrayOfString) {}
    
    public void aa_() {
      PhotoSelectFragment.a(this.a.a.c.a, 2, 22);
    }
  }
  
  class null implements DialogInterface.OnClickListener {
    public void onClick(DialogInterface param1DialogInterface, int param1Int) {
      PrivacyPhotoAlbumFragment.a(this.a.a.c.a).a(this.a.a.a.getPid());
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\setting\fragment\PrivacyPhotoAlbumFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */