package org.ahmadelsayed.derma;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Data extends AppCompatActivity {

    private LinearLayout linearLayout;
    private String disease;
    private String topic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);

        topic = getIntent().getStringExtra("TopicName");
        setTitle(topic);

        disease = getIntent().getStringExtra("DiseaseName");
        linearLayout = findViewById(R.id.linear_layout);

        try {
            view();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void view() throws Exception {
        switch (topic) {
            case "Introduction":
                makeIntro();
                break;
            case "Causes":
                makeCauses();
                break;
            case "Symptoms":
                makeSymptoms();
                break;
            case "Treatment":
                makeTreatment();
                break;
            case "Extra Information":
                makeExtra();
                break;
            case "Videos":
                makeVideos();
                break;
            default:
                throw new Exception("String Unknown: Mine");
        }
    }

    private void makeIntro() throws Exception {
        if(disease.equals("Psoriasis")) {
            createText(R.string.p_intro);
            createImage(R.drawable.p_intro);
        }
        else if(disease.equals("Vitiligo")) {
            createText(R.string.v_info);
            createImage(R.drawable.v_intro);
        } else
            throw new Exception("String Unknown: Mine");
    }

    private void makeCauses() throws Exception {
        if(disease.equals("Psoriasis")) {
            createText(R.string.p_causes);
            createImage(R.drawable.p_causes);
        }
        else if(disease.equals("Vitiligo")) {
            createText(R.string.v_causes);
            createImage(R.drawable.v_causes);
        }
        else
            throw new Exception("String Unknown: Mine");
    }

    private void makeSymptoms() throws Exception {
        if(disease.equals("Psoriasis")) {
            createText(R.string.p_symp);
            createImage(R.drawable.p_symp);
            createImage(R.drawable.p_symp2);
        }
        else if(disease.equals("Vitiligo"))
            createText(R.string.v_symp);
        else
            throw new Exception("String Unknown: Mine");
    }

    private void makeTreatment() throws Exception {
        if(disease.equals("Psoriasis")) {
            createText(R.string.p_treatment);
            createImage(R.drawable.p_treat);
            createImage(R.drawable.p_treat2);
        }
        else if(disease.equals("Vitiligo")) {
            createText(R.string.v_treat);
            createImage(R.drawable.v_treat);
        }
        else
            throw new Exception("String Unknown: Mine");
    }

    private void makeExtra() throws Exception {
        if(disease.equals("Psoriasis")) {
            createText(R.string.p_extra);
            createImage(R.drawable.p_extra);
            createImage(R.drawable.p_extra1);
        }
        else if(disease.equals("Vitiligo")) {
            createText(R.string.v_extra);
            createImage(R.drawable.v_extra);
            createImage(R.drawable.v_extra2);
        }
        else
            throw new Exception("String Unknown: Mine");
    }

    private void makeVideos() throws Exception {
        if(disease.equals("Psoriasis")) {
            createVideo("<iframe width=\"1001\" height=\"1001\" src=\"https://www.youtube.com/embed/b3fr0fMSN28\" frameborder=\"0\" allow=\"accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture\" allowfullscreen></iframe>");
            createVideo("<iframe width=\"1001\" height=\"1001\" src=\"https://www.youtube.com/embed/3OepdO3ddqM\" frameborder=\"0\" allow=\"accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture\" allowfullscreen></iframe>");
            createVideo("<iframe width=\"1001\" height=\"1001\" src=\"https://www.youtube.com/embed/hCXh9PDsFjY\" frameborder=\"0\" allow=\"accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture\" allowfullscreen></iframe>");
            createVideo("<iframe width=\"1001\" height=\"1001\" src=\"https://www.youtube.com/embed/MbmizU2O1XY\" frameborder=\"0\" allow=\"accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture\" allowfullscreen></iframe>");
        }
        else if(disease.equals("Vitiligo")) {
            createVideo("<iframe width=\"1001\" height=\"1001\" src=\"https://www.youtube.com/embed/7a_9YydIjYs\" frameborder=\"0\" allow=\"accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture\" allowfullscreen></iframe>");
            createVideo("<iframe width=\"1001\" height=\"1001\" src=\"https://www.youtube.com/embed/eW9ONkdLdqc\" frameborder=\"0\" allow=\"accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture\" allowfullscreen></iframe>");
            createVideo("<iframe width=\"1001\" height=\"1001\" src=\"https://www.youtube.com/embed/_6q-VAezFj4\" frameborder=\"0\" allow=\"accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture\" allowfullscreen></iframe>");
            createVideo("<iframe width=\"1001\" height=\"1001\" src=\"https://www.youtube.com/embed/qBJYZ9VOgd0\" frameborder=\"0\" allow=\"accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture\" allowfullscreen></iframe>");
            createVideo("<iframe width=\"1001\" height=\"1001\" src=\"https://www.youtube.com/embed/0YiIYIfxUj4\" frameborder=\"0\" allow=\"accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture\" allowfullscreen></iframe>");
            createVideo("<iframe width=\"1001\" height=\"1001\" src=\"https://www.youtube.com/embed/NXhZwmYfyI4\" frameborder=\"0\" allow=\"accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture\" allowfullscreen></iframe>");
        } else
            throw new Exception("String Unknown: Mine");
    }

    private void createText(int resid) {
        TextView textView = new TextView(this);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT,
                Gravity.FILL
                );
        layoutParams.setMargins(16,16,16,16);

        textView.setLayoutParams(layoutParams);
        textView.setText(resid);
        linearLayout.addView(textView);
    }

    private void createImage(int resid) {
        ImageView imageView = new ImageView(this);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT,
                Gravity.CENTER
        );
        layoutParams.setMargins(16,16,16,16);
        imageView.setLayoutParams(layoutParams);
        imageView.setImageResource(resid);
        imageView.setAdjustViewBounds(true);
        linearLayout.addView(imageView);
    }

    private void createVideo(String link) {
        WebView webView = new WebView(this);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.FILL_PARENT,
                LinearLayout.LayoutParams.FILL_PARENT
        );
        webView.setLayoutParams(layoutParams);

        webView.setInitialScale(1);
        webView.getSettings().setLoadWithOverviewMode(true);
        webView.getSettings().setUseWideViewPort(true);
        webView.getSettings().setJavaScriptEnabled(true);
        final String mimeType = "text/html";
        final String encoding = "UTF-8";
        String html = link;
        webView.loadDataWithBaseURL("", html, mimeType, encoding, "");

        linearLayout.addView(webView);
    }

}
