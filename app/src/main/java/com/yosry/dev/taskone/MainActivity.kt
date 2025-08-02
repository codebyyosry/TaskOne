package com.yosry.dev.taskone

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.yosry.dev.taskone.ui.theme.TaskOneTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        // check on Android version SDK
        /*
        * Important: If you implemented
        * a custom splash screen in Android 11 or lower,
        * migrate your app to the SplashScreen API to ensure it displays correctly
        * in Android 12 and higher. For instructions, see Migrate your existing splash screen
        * implementation to Android 12.
        *
         */

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            val splashScreen = installSplashScreen() // Install the splash screen
            splashScreen.setKeepOnScreenCondition { /* return true to keep splash screen */ false }
        }


        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TaskOneTheme {


            }
        }
    }
}

