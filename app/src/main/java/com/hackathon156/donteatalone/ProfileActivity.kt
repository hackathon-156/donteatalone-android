package com.hackathon156.donteatalone

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Toast
import com.anton46.collectionitempicker.Item
import kotlinx.android.synthetic.main.activity_profile.*
import net.hockeyapp.android.CrashManager
import net.hockeyapp.android.UpdateManager


class ProfileActivity : AppCompatActivity() {

    private val cuisines = mutableListOf<Item>()
    private val finalCuisines = HashMap<String, String>()
    private val TAG = "ProfileActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        loadCuisines()

        collection_item_picker.items = cuisines
        collection_item_picker.setOnItemClickListener { item, position ->
            makeFinalCuisinesList(item)
            Toast.makeText(this, item.text + " clicked at position " + position, Toast.LENGTH_SHORT).show()
        }

        buttonEditProfile.setOnClickListener {
            Log.d(TAG, finalCuisines.toString())
        }

        checkForUpdates()
    }

    private fun makeFinalCuisinesList(item: Item) {
        if (!item.isSelected) {
            finalCuisines.remove(item.id)
        } else {
            finalCuisines[item.id] = item.text
        }
    }

    public override fun onResume() {
        super.onResume()
        // ... your own onResume implementation
        checkForCrashes()
    }

    public override fun onPause() {
        super.onPause()
        unregisterManagers()
    }

    public override fun onDestroy() {
        super.onDestroy()
        unregisterManagers()
    }

    private fun checkForCrashes() {
        CrashManager.register(this)
    }

    private fun checkForUpdates() {
        // Remove this for store builds!
        UpdateManager.register(this)
    }

    private fun unregisterManagers() {
        UpdateManager.unregister()
    }

    private fun loadCuisines() {
        cuisines.add(Item("cui1", "American"))
        cuisines.add(Item("cui2", "Armenian"))
        cuisines.add(Item("cui3", "Argentine"))
        cuisines.add(Item("cui4", "Asian"))
        cuisines.add(Item("cui5", "Australian"))
        cuisines.add(Item("cui6", "Austrian"))
        cuisines.add(Item("cui7", "Belgian"))
        cuisines.add(Item("cui8", "Bistro"))
        cuisines.add(Item("cui9", "Brazilian"))
        cuisines.add(Item("cui10", "British"))
        cuisines.add(Item("cui11", "Californian"))
        cuisines.add(Item("cui12", "Caribbean"))
        cuisines.add(Item("cui13", "Chilean"))
        cuisines.add(Item("cui14", "Chinese"))
        cuisines.add(Item("cui15", "Colombian"))
        cuisines.add(Item("cui16", "Contemporary"))
        cuisines.add(Item("cui17", "Continental"))
        cuisines.add(Item("cui18", "Czech"))
        cuisines.add(Item("cui19", "Dutch"))
        cuisines.add(Item("cui20", "English"))
        cuisines.add(Item("cui21", "European"))
        cuisines.add(Item("cui22", "French"))
        cuisines.add(Item("cui23", "Fusion"))
        cuisines.add(Item("cui24", "German"))
        cuisines.add(Item("cui25", "Greek"))
        cuisines.add(Item("cui26", "Indian"))
        cuisines.add(Item("cui27", "Irish"))
        cuisines.add(Item("cui28", "Italian"))
        cuisines.add(Item("cui29", "Japanese"))
        cuisines.add(Item("cui30", "Korean"))
        cuisines.add(Item("cui31", "Latin"))
        cuisines.add(Item("cui32", "Lebanese"))
        cuisines.add(Item("cui33", "Malaysian"))
        cuisines.add(Item("cui34", "Mediterranean"))
        cuisines.add(Item("cui35", "Mexican"))
        cuisines.add(Item("cui36", "Middle Eastern"))
        cuisines.add(Item("cui37", "Mongolian"))
        cuisines.add(Item("cui38", "Moroccan"))
        cuisines.add(Item("cui39", "Persian"))
        cuisines.add(Item("cui40", "Portuguese"))
        cuisines.add(Item("cui41", "Russian"))
        cuisines.add(Item("cui42", "Seafood"))
        cuisines.add(Item("cui43", "Singaporean"))
        cuisines.add(Item("cui44", "Southwestern"))
        cuisines.add(Item("cui45", "Spanish"))
        cuisines.add(Item("cui46", "Taiwanese"))
        cuisines.add(Item("cui47", "Thai"))
        cuisines.add(Item("cui48", "Tibetan"))
        cuisines.add(Item("cui49", "Tunisian"))
        cuisines.add(Item("cui50", "Turkish"))
        cuisines.add(Item("cui51", "Ukrainian"))
        cuisines.add(Item("cui52", "Vegan"))
        cuisines.add(Item("cui53", "Venezuelan"))
        cuisines.add(Item("cui54", "Vietnamese"))
    }
}
