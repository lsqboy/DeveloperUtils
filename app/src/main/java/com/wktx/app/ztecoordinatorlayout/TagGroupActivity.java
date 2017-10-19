package com.wktx.app.ztecoordinatorlayout;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.wktx.app.ztecoordinatorlayout.widget.TagColor;
import com.wktx.app.ztecoordinatorlayout.widget.TagGroup;

import java.util.ArrayList;
import java.util.List;

public class TagGroupActivity extends AppCompatActivity {
    TagGroup mTagGroup;
    private List<String> tagList = new ArrayList<>();
    int hotIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tag_group);
        mTagGroup = (TagGroup) findViewById(R.id.tag_group);

        tagList.add("LoL3");
        tagList.add("L4");
        tagList.add("LoL2");
        tagList.add("Lo连松青82");
        tagList.add("Lo连松青连松青82");
        tagList.add("L连松青2");
        tagList.add("L连松青连松青连松青连松青o82");
        tagList.add("Lo82");

        int tagSize = 8;
        String[] tags = new String[tagSize];
        for (int j = 0; j < tagSize && j < tagList.size(); hotIndex++, j++) {
            tags[j] = tagList.get(hotIndex % tagList.size());
        }
        List<TagColor> colors = TagColor.getRandomColors(tagSize);
        mTagGroup.setTags(colors, tags);

        mTagGroup.setOnTagClickListener(new TagGroup.OnTagClickListener() {
            @Override
            public void onTagClick(String tag) {
                Toast.makeText(TagGroupActivity.this, tag, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
