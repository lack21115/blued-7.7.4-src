package com.soft.blued.ui.live.adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.imagecache.view.AutoAttachRecyclingImageView;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.soft.blued.ui.live.model.LiveJoinFansModel;
import com.soft.blued.ui.live.model.LiveJoinFansPrivilegeModel;
import com.soft.blued.ui.live.view.LineView;
import com.soft.blued.view.tip.CommonAlertDialog;
import java.util.ArrayList;
import java.util.List;

public class LiveJoinFansAdapater extends BaseMultiItemQuickAdapter<LiveJoinFansModel, BaseViewHolder> {
  public EventCallBack a;
  
  private Context b;
  
  private IRequestHost c;
  
  private List<LiveJoinFansModel> d;
  
  private TextView e;
  
  public LiveJoinFansAdapater(IRequestHost paramIRequestHost, Context paramContext) {
    super(new ArrayList());
    this.b = paramContext;
    this.c = paramIRequestHost;
    this.d = new ArrayList<LiveJoinFansModel>();
    b(1, 2131493852);
    b(0, 2131493853);
    c(this.d);
  }
  
  private void b(BaseViewHolder paramBaseViewHolder, LiveJoinFansModel paramLiveJoinFansModel) {
    int i;
    long l;
    View view1 = paramBaseViewHolder.d(2131298932);
    if (paramLiveJoinFansModel.isOpen) {
      i = 0;
    } else {
      i = 8;
    } 
    view1.setVisibility(i);
    ((TextView)paramBaseViewHolder.d(2131301088)).setText(String.format(this.k.getResources().getString(2131757351), new Object[] { paramLiveJoinFansModel.anchor_name }));
    TextView textView3 = (TextView)paramBaseViewHolder.d(2131300951);
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(paramLiveJoinFansModel.level);
    stringBuilder2.append("");
    textView3.setText(stringBuilder2.toString());
    View view2 = paramBaseViewHolder.d(2131298909);
    ImageView imageView = (ImageView)paramBaseViewHolder.d(2131297800);
    if (paramLiveJoinFansModel.brand_status == 1) {
      view2.setBackgroundResource(2131233034);
      imageView.setImageResource(2131233035);
    } else {
      view2.setBackgroundResource(2131233030);
      imageView.setImageResource(2131233031);
    } 
    ((TextView)paramBaseViewHolder.d(2131300748)).setText(paramLiveJoinFansModel.name);
    TextView textView2 = (TextView)paramBaseViewHolder.d(2131301210);
    textView2.setOnClickListener(new View.OnClickListener(this, paramLiveJoinFansModel, paramBaseViewHolder) {
          public void onClick(View param1View) {
            CommonAlertDialog.a(LiveJoinFansAdapater.a(this.c), LiveJoinFansAdapater.b(this.c).getResources().getString(2131757365), "", LiveJoinFansAdapater.c(this.c).getResources().getString(2131756086), new DialogInterface.OnClickListener(this) {
                  public void onClick(DialogInterface param2DialogInterface, int param2Int) {
                    if (this.a.c.a != null)
                      this.a.c.a.a(this.a.a.anchor, this.a.b.getLayoutPosition()); 
                  }
                }LiveJoinFansAdapater.d(this.c).getResources().getString(2131757364), null, null);
          }
        });
    imageView = (ImageView)paramBaseViewHolder.d(2131297931);
    imageView.setOnClickListener(new View.OnClickListener(this, paramLiveJoinFansModel, imageView, view1, textView2) {
          public void onClick(View param1View) {
            Context context;
            int i;
            LiveJoinFansModel liveJoinFansModel = this.a;
            liveJoinFansModel.isOpen ^= 0x1;
            ImageView imageView = this.b;
            if (this.a.isOpen) {
              context = LiveJoinFansAdapater.e(this.e);
              i = 2131233052;
            } else {
              context = LiveJoinFansAdapater.e(this.e);
              i = 2131233021;
            } 
            imageView.setImageDrawable(BluedSkinUtils.b(context, i));
            View view = this.c;
            boolean bool1 = this.a.isOpen;
            boolean bool = false;
            if (bool1) {
              i = 0;
            } else {
              i = 8;
            } 
            view.setVisibility(i);
            TextView textView = this.d;
            if (this.a.isOpen) {
              i = bool;
            } else {
              i = 8;
            } 
            textView.setVisibility(i);
          }
        });
    try {
      float f = paramLiveJoinFansModel.relation;
      i = paramLiveJoinFansModel.next_level_relation;
      l = (long)(f * 1.0F * 100.0F / i);
    } catch (ArithmeticException arithmeticException) {
      l = 0L;
    } 
    ((ProgressBar)paramBaseViewHolder.d(2131296501)).setProgress((int)l);
    ((TextView)paramBaseViewHolder.d(2131300553)).setText(String.format(this.b.getResources().getString(2131757373), new Object[] { Integer.valueOf(paramLiveJoinFansModel.next_level_relation - paramLiveJoinFansModel.relation) }));
    RecyclerView recyclerView = (RecyclerView)paramBaseViewHolder.d(2131299773);
    recyclerView.setLayoutManager((RecyclerView.LayoutManager)new GridLayoutManager(this.k, 3));
    recyclerView.setAdapter((RecyclerView.Adapter)new PrivilegeAdapter(this, this.c, paramLiveJoinFansModel.privilege_list));
    TextView textView1 = (TextView)paramBaseViewHolder.d(2131301430);
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append(this.b.getResources().getString(2131757372));
    stringBuilder1.append(paramLiveJoinFansModel.relation_today);
    textView1.setText(stringBuilder1.toString());
    ((LineView)paramBaseViewHolder.d(2131298125)).setData(paramLiveJoinFansModel.relation_days);
  }
  
  public int a() {
    return (n() != null) ? n().size() : 0;
  }
  
  public void a(int paramInt) {
    d(paramInt);
  }
  
  protected void a(BaseViewHolder paramBaseViewHolder, LiveJoinFansModel paramLiveJoinFansModel) {
    if (paramBaseViewHolder != null) {
      int i = paramBaseViewHolder.getItemViewType();
      if (i != 0) {
        if (i != 1)
          return; 
        this.e = (TextView)paramBaseViewHolder.d(2131300749);
        this.e.setText(String.format(this.k.getString(2131757317), new Object[] { Integer.valueOf(a() - 1) }));
        return;
      } 
      b(paramBaseViewHolder, paramLiveJoinFansModel);
    } 
  }
  
  public void a(EventCallBack paramEventCallBack) {
    this.a = paramEventCallBack;
  }
  
  public void a(String paramString) {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: iload_2
    //   3: aload_0
    //   4: invokevirtual n : ()Ljava/util/List;
    //   7: invokeinterface size : ()I
    //   12: if_icmpge -> 48
    //   15: aload_1
    //   16: aload_0
    //   17: invokevirtual n : ()Ljava/util/List;
    //   20: iload_2
    //   21: invokeinterface get : (I)Ljava/lang/Object;
    //   26: checkcast com/soft/blued/ui/live/model/LiveJoinFansModel
    //   29: getfield anchor : Ljava/lang/String;
    //   32: invokestatic equals : (Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   35: ifeq -> 41
    //   38: goto -> 50
    //   41: iload_2
    //   42: iconst_1
    //   43: iadd
    //   44: istore_2
    //   45: goto -> 2
    //   48: iconst_m1
    //   49: istore_2
    //   50: iload_2
    //   51: iflt -> 100
    //   54: aload_0
    //   55: iload_2
    //   56: invokevirtual a : (I)V
    //   59: aload_0
    //   60: getfield e : Landroid/widget/TextView;
    //   63: astore_1
    //   64: aload_1
    //   65: ifnull -> 100
    //   68: aload_1
    //   69: aload_0
    //   70: getfield k : Landroid/content/Context;
    //   73: ldc 2131757317
    //   75: invokevirtual getString : (I)Ljava/lang/String;
    //   78: iconst_1
    //   79: anewarray java/lang/Object
    //   82: dup
    //   83: iconst_0
    //   84: aload_0
    //   85: invokevirtual a : ()I
    //   88: iconst_1
    //   89: isub
    //   90: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   93: aastore
    //   94: invokestatic format : (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   97: invokevirtual setText : (Ljava/lang/CharSequence;)V
    //   100: aload_0
    //   101: invokevirtual a : ()I
    //   104: iconst_1
    //   105: isub
    //   106: ifgt -> 124
    //   109: aload_0
    //   110: getfield a : Lcom/soft/blued/ui/live/adapter/LiveJoinFansAdapater$EventCallBack;
    //   113: astore_1
    //   114: aload_1
    //   115: ifnull -> 124
    //   118: aload_1
    //   119: invokeinterface a : ()V
    //   124: return
  }
  
  public void a(List<LiveJoinFansModel> paramList) {
    if (paramList == null)
      return; 
    ArrayList<LiveJoinFansModel> arrayList = new ArrayList();
    if (paramList.size() > 0) {
      LiveJoinFansModel liveJoinFansModel = new LiveJoinFansModel();
      liveJoinFansModel.itemCusType = 1;
      arrayList.add(liveJoinFansModel);
      ((LiveJoinFansModel)paramList.get(0)).isOpen = true;
      arrayList.addAll(paramList);
    } 
    c(arrayList);
  }
  
  public static interface EventCallBack {
    void a();
    
    void a(String param1String, int param1Int);
  }
  
  class PrivilegeAdapter extends BaseQuickAdapter<LiveJoinFansPrivilegeModel, BaseViewHolder> {
    private IRequestHost b;
    
    public PrivilegeAdapter(LiveJoinFansAdapater this$0, IRequestHost param1IRequestHost, List<LiveJoinFansPrivilegeModel> param1List) {
      super(2131493854);
      this.b = param1IRequestHost;
      c(param1List);
    }
    
    protected void a(BaseViewHolder param1BaseViewHolder, LiveJoinFansPrivilegeModel param1LiveJoinFansPrivilegeModel) {
      String str;
      AutoAttachRecyclingImageView autoAttachRecyclingImageView = (AutoAttachRecyclingImageView)param1BaseViewHolder.d(2131296485);
      if (!TextUtils.isEmpty(param1LiveJoinFansPrivilegeModel.icon)) {
        str = param1LiveJoinFansPrivilegeModel.icon;
      } else {
        str = param1LiveJoinFansPrivilegeModel.icon_gray;
      } 
      ImageLoader.a(this.b, str).a((ImageView)autoAttachRecyclingImageView);
      ((TextView)param1BaseViewHolder.d(2131301088)).setText(param1LiveJoinFansPrivilegeModel.title);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\live\adapter\LiveJoinFansAdapater.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */