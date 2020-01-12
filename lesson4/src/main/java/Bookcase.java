public class Bookcase {

    private int shelvesCount;
    private int shelveCapacity;
    private MyLinkedList<MyLinkedList<String>> bookcase = new MyLinkedList<>();

    Bookcase (int shelvesCount, int shelveCapacity){
        this.shelvesCount = shelvesCount;
        this.shelveCapacity = shelveCapacity;
        for (int i = 0; i < shelvesCount; i++) {
            bookcase.add(new MyLinkedList<>());
        }
    }

    /*
    *  Разработайте структуру данных книжный шкаф
    *  в шкафе есть shelvesCount полок, каждая из которых
    *  может вмещать не более shelveCapacity книг
    *  Механика добавления книги в шкаф:
    *  выбираем номер полки, на полку можно положить книгу либо справа либо слева
    *  от имеющихся там книг
    *  Механика извлечения книги:
    *  можно вытащить любую книгу с любой полки, достаточно передать
    *  в метод номер полки и номер книги
    *  Нумерация полок с 1, нумерация книг с 1
    * */

    //side - либо 'L' либо 'R'
    public void putBook(int shelveNumber, char side, String bookName) {
        // TODO: 21/11/2019
        if (shelveNumber - 1 > shelvesCount) {
            System.out.println("Вы ввели неверный номер полки");
        } else if (side == 'R') {
            if ( bookcase.get(shelveNumber - 1).size() <= shelveCapacity) {
                bookcase.get(shelveNumber - 1).add(bookName);
//                System.out.println("book added: " + bookName + " on shelf " + shelveNumber);
            } else {
                System.out.println("На данной полке закончилось место");
            }
        } else if (side == 'L'){
//?????????????????
//некорректно работает метод добавления книги слева
//при попытке добавить книгу слева возникает ошибка добавляется только первая книга
//дальше добавление не идет. почему - так и не смог понять. Подскажите пожалуйста
            if ( bookcase.get(shelveNumber - 1).size() <= shelveCapacity) {
                bookcase.get(shelveNumber - 1).add(0, bookName);
                System.out.println("book added: " + bookName + " on shelf " + shelveNumber);
            } else {
                System.out.println("На данной полке закончилось место");
            }
        } else {
            System.out.println("Вы ввели неверную сторону полки");
        }
    }

    //Взятая книга удаляется из шкафа!
    public String takeBook(int shelveNumber, int bookNumber) {
        // TODO: 21/11/2019
        String book = null;
        if (shelveNumber - 1 > shelvesCount) {
            System.out.println("Вы ввели неверный номер полки");
        } else if (bookNumber - 1 > shelveCapacity) {
            System.out.println("Вы ввели неверный номер книги");
        } else {
            book = (bookcase.get(shelveNumber - 1)).get(bookNumber - 1);
            bookcase.get(shelveNumber - 1).remove(bookNumber - 1);
        }
        return book;
    }

    public void showBookcase() {
        //?????????????????
        //к сожалению так и не смог допилить итератор
        //соответственно показывает содержимое шкафа он не совсем адекватно
        //но как бы то ни было, метод показать содержимое шкафа я реализовал
        //и он работает отображая его содержимое
        int cnt = 1;
//        for (MyLinkedList<String> list : bookcase) {
        for (int i = 0; i < shelvesCount; i++) {
            System.out.print("Полка № " + cnt + ": ");
            cnt++;
//            for (String book : list) {
            for (int j = 0; j < bookcase.get(i).size(); j++) {
                System.out.print(bookcase.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }
}