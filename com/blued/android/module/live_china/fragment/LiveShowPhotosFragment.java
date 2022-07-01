package com.blued.android.module.live_china.fragment;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.AppInfo;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.framework.ui.mvp.MvpFragment;
import com.blued.android.framework.view.badgeview.DisplayUtil;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.adapter.LiveShowPhotoAdapter;
import com.blued.android.module.live_china.adapter.PhotoFolderAdapter;
import com.blued.android.module.live_china.presenter.LiveShowPhotosPresenter;
import com.blued.android.module.live_china.same.Logger;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;
import java.util.List;

public class LiveShowPhotosFragment extends MvpFragment<LiveShowPhotosPresenter> implements View.OnClickListener {
  TextView d;
  
  LinearLayout e;
  
  RecyclerView f;
  
  LinearLayout g;
  
  TextView h;
  
  SmartRefreshLayout i;
  
  ListView j;
  
  TextView n;
  
  TextView o;
  
  private PhotoFolderAdapter p;
  
  private LiveShowPhotoAdapter q;
  
  private int r;
  
  private ValueAnimator a(int paramInt1, int paramInt2) {
    this.j.clearAnimation();
    ValueAnimator valueAnimator = ValueAnimator.ofInt(new int[] { paramInt1, paramInt2 });
    valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) {
          public void onAnimationUpdate(ValueAnimator param1ValueAnimator) {
            int i = ((Integer)param1ValueAnimator.getAnimatedValue()).intValue();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("onAnimationUpdate value = ");
            stringBuilder.append(i);
            Logger.d("LiveShowPhotosFragment", new Object[] { stringBuilder.toString() });
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams)this.a.j.getLayoutParams();
            layoutParams.height = i;
            this.a.j.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
          }
        });
    valueAnimator.setDuration(300L);
    valueAnimator.setInterpolator((TimeInterpolator)new LinearInterpolator());
    return valueAnimator;
  }
  
  private void d(List<String> paramList) {
    this.g.setVisibility(8);
    this.f.setVisibility(0);
    this.q.c(paramList);
  }
  
  private void k() {
    this.p = new PhotoFolderAdapter(((LiveShowPhotosPresenter)s()).m());
    this.j.setAdapter((ListAdapter)this.p);
    this.j.setOnItemClickListener(new AdapterView.OnItemClickListener(this) {
          public void onItemClick(AdapterView<?> param1AdapterView, View param1View, int param1Int, long param1Long) {
            this.a.h.setText(((LiveShowPhotosPresenter)this.a.s()).m().get(param1Int));
            LiveShowPhotosFragment.b(this.a).a();
            LiveShowPhotosFragment.b(this.a).a(param1Int);
            if (param1Int == 0) {
              this.a.i.c(false);
            } else {
              this.a.i.c(true);
            } 
            ((LiveShowPhotosPresenter)this.a.s()).b(param1Int);
            LiveShowPhotosFragment.c(this.a);
          }
        });
  }
  
  private void l() {
    this.j.measure(0, 0);
    int i = this.j.getMeasuredHeight();
    ((RelativeLayout.LayoutParams)this.j.getLayoutParams()).height = 1;
    this.j.setVisibility(0);
    a(1, i).start();
  }
  
  private void m() {
    this.j.measure(0, 0);
    ValueAnimator valueAnimator = a(this.j.getMeasuredHeight(), 0);
    valueAnimator.addListener((Animator.AnimatorListener)new AnimatorListenerAdapter(this) {
          public void onAnimationEnd(Animator param1Animator) {
            this.a.j.setVisibility(8);
          }
        });
    valueAnimator.start();
  }
  
  public void a(Bundle paramBundle) {
    super.a(paramBundle);
    this.d = (TextView)this.l.findViewById(R.id.tv_cancel);
    this.e = (LinearLayout)this.l.findViewById(R.id.ll_center_view);
    this.f = (RecyclerView)this.l.findViewById(R.id.rv_photos);
    this.g = (LinearLayout)this.l.findViewById(R.id.no_data_view);
    this.h = (TextView)this.l.findViewById(R.id.tv_folder_name);
    this.i = (SmartRefreshLayout)this.l.findViewById(R.id.refresh_layout);
    this.j = (ListView)this.l.findViewById(R.id.folder_list);
    this.n = (TextView)this.l.findViewById(R.id.no_data_retry);
    this.o = (TextView)this.l.findViewById(R.id.no_data_text);
    this.d.setOnClickListener(this);
    this.e.setOnClickListener(this);
    this.n.setOnClickListener(this);
    k();
    this.i.a(new OnRefreshLoadMoreListener(this) {
          public void a(RefreshLayout param1RefreshLayout) {
            ((LiveShowPhotosPresenter)this.a.s()).f();
          }
          
          public void onRefresh(RefreshLayout param1RefreshLayout) {
            ((LiveShowPhotosPresenter)this.a.s()).e();
          }
        });
    this.q = new LiveShowPhotoAdapter((BaseFragment)this);
    GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 3);
    this.f.setLayoutManager((RecyclerView.LayoutManager)gridLayoutManager);
    this.f.addItemDecoration(new RecyclerView.ItemDecoration(this) {
          public void getItemOffsets(Rect param1Rect, View param1View, RecyclerView param1RecyclerView, RecyclerView.State param1State) {
            param1Rect.left = LiveShowPhotosFragment.a(this.a);
            param1Rect.top = LiveShowPhotosFragment.a(this.a);
            if (param1RecyclerView.getChildLayoutPosition(param1View) % 3 == 0)
              param1Rect.left = 0; 
          }
        });
    this.f.setAdapter((RecyclerView.Adapter)this.q);
  }
  
  public void a(String paramString, boolean paramBoolean) {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: iload_2
    //   3: invokespecial a : (Ljava/lang/String;Z)V
    //   6: ldc_w 'LiveShowPhotosFragment'
    //   9: iconst_1
    //   10: anewarray java/lang/Object
    //   13: dup
    //   14: iconst_0
    //   15: ldc_w 'dismissDataLoading ... '
    //   18: aastore
    //   19: invokestatic d : (Ljava/lang/String;[Ljava/lang/Object;)V
    //   22: aload_1
    //   23: invokevirtual hashCode : ()I
    //   26: istore_3
    //   27: iload_3
    //   28: ldc_w -1290256561
    //   31: if_icmpeq -> 59
    //   34: iload_3
    //   35: ldc_w 623698297
    //   38: if_icmpeq -> 44
    //   41: goto -> 74
    //   44: aload_1
    //   45: ldc_w '_load_type_loadmore_'
    //   48: invokevirtual equals : (Ljava/lang/Object;)Z
    //   51: ifeq -> 74
    //   54: iconst_1
    //   55: istore_3
    //   56: goto -> 76
    //   59: aload_1
    //   60: ldc_w '_load_type_refresh_'
    //   63: invokevirtual equals : (Ljava/lang/Object;)Z
    //   66: ifeq -> 74
    //   69: iconst_0
    //   70: istore_3
    //   71: goto -> 76
    //   74: iconst_m1
    //   75: istore_3
    //   76: iload_3
    //   77: ifeq -> 99
    //   80: iload_3
    //   81: iconst_1
    //   82: if_icmpeq -> 88
    //   85: goto -> 107
    //   88: aload_0
    //   89: getfield i : Lcom/scwang/smartrefresh/layout/SmartRefreshLayout;
    //   92: invokevirtual h : ()Lcom/scwang/smartrefresh/layout/SmartRefreshLayout;
    //   95: pop
    //   96: goto -> 107
    //   99: aload_0
    //   100: getfield i : Lcom/scwang/smartrefresh/layout/SmartRefreshLayout;
    //   103: invokevirtual g : ()Lcom/scwang/smartrefresh/layout/SmartRefreshLayout;
    //   106: pop
    //   107: aload_0
    //   108: getfield q : Lcom/blued/android/module/live_china/adapter/LiveShowPhotoAdapter;
    //   111: astore_1
    //   112: aload_1
    //   113: ifnull -> 123
    //   116: aload_1
    //   117: invokevirtual getItemCount : ()I
    //   120: ifgt -> 179
    //   123: aload_0
    //   124: getfield g : Landroid/widget/LinearLayout;
    //   127: iconst_0
    //   128: invokevirtual setVisibility : (I)V
    //   131: aload_0
    //   132: getfield f : Landroidx/recyclerview/widget/RecyclerView;
    //   135: bipush #8
    //   137: invokevirtual setVisibility : (I)V
    //   140: iload_2
    //   141: ifne -> 162
    //   144: aload_0
    //   145: getfield n : Landroid/widget/TextView;
    //   148: iconst_0
    //   149: invokevirtual setVisibility : (I)V
    //   152: aload_0
    //   153: getfield o : Landroid/widget/TextView;
    //   156: bipush #8
    //   158: invokevirtual setVisibility : (I)V
    //   161: return
    //   162: aload_0
    //   163: getfield n : Landroid/widget/TextView;
    //   166: bipush #8
    //   168: invokevirtual setVisibility : (I)V
    //   171: aload_0
    //   172: getfield o : Landroid/widget/TextView;
    //   175: iconst_0
    //   176: invokevirtual setVisibility : (I)V
    //   179: return
  }
  
  public void a(List<String> paramList) {
    d(paramList);
  }
  
  public void b(List<String> paramList) {
    d(paramList);
  }
  
  public void c(List<String> paramList) {
    this.q.a();
    d(paramList);
  }
  
  public void onActivityCreated(Bundle paramBundle) {
    super.onActivityCreated(paramBundle);
    this.i.c(false);
  }
  
  public void onClick(View paramView) {
    if (paramView.getId() == R.id.tv_cancel) {
      LiveEventBus.get("live_dialog_cancel").post("cancel");
      return;
    } 
    if (paramView.getId() == R.id.ll_center_view) {
      if (this.j.getVisibility() == 0) {
        m();
        return;
      } 
      l();
      return;
    } 
    if (paramView.getId() == R.id.no_data_retry)
      ((LiveShowPhotosPresenter)s()).e(); 
  }
  
  public void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    this.r = DisplayUtil.a(AppInfo.d(), 3.0F);
  }
  
  public int p() {
    return R.layout.fragment_live_show_photos;
  }
  
  public void x() {
    super.x();
    Logger.d("LiveShowPhotosFragment", new Object[] { "enableLoadMore ... " });
    this.i.b(true);
  }
  
  public void y() {
    super.y();
    Logger.d("LiveShowPhotosFragment", new Object[] { "disableLoadMore ... " });
    this.i.b(false);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\fragment\LiveShowPhotosFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */