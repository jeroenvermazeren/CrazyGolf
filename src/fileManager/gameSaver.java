package fileManager;

import Testing.Main;
import entities.Entity;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import static Testing.Main.terrainChoice;

/**
 * Created by Jeroen on 16-3-2016.
 */
public class gameSaver {

    public static void saveEntities(String courseName) throws FileNotFoundException  {
       /* public Entity(TexturedModel model, Vector3f position, float rotX,
        float rotY, float rotZ, float scale, boolean isObstacle, Vector3f collisionSize) {*/
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
//        courseName = dateFormat.format(date) + "-"+courseName;
        courseName = "crs/" + courseName + ".txt";
        File inputFile = new File(courseName);

        PrintWriter out = new PrintWriter(courseName);
        out.println(Main.terrainChoice.getID().substring(0,1));
        for (int i = 0; i < Main.entities.size(); i++) {
            Entity t = Main.entities.get(i);
            String k = " ";

           /* String s = t.getModel().getIndex() + k + t.getPosition().x + k + t.getPosition().y + k + t.getPosition().z + k + t.getRotX() + k + t.getRotY() + k + t.getRotZ() +
                    k + t.getScale() + k + t.isEntityObstacle() + k + +t.getCollisionZone().x + k + t.getCollisionZone().y + k + t.getCollisionZone().z + k + Main.terrainChoice.getID().substring(0,1);
*/
            String s = Main.entities.get(i).toString();
            out.println(s);
            out.flush();
        }
        out.println("HEIGHTS");
        for(int i = 0; i< terrainChoice.getHeights().length; i++){
            for(int j = 0; j< terrainChoice.getHeights()[0].length; j++){
                out.print(terrainChoice.getHeights()[i][j] + " ");
                out.flush();
            }
            out.println("");
            out.flush();
        }
//        System.out.println("SAVING FINISHED");
        out.close();
    }

}
