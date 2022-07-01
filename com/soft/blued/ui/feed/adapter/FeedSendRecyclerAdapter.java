package com.soft.blued.ui.feed.adapter;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.AppInfo;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.imagecache.LoadOptions;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.utils.DensityUtils;
import com.soft.blued.db.NewFeedDao;
import com.soft.blued.db.model.NewFeedModel;
import com.soft.blued.ui.circle.fragment.CircleAddPostFragment;
import com.soft.blued.ui.circle.model.CircleMethods;
import com.soft.blued.ui.feed.fragment.FeedPostFragment;
import com.soft.blued.ui.feed.manager.FeedSendManager;
import com.soft.blued.ui.find.observer.FeedRefreshObserver;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.utils.StringUtils;

public class FeedSendRecyclerAdapter extends RecyclerView.Adapter<FeedSendRecyclerAdapter.ViewHolder> {
  private Context a;
  
  private IRequestHost b;
  
  private LoadOptions c;
  
  public FeedSendRecyclerAdapter(Context paramContext, IRequestHost paramIRequestHost) {
    this.a = paramContext;
    this.b = paramIRequestHost;
    this.c = new LoadOptions();
    LoadOptions loadOptions = this.c;
    loadOptions.j = true;
    loadOptions.a(AppInfo.l >> 1, AppInfo.l >> 1);
  }
  
  public ViewHolder a(ViewGroup paramViewGroup, int paramInt) {
    return new ViewHolder(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131493127, paramViewGroup, false));
  }
  
  public void a(NewFeedModel paramNewFeedModel) {
    if (paramNewFeedModel.getState() == 0) {
      if (CircleMethods.isCircle(paramNewFeedModel)) {
        CircleAddPostFragment.a(this.a, paramNewFeedModel);
        return;
      } 
      FeedPostFragment.b(this.a, paramNewFeedModel);
    } 
  }
  
  public void a(ViewHolder paramViewHolder, int paramInt) {
    NewFeedModel newFeedModel = FeedSendManager.a().d().get(paramInt);
    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams)paramViewHolder.B.getLayoutParams();
    if (paramInt == FeedSendManager.a().d().size() - 1) {
      layoutParams.leftMargin = 0;
    } else {
      layoutParams.leftMargin = DensityUtils.a(this.a, 13.0F);
    } 
    paramViewHolder.B.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
    if (newFeedModel.is_repost == 1) {
      paramViewHolder.q.setVisibility(0);
      paramViewHolder.t.setVisibility(8);
      ImageLoader.a(this.b, newFeedModel.forwardImage).a(paramViewHolder.r);
    } else if (!TextUtils.isEmpty(newFeedModel.getPics()) || newFeedModel.isVideo == 1) {
      paramViewHolder.q.setVisibility(0);
      paramViewHolder.t.setVisibility(8);
      ImageLoader.d(this.b, newFeedModel.localPath).a(paramViewHolder.r);
    } else {
      paramViewHolder.q.setVisibility(8);
      paramViewHolder.t.setVisibility(0);
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(StringUtils.a(newFeedModel.getContent(), false, true, false, ""));
      stringBuilder.append("");
      String str = stringBuilder.toString();
      paramViewHolder.t.setText(str);
    } 
    if (BluedPreferences.cZ()) {
      paramViewHolder.p.setCardBackgroundColor(Color.parseColor("#282828"));
      paramViewHolder.w.setProgressDrawable(this.a.getResources().getDrawable(2131233545));
    } else {
      paramViewHolder.p.setCardBackgroundColor(Color.parseColor("#ECEDF0"));
      paramViewHolder.w.setProgressDrawable(this.a.getResources().getDrawable(2131233544));
    } 
    paramInt = newFeedModel.getState();
    if (paramInt != 0) {
      if (paramInt != 1) {
        paramViewHolder.s.setVisibility(8);
        paramViewHolder.w.setVisibility(8);
        paramViewHolder.z.setVisibility(0);
        paramViewHolder.u.setText(this.a.getResources().getString(2131758685));
        paramViewHolder.v.setVisibility(0);
      } else {
        paramViewHolder.s.setVisibility(8);
        if (newFeedModel.isResend) {
          paramViewHolder.w.setVisibility(0);
        } else {
          paramViewHolder.w.setVisibility(8);
        } 
        paramViewHolder.z.setVisibility(8);
        paramViewHolder.u.setText(this.a.getResources().getString(2131758688));
        paramViewHolder.u.setTextColor(BluedSkinUtils.a(this.a, 2131100838));
        paramViewHolder.v.setVisibility(8);
      } 
    } else {
      paramViewHolder.w.setVisibility(8);
      paramViewHolder.z.setVisibility(0);
      paramViewHolder.u.setText(this.a.getResources().getString(2131758685));
      paramViewHolder.v.setVisibility(0);
      paramViewHolder.s.setVisibility(0);
    } 
    paramViewHolder.w.setProgress(newFeedModel.getProgress());
    paramViewHolder.x.setOnClickListener(new View.OnClickListener(this, newFeedModel) {
          public void onClick(View param1View) {
            FeedSendManager.a().b(this.a);
            this.b.notifyDataSetChanged();
          }
        });
    paramViewHolder.y.setOnClickListener(new View.OnClickListener(this, newFeedModel) {
          public void onClick(View param1View) {
            NewFeedDao.a().c(this.a);
            FeedSendManager.a().c(this.a);
            this.b.notifyDataSetChanged();
            FeedRefreshObserver.a().a(null, 4);
          }
        });
    paramViewHolder.u.setOnClickListener(new View.OnClickListener(this, newFeedModel) {
          public void onClick(View param1View) {
            this.b.a(this.a);
          }
        });
    paramViewHolder.A.setOnClickListener(new View.OnClickListener(this, newFeedModel) {
          public void onClick(View param1View) {
            this.b.a(this.a);
          }
        });
  }
  
  public int getItemCount() {
    return FeedSendManager.a().e();
  }
  
  public static class ViewHolder extends RecyclerView.ViewHolder {
    public LinearLayout A;
    
    public View B;
    
    public CardView p;
    
    public ViewGroup q;
    
    public ImageView r;
    
    public View s;
    
    public TextView t;
    
    public TextView u;
    
    public TextView v;
    
    public ProgressBar w;
    
    public View x;
    
    public View y;
    
    public LinearLayout z;
    
    public ViewHolder(View param1View) {
      super(param1View);
      this.p = (CardView)param1View.findViewById(2131297045);
      this.q = (ViewGroup)param1View.findViewById(2131297047);
      this.r = (ImageView)param1View.findViewById(2131297362);
      this.s = param1View.findViewById(2131297046);
      this.t = (TextView)param1View.findViewById(2131296838);
      this.u = (TextView)param1View.findViewById(2131299896);
      this.w = (ProgressBar)param1View.findViewById(2131299526);
      this.x = param1View.findViewById(2131299890);
      this.v = (TextView)param1View.findViewById(2131296425);
      this.y = param1View.findViewById(2131296911);
      this.z = (LinearLayout)param1View.findViewById(2131296597);
      this.A = (LinearLayout)param1View.findViewById(2131296835);
      this.B = param1View.findViewById(2131300589);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\feed\adapter\FeedSendRecyclerAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */