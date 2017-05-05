package com.example.arjun_mu.a1retrofit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by norman on 12/26/16.
 */

// https://api.github.com/users/arjunarjun27/repos


public class GitHubRepoAdapter extends ArrayAdapter<GitHubRepo> {

    private Context context;
    private List<GitHubRepo> values;

    public GitHubRepoAdapter(Context context, List<GitHubRepo> values) {
        super(context, R.layout.list_item_pagination, values);

        this.context = context;
        this.values = values;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;

        if (row == null) {
            LayoutInflater inflater =
                    (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.list_item_pagination, parent, false);
        }

        TextView textView = (TextView) row.findViewById(R.id.list_item_pagination_text);
        TextView textView1 = (TextView) row.findViewById(R.id.fullname);
        TextView textView2 = (TextView) row.findViewById(R.id.id);

        GitHubRepo item = values.get(position);

        Owner owner=item.getOwner();
        int id=owner.getId();
        String message = item.getName();
        textView.setText(message);
        textView.setText(item.getFull_name());
        textView2.setText(""+item.getId());
        return row;
    }
}
