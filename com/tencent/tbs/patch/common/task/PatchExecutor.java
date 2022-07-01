package com.tencent.tbs.patch.common.task;

import java.util.ArrayDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class PatchExecutor {
  private static final int a = 0;
  
  private static final int b = 0;
  
  private static volatile BlockingQueue<Runnable> c;
  
  private static volatile Executor d;
  
  private static volatile ThreadFactory e;
  
  private static volatile Executor f;
  
  static {
    Runtime.getRuntime();
    throw new VerifyError("bad dex opcode");
  }
  
  public static Executor getParallelExecutor() {
    return d;
  }
  
  public static Executor getSerialExecutor() {
    return f;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued209820-dex2jar.jar!\com\tencent\tbs\patch\common\task\PatchExecutor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */