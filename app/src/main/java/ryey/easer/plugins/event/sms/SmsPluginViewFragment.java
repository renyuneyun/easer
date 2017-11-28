/*
 * Copyright (c) 2016 - 2017 Rui Zhao <renyuneyun@gmail.com>
 *
 * This file is part of Easer.
 *
 * Easer is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Easer is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Easer.  If not, see <http://www.gnu.org/licenses/>.
 */

package ryey.easer.plugins.event.sms;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import ryey.easer.R;
import ryey.easer.commons.plugindef.PluginViewFragment;
import ryey.easer.commons.plugindef.StorageData;

public class SmsPluginViewFragment extends PluginViewFragment {
    EditText editText_sender, editText_content;

    {
        setDesc(R.string.event_sms);
    }

    @NonNull
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.plugin_event__sms, container, false);
        editText_sender = view.findViewById(R.id.editText_sender);
        editText_content = view.findViewById(R.id.editText_content);

        return view;
    }

    @Override
    protected void _fill(StorageData data) {
        if (data instanceof SmsEventData) {
            SmsInnerData intentData = (SmsInnerData) data.get();
            editText_sender.setText(intentData.sender);
            editText_content.setText(intentData.content);
        }
    }

    @Override
    public StorageData getData() {
        SmsInnerData intentData = new SmsInnerData();
        intentData.sender = editText_sender.getText().toString();
        intentData.content = editText_content.getText().toString();
        return new SmsEventData(intentData);
    }
}
