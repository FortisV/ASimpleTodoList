package org.example;

import java.util.Vector;

public class Task {
    private String name;
    private Vector<String> tags;
    private boolean complete;


    public Task(String name) {
        this.name = name;
        this.tags = new Vector<>();
        this.complete = false;
    }
    public Task(String name, String tag) {
        this.name = name;
        this.tags = new Vector<>();
        addTag(tag);
        this.complete = false;
    }

    public boolean isSameTask(Task task) {
        return isSameTask(task.name);
    }
    public boolean isSameTask(String name) {
        return this.name.equalsIgnoreCase(name);
    }

    public boolean setName(String name) {
        if(!name.isBlank()) {
            this.name = name;
            return true;
        }
        return false;
    }
    public String getName() {
        return name;
    }
    public boolean isBlank() {
        return name.isBlank();
    }

    public boolean addTag(String tag) {
        if(!matchTag(tag) && !tag.isBlank()) {
            tags.add(tag);
            return true;
        }
        return false;
    }
    public boolean matchTag(String findTag) {
        for(String currTag : tags) {
            if(currTag.equalsIgnoreCase(findTag)) {
                return true;
            }
        }
        return false;
    }
    public boolean matchOneTag(Vector<String> findTags) {
        for(String currTag : tags) {
            for(String findTag : findTags) {
                if(currTag.equalsIgnoreCase(findTag)) {
                    return true;
                }
            }
        }
        return false;
    }

    public int getTagSize() {
        return tags.size();
    }
    public String getTag(int i) {
        if(0 <= i && i <= tags.size()) {
            return tags.get(i);
        }
        return null;
    }

    public boolean isComplete() {
        return complete;
    }
    public void markIncomplete() {
        complete = false;
    }
    public void markComplete() {
        complete = true;
    }
}
