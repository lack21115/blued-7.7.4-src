package com.blued.android.module.live_china.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.blued.android.chat.data.BadgeData;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.image.ImageWrapper;
import com.blued.android.core.imagecache.LoadOptions;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.fragment.PlayingOnliveBaseModeFragment;
import com.blued.android.module.live_china.fragment.RecordingOnliveFragment;
import com.blued.android.module.live_china.observer.LiveRefreshUIObserver;
import com.blued.android.module.live_china.observer.LiveSetDataObserver;
import com.blued.android.module.live_china.same.Logger;
import java.util.ArrayList;
import java.util.List;

public class MedalView extends LinearLayout implements View.OnClickListener, PopAnchorBadge.DismissLisnter {
  public View a;
  
  public Context b;
  
  public LayoutInflater c;
  
  public String d;
  
  public String e;
  
  public BaseFragment f;
  
  public ActivityFragmentActive g;
  
  public List<BadgeData> h = new ArrayList<BadgeData>();
  
  public RecordingOnliveFragment i;
  
  public PlayingOnliveBaseModeFragment j;
  
  public boolean k;
  
  private ImageView l;
  
  private ImageView m;
  
  private ImageView n;
  
  private LoadOptions o;
  
  public MedalView(Context paramContext) {
    this(paramContext, null);
  }
  
  public MedalView(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    this.b = paramContext;
    this.c = LayoutInflater.from(this.b);
    c();
    f();
  }
  
  private void f() {
    this.l = (ImageView)this.a.findViewById(R.id.medal_view1);
    this.m = (ImageView)this.a.findViewById(R.id.medal_view2);
    this.n = (ImageView)this.a.findViewById(R.id.medal_view3);
    this.o = new LoadOptions();
    this.o.d = R.drawable.anchor_badge_default;
    LoadOptions loadOptions = this.o;
    loadOptions.l = false;
    loadOptions.a(DensityUtils.a(this.b, 32.0F), DensityUtils.a(this.b, 28.0F));
    this.l.setOnClickListener(this);
    this.m.setOnClickListener(this);
    this.n.setOnClickListener(this);
  }
  
  public void a() {
    if (this.f instanceof RecordingOnliveFragment) {
      RecordingOnliveFragment recordingOnliveFragment = this.i;
      if (recordingOnliveFragment != null) {
        recordingOnliveFragment.R();
        return;
      } 
    } else {
      LiveRefreshUIObserver.a().d(0);
      LiveSetDataObserver.a().e(0);
    } 
  }
  
  public void a(String paramString1, String paramString2, BaseFragment paramBaseFragment) {
    this.f = paramBaseFragment;
    this.d = paramString1;
    this.e = paramString2;
    if (paramBaseFragment instanceof RecordingOnliveFragment) {
      this.k = true;
      this.i = (RecordingOnliveFragment)paramBaseFragment;
      this.g = this.i.w_();
      return;
    } 
    if (paramBaseFragment instanceof PlayingOnliveBaseModeFragment) {
      this.k = false;
      this.j = (PlayingOnliveBaseModeFragment)paramBaseFragment;
      this.g = this.j.w_();
    } 
  }
  
  public void b() {
    LiveRefreshUIObserver.a().b(true);
  }
  
  public void c() {
    this.a = this.c.inflate(R.layout.live_medal_layout, (ViewGroup)this, true);
  }
  
  public void d() {
    removeAllViews();
    this.a = this.c.inflate(R.layout.live_medal_horizontal, (ViewGroup)this, true);
    f();
  }
  
  public void e() {
    removeAllViews();
    this.a = this.c.inflate(R.layout.live_medal_layout, (ViewGroup)this, true);
    f();
  }
  
  public void onClick(View paramView) {
    Context context;
    if (paramView.getId() == R.id.medal_view1) {
      List<BadgeData> list1 = this.h;
      if (list1 != null && list1.size() >= 1)
        if (this.f instanceof PlayingOnliveBaseModeFragment) {
          if (this.j.A) {
            context = this.b;
            String str1 = this.d;
            String str2 = this.e;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(((BadgeData)this.h.get(0)).id);
            stringBuilder.append("");
            PopAnchorBadgeCenter.b(context, str1, str2, stringBuilder.toString(), this, (IRequestHost)this.g);
          } else {
            context = this.b;
            String str1 = this.d;
            String str2 = this.e;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(((BadgeData)this.h.get(0)).id);
            stringBuilder.append("");
            PopAnchorBadge.a(context, str1, str2, stringBuilder.toString(), this, (IRequestHost)this.g);
          } 
        } else {
          RecordingOnliveFragment recordingOnliveFragment = this.i;
          if (recordingOnliveFragment != null && recordingOnliveFragment.be) {
            context = this.b;
            String str1 = this.d;
            String str2 = this.e;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(((BadgeData)this.h.get(0)).id);
            stringBuilder.append("");
            PopAnchorBadgeCenter.b(context, str1, str2, stringBuilder.toString(), this, (IRequestHost)this.g);
          } else {
            context = this.b;
            String str1 = this.d;
            String str2 = this.e;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(((BadgeData)this.h.get(0)).id);
            stringBuilder.append("");
            PopAnchorBadge.a(context, str1, str2, stringBuilder.toString(), this, (IRequestHost)this.g);
          } 
        }  
    } else {
      Context context1;
      if (context.getId() == R.id.medal_view2) {
        List<BadgeData> list1 = this.h;
        if (list1 != null && list1.size() >= 2)
          if (this.f instanceof PlayingOnliveBaseModeFragment) {
            if (this.j.A) {
              context1 = this.b;
              String str1 = this.d;
              String str2 = this.e;
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append(((BadgeData)this.h.get(1)).id);
              stringBuilder.append("");
              PopAnchorBadgeCenter.b(context1, str1, str2, stringBuilder.toString(), this, (IRequestHost)this.g);
            } else {
              context1 = this.b;
              String str1 = this.d;
              String str2 = this.e;
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append(((BadgeData)this.h.get(1)).id);
              stringBuilder.append("");
              PopAnchorBadge.a(context1, str1, str2, stringBuilder.toString(), this, (IRequestHost)this.g);
            } 
          } else {
            RecordingOnliveFragment recordingOnliveFragment = this.i;
            if (recordingOnliveFragment != null && recordingOnliveFragment.be) {
              context1 = this.b;
              String str1 = this.d;
              String str2 = this.e;
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append(((BadgeData)this.h.get(0)).id);
              stringBuilder.append("");
              PopAnchorBadgeCenter.b(context1, str1, str2, stringBuilder.toString(), this, (IRequestHost)this.g);
            } else {
              context1 = this.b;
              String str1 = this.d;
              String str2 = this.e;
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append(((BadgeData)this.h.get(0)).id);
              stringBuilder.append("");
              PopAnchorBadge.a(context1, str1, str2, stringBuilder.toString(), this, (IRequestHost)this.g);
            } 
          }  
      } else if (context1.getId() == R.id.medal_view3) {
        List<BadgeData> list1 = this.h;
        if (list1 != null && list1.size() >= 3)
          if (this.f instanceof PlayingOnliveBaseModeFragment) {
            if (this.j.A) {
              Context context2 = this.b;
              String str1 = this.d;
              String str2 = this.e;
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append(((BadgeData)this.h.get(2)).id);
              stringBuilder.append("");
              PopAnchorBadgeCenter.b(context2, str1, str2, stringBuilder.toString(), this, (IRequestHost)this.g);
            } else {
              Context context2 = this.b;
              String str1 = this.d;
              String str2 = this.e;
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append(((BadgeData)this.h.get(2)).id);
              stringBuilder.append("");
              PopAnchorBadge.a(context2, str1, str2, stringBuilder.toString(), this, (IRequestHost)this.g);
            } 
          } else {
            RecordingOnliveFragment recordingOnliveFragment = this.i;
            if (recordingOnliveFragment != null && recordingOnliveFragment.be) {
              Context context2 = this.b;
              String str1 = this.d;
              String str2 = this.e;
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append(((BadgeData)this.h.get(0)).id);
              stringBuilder.append("");
              PopAnchorBadgeCenter.b(context2, str1, str2, stringBuilder.toString(), this, (IRequestHost)this.g);
            } else {
              Context context2 = this.b;
              String str1 = this.d;
              String str2 = this.e;
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append(((BadgeData)this.h.get(0)).id);
              stringBuilder.append("");
              PopAnchorBadge.a(context2, str1, str2, stringBuilder.toString(), this, (IRequestHost)this.g);
            } 
          }  
      } 
    } 
    List<BadgeData> list = this.h;
    if (list != null && list.size() >= 1)
      if (this.f instanceof RecordingOnliveFragment) {
        RecordingOnliveFragment recordingOnliveFragment = this.i;
        if (recordingOnliveFragment != null) {
          recordingOnliveFragment.Q();
          return;
        } 
      } else {
        LiveRefreshUIObserver.a().d(4);
        LiveSetDataObserver.a().e(4);
      }  
  }
  
  public void setMedalData(List<BadgeData> paramList) {
    this.h = paramList;
    if (paramList != null && paramList.size() > 0) {
      this.l.setVisibility(8);
      this.m.setVisibility(8);
      this.n.setVisibility(8);
      for (int i = 0; i < paramList.size(); i++) {
        if (i > 2)
          return; 
        BadgeData badgeData = paramList.get(i);
        Logger.a("drb", new Object[] { "setMedalData = ", Integer.valueOf(i) });
        ImageWrapper imageWrapper = ImageLoader.a(null, badgeData.url).c(R.drawable.anchor_badge_default);
        if (i == 0) {
          this.l.setVisibility(0);
          imageWrapper.a(this.l);
        } else if (i == 1) {
          this.m.setVisibility(0);
          imageWrapper.a(this.m);
        } else if (i == 2) {
          this.n.setVisibility(0);
          imageWrapper.a(this.n);
        } 
      } 
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\view\MedalView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */