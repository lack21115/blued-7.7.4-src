package com.tencent.tbs.patch.applier;

import com.tencent.tbs.patch.common.PatchException;
import com.tencent.tbs.patch.common.ZipWriteHelper;
import com.tencent.tbs.patch.common.patch.DeltaFormat;
import com.tencent.tbs.patch.common.patch.FileHolder;
import com.tencent.tbs.patch.common.patch.PatchDelta;
import com.tencent.tbs.patch.common.patch.PatchResultExplainer;
import com.tencent.tbs.patch.common.patch.PatchStatus;
import com.tencent.tbs.patch.common.task.CompletionTask;
import com.tencent.tbs.patch.common.task.DelegatedTask;
import com.tencent.tbs.patch.common.task.PatchExecutor;
import com.tencent.tbs.patch.common.task.Task;
import com.tencent.tbs.patch.common.task.TaskRunner;
import com.tencent.tbs.patch.common.task.ThreadPoolTaskRunner;
import com.tencent.tbs.patch.common.util.DigestProcessor;
import com.tencent.tbs.patch.common.util.FileUtils;
import com.tencent.tbs.patch.common.util.PatchLogger;
import com.tencent.tbs.patch.common.util.StringUtils;
import com.tencent.tbs.patch.common.zip.ZipSealer;
import java.io.Closeable;
import java.io.File;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;

public class PackageDeltaApplier extends a<ApplierConfig> {
  private final Map<String, PatchResultExplainer> b = new ConcurrentHashMap<String, PatchResultExplainer>();
  
  private b c;
  
  public PackageDeltaApplier(ApplierConfig paramApplierConfig) {
    super(paramApplierConfig);
  }
  
  private Task a(Map<String, PatchDelta> paramMap, b paramb) {
    CompletionTask completionTask = new CompletionTask();
    Iterator<String> iterator = paramMap.keySet().iterator();
    while (iterator.hasNext()) {
      String str1 = iterator.next();
      FileHolder fileHolder1 = paramb.a(str1);
      FileHolder fileHolder2 = paramb.b(str1);
      if (fileHolder1 == null) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Name: ");
        stringBuilder.append(str1);
        String str = " from old package is null";
        stringBuilder.append(str);
        b(stringBuilder.toString());
        return null;
      } 
      if (fileHolder2 == null) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Name: ");
        stringBuilder.append(str1);
        String str = " from old patch is null";
        stringBuilder.append(str);
        b(stringBuilder.toString());
        return null;
      } 
      String str2 = FileUtils.getNameSuffix(str1);
      File file = FileUtils.makeTempFile(this.a.getTempDir(), str2);
      Task task = (new PackageDeltaApplier((new ApplierConfig.Builder()).sourceInput(fileHolder1.getPath()).patchInput(fileHolder2.getPath()).restoreOutput(file.getAbsolutePath()).tempDir(this.a.getTempDir()).create())).getApplyTask();
      a(str1, new PatchResultExplainer(str1, file.getAbsolutePath()));
      completionTask.dependsOn(task);
    } 
    return (Task)completionTask;
  }
  
  private void a() {
    String str;
    if (this.a == null) {
      str = "Null applier configuration!";
    } else {
      File file1 = new File(this.a.getSourceInput());
      File file2 = new File(this.a.getPatchInput());
      if (!file1.exists() || !file2.exists()) {
        str = "Source input or patch input does not exist!";
      } else {
        if (this.a.isSourceInputDir() && !str.isDirectory())
          b("The expected input type is directory type but a file type was set!"); 
        return;
      } 
    } 
    b(str);
  }
  
  private void a(b paramb) {
    if (this.a.isRestoreOutputDir())
      synchronized (this.b) {
        for (String str : this.b.keySet()) {
          File file = new File(this.a.getRestoreOutput());
          PatchResultExplainer patchResultExplainer = this.b.get(str);
          if (patchResultExplainer != null) {
            FileUtils.assertCopy(new File(patchResultExplainer.getPatchFilePath()), new File(file, str));
            continue;
          } 
          throw new PatchException("Unexpected write assemble error");
        } 
        return;
      }  
    a(paramb, this.a.getRestoreOutput());
    if (this.c.g()) {
      File file = FileUtils.makeTempFile(this.a.getTempDir(), ".zip");
      a(paramb, file.getAbsolutePath());
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Seal: ");
      stringBuilder.append(this.a.getRestoreOutput());
      PatchLogger.d(stringBuilder.toString());
      synchronized (this.b) {
        ZipSealer.seal(this.b, file.getAbsolutePath(), paramb.e(), paramb.d(), this.a.getRestoreOutput());
        FileUtils.delete(file);
        return;
      } 
    } 
  }
  
  private void a(b paramb, String paramString) {
    null = new ZipWriteHelper(paramString);
    null.open(paramb.f());
    synchronized (this.b) {
      for (String str : this.b.keySet()) {
        PatchResultExplainer patchResultExplainer = this.b.get(str);
        if (patchResultExplainer != null) {
          null.putFileEntry(str, patchResultExplainer.getPatchFilePath());
          continue;
        } 
        throw new PatchException("Unexpected write patch result error");
      } 
      null.flush();
      FileUtils.closeQuietly((Closeable)null);
      return;
    } 
  }
  
  private void a(String paramString, PatchResultExplainer paramPatchResultExplainer) {
    synchronized (this.b) {
      if (!this.b.containsKey(paramString)) {
        this.b.put(paramString, paramPatchResultExplainer);
      } else {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Name: ");
        stringBuilder.append(paramString);
        stringBuilder.append(" exist");
        PatchLogger.w(stringBuilder.toString());
      } 
      return;
    } 
  }
  
  private Task b(Map<String, PatchDelta> paramMap, b paramb) {
    return (Task)new DelegatedTask(this, paramMap, paramb) {
        public void run(Task param1Task) {
          for (String str : this.a.keySet()) {
            try {
              FileHolder fileHolder1 = this.b.a(str);
              FileHolder fileHolder2 = this.b.b(str);
              String str1 = FileUtils.getNameSuffix(str);
              File file = FileUtils.makeTempFile(this.c.a.getTempDir(), str1);
              ApplierConfig applierConfig = (new ApplierConfig.Builder()).sourceInput(fileHolder1.getPath()).patchInput(fileHolder2.getPath()).restoreOutput(file.getAbsolutePath()).tempDir(this.c.a.getTempDir()).create();
              PatchDelta patchDelta = (PatchDelta)this.a.get(str);
              if (patchDelta != null) {
                ELF32Applier eLF32Applier;
                BinaryApplier binaryApplier;
                if (patchDelta.getFormat() == DeltaFormat.ELF32) {
                  eLF32Applier = new ELF32Applier(applierConfig);
                } else {
                  binaryApplier = new BinaryApplier((BasicApplierConfig)eLF32Applier);
                } 
                binaryApplier.doApply();
                PatchResultExplainer patchResultExplainer = new PatchResultExplainer(str, file.getAbsolutePath());
                PackageDeltaApplier.a(this.c, str, patchResultExplainer);
              } 
            } catch (Exception exception) {
              fail(-1, exception.getMessage());
            } 
          } 
          finish();
        }
      };
  }
  
  private boolean b(b paramb) {
    Map<String, String> map = paramb.c();
    Iterator<String> iterator = map.keySet().iterator();
    while (iterator.hasNext()) {
      Map<String, PatchResultExplainer> map1;
      String str;
      null = iterator.next();
      synchronized (this.b) {
        PatchResultExplainer patchResultExplainer = this.b.get(null);
        if (patchResultExplainer != null) {
          StringBuilder stringBuilder1;
          if (!patchResultExplainer.isIncompatible()) {
            str = map.get(null);
            String str1 = DigestProcessor.getInstance().calcDigest(new File(patchResultExplainer.getPatchFilePath()));
            if (!StringUtils.isBlank(str1) && str1.equals(str)) {
              stringBuilder1 = new StringBuilder();
              stringBuilder1.append("Check: ");
              stringBuilder1.append(null);
              null = " OK";
            } else {
              PatchDelta patchDelta = this.c.b().get(null);
              StringBuilder stringBuilder2 = new StringBuilder();
              stringBuilder2.append("Check: ");
              stringBuilder2.append(null);
              stringBuilder2.append(": ");
              stringBuilder2.append(stringBuilder1.getPatchFilePath());
              stringBuilder2.append(" ");
              stringBuilder2.append(str1);
              stringBuilder2.append(", target is: ");
              stringBuilder2.append(str);
              stringBuilder2.append(", failed, patch status: ");
              if (patchDelta != null) {
                PatchStatus patchStatus = patchDelta.getStatus();
              } else {
                null = "null";
              } 
              stringBuilder2.append(null);
              PatchLogger.e(stringBuilder2.toString());
              return false;
            } 
          } else {
            stringBuilder1 = new StringBuilder();
            stringBuilder1.append("Check: ");
            stringBuilder1.append(null);
            null = " Skipped";
          } 
          stringBuilder1.append(null);
          PatchLogger.i(stringBuilder1.toString());
          continue;
        } 
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Cannot get patch result info, `");
        stringBuilder.append(null);
        stringBuilder.append("` not found, context: ");
        stringBuilder.append(this.a.toString());
        throw new PatchException(stringBuilder.toString());
      } 
    } 
    return true;
  }
  
  public void doApply() {
    a();
    loadLibraryIfNecessary();
    ThreadPoolTaskRunner threadPoolTaskRunner = new ThreadPoolTaskRunner(PatchExecutor.getParallelExecutor());
    threadPoolTaskRunner.run(getApplyTask());
    threadPoolTaskRunner.setListener(new TaskRunner.Listener(this) {
          public void onError(int param1Int, String param1String, Throwable param1Throwable) {
            PackageDeltaApplier packageDeltaApplier = this.a;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Error: ");
            stringBuilder.append(param1Int);
            stringBuilder.append(", detail: ");
            stringBuilder.append(param1String);
            packageDeltaApplier.b(stringBuilder.toString());
          }
          
          public void onFinished() {
            PackageDeltaApplier packageDeltaApplier = this.a;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("All task has finished: ");
            stringBuilder.append(this.a.a.getRestoreOutput());
            packageDeltaApplier.a(stringBuilder.toString());
          }
        });
  }
  
  public void doApplySync() {
    CountDownLatch countDownLatch = new CountDownLatch(1);
    setListener(new ApplierListener(this, countDownLatch) {
          public void onApplyFailed(String param1String) {
            this.a.countDown();
          }
          
          public void onApplyFinished(String param1String) {
            this.a.countDown();
          }
        });
    doApply();
    countDownLatch.await();
    FileUtils.deleteDir(new File(this.a.getTempDir()));
  }
  
  public Task getApplyTask() {
    this.c = new b();
    this.c.a(this.a);
    LinkedHashMap<Object, Object> linkedHashMap3 = new LinkedHashMap<Object, Object>();
    LinkedHashMap<Object, Object> linkedHashMap5 = new LinkedHashMap<Object, Object>();
    LinkedHashMap<Object, Object> linkedHashMap1 = new LinkedHashMap<Object, Object>();
    LinkedHashMap<Object, Object> linkedHashMap2 = new LinkedHashMap<Object, Object>();
    LinkedHashMap<Object, Object> linkedHashMap4 = new LinkedHashMap<Object, Object>();
    for (Map.Entry<String, PatchDelta> entry : this.c.b().entrySet()) {
      String str = (String)entry.getKey();
      PatchDelta patchDelta = (PatchDelta)entry.getValue();
      PatchStatus patchStatus = patchDelta.getStatus();
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(patchStatus);
      stringBuilder.append(": ");
      stringBuilder.append(str);
      PatchLogger.i(stringBuilder.toString());
      if (patchStatus == PatchStatus.ADDED || patchStatus == PatchStatus.REPLACED) {
        linkedHashMap3.put(str, patchDelta);
        continue;
      } 
      if (patchStatus == PatchStatus.MODIFIED) {
        if (this.c.h() && DeltaFormat.isPackageType(str)) {
          linkedHashMap2.put(str, patchDelta);
          continue;
        } 
        linkedHashMap1.put(str, patchDelta);
        continue;
      } 
      if (patchStatus == PatchStatus.DELETED) {
        linkedHashMap5.put(str, patchDelta);
        continue;
      } 
      if (patchStatus == PatchStatus.INCOMPATIBLE)
        linkedHashMap4.put(str, patchDelta); 
    } 
    CompletionTask completionTask = new CompletionTask();
    DelegatedTask delegatedTask2 = new DelegatedTask(this, linkedHashMap3, linkedHashMap4) {
        public void run(Task param1Task) {
          Map<String, FileHolder> map = PackageDeltaApplier.a(this.c).a();
          for (String str : map.keySet()) {
            FileHolder fileHolder = map.get(str);
            PackageDeltaApplier.a(this.c, str, new PatchResultExplainer(str, fileHolder.getPath()));
          } 
          for (String str : this.a.keySet()) {
            FileHolder fileHolder = PackageDeltaApplier.a(this.c).b(str);
            PackageDeltaApplier.a(this.c, str, new PatchResultExplainer(str, fileHolder.getPath()));
          } 
          for (String str : this.b.keySet()) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Patch file incompatible: ");
            stringBuilder.append(str);
            PatchLogger.w(stringBuilder.toString());
            PatchResultExplainer patchResultExplainer = new PatchResultExplainer(str, PackageDeltaApplier.a(this.c).b(str).getPath(), true);
            PackageDeltaApplier.a(this.c, str, patchResultExplainer);
          } 
          finish();
        }
      };
    Task task2 = a((Map)linkedHashMap2, this.c);
    Task task1 = b((Map)linkedHashMap1, this.c);
    completionTask.dependsOn((Task)delegatedTask2);
    completionTask.dependsOn(task1);
    completionTask.dependsOn(task2);
    DelegatedTask delegatedTask1 = new DelegatedTask(this) {
        public void run(Task param1Task) {
          try {
            if (PackageDeltaApplier.a(this.a).g() && !PackageDeltaApplier.a(this.a, PackageDeltaApplier.a(this.a))) {
              StringBuilder stringBuilder1 = new StringBuilder();
              stringBuilder1.append("Failed: ");
              stringBuilder1.append(this.a.a.getRestoreOutput());
              stringBuilder1.append(", wrong patch");
              PatchLogger.e(stringBuilder1.toString());
              this.a.b("Wrong patch");
              finish();
              return;
            } 
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Write: ");
            stringBuilder.append(this.a.a.getRestoreOutput());
            PatchLogger.d(stringBuilder.toString());
            PackageDeltaApplier.b(this.a, PackageDeltaApplier.a(this.a));
            stringBuilder = new StringBuilder();
            stringBuilder.append("All task has finished: ");
            stringBuilder.append(this.a.a.getRestoreOutput());
            PatchLogger.d(stringBuilder.toString());
            this.a.a(this.a.a.getRestoreOutput());
            stringBuilder = new StringBuilder();
            stringBuilder.append("Task package for ");
            stringBuilder.append(this.a.a.getRestoreOutput());
            stringBuilder.append(" finished");
            PatchLogger.e(stringBuilder.toString());
            finish();
            return;
          } catch (Throwable throwable) {
            PackageDeltaApplier packageDeltaApplier = this.a;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Error: ");
            stringBuilder.append(throwable.getMessage());
            packageDeltaApplier.b(stringBuilder.toString());
            return;
          } 
        }
      };
    delegatedTask1.dependsOn((Task)completionTask);
    return (Task)delegatedTask1;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued209820-dex2jar.jar!\com\tencent\tbs\patch\applier\PackageDeltaApplier.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */