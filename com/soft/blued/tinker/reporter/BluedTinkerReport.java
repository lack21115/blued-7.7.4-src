package com.soft.blued.tinker.reporter;

import com.soft.blued.tinker.util.Utils;
import com.tencent.tinker.lib.util.TinkerLog;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;

public class BluedTinkerReport {
  private static Reporter a;
  
  public static void a() {
    Reporter reporter = a;
    if (reporter == null)
      return; 
    reporter.a(309);
  }
  
  public static void a(int paramInt) {
    Reporter reporter = a;
    if (reporter == null)
      return; 
    switch (paramInt) {
      default:
        switch (paramInt) {
          default:
            return;
          case -1:
            reporter.a(71);
            return;
          case -2:
            reporter.a(74);
            return;
          case -3:
            reporter.a(72);
            return;
          case -4:
            reporter.a(73);
            return;
          case -5:
            reporter.a(81);
            return;
          case -6:
            break;
        } 
        reporter.a(77);
        return;
      case -20:
        reporter.a(75);
        return;
      case -21:
        reporter.a(76);
        return;
      case -22:
        reporter.a(78);
        return;
      case -23:
        reporter.a(79);
        return;
      case -24:
        break;
    } 
    reporter.a(80);
  }
  
  public static void a(int paramInt, Throwable paramThrowable) {
    Reporter reporter = a;
    if (reporter == null)
      return; 
    if (paramInt != 0) {
      if (paramInt != 1) {
        if (paramInt != 2)
          return; 
        reporter.a(451);
        reporter = a;
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("Tinker Exception:interpret occur exception ");
        stringBuilder1.append(Utils.b(paramThrowable));
        reporter.a(stringBuilder1.toString());
        return;
      } 
      reporter.a(450);
      reporter = a;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Tinker Exception:interpret occur exception ");
      stringBuilder.append(Utils.b(paramThrowable));
      reporter.a(stringBuilder.toString());
      return;
    } 
    reporter.a(452);
  }
  
  public static void a(long paramLong) {
    Reporter reporter = a;
    if (reporter == null)
      return; 
    reporter.a(6);
    if (paramLong < 0L) {
      TinkerLog.e("Tinker.BluedTinkerReport", "hp_report report load cost failed, invalid cost", new Object[0]);
      return;
    } 
    if (paramLong <= 500L) {
      a.a(400);
      return;
    } 
    if (paramLong <= 1000L) {
      a.a(401);
      return;
    } 
    if (paramLong <= 3000L) {
      a.a(402);
      return;
    } 
    if (paramLong <= 5000L) {
      a.a(403);
      return;
    } 
    a.a(404);
  }
  
  public static void a(long paramLong, boolean paramBoolean) {
    Reporter reporter = a;
    if (reporter == null)
      return; 
    if (paramBoolean)
      reporter.a(5); 
    if (paramBoolean) {
      a.a(100);
    } else {
      a.a(101);
    } 
    TinkerLog.i("Tinker.BluedTinkerReport", "hp_report report apply cost = %d", new Object[] { Long.valueOf(paramLong) });
    if (paramLong < 0L) {
      TinkerLog.e("Tinker.BluedTinkerReport", "hp_report report apply cost failed, invalid cost", new Object[0]);
      return;
    } 
    if (paramLong <= 5000L) {
      if (paramBoolean) {
        a.a(200);
        return;
      } 
      a.a(205);
      return;
    } 
    if (paramLong <= 10000L) {
      if (paramBoolean) {
        a.a(201);
        return;
      } 
      a.a(206);
      return;
    } 
    if (paramLong <= 30000L) {
      if (paramBoolean) {
        a.a(202);
        return;
      } 
      a.a(207);
      return;
    } 
    if (paramLong <= 60000L) {
      if (paramBoolean) {
        a.a(203);
        return;
      } 
      a.a(208);
      return;
    } 
    if (paramBoolean) {
      a.a(204);
      return;
    } 
    a.a(209);
  }
  
  public static void a(Throwable paramThrowable) {
    if (a == null)
      return; 
    if (paramThrowable.getMessage().contains("checkDexOptExist failed")) {
      a.a(122);
      return;
    } 
    if (paramThrowable.getMessage().contains("checkDexOptFormat failed")) {
      a.a(123);
      return;
    } 
    a.a(121);
    Reporter reporter = a;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Tinker Exception:apply tinker occur exception ");
    stringBuilder.append(Utils.b(paramThrowable));
    reporter.a(stringBuilder.toString());
  }
  
  public static void a(Throwable paramThrowable, int paramInt) {
    Reporter reporter = a;
    if (reporter == null)
      return; 
    boolean bool = true;
    if (paramInt != -4) {
      if (paramInt != -3) {
        if (paramInt != -2) {
          if (paramInt == -1)
            reporter.a(250); 
        } else {
          if (paramThrowable.getMessage().contains("checkDexInstall failed")) {
            a.a(253);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("tinker dex check fail:");
            stringBuilder.append(paramThrowable.getMessage());
            TinkerLog.e("Tinker.BluedTinkerReport", stringBuilder.toString(), new Object[0]);
            paramInt = bool;
          } else {
            a.a(252);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("tinker dex reflect fail:");
            stringBuilder.append(paramThrowable.getMessage());
            TinkerLog.e("Tinker.BluedTinkerReport", stringBuilder.toString(), new Object[0]);
            paramInt = 0;
          } 
          if (paramInt == 0) {
            reporter = a;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Tinker Exception:load tinker occur exception ");
            stringBuilder.append(Utils.b(paramThrowable));
            reporter.a(stringBuilder.toString());
          } 
        } 
      } else {
        if (paramThrowable.getMessage().contains("checkResInstall failed")) {
          a.a(255);
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("tinker res check fail:");
          stringBuilder.append(paramThrowable.getMessage());
          TinkerLog.e("Tinker.BluedTinkerReport", stringBuilder.toString(), new Object[0]);
          paramInt = bool;
        } else {
          a.a(254);
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("tinker res reflect fail:");
          stringBuilder.append(paramThrowable.getMessage());
          TinkerLog.e("Tinker.BluedTinkerReport", stringBuilder.toString(), new Object[0]);
          paramInt = 0;
        } 
        if (paramInt == 0) {
          reporter = a;
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("Tinker Exception:load tinker occur exception ");
          stringBuilder.append(Utils.b(paramThrowable));
          reporter.a(stringBuilder.toString());
        } 
      } 
    } else {
      reporter.a(251);
    } 
    paramInt = 0;
  }
  
  public static void a(boolean paramBoolean) {
    Reporter reporter = a;
    if (reporter == null)
      return; 
    reporter.a(2);
    a.a(70);
    if (paramBoolean)
      a.a(3); 
  }
  
  public static void b() {
    Reporter reporter = a;
    if (reporter == null)
      return; 
    reporter.a(4);
  }
  
  public static void b(int paramInt) {
    Reporter reporter = a;
    if (reporter == null)
      return; 
    switch (paramInt) {
      default:
        return;
      case -1:
        reporter.a(350);
        return;
      case -2:
        reporter.a(356);
        return;
      case -3:
        reporter.a(351);
        return;
      case -4:
        reporter.a(352);
        return;
      case -5:
        reporter.a(353);
        return;
      case -6:
        reporter.a(354);
        return;
      case -7:
        reporter.a(355);
        return;
      case -8:
        reporter.a(357);
        return;
      case -9:
        break;
    } 
    reporter.a(358);
  }
  
  public static void b(Throwable paramThrowable) {
    Reporter reporter = a;
    if (reporter == null)
      return; 
    reporter.a(120);
    reporter = a;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Tinker Exception:apply tinker occur exception ");
    stringBuilder.append(Utils.b(paramThrowable));
    reporter.a(stringBuilder.toString());
  }
  
  public static void c() {
    Reporter reporter = a;
    if (reporter == null)
      return; 
    reporter.a(124);
  }
  
  public static void c(int paramInt) {
    Reporter reporter = a;
    if (reporter == null)
      return; 
    switch (paramInt) {
      default:
        return;
      case 6:
        reporter.a(308);
        return;
      case 5:
        reporter.a(304);
        return;
      case 4:
        reporter.a(307);
        return;
      case 3:
        reporter.a(303);
        return;
      case 2:
        reporter.a(306);
        return;
      case 1:
        break;
    } 
    reporter.a(305);
  }
  
  public static void d() {
    Reporter reporter = a;
    if (reporter == null)
      return; 
    reporter.a(180);
  }
  
  public static void d(int paramInt) {
    Reporter reporter = a;
    if (reporter == null)
      return; 
    if (paramInt != 3) {
      if (paramInt != 5) {
        if (paramInt != 6)
          return; 
        reporter.a(302);
        return;
      } 
      reporter.a(301);
      return;
    } 
    reporter.a(300);
  }
  
  public static void e() {
    Reporter reporter = a;
    if (reporter == null)
      return; 
    reporter.a(7);
  }
  
  public static void e(int paramInt) {
    Reporter reporter = a;
    if (reporter == null)
      return; 
    if (paramInt != 1) {
      if (paramInt != 3) {
        if (paramInt != 5) {
          if (paramInt != 6)
            return; 
          reporter.a(184);
          return;
        } 
        reporter.a(183);
        return;
      } 
      reporter.a(182);
      return;
    } 
    reporter.a(181);
  }
  
  public static void f() {
    if (a == null)
      return; 
    if (ShareTinkerInternals.isVmArt()) {
      a.a(9);
      return;
    } 
    a.a(8);
  }
  
  public static void f(int paramInt) {
    if (a == null)
      return; 
    TinkerLog.i("Tinker.BluedTinkerReport", "hp_report package check failed, error = %d", new Object[] { Integer.valueOf(paramInt) });
    switch (paramInt) {
      default:
        return;
      case -1:
        a.a(150);
        return;
      case -2:
        a.a(155);
        return;
      case -3:
        a.a(151);
        return;
      case -4:
        a.a(152);
        return;
      case -5:
        a.a(153);
        return;
      case -6:
        a.a(154);
        return;
      case -7:
        a.a(156);
        return;
      case -8:
        a.a(157);
        return;
      case -9:
        break;
    } 
    a.a(158);
  }
  
  public static void g() {
    Reporter reporter = a;
    if (reporter == null)
      return; 
    reporter.a(10);
  }
  
  public void a(Reporter paramReporter) {
    a = paramReporter;
  }
  
  public static interface Reporter {
    void a(int param1Int);
    
    void a(String param1String);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\tinker\reporter\BluedTinkerReport.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */