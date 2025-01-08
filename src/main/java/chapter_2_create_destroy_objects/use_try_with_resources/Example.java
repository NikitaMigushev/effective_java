package chapter_2_create_destroy_objects.use_try_with_resources;

import java.io.*;

public class Example {

    private static final int BUFFER_SIZE = 8192;

    static String firstLineOfFile(String path) throws IOException {
        try (BufferedReader br = new BufferedReader(
                new FileReader(path)
        )) {
            return br.readLine();
        }
    }

    static void copy(String src, String dist) throws IOException {
        try (InputStream in = new FileInputStream(src);
            OutputStream out = new FileOutputStream(dist)
        ) {
            byte[] buf = new byte[BUFFER_SIZE];
            int n;
            while ((n = in.read(buf)) >= 0) {
                out.write(buf, 0, n);
            }
        }
    }
}
