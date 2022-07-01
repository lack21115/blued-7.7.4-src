package com.soft.blued.ui.circle.fragment;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import com.blued.android.core.AppMethods;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.das.client.feed.FeedProtos;
import com.soft.blued.db.model.NewFeedModel;
import com.soft.blued.log.trackUtils.EventTrackFeed;
import com.soft.blued.ui.circle.model.CircleBubble;
import com.soft.blued.ui.circle.model.CircleMethods;
import com.soft.blued.ui.circle.view.CircleTextVoteView;
import com.soft.blued.ui.feed.fragment.FeedPostFragment;
import com.soft.blued.ui.feed.model.CircleTextVote;
import com.soft.blued.utils.PopMenuUtils;
import com.soft.blued.view.tip.CommonAlertDialog;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CircleAddPostFragment extends FeedPostFragment {
  private ImageView aF;
  
  private TextView aG;
  
  private FrameLayout aH;
  
  private CircleTextVoteView aI;
  
  private ImageView aJ;
  
  private ConstraintLayout aK;
  
  private CheckBox aL;
  
  private ImageView aM;
  
  private TextView aN;
  
  private CheckBox aO;
  
  private int aP = -1;
  
  private String aQ;
  
  private String aR;
  
  private String aS;
  
  private boolean aT = false;
  
  private String aU;
  
  private List<CircleTextVote> aV;
  
  private void K() {
    Bundle bundle = getArguments();
    if (bundle != null) {
      this.aQ = bundle.getString("circle_id");
      this.aS = bundle.getString("circle_name");
      this.aR = bundle.getString("circle_header");
    } 
    if (this.an != null) {
      boolean bool;
      this.aQ = this.an.circle_id;
      this.aS = this.an.circle_title;
      this.aR = this.an.circle_header;
      CheckBox checkBox = this.aL;
      if (this.an.is_anonym == 1) {
        bool = true;
      } else {
        bool = false;
      } 
      checkBox.setChecked(bool);
      checkBox = this.aO;
      if (this.an.anonym_comment == 1) {
        bool = true;
      } else {
        bool = false;
      } 
      checkBox.setChecked(bool);
      this.aP = this.an.anonym_avatar;
      if (this.an.is_posts_vote == 1) {
        this.aT = true;
        this.aU = this.an.posts_vote_title;
        this.aV = new ArrayList<CircleTextVote>();
        for (String str : this.an.option.split(";"))
          this.aV.add(new CircleTextVote(str)); 
        this.aH.setVisibility(0);
        this.aI.setOptionTitle(this.aU);
        this.aI.setOptionList(this.aV);
      } 
    } 
    this.aG.setText(this.aS);
    if (!TextUtils.isEmpty(this.aR)) {
      this.aF.setVisibility(0);
      ImageLoader.a((IRequestHost)w_(), this.aR).a(3.0F).a(this.aF);
    } else {
      this.aF.setVisibility(8);
    } 
    if (this.aP < 0)
      this.aP = CircleMethods.getAnonymousHeaderNumber(this.e); 
    this.aM.setImageResource(CircleMethods.getAnonymousHeaderRes(this.e, this.aP));
    if (bundle != null) {
      CircleBubble circleBubble = (CircleBubble)bundle.getSerializable("circle_bubble");
      if (circleBubble != null)
        a(circleBubble.getMarkDownLink()); 
    } 
  }
  
  private void L() {
    this.aF = (ImageView)this.f.findViewById(2131297804);
    this.aG = (TextView)this.f.findViewById(2131301409);
    this.K.setVisibility(8);
    this.aH = (FrameLayout)this.f.findViewById(2131298096);
    this.aI = (CircleTextVoteView)this.f.findViewById(2131296751);
    this.aJ = (ImageView)this.f.findViewById(2131297942);
    this.aI.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            CircleAddPostFragment circleAddPostFragment = this.a;
            CircleTextVoteEditFragment.a((Fragment)circleAddPostFragment, 111, CircleAddPostFragment.a(circleAddPostFragment), CircleAddPostFragment.b(this.a));
          }
        });
    this.aJ.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            CircleAddPostFragment.a(this.a, false);
            CircleAddPostFragment.a(this.a, (String)null);
            CircleAddPostFragment.a(this.a, (List)null);
            CircleAddPostFragment.c(this.a).setVisibility(8);
            CircleAddPostFragment.d(this.a);
          }
        });
    this.aK = (ConstraintLayout)this.f.findViewById(2131296756);
    this.aL = (CheckBox)this.f.findViewById(2131296667);
    this.aM = (ImageView)this.f.findViewById(2131297682);
    this.aN = (TextView)this.f.findViewById(2131300517);
    this.aO = (CheckBox)this.f.findViewById(2131296666);
    this.aK.setVisibility(0);
    this.aL.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(this) {
          public void onCheckedChanged(CompoundButton param1CompoundButton, boolean param1Boolean) {
            byte b;
            ImageView imageView = CircleAddPostFragment.e(this.a);
            if (param1Boolean) {
              b = 0;
            } else {
              b = 8;
            } 
            imageView.setVisibility(b);
          }
        });
    this.aN.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            AnonymousHelpDialogFragment.a(this.a.getFragmentManager());
          }
        });
  }
  
  public static Bundle a(String paramString1, String paramString2, String paramString3) {
    Bundle bundle = new Bundle();
    bundle.putString("circle_id", paramString1);
    bundle.putString("circle_name", paramString2);
    bundle.putString("circle_header", paramString3);
    return bundle;
  }
  
  public static void a(Context paramContext, NewFeedModel paramNewFeedModel) {
    if (PopMenuUtils.a(paramContext))
      return; 
    Bundle bundle = new Bundle();
    bundle.putSerializable("feed_send_data", (Serializable)paramNewFeedModel);
    TerminalActivity.d(paramContext, CircleAddPostFragment.class, bundle);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, String paramString3) {
    if (PopMenuUtils.a(paramContext))
      return; 
    if (TextUtils.isEmpty(paramString1))
      return; 
    TerminalActivity.d(paramContext, CircleAddPostFragment.class, a(paramString1, paramString2, paramString3));
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, String paramString3, CircleBubble paramCircleBubble) {
    if (PopMenuUtils.a(paramContext))
      return; 
    if (TextUtils.isEmpty(paramString1))
      return; 
    Bundle bundle = a(paramString1, paramString2, paramString3);
    bundle.putSerializable("circle_bubble", (Serializable)paramCircleBubble);
    TerminalActivity.d(paramContext, CircleAddPostFragment.class, bundle);
  }
  
  public boolean A() {
    return (super.A() || this.aT);
  }
  
  public int B() {
    return 2000;
  }
  
  public boolean C() {
    return super.C();
  }
  
  public boolean D() {
    return super.D();
  }
  
  public FeedProtos.FeedType E() {
    return FeedProtos.FeedType.CIRCLE_NOTE;
  }
  
  public boolean F() {
    return false;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 == -1) {
      if (paramInt1 != 111)
        return; 
      if (paramIntent != null) {
        String str = paramIntent.getStringExtra("circle_vote_title");
        List<CircleTextVote> list = (List)paramIntent.getSerializableExtra("circle_vote_content");
        if (!TextUtils.isEmpty(str) && list != null) {
          this.aT = true;
          this.aU = str;
          this.aV = list;
          this.aH.setVisibility(0);
          this.aI.setOptionTitle(this.aU);
          this.aI.setOptionList(this.aV);
          AppMethods.d(2131755948);
        } 
      } 
    } 
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    View view = super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    L();
    K();
    J();
    return view;
  }
  
  public void t() {}
  
  public void u() {}
  
  public void v() {
    EventTrackFeed.b(FeedProtos.Event.CIRCLE_NOTE_VOTE_ICON_CLICK);
    CircleTextVoteEditFragment.a((Fragment)this, 111, this.aU, this.aV);
  }
  
  public void w() {
    throw new RuntimeException("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void x() {
    CommonAlertDialog.a((Context)getActivity(), getResources().getString(2131756931), getResources().getString(2131755915), getResources().getString(2131756127), null, getResources().getString(2131756598), new DialogInterface.OnClickListener(this) {
          public void onClick(DialogInterface param1DialogInterface, int param1Int) {
            CircleAddPostFragment.f(this.a);
            this.a.a(new Runnable(this) {
                  public void run() {
                    this.a.a.getActivity().finish();
                  }
                },  200L);
          }
        }null);
  }
  
  public boolean y() {
    boolean bool = TextUtils.isEmpty(this.r.getText().toString().trim());
    return (this.ax && this.ay != null) ? true : (this.aT ? (bool ^ true) : super.y());
  }
  
  public boolean z() {
    if (this.aT) {
      AppMethods.d(2131755952);
      return true;
    } 
    return super.z();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\circle\fragment\CircleAddPostFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */