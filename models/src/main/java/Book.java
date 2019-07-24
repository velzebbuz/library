import lombok.NonNull;
import org.jetbrains.annotations.NotNull;

public final class Book extends Author{
    @NonNull
    String title;
    @NonNull
    int countPage;

}
