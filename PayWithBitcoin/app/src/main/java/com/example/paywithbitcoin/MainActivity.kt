package com.example.paywithbitcoin

import android.Manifest
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.hardware.Camera
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.TextureView
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.camera.core.*
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.LifecycleOwner
import com.example.paywithbitcoin.ui.dashboard.camera.QrCodeAnalyzer
import com.example.paywithbitcoin.ui.dashboard.login.LoginFragment
import java.io.File


class MainActivity : AppCompatActivity() {

    companion object {
        private const val REQUEST_CAMERA_PERMISSION = 10
    }

    private lateinit var textureView: TextureView
    private lateinit var myContext: FragmentActivity
    var photoFile: File? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textureView = findViewById(R.id.texture_view)

        // Request camera permissions
        if (isCameraPermissionGranted()) {
            textureView.post { startCamera() }
        } else {
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.CAMERA), REQUEST_CAMERA_PERMISSION)
        }

        // set button click to take picture and move to prices list selection
        val context = getApplicationContext()
        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)

        checkCameraHardware(context)
        val btn_click_me = findViewById(R.id.button3) as Button

        btn_click_me.setOnClickListener {
            Toast.makeText(this@MainActivity, "You took a picture now login.", Toast.LENGTH_SHORT).show()
            // implement fragment manage to transition to the next feature
            if(savedInstanceState == null){
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.frame_layout, LoginFragment.newInstance(), "Login Fragment")
                    .commit()
            }
            btn_click_me.visibility = View.INVISIBLE
        }
    }

    private fun startCamera() {
        val previewConfig = PreviewConfig.Builder()
            // We want to show input from back camera of the device
            .setLensFacing(CameraX.LensFacing.BACK)
            .build()

        val preview = Preview(previewConfig)

        preview.setOnPreviewOutputUpdateListener { previewOutput ->
            textureView.setSurfaceTexture(previewOutput.surfaceTexture)
        }

        CameraX.bindToLifecycle(this as LifecycleOwner, preview)

        val imageAnalysisConfig = ImageAnalysisConfig.Builder()
            .build()
        val imageAnalysis = ImageAnalysis(imageAnalysisConfig)

        val qrCodeAnalyzer = QrCodeAnalyzer { qrCodes ->
            qrCodes.forEach {
                Log.d("MainActivity", "QR Code detected: ${it.rawValue}.")
            }
        }

        imageAnalysis.analyzer = qrCodeAnalyzer

        // We need to bind preview and imageAnalysis use cases
        CameraX.bindToLifecycle(this as LifecycleOwner, preview)
        CameraX.bindToLifecycle(this as LifecycleOwner, imageAnalysis)


    }

    private fun isCameraPermissionGranted(): Boolean {
        val selfPermission = ContextCompat.checkSelfPermission(baseContext, Manifest.permission.CAMERA)
        return selfPermission == PackageManager.PERMISSION_GRANTED
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        if (requestCode == REQUEST_CAMERA_PERMISSION) {
            if (isCameraPermissionGranted()) {
                textureView.post { startCamera() }
            } else {
                Toast.makeText(this, "Camera permission is required.", Toast.LENGTH_SHORT).show()
                finish()
            }
        }
    }

    fun getCameraInstance(): Camera? {
        return try {
            Camera.open()

        } catch (e: Exception) {
            null // returns null if camera is unavailable
        }
    }

    private fun checkCameraHardware(context: Context): Boolean {
        if (context.packageManager.hasSystemFeature(PackageManager.FEATURE_CAMERA)) {
            getCameraInstance()
            return true
        } else {
            // no camera on this device
            return false
        }
    }

}
