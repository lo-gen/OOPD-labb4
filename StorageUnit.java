import java.util.ArrayList;

public class StorageUnit<storageType>{
    private ArrayList<storageType> storage;
    private int totalSpace;

    public StorageUnit(int totalSpace){
        storage = new ArrayList<storageType>();
        this.totalSpace = totalSpace;
    }

    protected int getSpaceUsed(){
        return storage.size();
    }

    protected int getSpaceLeft(){
        return totalSpace - getSpaceUsed();
    }

    protected void addItem(storageType item){
        if (getSpaceLeft() > 0) {
            for (storageType i : storage) {
                if (i == item)
                    return;
            }
            storage.add(item);
        }
    }

    protected storageType removeFirstItem(){
        return storage.removeFirst();
    }

    protected storageType removeLastItem(){
        return storage.removeLast();
    }

    protected void removeSpecificItem(storageType item){
        if (storage.contains(item)) {
            storage.remove(item);
        }
    }

    protected ArrayList<storageType> getItems(){
        return storage;
    }
}
