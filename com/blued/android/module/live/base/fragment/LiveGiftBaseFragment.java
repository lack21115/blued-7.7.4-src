package com.blued.android.module.live.base.fragment;

import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.blued.android.core.AppInfo;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.framework.utils.LogUtils;
import com.blued.android.framework.utils.StringUtils;
import com.blued.android.framework.utils.TypeUtils;
import com.blued.android.framework.utils.UiUtils;
import com.blued.android.framework.view.badgeview.DisplayUtil;
import com.blued.android.module.common.adapter.CommonAdapter;
import com.blued.android.module.common.fragment.BaseGiftRootFragment;
import com.blued.android.module.common.model.BaseGiftModel;
import com.blued.android.module.common.model.CommonGiftPackageModel;
import com.blued.android.module.common.utils.CommonStringUtils;
import com.blued.android.module.live.base.R;
import com.blued.android.module.live.base.event.LiveBeansChangeEvent;
import com.blued.android.module.live.base.manager.LiveDataManager;
import com.blued.android.module.live.base.model.BasePayRemaining;
import com.blued.android.module.live.base.model.CommonLiveGiftModel;
import com.blued.android.module.live.base.model.LiveGiftNumberModel;
import com.blued.android.module.live.base.utils.LiveBasePreferences;
import com.jeremyliao.liveeventbus.LiveEventBus;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import javax.annotation.OverridingMethodsMustInvokeSuper;

public abstract class LiveGiftBaseFragment extends BaseGiftRootFragment<CommonGiftPackageModel> implements View.OnClickListener {
  protected ListView A;
  
  protected CommonAdapter B;
  
  protected long C;
  
  protected String D = "";
  
  public LiveGiftNumberModel E;
  
  protected String F = "";
  
  protected boolean G = false;
  
  protected CommonLiveGiftModel H;
  
  protected Timer I;
  
  protected int J = 10;
  
  int[] K = new int[2];
  
  private int L = 0;
  
  private int M = 100;
  
  private String N = "live_gift";
  
  protected ViewGroup r;
  
  protected TextView s;
  
  protected TextView t;
  
  protected TextView u;
  
  protected View v;
  
  public TextView w;
  
  protected LinearLayout x;
  
  protected ImageView y;
  
  protected View z;
  
  public int A() {
    LiveGiftNumberModel liveGiftNumberModel = this.E;
    return (liveGiftNumberModel != null && liveGiftNumberModel.count > 0) ? this.E.count : 1;
  }
  
  protected void B() {
    if (this.j == null)
      this.j = t(); 
    BaseGiftModel baseGiftModel = a(this.j);
    if (baseGiftModel != null) {
      LiveEventBus.get("gift_item_selected").post(this.j);
      this.h.setToolBtnSelect(baseGiftModel.packageTabIndex);
      this.n.setCurrentItem(baseGiftModel.packageTabIndex, false);
    } 
  }
  
  protected abstract void C();
  
  protected ViewGroup D() {
    ViewGroup viewGroup = (ViewGroup)getActivity().getWindow().getDecorView();
    LinearLayout linearLayout = new LinearLayout(getContext());
    linearLayout.setLayoutParams((ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-1, -1));
    linearLayout.setId(2147483647);
    linearLayout.setBackgroundResource(17170445);
    viewGroup.addView((View)linearLayout);
    return (ViewGroup)linearLayout;
  }
  
  public int E() {
    return -1;
  }
  
  public int F() {
    return -1;
  }
  
  protected void G() {
    this.B = new CommonAdapter<LiveGiftNumberModel>(this, R.layout.item_live_gift_select_num_layout) {
        public void a(CommonAdapter.ViewHolder param1ViewHolder, LiveGiftNumberModel param1LiveGiftNumberModel, int param1Int) {
          param1ViewHolder.a(R.id.item_live_gift_select_num_tv, String.valueOf(param1LiveGiftNumberModel.count));
          param1ViewHolder.a(R.id.item_live_gift_select_name, param1LiveGiftNumberModel.name);
          if (this.d.G) {
            param1ViewHolder.b(R.id.item_live_gift_select_name, 0);
          } else {
            param1ViewHolder.b(R.id.item_live_gift_select_name, 8);
          } 
          if (param1LiveGiftNumberModel.selected) {
            param1ViewHolder.a(R.id.item_live_gift_select_num_tv, -1);
            param1ViewHolder.a(R.id.item_live_gift_select_name, -1);
          } else {
            param1ViewHolder.a(R.id.item_live_gift_select_num_tv, Color.parseColor("#99FFFFFF"));
            param1ViewHolder.a(R.id.item_live_gift_select_name, Color.parseColor("#99FFFFFF"));
          } 
          if (param1Int == this.b.size() - 1) {
            param1ViewHolder.b(R.id.item_live_gift_select_divider, 8);
          } else {
            param1ViewHolder.b(R.id.item_live_gift_select_divider, 0);
          } 
          param1ViewHolder.a().setOnClickListener(new -$$Lambda$LiveGiftBaseFragment$3$c3nbM3Bd_4UjsGrplH_jzEN0AZE(this, param1LiveGiftNumberModel));
        }
      };
  }
  
  public void H() {}
  
  protected void I() {
    Timer timer = this.I;
    if (timer != null) {
      timer.cancel();
      this.I = null;
    } 
    this.L = 0;
  }
  
  protected void J() {
    I();
  }
  
  public boolean V_() {
    View view = this.z;
    if (view != null && view.getVisibility() == 0) {
      a(false);
      return true;
    } 
    return super.V_();
  }
  
  protected void a(View paramView, int paramInt1, int paramInt2) {
    TranslateAnimation translateAnimation1 = new TranslateAnimation(0.0F, paramInt1, 0.0F, 0.0F);
    translateAnimation1.setInterpolator((Interpolator)new LinearInterpolator());
    translateAnimation1.setRepeatCount(0);
    translateAnimation1.setFillAfter(true);
    float f = paramInt2;
    TranslateAnimation translateAnimation2 = new TranslateAnimation(0.0F, 0.0F, 0.0F, f);
    translateAnimation2.setInterpolator((Interpolator)new DecelerateInterpolator());
    translateAnimation2.setRepeatCount(0);
    translateAnimation1.setFillAfter(true);
    ScaleAnimation scaleAnimation = new ScaleAnimation(1.0F, 0.4F, 1.0F, 0.4F, 1, 0.5F, 1, 0.5F);
    AnimationSet animationSet = new AnimationSet(false);
    animationSet.addAnimation((Animation)scaleAnimation);
    animationSet.setFillAfter(false);
    animationSet.addAnimation((Animation)translateAnimation1);
    animationSet.addAnimation((Animation)translateAnimation2);
    animationSet.setDuration((long)Math.abs(f / 0.7F));
    paramView.startAnimation((Animation)animationSet);
    animationSet.setAnimationListener(new Animation.AnimationListener(this, paramView) {
          public void onAnimationEnd(Animation param1Animation) {
            this.a.setVisibility(8);
          }
          
          public void onAnimationRepeat(Animation param1Animation) {}
          
          public void onAnimationStart(Animation param1Animation) {
            LogUtils.c("onAnimationStart");
            this.a.setVisibility(0);
          }
        });
  }
  
  protected void a(ViewGroup paramViewGroup, View paramView, int paramInt1, int paramInt2) {
    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(UiUtils.a(getContext(), 66.0F), UiUtils.a(getContext(), 66.0F));
    layoutParams.leftMargin = paramInt1;
    layoutParams.topMargin = paramInt2;
    paramView.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
  }
  
  protected void a(BasePayRemaining paramBasePayRemaining) {
    if (paramBasePayRemaining == null)
      return; 
    LiveDataManager.a().b(paramBasePayRemaining.beans);
    c(paramBasePayRemaining);
    LiveEventBus.get("live_beans_change").post(new LiveBeansChangeEvent(LiveDataManager.a().c(), paramBasePayRemaining.beans_current, paramBasePayRemaining.beans_current));
  }
  
  protected void a(CommonLiveGiftModel paramCommonLiveGiftModel) {
    int i;
    LogUtils.c("setAnim");
    ImageView imageView = new ImageView(getContext());
    imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
    ImageLoader.a((IRequestHost)((BaseFragment)getParentFragment()).w_(), paramCommonLiveGiftModel.images_static).a(imageView);
    this.r = D();
    this.r.addView((View)imageView);
    int j = 0;
    int k = -1;
    int n = 2;
    int m = 4;
    while (j < this.i.size()) {
      CommonGiftPackageModel commonGiftPackageModel = this.i.get(j);
      int i2 = k;
      if (commonGiftPackageModel.tabIndex == paramCommonLiveGiftModel.packageTabIndex) {
        int i3 = commonGiftPackageModel.getLine();
        int i4 = commonGiftPackageModel.getRow();
        i = 0;
        while (true) {
          i2 = k;
          n = i3;
          m = i4;
          if (i < commonGiftPackageModel.goods.size()) {
            if (StringUtils.a(paramCommonLiveGiftModel.index, ((BaseGiftModel)commonGiftPackageModel.goods.get(i)).index)) {
              i2 = i;
              n = i3;
              m = i4;
              break;
            } 
            i++;
            continue;
          } 
          break;
        } 
      } 
      j++;
      k = i2;
    } 
    if (k < 0)
      return; 
    int i1 = k - k / n * m * n * m;
    if (LiveDataManager.a().f()) {
      i = (AppInfo.m - DisplayUtil.a(getContext(), 200.0F)) / m;
    } else {
      i = (AppInfo.l - DisplayUtil.a(getContext(), 30.0F)) / m;
    } 
    if (LiveDataManager.a().f()) {
      if (n <= 1) {
        j = i1;
      } else {
        j = i1 - m * (n - 1);
      } 
      j = DisplayUtil.a(getContext(), 30.0F) + j * i + i / 2;
      k = DisplayUtil.a(getContext(), 33.0F);
    } else {
      j = DisplayUtil.a(getContext(), 15.0F) + i1 % m * i + i / 2;
      k = DisplayUtil.a(getContext(), 33.0F);
    } 
    m = j - k;
    int[] arrayOfInt = this.K;
    if (arrayOfInt[0] == 0 || arrayOfInt[1] == 0)
      this.h.getLocationInWindow(this.K); 
    k = this.K[1];
    j = k;
    if (k == 0) {
      if (LiveDataManager.a().f()) {
        j = AppInfo.l;
        k = DisplayUtil.a(getContext(), 175.0F);
      } else {
        j = AppInfo.m;
        k = DisplayUtil.a(getContext(), 245.0F);
      } 
      j -= k;
    } 
    k = j + i1 / 4 * i + DisplayUtil.a(getContext(), 33.0F) - i / 2;
    if (LiveDataManager.a().f()) {
      j = AppInfo.m / 2;
      i = DisplayUtil.a(getContext(), 120.0F);
    } else {
      j = AppInfo.l / 2;
      i = DisplayUtil.a(getContext(), 190.0F);
    } 
    a(this.r, (View)imageView, m, k);
    a((View)imageView, j - m, i - k);
  }
  
  protected void a(CommonLiveGiftModel paramCommonLiveGiftModel, int paramInt) {
    int j = this.J;
    int i = paramInt;
    if (paramInt > j)
      i = j; 
    if (paramCommonLiveGiftModel == null)
      return; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramCommonLiveGiftModel.index);
    stringBuilder.append(" left double hit time: ");
    stringBuilder.append(i);
    LogUtils.c(stringBuilder.toString());
    if (paramCommonLiveGiftModel.double_hit == 1) {
      paramCommonLiveGiftModel.comboWaitTime = i;
      if (i <= 0)
        paramCommonLiveGiftModel.hit_count = 0; 
      LiveEventBus.get("gift_item_update").post(paramCommonLiveGiftModel);
    } 
  }
  
  public void a(boolean paramBoolean) {
    byte b;
    if (E() != -1 && F() != -1) {
      ImageView imageView = this.y;
      if (paramBoolean) {
        b = E();
      } else {
        b = F();
      } 
      imageView.setImageResource(b);
    } 
    View view = this.z;
    if (paramBoolean) {
      b = 0;
    } else {
      b = 8;
    } 
    view.setVisibility(b);
  }
  
  protected void b(BasePayRemaining paramBasePayRemaining) {}
  
  protected void b(CommonLiveGiftModel paramCommonLiveGiftModel, int paramInt) {
    I();
    this.I = new Timer();
    this.I.schedule(new TimerTask(this, paramCommonLiveGiftModel) {
          public void run() {
            if (this.b.getParentFragment() != null) {
              if (!((BaseFragment)this.b.getParentFragment()).w_().isActive())
                return; 
              if (this.a == null)
                return; 
              LiveGiftBaseFragment.a(this.b);
              LiveGiftBaseFragment liveGiftBaseFragment = this.b;
              liveGiftBaseFragment.d(LiveGiftBaseFragment.b(liveGiftBaseFragment));
            } 
          }
        }0L, this.M);
    c(paramCommonLiveGiftModel, paramInt);
  }
  
  public void b(List<CommonGiftPackageModel> paramList) {
    CommonLiveGiftModel commonLiveGiftModel = (CommonLiveGiftModel)a(this.j);
    a(paramList);
    for (int i = 0; i < paramList.size(); i++) {
      for (int j = 0; j < ((CommonGiftPackageModel)paramList.get(i)).goods.size(); j++) {
        CommonLiveGiftModel commonLiveGiftModel1 = ((CommonGiftPackageModel)paramList.get(i)).goods.get(j);
        commonLiveGiftModel1.pic = commonLiveGiftModel1.images_static;
        commonLiveGiftModel1.pic_apng = commonLiveGiftModel1.images_apng2;
        commonLiveGiftModel1.pic_dynamic = commonLiveGiftModel1.images_gif;
        if (commonLiveGiftModel != null && StringUtils.a(commonLiveGiftModel1.index, commonLiveGiftModel.index)) {
          commonLiveGiftModel1.sendGiftStatus = commonLiveGiftModel.sendGiftStatus;
          commonLiveGiftModel1.hit_batch = commonLiveGiftModel.hit_batch;
          commonLiveGiftModel1.hit_count = commonLiveGiftModel.hit_count;
          commonLiveGiftModel1.hit_id = commonLiveGiftModel.hit_id;
          commonLiveGiftModel1.isSelected = commonLiveGiftModel.isSelected;
          commonLiveGiftModel1.comboWaitTime = commonLiveGiftModel.comboWaitTime;
        } else {
          commonLiveGiftModel1.sendGiftStatus = 0;
        } 
        LogUtils.c(commonLiveGiftModel1.toString());
      } 
    } 
    this.i.clear();
    this.i.addAll(paramList);
    v();
  }
  
  protected void c(int paramInt) {
    a((CommonLiveGiftModel)a(this.j), paramInt);
  }
  
  public void c(BasePayRemaining paramBasePayRemaining) {
    long l1;
    TextView textView = this.s;
    long l2 = LiveDataManager.a().d();
    if (paramBasePayRemaining != null) {
      l1 = paramBasePayRemaining.bonus;
    } else {
      l1 = 0L;
    } 
    textView.setText(CommonStringUtils.d(String.valueOf(l2 + l1)));
  }
  
  protected void c(CommonLiveGiftModel paramCommonLiveGiftModel, int paramInt) {}
  
  protected void c(String paramString) {}
  
  protected void c(List<LiveGiftNumberModel> paramList) {
    if (TypeUtils.a(paramList))
      return; 
    a(true);
    this.z.setOnClickListener(new -$$Lambda$LiveGiftBaseFragment$ZDbaHl4iJ2qPWwWP04Y2yknW1yw(this));
    if (this.B == null) {
      G();
      this.A.setAdapter((ListAdapter)this.B);
    } 
    this.B.a(paramList);
  }
  
  protected void d(int paramInt) {
    int i = paramInt / 5;
    if (paramInt % 5 == 0)
      c(this.J - i); 
    if (i >= this.J)
      J(); 
  }
  
  @OverridingMethodsMustInvokeSuper
  public void d(CommonLiveGiftModel paramCommonLiveGiftModel, int paramInt) {
    CommonLiveGiftModel commonLiveGiftModel = this.H;
    if (commonLiveGiftModel != null && !StringUtils.a(commonLiveGiftModel.index, paramCommonLiveGiftModel.index)) {
      I();
      if (this.H.double_hit == 1)
        a(this.H, 0); 
    } 
  }
  
  protected void e(CommonLiveGiftModel paramCommonLiveGiftModel, int paramInt) {
    if (paramCommonLiveGiftModel == null)
      return; 
    CommonGiftPackageModel commonGiftPackageModel = b(paramCommonLiveGiftModel.index);
    if (commonGiftPackageModel != null && commonGiftPackageModel.deleteItemIfZeroCount && paramCommonLiveGiftModel.count <= 0)
      return; 
    if (paramCommonLiveGiftModel.double_hit == 1)
      b(paramCommonLiveGiftModel, paramInt); 
  }
  
  public void n() {
    super.n();
    this.N = x();
  }
  
  public void o() {
    super.o();
    if (!TypeUtils.a(LiveDataManager.a().b(this.N))) {
      this.i.clear();
      this.i.addAll(LiveDataManager.a().b(this.N));
      v();
    } 
  }
  
  public void onHiddenChanged(boolean paramBoolean) {
    super.onHiddenChanged(paramBoolean);
    if (paramBoolean) {
      LiveDataManager.a().a(this.N, this.i);
      c(0);
      I();
    } 
  }
  
  @OverridingMethodsMustInvokeSuper
  public void p() {
    super.p();
    this.u.setOnClickListener(this);
    this.v.setOnClickListener(new -$$Lambda$LiveGiftBaseFragment$46IfMYB7p-iGZO51HhgD_nW9z3U(this));
    this.t.setOnClickListener(this);
    this.d.setOnClickListener(-$$Lambda$LiveGiftBaseFragment$ND5Rz9Xsp5i_MNP94AGKqSRpPx4.INSTANCE);
    this.x.setOnClickListener(this);
    LiveEventBus.get("gold_remain_result", BasePayRemaining.class).observe((LifecycleOwner)this, new Observer<BasePayRemaining>(this) {
          public void a(BasePayRemaining param1BasePayRemaining) {
            this.a.c(param1BasePayRemaining);
            if (param1BasePayRemaining != null && param1BasePayRemaining.text != null) {
              boolean bool = LiveBasePreferences.b();
              if (!TextUtils.isEmpty(param1BasePayRemaining.text.goods) && !bool)
                this.a.c(param1BasePayRemaining.text.goods); 
              if (!TextUtils.isEmpty(param1BasePayRemaining.text.sums)) {
                this.a.t.setText(param1BasePayRemaining.text.sums);
              } else {
                this.a.t.setText(this.a.F);
              } 
            } 
            if (param1BasePayRemaining != null)
              this.a.b(param1BasePayRemaining); 
          }
        });
  }
  
  public void q() {
    c(new BasePayRemaining());
    y();
  }
  
  public void r() {}
  
  public void s() {}
  
  public void v() {
    super.v();
    B();
  }
  
  protected abstract String x();
  
  protected abstract void y();
  
  public boolean z() {
    return !(w_() == null || !isAdded() || !a());
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live\base\fragment\LiveGiftBaseFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */