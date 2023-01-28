package Java2.lesson2;

public class MyArrayDataException extends RuntimeException{
    private final int i;
    private final int j;

    public MyArrayDataException(String message,int i,int j) {
        super(message);
        this.i =i;
        this.j =j;
    }

    public int getI() {
        return i;
    }

    public int getJ() {
        return j;
    }

}
