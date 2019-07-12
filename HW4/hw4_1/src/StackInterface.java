public interface StackInterface<E> {

   
    E push(E item);
    E pop();
    boolean isEmpty();

    /**
     *
     * @return
     */
    int size();
}
