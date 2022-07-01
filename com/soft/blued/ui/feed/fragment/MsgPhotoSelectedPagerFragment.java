package com.soft.blued.ui.feed.fragment;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.blued.android.core.AppMethods;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.module.player.media.observer.EventCallBackListener;
import com.blued.android.module.player.media.observer.EventCallbackObserver;
import com.soft.blued.constant.PhotoConstants;
import com.soft.blued.customview.HackyViewPager;
import com.soft.blued.log.InstantLog;
import com.soft.blued.ui.feed.adapter.MsgAblumAdapter;
import com.soft.blued.ui.feed.manager.SelectPhotoManager;
import com.soft.blued.ui.feed.model.ChildImageInfo;
import com.soft.blued.user.BluedConfig;
import java.util.ArrayList;
import java.util.List;

public class MsgPhotoSelectedPagerFragment extends BaseFragment implements EventCallBackListener {
  private Context d;
  
  private View e;
  
  private HackyViewPager f;
  
  private LayoutInflater g;
  
  private ImagePagerAdapter h;
  
  private View i;
  
  private TextView j;
  
  private TextView k;
  
  private CheckBox l;
  
  private View m;
  
  private TextView n;
  
  private ImageView o;
  
  private ImageView p;
  
  private RecyclerView q;
  
  private MsgAblumAdapter r;
  
  private View s;
  
  private int t;
  
  private int u;
  
  private boolean v;
  
  private boolean w = false;
  
  private List<ChildImageInfo> x = new ArrayList<ChildImageInfo>();
  
  public static void a(BaseFragment paramBaseFragment, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2) {
    Bundle bundle = new Bundle();
    bundle.putInt("select_photo", paramInt2);
    bundle.putInt("photo_index", paramInt1);
    bundle.putBoolean("photo_destroy_switch", paramBoolean1);
    bundle.putBoolean("photo_from_group", paramBoolean2);
    TerminalActivity.a((Fragment)paramBaseFragment, MsgPhotoSelectedPagerFragment.class, bundle, 1);
  }
  
  private void b(int paramInt) {
    if (((ChildImageInfo)this.x.get(paramInt)).mSelect) {
      this.p.setImageResource(2131233514);
      return;
    } 
    this.p.setImageResource(2131233518);
  }
  
  private void k() {
    Bundle bundle = getArguments();
    if (bundle != null) {
      this.t = bundle.getInt("photo_index", 0);
      this.u = bundle.getInt("select_photo", 0);
      this.v = bundle.getBoolean("photo_destroy_switch", false);
      this.w = bundle.getBoolean("photo_from_group", false);
    } 
    this.x.addAll(SelectPhotoManager.a().c());
  }
  
  private void l() {
    this.g = LayoutInflater.from(this.d);
    this.f = (HackyViewPager)this.e.findViewById(2131299443);
    this.h = new ImagePagerAdapter(this, getChildFragmentManager());
    this.f.setAdapter((PagerAdapter)this.h);
    this.s = this.e.findViewById(2131296849);
    this.m = this.e.findViewById(2131300273);
    this.o = (ImageView)this.m.findViewById(2131296863);
    this.n = (TextView)this.m.findViewById(2131296857);
    this.p = (ImageView)this.m.findViewById(2131296867);
    this.i = this.e.findViewById(2131296557);
    this.i.setBackgroundColor(getResources().getColor(2131100539));
    this.j = (TextView)this.e.findViewById(2131301328);
    this.j.setTextColor(getResources().getColor(2131100528));
    this.j.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            throw new RuntimeException("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
          }
        });
    this.l = (CheckBox)this.e.findViewById(2131297746);
    this.l.setChecked(this.v);
    this.k = (TextView)this.e.findViewById(2131300707);
    this.k.setTextColor(getResources().getColor(2131100528));
    this.k.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            MsgPhotoSelectedPagerFragment.c(this.a).setChecked(MsgPhotoSelectedPagerFragment.c(this.a).isChecked() ^ true);
          }
        });
    if (BluedConfig.b().m() && this.w) {
      this.k.setVisibility(8);
      this.l.setVisibility(8);
    } else {
      this.k.setVisibility(0);
      this.l.setVisibility(0);
    } 
    this.l.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(this) {
          public void onCheckedChanged(CompoundButton param1CompoundButton, boolean param1Boolean) {
            if (MsgPhotoSelectedPagerFragment.d(this.a)) {
              InstantLog.a("chat_burn_pic_click", Integer.valueOf(1));
              return;
            } 
            InstantLog.a("chat_burn_pic_click", Integer.valueOf(0));
          }
        });
    this.q = (RecyclerView)this.e.findViewById(2131299460);
    this.q.setHasFixedSize(true);
    o();
    this.p.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            ChildImageInfo childImageInfo = MsgPhotoSelectedPagerFragment.b(this.a).get(MsgPhotoSelectedPagerFragment.a(this.a));
            if (childImageInfo.mSelect) {
              childImageInfo.mSelect = false;
              MsgPhotoSelectedPagerFragment.e(this.a).setImageResource(2131233518);
              SelectPhotoManager.a().b(childImageInfo);
              MsgPhotoSelectedPagerFragment.f(this.a);
              MsgPhotoSelectedPagerFragment.g(this.a).b(childImageInfo);
              MsgPhotoSelectedPagerFragment.h(this.a).notifyDataSetChanged();
              return;
            } 
            if (SelectPhotoManager.a().b() < PhotoConstants.CONFIG.a) {
              childImageInfo.mSelect = true;
              MsgPhotoSelectedPagerFragment.e(this.a).setImageResource(2131233514);
              SelectPhotoManager.a().a(childImageInfo);
              MsgPhotoSelectedPagerFragment.f(this.a);
              MsgPhotoSelectedPagerFragment.g(this.a).a(childImageInfo);
              MsgPhotoSelectedPagerFragment.h(this.a).notifyDataSetChanged();
              return;
            } 
            AppMethods.a(String.format(this.a.getResources().getString(2131757865), new Object[] { Integer.valueOf(PhotoConstants.CONFIG.a) }));
          }
        });
    this.o.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            MsgPhotoSelectedPagerFragment.i(this.a);
          }
        });
    this.f.setOnPageChangeListener(new ViewPager.OnPageChangeListener(this) {
          public void onPageScrollStateChanged(int param1Int) {}
          
          public void onPageScrolled(int param1Int1, float param1Float, int param1Int2) {}
          
          public void onPageSelected(int param1Int) {
            MsgPhotoSelectedPagerFragment.a(this.a, param1Int);
            MsgPhotoSelectedPagerFragment.b(this.a, param1Int);
            MsgPhotoSelectedPagerFragment.g(this.a).c(MsgPhotoSelectedPagerFragment.b(this.a).get(MsgPhotoSelectedPagerFragment.a(this.a)));
          }
        });
    b(this.t);
    this.f.setCurrentItem(this.t);
  }
  
  private void m() {
    int i = SelectPhotoManager.a().b();
    if (i == 0) {
      this.j.setText(getString(2131758680));
      this.j.setBackgroundResource(2131233453);
      return;
    } 
    TextView textView = this.j;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(getString(2131758680));
    stringBuilder.append("(");
    stringBuilder.append(i);
    stringBuilder.append(")");
    textView.setText(stringBuilder.toString());
    this.j.setBackgroundResource(2131233453);
  }
  
  private void n() {
    throw new RuntimeException("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private void o() {
    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
    linearLayoutManager.setOrientation(0);
    this.q.setLayoutManager((RecyclerView.LayoutManager)linearLayoutManager);
    this.q.setItemAnimator((RecyclerView.ItemAnimator)new DefaultItemAnimator());
    ChildImageInfo childImageInfo = SelectPhotoManager.a().a(this.t);
    this.r = new MsgAblumAdapter(getContext(), (IRequestHost)w_(), this.q, childImageInfo);
    this.q.setAdapter((RecyclerView.Adapter)this.r);
    this.r.a(new MsgAblumAdapter.OnItemClickListener(this) {
          public void a(ChildImageInfo param1ChildImageInfo) {
            for (int i = 0; i < MsgPhotoSelectedPagerFragment.b(this.a).size(); i++) {
              if (TextUtils.equals(((ChildImageInfo)MsgPhotoSelectedPagerFragment.b(this.a).get(i)).mImagePath, param1ChildImageInfo.mImagePath)) {
                MsgPhotoSelectedPagerFragment.a(this.a, i);
                MsgPhotoSelectedPagerFragment.j(this.a).setCurrentItem(MsgPhotoSelectedPagerFragment.a(this.a), false);
                return;
              } 
            } 
          }
        });
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3) {}
  
  public void a(View paramView) {
    paramView = this.s;
    if (paramView == null)
      return; 
    if (paramView.getVisibility() == 0) {
      this.s.setVisibility(8);
      return;
    } 
    this.s.setVisibility(0);
  }
  
  public void a(Object... paramVarArgs) {}
  
  public void aR_() {}
  
  public void aS_() {}
  
  public void aT_() {
    n();
  }
  
  public void b(View paramView) {}
  
  public void b(Object... paramVarArgs) {}
  
  public void d() {}
  
  public void f_(int paramInt) {}
  
  public void onCreate(Bundle paramBundle) {
    EventCallbackObserver.a().a(this);
    super.onCreate(paramBundle);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    this.d = (Context)getActivity();
    View view = this.e;
    if (view == null) {
      this.e = paramLayoutInflater.inflate(2131493235, paramViewGroup, false);
      k();
      l();
      m();
      b(this.t);
    } else if (view.getParent() != null) {
      ((ViewGroup)this.e.getParent()).removeView(this.e);
    } 
    return this.e;
  }
  
  public void onDestroy() {
    EventCallbackObserver.a().b(this);
    super.onDestroy();
  }
  
  class ImagePagerAdapter extends FragmentStatePagerAdapter {
    public ImagePagerAdapter(MsgPhotoSelectedPagerFragment this$0, FragmentManager param1FragmentManager) {
      super(param1FragmentManager);
    }
    
    public int getCount() {
      return MsgPhotoSelectedPagerFragment.b(this.a).size();
    }
    
    public Fragment getItem(int param1Int) {
      String str;
      if (!TextUtils.isEmpty(((ChildImageInfo)MsgPhotoSelectedPagerFragment.b(this.a).get(param1Int)).imgUri)) {
        str = ((ChildImageInfo)MsgPhotoSelectedPagerFragment.b(this.a).get(param1Int)).imgUri;
      } else {
        str = ((ChildImageInfo)MsgPhotoSelectedPagerFragment.b(this.a).get(param1Int)).mImagePath;
      } 
      return (Fragment)ImageDetailFragment.a(str, true, 4, null, param1Int, MsgPhotoSelectedPagerFragment.b(this.a).size());
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\feed\fragment\MsgPhotoSelectedPagerFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */