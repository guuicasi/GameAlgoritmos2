package com.mycompany.game;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Historic {
    public static Path file;
    public static Path directory;

    public static void InsertLine(String line) throws IOException {
        Path directory = Paths.get("./historic");
		Path file = directory.resolve("historic.txt");

        Files.write(file,
					(line + "\r\n").getBytes(StandardCharsets.ISO_8859_1),
					StandardOpenOption.APPEND);
    }
}
