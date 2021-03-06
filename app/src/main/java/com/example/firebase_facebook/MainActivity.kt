package com.example.firebase_facebook

import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.annotation.RequiresApi
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException
import java.util.*

class MainActivity : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        debugHashKey()

        val fragment_login = login()
        val manager = supportFragmentManager;
        val transaction = manager.beginTransaction();
        transaction.replace(R.id.contentContainer,fragment_login,"fragment_login")
       transaction.addToBackStack("fragment_login");
        transaction.commit();


    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun debugHashKey() {
        try {
            val info = packageManager.getPackageInfo(
                "com.example.firebase_facebook",
                PackageManager.GET_SIGNATURES
            )
            for (signature in info.signatures) {
                val md: MessageDigest = MessageDigest.getInstance("SHA")
                md.update(signature.toByteArray())
                Log.d("KeyHash:", Base64.getEncoder().encodeToString(md.digest()))
            }
        } catch (e: PackageManager.NameNotFoundException) {
        } catch (e: NoSuchAlgorithmException) {
        }
    }

}
