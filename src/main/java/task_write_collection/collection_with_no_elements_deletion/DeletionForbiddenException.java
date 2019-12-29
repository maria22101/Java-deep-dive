package task_write_collection.collection_with_no_elements_deletion;

public class DeletionForbiddenException extends Exception {
    @Override
    public String toString() {
        return "Elements deletion forbidden from this data structure";
    }
}
