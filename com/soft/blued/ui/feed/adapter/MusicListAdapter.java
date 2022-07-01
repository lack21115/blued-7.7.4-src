package com.soft.blued.ui.feed.adapter;

import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.blued.android.core.AppInfo;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.imagecache.LoadOptions;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.utils.DensityUtils;
import com.soft.blued.ui.feed.model.MusicListItem;
import com.soft.blued.ui.feed.observer.MusicChoosedObserver;
import com.soft.blued.utils.StringUtils;
import com.soft.blued.utils.TypefaceUtils;
import java.util.ArrayList;
import java.util.List;

public class MusicListAdapter extends BaseAdapter {
  public List<MusicListItem> a = new ArrayList<MusicListItem>();
  
  public Context b;
  
  public LayoutInflater c;
  
  public LoadOptions d;
  
  public int e;
  
  public ViewHolder f;
  
  public int g;
  
  public ListView h;
  
  public int i;
  
  public int j;
  
  public String k;
  
  public IRequestHost l;
  
  public MusicListAdapter(Context paramContext, ListView paramListView, IRequestHost paramIRequestHost) {
    this.b = paramContext;
    this.h = paramListView;
    this.l = paramIRequestHost;
    this.d = new LoadOptions();
    LoadOptions loadOptions = this.d;
    loadOptions.b = 2131232618;
    loadOptions.d = 2131232618;
    this.c = LayoutInflater.from(this.b);
    this.e = AppInfo.l;
    this.i = -DensityUtils.a(this.b, 70.0F);
    this.j = DensityUtils.a(this.b, 15.0F);
  }
  
  public MusicListItem a(int paramInt) {
    return this.a.get(paramInt);
  }
  
  public void a() {
    this.f = null;
    this.g = -1;
  }
  
  public void a(int paramInt, ViewHolder paramViewHolder) {
    if (paramInt != d()) {
      b();
      ((MusicListItem)this.a.get(paramInt)).isChoosed = true;
      ListView listView = this.h;
      if (listView != null && this.f != null && this.g <= listView.getLastVisiblePosition() - 1 && this.g >= this.h.getFirstVisiblePosition() - 1) {
        a((View)ViewHolder.f(this.f), this.j, this.i, -1);
        ViewHolder.b(this.f).setImageResource(2131232620);
        ViewHolder.a(this.f).clearAnimation();
      } 
      a((View)ViewHolder.f(paramViewHolder), this.i, this.j, paramInt);
    } 
    AppInfo.n().postDelayed(new Runnable(this, paramInt) {
          public void run() {
            if (((MusicListItem)this.b.a.get(this.a)).isPlaying) {
              ((MusicListItem)this.b.a.get(this.a)).isPlaying = false;
              MusicChoosedObserver.a().b();
            } else {
              this.b.c();
              ((MusicListItem)this.b.a.get(this.a)).isPlaying = true;
              MusicChoosedObserver musicChoosedObserver = MusicChoosedObserver.a();
              String str = ((MusicListItem)this.b.a.get(this.a)).download;
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append(((MusicListItem)this.b.a.get(this.a)).id);
              stringBuilder.append("");
              musicChoosedObserver.b(str, stringBuilder.toString());
            } 
            this.b.notifyDataSetChanged();
          }
        }120L);
    this.g = paramInt;
    this.f = paramViewHolder;
  }
  
  public void a(View paramView, int paramInt1, int paramInt2, int paramInt3) {
    new ObjectAnimator();
    ValueAnimator valueAnimator = ObjectAnimator.ofInt(new int[] { paramInt1, paramInt2 });
    valueAnimator.setDuration(100L);
    valueAnimator.setInterpolator((TimeInterpolator)new AccelerateDecelerateInterpolator());
    valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this, paramView) {
          public void onAnimationUpdate(ValueAnimator param1ValueAnimator) {
            int i = ((Integer)param1ValueAnimator.getAnimatedValue()).intValue();
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams)this.a.getLayoutParams();
            layoutParams.rightMargin = i;
            this.a.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
          }
        });
    valueAnimator.start();
  }
  
  public void a(String paramString) {
    this.k = paramString;
  }
  
  public void a(List<MusicListItem> paramList) {
    this.a.clear();
    this.a.addAll(paramList);
    notifyDataSetChanged();
  }
  
  public String b(int paramInt) {
    if (paramInt >= 60) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramInt / 60);
      stringBuilder.append(":");
      stringBuilder.append(paramInt % 60);
      return stringBuilder.toString();
    } 
    if (paramInt > 0) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("0:");
      stringBuilder.append(paramInt);
      return stringBuilder.toString();
    } 
    return "";
  }
  
  public void b() {
    for (int i = 0; i < this.a.size(); i++)
      ((MusicListItem)this.a.get(i)).isChoosed = false; 
  }
  
  public void b(List<MusicListItem> paramList) {
    this.a.addAll(paramList);
    notifyDataSetChanged();
  }
  
  public void c() {
    for (int i = 0; i < this.a.size(); i++)
      ((MusicListItem)this.a.get(i)).isPlaying = false; 
  }
  
  public int d() {
    for (int i = 0; i < this.a.size(); i++) {
      if (((MusicListItem)this.a.get(i)).isChoosed)
        return i; 
    } 
    return -1;
  }
  
  public int getCount() {
    return this.a.size();
  }
  
  public long getItemId(int paramInt) {
    return ((MusicListItem)this.a.get(paramInt)).id;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {
    ViewHolder viewHolder1;
    ViewHolder viewHolder2;
    if (paramView == null) {
      viewHolder1 = new ViewHolder(this);
      View view = this.c.inflate(2131493604, paramViewGroup, false);
      ViewHolder.a(viewHolder1, view);
      view.setTag(viewHolder1);
    } else {
      ViewHolder viewHolder = (ViewHolder)viewHolder1.getTag();
      viewHolder2 = viewHolder1;
      viewHolder1 = viewHolder;
    } 
    MusicListItem musicListItem = this.a.get(paramInt);
    if (musicListItem != null) {
      if (!StringUtils.e(musicListItem.cover))
        ImageLoader.a(this.l, musicListItem.cover).a(2131232618).c().a(ViewHolder.a(viewHolder1)); 
      if (((MusicListItem)this.a.get(paramInt)).isPlaying) {
        ViewHolder.b(viewHolder1).setImageResource(2131232619);
        Animation animation = AnimationUtils.loadAnimation(this.b, 2130771998);
        animation.setInterpolator((Interpolator)new LinearInterpolator());
        ViewHolder.a(viewHolder1).startAnimation(animation);
      } else {
        ViewHolder.b(viewHolder1).setImageResource(2131232620);
        ViewHolder.a(viewHolder1).clearAnimation();
      } 
      ViewHolder.c(viewHolder1).setText(musicListItem.subject);
      TypefaceUtils.a(this.b, ViewHolder.c(viewHolder1), this.k, this.b.getResources().getColor(2131100538));
      ViewHolder.d(viewHolder1).setText(musicListItem.composer);
      TypefaceUtils.a(this.b, ViewHolder.d(viewHolder1), this.k, this.b.getResources().getColor(2131100538));
      ViewHolder.e(viewHolder1).setText(b(musicListItem.duration));
      LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams)ViewHolder.f(viewHolder1).getLayoutParams();
      if (musicListItem.isChoosed) {
        layoutParams.rightMargin = this.j;
      } else {
        layoutParams.rightMargin = this.i;
      } 
      ViewHolder.f(viewHolder1).setLayoutParams((ViewGroup.LayoutParams)layoutParams);
      ViewHolder.f(viewHolder1).setOnClickListener(new View.OnClickListener(this, musicListItem) {
            public void onClick(View param1View) {
              MusicChoosedObserver musicChoosedObserver = MusicChoosedObserver.a();
              String str = this.a.download;
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append(this.a.id);
              stringBuilder.append("");
              musicChoosedObserver.a(str, stringBuilder.toString());
            }
          });
      viewHolder2.setOnClickListener(new View.OnClickListener(this, paramInt, viewHolder1) {
            public void onClick(View param1View) {
              this.c.a(this.a, this.b);
            }
          });
    } 
    return (View)viewHolder2;
  }
  
  public class ViewHolder {
    private ImageView b;
    
    private ImageView c;
    
    private TextView d;
    
    private TextView e;
    
    private TextView f;
    
    private TextView g;
    
    public ViewHolder(MusicListAdapter this$0) {}
    
    private void a(View param1View) {
      this.b = (ImageView)param1View.findViewById(2131297463);
      this.c = (ImageView)param1View.findViewById(2131297464);
      this.d = (TextView)param1View.findViewById(2131301068);
      this.e = (TextView)param1View.findViewById(2131301067);
      this.f = (TextView)param1View.findViewById(2131301070);
      this.g = (TextView)param1View.findViewById(2131301466);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\feed\adapter\MusicListAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */