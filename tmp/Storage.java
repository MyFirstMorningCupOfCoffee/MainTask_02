package by.epam.javatraining.rassolko.collections;


public class Storage<T>
{
    private int size;
    private int maxSize;
    private Object[] storage;
    
    public Storage()
    {
        maxSize = 10;
    }
    
    public Storage(int size)
    {
        maxSize = size;
    }
    
    public Storage(Storage st)
    {
        this.size = st.size;
        this.maxSize = st.maxSize;
        this.storage = new Object[st.storage.length];
        System.arraycopy(st.storage, 0, this.storage, 0, st.storage.length);
    }
    
    public Storage(T[] elements)
    {
        maxSize = elements.length;
        size = elements.length;
        storage = new Object[elements.length];
        System.arraycopy(elements, 0, this.storage, 0, elements.length);
    }
    
    public Storage(java.util.Collection elements)
    {
        maxSize = elements.size();
        size = elements.size();
        storage = elements.toArray();
    }
    
    public boolean add(T element)
    {
        if(size < maxSize)
        {
            storage[size++] = element;
            return true;
        }
        
        return false;
    }
    
    public T get(int position)
    {
        if(position < size)
        {
            return (T) storage[position];
        }
        else
        {
            throw new IndexOutOfBoundsException();
        }
    }
    
    public boolean set(T element, int position)
    {
        if(position < size)
        {
            storage[position] = element;
            return true;
        }
        
        return false;
    }
    
    public int size()
    {
        return size;
    }
    
    private void increaseSizeIfNecessary()
    {
        if(size == maxSize)
            
    }
}
