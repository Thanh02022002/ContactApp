package com.example.contactapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.contactapp.databinding.ActivityUserBinding

class UserActivity: AppCompatActivity() {

    private lateinit var binding: ActivityUserBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val name = intent.getStringExtra("name")
        val phone = intent.getStringExtra("phone")
        val country = intent.getStringExtra("country")
        val imageId = intent.getIntExtra("imageId", R.drawable.imagesm)

        binding.nameProfile.text=name
        binding.phoneProfile.text=phone
        binding.countryProfile.text=country
        binding.profileImage.setImageResource(imageId)
    }
}