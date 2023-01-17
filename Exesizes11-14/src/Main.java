import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        //11. Дан массив строк. Необходимо удалить из него все дубли, а оставшиеся строки объединить в одну
        // в порядке следования в массиве.
        String[] array = new String[]{"Vasya", "Petya", "Vasya", "Olesya", "Grisha", "Vasya"};
        Set<String> set = new LinkedHashSet<>(Arrays.asList(array));
        System.out.println(set.toString());

        //12. Дан массив пар названий книг и авторов, необходимо привести каждую пару в строку вида:
        // "Название книги" И. О. Фамилия автора.
        String[] couples = {"Война и мир", "Л.Н. Толстой", "Евгений онегин", "А.С. Пушкин", "Мастер и Маргарита", "М.Ф. Булгаков"};
        List<String> list = new ArrayList<>();
        for (int i = 1; i < couples.length; i += 2){
            list.add("\"" + couples[i - 1] + "\" " + couples[i]);
        }
        System.out.println(list);

        //13. Необходимо реализовать следующий метод:
        //На вход получаем список названий книг.
        //Распределяем книги по полкам так, чтобы на каждой полке было примерно одинаковое количество книг.
        //Все книги должны быть отсортированы по алфавиту с первой до последней полки.
        //Количество полок константное — 5 штук.
        //Вернуть книги, распределенные по полкам.
        System.out.println(booksToShelves(List.of("Book 1", "Book 2", "Book 3", "Book 4", "Book 5", "Book 6",
                "Book 7", "Book 8", "Book 9", "Book 10", "Book 11", "Book 12")));

        //14. Дан класс User, который содержит поля с именем и возрастом. Необходимо реализовать следующий метод:
        //На входе коллекция — пользователей.
        //Необходимо удалить все дубли (одинаковое имя и возраст).
        //Отсортировать по возрасту и имени.
        //Вернуть самого старого пользователя.
        List<User> users = List.of(new User("Vasya", 20),
                new User("Misha", 20),
                new User("Petya", 30),
                new User("Danya", 40),
                new User("Sonya", 20),
                new User("Vasya", 20));
        System.out.println(getOldestUser(users));
    }

    /**
     * Убрать дубли, отсортировать, вернуть старейшего.
     * @param users
     * @return
     */
    private static User getOldestUser(List<User> users){
        users = users.stream().distinct().sorted(Comparator.comparing(User::getAge).thenComparing(User::getName)).toList();
        System.out.println(users);
        return users.get(users.size() - 1);
    }

    /**
     * Раскидать книги по полкам
     * @param books
     * @return
     */
    private static Map<Integer, List<String>> booksToShelves(List<String> books){
        int quantityOnShelf = books.size() / 5;
        if(quantityOnShelf < 1){
            quantityOnShelf = 1;
        }
        int remainder = books.size() < 5 ? 0 : books.size() % 5;
        int counter = 0;
        books = books.stream().sorted().toList();
        Map<Integer, List<String>> shelves= new LinkedHashMap<>();
        int quantityOfShelf = 5;
        if (books.size() < quantityOfShelf){
            quantityOfShelf = books.size();
        }
            for (int i = 0; i < quantityOfShelf; i++) {
                int extensionBook = 0;
                if(i < remainder){
                    extensionBook = 1;
                }
                shelves.put(i, books.subList(counter, counter + quantityOnShelf + extensionBook));
                counter = counter + quantityOnShelf + extensionBook;
            }
        return shelves;
    }
}