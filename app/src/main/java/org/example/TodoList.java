package org.example;

import java.io.InterruptedIOException;
import java.util.Vector;

public class TodoList {
    private String name;
    private Vector<Task> tasks;


    public TodoList(String name) {
        this.name = name;
        this.tasks = new Vector<>();
    }

    public String getName() {
        return name;
    }

    public boolean hasTask(Task task) {
        return hasTask(task.getName());
    }
    public boolean hasTask(String name) {
        for(int i = 0; i < tasks.size(); ++i) {
            if(tasks.get(i).isSameTask(name)) {
                return true;
            }
        }
        return false;
    }

    public boolean add(Task task) {
        return addTask(task);
    }
    public boolean addTask(Task task) {
        if(!hasTask(task) && !task.isBlank()) {
            tasks.add(task);
            return true;
        }
        return false;
    }

    public boolean removeTask(int i) {
        if(0 <= i && i < tasks.size()) {
            tasks.remove(i);
            return true;
        }
        return false;
    }
    public boolean removeTask(String name) {
        return removeTask(getTaskIndex(name));
    }
    public boolean removeTask(Task task) {
        return removeTask(getTaskIndex(task));
    }

    public Task getTask(int i) {
        if(0 <= i && i < tasks.size()) {
            return tasks.get(i);
        }
        return null;
    }
    public Task getTask(String name) {
        return getTask(getTaskIndex(name));
    }
    public Task getTask(Task task) {
        return getTask(getTaskIndex(task));
    }

    public int getTaskIndex(Task task) {
        return getTaskIndex(task.getName());
    }
    public int getTaskIndex(String name) {
        for(int i = 0; i < tasks.size(); ++i) {
            if(tasks.get(i).isSameTask(name)) {
                return i;
            }
        }
        return -1;
    }

    public int getTasksSize() {
        return tasks.size();
    }

    public void all() {
        printAll();
    }
    public void printAll() {
        for(int i = 0; i < tasks.size(); ++i) {
            Task currTask = tasks.get(i);
            System.out.println(i + ") " + currTask.getName());
        }
    }

    public void complete() {
        printComplete();
    }
    public void printComplete() {
        for(int i = 0; i < tasks.size(); ++i) {
            Task currTask = tasks.get(i);
            if(currTask.isComplete()) {
                System.out.println(i + ") " + tasks.get(i).getName());
            }
        }
    }

    public void incomplete() {
        printIncomplete();
    }
    public void printIncomplete() {
        for(int i = 0; i < tasks.size(); ++i) {
            Task currTask = tasks.get(i);
            if(!currTask.isComplete()) {
                System.out.println(i + ") " + tasks.get(i).getName());
            }
        }
    }

    public void printWithTag(String tag) {
        for(int i = 0; i < tasks.size(); ++i) {
            Task currTask = tasks.get(i);
            if(currTask.matchTag(tag)) {
                System.out.println(i + ") " + tasks.get(i).getName());
            }
        }
    }
    public void printWithOneTag(Vector<String> tags) {
        for(int i = 0; i < tasks.size(); ++i) {
            Task currTask = tasks.get(i);
            if(currTask.matchOneTag(tags)) {
                System.out.println(i + ") " + tasks.get(i).getName());
            }
        }
    }

    public void clear() {
        tasks.clear();
    }

    public boolean markComplete(int i) {
        if(0 <= i && i < tasks.size()) {
            Task task = tasks.get(i);
            task.markComplete();
            tasks.set(i, task);
            return true;
        }
        return false;
    }
    public boolean markIncomplete(int i) {
        if(0 <= i && i < tasks.size()) {
            Task task = tasks.get(i);
            task.markIncomplete();
            tasks.set(i, task);
            return true;
        }
        return false;
    }

    public boolean markComplete(String name) {
        int index = getTaskIndex(name);
        if(index != -1) {
            markComplete(index);
        }
        return false;
    }
    public boolean markIncomplete(String name) {
        int index = getTaskIndex(name);
        if(index != -1) {
            markIncomplete(index);
        }
        return false;
    }

    public boolean markComplete(Task task) {
        int index = getTaskIndex(task);
        if(index != -1) {
            markComplete(index);
        }
        return false;
    }
    public boolean markIncomplete(Task task) {
        int index = getTaskIndex(task);
        if(index != -1) {
            markIncomplete(index);
        }
        return false;
    }
}
