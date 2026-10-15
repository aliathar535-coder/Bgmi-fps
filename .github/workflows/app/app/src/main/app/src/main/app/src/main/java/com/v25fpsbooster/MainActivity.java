package com.v25fpsbooster;

import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;
import android.provider.Settings;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends Activity {

    LinearLayout layout;
    TextView status;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setGravity(Gravity.CENTER);
        layout.setPadding(28, 28, 28, 28);
        layout.setBackgroundColor(Color.rgb(8, 13, 25));

        TextView title = new TextView(this);
        title.setText("⚡ V25 FPS BOOSTER");
        title.setTextColor(Color.rgb(0, 255, 200));
        title.setTextSize(26);
        title.setGravity(Gravity.CENTER);

        status = new TextView(this);
        status.setText("BGMI Performance Assistant");
        status.setTextColor(Color.WHITE);
        status.setTextSize(17);
        status.setGravity(Gravity.CENTER);
        status.setPadding(0, 24, 0, 24);

        layout.addView(title);
        layout.addView(status);

        addButton("📱 Display Settings", v -> {
            startActivity(new Intent(Settings.ACTION_DISPLAY_SETTINGS));
        });

        addButton("🎮 BGMI Settings Guide", v -> {
            status.setText(
                "BGMI खोलें > Settings > Graphics & Audio।\n\n" +
                "Smooth Graphics चुनें और उपलब्ध सबसे ऊँचा FPS विकल्प चुनें।"
            );
        });

        addButton("🔋 Battery Settings", v -> {
            startActivity(new Intent(Settings.ACTION_BATTERY_SAVER_SETTINGS));
        });

        addButton("ℹ️ FPS जानकारी", v -> {
            status.setText(
                "Vivo V25 5G में 90Hz डिस्प्ले है।\n\n" +
                "90 FPS तभी मिलेगा जब BGMI उस विकल्प को सपोर्ट करे।\n\n" +
                "यह ऐप गेम की FPS सीमा को जबरदस्ती नहीं बदलता।"
            );
        });

        setContentView(layout);
    }

    void addButton(String text, View.OnClickListener listener) {
        Button button = new Button(this);
        button.setText(text);
        button.setTextSize(15);
        button.setAllCaps(false);
        button.setOnClickListener(listener);

        LinearLayout.LayoutParams params =
            new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            );

        params.setMargins(0, 10, 0, 10);
        layout.addView(button, params);
    }
}
