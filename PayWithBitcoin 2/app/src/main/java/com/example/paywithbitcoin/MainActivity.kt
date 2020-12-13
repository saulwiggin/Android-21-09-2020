package com.example.paywithbitcoin

import android.Manifest
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.TextureView
import android.widget.Toast
import androidx.camera.core.*
import androidx.core.content.ContextCompat
import androidx.lifecycle.LifecycleOwner
import com.coinbase.android.sdk.OAuth
import com.example.paywithbitcoin.network.API
import com.example.paywithbitcoin.ui.dashboard.camera.BarcodeFragment
import com.example.paywithbitcoin.ui.dashboard.dashboard.DashboardFragment
import com.example.paywithbitcoin.ui.dashboard.camera.QrCodeAnalyzer
import com.example.paywithbitcoin.ui.dashboard.login.ui.login.LoginFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_first.*
import com.coinbase.api.exception.CoinbaseException;
import com.example.paywithbitcoin.network.Coinbase
import okhttp3.OkHttpClient
import okhttp3.internal.concurrent.Task

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    companion object {
        private const val REQUEST_CAMERA_PERMISSION =10
    }

    private lateinit var textureView: TextureView

    private val CLIENT_ID = Coinbase.CLIENT_ID
    private val CLIENT_SECRET = Coinbase.CLIENT_SECRET
    private val REDIRECT_URI = Coinbase.REDIRECT_URI

    private val TAG="Coinbase Wallet Authorization"

    var client = OkHttpClient()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.AppTheme)
        setContentView(R.layout.activity_main)

    }

    private fun startCamera() {
        val previewConfig = PreviewConfig.Builder()
            // We want to show input from back camera of the device
            .setLensFacing(CameraX.LensFacing.BACK)
            .build()

        val preview = Preview(previewConfig)

        preview.setOnPreviewOutputUpdateListener { previewOutput ->
            // textureView.surfaceTexture = previewOutput.surfaceTexture
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
        CameraX.bindToLifecycle(this as LifecycleOwner, preview, imageAnalysis)
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

    private fun onAuthorizationTask() : OkHttpClient {
        return client
    }

}
