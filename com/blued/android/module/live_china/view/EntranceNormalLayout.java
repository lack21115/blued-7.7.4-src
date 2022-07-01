package com.blued.android.module.live_china.view;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.blued.android.chat.model.ChattingModel;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.live_info.LiveRoomInfo;
import com.blued.android.module.live_china.same.LiveBitmapUtils;
import java.util.ArrayList;
import java.util.List;

public class EntranceNormalLayout extends LinearLayout {
  public View a;
  
  public Context b;
  
  private View c;
  
  private ImageView d;
  
  private ImageView e;
  
  private TextView f;
  
  private TextView g;
  
  private int h = 300;
  
  private int i = 300;
  
  private List<ChattingModel> j;
  
  private int k = 1500;
  
  private int l = 500;
  
  private int m = 100;
  
  public EntranceNormalLayout(Context paramContext) {
    super(paramContext);
    this.b = paramContext;
    b();
  }
  
  public EntranceNormalLayout(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    this.b = paramContext;
    b();
  }
  
  public EntranceNormalLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    this.b = paramContext;
    b();
  }
  
  private void a(ChattingModel paramChattingModel) {
    if (paramChattingModel != null) {
      if (TextUtils.equals(LiveRoomInfo.a().f(), String.valueOf(paramChattingModel.fromId)))
        paramChattingModel.fromRichLevel = LiveRoomInfo.a().q(); 
      if (TextUtils.isEmpty(paramChattingModel.msgContent))
        paramChattingModel.msgContent = this.b.getResources().getString(R.string.live_coming); 
      this.g.setText(paramChattingModel.msgContent);
      this.f.setText(paramChattingModel.fromNickName);
      if (paramChattingModel.fromLiveManager == 1) {
        this.e.setVisibility(0);
      } else {
        this.e.setVisibility(8);
      } 
      LiveBitmapUtils.a(this.b, this.d, paramChattingModel.fromRichLevel);
      this.c.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
      View view = this.c;
      view.layout(0, 0, view.getMeasuredWidth(), this.c.getMeasuredHeight());
      a(this.c.getMeasuredWidth(), paramChattingModel).start();
    } 
  }
  
  private void b() {
    a();
    this.c = this.a.findViewById(R.id.fl_main);
    this.c.setVisibility(4);
    this.f = (TextView)this.c.findViewById(R.id.tv_name);
    this.g = (TextView)this.c.findViewById(R.id.tv_content);
    this.d = (ImageView)this.c.findViewById(R.id.img_rich_rank);
    this.e = (ImageView)this.c.findViewById(R.id.img_manager_icon);
    this.j = new ArrayList<ChattingModel>();
  }
  
  public AnimatorSet a(float paramFloat, ChattingModel paramChattingModel) {
    int i;
    ValueAnimator valueAnimator1;
    this.c.setVisibility(0);
    new ObjectAnimator();
    paramFloat = -paramFloat;
    ValueAnimator valueAnimator2 = ObjectAnimator.ofFloat(new float[] { paramFloat, 0.0F });
    valueAnimator2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) {
          public void onAnimationUpdate(ValueAnimator param1ValueAnimator) {
            float f = ((Float)param1ValueAnimator.getAnimatedValue()).floatValue();
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams)EntranceNormalLayout.a(this.a).getLayoutParams();
            layoutParams.leftMargin = (int)f;
            EntranceNormalLayout.a(this.a).setAlpha(1.0F);
            EntranceNormalLayout.a(this.a).setLayoutParams((ViewGroup.LayoutParams)layoutParams);
          }
        });
    valueAnimator2.setDuration(this.h);
    new ObjectAnimator();
    ValueAnimator valueAnimator3 = ObjectAnimator.ofFloat(new float[] { 0.0F, -0.1F });
    valueAnimator3.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) {
          public void onAnimationUpdate(ValueAnimator param1ValueAnimator) {
            float f = ((Float)param1ValueAnimator.getAnimatedValue()).floatValue();
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams)EntranceNormalLayout.a(this.a).getLayoutParams();
            layoutParams.leftMargin = (int)f;
            EntranceNormalLayout.a(this.a).setAlpha(1.0F);
            EntranceNormalLayout.a(this.a).setLayoutParams((ViewGroup.LayoutParams)layoutParams);
          }
        });
    List<ChattingModel> list = this.j;
    if (list != null && list.size() >= 10) {
      i = this.l;
    } else {
      i = this.k;
    } 
    valueAnimator3.setDuration(i);
    if (Build.VERSION.SDK_INT < 11) {
      new ObjectAnimator();
      valueAnimator1 = ObjectAnimator.ofFloat(new float[] { 0.0F, paramFloat });
      valueAnimator1.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) {
            public void onAnimationUpdate(ValueAnimator param1ValueAnimator) {
              float f = ((Float)param1ValueAnimator.getAnimatedValue()).floatValue();
              LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams)EntranceNormalLayout.a(this.a).getLayoutParams();
              layoutParams.leftMargin = (int)f;
              EntranceNormalLayout.a(this.a).setLayoutParams((ViewGroup.LayoutParams)layoutParams);
            }
          });
    } else {
      new ObjectAnimator();
      valueAnimator1 = ObjectAnimator.ofFloat(new float[] { 1.0F, 0.0F });
      valueAnimator1.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) {
            public void onAnimationUpdate(ValueAnimator param1ValueAnimator) {
              float f = ((Float)param1ValueAnimator.getAnimatedValue()).floatValue();
              EntranceNormalLayout.a(this.a).setAlpha(f);
            }
          });
    } 
    valueAnimator1.setDuration(this.i);
    ArrayList<ValueAnimator> arrayList = new ArrayList();
    arrayList.add(valueAnimator2);
    arrayList.add(valueAnimator3);
    arrayList.add(valueAnimator1);
    AnimatorSet animatorSet = new AnimatorSet();
    animatorSet.playSequentially(arrayList);
    this.c.postDelayed(new Runnable(this, paramChattingModel) {
          public void run() {
            if (EntranceNormalLayout.b(this.b).size() > 0)
              EntranceNormalLayout.b(this.b).remove(this.a); 
            if (EntranceNormalLayout.b(this.b).size() > 0) {
              EntranceNormalLayout entranceNormalLayout = this.b;
              EntranceNormalLayout.a(entranceNormalLayout, EntranceNormalLayout.b(entranceNormalLayout).get(0));
            } 
          }
        }(this.h + i + this.i));
    return animatorSet;
  }
  
  public void a() {
    this.a = LayoutInflater.from(this.b).inflate(R.layout.item_entrance_normal, (ViewGroup)this);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\view\EntranceNormalLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */