import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;


public class Main {
    public static void main(String[] args) throws IOException {
//    visitFiles(Paths.get(args[0]));

    }

    private static void visitFiles(Path path) {
        if (!Files.isDirectory(path) && !Files.exists(path)){
            System.out.println("Wrong directory name!");
        } else {
            try {
                Files.walkFileTree(path, new SimpleFileVisitor<>(){
                    @Override
                    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs){
                        System.out.println(dir.toString());
                        return FileVisitResult.CONTINUE;
                    }
                    @Override
                    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs){
                        try {
                            BufferedImage image = ImageIO.read(file.toFile());
                            // cutting part of image with cards and saving it
                            BufferedImage img1 = image.getSubimage(140,580, 350, 100);
                            File output = new File("2.png");
                            ImageIO.write(img1, "png", output);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                        return FileVisitResult.CONTINUE;
                    }
                });
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}


