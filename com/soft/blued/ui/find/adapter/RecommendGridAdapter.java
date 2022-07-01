package com.soft.blued.ui.find.adapter;

import android.app.Dialog;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.blued.android.core.BlueAppLocal;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.image.ImageWrapper;
import com.blued.android.core.imagecache.LoadOptions;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.module.common.utils.AvatarUtils;
import com.blued.android.module.live_china.manager.LiveFloatManager;
import com.blued.das.login.LoginAndRegisterProtos;
import com.soft.blued.log.trackUtils.EventTrackLoginAndRegister;
import com.soft.blued.ui.find.model.BluedRecommendUsers;
import com.soft.blued.utils.StringUtils;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class RecommendGridAdapter extends BaseAdapter {
  private static final int[] b = new int[] { 2131297363, 2131297364, 2131297365, 2131297366 };
  
  private static final int[] c = new int[] { 2131299745, 2131299746, 2131299747, 2131299748 };
  
  private static final int[] d = new int[] { 2131296479, 2131296480, 2131296481, 2131296482 };
  
  private static final int[] e = new int[] { 2131296546, 2131296547, 2131296548, 2131296549 };
  
  public List<BluedRecommendUsers> a = new ArrayList<BluedRecommendUsers>();
  
  private Context f;
  
  private LayoutInflater g;
  
  private ActivityFragmentActive h = null;
  
  private Dialog i = null;
  
  private LoadOptions j;
  
  private HashSet<String> k = new HashSet<String>();
  
  private int l;
  
  private int m = 4;
  
  private int n;
  
  private View.OnClickListener o;
  
  public RecommendGridAdapter(Context paramContext, int paramInt, View.OnClickListener paramOnClickListener, ActivityFragmentActive paramActivityFragmentActive, Dialog paramDialog) {
    this.f = paramContext;
    if (paramInt != 0)
      this.m = paramInt; 
    paramInt = LiveFloatManager.a().C();
    int i = DensityUtils.a(paramContext, 6.0F);
    int j = this.m;
    this.n = (paramInt - i * (j + 1)) / j;
    this.o = paramOnClickListener;
    this.h = paramActivityFragmentActive;
    this.i = paramDialog;
    this.g = LayoutInflater.from(paramContext);
    paramInt = (paramContext.getResources().getDisplayMetrics()).widthPixels;
    this.j = new LoadOptions();
    LoadOptions loadOptions = this.j;
    loadOptions.d = 2131231368;
    loadOptions.b = 2131231368;
    paramInt >>= 1;
    loadOptions.a(paramInt, paramInt);
  }
  
  public void a(List<BluedRecommendUsers> paramList) {
    this.k.clear();
    this.a.clear();
    int i = 0;
    this.l = 0;
    if (paramList != null && paramList.size() > 0)
      while (i < paramList.size()) {
        BluedRecommendUsers bluedRecommendUsers = paramList.get(i);
        if (!this.k.contains(bluedRecommendUsers.uid)) {
          this.a.add(bluedRecommendUsers);
          this.k.add(bluedRecommendUsers.uid);
        } 
        i++;
      }  
    notifyDataSetChanged();
  }
  
  public void b(List<BluedRecommendUsers> paramList) {
    if (paramList != null && paramList.size() > 0) {
      for (int i = 0; i < paramList.size(); i++) {
        BluedRecommendUsers bluedRecommendUsers = paramList.get(i);
        if (!this.k.contains(bluedRecommendUsers.uid)) {
          this.a.add(bluedRecommendUsers);
          this.k.add(bluedRecommendUsers.uid);
        } else {
          this.l++;
        } 
      } 
      notifyDataSetChanged();
    } 
  }
  
  public int getCount() {
    return (int)Math.ceil((this.a.size() / this.m));
  }
  
  public Object getItem(int paramInt) {
    return Integer.valueOf(paramInt);
  }
  
  public long getItemId(int paramInt) {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {
    ViewHolder viewHolder;
    int k;
    if (paramView == null) {
      ViewHolder viewHolder1 = new ViewHolder();
      int m = this.m;
      if (m == 3) {
        paramView = this.g.inflate(2131493282, paramViewGroup, false);
      } else if (m == 4) {
        paramView = this.g.inflate(2131493283, paramViewGroup, false);
      } 
      viewHolder1.a = paramView.findViewById(2131298026);
      FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, this.n);
      viewHolder1.a.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
      viewHolder1.a.requestLayout();
      for (m = 0; m < this.m; m++) {
        viewHolder1.b[m] = (ImageView)paramView.findViewById(c[m]);
        viewHolder1.c[m] = (ImageView)paramView.findViewById(d[m]);
        viewHolder1.e[m] = (ImageView)paramView.findViewById(b[m]);
        viewHolder1.d[m] = (ImageView)paramView.findViewById(e[m]);
      } 
      paramView.setTag(viewHolder1);
      viewHolder = viewHolder1;
    } else {
      viewHolder = (ViewHolder)paramView.getTag();
    } 
    int j = this.a.size();
    int i = this.m;
    j -= paramInt * i;
    if (j < i)
      i = j; 
    j = 0;
    while (true) {
      k = i;
      if (j < i) {
        viewHolder.c[j].setVisibility(0);
        viewHolder.b[j].setVisibility(0);
        viewHolder.e[j].setVisibility(0);
        viewHolder.d[j].setVisibility(0);
        BluedRecommendUsers bluedRecommendUsers = this.a.get(paramInt * i + j);
        ImageWrapper imageWrapper = ImageLoader.a((IRequestHost)this.h, AvatarUtils.a(0, bluedRecommendUsers.avatar)).a(2131231368);
        if (this.m == 4)
          imageWrapper.c(); 
        imageWrapper.a(viewHolder.e[j]);
        if (!TextUtils.isEmpty(bluedRecommendUsers.role)) {
          String str = BlueAppLocal.c().getLanguage();
          if (!TextUtils.isEmpty(str) && str.toLowerCase().equals("zh")) {
            if ("0".equals(bluedRecommendUsers.role)) {
              viewHolder.b[j].setImageResource(2131233596);
            } else if ("1".equals(bluedRecommendUsers.role)) {
              viewHolder.b[j].setImageResource(2131233597);
            } else if ("0.5".equals(bluedRecommendUsers.role)) {
              viewHolder.b[j].setImageResource(2131233598);
            } else if ("-1".equals(bluedRecommendUsers.role)) {
              viewHolder.b[j].setImageResource(2131233600);
            } else {
              viewHolder.b[j].setImageResource(2131233600);
            } 
          } else if ("0".equals(bluedRecommendUsers.role)) {
            viewHolder.b[j].setImageResource(2131233599);
          } else if ("1".equals(bluedRecommendUsers.role)) {
            viewHolder.b[j].setImageResource(2131233601);
          } else if ("0.5".equals(bluedRecommendUsers.role)) {
            viewHolder.b[j].setImageResource(2131233602);
          } else {
            viewHolder.b[j].setImageResource(2131233600);
          } 
        } else {
          viewHolder.b[j].setImageResource(2131233600);
        } 
        if (!bluedRecommendUsers.isGridVisibility) {
          bluedRecommendUsers.isGridVisibility = true;
          EventTrackLoginAndRegister.a(LoginAndRegisterProtos.Event.RECOMMEND_PAGE_GRID_AVATAR_DRAW, bluedRecommendUsers.uid);
        } 
        viewHolder.e[j].setTag(Integer.valueOf(this.m * paramInt + j));
        viewHolder.e[j].setOnClickListener(this.o);
        if (!StringUtils.e(bluedRecommendUsers.relationship)) {
          if ("0".equals(bluedRecommendUsers.relationship)) {
            viewHolder.c[j].setImageResource(2131234226);
          } else {
            viewHolder.c[j].setImageResource(2131234229);
          } 
        } else {
          viewHolder.c[j].setImageResource(2131234226);
        } 
        j++;
        continue;
      } 
      break;
    } 
    while (k < this.m) {
      viewHolder.c[k].setVisibility(4);
      viewHolder.b[k].setVisibility(4);
      viewHolder.e[k].setVisibility(4);
      viewHolder.d[k].setVisibility(4);
      viewHolder.e[k].setOnClickListener(null);
      k++;
    } 
    return paramView;
  }
  
  class ViewHolder {
    public View a;
    
    public ImageView[] b = new ImageView[RecommendGridAdapter.a(this.f)];
    
    public ImageView[] c = new ImageView[RecommendGridAdapter.a(this.f)];
    
    public ImageView[] d = new ImageView[RecommendGridAdapter.a(this.f)];
    
    public ImageView[] e = new ImageView[RecommendGridAdapter.a(this.f)];
    
    private ViewHolder(RecommendGridAdapter this$0) {}
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\find\adapter\RecommendGridAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */