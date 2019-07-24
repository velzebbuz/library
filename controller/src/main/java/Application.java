import com.google.gson.Gson;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public final class Application {
    public static void main(@NotNull String[] args) throws IOException {
        Library lib1 = LibraryFactory.createLibrary("VSU");
        Library lib2 = LibraryFactory.createLibrary("Nekitinskaya");
        ArrayList<Library> libs = new ArrayList<>();
        libs.add(lib1);
        libs.add(lib2);
        System.out.println("Input an author: ");
        Scanner in = new Scanner(System.in);
        String author = in.nextLine();
        Gson gson = new Gson();
        StringBuilder buffer = new StringBuilder();
        for (Library k:
            libs){
            for (Book i :
                    k.books) {
                if (author.equals(i.authorName)) {
                    buffer.append(gson.toJson(i));
                }
            }
        }
        System.out.println(buffer);
    }
}


