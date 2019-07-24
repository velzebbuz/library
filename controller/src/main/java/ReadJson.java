import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.jetbrains.annotations.NotNull;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URL;
import java.util.ArrayList;

final class ReadJson {

    @NotNull
    private File getFileFromResources(@NotNull String fileName)  {

        ClassLoader classLoader = getClass().getClassLoader();

        URL resource = classLoader.getResource(fileName);
        if (resource == null) {
            throw new IllegalArgumentException("file is not found!");
        } else {
            return new File(resource.getFile());
        }

    }
    @NotNull
    ArrayList<Book> getBooks(@NotNull String fileName) throws IOException {


        File file = this.getFileFromResources(fileName);
        try (FileReader reader = new FileReader(file);
             BufferedReader br = new BufferedReader(reader)) {

            String line;
            StringBuilder buffer = new StringBuilder();
            while ((line = br.readLine()) != null) {
                buffer.append(line);
            }
            GsonBuilder builder = new GsonBuilder();
            Gson gson = builder.create();
            Type collectionType = new TypeToken<ArrayList<Book>>(){}.getType();
            return gson.fromJson(buffer.toString(), collectionType);
        }
    }
}

