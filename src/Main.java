import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        /**
         * Дан List ‹String› names. Удалите первую букву из каждого имени и верните отсортированный список.
         */
        List<String> list = List.of("Misha", "Petya", "Sasha");
        list.stream().map(e -> e.substring(1)).sorted().forEach(e -> System.out.println(e));
        List sortedList = list.stream().map(e -> e.substring(1)).sorted().collect(Collectors.toList());
        System.out.println(sortedList);

        System.out.println("---------------------------");

        /**
         * Напишите программу, которая переворачивает массив.
         */
        String[] array = new String[5];
        array[0] = "Moscow";
        array[1] = "NewYork";
        array[2] = "London";
        array[3] = "Paris";
        array[4] = "Delhi";

        String[] newArray = new String[5];
        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[array.length - 1 - i];
        }
        array = newArray;
        Arrays.stream(array).forEach(System.out::println);

        System.out.println("---------------------------");

        /**
         * Напишите программу в простом текстовом редакторе, которая проверяет, является ли строка палиндромом.
         */
        String palindrom = "20000002";
        char[] strToArray = palindrom.toCharArray();
        int half = strToArray.length / 2 + strToArray.length % 2;
        char[] firstArray = new char[half];
        char[] seckondArray = new char[half];
        for (int i = 0; i < half; i++) {
            firstArray[i] = strToArray[i];
            seckondArray[i] = strToArray[strToArray.length - 1 - i];
        }
        System.out.println("Palindrom: " + Arrays.equals(firstArray, seckondArray));

        System.out.println("---------------------------");

        /**
         * Напишите программу в текстовом редакторе, которая разделяет любую строку на две части.
         */
        String string = "Метрополитен";
        int half1 = string.length() / 2;
        String substring1 = string.substring(0, half1);
        String substring2 = string.substring(half1);
        System.out.println(substring1);
        System.out.println(substring2);

        System.out.println("---------------------------");

        /**
         * Напишите пример Enum.
         */
        enum SomeEnum {
            A,B,C,D;
        }
        System.out.println(SomeEnum.A);

        System.out.println("---------------------------");

        /**
         * Напишите пример перехвата и обработки исключения в блоке try-catch метода.
         */
        try{
            throw new RuntimeException("Отловили ошибку");
        }
        catch(RuntimeException e){
            System.out.println(e.getMessage());
        }
        finally{
            System.out.println("Это напечатается по-любому");
        }

        System.out.println("---------------------------");

        //main1();

        /**
         * Напишите пример перехвата и обработки исключения с использованием собственных исключений.
         */
        try{
            throw new SelfException("Отловили собственное исключение");
        }
        catch(SelfException e){
            System.out.println(e.getMessage());
        }

        System.out.println("---------------------------");

        /**
         * Напишите пример обработки нескольких исключений в одном блоке catch.
         */
        try{
            if(false){
                throw new RuntimeException("Отловили RuntimeException");
            } else{
                throw new FileNotFoundException("Отловили FileNotFoundException");
            }

        }
        catch(RuntimeException | FileNotFoundException e){
            System.out.println(e.getMessage());
        }

    }

    /**
     * Напишите пример перехвата и обработки исключения в секции throws-метода и передачи вызывающему методу.
     */

    public static void main1() throws FileNotFoundException, IOException {
        try{
            testException(-5);
            testException(-10);
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }finally{
            System.out.println("Необязательный блок");
        }
        testException(15);
    }
    public static void testException(int i) throws FileNotFoundException, IOException{
        if(i < 0){
            FileNotFoundException myException = new FileNotFoundException("число меньше 0: " + i);
            throw myException;
        }else if(i > 10){
            throw new IOException("Число должно быть в пределах от 0 до 10");
        }
    }

    /**
     * Напишите методы Equals and HashCode для класса Student, который состоит из полей String name и int age.
     */
    public class Student {
        private String name;
        int age;

        @Override
        public int hashCode(){
            return Objects.hash(name, age);
        }

        @Override
        public boolean equals(Object o){
            if(this == o){
                return true;
            }
            if(o == null || getClass() != o.getClass()){
                return false;
            }
            Student student = (Student) o;
            return age == student.age && Objects.equals(name, student.name);
        }
    }

    /**
     * Собственное исключение
     */
    public static class SelfException extends Exception {
        public SelfException() {
        }
        public SelfException(String message) {
            super(message);
        }
        public SelfException(String message, Throwable cause) {
            super(message, cause);
        }
        public SelfException(Throwable cause) {
            super(cause);
        }
        public SelfException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
            super(message, cause, enableSuppression, writableStackTrace);
        }
    }
}