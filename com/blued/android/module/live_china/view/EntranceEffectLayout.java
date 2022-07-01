package com.blued.android.module.live_china.view;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.blued.android.chat.data.EntranceData;
import com.blued.android.chat.data.ProfileData;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.live_info.LiveRoomInfo;
import com.blued.android.module.live_china.manager.LiveRoomManager;
import com.blued.android.module.live_china.same.LiveBitmapUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class EntranceEffectLayout extends LinearLayout {
  private static int A = 400;
  
  private static int v = 500;
  
  private static int w = 2900;
  
  private static int x = 500;
  
  private static int y = 1200;
  
  private static float z = 150.0F;
  
  private View a;
  
  private View b;
  
  private Context c;
  
  private ImageView d;
  
  private ImageView e;
  
  private ImageView f;
  
  private ImageView g;
  
  private TextView h;
  
  private TextView i;
  
  private TextView j;
  
  private TextView k;
  
  private HalfCircle l;
  
  private LinearLayout m;
  
  private LinearLayout n;
  
  private ImageView o;
  
  private ImageView p;
  
  private ImageView q;
  
  private ImageView r;
  
  private ImageView s;
  
  private List<EntranceData> t;
  
  private boolean u;
  
  public EntranceEffectLayout(Context paramContext) {
    super(paramContext);
    this.c = paramContext;
    c();
  }
  
  public EntranceEffectLayout(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    this.c = paramContext;
    c();
  }
  
  public EntranceEffectLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    this.c = paramContext;
    c();
  }
  
  private Animator a(int paramInt) {
    paramInt -= this.r.getMeasuredWidth();
    new ObjectAnimator();
    ValueAnimator valueAnimator = ObjectAnimator.ofInt(new int[] { 0, paramInt });
    valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this, paramInt) {
          public void onAnimationUpdate(ValueAnimator param1ValueAnimator) {
            int i = ((Integer)param1ValueAnimator.getAnimatedValue()).intValue();
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams)EntranceEffectLayout.e(this.b).getLayoutParams();
            layoutParams.leftMargin = i;
            EntranceEffectLayout.e(this.b).setLayoutParams((ViewGroup.LayoutParams)layoutParams);
            if ((this.a - i) <= EntranceEffectLayout.b() && this.a - i >= 0) {
              EntranceEffectLayout.e(this.b).setAlpha((this.a - i) / EntranceEffectLayout.b());
              return;
            } 
            EntranceEffectLayout.e(this.b).setAlpha(1.0F);
          }
        });
    valueAnimator.setDuration(y);
    valueAnimator.setInterpolator((TimeInterpolator)new AccelerateDecelerateInterpolator());
    return (Animator)valueAnimator;
  }
  
  private AnimatorSet a(View paramView) {
    paramView.clearAnimation();
    new ObjectAnimator();
    ValueAnimator valueAnimator1 = ObjectAnimator.ofFloat(new float[] { 1.0F, 0.5F });
    valueAnimator1.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this, paramView) {
          public void onAnimationUpdate(ValueAnimator param1ValueAnimator) {
            float f = ((Float)param1ValueAnimator.getAnimatedValue()).floatValue();
            this.a.setScaleY(f);
            this.a.setScaleX(f);
            this.a.setAlpha(f);
          }
        });
    Random random = new Random();
    valueAnimator1.setDuration((random.nextInt(200) + 300));
    new ObjectAnimator();
    ValueAnimator valueAnimator2 = ObjectAnimator.ofFloat(new float[] { 0.5F, 1.0F });
    valueAnimator2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this, paramView) {
          public void onAnimationUpdate(ValueAnimator param1ValueAnimator) {
            float f = ((Float)param1ValueAnimator.getAnimatedValue()).floatValue();
            this.a.setScaleY(f);
            this.a.setScaleX(f);
            this.a.setAlpha(f);
          }
        });
    valueAnimator2.setDuration((random.nextInt(100) + 100));
    ArrayList<ValueAnimator> arrayList = new ArrayList();
    arrayList.add(valueAnimator1);
    arrayList.add(valueAnimator2);
    AnimatorSet animatorSet = new AnimatorSet();
    animatorSet.playSequentially(arrayList);
    return animatorSet;
  }
  
  private void b(EntranceData paramEntranceData) {
    if (paramEntranceData != null) {
      this.u = true;
      if (paramEntranceData.userData == null) {
        paramEntranceData.userData = new ProfileData();
        paramEntranceData.userData.name = LiveRoomInfo.a().c();
        paramEntranceData.userData.richLevel = LiveRoomInfo.a().q();
        if (LiveRoomManager.a().j() != null) {
          paramEntranceData.userData.liangType = (LiveRoomManager.a().j()).liang_type;
          paramEntranceData.userData.liangId = (LiveRoomManager.a().j()).liang_id;
        } 
      } else if (TextUtils.equals(LiveRoomInfo.a().f(), String.valueOf(paramEntranceData.userData.uid))) {
        paramEntranceData.userData.richLevel = LiveRoomInfo.a().q();
      } 
      this.i.setText(paramEntranceData.entranceContents);
      this.h.setText(paramEntranceData.userData.name);
      if (paramEntranceData.entranceColor != null && paramEntranceData.entranceColor.contains("#"))
        paramEntranceData.entranceColor = paramEntranceData.entranceColor.replace("#", ""); 
      LiveBitmapUtils.a(this.c, this.f, paramEntranceData.userData.richLevel);
      if (paramEntranceData.userData.liangType >= 2) {
        this.g.setVisibility(0);
      } else {
        this.g.setVisibility(8);
      } 
      if (paramEntranceData.userData.isLiveManager == true) {
        this.s.setVisibility(0);
      } else {
        this.s.setVisibility(8);
      } 
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("#FF");
      stringBuilder1.append(paramEntranceData.entranceColor);
      String str1 = stringBuilder1.toString();
      StringBuilder stringBuilder2 = new StringBuilder();
      stringBuilder2.append("#00");
      stringBuilder2.append(paramEntranceData.entranceColor);
      String str2 = stringBuilder2.toString();
      int[] arrayOfInt1 = a(str1, str2, 3, 8);
      GradientDrawable gradientDrawable1 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, arrayOfInt1);
      int[] arrayOfInt2 = a(str1, str2, 6, 7);
      GradientDrawable gradientDrawable2 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, arrayOfInt2);
      int[] arrayOfInt3 = a("#5F000000", "#00000000", 5, 6);
      GradientDrawable gradientDrawable3 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, arrayOfInt3);
      try {
        this.l.setColor(Color.parseColor(str1));
      } catch (Exception exception) {
        this.l.setColor(Color.parseColor("#FF000000"));
      } 
      this.m.setBackground((Drawable)gradientDrawable1);
      this.j.setBackground((Drawable)gradientDrawable2);
      this.k.setBackground((Drawable)gradientDrawable2);
      this.n.setBackground((Drawable)gradientDrawable3);
      if (TextUtils.isEmpty(paramEntranceData.entranceImage)) {
        this.e.setImageResource(R.drawable.entrance_sample);
        this.d.setImageResource(R.drawable.entrance_sample);
      } else {
        ImageLoader.a(null, paramEntranceData.entranceImage).a(this.e);
        ImageLoader.a(null, paramEntranceData.entranceImage).a(this.d);
      } 
      this.e.post(new Runnable(this, paramEntranceData) {
            public void run() {
              EntranceEffectLayout.a(this.b).measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
              EntranceEffectLayout.a(this.b).layout(0, 0, EntranceEffectLayout.a(this.b).getMeasuredWidth(), EntranceEffectLayout.a(this.b).getMeasuredHeight());
              EntranceEffectLayout entranceEffectLayout = this.b;
              entranceEffectLayout.a(EntranceEffectLayout.a(entranceEffectLayout).getMeasuredWidth(), this.a).start();
            }
          });
    } 
  }
  
  private void c() {
    this.a = LayoutInflater.from(this.c).inflate(R.layout.item_entrance_effect, (ViewGroup)this);
    this.b = this.a.findViewById(R.id.fl_main);
    this.b.setVisibility(4);
    this.s = (ImageView)this.b.findViewById(R.id.img_manager_icon);
    this.d = (ImageView)this.b.findViewById(R.id.img_effect_slot);
    this.e = (ImageView)this.b.findViewById(R.id.img_effect);
    this.h = (TextView)this.b.findViewById(R.id.tv_name);
    this.i = (TextView)this.b.findViewById(R.id.tv_content);
    this.j = (TextView)this.b.findViewById(R.id.tv_top_line);
    this.k = (TextView)this.b.findViewById(R.id.tv_btm_line);
    this.l = (HalfCircle)this.b.findViewById(R.id.left_half_circle);
    this.m = (LinearLayout)this.b.findViewById(R.id.ll_content);
    this.n = (LinearLayout)this.b.findViewById(R.id.ll_top_layer);
    this.o = (ImageView)this.b.findViewById(R.id.star_first);
    this.p = (ImageView)this.b.findViewById(R.id.star_second);
    this.q = (ImageView)this.b.findViewById(R.id.star_third);
    this.r = (ImageView)this.b.findViewById(R.id.img_light);
    this.f = (ImageView)this.b.findViewById(R.id.img_rich_rank);
    this.g = (ImageView)this.b.findViewById(R.id.iv_liang);
    this.t = new ArrayList<EntranceData>();
  }
  
  private AnimatorSet getStarsAnims() {
    AnimatorSet animatorSet1 = a((View)this.o);
    AnimatorSet animatorSet2 = a((View)this.p);
    AnimatorSet animatorSet3 = a((View)this.q);
    AnimatorSet animatorSet4 = new AnimatorSet();
    animatorSet4.playTogether(new Animator[] { (Animator)animatorSet1, (Animator)animatorSet2, (Animator)animatorSet3 });
    return animatorSet4;
  }
  
  public AnimatorSet a(float paramFloat, EntranceData paramEntranceData) {
    this.b.setVisibility(0);
    new ObjectAnimator();
    ValueAnimator valueAnimator1 = ObjectAnimator.ofFloat(new float[] { (this.c.getResources().getDisplayMetrics()).widthPixels, DensityUtils.a(this.c, 20.0F) });
    valueAnimator1.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) {
          public void onAnimationUpdate(ValueAnimator param1ValueAnimator) {
            float f = ((Float)param1ValueAnimator.getAnimatedValue()).floatValue();
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams)EntranceEffectLayout.a(this.a).getLayoutParams();
            layoutParams.leftMargin = (int)f;
            EntranceEffectLayout.a(this.a).setLayoutParams((ViewGroup.LayoutParams)layoutParams);
          }
        });
    valueAnimator1.setDuration(v);
    new ObjectAnimator();
    ValueAnimator valueAnimator2 = ObjectAnimator.ofFloat(new float[] { DensityUtils.a(this.c, 20.0F), DensityUtils.a(this.c, 5.0F) });
    valueAnimator2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) {
          public void onAnimationUpdate(ValueAnimator param1ValueAnimator) {
            float f = ((Float)param1ValueAnimator.getAnimatedValue()).floatValue();
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams)EntranceEffectLayout.a(this.a).getLayoutParams();
            layoutParams.leftMargin = (int)f;
            EntranceEffectLayout.a(this.a).setLayoutParams((ViewGroup.LayoutParams)layoutParams);
          }
        });
    valueAnimator2.addListener(new Animator.AnimatorListener(this) {
          public void onAnimationCancel(Animator param1Animator) {}
          
          public void onAnimationEnd(Animator param1Animator) {}
          
          public void onAnimationRepeat(Animator param1Animator) {}
          
          public void onAnimationStart(Animator param1Animator) {
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playSequentially(new Animator[] { (Animator)EntranceEffectLayout.b(this.a), (Animator)EntranceEffectLayout.b(this.a), (Animator)EntranceEffectLayout.b(this.a), (Animator)EntranceEffectLayout.b(this.a), (Animator)EntranceEffectLayout.b(this.a), (Animator)EntranceEffectLayout.b(this.a) });
            animatorSet.start();
            animatorSet = new AnimatorSet();
            EntranceEffectLayout entranceEffectLayout1 = this.a;
            Animator animator = EntranceEffectLayout.a(entranceEffectLayout1, EntranceEffectLayout.c(entranceEffectLayout1).getMeasuredWidth());
            animator.setStartDelay(EntranceEffectLayout.a());
            EntranceEffectLayout entranceEffectLayout2 = this.a;
            animatorSet.playSequentially(new Animator[] { EntranceEffectLayout.a(entranceEffectLayout2, EntranceEffectLayout.c(entranceEffectLayout2).getMeasuredWidth()), animator });
            animatorSet.start();
          }
        });
    valueAnimator2.setDuration(w);
    new ObjectAnimator();
    ValueAnimator valueAnimator3 = ObjectAnimator.ofFloat(new float[] { DensityUtils.a(this.c, 5.0F), -paramFloat });
    valueAnimator3.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) {
          public void onAnimationUpdate(ValueAnimator param1ValueAnimator) {
            float f = ((Float)param1ValueAnimator.getAnimatedValue()).floatValue();
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams)EntranceEffectLayout.a(this.a).getLayoutParams();
            layoutParams.leftMargin = (int)f;
            EntranceEffectLayout.a(this.a).setLayoutParams((ViewGroup.LayoutParams)layoutParams);
          }
        });
    valueAnimator3.setDuration(x);
    ArrayList<ValueAnimator> arrayList = new ArrayList();
    arrayList.add(valueAnimator1);
    arrayList.add(valueAnimator2);
    arrayList.add(valueAnimator3);
    AnimatorSet animatorSet = new AnimatorSet();
    animatorSet.playSequentially(arrayList);
    this.b.postDelayed(new Runnable(this, paramEntranceData) {
          public void run() {
            EntranceEffectLayout.a(this.b, false);
            EntranceEffectLayout.a(this.b).setVisibility(8);
            if (EntranceEffectLayout.d(this.b).size() > 0)
              EntranceEffectLayout.d(this.b).remove(this.a); 
            if (EntranceEffectLayout.d(this.b).size() > 0) {
              EntranceEffectLayout entranceEffectLayout = this.b;
              EntranceEffectLayout.a(entranceEffectLayout, EntranceEffectLayout.d(entranceEffectLayout).get(0));
            } 
          }
        }(v + w + x));
    return animatorSet;
  }
  
  public void a(EntranceData paramEntranceData) {
    // Byte code:
    //   0: aload_1
    //   1: ifnull -> 112
    //   4: aload_1
    //   5: getfield userData : Lcom/blued/android/chat/data/ProfileData;
    //   8: ifnull -> 71
    //   11: invokestatic a : ()Lcom/blued/android/module/live_china/live_info/LiveRoomInfo;
    //   14: invokevirtual f : ()Ljava/lang/String;
    //   17: astore_2
    //   18: new java/lang/StringBuilder
    //   21: dup
    //   22: invokespecial <init> : ()V
    //   25: astore_3
    //   26: aload_3
    //   27: aload_1
    //   28: getfield userData : Lcom/blued/android/chat/data/ProfileData;
    //   31: getfield uid : J
    //   34: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   37: pop
    //   38: aload_3
    //   39: ldc_w ''
    //   42: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: pop
    //   46: aload_2
    //   47: aload_3
    //   48: invokevirtual toString : ()Ljava/lang/String;
    //   51: invokestatic equals : (Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   54: ifeq -> 71
    //   57: aload_0
    //   58: getfield t : Ljava/util/List;
    //   61: iconst_0
    //   62: aload_1
    //   63: invokeinterface add : (ILjava/lang/Object;)V
    //   68: goto -> 82
    //   71: aload_0
    //   72: getfield t : Ljava/util/List;
    //   75: aload_1
    //   76: invokeinterface add : (Ljava/lang/Object;)Z
    //   81: pop
    //   82: aload_0
    //   83: getfield t : Ljava/util/List;
    //   86: invokeinterface size : ()I
    //   91: iconst_1
    //   92: if_icmpne -> 112
    //   95: aload_0
    //   96: aload_0
    //   97: getfield t : Ljava/util/List;
    //   100: iconst_0
    //   101: invokeinterface get : (I)Ljava/lang/Object;
    //   106: checkcast com/blued/android/chat/data/EntranceData
    //   109: invokespecial b : (Lcom/blued/android/chat/data/EntranceData;)V
    //   112: return
  }
  
  public int[] a(String paramString1, String paramString2, int paramInt1, int paramInt2) {
    int[] arrayOfInt = new int[paramInt2];
    paramInt2 = 0;
    while (true) {
      if (paramInt2 < arrayOfInt.length) {
        if (paramInt2 <= paramInt1 - 1) {
          try {
            arrayOfInt[paramInt2] = Color.parseColor(paramString1);
          } catch (Exception exception) {
            arrayOfInt[paramInt2] = Color.parseColor("#FF000000");
          } 
        } else {
          try {
            arrayOfInt[paramInt2] = Color.parseColor(paramString2);
          } catch (Exception exception) {
            arrayOfInt[paramInt2] = Color.parseColor("#00000000");
          } 
        } 
        paramInt2++;
        continue;
      } 
      return arrayOfInt;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\view\EntranceEffectLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */