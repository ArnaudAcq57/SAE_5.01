package com.example.sae_501

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.sae_501.camera.CameraManager
import com.example.sae_501.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var viewBinding: ActivityMainBinding
    private lateinit var cameraManager: CameraManager

    private val galleryLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == RESULT_OK) {
            val uri = result.data?.data
            Toast.makeText(baseContext, "Image sélectionnée de la galerie : $uri", Toast.LENGTH_SHORT).show()
        }
    }

    private val permissionsLauncher = registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()) { permissions ->
        if (permissions.entries.all { it.value }) {
            cameraManager.startCamera()
        } else {
            Toast.makeText(this, "Les autorisations n'ont pas été accordées par l'utilisateur.", Toast.LENGTH_SHORT).show()
            finish()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        cameraManager = CameraManager(
            context = this,
            finderView = viewBinding.viewFinder,
            lifecycleOwner = this,
            onImageAnalyzed = { image ->
                //
                // TODO: RECONNAISSANCE D'OBJETS ICI
                //
                image.close()
            }
        )

        if (allPermissionsGranted()) {
            cameraManager.startCamera()
        } else {
            permissionsLauncher.launch(REQUIRED_PERMISSIONS)
        }

        viewBinding.imageCaptureButton.setOnClickListener { takePhoto() }
        viewBinding.galleryButton.setOnClickListener { openGallery() }
    }

    private fun takePhoto() {
        cameraManager.takePhoto(
            onSuccess = { uri ->
                val msg = "Capture photo réussie : $uri"
                Toast.makeText(baseContext, msg, Toast.LENGTH_SHORT).show()
            },
            onError = { exception ->
                Toast.makeText(baseContext, "Échec de la capture photo : ${exception.message}", Toast.LENGTH_SHORT).show()
            }
        )
    }

    private fun openGallery() {
        val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        galleryLauncher.launch(intent)
    }

    private fun allPermissionsGranted() = REQUIRED_PERMISSIONS.all {
        ContextCompat.checkSelfPermission(baseContext, it) == PackageManager.PERMISSION_GRANTED
    }

    override fun onDestroy() {
        super.onDestroy()
        cameraManager.shutdown()
    }

    companion object {
        private val REQUIRED_PERMISSIONS = mutableListOf(
            Manifest.permission.CAMERA
        ).apply {
            if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.P) {
                add(Manifest.permission.WRITE_EXTERNAL_STORAGE)
            }
        }.toTypedArray()
    }
}