import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TodosTest {

    SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");
    String[] subtasks = { "Молоко", "Яйца", "Хлеб" };
    Epic epic = new Epic(55, subtasks);
    Meeting meeting = new Meeting(
            555,
            "Выкатка 3й версии приложения",
            "Приложение НетоБанка",
            "Во вторник после обеда"
    );
    Todos todos = new Todos();

    @BeforeEach
    void setUp() {
        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);
    }

    @Test
    public void shouldAddThreeTasksOfDifferentType() {
        Task[] expected = { simpleTask, epic, meeting };
        Task[] actual = todos.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindAllTypesOfTasks() {
        Task expected = simpleTask;
        Task[] actual = todos.search("нить");
        Assertions.assertEquals(expected, actual[0]);

        expected = epic;
        actual = todos.search("локо");
        Assertions.assertEquals(expected, actual[0]);

        expected = meeting;
        actual = todos.search("ложен");
        Assertions.assertEquals(expected, actual[0]);
    }

}