package by.epam.javatraining.rassolko.maintask02.collections;


public class Storage<T>
{
    private int size;
    private Object[] storage;
    
    private static int DEFAULT_INITIAL_SIZE = 20;
    private static int DEFAULT_INCREASE_VALUE = 10;
    
    public Storage()
    {
        storage = new Object[DEFAULT_INITIAL_SIZE];
    }
    
    public Storage(int size)
    {
        storage = new Object[size];
    }
    
    public Storage(Storage st)
    {
        this.size = st.size;
        this.storage = new Object[st.storage.length];
        System.arraycopy(st.storage, 0, this.storage, 0, st.storage.length);
    }
    
    public Storage(T[] elements)
    {
        size = elements.length;
        storage = new Object[elements.length];
        System.arraycopy(elements, 0, this.storage, 0, elements.length);
    }
    
    public Storage(java.util.Collection elements)
    {
        size = elements.size();
        storage = elements.toArray();
    }
    
    public void add(T element)
    {
        increaseSizeIfNecessary();
        storage[size++] = element;
    }
    
    private void addUnsafely(T element)
    {
        storage[size++] = element;
    }
    
    public void add(T[] elements)
    {
        increaseSizeIfNecessary(elements.length);
        for(T element : elements)
        {
            addUnsafely(element);
        }
    }
    
    public void add(java.util.Collection<T> elements)
    {
        increaseSizeIfNecessary(elements.size());
        for(T element : elements)
        {
            addUnsafely(element);
        }
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
    
    public boolean delete(T object)
    {
        for(int i = 0; i < size; i++)
        {
            if(object == storage[i])
            {
                for(int j = i; j < size - 1; j++)
                {
                    storage[j] = storage[j + 1];
                }
                size--;
                return true;
            }
        }
        
        return false;
    }
    
    public boolean delete(int index)
    {
        if(index < size)
        {
            for(int i = index; i < size - 1; i++)
            {
                storage[i] = storage[i + 1];
            }
            size--;
            return true;
        }
        
        return false;
    }
    
    private void increaseSizeIfNecessary()
    {
        if(size == storage.length)
        {
            Object[] incresedStorage = 
                    new Object[storage.length + DEFAULT_INCREASE_VALUE];
            
            System.arraycopy(storage, 0, incresedStorage, 0, storage.length);
            
            storage = incresedStorage;
            
        }
            
    }
    
    private void increaseSizeIfNecessary(int newElementsQuantity)
    {
        if(size + newElementsQuantity >= storage.length)
        {
            Object[] incresedStorage = 
                    new Object[storage.length + newElementsQuantity];
            
            System.arraycopy(storage, 0, incresedStorage, 0, storage.length);
            
            storage = incresedStorage;
            
        }     
    }
    
}
