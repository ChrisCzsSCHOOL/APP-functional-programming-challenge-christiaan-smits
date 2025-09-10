public class Pair<T, U>{

    T i;
    U s;

    public Pair(T i, U s) {
        this.i = i;
        this.s = s;
    }

    public T getI() {
        return i;
    }

    public void setI(T i) {
        this.i = i;
    }

    public U getS() {
        return s;
    }

    public void setS(U s) {
        this.s = s;
    }
}
