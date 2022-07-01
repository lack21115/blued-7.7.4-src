package com.soft.blued.ui.group;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.blued.android.chat.ChatManager;
import com.blued.android.core.AppMethods;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.view.pulltorefresh.RenrenPullToRefreshListView;
import com.blued.android.module.common.utils.DialogUtils;
import com.soft.blued.customview.CommonTopTitleNoTrans;
import com.soft.blued.customview.NoDataAndLoadFailView;
import com.soft.blued.http.GroupHttpUtils;
import com.soft.blued.ui.group.adapter.GroupNotifyAdapter;
import com.soft.blued.ui.group.model.BluedMyGroupNotify;
import com.soft.blued.user.UserInfo;
import com.soft.blued.utils.Logger;
import com.soft.blued.view.tip.CommonAlertDialog;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;

public class GroupNotifyFragment extends BaseFragment implements View.OnClickListener {
  public static List<String> d = new ArrayList<String>();
  
  public BluedUIHttpResponse e = new BluedUIHttpResponse<BluedEntityA<BluedMyGroupNotify>>(this) {
      protected BluedEntityA<BluedMyGroupNotify> a(String param1String) {
        Logger.a(GroupNotifyFragment.c(this.a), new Object[] { "onSuccess, content:", param1String });
        return (BluedEntityA<BluedMyGroupNotify>)super.parseData(param1String);
      }
      
      public void a(BluedEntityA<BluedMyGroupNotify> param1BluedEntityA) {
        // Byte code:
        //   0: aload_1
        //   1: ifnull -> 385
        //   4: aload_1
        //   5: invokevirtual hasData : ()Z
        //   8: ifeq -> 385
        //   11: aload_1
        //   12: getfield extra : Lcom/blued/android/framework/http/parser/BluedEntityBaseExtra;
        //   15: getfield hasmore : I
        //   18: iconst_1
        //   19: if_icmpne -> 44
        //   22: aload_0
        //   23: getfield a : Lcom/soft/blued/ui/group/GroupNotifyFragment;
        //   26: iconst_1
        //   27: invokestatic b : (Lcom/soft/blued/ui/group/GroupNotifyFragment;Z)Z
        //   30: pop
        //   31: aload_0
        //   32: getfield a : Lcom/soft/blued/ui/group/GroupNotifyFragment;
        //   35: invokestatic a : (Lcom/soft/blued/ui/group/GroupNotifyFragment;)Lcom/blued/android/framework/view/pulltorefresh/RenrenPullToRefreshListView;
        //   38: invokevirtual o : ()V
        //   41: goto -> 63
        //   44: aload_0
        //   45: getfield a : Lcom/soft/blued/ui/group/GroupNotifyFragment;
        //   48: iconst_0
        //   49: invokestatic b : (Lcom/soft/blued/ui/group/GroupNotifyFragment;Z)Z
        //   52: pop
        //   53: aload_0
        //   54: getfield a : Lcom/soft/blued/ui/group/GroupNotifyFragment;
        //   57: invokestatic a : (Lcom/soft/blued/ui/group/GroupNotifyFragment;)Lcom/blued/android/framework/view/pulltorefresh/RenrenPullToRefreshListView;
        //   60: invokevirtual p : ()V
        //   63: aload_0
        //   64: getfield a : Lcom/soft/blued/ui/group/GroupNotifyFragment;
        //   67: invokestatic d : (Lcom/soft/blued/ui/group/GroupNotifyFragment;)I
        //   70: iconst_1
        //   71: if_icmpne -> 110
        //   74: aload_0
        //   75: getfield a : Lcom/soft/blued/ui/group/GroupNotifyFragment;
        //   78: invokestatic e : (Lcom/soft/blued/ui/group/GroupNotifyFragment;)Ljava/util/List;
        //   81: invokeinterface clear : ()V
        //   86: aload_0
        //   87: getfield a : Lcom/soft/blued/ui/group/GroupNotifyFragment;
        //   90: aload_1
        //   91: getfield data : Ljava/util/List;
        //   94: iconst_0
        //   95: invokeinterface get : (I)Ljava/lang/Object;
        //   100: checkcast com/soft/blued/ui/group/model/BluedMyGroupNotify
        //   103: invokevirtual getIid : ()Ljava/lang/String;
        //   106: invokestatic a : (Lcom/soft/blued/ui/group/GroupNotifyFragment;Ljava/lang/String;)Ljava/lang/String;
        //   109: pop
        //   110: aconst_null
        //   111: astore #5
        //   113: new java/io/File
        //   116: dup
        //   117: aload_0
        //   118: getfield a : Lcom/soft/blued/ui/group/GroupNotifyFragment;
        //   121: invokevirtual getActivity : ()Landroidx/fragment/app/FragmentActivity;
        //   124: invokevirtual getFilesDir : ()Ljava/io/File;
        //   127: ldc 'groupnofyalread'
        //   129: invokespecial <init> : (Ljava/io/File;Ljava/lang/String;)V
        //   132: astore #6
        //   134: aload #5
        //   136: astore #4
        //   138: aload #6
        //   140: invokevirtual exists : ()Z
        //   143: ifeq -> 504
        //   146: new java/io/FileInputStream
        //   149: dup
        //   150: aload #6
        //   152: invokespecial <init> : (Ljava/io/File;)V
        //   155: astore #4
        //   157: new java/io/BufferedInputStream
        //   160: dup
        //   161: aload #4
        //   163: invokespecial <init> : (Ljava/io/InputStream;)V
        //   166: astore #6
        //   168: new java/lang/StringBuffer
        //   171: dup
        //   172: invokespecial <init> : ()V
        //   175: astore #7
        //   177: aload #6
        //   179: invokevirtual available : ()I
        //   182: ifeq -> 200
        //   185: aload #7
        //   187: aload #6
        //   189: invokevirtual read : ()I
        //   192: i2c
        //   193: invokevirtual append : (C)Ljava/lang/StringBuffer;
        //   196: pop
        //   197: goto -> 177
        //   200: aload #6
        //   202: invokevirtual close : ()V
        //   205: aload #4
        //   207: invokevirtual close : ()V
        //   210: new org/json/JSONArray
        //   213: dup
        //   214: aload #7
        //   216: invokevirtual toString : ()Ljava/lang/String;
        //   219: invokespecial <init> : (Ljava/lang/String;)V
        //   222: astore #4
        //   224: goto -> 504
        //   227: astore #4
        //   229: aload #4
        //   231: invokevirtual printStackTrace : ()V
        //   234: aload #5
        //   236: astore #4
        //   238: goto -> 504
        //   241: astore #4
        //   243: aload #4
        //   245: invokevirtual printStackTrace : ()V
        //   248: aload #5
        //   250: astore #4
        //   252: goto -> 504
        //   255: iload_2
        //   256: aload_1
        //   257: getfield data : Ljava/util/List;
        //   260: invokeinterface size : ()I
        //   265: if_icmpge -> 374
        //   268: aload_1
        //   269: getfield data : Ljava/util/List;
        //   272: iload_2
        //   273: invokeinterface get : (I)Ljava/lang/Object;
        //   278: checkcast com/soft/blued/ui/group/model/BluedMyGroupNotify
        //   281: astore #5
        //   283: aload_1
        //   284: getfield data : Ljava/util/List;
        //   287: iload_2
        //   288: invokeinterface get : (I)Ljava/lang/Object;
        //   293: checkcast com/soft/blued/ui/group/model/BluedMyGroupNotify
        //   296: invokevirtual getTimestamp : ()Ljava/lang/String;
        //   299: astore #6
        //   301: aload #4
        //   303: ifnull -> 352
        //   306: aload #4
        //   308: invokevirtual length : ()I
        //   311: ifle -> 352
        //   314: iconst_0
        //   315: istore_3
        //   316: iload_3
        //   317: aload #4
        //   319: invokevirtual length : ()I
        //   322: if_icmpge -> 352
        //   325: aload #6
        //   327: aload #4
        //   329: iload_3
        //   330: invokevirtual get : (I)Ljava/lang/Object;
        //   333: invokevirtual toString : ()Ljava/lang/String;
        //   336: invokevirtual equals : (Ljava/lang/Object;)Z
        //   339: ifeq -> 509
        //   342: aload #5
        //   344: ldc '1'
        //   346: invokevirtual setIs_read : (Ljava/lang/String;)V
        //   349: goto -> 509
        //   352: aload_0
        //   353: getfield a : Lcom/soft/blued/ui/group/GroupNotifyFragment;
        //   356: invokestatic e : (Lcom/soft/blued/ui/group/GroupNotifyFragment;)Ljava/util/List;
        //   359: aload #5
        //   361: invokeinterface add : (Ljava/lang/Object;)Z
        //   366: pop
        //   367: iload_2
        //   368: iconst_1
        //   369: iadd
        //   370: istore_2
        //   371: goto -> 255
        //   374: aload_0
        //   375: getfield a : Lcom/soft/blued/ui/group/GroupNotifyFragment;
        //   378: invokestatic f : (Lcom/soft/blued/ui/group/GroupNotifyFragment;)Lcom/soft/blued/ui/group/adapter/GroupNotifyAdapter;
        //   381: invokevirtual notifyDataSetChanged : ()V
        //   384: return
        //   385: aload_0
        //   386: getfield a : Lcom/soft/blued/ui/group/GroupNotifyFragment;
        //   389: invokestatic d : (Lcom/soft/blued/ui/group/GroupNotifyFragment;)I
        //   392: iconst_1
        //   393: if_icmpne -> 450
        //   396: aload_0
        //   397: getfield a : Lcom/soft/blued/ui/group/GroupNotifyFragment;
        //   400: invokestatic e : (Lcom/soft/blued/ui/group/GroupNotifyFragment;)Ljava/util/List;
        //   403: invokeinterface clear : ()V
        //   408: aload_0
        //   409: getfield a : Lcom/soft/blued/ui/group/GroupNotifyFragment;
        //   412: invokestatic f : (Lcom/soft/blued/ui/group/GroupNotifyFragment;)Lcom/soft/blued/ui/group/adapter/GroupNotifyAdapter;
        //   415: invokevirtual notifyDataSetChanged : ()V
        //   418: aload_0
        //   419: getfield a : Lcom/soft/blued/ui/group/GroupNotifyFragment;
        //   422: invokestatic a : (Lcom/soft/blued/ui/group/GroupNotifyFragment;)Lcom/blued/android/framework/view/pulltorefresh/RenrenPullToRefreshListView;
        //   425: bipush #8
        //   427: invokevirtual setVisibility : (I)V
        //   430: aload_0
        //   431: getfield a : Lcom/soft/blued/ui/group/GroupNotifyFragment;
        //   434: invokestatic g : (Lcom/soft/blued/ui/group/GroupNotifyFragment;)Lcom/soft/blued/customview/CommonTopTitleNoTrans;
        //   437: invokevirtual a : ()V
        //   440: aload_0
        //   441: getfield a : Lcom/soft/blued/ui/group/GroupNotifyFragment;
        //   444: invokestatic h : (Lcom/soft/blued/ui/group/GroupNotifyFragment;)Lcom/soft/blued/customview/NoDataAndLoadFailView;
        //   447: invokevirtual a : ()V
        //   450: aload_0
        //   451: getfield a : Lcom/soft/blued/ui/group/GroupNotifyFragment;
        //   454: invokestatic d : (Lcom/soft/blued/ui/group/GroupNotifyFragment;)I
        //   457: iconst_1
        //   458: if_icmpeq -> 469
        //   461: aload_0
        //   462: getfield a : Lcom/soft/blued/ui/group/GroupNotifyFragment;
        //   465: invokestatic i : (Lcom/soft/blued/ui/group/GroupNotifyFragment;)I
        //   468: pop
        //   469: aload_0
        //   470: getfield a : Lcom/soft/blued/ui/group/GroupNotifyFragment;
        //   473: invokestatic a : (Lcom/soft/blued/ui/group/GroupNotifyFragment;)Lcom/blued/android/framework/view/pulltorefresh/RenrenPullToRefreshListView;
        //   476: invokevirtual p : ()V
        //   479: return
        //   480: astore_1
        //   481: aload_1
        //   482: invokevirtual printStackTrace : ()V
        //   485: aload_0
        //   486: getfield a : Lcom/soft/blued/ui/group/GroupNotifyFragment;
        //   489: invokestatic j : (Lcom/soft/blued/ui/group/GroupNotifyFragment;)Landroid/content/Context;
        //   492: invokevirtual getResources : ()Landroid/content/res/Resources;
        //   495: ldc 2131756082
        //   497: invokevirtual getString : (I)Ljava/lang/String;
        //   500: invokestatic a : (Ljava/lang/CharSequence;)V
        //   503: return
        //   504: iconst_0
        //   505: istore_2
        //   506: goto -> 255
        //   509: iload_3
        //   510: iconst_1
        //   511: iadd
        //   512: istore_3
        //   513: goto -> 316
        // Exception table:
        //   from	to	target	type
        //   4	41	480	java/lang/Exception
        //   44	63	480	java/lang/Exception
        //   63	110	480	java/lang/Exception
        //   113	134	480	java/lang/Exception
        //   138	177	241	java/io/IOException
        //   138	177	480	java/lang/Exception
        //   177	197	241	java/io/IOException
        //   177	197	480	java/lang/Exception
        //   200	210	241	java/io/IOException
        //   200	210	480	java/lang/Exception
        //   210	224	227	org/json/JSONException
        //   210	224	241	java/io/IOException
        //   210	224	480	java/lang/Exception
        //   229	234	241	java/io/IOException
        //   229	234	480	java/lang/Exception
        //   243	248	480	java/lang/Exception
        //   255	301	480	java/lang/Exception
        //   306	314	480	java/lang/Exception
        //   316	349	480	java/lang/Exception
        //   352	367	480	java/lang/Exception
        //   374	384	480	java/lang/Exception
        //   385	450	480	java/lang/Exception
        //   450	469	480	java/lang/Exception
        //   469	479	480	java/lang/Exception
      }
      
      public void onFailure(Throwable param1Throwable, int param1Int, String param1String) {
        super.onFailure(param1Throwable, param1Int, param1String);
        Logger.a(GroupNotifyFragment.c(this.a), new Object[] { "onFailure, error:", param1Throwable });
      }
      
      public void onUIFinish() {
        Logger.a(GroupNotifyFragment.c(this.a), new Object[] { "onUIFinish" });
        GroupNotifyFragment.a(this.a).j();
        GroupNotifyFragment.a(this.a).q();
      }
    };
  
  private String f = GroupNotifyFragment.class.getSimpleName();
  
  private CommonTopTitleNoTrans g;
  
  private RenrenPullToRefreshListView h;
  
  private NoDataAndLoadFailView i;
  
  private ListView j;
  
  private List<BluedMyGroupNotify> k;
  
  private int l = 1;
  
  private int m = 20;
  
  private boolean n = true;
  
  private GroupNotifyAdapter o;
  
  private View p;
  
  private Context q;
  
  private Dialog r;
  
  private int s;
  
  private short t;
  
  private String u;
  
  private void a() {
    Bundle bundle = getArguments();
    if (bundle != null) {
      this.s = (int)bundle.getLong("passby_session_id");
      this.t = bundle.getShort("passby_session_type");
      ChatManager.getInstance().ignoredNoReadNum(this.t, this.s);
      ChatManager.getInstance().deleteLocalChatting(this.t, this.s);
    } 
  }
  
  private void a(boolean paramBoolean) {
    if (paramBoolean)
      this.l = 1; 
    if (this.l == 1)
      this.n = true; 
    if (!this.n) {
      int i = this.l;
      if (i != 1) {
        this.l = i - 1;
        AppMethods.a(getResources().getString(2131756083));
        return;
      } 
    } 
    Context context = this.q;
    BluedUIHttpResponse bluedUIHttpResponse = this.e;
    String str1 = UserInfo.a().i().getUid();
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append(this.l);
    stringBuilder1.append("");
    String str2 = stringBuilder1.toString();
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(this.m);
    stringBuilder2.append("");
    GroupHttpUtils.a(context, bluedUIHttpResponse, str1, str2, stringBuilder2.toString(), (IRequestHost)w_());
  }
  
  private void k() {
    this.r = DialogUtils.a(this.q);
    this.k = new ArrayList<BluedMyGroupNotify>();
    this.h = (RenrenPullToRefreshListView)this.p.findViewById(2131299334);
    this.h.setRefreshEnabled(true);
    this.h.setOnPullDownListener(new MyPullDownListener());
    this.j = (ListView)this.h.getRefreshableView();
    this.j.setDivider(null);
    this.j.setSelector((Drawable)new ColorDrawable(0));
    this.h.postDelayed(new Runnable(this) {
          public void run() {
            GroupNotifyFragment.a(this.a).k();
          }
        },  100L);
    this.i = (NoDataAndLoadFailView)this.p.findViewById(2131298988);
    this.o = new GroupNotifyAdapter(this.q, this.k, (IRequestHost)w_());
    this.j.setAdapter((ListAdapter)this.o);
  }
  
  private void l() {
    this.g = (CommonTopTitleNoTrans)this.p.findViewById(2131300300);
    this.g.a();
    this.g.setCenterText(getString(2131756749));
    this.g.setLeftClickListener(this);
    this.g.setRightClickListener(this);
    this.g.setRightText(getString(2131756755));
  }
  
  private void m() {
    ChatManager.getInstance().deleteSessionAndChatting(Short.valueOf(this.t), this.s);
    GroupHttpUtils.j((Context)getActivity(), new BluedUIHttpResponse<BluedEntity>(this) {
          public void onUIFinish() {
            super.onUIFinish();
            DialogUtils.b(GroupNotifyFragment.k(this.a));
          }
          
          public void onUIStart() {
            super.onUIStart();
            DialogUtils.a(GroupNotifyFragment.k(this.a));
          }
          
          public void onUIUpdate(BluedEntity param1BluedEntity) {
            try {
              GroupNotifyFragment.a(this.a).setVisibility(8);
              GroupNotifyFragment.h(this.a).a();
              GroupNotifyFragment.g(this.a).a();
              GroupNotifyFragment.a(this.a, "");
              return;
            } catch (Exception exception) {
              exception.printStackTrace();
              return;
            } 
          }
        }UserInfo.a().i().getUid(), (IRequestHost)w_());
  }
  
  private void n() {
    GroupHttpUtils.i(this.q, new BluedUIHttpResponse<BluedEntity>(this) {
          public void onUIUpdate(BluedEntity param1BluedEntity) {}
        },  UserInfo.a().i().getUid(), this.u, (IRequestHost)w_());
  }
  
  private void o() {
    File file = new File(getActivity().getFilesDir(), "groupnofyalread");
    try {
      JSONArray jSONArray = new JSONArray();
      for (int i = 0; i < this.k.size(); i++)
        jSONArray.put(((BluedMyGroupNotify)this.k.get(i)).getTimestamp()); 
      FileOutputStream fileOutputStream = new FileOutputStream(file);
      fileOutputStream.write(jSONArray.toString().getBytes());
      fileOutputStream.close();
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
    if (!TextUtils.isEmpty(this.u))
      n(); 
    getActivity().finish();
  }
  
  private void p() {
    Context context = this.q;
    CommonAlertDialog.a(context, "", context.getResources().getString(2131756756), this.q.getResources().getString(2131756086), new DialogInterface.OnClickListener(this) {
          public void onClick(DialogInterface param1DialogInterface, int param1Int) {
            GroupNotifyFragment.l(this.a);
          }
        },  null, null, null);
  }
  
  public boolean V_() {
    o();
    return super.V_();
  }
  
  public void onClick(View paramView) {
    int i = paramView.getId();
    if (i != 2131296863) {
      if (i != 2131296867)
        return; 
      p();
      return;
    } 
    o();
  }
  
  public void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    this.q = (Context)getActivity();
    View view = this.p;
    if (view == null) {
      this.p = paramLayoutInflater.inflate(2131493144, paramViewGroup, false);
      a();
      k();
      l();
    } else if (view.getParent() != null) {
      ((ViewGroup)this.p.getParent()).removeView(this.p);
    } 
    return this.p;
  }
  
  class MyPullDownListener implements RenrenPullToRefreshListView.OnPullDownListener {
    private MyPullDownListener(GroupNotifyFragment this$0) {}
    
    public void a() {
      GroupNotifyFragment.a(this.a, 1);
      GroupNotifyFragment.a(this.a, false);
    }
    
    public void b() {
      GroupNotifyFragment.b(this.a);
      GroupNotifyFragment.a(this.a, false);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\group\GroupNotifyFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */