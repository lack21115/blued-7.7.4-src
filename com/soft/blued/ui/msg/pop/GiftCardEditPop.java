package com.soft.blued.ui.msg.pop;

import android.app.Activity;
import android.content.Context;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.blued.android.core.BlueAppLocal;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.ui.xpop.core.BottomPopupView;
import com.blued.android.module.common.utils.ToastUtils;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.soft.blued.http.ChatHttpUtils;
import com.soft.blued.ui.msg.model.CardWordCheckModel;
import com.soft.blued.ui.user.model.GiftGivingOptionForJsonParse;
import com.soft.blued.utils.Logger;

public class GiftCardEditPop extends BottomPopupView {
  private EditText b;
  
  private GiftGivingOptionForJsonParse.CardGift c;
  
  public GiftCardEditPop(Context paramContext, GiftGivingOptionForJsonParse.CardGift paramCardGift) {
    super(paramContext);
    this.c = paramCardGift;
    if (paramContext instanceof Activity) {
      Logger.c(getClass().getSimpleName(), new Object[] { "SOFT_INPUT_ADJUST_NOTHING" });
      ((Activity)paramContext).getWindow().setSoftInputMode(48);
    } 
  }
  
  public void b() {
    super.b();
    this.b = (EditText)findViewById(2131296997);
    GiftGivingOptionForJsonParse.CardGift cardGift1 = this.c;
    if (cardGift1 != null && !TextUtils.isEmpty(cardGift1.text))
      this.b.setText(this.c.text); 
    EditText editText1 = this.b;
    editText1.setSelection(editText1.getText().length());
    editText1 = (EditText)findViewById(2131297016);
    EditText editText2 = (EditText)findViewById(2131296999);
    ((TextView)findViewById(2131301130)).setOnClickListener(new View.OnClickListener(this, editText2, editText1) {
          public void onClick(View param1View) {
            if (TextUtils.isEmpty(GiftCardEditPop.a(this.c).getText().toString()) || TextUtils.isEmpty(this.a.getText().toString()) || TextUtils.isEmpty(this.b.getText().toString())) {
              ToastUtils.a(this.c.getResources().getString(2131757951));
              return;
            } 
            BluedUIHttpResponse<BluedEntityA<CardWordCheckModel>> bluedUIHttpResponse = new BluedUIHttpResponse<BluedEntityA<CardWordCheckModel>>(this, null) {
                protected void a(BluedEntityA<CardWordCheckModel> param2BluedEntityA) {
                  if (param2BluedEntityA.hasData()) {
                    if (((CardWordCheckModel)param2BluedEntityA.data.get(0)).validation) {
                      GiftGivingOptionForJsonParse.CardGift cardGift = new GiftGivingOptionForJsonParse.CardGift();
                      cardGift.from = this.a.a.getText().toString();
                      cardGift.to = this.a.b.getText().toString();
                      cardGift.text = GiftCardEditPop.a(this.a.c).getText().toString();
                      LiveEventBus.get("card_edit").post(cardGift);
                      this.a.c.p();
                      return;
                    } 
                    ToastUtils.a(this.a.c.getResources().getString(2131757952));
                  } 
                }
              };
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(GiftCardEditPop.a(this.c).getText().toString());
            stringBuilder.append(this.a.getText().toString());
            stringBuilder.append(this.b.getText().toString());
            ChatHttpUtils.a(bluedUIHttpResponse, stringBuilder.toString());
          }
        });
    ((TextView)findViewById(2131301129)).setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            String str;
            if (BlueAppLocal.d()) {
              if ("CN".equals(BlueAppLocal.c().getCountry().toUpperCase())) {
                str = (GiftCardEditPop.b(this.a)).text_zh_cn;
              } else {
                str = (GiftCardEditPop.b(this.a)).text_zh_tw;
              } 
            } else {
              str = (GiftCardEditPop.b(this.a)).text_en_us;
            } 
            GiftCardEditPop.a(this.a).setText(str);
            GiftCardEditPop.a(this.a).setSelection(GiftCardEditPop.a(this.a).getText().toString().length());
          }
        });
    GiftGivingOptionForJsonParse.CardGift cardGift2 = this.c;
    if (cardGift2 != null) {
      editText1.setText(cardGift2.to);
      editText1.setSelection(editText1.getText().toString().length());
      editText2.setText(this.c.from);
      editText2.setSelection(editText2.getText().toString().length());
    } 
    this.b.setFilters(new InputFilter[] { new InputFilter(this) {
            public CharSequence filter(CharSequence param1CharSequence, int param1Int1, int param1Int2, Spanned param1Spanned, int param1Int3, int param1Int4) {
              // Byte code:
              //   0: aload #4
              //   2: invokevirtual toString : ()Ljava/lang/String;
              //   5: astore #4
              //   7: aload #4
              //   9: invokevirtual toCharArray : ()[C
              //   12: astore #8
              //   14: aload #8
              //   16: arraylength
              //   17: istore #6
              //   19: iconst_0
              //   20: istore_2
              //   21: iconst_0
              //   22: istore_3
              //   23: iload_2
              //   24: iload #6
              //   26: if_icmpge -> 84
              //   29: aload #8
              //   31: iload_2
              //   32: caload
              //   33: istore #7
              //   35: iload #7
              //   37: bipush #10
              //   39: if_icmpeq -> 52
              //   42: iload_3
              //   43: istore #5
              //   45: iload #7
              //   47: bipush #13
              //   49: if_icmpne -> 57
              //   52: iload_3
              //   53: iconst_1
              //   54: iadd
              //   55: istore #5
              //   57: ldc 'GiftCardEditPop'
              //   59: iconst_1
              //   60: anewarray java/lang/Object
              //   63: dup
              //   64: iconst_0
              //   65: iload #7
              //   67: invokestatic valueOf : (I)Ljava/lang/Integer;
              //   70: aastore
              //   71: invokestatic c : (Ljava/lang/String;[Ljava/lang/Object;)V
              //   74: iload_2
              //   75: iconst_1
              //   76: iadd
              //   77: istore_2
              //   78: iload #5
              //   80: istore_3
              //   81: goto -> 23
              //   84: aload_0
              //   85: getfield a : Lcom/soft/blued/ui/msg/pop/GiftCardEditPop;
              //   88: invokestatic a : (Lcom/soft/blued/ui/msg/pop/GiftCardEditPop;)Landroid/widget/EditText;
              //   91: invokevirtual getHeight : ()I
              //   94: ldc 50.0
              //   96: invokestatic a : (F)I
              //   99: if_icmplt -> 139
              //   102: aload_0
              //   103: getfield a : Lcom/soft/blued/ui/msg/pop/GiftCardEditPop;
              //   106: invokestatic a : (Lcom/soft/blued/ui/msg/pop/GiftCardEditPop;)Landroid/widget/EditText;
              //   109: invokevirtual getLayoutParams : ()Landroid/view/ViewGroup$LayoutParams;
              //   112: checkcast android/widget/LinearLayout$LayoutParams
              //   115: astore #8
              //   117: aload #8
              //   119: ldc 50.0
              //   121: invokestatic a : (F)I
              //   124: putfield height : I
              //   127: aload_0
              //   128: getfield a : Lcom/soft/blued/ui/msg/pop/GiftCardEditPop;
              //   131: invokestatic a : (Lcom/soft/blued/ui/msg/pop/GiftCardEditPop;)Landroid/widget/EditText;
              //   134: aload #8
              //   136: invokevirtual setLayoutParams : (Landroid/view/ViewGroup$LayoutParams;)V
              //   139: iload_3
              //   140: bipush #7
              //   142: if_icmpge -> 187
              //   145: new java/lang/StringBuilder
              //   148: dup
              //   149: invokespecial <init> : ()V
              //   152: astore #8
              //   154: aload #8
              //   156: aload_1
              //   157: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
              //   160: pop
              //   161: aload #8
              //   163: aload #4
              //   165: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
              //   168: pop
              //   169: aload #8
              //   171: invokevirtual toString : ()Ljava/lang/String;
              //   174: invokevirtual length : ()I
              //   177: bipush #100
              //   179: if_icmple -> 185
              //   182: goto -> 187
              //   185: aconst_null
              //   186: areturn
              //   187: ldc ''
              //   189: areturn
            }
          } });
    editText1.clearFocus();
    editText2.clearFocus();
    this.b.requestFocus();
  }
  
  public int getImplLayoutId() {
    return 2131494040;
  }
  
  public void t() {
    super.t();
    if (getContext() instanceof Activity) {
      Logger.c(getClass().getSimpleName(), new Object[] { "SOFT_INPUT_ADJUST_RESIZE" });
      ((Activity)getContext()).getWindow().setSoftInputMode(16);
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\msg\pop\GiftCardEditPop.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */