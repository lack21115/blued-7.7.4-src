package com.soft.blued.ui.user.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.blued.android.core.AppInfo;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.utils.DensityUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.soft.blued.ui.user.model.AlbumFlow;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WaterfallPicturesAdapter extends BaseQuickAdapter<AlbumFlow, BaseViewHolder> {
  private ImageView a;
  
  private int b;
  
  private int c;
  
  private int d;
  
  private int e;
  
  private Set<String> f = new HashSet<String>();
  
  private List<AlbumFlow> g = new ArrayList<AlbumFlow>();
  
  private List<AlbumFlow> h = new ArrayList<AlbumFlow>();
  
  private IRequestHost i;
  
  public WaterfallPicturesAdapter(Context paramContext, IRequestHost paramIRequestHost) {
    super(2131493626, new ArrayList());
    this.i = paramIRequestHost;
    int i = DensityUtils.a(paramContext, 30.0F);
    this.b = (AppInfo.l - i) / 2;
    this.d = DensityUtils.a(paramContext, 400.0F);
    this.e = DensityUtils.a(paramContext, 130.0F);
  }
  
  private boolean a(AlbumFlow paramAlbumFlow) {
    float f;
    String[] arrayOfString = paramAlbumFlow.feed_pics_width;
    boolean bool = false;
    int i = Integer.parseInt(arrayOfString[0]);
    int j = Integer.parseInt(paramAlbumFlow.feed_pics_height[0]);
    if (j != 0) {
      f = i / j;
    } else {
      f = 0.0F;
    } 
    if (f != 0.0F)
      this.c = (int)(this.b / f); 
    if (this.c > this.d)
      bool = true; 
    if (bool) {
      this.c = this.d;
      return bool;
    } 
    j = this.c;
    int k = this.e;
    i = j;
    if (j < k)
      i = k; 
    this.c = i;
    return bool;
  }
  
  public List<AlbumFlow> a() {
    return this.h;
  }
  
  protected void a(BaseViewHolder paramBaseViewHolder, AlbumFlow paramAlbumFlow) {
    if (paramBaseViewHolder != null) {
      this.a = (ImageView)paramBaseViewHolder.d(2131299687);
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramAlbumFlow.feed_dig);
      stringBuilder.append("");
      paramBaseViewHolder.a(2131300954, stringBuilder.toString());
      if (paramAlbumFlow.feed_dig == 0 || paramAlbumFlow.iliked == 0) {
        paramBaseViewHolder.c(2131297806, 2131232767);
        paramBaseViewHolder.f(2131300954, this.k.getResources().getColor(2131100528));
      } 
      if (paramAlbumFlow.iliked != 0) {
        paramBaseViewHolder.c(2131297806, 2131232547);
        paramBaseViewHolder.f(2131300954, this.k.getResources().getColor(2131100535));
      } 
      if (a(paramAlbumFlow)) {
        paramBaseViewHolder.c(2131301005, true);
      } else {
        paramBaseViewHolder.c(2131301005, false);
      } 
      if (TextUtils.isEmpty(paramAlbumFlow.score) || "0".equals(paramAlbumFlow.score)) {
        paramBaseViewHolder.c(2131301299, false);
      } else {
        paramBaseViewHolder.c(2131301299, true);
        paramBaseViewHolder.a(2131301299, paramAlbumFlow.score);
      } 
    } 
    paramBaseViewHolder.c(2131297806);
    ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(this.b, this.c);
    this.a.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
    ImageLoader.a(this.i, paramAlbumFlow.feed_pics[0]).a(2131100549).a(3.0F).a(this.a);
  }
  
  public void a(String paramString, int paramInt) {
    try {
      List<AlbumFlow> list = n();
      for (int i = 0; i < list.size(); i++) {
        if (((AlbumFlow)list.get(i)).feed_id.equals(paramString)) {
          ((AlbumFlow)list.get(i)).iliked = paramInt;
          if (paramInt == 1) {
            AlbumFlow albumFlow = list.get(i);
            albumFlow.feed_dig++;
          } else {
            AlbumFlow albumFlow = list.get(i);
            albumFlow.feed_dig--;
          } 
        } 
      } 
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
    notifyDataSetChanged();
  }
  
  public void a(Collection<? extends AlbumFlow> paramCollection) {
    paramCollection = new ArrayList<AlbumFlow>(paramCollection);
    this.h.clear();
    for (int i = 0; i < paramCollection.size(); i++) {
      if (!TextUtils.isEmpty(((AlbumFlow)paramCollection.get(i)).hash_id) && !this.f.contains(((AlbumFlow)paramCollection.get(i)).hash_id)) {
        this.f.add(((AlbumFlow)paramCollection.get(i)).hash_id);
        this.h.add(paramCollection.get(i));
        this.g.add(paramCollection.get(i));
      } 
    } 
    super.c(this.g);
  }
  
  public void c(List<AlbumFlow> paramList) {
    this.f.clear();
    this.g.clear();
    if (paramList != null) {
      for (int i = 0; i < paramList.size(); i++) {
        if (!TextUtils.isEmpty(((AlbumFlow)paramList.get(i)).hash_id) && !this.f.contains(((AlbumFlow)paramList.get(i)).hash_id)) {
          this.f.add(((AlbumFlow)paramList.get(i)).hash_id);
          this.g.add(paramList.get(i));
        } 
      } 
      super.c(this.g);
      return;
    } 
    super.c(paramList);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\u\\user\adapter\WaterfallPicturesAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */