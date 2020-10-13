import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;


public class Main {
    public static void main(String[] args) {
//    visitFiles(Paths.get(args[0]));


//        BufferedImage image = new BufferedImage(100, 100, BufferedImage.TYPE_INT_RGB);
//        image.setRGB(10, 10, Color.YELLOW.getRGB());
//        System.out.println(image.getRGB(10, 10));
//
//        JFrame frame = new JFrame();
//        frame.setSize(100, 100);
//        frame.setUndecorated(true);
//        frame.setLocationRelativeTo(null);
//        frame.setVisible(true);
//        JLabel label = new JLabel(new ImageIcon(image));
//        label.setBounds(0, 0, 100, 100);
//        frame.add(label);
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
                            int height = image.getHeight();
                            int width = image.getWidth();
                            BufferedImage img1 = image.getSubimage();

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


