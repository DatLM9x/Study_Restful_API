package gateway.wrb.util;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileUtils {

    public List<String> getFilesDirectory(String directoryPath) {
        List<String> result = new ArrayList<>();
        try (Stream<Path> walk = Files.walk(Paths.get(directoryPath))) {
            result = walk.filter(Files::isRegularFile)
                    .map(x -> x.toString()).collect(Collectors.toList());
            result.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public void moveFile(String inputFile, String outputFile, String fileName) {
        InputStream inStream = null;
        OutputStream outStream = null;
        System.out.println("IN PUT PATH: "+inputFile);
        System.out.println("OUT PUT PATH :"+outputFile);
        System.out.println("FILE NAME :"+fileName);
        try {
            File afile = new File(inputFile);
            File bfile = new File(outputFile);
            if (!bfile.exists() || !bfile.isDirectory()) {
                System.out.println("Backup folder not exist");
                Path path = Paths.get(outputFile);
                Files.createDirectories(path);
            }

            File newFile = new File(outputFile +"\\"+ fileName + ".bak");

            inStream = new FileInputStream(afile);
            outStream = new FileOutputStream(newFile);
            byte[] buffer = new byte[1024];
            int length;
            //copy the file content in bytes
            while ((length = inStream.read(buffer)) > 0) {
                outStream.write(buffer, 0, length);

            }
            inStream.close();
            outStream.close();
            //delete the original file
            afile.delete();
            System.out.println("File is copied successful!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void createFile(String dir, List<String> content) {
        Charset utf8 = StandardCharsets.UTF_8;
        try (Writer writer = new BufferedWriter(
                new OutputStreamWriter(new FileOutputStream(dir), utf8)
        )) {
            writer.write(content + "\n");

            for (String s : content) {
                writer.write(s + "\n");
            }

        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        }
    }

}
