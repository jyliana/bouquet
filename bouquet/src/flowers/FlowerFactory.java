package flowers;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Inna on 7/8/17.
 */
public class FlowerFactory {
   /* private Map<Class, FlowerSetting> flowerSettings = new HashMap<>();

    public FlowerFactory() {
        this.flowerSettings.put(Lotus.class, new FlowerSetting(new ArrayList<>(Arrays.asList(Color.BLUE, Color.WHITE, Color.ROSE))));
    }

    public void createFlower(Class objectType, Color color) throws IllegalAccessException, InvocationTargetException, InstantiationException {
        boolean settingPresent = flowerSettings.containsKey(objectType);
        if (settingPresent) {
            boolean colorAllowed = flowerSettings.get(objectType).allowedColors.contains(color);
            if (colorAllowed) {
                //Class.forName(objectType.getName()).newInstance();
                Constructor<?>[] vtros = objectType.getConstructors();
                object obj = vtros[0].newInstance(color)   ;  // Constructor.newInstance
            }
        }
    }*/
}
