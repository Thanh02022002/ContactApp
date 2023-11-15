package com.example.contactapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.contactapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var userArrayList: ArrayList<User>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val imageId = intArrayOf(

            R.drawable.imagesm,R.drawable.imagesm,R.drawable.imagesm,R.drawable.imagesm,R.drawable.imagesm,
            R.drawable.imagesm,R.drawable.imagesm,R.drawable.imagesm,R.drawable.imagesm
        )

        val name = arrayOf(
            "Josefina Lehner", "Stuart Vandervort II", "Maddison Rusell", "Halie Morar II", "Karelle Simonis",
            "Hannah Welch", "Fanny Frami", "Elfrieda Wisozk", "Maria ozi"
        )


        val phoneNo = arrayOf(
            "76845743","343758343","297563293","324675373","2387462374",
            "23437683","245289364","324978236","235723874"
        )

        val contry = arrayOf(
            "Vietnam","Vietnam","Vietnam","Vietnam","Vietnam","Vietnam","Vietnam",
            "Vietnam","Vietnam"
        )

        userArrayList = ArrayList()

        for (i in name.indices){
            val user = User(name[i],phoneNo[i],contry[i],imageId[i] )
            userArrayList.add(user)

        }

        binding.listview.isClickable = true
        binding.listview.adapter = MyAdapter(this,userArrayList)
        binding.listview.setOnItemClickListener{parent, view, position, id ->

            val name = name[position]
            val phone = phoneNo[position]
            val country = contry[position]
            val imageId = imageId[position]

            val i = Intent(this,UserActivity::class.java)
            i.putExtra("name",name)
            i.putExtra("phone",phone)
            i.putExtra("country",country)
            i.putExtra("imageid",imageId)
            startActivity(i)


        }
    }
}