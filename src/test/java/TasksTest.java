import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TasksTest {
    @Test
    public void simpleTrue() {
        Task task = new SimpleTask(1,"Вынести мусор");
        Assertions.assertEquals(true, task.matches("мусор"));
    }

    @Test
    public void simpleFalse() {
        Task task = new SimpleTask(1,"Вынести мусор");
        Assertions.assertEquals(false, task.matches("подмести"));
    }

    @Test
    public void epicTrue() {
        String[] chancelly = {"карандаш", "ручка", "линейка"};
        Task task = new Epic(2, chancelly);
        Assertions.assertEquals(true, task.matches("ручка"));
    }

    @Test
    public void epicFalse() {
        String[] chancelly = {"карандаш", "ручка", "линейка"};
        Task task = new Epic(2, chancelly);
        Assertions.assertEquals(false, task.matches("ластик"));
    }

    @Test
    public void meetingTrue() {
        Task task = new Meeting(3, "тема", "проект", "дата");
        Assertions.assertEquals(true, task.matches("тема"));
    }

    @Test
    public void meetingFalse() {
        Task task = new Meeting(3, "тема", "проект", "дата");
        Assertions.assertEquals(false, task.matches("проЭкт"));
    }
}
