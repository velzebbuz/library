import org.jetbrains.annotations.NotNull;

import java.io.IOException;

final class LibraryFactory {

    @NotNull
    static Library createLibrary(@NotNull String nameLibrary) throws IOException {
        ReadJson reader = new ReadJson();
        Library lib = new Library();
        lib.name = nameLibrary;
        lib.books = reader.getBooks(nameLibrary);
        return lib;
    }
}
