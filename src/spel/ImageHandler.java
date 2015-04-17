package spel;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import javax.imageio.ImageIO;

public class ImageHandler {

    static HashMap<String, BufferedImage> map = new HashMap();

    static Image get(String filename) {
        BufferedImage img = map.get(filename);

        if (img == null) {
            try {
                img = ImageIO.read(ImageIO.class.getResourceAsStream("/images/" + filename));
                map.put(filename,img);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return img;
    }

}
