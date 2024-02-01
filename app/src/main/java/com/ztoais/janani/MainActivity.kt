package com.ztoais.janani



import android.app.Activity
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.browser.customtabs.CustomTabsIntent
import androidx.core.content.ContextCompat
import androidx.fragment.app.FragmentActivity


/**
 * Loads [MainFragment].
 */
class MainActivity : FragmentActivity() {
    val time2ChessUrl = "https://coaching.time2chess.com/app"
    val ixlUrl = "https://ixl.com/skill-plans"
    val testingMomUrl = "https://members.testingmom.com/test-prep"
    val chessdotcomurl = "https://chess.com"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.time2Chess).setOnClickListener(View.OnClickListener {
            openUrl(this@MainActivity, time2ChessUrl)
        })
        findViewById<Button>(R.id.ixl).setOnClickListener(View.OnClickListener {
            openUrl(this@MainActivity, ixlUrl)
        })
        findViewById<Button>(R.id.testingmom).setOnClickListener(View.OnClickListener {
            openUrl(this@MainActivity, testingMomUrl)
        })
        findViewById<Button>(R.id.chessdotcom).setOnClickListener(View.OnClickListener {
            openUrl(this@MainActivity, chessdotcomurl)
        })
    }
}

fun openUrl(mainActivity: MainActivity, url:String){
    // initializing object for custom chrome tabs.
    // initializing object for custom chrome tabs.
    val customIntent = CustomTabsIntent.Builder()

    // below line is setting toolbar color
    // for our custom chrome tab.

    // below line is setting toolbar color
    // for our custom chrome tab.
    customIntent.setToolbarColor(
        ContextCompat.getColor(
            mainActivity,
            android.R.color.holo_purple
        )
    )

    // we are calling below method after
    // setting our toolbar color.

    // we are calling below method after
    // setting our toolbar color.
    openCustomTab(mainActivity, customIntent.build(), Uri.parse(url))
}

fun openCustomTab(activity: Activity, customTabsIntent: CustomTabsIntent, uri: Uri?) {
    uri?.let {
        // package name is the default package
        // for our custom chrome tab
        val packageName = "com.android.chrome"

        // we are checking if the package name is not null
        // if package name is not null then we are calling
        // that custom chrome tab with intent by passing its
        // package name.
       // customTabsIntent.intent.setPackage(packageName)

        // in that custom tab intent we are passing
        // our url which we have to browse.
        customTabsIntent.launchUrl(activity, uri)
    }
}


fun launchChessApp(context: Context){
    try {
        val intent = Intent()
        intent.setComponent(ComponentName("com.chess", "com.chess.splash.SplashActivity"))
        context.startActivity(intent)
    }catch (ex:Exception){
        Toast.makeText(context.applicationContext, " launch Intent not available", Toast.LENGTH_SHORT).show()
    }finally {
        (context as MainActivity).finish()
    }

   /* val launchIntent: Intent? = context.applicationContext.packageManager.getLaunchIntentForPackage("com.chess.splash.SplashActivity")
    if (launchIntent != null) {
        context.startActivity(launchIntent)
        (context as MainActivity).finish()
    } else {
        Toast.makeText(context.applicationContext, " launch Intent not available", Toast.LENGTH_SHORT).show()
    }*/

    /*try {
        val `in`: InputStream = context.getResources().openRawResource(R.raw.embeddedapk)
        val b = ByteArray(`in`.available())
        val read = `in`.read(b)
        toast("$read byte read")
        val tempFileName = "embeddedapk.apk"
        val fout: FileOutputStream = context.openFileOutput(tempFileName, MODE_WORLD_READABLE)
        fout.write(b)
        fout.close()
        `in`.close()
        val tempFile: File = context.getFileStreamPath(tempFileName)
        val i: Intent = context.get(Intent.ACTION_VIEW, tempFile)
        context.startActivity(Intent.createChooser(i, "sdsds"))
    } catch (ex: Exception) {
        Log.e("ero", "erer", ex)
    }*/
}