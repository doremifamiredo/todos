import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TodosTest {
    @Test
    public void shouldAddThreeTasksOfDifferentType() {
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

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = { simpleTask, epic, meeting };
        Task[] actual = todos.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindSimpleTask() {
        SimpleTask task1 = new SimpleTask(1, "Погулять с собакой");
        SimpleTask task2 = new SimpleTask(2, "Погулять с кошкой");
        SimpleTask task3 = new SimpleTask(3, "Зайти в магазин");

        Todos todos = new Todos();

        todos.add(task1);
        todos.add(task2);
        todos.add(task3);

        Task[] expected = {task1, task2};
        Task[] actual = todos.search("Погулять");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindEpicTask() {
        String[] subtasks1 = {"Молоко", "Яйца", "Хлеб"};
        String[] subtasks2 = {"Сыр", "Мясо", "Торт"};
        String[] subtasks3 = {"Творог", "Курица", "Хлеб"};
        Epic epic1 = new Epic(4, subtasks1);
        Epic epic2 = new Epic(5, subtasks2);
        Epic epic3 = new Epic(6, subtasks3);

        Todos todos = new Todos();

        todos.add(epic1);
        todos.add(epic2);
        todos.add(epic3);

        Task[] expected = {epic1, epic3};
        Task[] actual = todos.search("Хлеб");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindMeeting() {
        Meeting meeting1 = new Meeting(7,
                "Объектно-ориентированное программирование",
                "Группа 1",
                "Вторник");
        Meeting meeting2 = new Meeting(8,
                "Наследование и расширяемость систем",
                "Группа 2",
                "Среда");
        Meeting meeting3 = new Meeting(9,
                "Проблемы наследования",
                "Группа 3",
                "Четверг");

        Todos todos = new Todos();

        todos.add(meeting1);
        todos.add(meeting2);
        todos.add(meeting3);

        Task[] expected = {meeting1};
        Task[] actual = todos.search("программирование");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindAmongDifferentTasks() {
        SimpleTask task1 = new SimpleTask(10, "Купить творог");
        String[] subtasks2 = {"творог", "курица", "хлеб"};
        Epic epic2 = new Epic(11, subtasks2);
        Meeting meeting3 = new Meeting(12,
                "Проблемы наследования",
                "Группа 3",
                "Четверг");

        Todos todos = new Todos();

        todos.add(task1);
        todos.add(epic2);
        todos.add(meeting3);

        Task[] expected = {task1, epic2};
        Task[] actual = todos.search("творог");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void findsNothing() {
        SimpleTask task1 = new SimpleTask(13, "Купить творог");
        String[] subtasks2 = {"Учебник", "Тетрадь", "Дневник"};
        Epic epic2 = new Epic(14, subtasks2);
        Meeting meeting3 = new Meeting(15,
                "Композиция и зависимость объектов",
                "Группа 4",
                "Пятница");

        Todos todos = new Todos();

        todos.add(task1);
        todos.add(epic2);
        todos.add(meeting3);

        Task[] expected = {};
        Task[] actual = todos.search("Суббота");
        Assertions.assertArrayEquals(expected, actual);
    }
}
