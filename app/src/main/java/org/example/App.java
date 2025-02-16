package org.example;

public class App {
  public static void main(String[] args) {
    TodoList todoList = new TodoList("Fortis's Todo List");

    todoList.add(new Task("Math Homework", "Homework"));
    todoList.add(new Task("History Homework", "Homework"));
    todoList.add(new Task("English Homework", "Homework"));
    todoList.add(new Task("Run", "Sports"));
    todoList.add(new Task("Jump", "Sports"));
    todoList.add(new Task("Squat", "Sports"));

    // Blank won't work
    todoList.add(new Task(""));

    // Duplicate won't work
    todoList.add(new Task("Math Homework", "Homework"));

    todoList.markComplete("Math Homework");
    todoList.markComplete("History Homework");

    todoList.markComplete("Run");

    ConsoleDecorations.printBanner("Todo List");

    ConsoleDecorations.printDivider("List Name");
    System.out.println(todoList.getName());

    ConsoleDecorations.printDivider("List");
    todoList.all();

    ConsoleDecorations.printDivider("Complete");
    todoList.complete();

    ConsoleDecorations.printDivider("Incomplete");
    todoList.incomplete();

    ConsoleDecorations.printDivider("Homework");
    todoList.printWithTag("Homework");

    ConsoleDecorations.printDivider("Sports");
    todoList.printWithTag("Sports");

    ConsoleDecorations.printBanner("Exiting...");
  }
}
