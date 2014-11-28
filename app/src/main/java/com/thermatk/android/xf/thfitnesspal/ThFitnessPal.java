package com.thermatk.android.xf.thfitnesspal;

import static de.robv.android.xposed.XposedHelpers.findAndHookMethod;
import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.callbacks.XC_LoadPackage.LoadPackageParam;
import de.robv.android.xposed.XC_MethodReplacement;

public class ThFitnessPal implements IXposedHookLoadPackage {
	public void handleLoadPackage(final LoadPackageParam lpparam)
			throws Throwable {
		if (!lpparam.packageName.equals("com.myfitnesspal.android"))
			return;

		XposedBridge.log("inside FitnessPal!");

		findAndHookMethod("com.myfitnesspal.android.diary.Diary",
				lpparam.classLoader, "addGestureListeners", new XC_MethodReplacement() {
                    @Override
                    protected Object replaceHookedMethod(MethodHookParam param) throws Throwable {
                        return false;
                    }
                });
	}
}
