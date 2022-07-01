package com.qq.e.comm.plugin.w.a;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import com.qq.e.comm.plugin.a.c;
import com.qq.e.comm.plugin.w.c;
import com.qq.e.comm.util.GDTLogger;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import org.json.JSONObject;
import yaq.gdtadv;

public class f {
  private static final Object a = new Object();
  
  private static boolean b = false;
  
  private static Map<String, Future<JSONObject>> c = new LinkedHashMap<String, Future<JSONObject>>();
  
  private static int a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean) {
    return gdtadv.getIresult(87, 1, new Object[] { paramContext, paramString1, paramString2, paramString3, paramString4, Boolean.valueOf(paramBoolean) });
  }
  
  private static c a(d.a parama, d.e parame, JSONObject paramJSONObject1, JSONObject paramJSONObject2, boolean paramBoolean) {
    return (c)gdtadv.getobjresult(88, 1, new Object[] { parama, parame, paramJSONObject1, paramJSONObject2, Boolean.valueOf(paramBoolean) });
  }
  
  private static String a(int paramInt) {
    return (String)gdtadv.getobjresult(90, 1, new Object[] { Integer.valueOf(paramInt) });
  }
  
  private static String a(Future<JSONObject> paramFuture) {
    return (String)gdtadv.getobjresult(91, 1, new Object[] { paramFuture });
  }
  
  public static void a(Context paramContext, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2) {
    gdtadv.getVresult(93, 1, new Object[] { paramContext, paramOnClickListener1, paramOnClickListener2 });
  }
  
  static void a(Context paramContext, d.a parama, Future<JSONObject> paramFuture, String paramString) {
    gdtadv.getVresult(94, 1, new Object[] { paramContext, parama, paramFuture, paramString });
  }
  
  public static void a(d.a parama) {
    gdtadv.getVresult(95, 1, new Object[] { parama });
  }
  
  private static void a(d.a parama, Future<JSONObject> paramFuture) {
    gdtadv.getVresult(96, 1, new Object[] { parama, paramFuture });
  }
  
  private static boolean a(Context paramContext, d.a parama, Future<JSONObject> paramFuture, boolean paramBoolean) {
    return gdtadv.getZresult(98, 1, new Object[] { paramContext, parama, paramFuture, Boolean.valueOf(paramBoolean) });
  }
  
  static <T> boolean a(Context paramContext, T paramT, d.a parama, d.b paramb, d.e parame) {
    return gdtadv.getZresult(99, 1, new Object[] { paramContext, paramT, parama, paramb, parame });
  }
  
  static <T> boolean a(T paramT, Context paramContext, d.a parama, d.b paramb, d.e parame) {
    return gdtadv.getZresult(100, 1, new Object[] { paramT, paramContext, parama, paramb, parame });
  }
  
  private static <T> boolean a(T paramT, Context paramContext, d.a parama, d.b paramb, d.e parame, int paramInt, Future<JSONObject> paramFuture) {
    return gdtadv.getZresult(101, 1, new Object[] { paramT, paramContext, parama, paramb, parame, Integer.valueOf(paramInt), paramFuture });
  }
  
  private static boolean a(JSONObject paramJSONObject, String paramString, d.e parame) {
    return gdtadv.getZresult(102, 1, new Object[] { paramJSONObject, paramString, parame });
  }
  
  private static <T> Boolean b(T paramT, Context paramContext, int paramInt) {
    return (Boolean)gdtadv.getobjresult(103, 1, new Object[] { paramT, paramContext, Integer.valueOf(paramInt) });
  }
  
  private static Future<JSONObject> b(d.a parama) {
    return (Future<JSONObject>)gdtadv.getobjresult(104, 1, new Object[] { parama });
  }
  
  private static JSONObject b(d.a parama, d.b paramb, d.e parame) {
    return (JSONObject)gdtadv.getobjresult(105, 1, new Object[] { parama, paramb, parame });
  }
  
  static <T> boolean b(T paramT, Context paramContext, d.a parama, d.b paramb, d.e parame) {
    return gdtadv.getZresult(107, 1, new Object[] { paramT, paramContext, parama, paramb, parame });
  }
  
  private static Future<JSONObject> c(d.a parama, d.b paramb, d.e parame) {
    return (Future<JSONObject>)gdtadv.getobjresult(108, 1, new Object[] { parama, paramb, parame });
  }
  
  private static void c(Exchanger<Boolean> paramExchanger) {
    gdtadv.getVresult(109, 1, new Object[] { paramExchanger });
  }
  
  private static void d(Exchanger<Boolean> paramExchanger) {
    gdtadv.getVresult(110, 1, new Object[] { paramExchanger });
  }
  
  static class a {
    private static final ExecutorService a = Executors.newCachedThreadPool();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\w\a\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */