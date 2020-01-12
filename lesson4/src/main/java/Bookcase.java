public class Bookcase {
    /**
     *  Разработайте структуру данных книжный шкаф где есть shelvesCount полок
     *  каждая из которых может вмещать не более shelveCapacity книг.
     *  Механика добавления книги в шкаф: выбираем номер полки,
     *  на полку можно положить книгу либо справа либо слева от имеющихся там книг.
     *  Механика извлечения книги: можно вытащить любую книгу с любой полки,
     *  достаточно передать в метод номер полки и номер книги.
     */

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

    // TODO: 21/11/2019
    /**
     * Положить книгу, сторона шкафа - либо 'L' либо 'R'
     * Нумерация полок с 1, нумерация книг с 1
     */
    public void putBook(int shelveNumber, char side, String bookName) {
        --shelveNumber;
        while(bookcase.get(shelveNumber).size() >= shelveCapacity){
            shelveNumber++;
            if (shelveNumber > shelvesCount) {
                throw new ArrayIndexOutOfBoundsException();
            }
        }
        if(side == 'L') bookcase.get(shelveNumber).add(0, bookName);
        else bookcase.get(shelveNumber).add(bookName);
    }

    // TODO: 21/11/2019
    /**
     * Взять книгу, взятая книга удаляется из шкафа!
     * Нумерация полок с 1, нумерация книг с 1
     */
    public String takeBook(int shelveNumber, int bookNumber) {
        --shelveNumber;
        --bookNumber;
        if(shelveNumber > shelvesCount || bookNumber > shelveCapacity){
            throw new ArrayIndexOutOfBoundsException();
        }
        String book = bookcase.get(shelveNumber).get(bookNumber);
        bookcase.get(shelveNumber).remove(bookNumber);
        return book;
    }

    /**
     * Показать содержимое шкафа для отлпадки класса
     */
    public void showBookcase() {
        int cnt = 1;
        for (MyLinkedList<String> list : bookcase) {
            System.out.print("Полка № " + cnt + ": ");
            cnt++;
            for (String book : list) {
                System.out.print(book + " ");
            }
            System.out.println();
        }
    }
}