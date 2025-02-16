package org.example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AppTest {
    static TodoList todoList;

    @BeforeEach
    void initTodoList() {
        todoList = new TodoList("Test List");
    }
    @Test
    void addToList() {
        Task task = new Task("Jump");
        todoList.add(task);
        assertEquals(task, todoList.getTask(0));
    }
    @Test
    void addToListBlank() {
        Task task = new Task("");
        todoList.add(task);
        assertEquals(0, todoList.getTasksSize());
    }
    @Test
    void addToListDuplicate() {
        Task task = new Task("Jump");
        todoList.add(task);
        todoList.add(task);
        assertEquals(1, todoList.getTasksSize());
    }
    @Test
    void markTaskComplete() {
        Task task = new Task("Jump");
        todoList.add(task);
        todoList.markComplete(task);
        assertEquals(true, todoList.getTask(task).isComplete());
    }
    @Test
    void markTaskIncomplete() {
        Task task = new Task("Jump");
        task.markComplete();
        todoList.add(task);
        todoList.markIncomplete(task);
        assertEquals(false, todoList.getTask(task).isComplete());
    }
    @Test
    void clearList() {
        Task task1 = new Task("Jump");
        Task task2 = new Task("Run");
        Task task3 = new Task("Squat");
        Task task4 = new Task("Bench");
        todoList.add(task1);
        todoList.add(task2);
        todoList.add(task3);
        todoList.add(task4);
        todoList.clear();
        assertEquals(0, todoList.getTasksSize());
    }
}
