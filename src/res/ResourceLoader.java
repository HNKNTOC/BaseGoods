package res;

import java.awt.*;

/**
 * Created by HNKNTOC on 30.08.2015.
 */
public class ResourceLoader {
    static ResourceLoader rl = new ResourceLoader();

    public static Image getImage(String fileName){
        return Toolkit.getDefaultToolkit().getImage(rl.getClass().getResource(fileName));
    }
}
