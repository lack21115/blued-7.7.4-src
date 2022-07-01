package com.soft.blued.ui.share_custom.Adapter;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.CycleInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.AppInfo;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.module_share_china.R;
import com.soft.blued.ui.share_custom.Model.ShareOption;
import java.util.List;

public class ShareOptionRecyclerAdapter extends RecyclerView.Adapter<ShareOptionRecyclerAdapter.ViewHolder> {
  private LayoutInflater a;
  
  private List<ShareOption> b;
  
  private Context c;
  
  private ShareOptionsItemClickListener d;
  
  private boolean e = false;
  
  public ShareOptionRecyclerAdapter(Context paramContext, List<ShareOption> paramList, boolean paramBoolean) {
    this.c = paramContext;
    this.e = paramBoolean;
    this.b = paramList;
    this.a = LayoutInflater.from(paramContext);
  }
  
  public ViewHolder a(ViewGroup paramViewGroup, int paramInt) {
    View view = this.a.inflate(R.layout.item_share_option, paramViewGroup, false);
    ((LinearLayout)view.findViewById(R.id.ll_main)).setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            int i = ((Integer)param1View.getTag()).intValue();
            if (ShareOptionRecyclerAdapter.a(this.a) != null)
              ShareOptionRecyclerAdapter.a(this.a).onItemClick(i); 
          }
        });
    return new ViewHolder(this, view);
  }
  
  public void a(int paramInt) {
    for (int i = 0; i < this.b.size(); i++) {
      if (((ShareOption)this.b.get(i)).textResourceID == paramInt) {
        this.b.remove(i);
        break;
      } 
    } 
    notifyDataSetChanged();
  }
  
  public void a(View paramView, int paramInt) {
    AppInfo.n().postDelayed(new Runnable(this, paramView) {
          public void run() {
            ValueAnimator valueAnimator = ValueAnimator.ofInt(new int[] { 0, DensityUtils.a(ShareOptionRecyclerAdapter.b(this.b), 15.0F) });
            valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) {
                  public void onAnimationUpdate(ValueAnimator param2ValueAnimator) {
                    int i = -((Integer)param2ValueAnimator.getAnimatedValue()).intValue();
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams)this.a.a.getLayoutParams();
                    layoutParams.topMargin = i;
                    this.a.a.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
                  }
                });
            valueAnimator.setInterpolator((TimeInterpolator)new CycleInterpolator(0.5F));
            valueAnimator.setDuration(350L);
            valueAnimator.start();
          }
        }(paramInt * 30 + 200));
  }
  
  public void a(ShareOptionsItemClickListener paramShareOptionsItemClickListener) {
    this.d = paramShareOptionsItemClickListener;
  }
  
  public void a(ViewHolder paramViewHolder, int paramInt) {
    if (paramViewHolder != null) {
      ShareOption shareOption = this.b.get(paramInt);
      paramViewHolder.p.setImageResource(shareOption.iconResourceId);
      if (paramViewHolder.q != null) {
        paramViewHolder.q.setText(shareOption.textResourceID);
        paramViewHolder.r.setTag(Integer.valueOf(shareOption.textResourceID));
        if (this.e)
          paramViewHolder.q.setTextColor(this.c.getResources().getColor(R.color.syc_j)); 
      } 
      a((View)paramViewHolder.s, paramInt);
    } 
  }
  
  public int getItemCount() {
    return this.b.size();
  }
  
  public static interface ShareOptionsItemClickListener {
    void onItemClick(int param1Int);
  }
  
  public class ViewHolder extends RecyclerView.ViewHolder {
    public ImageView p;
    
    public TextView q;
    
    public LinearLayout r;
    
    public FrameLayout s;
    
    public ViewHolder(ShareOptionRecyclerAdapter this$0, View param1View) {
      super(param1View);
      this.p = (ImageView)param1View.findViewById(R.id.img_icon);
      this.q = (TextView)param1View.findViewById(R.id.tv_text);
      this.r = (LinearLayout)param1View.findViewById(R.id.ll_main);
      this.s = (FrameLayout)param1View.findViewById(R.id.ll_anim);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\share_custom\Adapter\ShareOptionRecyclerAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */