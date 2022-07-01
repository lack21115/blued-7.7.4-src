package com.blued.android.module.live_china.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.blued.android.chat.model.ChattingModel;
import com.blued.android.chat.utils.MsgPackHelper;
import com.blued.android.core.AppInfo;
import com.blued.android.core.image.ImageFileLoader;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.live_info.LiveRoomInfo;
import com.blued.android.module.live_china.manager.LiveFloatManager;
import com.blued.android.module.live_china.observer.LiveSetDataObserver;
import com.blued.android.module.live_china.same.LiveBitmapUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BarrageViewMultiOneRow extends View {
  public int a = 3;
  
  private BubblesRow b = new BubblesRow();
  
  private BubblesRow c = new BubblesRow();
  
  private BubblesRow d = new BubblesRow();
  
  private Context e;
  
  private Paint f = new Paint();
  
  private LayoutInflater g;
  
  private Float[] h = new Float[] { Float.valueOf(0.0F), Float.valueOf(27.5F), Float.valueOf(55.0F) };
  
  private PopUserCard i;
  
  private int j = 0;
  
  private View k;
  
  private View l;
  
  private View m;
  
  private View n;
  
  private View o;
  
  private View p;
  
  private View q;
  
  private View r;
  
  private Bitmap s;
  
  private final int t = 130;
  
  private final float u = 2.5F;
  
  private float v;
  
  private float w;
  
  private int x = 2;
  
  private boolean y = false;
  
  public BarrageViewMultiOneRow(Context paramContext) {
    super(paramContext);
    this.e = paramContext;
    a();
  }
  
  public BarrageViewMultiOneRow(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    this.e = paramContext;
    a();
  }
  
  public BarrageViewMultiOneRow(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    this.e = paramContext;
    a();
  }
  
  private Bubble a(int paramInt1, int paramInt2) {
    Bubble bubble2 = this.b.a(paramInt1, paramInt2);
    Bubble bubble1 = bubble2;
    if (bubble2 == null)
      bubble1 = this.c.a(paramInt1, paramInt2); 
    bubble2 = bubble1;
    if (bubble1 == null)
      bubble2 = this.d.a(paramInt1, paramInt2); 
    return bubble2;
  }
  
  private void a() {
    DisplayMetrics displayMetrics = new DisplayMetrics();
    ((Activity)this.e).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
    this.v = 0.0F;
    this.w = displayMetrics.widthPixels;
    this.f.reset();
    this.f.setAntiAlias(true);
    this.f.setFilterBitmap(true);
    this.f.setColor(this.e.getResources().getColor(R.color.transparent));
    this.f.setAlpha(255);
    this.g = LayoutInflater.from(this.e);
    this.k = this.g.inflate(R.layout.item_barrage, null);
    this.l = this.g.inflate(R.layout.item_barrage_msg_multi, null);
    this.n = this.g.inflate(R.layout.item_barrage_gift_multi, null);
    this.m = this.g.inflate(R.layout.item_barrage_normal_entrance_multi, null);
    this.o = this.g.inflate(R.layout.item_barrage_multi_obtain_gift, null);
    this.p = this.g.inflate(R.layout.item_barrage_chat_remind_multi, null);
    this.q = this.g.inflate(R.layout.item_barrage_attention_remind_multi, null);
    this.r = this.g.inflate(R.layout.item_live_msg_content_level, null);
    this.k.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
    View view = this.k;
    view.layout(0, 0, view.getMeasuredWidth(), this.k.getMeasuredHeight());
    this.j = this.k.getHeight();
    setOnTouchListener(new View.OnTouchListener(this) {
          public boolean onTouch(View param1View, MotionEvent param1MotionEvent) {
            if (BarrageViewMultiOneRow.a(this.a) != null) {
              BarrageViewMultiOneRow.Bubble bubble = BarrageViewMultiOneRow.a(this.a, (int)param1MotionEvent.getX(), (int)param1MotionEvent.getY());
              if (bubble != null)
                if (bubble.b == 6) {
                  LiveSetDataObserver.a().k();
                } else if (bubble.b == 5) {
                  LiveSetDataObserver.a().i();
                } else if (!TextUtils.isEmpty(bubble.c)) {
                  BarrageViewMultiOneRow.a(this.a).e(bubble.c);
                }  
            } 
            return false;
          }
        });
    this.b.d = DensityUtils.a(this.e, this.h[0].floatValue());
    this.c.d = DensityUtils.a(this.e, this.h[1].floatValue());
    this.d.d = DensityUtils.a(this.e, this.h[2].floatValue());
  }
  
  protected void a(ChattingModel paramChattingModel) {
    if (paramChattingModel != null && !TextUtils.isEmpty(MsgPackHelper.getStringValue(paramChattingModel.msgMapExtra, "image"))) {
      String str = MsgPackHelper.getStringValue(paramChattingModel.msgMapExtra, "image");
      ImageFileLoader.a(null).a(str).a(new ImageFileLoader.OnLoadFileListener(this, paramChattingModel) {
            public void onUIFinish(File param1File, Exception param1Exception) {
              this.b.a(this.a, 3);
            }
          }).a();
    } 
  }
  
  protected void a(ChattingModel paramChattingModel, int paramInt) {
    if (!this.y) {
      this.y = true;
      this.v = getX();
      this.w = getX() + getWidth();
    } 
    Bubble bubble = new Bubble();
    switch (paramInt) {
      case 7:
        bubble.k = this.r;
        break;
      case 6:
        bubble.k = this.q;
        break;
      case 5:
        bubble.k = this.p;
        break;
      case 4:
        bubble.k = this.m;
        break;
      case 3:
        bubble.k = this.o;
        break;
      case 2:
        bubble.k = this.k;
        break;
      case 1:
        bubble.k = this.l;
        break;
      case 0:
        bubble.k = this.n;
        break;
    } 
    bubble.b = paramInt;
    bubble.a(this.w);
    bubble.a = paramChattingModel;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramChattingModel.fromId);
    stringBuilder.append("");
    bubble.c = stringBuilder.toString();
    bubble.d = paramChattingModel.fromAvatar;
    bubble.e = paramChattingModel.fromNickName;
    bubble.f = paramChattingModel.msgContent;
    if (LiveFloatManager.a().w())
      bubble.i = 1; 
    if (bubble.c.equals(LiveRoomInfo.a().f())) {
      bubble.h = LiveRoomInfo.a().q();
    } else {
      bubble.h = paramChattingModel.fromRichLevel;
    } 
    bubble.g = paramChattingModel.getMsgExtra();
    bubble.l = null;
    stringBuilder = new StringBuilder();
    stringBuilder.append(paramChattingModel.fromId);
    stringBuilder.append("");
    if (stringBuilder.toString().equals(LiveRoomInfo.a().f()))
      bubble.j = true; 
    bubble.b(-DensityUtils.a(this.e, 2.5F));
    post(new Runnable(this, bubble) {
          public void run() {
            int i;
            if (this.b.getEmptyRow() + this.b.getSlotRow() > -2) {
              this.b.a(this.a);
              this.b.invalidate();
              return;
            } 
            BarrageViewMultiOneRow.b(this.b);
            BarrageViewMultiOneRow barrageViewMultiOneRow = this.b;
            if (BarrageViewMultiOneRow.c(barrageViewMultiOneRow) < 0) {
              i = 2;
            } else {
              i = BarrageViewMultiOneRow.c(this.b);
            } 
            BarrageViewMultiOneRow.a(barrageViewMultiOneRow, i);
            if (this.a.j) {
              i = BarrageViewMultiOneRow.c(this.b);
              if (i != 0) {
                if (i != 1) {
                  if (i != 2)
                    return; 
                  (BarrageViewMultiOneRow.f(this.b)).b.add(0, this.a);
                  return;
                } 
                (BarrageViewMultiOneRow.e(this.b)).b.add(0, this.a);
                return;
              } 
              (BarrageViewMultiOneRow.d(this.b)).b.add(0, this.a);
              return;
            } 
            if (BarrageViewMultiOneRow.d(this.b).a() + BarrageViewMultiOneRow.e(this.b).a() + BarrageViewMultiOneRow.f(this.b).a() < 130) {
              i = BarrageViewMultiOneRow.c(this.b);
              if (i != 0) {
                if (i != 1) {
                  if (i != 2)
                    return; 
                  (BarrageViewMultiOneRow.f(this.b)).b.add(this.a);
                  return;
                } 
                (BarrageViewMultiOneRow.e(this.b)).b.add(this.a);
                return;
              } 
              (BarrageViewMultiOneRow.d(this.b)).b.add(this.a);
            } 
          }
        });
  }
  
  protected void a(Bubble paramBubble) {
    int i = getEmptyRow();
    if (i < 0) {
      i = getSlotRow();
      if (i != 0) {
        if (i != 1) {
          if (i != 2)
            return; 
          this.d.b.add(paramBubble);
          return;
        } 
        this.c.b.add(paramBubble);
        return;
      } 
      this.b.b.add(paramBubble);
      return;
    } 
    if (i != 0) {
      if (i != 1) {
        if (i != 2)
          return; 
        this.d.a.add(paramBubble);
        return;
      } 
      this.c.a.add(paramBubble);
      return;
    } 
    this.b.a.add(paramBubble);
  }
  
  protected void a(BubblesRow paramBubblesRow, Canvas paramCanvas) {
    if (paramBubblesRow.a.size() > 0) {
      Iterator<Bubble> iterator = paramBubblesRow.a.iterator();
      while (iterator.hasNext()) {
        Bubble bubble = iterator.next();
        if (bubble == null)
          continue; 
        Bitmap bitmap = bubble.a();
        if (bubble.b() + bubble.l.getWidth() <= this.v) {
          iterator.remove();
        } else if (bubble.b() + bubble.c() + bubble.l.getWidth() - this.w < 0.0F && bubble.b() + bubble.l.getWidth() - this.w > 0.0F) {
          paramBubblesRow.c = true;
          bubble.a(bubble.b() + bubble.c());
        } else {
          if (bubble.b() + bitmap.getWidth() > this.w) {
            paramBubblesRow.c = false;
          } else {
            paramBubblesRow.c = true;
          } 
          bubble.a(bubble.b() + bubble.c());
        } 
        paramCanvas.drawBitmap(bubble.a(), bubble.b(), paramBubblesRow.d, this.f);
      } 
      if (paramBubblesRow.b.size() > 0 && paramBubblesRow.c) {
        Bubble bubble = paramBubblesRow.b.get(0);
        paramBubblesRow.a.add(bubble);
        paramBubblesRow.b.remove(0);
      } 
    } 
  }
  
  public void b(ChattingModel paramChattingModel) {
    // Byte code:
    //   0: aload_1
    //   1: getfield msgType : S
    //   4: istore_2
    //   5: iload_2
    //   6: iconst_1
    //   7: if_icmpeq -> 148
    //   10: iload_2
    //   11: bipush #27
    //   13: if_icmpeq -> 141
    //   16: iload_2
    //   17: bipush #33
    //   19: if_icmpeq -> 154
    //   22: iload_2
    //   23: bipush #37
    //   25: if_icmpeq -> 134
    //   28: iload_2
    //   29: bipush #61
    //   31: if_icmpeq -> 128
    //   34: iload_2
    //   35: bipush #49
    //   37: if_icmpeq -> 141
    //   40: iload_2
    //   41: bipush #50
    //   43: if_icmpeq -> 141
    //   46: iload_2
    //   47: tableswitch default -> 72, 102 -> 120, 103 -> 112, 104 -> 105
    //   72: iload_2
    //   73: tableswitch default -> 104, 106 -> 148, 107 -> 148, 108 -> 148, 109 -> 148
    //   104: return
    //   105: aload_0
    //   106: aload_1
    //   107: iconst_5
    //   108: invokevirtual a : (Lcom/blued/android/chat/model/ChattingModel;I)V
    //   111: return
    //   112: aload_0
    //   113: aload_1
    //   114: bipush #6
    //   116: invokevirtual a : (Lcom/blued/android/chat/model/ChattingModel;I)V
    //   119: return
    //   120: aload_0
    //   121: aload_1
    //   122: bipush #7
    //   124: invokevirtual a : (Lcom/blued/android/chat/model/ChattingModel;I)V
    //   127: return
    //   128: aload_0
    //   129: aload_1
    //   130: invokevirtual a : (Lcom/blued/android/chat/model/ChattingModel;)V
    //   133: return
    //   134: aload_0
    //   135: aload_1
    //   136: iconst_2
    //   137: invokevirtual a : (Lcom/blued/android/chat/model/ChattingModel;I)V
    //   140: return
    //   141: aload_0
    //   142: aload_1
    //   143: iconst_4
    //   144: invokevirtual a : (Lcom/blued/android/chat/model/ChattingModel;I)V
    //   147: return
    //   148: aload_0
    //   149: aload_1
    //   150: iconst_1
    //   151: invokevirtual a : (Lcom/blued/android/chat/model/ChattingModel;I)V
    //   154: return
  }
  
  protected int getEmptyRow() {
    return (this.d.a.size() == 0) ? 2 : ((this.c.a.size() == 0) ? 1 : ((this.b.a.size() == 0) ? 0 : -1));
  }
  
  protected int getSlotRow() {
    return this.d.c ? 2 : (this.c.c ? 1 : (this.b.c ? 0 : -1));
  }
  
  protected void onDraw(Canvas paramCanvas) {
    super.onDraw(paramCanvas);
    a(this.d, paramCanvas);
    a(this.c, paramCanvas);
    a(this.b, paramCanvas);
    invalidate();
  }
  
  public void setUserCard(PopUserCard paramPopUserCard) {
    this.i = paramPopUserCard;
  }
  
  static interface BARRAGE_TYPE {}
  
  class Bubble {
    public ChattingModel a;
    
    public int b;
    
    public String c = "";
    
    public String d = "";
    
    public String e = "";
    
    public String f = "";
    
    public String g = "";
    
    public int h;
    
    public int i = 0;
    
    public boolean j = false;
    
    public View k;
    
    public Bitmap l;
    
    private float n;
    
    private float o;
    
    private Bubble(BarrageViewMultiOneRow this$0) {}
    
    private void d() {
      LinearLayout linearLayout = (LinearLayout)this.k.findViewById(R.id.ll_content);
      TextView textView1 = (TextView)this.k.findViewById(R.id.tv_name);
      TextView textView2 = (TextView)this.k.findViewById(R.id.tv_content);
      ImageView imageView1 = (ImageView)this.k.findViewById(R.id.img_rich_rank);
      ImageView imageView2 = (ImageView)this.k.findViewById(R.id.img_manager_icon);
      ImageView imageView3 = (ImageView)this.k.findViewById(R.id.img_star_invisible);
      ImageView imageView4 = (ImageView)this.k.findViewById(R.id.img_star);
      if (this.i == 1) {
        imageView2.setVisibility(0);
      } else {
        imageView2.setVisibility(8);
      } 
      LiveBitmapUtils.a(BarrageViewMultiOneRow.g(this.m), imageView1, this.h);
      textView1.setText(this.e);
      textView2.setText(this.f);
      BarrageView.a(BarrageViewMultiOneRow.g(this.m), (View)linearLayout, this.h, this.j);
      if (this.h >= 30) {
        imageView3.setVisibility(4);
        imageView4.setVisibility(0);
        return;
      } 
      imageView3.setVisibility(8);
      imageView4.setVisibility(8);
    }
    
    private void e() {
      TextView textView1 = (TextView)this.k.findViewById(R.id.tv_content);
      TextView textView2 = (TextView)this.k.findViewById(R.id.tv_content_shadow);
      ImageView imageView1 = (ImageView)this.k.findViewById(R.id.img_rich_rank);
      ImageView imageView2 = (ImageView)this.k.findViewById(R.id.img_manager_icon);
      if (this.i == 1) {
        imageView2.setVisibility(0);
      } else {
        imageView2.setVisibility(8);
      } 
      LiveBitmapUtils.a(BarrageViewMultiOneRow.g(this.m), imageView1, this.h);
      StringBuilder stringBuilder2 = new StringBuilder();
      stringBuilder2.append(this.e);
      stringBuilder2.append(": ");
      stringBuilder2.append(this.f);
      textView2.setText(stringBuilder2.toString());
      if (!TextUtils.isEmpty(this.e)) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.e);
        stringBuilder.append(": ");
        stringBuilder.append(this.f);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(stringBuilder.toString());
        spannableStringBuilder.setSpan(new ForegroundColorSpan(AppInfo.d().getResources().getColor(R.color.syc_f)), 0, this.e.length(), 33);
        textView1.setText((CharSequence)spannableStringBuilder);
        return;
      } 
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(this.e);
      stringBuilder1.append(": ");
      stringBuilder1.append(this.f);
      textView1.setText(stringBuilder1.toString());
    }
    
    private void f() {
      TextView textView1 = (TextView)this.k.findViewById(R.id.tv_content);
      TextView textView2 = (TextView)this.k.findViewById(R.id.tv_content_shadow);
      ImageView imageView1 = (ImageView)this.k.findViewById(R.id.img_rich_rank);
      ImageView imageView2 = (ImageView)this.k.findViewById(R.id.img_manager_icon);
      if (this.i == 1) {
        imageView2.setVisibility(0);
      } else {
        imageView2.setVisibility(8);
      } 
      LiveBitmapUtils.a(BarrageViewMultiOneRow.g(this.m), imageView1, this.h);
      StringBuilder stringBuilder2 = new StringBuilder();
      stringBuilder2.append(this.e);
      stringBuilder2.append(" ");
      stringBuilder2.append(this.f);
      textView2.setText(stringBuilder2.toString());
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(this.e);
      stringBuilder1.append(" ");
      stringBuilder1.append(this.f);
      textView1.setText(stringBuilder1.toString());
    }
    
    private void g() {
      TextView textView2 = (TextView)this.k.findViewById(R.id.tv_name);
      TextView textView1 = (TextView)this.k.findViewById(R.id.tv_count);
      ImageView imageView = (ImageView)this.k.findViewById(R.id.img_gift);
      textView2.setText(MsgPackHelper.getStringValue(this.a.msgMapExtra, "name"));
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(MsgPackHelper.getIntValue(this.a.msgMapExtra, "count"));
      stringBuilder.append("");
      textView1.setText(stringBuilder.toString());
      ImageLoader.a(null, MsgPackHelper.getStringValue(this.a.msgMapExtra, "image")).a(R.drawable.gift_default_icon).a(imageView);
    }
    
    private void h() {
      ((TextView)this.k.findViewById(R.id.tv_content)).setText(this.f);
    }
    
    private void i() {
      ((TextView)this.k.findViewById(R.id.tv_content)).setText(this.f);
    }
    
    private void j() {
      // Byte code:
      //   0: aload_0
      //   1: getfield k : Landroid/view/View;
      //   4: getstatic com/blued/android/module/live_china/R$id.tv_content : I
      //   7: invokevirtual findViewById : (I)Landroid/view/View;
      //   10: checkcast android/widget/TextView
      //   13: astore #6
      //   15: aload_0
      //   16: getfield k : Landroid/view/View;
      //   19: getstatic com/blued/android/module/live_china/R$id.tv_content_shadow : I
      //   22: invokevirtual findViewById : (I)Landroid/view/View;
      //   25: checkcast android/widget/TextView
      //   28: astore_3
      //   29: aload_0
      //   30: getfield k : Landroid/view/View;
      //   33: getstatic com/blued/android/module/live_china/R$id.tv_gift_count : I
      //   36: invokevirtual findViewById : (I)Landroid/view/View;
      //   39: checkcast android/widget/TextView
      //   42: astore #4
      //   44: aload_0
      //   45: getfield k : Landroid/view/View;
      //   48: getstatic com/blued/android/module/live_china/R$id.img_rich_rank : I
      //   51: invokevirtual findViewById : (I)Landroid/view/View;
      //   54: checkcast android/widget/ImageView
      //   57: astore #5
      //   59: aload_0
      //   60: getfield m : Lcom/blued/android/module/live_china/view/BarrageViewMultiOneRow;
      //   63: invokestatic g : (Lcom/blued/android/module/live_china/view/BarrageViewMultiOneRow;)Landroid/content/Context;
      //   66: aload #5
      //   68: aload_0
      //   69: getfield h : I
      //   72: invokestatic a : (Landroid/content/Context;Landroid/widget/ImageView;I)I
      //   75: pop
      //   76: aload_0
      //   77: getfield k : Landroid/view/View;
      //   80: getstatic com/blued/android/module/live_china/R$id.img_manager_icon : I
      //   83: invokevirtual findViewById : (I)Landroid/view/View;
      //   86: checkcast android/widget/ImageView
      //   89: astore #5
      //   91: aload_0
      //   92: getfield i : I
      //   95: iconst_1
      //   96: if_icmpne -> 108
      //   99: aload #5
      //   101: iconst_0
      //   102: invokevirtual setVisibility : (I)V
      //   105: goto -> 115
      //   108: aload #5
      //   110: bipush #8
      //   112: invokevirtual setVisibility : (I)V
      //   115: aload_0
      //   116: getfield k : Landroid/view/View;
      //   119: getstatic com/blued/android/module/live_china/R$id.img_gift : I
      //   122: invokevirtual findViewById : (I)Landroid/view/View;
      //   125: checkcast android/widget/ImageView
      //   128: astore #5
      //   130: new java/lang/StringBuilder
      //   133: dup
      //   134: invokespecial <init> : ()V
      //   137: astore #7
      //   139: aload #7
      //   141: aload_0
      //   142: getfield e : Ljava/lang/String;
      //   145: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   148: pop
      //   149: aload #7
      //   151: ldc ' '
      //   153: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   156: pop
      //   157: aload #7
      //   159: aload_0
      //   160: getfield m : Lcom/blued/android/module/live_china/view/BarrageViewMultiOneRow;
      //   163: invokestatic g : (Lcom/blued/android/module/live_china/view/BarrageViewMultiOneRow;)Landroid/content/Context;
      //   166: invokevirtual getResources : ()Landroid/content/res/Resources;
      //   169: getstatic com/blued/android/module/live_china/R$string.Live_SendPresent_send : I
      //   172: invokevirtual getString : (I)Ljava/lang/String;
      //   175: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   178: pop
      //   179: aload #7
      //   181: ldc ' '
      //   183: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   186: pop
      //   187: aload #6
      //   189: aload #7
      //   191: invokevirtual toString : ()Ljava/lang/String;
      //   194: invokevirtual setText : (Ljava/lang/CharSequence;)V
      //   197: new java/lang/StringBuilder
      //   200: dup
      //   201: invokespecial <init> : ()V
      //   204: astore #6
      //   206: aload #6
      //   208: aload_0
      //   209: getfield e : Ljava/lang/String;
      //   212: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   215: pop
      //   216: aload #6
      //   218: ldc ' '
      //   220: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   223: pop
      //   224: aload #6
      //   226: aload_0
      //   227: getfield m : Lcom/blued/android/module/live_china/view/BarrageViewMultiOneRow;
      //   230: invokestatic g : (Lcom/blued/android/module/live_china/view/BarrageViewMultiOneRow;)Landroid/content/Context;
      //   233: invokevirtual getResources : ()Landroid/content/res/Resources;
      //   236: getstatic com/blued/android/module/live_china/R$string.Live_SendPresent_send : I
      //   239: invokevirtual getString : (I)Ljava/lang/String;
      //   242: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   245: pop
      //   246: aload #6
      //   248: ldc ' '
      //   250: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   253: pop
      //   254: aload_3
      //   255: aload #6
      //   257: invokevirtual toString : ()Ljava/lang/String;
      //   260: invokevirtual setText : (Ljava/lang/CharSequence;)V
      //   263: aload_0
      //   264: getfield a : Lcom/blued/android/chat/model/ChattingModel;
      //   267: getfield msgMapExtra : Ljava/util/Map;
      //   270: ifnull -> 294
      //   273: aload_0
      //   274: getfield a : Lcom/blued/android/chat/model/ChattingModel;
      //   277: getfield msgMapExtra : Ljava/util/Map;
      //   280: ldc 'gift_model'
      //   282: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
      //   287: checkcast com/blued/android/module/live_china/model/LiveGiftModel
      //   290: astore_3
      //   291: goto -> 322
      //   294: aload_0
      //   295: getfield g : Ljava/lang/String;
      //   298: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
      //   301: ifeq -> 305
      //   304: return
      //   305: invokestatic f : ()Lcom/google/gson/Gson;
      //   308: aload_0
      //   309: getfield g : Ljava/lang/String;
      //   312: ldc_w com/blued/android/module/live_china/model/LiveGiftModel
      //   315: invokevirtual fromJson : (Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;
      //   318: checkcast com/blued/android/module/live_china/model/LiveGiftModel
      //   321: astore_3
      //   322: aload_3
      //   323: ifnonnull -> 327
      //   326: return
      //   327: aload_3
      //   328: getfield images_static : Ljava/lang/String;
      //   331: astore #6
      //   333: aload_3
      //   334: getfield hit_batch : I
      //   337: istore_1
      //   338: aload_3
      //   339: getfield hit_count : I
      //   342: istore_2
      //   343: iload_1
      //   344: iconst_1
      //   345: if_icmpne -> 388
      //   348: aload #4
      //   350: iconst_0
      //   351: invokevirtual setVisibility : (I)V
      //   354: new java/lang/StringBuilder
      //   357: dup
      //   358: invokespecial <init> : ()V
      //   361: astore_3
      //   362: aload_3
      //   363: ldc_w 'X'
      //   366: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   369: pop
      //   370: aload_3
      //   371: iload_2
      //   372: invokevirtual append : (I)Ljava/lang/StringBuilder;
      //   375: pop
      //   376: aload #4
      //   378: aload_3
      //   379: invokevirtual toString : ()Ljava/lang/String;
      //   382: invokevirtual setText : (Ljava/lang/CharSequence;)V
      //   385: goto -> 395
      //   388: aload #4
      //   390: bipush #8
      //   392: invokevirtual setVisibility : (I)V
      //   395: aload #6
      //   397: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
      //   400: ifeq -> 414
      //   403: aload #5
      //   405: getstatic com/blued/android/module/live_china/R$drawable.gift_default_icon : I
      //   408: invokevirtual setImageResource : (I)V
      //   411: goto -> 431
      //   414: aconst_null
      //   415: aload #6
      //   417: invokestatic a : (Lcom/blued/android/core/net/IRequestHost;Ljava/lang/String;)Lcom/blued/android/core/image/ImageWrapper;
      //   420: getstatic com/blued/android/module/live_china/R$drawable.gift_default_icon : I
      //   423: invokevirtual a : (I)Lcom/blued/android/core/image/ImageWrapper;
      //   426: aload #5
      //   428: invokevirtual a : (Landroid/widget/ImageView;)V
      //   431: aload #5
      //   433: iconst_0
      //   434: iconst_0
      //   435: invokestatic makeMeasureSpec : (II)I
      //   438: iconst_0
      //   439: iconst_0
      //   440: invokestatic makeMeasureSpec : (II)I
      //   443: invokevirtual measure : (II)V
      //   446: aload #5
      //   448: iconst_0
      //   449: iconst_0
      //   450: aload #5
      //   452: invokevirtual getMeasuredWidth : ()I
      //   455: aload #5
      //   457: invokevirtual getMeasuredHeight : ()I
      //   460: invokevirtual layout : (IIII)V
      //   463: aload #5
      //   465: invokevirtual getWidth : ()I
      //   468: i2f
      //   469: aload #5
      //   471: invokevirtual getHeight : ()I
      //   474: i2f
      //   475: fdiv
      //   476: aload_0
      //   477: getfield m : Lcom/blued/android/module/live_china/view/BarrageViewMultiOneRow;
      //   480: invokestatic h : (Lcom/blued/android/module/live_china/view/BarrageViewMultiOneRow;)I
      //   483: i2f
      //   484: fmul
      //   485: f2i
      //   486: istore_1
      //   487: aload #5
      //   489: invokevirtual getLayoutParams : ()Landroid/view/ViewGroup$LayoutParams;
      //   492: checkcast android/widget/LinearLayout$LayoutParams
      //   495: astore_3
      //   496: aload_3
      //   497: iload_1
      //   498: putfield width : I
      //   501: aload_3
      //   502: aload_0
      //   503: getfield m : Lcom/blued/android/module/live_china/view/BarrageViewMultiOneRow;
      //   506: invokestatic h : (Lcom/blued/android/module/live_china/view/BarrageViewMultiOneRow;)I
      //   509: putfield height : I
      //   512: aload #5
      //   514: aload_3
      //   515: invokevirtual setLayoutParams : (Landroid/view/ViewGroup$LayoutParams;)V
      //   518: return
      //   519: astore_3
      //   520: aload_3
      //   521: invokevirtual printStackTrace : ()V
      //   524: return
      // Exception table:
      //   from	to	target	type
      //   305	322	519	java/lang/Exception
    }
    
    private void k() {
      TextView textView2 = (TextView)this.k.findViewById(R.id.live_msg_content_nickname);
      TextView textView1 = (TextView)this.k.findViewById(R.id.live_msg_content_text);
      textView2.setText(this.a.fromNickName);
      String str = BarrageViewMultiOneRow.g(this.m).getResources().getString(R.string.live_chat_upgrade);
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(this.a.fromRichLevel);
      stringBuilder.append("");
      textView1.setText(String.format(str, new Object[] { stringBuilder.toString() }));
    }
    
    public Bitmap a() {
      Bitmap bitmap = this.l;
      if (bitmap != null)
        return bitmap; 
      if (this.k != null) {
        switch (this.b) {
          case 7:
            k();
            break;
          case 6:
            i();
            break;
          case 5:
            h();
            break;
          case 4:
            f();
            break;
          case 3:
            g();
            break;
          case 2:
            d();
            break;
          case 1:
            e();
            break;
          case 0:
            j();
            break;
        } 
        try {
          this.k.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
          this.k.layout(0, 0, this.k.getMeasuredWidth(), this.k.getMeasuredHeight());
          BarrageViewMultiOneRow.a(this.m, Bitmap.createBitmap(this.k.getMeasuredWidth(), this.k.getMeasuredHeight(), Bitmap.Config.ARGB_8888));
          Canvas canvas = new Canvas(BarrageViewMultiOneRow.i(this.m));
          this.k.draw(canvas);
          this.l = BarrageViewMultiOneRow.i(this.m);
          return BarrageViewMultiOneRow.i(this.m);
        } catch (Exception exception) {
          return null;
        } 
      } 
      return null;
    }
    
    public void a(float param1Float) {
      this.o = param1Float;
    }
    
    public float b() {
      return this.o;
    }
    
    public void b(float param1Float) {
      this.n = param1Float;
    }
    
    public float c() {
      return this.n;
    }
  }
  
  class BubblesRow {
    public List<BarrageViewMultiOneRow.Bubble> a = new ArrayList<BarrageViewMultiOneRow.Bubble>();
    
    public List<BarrageViewMultiOneRow.Bubble> b = new ArrayList<BarrageViewMultiOneRow.Bubble>();
    
    public boolean c = true;
    
    public int d;
    
    private BubblesRow(BarrageViewMultiOneRow this$0) {}
    
    public int a() {
      return this.b.size();
    }
    
    public BarrageViewMultiOneRow.Bubble a(int param1Int1, int param1Int2) {
      int i = this.d;
      int j = BarrageViewMultiOneRow.h(this.e);
      if (param1Int2 > i && param1Int2 < j + i)
        for (param1Int2 = 0; param1Int2 < this.a.size(); param1Int2++) {
          i = (int)BarrageViewMultiOneRow.Bubble.a(this.a.get(param1Int2));
          j = (int)BarrageViewMultiOneRow.Bubble.a(this.a.get(param1Int2));
          int k = ((BarrageViewMultiOneRow.Bubble)this.a.get(param1Int2)).l.getWidth();
          if (param1Int1 > i && param1Int1 < j + k)
            return this.a.get(param1Int2); 
        }  
      return null;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\view\BarrageViewMultiOneRow.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */