package com.example.redcarpet


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.TextView
import kotlinx.android.synthetic.main.news_details.*



class Detail_news : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val w = activity?.window
        w?.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )

    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.news_details, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val args = arguments?.let { Detail_newsArgs.fromBundle(it) }
        val articleTitle = args?.message
        val articleAuthor = args?.Author
        val articleContent = args?.content
        val articleUrl = args?.url
        val articleSource = args?.source1name
        val articleTime = args?.publisheddate
        val articleImage = args?.urltoimage
        val articleDescription = args?.description

        GlideApp.with(ImageView)
            .load(articleImage)
            .into(ImageView)
        if (articleTime != null) {
            val date1: TextView = time2
            date1.text = articleTime ?: "Unknown"
            Title.text = articleTitle

            if (articleAuthor != null) {
                Author.text = articleAuthor.toString()
            } else if (articleSource != null) {
                Author.text = articleSource.toString()
            } else {
                Author.text = "unknown"
            }
            if (articleContent != null) {
                if (articleContent.length >= 600) {
                    content.text = articleContent.substring(0, 600).toString() + "..."
                } else {
                    content.text = articleContent.toString()
                }

            } else if (articleDescription != null) {
                content.text = articleDescription.toString()
            }


        }
    }}