/*
 * SPDX-FileCopyrightText: 2024 The LineageOS Project
 * SPDX-License-Identifier: Apache-2.0
 */

package org.lineageos.lineageparts.notificationlight;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageButton;

import androidx.annotation.Nullable;
import androidx.preference.Preference;
import androidx.preference.PreferenceViewHolder;

import org.lineageos.lineageparts.R;

public class NotificationLightAppPreference extends Preference {

    public interface OnRemoveClickListener {
        void onRemoveClicked(String packageName);
    }

    private OnRemoveClickListener mRemoveClickListener;

    public NotificationLightAppPreference(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public NotificationLightAppPreference(Context context) {
        super(context);
        init();
    }

    private void init() {
        setWidgetLayoutResource(R.layout.preference_widget_remove);
        setSelectable(false);
    }

    public void setOnRemoveClickListener(@Nullable OnRemoveClickListener listener) {
        mRemoveClickListener = listener;
    }

    @Override
    public void onBindViewHolder(PreferenceViewHolder holder) {
        super.onBindViewHolder(holder);
        ImageButton removeButton = (ImageButton) holder.findViewById(R.id.remove_app);
        if (removeButton != null) {
            removeButton.setOnClickListener(v -> {
                if (mRemoveClickListener != null) {
                    mRemoveClickListener.onRemoveClicked(getKey());
                }
            });
        }
    }
}
