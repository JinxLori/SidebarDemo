package com.jason.sidebardemo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.SectionIndexer;
import android.widget.TextView;

import com.jason.library.widget.Sidebar;
import com.jason.sidebardemo.R;
import com.jason.sidebardemo.model.Contact;

import java.util.Arrays;
import java.util.List;

/**
 * @author zjh
 * @date 2016/9/9
 */
public class MyAdapter extends BaseAdapter implements SectionIndexer{
    private Context mContext;
    private List<Contact> mContacts;
    public MyAdapter(Context context,List<Contact> contacts){
        mContext = context;
        mContacts = contacts;
    }

    @Override
    public int getCount() {
        return mContacts.size();
    }

    @Override
    public Object getItem(int position) {
        return mContacts.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null){
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_contact, null);
            viewHolder.tvHeader = (TextView) convertView.findViewById(R.id.tv_header);
            viewHolder.tvName = (TextView) convertView.findViewById(R.id.tv_name);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        if (position == 0){
            viewHolder.tvHeader.setVisibility(View.VISIBLE);
        }else if (mContacts.get(position).getFirstAlphabet().charAt(0) != mContacts.get(position - 1).getFirstAlphabet().charAt(0)){
            viewHolder.tvHeader.setVisibility(View.VISIBLE);
        }else {
            viewHolder.tvHeader.setVisibility(View.GONE);
        }

        viewHolder.tvHeader.setText(mContacts.get(position).getFirstAlphabet());
        viewHolder.tvName.setText(mContacts.get(position).getName());

        return convertView;
    }

    @Override
    public Object[] getSections() {
        return Arrays.copyOf(Sidebar.alphabets,Sidebar.alphabets.length);
    }

    @Override
    public int getPositionForSection(int sectionIndex) {
        for (int i=0; i<getCount(); i++){
            if (((String)getSections()[sectionIndex]).charAt(0) == mContacts.get(i).getFirstAlphabet().charAt(0)){
                return i;
            }
        }
        return 0;
    }

    @Override
    public int getSectionForPosition(int position) {
        return 0;
    }

    class ViewHolder{
        public TextView tvHeader;
        public TextView tvName;
    }
}
