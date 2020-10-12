
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class Main {
    public static void main(String[] args) {

//        Path path = Paths.get(args[0]);



    }



    public void visitFiles(Path path) {
        if (!Files.isDirectory(path) && !Files.exists(path)){
            System.out.println("Wrong directory name!");
        } else {
            try {
                Files.walkFileTree(path, new SimpleFileVisitor<>(){
                    @Override
                    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                        System.out.println(dir.toString());
                        return FileVisitResult.CONTINUE;
                    }
                    @Override
                    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {

                        return FileVisitResult.CONTINUE;
                    }
                });
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}


